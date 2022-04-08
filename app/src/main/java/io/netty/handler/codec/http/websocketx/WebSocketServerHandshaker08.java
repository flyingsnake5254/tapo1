package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;

/* loaded from: classes3.dex */
public class WebSocketServerHandshaker08 extends WebSocketServerHandshaker {
    public static final String WEBSOCKET_08_ACCEPT_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    public WebSocketServerHandshaker08(String str, String str2, boolean z, int i) {
        this(str, str2, z, i, false);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    protected FullHttpResponse newHandshakeResponse(FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders) {
        String str = fullHttpRequest.headers().get(HttpHeaderNames.SEC_WEBSOCKET_KEY);
        if (str != null) {
            DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.SWITCHING_PROTOCOLS, fullHttpRequest.content().alloc().buffer(0));
            if (httpHeaders != null) {
                defaultFullHttpResponse.headers().add(httpHeaders);
            }
            String base64 = WebSocketUtil.base64(WebSocketUtil.sha1((((Object) str) + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes(CharsetUtil.US_ASCII)));
            InternalLogger internalLogger = WebSocketServerHandshaker.logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("WebSocket version 08 server handshake key: {}, response: {}", str, base64);
            }
            defaultFullHttpResponse.headers().set(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET).set(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE).set(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT, base64);
            HttpHeaders headers = fullHttpRequest.headers();
            AsciiString asciiString = HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL;
            String str2 = headers.get(asciiString);
            if (str2 != null) {
                String selectSubprotocol = selectSubprotocol(str2);
                if (selectSubprotocol != null) {
                    defaultFullHttpResponse.headers().add(asciiString, selectSubprotocol);
                } else if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Requested subprotocol(s) not supported: {}", str2);
                }
            }
            return defaultFullHttpResponse;
        }
        throw new WebSocketHandshakeException("not a WebSocket request: missing key");
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    protected b newWebSocketEncoder() {
        return new WebSocket08FrameEncoder(false);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    protected a newWebsocketDecoder() {
        return new WebSocket08FrameDecoder(decoderConfig());
    }

    public WebSocketServerHandshaker08(String str, String str2, boolean z, int i, boolean z2) {
        this(str, str2, WebSocketDecoderConfig.newBuilder().allowExtensions(z).maxFramePayloadLength(i).allowMaskMismatch(z2).build());
    }

    public WebSocketServerHandshaker08(String str, String str2, WebSocketDecoderConfig webSocketDecoderConfig) {
        super(WebSocketVersion.V08, str, str2, webSocketDecoderConfig);
    }
}
