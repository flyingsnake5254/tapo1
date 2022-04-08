package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;

/* loaded from: classes3.dex */
public class ChunkedNioFile implements ChunkedInput<ByteBuf> {
    private final int chunkSize;
    private final long endOffset;
    private final FileChannel in;
    private long offset;
    private final long startOffset;

    public ChunkedNioFile(File file) throws IOException {
        this(new RandomAccessFile(file, "r").getChannel());
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.in.close();
    }

    public long currentOffset() {
        return this.offset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        return this.offset >= this.endOffset || !this.in.isOpen();
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long length() {
        return this.endOffset - this.startOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset - this.startOffset;
    }

    public long startOffset() {
        return this.startOffset;
    }

    public ChunkedNioFile(File file, int i) throws IOException {
        this(new RandomAccessFile(file, "r").getChannel(), i);
    }

    public ChunkedNioFile(FileChannel fileChannel) throws IOException {
        this(fileChannel, 8192);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    public ChunkedNioFile(FileChannel fileChannel, int i) throws IOException {
        this(fileChannel, 0L, fileChannel.size(), i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator) throws Exception {
        long j = this.offset;
        long j2 = this.endOffset;
        if (j >= j2) {
            return null;
        }
        int min = (int) Math.min(this.chunkSize, j2 - j);
        ByteBuf buffer = byteBufAllocator.buffer(min);
        int i = 0;
        do {
            try {
                int writeBytes = buffer.writeBytes(this.in, i + j, min - i);
                if (writeBytes < 0) {
                    break;
                }
                i += writeBytes;
            } catch (Throwable th) {
                buffer.release();
                throw th;
            }
        } while (i != min);
        this.offset += i;
        return buffer;
    }

    public ChunkedNioFile(FileChannel fileChannel, long j, long j2, int i) throws IOException {
        ObjectUtil.checkNotNull(fileChannel, "in");
        ObjectUtil.checkPositiveOrZero(j, "offset");
        ObjectUtil.checkPositiveOrZero(j2, "length");
        ObjectUtil.checkPositive(i, "chunkSize");
        if (fileChannel.isOpen()) {
            this.in = fileChannel;
            this.chunkSize = i;
            this.startOffset = j;
            this.offset = j;
            this.endOffset = j + j2;
            return;
        }
        throw new ClosedChannelException();
    }
}
