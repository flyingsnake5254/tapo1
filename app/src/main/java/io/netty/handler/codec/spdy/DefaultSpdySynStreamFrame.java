package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* loaded from: classes3.dex */
public class DefaultSpdySynStreamFrame extends DefaultSpdyHeadersFrame implements SpdySynStreamFrame {
    private int associatedStreamId;
    private byte priority;
    private boolean unidirectional;

    public DefaultSpdySynStreamFrame(int i, int i2, byte b2) {
        this(i, i2, b2, true);
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public int associatedStreamId() {
        return this.associatedStreamId;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public boolean isUnidirectional() {
        return this.unidirectional;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public byte priority() {
        return this.priority;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public SpdySynStreamFrame setAssociatedStreamId(int i) {
        ObjectUtil.checkPositiveOrZero(i, "associatedStreamId");
        this.associatedStreamId = i;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public SpdySynStreamFrame setPriority(byte b2) {
        if (b2 < 0 || b2 > 7) {
            throw new IllegalArgumentException("Priority must be between 0 and 7 inclusive: " + ((int) b2));
        }
        this.priority = b2;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySynStreamFrame
    public SpdySynStreamFrame setUnidirectional(boolean z) {
        this.unidirectional = z;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(last: ");
        sb.append(isLast());
        sb.append("; unidirectional: ");
        sb.append(isUnidirectional());
        sb.append(')');
        String str = StringUtil.NEWLINE;
        sb.append(str);
        sb.append("--> Stream-ID = ");
        sb.append(streamId());
        sb.append(str);
        if (this.associatedStreamId != 0) {
            sb.append("--> Associated-To-Stream-ID = ");
            sb.append(associatedStreamId());
            sb.append(str);
        }
        sb.append("--> Priority = ");
        sb.append((int) priority());
        sb.append(str);
        sb.append("--> Headers:");
        sb.append(str);
        appendHeaders(sb);
        sb.setLength(sb.length() - str.length());
        return sb.toString();
    }

    public DefaultSpdySynStreamFrame(int i, int i2, byte b2, boolean z) {
        super(i, z);
        setAssociatedStreamId(i2);
        setPriority(b2);
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.SpdyHeadersFrame
    public SpdySynStreamFrame setInvalid() {
        super.setInvalid();
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdySynStreamFrame setLast(boolean z) {
        super.setLast(z);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame, io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdySynStreamFrame setStreamId(int i) {
        super.setStreamId(i);
        return this;
    }
}
