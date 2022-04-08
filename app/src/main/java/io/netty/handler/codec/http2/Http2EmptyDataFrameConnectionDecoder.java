package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
final class Http2EmptyDataFrameConnectionDecoder extends DecoratingHttp2ConnectionDecoder {
    private final int maxConsecutiveEmptyFrames;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2EmptyDataFrameConnectionDecoder(Http2ConnectionDecoder http2ConnectionDecoder, int i) {
        super(http2ConnectionDecoder);
        this.maxConsecutiveEmptyFrames = ObjectUtil.checkPositive(i, "maxConsecutiveEmptyFrames");
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2ConnectionDecoder, io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void frameListener(Http2FrameListener http2FrameListener) {
        if (http2FrameListener != null) {
            super.frameListener(new Http2EmptyDataFrameListener(http2FrameListener, this.maxConsecutiveEmptyFrames));
        } else {
            super.frameListener(null);
        }
    }

    Http2FrameListener frameListener0() {
        return super.frameListener();
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2ConnectionDecoder, io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2FrameListener frameListener() {
        Http2FrameListener frameListener0 = frameListener0();
        return frameListener0 instanceof Http2EmptyDataFrameListener ? ((Http2EmptyDataFrameListener) frameListener0).listener : frameListener0;
    }
}
