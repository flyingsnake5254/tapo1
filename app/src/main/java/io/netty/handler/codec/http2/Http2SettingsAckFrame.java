package io.netty.handler.codec.http2;

/* loaded from: classes3.dex */
public interface Http2SettingsAckFrame extends Http2Frame {
    public static final Http2SettingsAckFrame INSTANCE = new DefaultHttp2SettingsAckFrame();

    @Override // io.netty.handler.codec.http2.Http2Frame
    String name();
}
