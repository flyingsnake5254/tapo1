package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.AbstractMemcacheObject;

/* loaded from: classes3.dex */
public abstract class AbstractBinaryMemcacheMessage extends AbstractMemcacheObject implements BinaryMemcacheMessage {
    private long cas;
    private byte dataType;
    private ByteBuf extras;
    private byte extrasLength;
    private ByteBuf key;
    private short keyLength;
    private byte magic;
    private int opaque;
    private byte opcode;
    private int totalBodyLength;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractBinaryMemcacheMessage(ByteBuf byteBuf, ByteBuf byteBuf2) {
        this.key = byteBuf;
        byte b2 = 0;
        this.keyLength = byteBuf == null ? (short) 0 : (short) byteBuf.readableBytes();
        this.extras = byteBuf2;
        b2 = byteBuf2 != null ? (byte) byteBuf2.readableBytes() : b2;
        this.extrasLength = b2;
        this.totalBodyLength = this.keyLength + b2;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public long cas() {
        return this.cas;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void copyMeta(AbstractBinaryMemcacheMessage abstractBinaryMemcacheMessage) {
        abstractBinaryMemcacheMessage.magic = this.magic;
        abstractBinaryMemcacheMessage.opcode = this.opcode;
        abstractBinaryMemcacheMessage.keyLength = this.keyLength;
        abstractBinaryMemcacheMessage.extrasLength = this.extrasLength;
        abstractBinaryMemcacheMessage.dataType = this.dataType;
        abstractBinaryMemcacheMessage.totalBodyLength = this.totalBodyLength;
        abstractBinaryMemcacheMessage.opaque = this.opaque;
        abstractBinaryMemcacheMessage.cas = this.cas;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public byte dataType() {
        return this.dataType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.AbstractReferenceCounted
    public void deallocate() {
        ByteBuf byteBuf = this.key;
        if (byteBuf != null) {
            byteBuf.release();
        }
        ByteBuf byteBuf2 = this.extras;
        if (byteBuf2 != null) {
            byteBuf2.release();
        }
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public ByteBuf extras() {
        return this.extras;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public byte extrasLength() {
        return this.extrasLength;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public ByteBuf key() {
        return this.key;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public short keyLength() {
        return this.keyLength;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public byte magic() {
        return this.magic;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public int opaque() {
        return this.opaque;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public byte opcode() {
        return this.opcode;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setCas(long j) {
        this.cas = j;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setDataType(byte b2) {
        this.dataType = b2;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setExtras(ByteBuf byteBuf) {
        ByteBuf byteBuf2 = this.extras;
        if (byteBuf2 != null) {
            byteBuf2.release();
        }
        this.extras = byteBuf;
        short s = this.extrasLength;
        byte readableBytes = byteBuf == null ? (byte) 0 : (byte) byteBuf.readableBytes();
        this.extrasLength = readableBytes;
        this.totalBodyLength = (this.totalBodyLength + readableBytes) - s;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinaryMemcacheMessage setExtrasLength(byte b2) {
        this.extrasLength = b2;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setKey(ByteBuf byteBuf) {
        ByteBuf byteBuf2 = this.key;
        if (byteBuf2 != null) {
            byteBuf2.release();
        }
        this.key = byteBuf;
        short s = this.keyLength;
        short readableBytes = byteBuf == null ? (short) 0 : (short) byteBuf.readableBytes();
        this.keyLength = readableBytes;
        this.totalBodyLength = (this.totalBodyLength + readableBytes) - s;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinaryMemcacheMessage setKeyLength(short s) {
        this.keyLength = s;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setMagic(byte b2) {
        this.magic = b2;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setOpaque(int i) {
        this.opaque = i;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setOpcode(byte b2) {
        this.opcode = b2;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setTotalBodyLength(int i) {
        this.totalBodyLength = i;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public int totalBodyLength() {
        return this.totalBodyLength;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheMessage retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheMessage touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheMessage retain(int i) {
        super.retain(i);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public BinaryMemcacheMessage touch(Object obj) {
        ByteBuf byteBuf = this.key;
        if (byteBuf != null) {
            byteBuf.touch(obj);
        }
        ByteBuf byteBuf2 = this.extras;
        if (byteBuf2 != null) {
            byteBuf2.touch(obj);
        }
        return this;
    }
}
