package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes4.dex */
public class MpscAtomicArrayQueue<E> extends MpscAtomicArrayQueueL3Pad<E> {
    public MpscAtomicArrayQueue(int i) {
        super(i);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        if (consumer == 0) {
            throw new IllegalArgumentException("c is null");
        } else if (i >= 0) {
            if (i == 0) {
                return 0;
            }
            AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
            int i2 = this.mask;
            long lpConsumerIndex = lpConsumerIndex();
            for (int i3 = 0; i3 < i; i3++) {
                long j = i3 + lpConsumerIndex;
                int calcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(j, i2);
                Object lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, calcCircularRefElementOffset);
                if (lvRefElement == null) {
                    return i3;
                }
                AtomicQueueUtil.soRefElement(atomicReferenceArray, calcCircularRefElementOffset, null);
                soConsumerIndex(j + 1);
                consumer.accept(lvRefElement);
            }
            return i;
        } else {
            throw new IllegalArgumentException("limit is negative: " + i);
        }
    }

    public final int failFastOffer(E e2) {
        Objects.requireNonNull(e2);
        int i = this.mask;
        long j = i + 1;
        long lvProducerIndex = lvProducerIndex();
        if (lvProducerIndex >= lvProducerLimit()) {
            long lvConsumerIndex = lvConsumerIndex() + j;
            if (lvProducerIndex >= lvConsumerIndex) {
                return 1;
            }
            soProducerLimit(lvConsumerIndex);
        }
        if (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex)) {
            return -1;
        }
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lvProducerIndex, i), e2);
        return 0;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        long lvProducerIndex;
        int min;
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        } else if (i >= 0) {
            if (i == 0) {
                return 0;
            }
            int i2 = this.mask;
            long j = i2 + 1;
            long lvProducerLimit = lvProducerLimit();
            do {
                lvProducerIndex = lvProducerIndex();
                long j2 = lvProducerLimit - lvProducerIndex;
                if (j2 <= 0) {
                    lvProducerLimit = lvConsumerIndex() + j;
                    j2 = lvProducerLimit - lvProducerIndex;
                    if (j2 <= 0) {
                        return 0;
                    }
                    soProducerLimit(lvProducerLimit);
                }
                min = Math.min((int) j2, i);
            } while (!casProducerIndex(lvProducerIndex, min + lvProducerIndex));
            AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
            for (int i3 = 0; i3 < min; i3++) {
                AtomicQueueUtil.soRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(i3 + lvProducerIndex, i2), supplier.get());
            }
            return min;
        } else {
            throw new IllegalArgumentException("limit is negative:" + i);
        }
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e2) {
        long lvProducerIndex;
        Objects.requireNonNull(e2);
        int i = this.mask;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            if (lvProducerIndex >= lvProducerLimit) {
                lvProducerLimit = lvConsumerIndex() + i + 1;
                if (lvProducerIndex >= lvProducerLimit) {
                    return false;
                }
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lvProducerIndex, i), e2);
        return true;
    }

    public boolean offerIfBelowThreshold(E e2, int i) {
        long lvProducerIndex;
        Objects.requireNonNull(e2);
        int i2 = this.mask;
        long j = i2 + 1;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            long j2 = i;
            if (j - (lvProducerLimit - lvProducerIndex) >= j2) {
                long lvConsumerIndex = lvConsumerIndex();
                if (lvProducerIndex - lvConsumerIndex >= j2) {
                    return false;
                }
                lvProducerLimit = lvConsumerIndex + j;
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lvProducerIndex, i2), e2);
        return true;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        int calcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex, this.mask);
        E e2 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, calcCircularRefElementOffset);
        if (e2 != null) {
            return e2;
        }
        if (lpConsumerIndex == lvProducerIndex()) {
            return null;
        }
        do {
            e2 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, calcCircularRefElementOffset);
        } while (e2 == null);
        return e2;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        long lpConsumerIndex = lpConsumerIndex();
        int calcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex, this.mask);
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        E e2 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, calcCircularRefElementOffset);
        if (e2 != null) {
            AtomicQueueUtil.soRefElement(atomicReferenceArray, calcCircularRefElementOffset, null);
            soConsumerIndex(lpConsumerIndex + 1);
            return e2;
        } else if (lpConsumerIndex == lvProducerIndex()) {
            return null;
        } else {
            do {
                e2 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, calcCircularRefElementOffset);
            } while (e2 == null);
            AtomicQueueUtil.soRefElement(atomicReferenceArray, calcCircularRefElementOffset, null);
            soConsumerIndex(lpConsumerIndex + 1);
            return e2;
        }
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e2) {
        return offer(e2);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) AtomicQueueUtil.lvRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex(), this.mask));
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        int calcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex, this.mask);
        E e2 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, calcCircularRefElementOffset);
        if (e2 == null) {
            return null;
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray, calcCircularRefElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e2;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Deprecated
    public int weakOffer(E e2) {
        return failFastOffer(e2);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        return MessagePassingQueueUtil.fillBounded(this, supplier);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }
}
