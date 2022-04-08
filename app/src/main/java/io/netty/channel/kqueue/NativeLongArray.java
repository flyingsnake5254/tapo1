package io.netty.channel.kqueue;

import io.netty.channel.unix.Buffer;
import io.netty.channel.unix.Limits;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class NativeLongArray {
    private int capacity;
    private ByteBuffer memory;
    private long memoryAddress;
    private int size;

    NativeLongArray(int i) {
        if (i >= 1) {
            ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i));
            this.memory = allocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
            this.capacity = i;
            return;
        }
        throw new IllegalArgumentException("capacity must be >= 1 but was " + i);
    }

    private static int calculateBufferCapacity(int i) {
        return i * Limits.SIZEOF_JLONG;
    }

    private static int idx(int i) {
        return i * Limits.SIZEOF_JLONG;
    }

    private long memoryOffset(int i) {
        return this.memoryAddress + idx(i);
    }

    private void reallocIfNeeded() {
        int i = this.size;
        int i2 = this.capacity;
        if (i == i2) {
            int i3 = i2 <= 65536 ? i2 << 1 : (i2 + i2) >> 1;
            ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i3));
            this.memory.position(0).limit(this.size);
            allocateDirectWithNativeOrder.put(this.memory);
            allocateDirectWithNativeOrder.position(0);
            Buffer.free(this.memory);
            this.memory = allocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
            this.capacity = i3;
        }
    }

    void add(long j) {
        reallocIfNeeded();
        if (PlatformDependent.hasUnsafe()) {
            PlatformDependent.putLong(memoryOffset(this.size), j);
        } else {
            this.memory.putLong(idx(this.size), j);
        }
        this.size++;
    }

    void clear() {
        this.size = 0;
    }

    void free() {
        Buffer.free(this.memory);
        this.memoryAddress = 0L;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    long memoryAddress() {
        return this.memoryAddress;
    }

    long memoryAddressEnd() {
        return memoryOffset(this.size);
    }

    int size() {
        return this.size;
    }

    public String toString() {
        return "memoryAddress: " + this.memoryAddress + " capacity: " + this.capacity + " size: " + this.size;
    }
}
