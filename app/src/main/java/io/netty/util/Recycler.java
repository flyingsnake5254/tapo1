package io.netty.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class Recycler<T> {
    private static final int DEFAULT_INITIAL_MAX_CAPACITY_PER_THREAD = 4096;
    private static final int DEFAULT_MAX_CAPACITY_PER_THREAD;
    private static final int DELAYED_QUEUE_RATIO;
    private static final FastThreadLocal<Map<Stack<?>, WeakOrderQueue>> DELAYED_RECYCLED;
    private static final AtomicInteger ID_GENERATOR;
    private static final int INITIAL_CAPACITY;
    private static final int LINK_CAPACITY;
    private static final int MAX_DELAYED_QUEUES_PER_THREAD;
    private static final int MAX_SHARED_CAPACITY_FACTOR;
    private static final a NOOP_HANDLE = new a() { // from class: io.netty.util.Recycler.1
        @Override // io.netty.util.internal.ObjectPool.Handle
        public void recycle(Object obj) {
        }
    };
    private static final int OWN_THREAD_ID;
    private static final int RATIO;
    private static final InternalLogger logger;
    private final int delayedQueueInterval;
    private final int interval;
    private final int maxCapacityPerThread;
    private final int maxDelayedQueuesPerThread;
    private final int maxSharedCapacityFactor;
    private final FastThreadLocal<Stack<T>> threadLocal;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class DefaultHandle<T> implements a<T> {
        boolean hasBeenRecycled;
        int lastRecycledId;
        int recycleId;
        Stack<?> stack;
        Object value;

        DefaultHandle(Stack<?> stack) {
            this.stack = stack;
        }

        @Override // io.netty.util.internal.ObjectPool.Handle
        public void recycle(Object obj) {
            if (obj == this.value) {
                Stack<?> stack = this.stack;
                if (this.lastRecycledId != this.recycleId || stack == null) {
                    throw new IllegalStateException("recycled already");
                }
                stack.push(this);
                return;
            }
            throw new IllegalArgumentException("object does not belong to handle");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Stack<T> {
        final AtomicInteger availableSharedCapacity;
        private WeakOrderQueue cursor;
        private final int delayedQueueInterval;
        DefaultHandle<?>[] elements;
        private int handleRecycleCount;
        private volatile WeakOrderQueue head;
        private final int interval;
        private final int maxCapacity;
        private final int maxDelayedQueues;
        final Recycler<T> parent;
        private WeakOrderQueue prev;
        int size;
        final WeakReference<Thread> threadRef;

        Stack(Recycler<T> recycler, Thread thread, int i, int i2, int i3, int i4, int i5) {
            this.parent = recycler;
            this.threadRef = new WeakReference<>(thread);
            this.maxCapacity = i;
            this.availableSharedCapacity = new AtomicInteger(Math.max(i / i2, Recycler.LINK_CAPACITY));
            this.elements = new DefaultHandle[Math.min(Recycler.INITIAL_CAPACITY, i)];
            this.interval = i3;
            this.delayedQueueInterval = i5;
            this.handleRecycleCount = i3;
            this.maxDelayedQueues = i4;
        }

        private WeakOrderQueue newWeakOrderQueue(Thread thread) {
            return WeakOrderQueue.newQueue(this, thread);
        }

        private void pushLater(DefaultHandle<?> defaultHandle, Thread thread) {
            if (this.maxDelayedQueues != 0) {
                Map map = (Map) Recycler.DELAYED_RECYCLED.get();
                WeakOrderQueue weakOrderQueue = (WeakOrderQueue) map.get(this);
                if (weakOrderQueue == null) {
                    if (map.size() >= this.maxDelayedQueues) {
                        map.put(this, WeakOrderQueue.DUMMY);
                        return;
                    }
                    weakOrderQueue = newWeakOrderQueue(thread);
                    if (weakOrderQueue != null) {
                        map.put(this, weakOrderQueue);
                    } else {
                        return;
                    }
                } else if (weakOrderQueue == WeakOrderQueue.DUMMY) {
                    return;
                }
                weakOrderQueue.add(defaultHandle);
            }
        }

        private void pushNow(DefaultHandle<?> defaultHandle) {
            if ((defaultHandle.recycleId | defaultHandle.lastRecycledId) == 0) {
                int i = Recycler.OWN_THREAD_ID;
                defaultHandle.lastRecycledId = i;
                defaultHandle.recycleId = i;
                int i2 = this.size;
                if (i2 < this.maxCapacity && !dropHandle(defaultHandle)) {
                    DefaultHandle<?>[] defaultHandleArr = this.elements;
                    if (i2 == defaultHandleArr.length) {
                        this.elements = (DefaultHandle[]) Arrays.copyOf(defaultHandleArr, Math.min(i2 << 1, this.maxCapacity));
                    }
                    this.elements[i2] = defaultHandle;
                    this.size = i2 + 1;
                    return;
                }
                return;
            }
            throw new IllegalStateException("recycled already");
        }

        private boolean scavenge() {
            if (scavengeSome()) {
                return true;
            }
            this.prev = null;
            this.cursor = this.head;
            return false;
        }

        private boolean scavengeSome() {
            WeakOrderQueue weakOrderQueue;
            WeakOrderQueue weakOrderQueue2;
            boolean z;
            WeakOrderQueue next;
            WeakOrderQueue weakOrderQueue3 = this.cursor;
            boolean z2 = false;
            if (weakOrderQueue3 == null) {
                weakOrderQueue2 = null;
                weakOrderQueue = this.head;
                if (weakOrderQueue == null) {
                    return false;
                }
            } else {
                weakOrderQueue = weakOrderQueue3;
                weakOrderQueue2 = this.prev;
            }
            while (true) {
                z = true;
                if (weakOrderQueue.transfer(this)) {
                    break;
                }
                next = weakOrderQueue.getNext();
                if (weakOrderQueue.get() == null) {
                    if (weakOrderQueue.hasFinalData()) {
                        while (weakOrderQueue.transfer(this)) {
                            z2 = true;
                        }
                    }
                    if (weakOrderQueue2 != null) {
                        weakOrderQueue.reclaimAllSpaceAndUnlink();
                        weakOrderQueue2.setNext(next);
                    }
                } else {
                    weakOrderQueue2 = weakOrderQueue;
                }
                if (next == null || z2) {
                    break;
                }
                weakOrderQueue = next;
            }
            z = z2;
            weakOrderQueue = next;
            this.prev = weakOrderQueue2;
            this.cursor = weakOrderQueue;
            return z;
        }

        boolean dropHandle(DefaultHandle<?> defaultHandle) {
            if (!defaultHandle.hasBeenRecycled) {
                int i = this.handleRecycleCount;
                if (i < this.interval) {
                    this.handleRecycleCount = i + 1;
                    return true;
                }
                this.handleRecycleCount = 0;
                defaultHandle.hasBeenRecycled = true;
            }
            return false;
        }

        int increaseCapacity(int i) {
            int length = this.elements.length;
            int i2 = this.maxCapacity;
            do {
                length <<= 1;
                if (length >= i) {
                    break;
                }
            } while (length < i2);
            int min = Math.min(length, i2);
            DefaultHandle<?>[] defaultHandleArr = this.elements;
            if (min != defaultHandleArr.length) {
                this.elements = (DefaultHandle[]) Arrays.copyOf(defaultHandleArr, min);
            }
            return min;
        }

        DefaultHandle<T> newHandle() {
            return new DefaultHandle<>(this);
        }

        DefaultHandle<T> pop() {
            int i = this.size;
            if (i == 0 && (!scavenge() || (i = this.size) <= 0)) {
                return null;
            }
            int i2 = i - 1;
            DefaultHandle<?>[] defaultHandleArr = this.elements;
            DefaultHandle<T> defaultHandle = (DefaultHandle<T>) defaultHandleArr[i2];
            defaultHandleArr[i2] = null;
            this.size = i2;
            if (defaultHandle.lastRecycledId == defaultHandle.recycleId) {
                defaultHandle.recycleId = 0;
                defaultHandle.lastRecycledId = 0;
                return defaultHandle;
            }
            throw new IllegalStateException("recycled multiple times");
        }

        void push(DefaultHandle<?> defaultHandle) {
            Thread currentThread = Thread.currentThread();
            if (this.threadRef.get() == currentThread) {
                pushNow(defaultHandle);
            } else {
                pushLater(defaultHandle, currentThread);
            }
        }

        synchronized void setHead(WeakOrderQueue weakOrderQueue) {
            weakOrderQueue.setNext(this.head);
            this.head = weakOrderQueue;
        }
    }

    /* loaded from: classes3.dex */
    public interface a<T> extends ObjectPool.Handle<T> {
    }

    static {
        InternalLogger instance = InternalLoggerFactory.getInstance(Recycler.class);
        logger = instance;
        AtomicInteger atomicInteger = new AtomicInteger(Integer.MIN_VALUE);
        ID_GENERATOR = atomicInteger;
        OWN_THREAD_ID = atomicInteger.getAndIncrement();
        int i = 4096;
        int i2 = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacityPerThread", SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 4096));
        if (i2 >= 0) {
            i = i2;
        }
        DEFAULT_MAX_CAPACITY_PER_THREAD = i;
        int max = Math.max(2, SystemPropertyUtil.getInt("io.netty.recycler.maxSharedCapacityFactor", 2));
        MAX_SHARED_CAPACITY_FACTOR = max;
        MAX_DELAYED_QUEUES_PER_THREAD = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.maxDelayedQueuesPerThread", NettyRuntime.availableProcessors() * 2));
        int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(Math.max(SystemPropertyUtil.getInt("io.netty.recycler.linkCapacity", 16), 16));
        LINK_CAPACITY = safeFindNextPositivePowerOfTwo;
        int max2 = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.ratio", 8));
        RATIO = max2;
        int max3 = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.delayedQueue.ratio", max2));
        DELAYED_QUEUE_RATIO = max3;
        if (instance.isDebugEnabled()) {
            if (i == 0) {
                instance.debug("-Dio.netty.recycler.maxCapacityPerThread: disabled");
                instance.debug("-Dio.netty.recycler.maxSharedCapacityFactor: disabled");
                instance.debug("-Dio.netty.recycler.linkCapacity: disabled");
                instance.debug("-Dio.netty.recycler.ratio: disabled");
                instance.debug("-Dio.netty.recycler.delayedQueue.ratio: disabled");
            } else {
                instance.debug("-Dio.netty.recycler.maxCapacityPerThread: {}", Integer.valueOf(i));
                instance.debug("-Dio.netty.recycler.maxSharedCapacityFactor: {}", Integer.valueOf(max));
                instance.debug("-Dio.netty.recycler.linkCapacity: {}", Integer.valueOf(safeFindNextPositivePowerOfTwo));
                instance.debug("-Dio.netty.recycler.ratio: {}", Integer.valueOf(max2));
                instance.debug("-Dio.netty.recycler.delayedQueue.ratio: {}", Integer.valueOf(max3));
            }
        }
        INITIAL_CAPACITY = Math.min(i, 256);
        DELAYED_RECYCLED = new FastThreadLocal<Map<Stack<?>, WeakOrderQueue>>() { // from class: io.netty.util.Recycler.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public Map<Stack<?>, WeakOrderQueue> initialValue() {
                return new WeakHashMap();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Recycler() {
        this(DEFAULT_MAX_CAPACITY_PER_THREAD);
    }

    public final T get() {
        if (this.maxCapacityPerThread == 0) {
            return newObject(NOOP_HANDLE);
        }
        Stack<T> stack = this.threadLocal.get();
        DefaultHandle<T> pop = stack.pop();
        if (pop == null) {
            pop = stack.newHandle();
            pop.value = newObject(pop);
        }
        return (T) pop.value;
    }

    protected abstract T newObject(a<T> aVar);

    @Deprecated
    public final boolean recycle(T t, a<T> aVar) {
        if (aVar == NOOP_HANDLE) {
            return false;
        }
        DefaultHandle defaultHandle = (DefaultHandle) aVar;
        if (defaultHandle.stack.parent != this) {
            return false;
        }
        defaultHandle.recycle(t);
        return true;
    }

    final int threadLocalCapacity() {
        return this.threadLocal.get().elements.length;
    }

    final int threadLocalSize() {
        return this.threadLocal.get().size;
    }

    protected Recycler(int i) {
        this(i, MAX_SHARED_CAPACITY_FACTOR);
    }

    protected Recycler(int i, int i2) {
        this(i, i2, RATIO, MAX_DELAYED_QUEUES_PER_THREAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class WeakOrderQueue extends WeakReference<Thread> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final WeakOrderQueue DUMMY = new WeakOrderQueue();
        private int handleRecycleCount;
        private final Head head;
        private final int id;
        private final int interval;
        private WeakOrderQueue next;
        private Link tail;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class Head {
            private final AtomicInteger availableSharedCapacity;
            Link link;

            Head(AtomicInteger atomicInteger) {
                this.availableSharedCapacity = atomicInteger;
            }

            private void reclaimSpace(int i) {
                this.availableSharedCapacity.addAndGet(i);
            }

            static boolean reserveSpaceForLink(AtomicInteger atomicInteger) {
                int i;
                do {
                    i = atomicInteger.get();
                    if (i < Recycler.LINK_CAPACITY) {
                        return false;
                    }
                } while (!atomicInteger.compareAndSet(i, i - Recycler.LINK_CAPACITY));
                return true;
            }

            Link newLink() {
                if (reserveSpaceForLink(this.availableSharedCapacity)) {
                    return new Link();
                }
                return null;
            }

            void reclaimAllSpaceAndUnlink() {
                Link link = this.link;
                this.link = null;
                int i = 0;
                while (link != null) {
                    i += Recycler.LINK_CAPACITY;
                    Link link2 = link.next;
                    link.next = null;
                    link = link2;
                }
                if (i > 0) {
                    reclaimSpace(i);
                }
            }

            void relink(Link link) {
                reclaimSpace(Recycler.LINK_CAPACITY);
                this.link = link;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class Link extends AtomicInteger {
            final DefaultHandle<?>[] elements = new DefaultHandle[Recycler.LINK_CAPACITY];
            Link next;
            int readIndex;

            Link() {
            }
        }

        private WeakOrderQueue() {
            super(null);
            this.id = Recycler.ID_GENERATOR.getAndIncrement();
            this.head = new Head(null);
            this.interval = 0;
        }

        static WeakOrderQueue newQueue(Stack<?> stack, Thread thread) {
            if (!Head.reserveSpaceForLink(stack.availableSharedCapacity)) {
                return null;
            }
            WeakOrderQueue weakOrderQueue = new WeakOrderQueue(stack, thread);
            stack.setHead(weakOrderQueue);
            return weakOrderQueue;
        }

        void add(DefaultHandle<?> defaultHandle) {
            defaultHandle.lastRecycledId = this.id;
            int i = this.handleRecycleCount;
            if (i < this.interval) {
                this.handleRecycleCount = i + 1;
                return;
            }
            this.handleRecycleCount = 0;
            Link link = this.tail;
            int i2 = link.get();
            if (i2 == Recycler.LINK_CAPACITY) {
                Link newLink = this.head.newLink();
                if (newLink != null) {
                    link.next = newLink;
                    this.tail = newLink;
                    i2 = newLink.get();
                    link = newLink;
                } else {
                    return;
                }
            }
            link.elements[i2] = defaultHandle;
            defaultHandle.stack = null;
            link.lazySet(i2 + 1);
        }

        WeakOrderQueue getNext() {
            return this.next;
        }

        boolean hasFinalData() {
            Link link = this.tail;
            return link.readIndex != link.get();
        }

        void reclaimAllSpaceAndUnlink() {
            this.head.reclaimAllSpaceAndUnlink();
            this.next = null;
        }

        void setNext(WeakOrderQueue weakOrderQueue) {
            this.next = weakOrderQueue;
        }

        boolean transfer(Stack<?> stack) {
            Link link;
            Link link2 = this.head.link;
            if (link2 == null) {
                return false;
            }
            if (link2.readIndex == Recycler.LINK_CAPACITY) {
                link2 = link2.next;
                if (link2 == null) {
                    return false;
                }
                this.head.relink(link2);
            }
            int i = link2.readIndex;
            int i2 = link2.get();
            int i3 = i2 - i;
            if (i3 == 0) {
                return false;
            }
            int i4 = stack.size;
            int i5 = i3 + i4;
            if (i5 > stack.elements.length) {
                i2 = Math.min((stack.increaseCapacity(i5) + i) - i4, i2);
            }
            if (i == i2) {
                return false;
            }
            DefaultHandle<?>[] defaultHandleArr = link2.elements;
            DefaultHandle<?>[] defaultHandleArr2 = stack.elements;
            while (i < i2) {
                DefaultHandle<?> defaultHandle = defaultHandleArr[i];
                int i6 = defaultHandle.recycleId;
                if (i6 == 0) {
                    defaultHandle.recycleId = defaultHandle.lastRecycledId;
                } else if (i6 != defaultHandle.lastRecycledId) {
                    throw new IllegalStateException("recycled already");
                }
                defaultHandleArr[i] = null;
                if (!stack.dropHandle(defaultHandle)) {
                    defaultHandle.stack = stack;
                    i4++;
                    defaultHandleArr2[i4] = defaultHandle;
                }
                i++;
            }
            if (i2 == Recycler.LINK_CAPACITY && (link = link2.next) != null) {
                this.head.relink(link);
            }
            link2.readIndex = i2;
            if (stack.size == i4) {
                return false;
            }
            stack.size = i4;
            return true;
        }

        private WeakOrderQueue(Stack<?> stack, Thread thread) {
            super(thread);
            this.id = Recycler.ID_GENERATOR.getAndIncrement();
            this.tail = new Link();
            Head head = new Head(stack.availableSharedCapacity);
            this.head = head;
            head.link = this.tail;
            int i = ((Stack) stack).delayedQueueInterval;
            this.interval = i;
            this.handleRecycleCount = i;
        }
    }

    protected Recycler(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, DELAYED_QUEUE_RATIO);
    }

    protected Recycler(int i, int i2, int i3, int i4, int i5) {
        this.threadLocal = new FastThreadLocal<Stack<T>>() { // from class: io.netty.util.Recycler.2
            @Override // io.netty.util.concurrent.FastThreadLocal
            protected /* bridge */ /* synthetic */ void onRemoval(Object obj) throws Exception {
                onRemoval((Stack) ((Stack) obj));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public Stack<T> initialValue() {
                return new Stack<>(Recycler.this, Thread.currentThread(), Recycler.this.maxCapacityPerThread, Recycler.this.maxSharedCapacityFactor, Recycler.this.interval, Recycler.this.maxDelayedQueuesPerThread, Recycler.this.delayedQueueInterval);
            }

            protected void onRemoval(Stack<T> stack) {
                if (stack.threadRef.get() == Thread.currentThread() && Recycler.DELAYED_RECYCLED.isSet()) {
                    ((Map) Recycler.DELAYED_RECYCLED.get()).remove(stack);
                }
            }
        };
        this.interval = Math.max(0, i3);
        this.delayedQueueInterval = Math.max(0, i5);
        if (i <= 0) {
            this.maxCapacityPerThread = 0;
            this.maxSharedCapacityFactor = 1;
            this.maxDelayedQueuesPerThread = 0;
            return;
        }
        this.maxCapacityPerThread = i;
        this.maxSharedCapacityFactor = Math.max(1, i2);
        this.maxDelayedQueuesPerThread = Math.max(0, i4);
    }
}
