package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseLinkedQueue.java */
/* loaded from: classes4.dex */
public abstract class BaseLinkedQueueProducerNodeRef<E> extends BaseLinkedQueuePad0<E> {
    static final long P_NODE_OFFSET = UnsafeAccess.fieldOffset(BaseLinkedQueueProducerNodeRef.class, "producerNode");
    private LinkedQueueNode<E> producerNode;

    final boolean casProducerNode(LinkedQueueNode<E> linkedQueueNode, LinkedQueueNode<E> linkedQueueNode2) {
        return UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, linkedQueueNode, linkedQueueNode2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LinkedQueueNode<E> lpProducerNode() {
        return this.producerNode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LinkedQueueNode<E> lvProducerNode() {
        return (LinkedQueueNode) UnsafeAccess.UNSAFE.getObjectVolatile(this, P_NODE_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void spProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }
}
