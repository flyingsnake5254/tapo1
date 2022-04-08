package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.unix.PreferredDirectByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class EpollRecvByteAllocatorHandle extends RecvByteBufAllocator.DelegatingHandle implements RecvByteBufAllocator.ExtendedHandle {
    private boolean isEdgeTriggered;
    private boolean receivedRdHup;
    private final PreferredDirectByteBufAllocator preferredDirectByteBufAllocator = new PreferredDirectByteBufAllocator();
    private final UncheckedBooleanSupplier defaultMaybeMoreDataSupplier = new UncheckedBooleanSupplier() { // from class: io.netty.channel.epoll.EpollRecvByteAllocatorHandle.1
        @Override // io.netty.util.UncheckedBooleanSupplier, io.netty.util.BooleanSupplier
        public boolean get() {
            return EpollRecvByteAllocatorHandle.this.maybeMoreDataToRead();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public EpollRecvByteAllocatorHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
        super(extendedHandle);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public final ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
        this.preferredDirectByteBufAllocator.updateAllocator(byteBufAllocator);
        return delegate().allocate(this.preferredDirectByteBufAllocator);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.ExtendedHandle
    public final boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier) {
        return ((RecvByteBufAllocator.ExtendedHandle) delegate()).continueReading(uncheckedBooleanSupplier);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void edgeTriggered(boolean z) {
        this.isEdgeTriggered = z;
    }

    final boolean isEdgeTriggered() {
        return this.isEdgeTriggered;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isReceivedRdHup() {
        return this.receivedRdHup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean maybeMoreDataToRead() {
        return (this.isEdgeTriggered && lastBytesRead() > 0) || (!this.isEdgeTriggered && lastBytesRead() == attemptedBytesRead());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void receivedRdHup() {
        this.receivedRdHup = true;
    }

    @Override // io.netty.channel.RecvByteBufAllocator.DelegatingHandle, io.netty.channel.RecvByteBufAllocator.Handle
    public final boolean continueReading() {
        return continueReading(this.defaultMaybeMoreDataSupplier);
    }
}
