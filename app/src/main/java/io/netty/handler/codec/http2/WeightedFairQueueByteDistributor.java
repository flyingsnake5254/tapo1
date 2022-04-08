package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.util.collection.IntCollections;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.EmptyPriorityQueue;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import io.netty.util.internal.SystemPropertyUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class WeightedFairQueueByteDistributor implements StreamByteDistributor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_MAX_STATE_ONLY_SIZE = 5;
    static final int INITIAL_CHILDREN_MAP_SIZE = Math.max(1, SystemPropertyUtil.getInt("io.netty.http2.childrenMapSize", 2));
    private int allocationQuantum;
    private final Http2Connection connection;
    private final State connectionState;
    private final int maxStateOnlySize;
    private final Http2Connection.a stateKey;
    private final IntObjectMap<State> stateOnlyMap;
    private final PriorityQueue<State> stateOnlyRemovalQueue;

    /* renamed from: io.netty.handler.codec.http2.WeightedFairQueueByteDistributor$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.RESERVED_REMOTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ParentChangedEvent {
        final State oldParent;
        final State state;

        ParentChangedEvent(State state, State state2) {
            this.state = state;
            this.oldParent = state2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class State implements PriorityQueueNode {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte STATE_IS_ACTIVE = 1;
        private static final byte STATE_IS_DISTRIBUTING = 2;
        private static final byte STATE_STREAM_ACTIVATED = 4;
        int activeCountForTree;
        IntObjectMap<State> children;
        int dependencyTreeDepth;
        private byte flags;
        State parent;
        long pseudoTime;
        private final PriorityQueue<State> pseudoTimeQueue;
        private int pseudoTimeQueueIndex;
        long pseudoTimeToWrite;
        private int stateOnlyQueueIndex;
        Http2Stream stream;
        final int streamId;
        int streamableBytes;
        long totalQueuedWeights;
        short weight;

        State(WeightedFairQueueByteDistributor weightedFairQueueByteDistributor, int i) {
            this(i, null, 0);
        }

        private void initChildren() {
            this.children = new IntObjectHashMap(WeightedFairQueueByteDistributor.INITIAL_CHILDREN_MAP_SIZE);
        }

        private void initChildrenIfEmpty() {
            if (this.children == IntCollections.emptyMap()) {
                initChildren();
            }
        }

        private IntObjectMap<State> removeAllChildrenExcept(State state) {
            State remove = this.children.remove(state.streamId);
            IntObjectMap<State> intObjectMap = this.children;
            initChildren();
            if (remove != null) {
                this.children.put(remove.streamId, (int) remove);
            }
            return intObjectMap;
        }

        private void setActive() {
            this.flags = (byte) (this.flags | 1);
        }

        private void setParent(State state) {
            State state2;
            if (!(this.activeCountForTree == 0 || (state2 = this.parent) == null)) {
                state2.removePseudoTimeQueue(this);
                this.parent.activeCountChangeForTree(-this.activeCountForTree);
            }
            this.parent = state;
            this.dependencyTreeDepth = state == null ? Integer.MAX_VALUE : state.dependencyTreeDepth + 1;
        }

        private void unsetActive() {
            this.flags = (byte) (this.flags & (-2));
        }

        void activeCountChangeForTree(int i) {
            int i2 = this.activeCountForTree + i;
            this.activeCountForTree = i2;
            State state = this.parent;
            if (state != null) {
                if (i2 == 0) {
                    state.removePseudoTimeQueue(this);
                } else if (i2 == i && !isDistributing()) {
                    this.parent.offerAndInitializePseudoTime(this);
                }
                this.parent.activeCountChangeForTree(i);
            }
        }

        void close() {
            updateStreamableBytes(0, false);
            this.stream = null;
        }

        boolean isActive() {
            return (this.flags & 1) != 0;
        }

        boolean isDescendantOf(State state) {
            for (State state2 = this.parent; state2 != null; state2 = state2.parent) {
                if (state2 == state) {
                    return true;
                }
            }
            return false;
        }

        boolean isDistributing() {
            return (this.flags & 2) != 0;
        }

        void offerAndInitializePseudoTime(State state) {
            state.pseudoTimeToWrite = this.pseudoTime;
            offerPseudoTimeQueue(state);
        }

        void offerPseudoTimeQueue(State state) {
            this.pseudoTimeQueue.offer(state);
            this.totalQueuedWeights += state.weight;
        }

        State peekPseudoTimeQueue() {
            return this.pseudoTimeQueue.peek();
        }

        State pollPseudoTimeQueue() {
            State poll = this.pseudoTimeQueue.poll();
            this.totalQueuedWeights -= poll.weight;
            return poll;
        }

        @Override // io.netty.util.internal.PriorityQueueNode
        public int priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue) {
            return defaultPriorityQueue == WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue ? this.stateOnlyQueueIndex : this.pseudoTimeQueueIndex;
        }

        void removeChild(State state) {
            if (this.children.remove(state.streamId) != null) {
                ArrayList arrayList = new ArrayList(state.children.size() + 1);
                arrayList.add(new ParentChangedEvent(state, state.parent));
                state.setParent(null);
                Iterator<IntObjectMap.PrimitiveEntry<State>> it = state.children.entries().iterator();
                while (it.hasNext()) {
                    takeChild(it, it.next().value(), false, arrayList);
                }
                WeightedFairQueueByteDistributor.this.notifyParentChanged(arrayList);
            }
        }

        void removePseudoTimeQueue(State state) {
            if (this.pseudoTimeQueue.removeTyped(state)) {
                this.totalQueuedWeights -= state.weight;
            }
        }

        void setDistributing() {
            this.flags = (byte) (this.flags | 2);
        }

        void setStreamReservedOrActivated() {
            this.flags = (byte) (this.flags | 4);
        }

        void takeChild(State state, boolean z, List<ParentChangedEvent> list) {
            takeChild(null, state, z, list);
        }

        public String toString() {
            int i = this.activeCountForTree;
            if (i <= 0) {
                i = 1;
            }
            StringBuilder sb = new StringBuilder(i * 256);
            toString(sb);
            return sb.toString();
        }

        void unsetDistributing() {
            this.flags = (byte) (this.flags & (-3));
        }

        void updatePseudoTime(State state, int i, long j) {
            this.pseudoTimeToWrite = Math.min(this.pseudoTimeToWrite, state.pseudoTime) + ((i * j) / this.weight);
        }

        void updateStreamableBytes(int i, boolean z) {
            if (isActive() != z) {
                if (z) {
                    activeCountChangeForTree(1);
                    setActive();
                } else {
                    activeCountChangeForTree(-1);
                    unsetActive();
                }
            }
            this.streamableBytes = i;
        }

        boolean wasStreamReservedOrActivated() {
            return (this.flags & 4) != 0;
        }

        void write(int i, StreamByteDistributor.Writer writer) throws Http2Exception {
            try {
                writer.write(this.stream, i);
            } catch (Throwable th) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th, "byte distribution write error", new Object[0]);
            }
        }

        State(WeightedFairQueueByteDistributor weightedFairQueueByteDistributor, Http2Stream http2Stream) {
            this(weightedFairQueueByteDistributor, http2Stream, 0);
        }

        @Override // io.netty.util.internal.PriorityQueueNode
        public void priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue, int i) {
            if (defaultPriorityQueue == WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue) {
                this.stateOnlyQueueIndex = i;
            } else {
                this.pseudoTimeQueueIndex = i;
            }
        }

        void takeChild(Iterator<IntObjectMap.PrimitiveEntry<State>> it, State state, boolean z, List<ParentChangedEvent> list) {
            State state2 = state.parent;
            if (state2 != this) {
                list.add(new ParentChangedEvent(state, state2));
                state.setParent(this);
                if (it != null) {
                    it.remove();
                } else if (state2 != null) {
                    state2.children.remove(state.streamId);
                }
                initChildrenIfEmpty();
                this.children.put(state.streamId, (int) state);
            }
            if (z && !this.children.isEmpty()) {
                Iterator<IntObjectMap.PrimitiveEntry<State>> it2 = removeAllChildrenExcept(state).entries().iterator();
                while (it2.hasNext()) {
                    state.takeChild(it2, it2.next().value(), false, list);
                }
            }
        }

        State(WeightedFairQueueByteDistributor weightedFairQueueByteDistributor, Http2Stream http2Stream, int i) {
            this(http2Stream.id(), http2Stream, i);
        }

        State(int i, Http2Stream http2Stream, int i2) {
            this.children = IntCollections.emptyMap();
            this.pseudoTimeQueueIndex = -1;
            this.stateOnlyQueueIndex = -1;
            this.weight = (short) 16;
            this.stream = http2Stream;
            this.streamId = i;
            this.pseudoTimeQueue = new DefaultPriorityQueue(StatePseudoTimeComparator.INSTANCE, i2);
        }

        private void toString(StringBuilder sb) {
            sb.append("{streamId ");
            sb.append(this.streamId);
            sb.append(" streamableBytes ");
            sb.append(this.streamableBytes);
            sb.append(" activeCountForTree ");
            sb.append(this.activeCountForTree);
            sb.append(" pseudoTimeQueueIndex ");
            sb.append(this.pseudoTimeQueueIndex);
            sb.append(" pseudoTimeToWrite ");
            sb.append(this.pseudoTimeToWrite);
            sb.append(" pseudoTime ");
            sb.append(this.pseudoTime);
            sb.append(" flags ");
            sb.append((int) this.flags);
            sb.append(" pseudoTimeQueue.size() ");
            sb.append(this.pseudoTimeQueue.size());
            sb.append(" stateOnlyQueueIndex ");
            sb.append(this.stateOnlyQueueIndex);
            sb.append(" parent.streamId ");
            State state = this.parent;
            sb.append(state == null ? -1 : state.streamId);
            sb.append("} [");
            if (!this.pseudoTimeQueue.isEmpty()) {
                for (State state2 : this.pseudoTimeQueue) {
                    state2.toString(sb);
                    sb.append(", ");
                }
                sb.setLength(sb.length() - 2);
            }
            sb.append(']');
        }
    }

    /* loaded from: classes3.dex */
    private static final class StateOnlyComparator implements Comparator<State>, Serializable {
        static final StateOnlyComparator INSTANCE = new StateOnlyComparator();
        private static final long serialVersionUID = -4806936913002105966L;

        private StateOnlyComparator() {
        }

        public int compare(State state, State state2) {
            boolean wasStreamReservedOrActivated = state.wasStreamReservedOrActivated();
            if (wasStreamReservedOrActivated != state2.wasStreamReservedOrActivated()) {
                return wasStreamReservedOrActivated ? -1 : 1;
            }
            int i = state2.dependencyTreeDepth - state.dependencyTreeDepth;
            return i != 0 ? i : state.streamId - state2.streamId;
        }
    }

    /* loaded from: classes3.dex */
    private static final class StatePseudoTimeComparator implements Comparator<State>, Serializable {
        static final StatePseudoTimeComparator INSTANCE = new StatePseudoTimeComparator();
        private static final long serialVersionUID = -1437548640227161828L;

        private StatePseudoTimeComparator() {
        }

        public int compare(State state, State state2) {
            return MathUtil.compare(state.pseudoTimeToWrite, state2.pseudoTimeToWrite);
        }
    }

    public WeightedFairQueueByteDistributor(Http2Connection http2Connection) {
        this(http2Connection, 5);
    }

    private int distributeToChildren(int i, StreamByteDistributor.Writer writer, State state) throws Http2Exception {
        long j = state.totalQueuedWeights;
        State pollPseudoTimeQueue = state.pollPseudoTimeQueue();
        State peekPseudoTimeQueue = state.peekPseudoTimeQueue();
        pollPseudoTimeQueue.setDistributing();
        if (peekPseudoTimeQueue != null) {
            try {
                i = Math.min(i, (int) Math.min((((peekPseudoTimeQueue.pseudoTimeToWrite - pollPseudoTimeQueue.pseudoTimeToWrite) * pollPseudoTimeQueue.weight) / j) + this.allocationQuantum, 2147483647L));
            } finally {
                pollPseudoTimeQueue.unsetDistributing();
                if (pollPseudoTimeQueue.activeCountForTree != 0) {
                    state.offerPseudoTimeQueue(pollPseudoTimeQueue);
                }
            }
        }
        int distribute = distribute(i, writer, pollPseudoTimeQueue);
        state.pseudoTime += distribute;
        pollPseudoTimeQueue.updatePseudoTime(state, distribute, j);
        return distribute;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public State state(Http2Stream http2Stream) {
        return (State) http2Stream.getProperty(this.stateKey);
    }

    public void allocationQuantum(int i) {
        ObjectUtil.checkPositive(i, "allocationQuantum");
        this.allocationQuantum = i;
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public boolean distribute(int i, StreamByteDistributor.Writer writer) throws Http2Exception {
        int i2;
        if (this.connectionState.activeCountForTree == 0) {
            return false;
        }
        while (true) {
            State state = this.connectionState;
            int i3 = state.activeCountForTree;
            i -= distributeToChildren(i, writer, state);
            i2 = this.connectionState.activeCountForTree;
            if (i2 == 0 || (i <= 0 && i3 == i2)) {
                break;
            }
        }
        return i2 != 0;
    }

    boolean isChild(int i, int i2, short s) {
        State state = state(i2);
        if (state.children.containsKey(i)) {
            State state2 = state(i);
            if (state2.parent == state && state2.weight == s) {
                return true;
            }
        }
        return false;
    }

    void notifyParentChanged(List<ParentChangedEvent> list) {
        for (int i = 0; i < list.size(); i++) {
            ParentChangedEvent parentChangedEvent = list.get(i);
            this.stateOnlyRemovalQueue.priorityChanged(parentChangedEvent.state);
            State state = parentChangedEvent.state;
            State state2 = state.parent;
            if (!(state2 == null || state.activeCountForTree == 0)) {
                state2.offerAndInitializePseudoTime(state);
                State state3 = parentChangedEvent.state;
                state3.parent.activeCountChangeForTree(state3.activeCountForTree);
            }
        }
    }

    int numChildren(int i) {
        State state = state(i);
        if (state == null) {
            return 0;
        }
        return state.children.size();
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public void updateDependencyTree(int i, int i2, short s, boolean z) {
        ArrayList arrayList;
        State state;
        State state2 = state(i);
        if (state2 == null) {
            if (this.maxStateOnlySize != 0) {
                state2 = new State(this, i);
                this.stateOnlyRemovalQueue.add(state2);
                this.stateOnlyMap.put(i, (int) state2);
            } else {
                return;
            }
        }
        State state3 = state(i2);
        int i3 = 0;
        if (state3 == null) {
            if (this.maxStateOnlySize != 0) {
                state3 = new State(this, i2);
                this.stateOnlyRemovalQueue.add(state3);
                this.stateOnlyMap.put(i2, (int) state3);
                ArrayList arrayList2 = new ArrayList(1);
                this.connectionState.takeChild(state3, false, arrayList2);
                notifyParentChanged(arrayList2);
            } else {
                return;
            }
        }
        if (!(state2.activeCountForTree == 0 || (state = state2.parent) == null)) {
            state.totalQueuedWeights += s - state2.weight;
        }
        state2.weight = s;
        if (state3 != state2.parent || (z && state3.children.size() != 1)) {
            if (state3.isDescendantOf(state2)) {
                arrayList = new ArrayList((z ? state3.children.size() : 0) + 2);
                state2.parent.takeChild(state3, false, arrayList);
            } else {
                if (z) {
                    i3 = state3.children.size();
                }
                arrayList = new ArrayList(i3 + 1);
            }
            state3.takeChild(state2, z, arrayList);
            notifyParentChanged(arrayList);
        }
        while (this.stateOnlyRemovalQueue.size() > this.maxStateOnlySize) {
            State poll = this.stateOnlyRemovalQueue.poll();
            poll.parent.removeChild(poll);
            this.stateOnlyMap.remove(poll.streamId);
        }
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public void updateStreamableBytes(StreamByteDistributor.StreamState streamState) {
        state(streamState.stream()).updateStreamableBytes(Http2CodecUtil.streamableBytes(streamState), streamState.hasFrame() && streamState.windowSize() >= 0);
    }

    public WeightedFairQueueByteDistributor(Http2Connection http2Connection, int i) {
        this.allocationQuantum = 1024;
        ObjectUtil.checkPositiveOrZero(i, "maxStateOnlySize");
        if (i == 0) {
            this.stateOnlyMap = IntCollections.emptyMap();
            this.stateOnlyRemovalQueue = EmptyPriorityQueue.instance();
        } else {
            this.stateOnlyMap = new IntObjectHashMap(i);
            this.stateOnlyRemovalQueue = new DefaultPriorityQueue(StateOnlyComparator.INSTANCE, i + 2);
        }
        this.maxStateOnlySize = i;
        this.connection = http2Connection;
        Http2Connection.a newKey = http2Connection.newKey();
        this.stateKey = newKey;
        Http2Stream connectionStream = http2Connection.connectionStream();
        State state = new State(this, connectionStream, 16);
        this.connectionState = state;
        connectionStream.setProperty(newKey, state);
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.WeightedFairQueueByteDistributor.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamActive(Http2Stream http2Stream) {
                WeightedFairQueueByteDistributor.this.state(http2Stream).setStreamReservedOrActivated();
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamAdded(Http2Stream http2Stream) {
                State state2 = (State) WeightedFairQueueByteDistributor.this.stateOnlyMap.remove(http2Stream.id());
                if (state2 == null) {
                    state2 = new State(WeightedFairQueueByteDistributor.this, http2Stream);
                    ArrayList arrayList = new ArrayList(1);
                    WeightedFairQueueByteDistributor.this.connectionState.takeChild(state2, false, arrayList);
                    WeightedFairQueueByteDistributor.this.notifyParentChanged(arrayList);
                } else {
                    WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.removeTyped(state2);
                    state2.stream = http2Stream;
                }
                int i2 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    state2.setStreamReservedOrActivated();
                }
                http2Stream.setProperty(WeightedFairQueueByteDistributor.this.stateKey, state2);
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                WeightedFairQueueByteDistributor.this.state(http2Stream).close();
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamRemoved(Http2Stream http2Stream) {
                State state2 = WeightedFairQueueByteDistributor.this.state(http2Stream);
                state2.stream = null;
                if (WeightedFairQueueByteDistributor.this.maxStateOnlySize == 0) {
                    state2.parent.removeChild(state2);
                    return;
                }
                if (WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.size() == WeightedFairQueueByteDistributor.this.maxStateOnlySize) {
                    State state3 = (State) WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.peek();
                    if (StateOnlyComparator.INSTANCE.compare(state3, state2) >= 0) {
                        state2.parent.removeChild(state2);
                        return;
                    }
                    WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.poll();
                    state3.parent.removeChild(state3);
                    WeightedFairQueueByteDistributor.this.stateOnlyMap.remove(state3.streamId);
                }
                WeightedFairQueueByteDistributor.this.stateOnlyRemovalQueue.add(state2);
                WeightedFairQueueByteDistributor.this.stateOnlyMap.put(state2.streamId, (int) state2);
            }
        });
    }

    private State state(int i) {
        Http2Stream stream = this.connection.stream(i);
        return stream != null ? state(stream) : this.stateOnlyMap.get(i);
    }

    private int distribute(int i, StreamByteDistributor.Writer writer, State state) throws Http2Exception {
        if (!state.isActive()) {
            return distributeToChildren(i, writer, state);
        }
        int min = Math.min(i, state.streamableBytes);
        state.write(min, writer);
        if (min == 0 && i != 0) {
            state.updateStreamableBytes(state.streamableBytes, false);
        }
        return min;
    }
}
