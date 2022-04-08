package io.netty.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class PoolChunk<T> implements PoolChunkMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INTEGER_SIZE_MINUS_ONE = 31;
    final PoolArena<T> arena;
    private final Deque<ByteBuffer> cachedNioBuffers;
    private final int chunkSize;
    private final byte[] depthMap;
    int freeBytes;
    private final int log2ChunkSize;
    private final int maxOrder;
    private final int maxSubpageAllocs;
    final T memory;
    private final byte[] memoryMap;
    PoolChunk<T> next;
    final int offset;
    private final int pageShifts;
    private final int pageSize;
    PoolChunkList<T> parent;
    PoolChunk<T> prev;
    private final int subpageOverflowMask;
    private final PoolSubpage<T>[] subpages;
    final boolean unpooled;
    private final byte unusable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolChunk(PoolArena<T> poolArena, T t, int i, int i2, int i3, int i4, int i5) {
        this.unpooled = false;
        this.arena = poolArena;
        this.memory = t;
        this.pageSize = i;
        this.pageShifts = i3;
        this.maxOrder = i2;
        this.chunkSize = i4;
        this.offset = i5;
        this.unusable = (byte) (i2 + 1);
        this.log2ChunkSize = log2(i4);
        this.subpageOverflowMask = ~(i - 1);
        this.freeBytes = i4;
        int i6 = 1 << i2;
        this.maxSubpageAllocs = i6;
        byte[] bArr = new byte[i6 << 1];
        this.memoryMap = bArr;
        this.depthMap = new byte[bArr.length];
        int i7 = 1;
        for (int i8 = 0; i8 <= i2; i8++) {
            int i9 = 1 << i8;
            for (int i10 = 0; i10 < i9; i10++) {
                byte b2 = (byte) i8;
                this.memoryMap[i7] = b2;
                this.depthMap[i7] = b2;
                i7++;
            }
        }
        this.subpages = newSubpageArray(this.maxSubpageAllocs);
        this.cachedNioBuffers = new ArrayDeque(8);
    }

    private int allocateNode(int i) {
        int i2 = 1;
        int i3 = -(1 << i);
        byte value = value(1);
        if (value > i) {
            return -1;
        }
        while (true) {
            if (value < i || (i2 & i3) == 0) {
                i2 <<= 1;
                value = value(i2);
                if (value > i) {
                    i2 ^= 1;
                    value = value(i2);
                }
            } else {
                value(i2);
                setValue(i2, this.unusable);
                updateParentsAlloc(i2);
                return i2;
            }
        }
    }

    private long allocateRun(int i) {
        int allocateNode = allocateNode(this.maxOrder - (log2(i) - this.pageShifts));
        if (allocateNode < 0) {
            return allocateNode;
        }
        this.freeBytes -= runLength(allocateNode);
        return allocateNode;
    }

    private long allocateSubpage(int i) {
        PoolSubpage<T> findSubpagePoolHead = this.arena.findSubpagePoolHead(i);
        int i2 = this.maxOrder;
        synchronized (findSubpagePoolHead) {
            int allocateNode = allocateNode(i2);
            if (allocateNode < 0) {
                return allocateNode;
            }
            PoolSubpage<T>[] poolSubpageArr = this.subpages;
            int i3 = this.pageSize;
            this.freeBytes -= i3;
            int subpageIdx = subpageIdx(allocateNode);
            PoolSubpage<T> poolSubpage = poolSubpageArr[subpageIdx];
            if (poolSubpage == null) {
                PoolSubpage<T> poolSubpage2 = new PoolSubpage<>(findSubpagePoolHead, this, allocateNode, runOffset(allocateNode), i3, i);
                poolSubpageArr[subpageIdx] = poolSubpage2;
                poolSubpage = poolSubpage2;
            } else {
                poolSubpage.init(findSubpagePoolHead, i);
            }
            return poolSubpage.allocate();
        }
    }

    private static int bitmapIdx(long j) {
        return (int) (j >>> 32);
    }

    private byte depth(int i) {
        return this.depthMap[i];
    }

    private static int log2(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    private static int memoryMapIdx(long j) {
        return (int) j;
    }

    private PoolSubpage<T>[] newSubpageArray(int i) {
        return new PoolSubpage[i];
    }

    private int runLength(int i) {
        return 1 << (this.log2ChunkSize - depth(i));
    }

    private int runOffset(int i) {
        return ((1 << depth(i)) ^ i) * runLength(i);
    }

    private void setValue(int i, byte b2) {
        this.memoryMap[i] = b2;
    }

    private int subpageIdx(int i) {
        return i ^ this.maxSubpageAllocs;
    }

    private void updateParentsAlloc(int i) {
        while (i > 1) {
            int i2 = i >>> 1;
            byte value = value(i);
            byte value2 = value(i ^ 1);
            if (value >= value2) {
                value = value2;
            }
            setValue(i2, value);
            i = i2;
        }
    }

    private void updateParentsFree(int i) {
        int depth = depth(i) + 1;
        while (i > 1) {
            int i2 = i >>> 1;
            byte value = value(i);
            byte value2 = value(i ^ 1);
            depth--;
            if (value == depth && value2 == depth) {
                setValue(i2, (byte) (depth - 1));
            } else {
                if (value >= value2) {
                    value = value2;
                }
                setValue(i2, value);
            }
            i = i2;
        }
    }

    private byte value(int i) {
        return this.memoryMap[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allocate(PooledByteBuf<T> pooledByteBuf, int i, int i2, PoolThreadCache poolThreadCache) {
        long j;
        if ((this.subpageOverflowMask & i2) != 0) {
            j = allocateRun(i2);
        } else {
            j = allocateSubpage(i2);
        }
        if (j < 0) {
            return false;
        }
        Deque<ByteBuffer> deque = this.cachedNioBuffers;
        initBuf(pooledByteBuf, deque != null ? deque.pollLast() : null, j, i, poolThreadCache);
        return true;
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int chunkSize() {
        return this.chunkSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        this.arena.destroyChunk(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void free(long j, ByteBuffer byteBuffer) {
        Deque<ByteBuffer> deque;
        int memoryMapIdx = memoryMapIdx(j);
        int bitmapIdx = bitmapIdx(j);
        if (bitmapIdx != 0) {
            PoolSubpage<T> poolSubpage = this.subpages[subpageIdx(memoryMapIdx)];
            PoolSubpage<T> findSubpagePoolHead = this.arena.findSubpagePoolHead(poolSubpage.elemSize);
            synchronized (findSubpagePoolHead) {
                if (poolSubpage.free(findSubpagePoolHead, bitmapIdx & 1073741823)) {
                    return;
                }
            }
        }
        this.freeBytes += runLength(memoryMapIdx);
        setValue(memoryMapIdx, depth(memoryMapIdx));
        updateParentsFree(memoryMapIdx);
        if (byteBuffer != null && (deque = this.cachedNioBuffers) != null && deque.size() < PooledByteBufAllocator.DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK) {
            this.cachedNioBuffers.offer(byteBuffer);
        }
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int freeBytes() {
        int i;
        synchronized (this.arena) {
            i = this.freeBytes;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initBuf(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j, int i, PoolThreadCache poolThreadCache) {
        int memoryMapIdx = memoryMapIdx(j);
        int bitmapIdx = bitmapIdx(j);
        if (bitmapIdx == 0) {
            value(memoryMapIdx);
            pooledByteBuf.init(this, byteBuffer, j, runOffset(memoryMapIdx) + this.offset, i, runLength(memoryMapIdx), poolThreadCache);
            return;
        }
        initBufWithSubpage(pooledByteBuf, byteBuffer, j, bitmapIdx, i, poolThreadCache);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j, int i, PoolThreadCache poolThreadCache) {
        initBufWithSubpage(pooledByteBuf, byteBuffer, j, bitmapIdx(j), i, poolThreadCache);
    }

    public String toString() {
        int i;
        synchronized (this.arena) {
            i = this.freeBytes;
        }
        return "Chunk(" + Integer.toHexString(System.identityHashCode(this)) + ": " + usage(i) + "%, " + (this.chunkSize - i) + '/' + this.chunkSize + ')';
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int usage() {
        int i;
        synchronized (this.arena) {
            i = this.freeBytes;
        }
        return usage(i);
    }

    private void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j, int i, int i2, PoolThreadCache poolThreadCache) {
        int memoryMapIdx = memoryMapIdx(j);
        PoolSubpage<T> poolSubpage = this.subpages[subpageIdx(memoryMapIdx)];
        int runOffset = runOffset(memoryMapIdx);
        int i3 = poolSubpage.elemSize;
        pooledByteBuf.init(this, byteBuffer, j, runOffset + ((1073741823 & i) * i3) + this.offset, i2, i3, poolThreadCache);
    }

    private int usage(int i) {
        if (i == 0) {
            return 100;
        }
        int i2 = (int) ((i * 100) / this.chunkSize);
        if (i2 == 0) {
            return 99;
        }
        return 100 - i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolChunk(PoolArena<T> poolArena, T t, int i, int i2) {
        this.unpooled = true;
        this.arena = poolArena;
        this.memory = t;
        this.offset = i2;
        this.memoryMap = null;
        this.depthMap = null;
        this.subpages = null;
        this.subpageOverflowMask = 0;
        this.pageSize = 0;
        this.pageShifts = 0;
        this.maxOrder = 0;
        this.unusable = (byte) (1 + 0);
        this.chunkSize = i;
        this.log2ChunkSize = log2(i);
        this.maxSubpageAllocs = 0;
        this.cachedNioBuffers = null;
    }
}
