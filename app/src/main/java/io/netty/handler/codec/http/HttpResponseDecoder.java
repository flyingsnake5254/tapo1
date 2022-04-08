package io.netty.handler.codec.http;

import androidx.room.RoomDatabase;

/* loaded from: classes3.dex */
public class HttpResponseDecoder extends HttpObjectDecoder {
    private static final HttpResponseStatus UNKNOWN_STATUS = new HttpResponseStatus(RoomDatabase.MAX_BIND_PARAMETER_CNT, "Unknown");

    public HttpResponseDecoder() {
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected HttpMessage createInvalidMessage() {
        return new DefaultFullHttpResponse(HttpVersion.HTTP_1_0, UNKNOWN_STATUS, this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected HttpMessage createMessage(String[] strArr) {
        return new DefaultHttpResponse(HttpVersion.valueOf(strArr[0]), HttpResponseStatus.valueOf(Integer.parseInt(strArr[1]), strArr[2]), this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected boolean isDecodingRequest() {
        return false;
    }

    public HttpResponseDecoder(int i, int i2, int i3) {
        super(i, i2, i3, true);
    }

    public HttpResponseDecoder(int i, int i2, int i3, boolean z) {
        super(i, i2, i3, true, z);
    }

    public HttpResponseDecoder(int i, int i2, int i3, boolean z, int i4) {
        super(i, i2, i3, true, z, i4);
    }

    public HttpResponseDecoder(int i, int i2, int i3, boolean z, int i4, boolean z2) {
        super(i, i2, i3, true, z, i4, z2);
    }
}
