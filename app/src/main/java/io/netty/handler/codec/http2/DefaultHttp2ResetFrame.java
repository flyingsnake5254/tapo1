package io.netty.handler.codec.http2;

import com.google.firebase.messaging.Constants;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* loaded from: classes3.dex */
public final class DefaultHttp2ResetFrame extends AbstractHttp2StreamFrame implements Http2ResetFrame {
    private final long errorCode;

    public DefaultHttp2ResetFrame(Http2Error http2Error) {
        this.errorCode = ((Http2Error) ObjectUtil.checkNotNull(http2Error, Constants.IPC_BUNDLE_KEY_SEND_ERROR)).code();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2ResetFrame)) {
            return false;
        }
        return super.equals(obj) && this.errorCode == ((DefaultHttp2ResetFrame) obj).errorCode;
    }

    @Override // io.netty.handler.codec.http2.Http2ResetFrame
    public long errorCode() {
        return this.errorCode;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public int hashCode() {
        long j = this.errorCode;
        return (super.hashCode() * 31) + ((int) (j ^ (j >>> 32)));
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "RST_STREAM";
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(stream=" + stream() + ", errorCode=" + this.errorCode + ')';
    }

    public DefaultHttp2ResetFrame(long j) {
        this.errorCode = j;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2ResetFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }
}
