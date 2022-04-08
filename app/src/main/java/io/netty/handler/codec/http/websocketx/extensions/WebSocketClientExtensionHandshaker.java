package io.netty.handler.codec.http.websocketx.extensions;

/* loaded from: classes3.dex */
public interface WebSocketClientExtensionHandshaker {
    a handshakeExtension(WebSocketExtensionData webSocketExtensionData);

    WebSocketExtensionData newRequestData();
}
