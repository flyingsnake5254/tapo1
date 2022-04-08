package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public abstract class AbstractDiskHttpData extends AbstractHttpData {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractDiskHttpData.class);
    private File file;
    private FileChannel fileChannel;
    private boolean isRenamed;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDiskHttpData(String str, Charset charset, long j) {
        super(str, charset, j);
    }

    private static byte[] readFrom(File file) throws IOException {
        long length = file.length();
        if (length <= 2147483647L) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            byte[] bArr = new byte[(int) length];
            try {
                FileChannel channel = randomAccessFile.getChannel();
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                for (int i = 0; i < length; i += channel.read(wrap)) {
                }
                return bArr;
            } finally {
                randomAccessFile.close();
            }
        } else {
            throw new IllegalArgumentException("File too big to be loaded in memory");
        }
    }

    private File tempFile() throws IOException {
        String str;
        File file;
        String diskFilename = getDiskFilename();
        if (diskFilename != null) {
            str = '_' + diskFilename;
        } else {
            str = getPostfix();
        }
        if (getBaseDirectory() == null) {
            file = File.createTempFile(getPrefix(), str);
        } else {
            file = File.createTempFile(getPrefix(), str, new File(getBaseDirectory()));
        }
        if (deleteOnExit()) {
            file.deleteOnExit();
        }
        return file;
    }

    /* JADX WARN: Finally extract failed */
    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z) throws IOException {
        if (byteBuf != null) {
            try {
                int readableBytes = byteBuf.readableBytes();
                long j = readableBytes;
                checkSize(this.size + j);
                long j2 = this.definedSize;
                if (j2 > 0 && j2 < this.size + j) {
                    throw new IOException("Out of size: " + (this.size + j) + " > " + this.definedSize);
                }
                if (this.file == null) {
                    this.file = tempFile();
                }
                if (this.fileChannel == null) {
                    this.fileChannel = new RandomAccessFile(this.file, "rw").getChannel();
                }
                int readerIndex = byteBuf.readerIndex();
                FileChannel fileChannel = this.fileChannel;
                byteBuf.getBytes(readerIndex, fileChannel, fileChannel.position(), readableBytes);
                this.size += j;
                byteBuf.readerIndex(byteBuf.readerIndex() + 0);
            } finally {
                byteBuf.release();
            }
        }
        if (z) {
            if (this.file == null) {
                this.file = tempFile();
            }
            if (this.fileChannel == null) {
                this.fileChannel = new RandomAccessFile(this.file, "rw").getChannel();
            }
            try {
                this.fileChannel.force(false);
                this.fileChannel.close();
                this.fileChannel = null;
                setCompleted();
            } catch (Throwable th) {
                this.fileChannel.close();
                throw th;
            }
        } else {
            ObjectUtil.checkNotNull(byteBuf, "buffer");
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0012 -> B:13:0x0027). Please submit an issue!!! */
    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        FileChannel fileChannel = this.fileChannel;
        if (fileChannel != null) {
            try {
                try {
                    try {
                        fileChannel.force(false);
                        this.fileChannel.close();
                    } catch (IOException e2) {
                        logger.warn("Failed to force.", (Throwable) e2);
                        this.fileChannel.close();
                    }
                } catch (IOException e3) {
                    logger.warn("Failed to close a file.", (Throwable) e3);
                }
                this.fileChannel = null;
            } catch (Throwable th) {
                try {
                    this.fileChannel.close();
                } catch (IOException e4) {
                    logger.warn("Failed to close a file.", (Throwable) e4);
                }
                throw th;
            }
        }
        if (!this.isRenamed) {
            File file = this.file;
            if (file != null && file.exists() && !this.file.delete()) {
                logger.warn("Failed to delete: {}", this.file);
            }
            this.file = null;
        }
    }

    protected abstract boolean deleteOnExit();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() throws IOException {
        File file = this.file;
        if (file == null) {
            return EmptyArrays.EMPTY_BYTES;
        }
        return readFrom(file);
    }

    protected abstract String getBaseDirectory();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() throws IOException {
        File file = this.file;
        if (file == null) {
            return Unpooled.EMPTY_BUFFER;
        }
        return Unpooled.wrappedBuffer(readFrom(file));
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getChunk(int i) throws IOException {
        if (this.file == null || i == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        if (this.fileChannel == null) {
            this.fileChannel = new RandomAccessFile(this.file, "r").getChannel();
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            try {
                int read = this.fileChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                i2 += read;
            } finally {
                this.fileChannel.close();
                this.fileChannel = null;
            }
        }
        if (i2 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        allocate.flip();
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(allocate);
        wrappedBuffer.readerIndex(0);
        wrappedBuffer.writerIndex(i2);
        return wrappedBuffer;
    }

    protected abstract String getDiskFilename();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() throws IOException {
        return this.file;
    }

    protected abstract String getPostfix();

    protected abstract String getPrefix();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() throws IOException {
        return getString(HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d2  */
    @Override // io.netty.handler.codec.http.multipart.HttpData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean renameTo(java.io.File r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.AbstractDiskHttpData.renameTo(java.io.File):boolean");
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) throws IOException {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        try {
            long readableBytes = byteBuf.readableBytes();
            this.size = readableBytes;
            checkSize(readableBytes);
            long j = this.definedSize;
            if (j > 0 && j < this.size) {
                throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
            }
            if (this.file == null) {
                this.file = tempFile();
            }
            if (byteBuf.readableBytes() == 0) {
                if (!this.file.createNewFile()) {
                    if (this.file.length() != 0) {
                        if (!this.file.delete() || !this.file.createNewFile()) {
                            throw new IOException("file exists already: " + this.file);
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.file, "rw");
            randomAccessFile.setLength(0L);
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer nioBuffer = byteBuf.nioBuffer();
            int i = 0;
            while (i < this.size) {
                i += channel.write(nioBuffer);
            }
            byteBuf.readerIndex(byteBuf.readerIndex() + i);
            channel.force(false);
            randomAccessFile.close();
            setCompleted();
        } finally {
            byteBuf.release();
        }
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData touch() {
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public HttpData touch(Object obj) {
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) throws IOException {
        File file = this.file;
        if (file == null) {
            return "";
        }
        if (charset == null) {
            return new String(readFrom(file), HttpConstants.DEFAULT_CHARSET.name());
        }
        return new String(readFrom(file), charset.name());
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        long length = file.length();
        checkSize(length);
        this.size = length;
        if (this.file != null) {
            delete();
        }
        this.file = file;
        this.isRenamed = true;
        setCompleted();
    }

    /* JADX WARN: Finally extract failed */
    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        ObjectUtil.checkNotNull(inputStream, "inputStream");
        if (this.file != null) {
            delete();
        }
        this.file = tempFile();
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.file, "rw");
        try {
            randomAccessFile.setLength(0L);
            FileChannel channel = randomAccessFile.getChannel();
            byte[] bArr = new byte[16384];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int read = inputStream.read(bArr);
            int i = 0;
            while (read > 0) {
                wrap.position(read).flip();
                i += channel.write(wrap);
                checkSize(i);
                read = inputStream.read(bArr);
            }
            channel.force(false);
            randomAccessFile.close();
            long j = i;
            this.size = j;
            long j2 = this.definedSize;
            if (j2 <= 0 || j2 >= j) {
                this.isRenamed = true;
                setCompleted();
                return;
            }
            if (!this.file.delete()) {
                logger.warn("Failed to delete: {}", this.file);
            }
            this.file = null;
            throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }
}
