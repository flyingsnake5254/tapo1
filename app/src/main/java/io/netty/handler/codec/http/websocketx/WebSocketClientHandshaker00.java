package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import java.net.URI;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class WebSocketClientHandshaker00 extends WebSocketClientHandshaker {
    private static final AsciiString WEBSOCKET = AsciiString.cached(HttpHeaders.Values.WEBSOCKET);
    private ByteBuf expectedChallengeResponseBytes;

    public WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i) {
        this(uri, webSocketVersion, str, httpHeaders, i, 10000L);
    }

    private static String insertRandomCharacters(String str) {
        int randomNumber = WebSocketUtil.randomNumber(1, 12);
        char[] cArr = new char[randomNumber];
        int i = 0;
        while (i < randomNumber) {
            int random = (int) ((Math.random() * 126.0d) + 33.0d);
            if ((33 < random && random < 47) || (58 < random && random < 126)) {
                cArr[i] = (char) random;
                i++;
            }
        }
        for (int i2 = 0; i2 < randomNumber; i2++) {
            int randomNumber2 = WebSocketUtil.randomNumber(0, str.length());
            str = str.substring(0, randomNumber2) + cArr[i2] + str.substring(randomNumber2);
        }
        return str;
    }

    private static String insertSpaces(String str, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int randomNumber = WebSocketUtil.randomNumber(1, str.length() - 1);
            str = str.substring(0, randomNumber) + ' ' + str.substring(randomNumber);
        }
        return str;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected FullHttpRequest newHandshakeRequest() {
        int randomNumber = WebSocketUtil.randomNumber(1, 12);
        int randomNumber2 = WebSocketUtil.randomNumber(1, 12);
        int randomNumber3 = WebSocketUtil.randomNumber(0, Integer.MAX_VALUE / randomNumber);
        int randomNumber4 = WebSocketUtil.randomNumber(0, Integer.MAX_VALUE / randomNumber2);
        String num = Integer.toString(randomNumber3 * randomNumber);
        String num2 = Integer.toString(randomNumber4 * randomNumber2);
        String insertRandomCharacters = insertRandomCharacters(num);
        String insertRandomCharacters2 = insertRandomCharacters(num2);
        String insertSpaces = insertSpaces(insertRandomCharacters, randomNumber);
        String insertSpaces2 = insertSpaces(insertRandomCharacters2, randomNumber2);
        byte[] randomBytes = WebSocketUtil.randomBytes(8);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(randomNumber3);
        byte[] array = allocate.array();
        ByteBuffer allocate2 = ByteBuffer.allocate(4);
        allocate2.putInt(randomNumber4);
        byte[] array2 = allocate2.array();
        byte[] bArr = new byte[16];
        System.arraycopy(array, 0, bArr, 0, 4);
        System.arraycopy(array2, 0, bArr, 4, 4);
        System.arraycopy(randomBytes, 0, bArr, 8, 8);
        this.expectedChallengeResponseBytes = Unpooled.wrappedBuffer(WebSocketUtil.md5(bArr));
        URI uri = uri();
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, upgradeUrl(uri), Unpooled.wrappedBuffer(randomBytes));
        HttpHeaders headers = defaultFullHttpRequest.headers();
        HttpHeaders httpHeaders = this.customHeaders;
        if (httpHeaders != null) {
            headers.add(httpHeaders);
        }
        headers.set(HttpHeaderNames.UPGRADE, WEBSOCKET).set(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE).set(HttpHeaderNames.HOST, WebSocketClientHandshaker.websocketHostValue(uri)).set(HttpHeaderNames.SEC_WEBSOCKET_KEY1, insertSpaces).set(HttpHeaderNames.SEC_WEBSOCKET_KEY2, insertSpaces2);
        AsciiString asciiString = HttpHeaderNames.ORIGIN;
        if (!headers.contains(asciiString)) {
            headers.set(asciiString, WebSocketClientHandshaker.websocketOriginValue(uri));
        }
        String expectedSubprotocol = expectedSubprotocol();
        if (expectedSubprotocol != null && !expectedSubprotocol.isEmpty()) {
            headers.set(HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL, expectedSubprotocol);
        }
        headers.set(HttpHeaderNames.CONTENT_LENGTH, Integer.valueOf(randomBytes.length));
        return defaultFullHttpRequest;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected b newWebSocketEncoder() {
        return new WebSocket00FrameEncoder();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected a newWebsocketDecoder() {
        return new WebSocket00FrameDecoder(maxFramePayloadLength());
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected void verify(FullHttpResponse fullHttpResponse) {
        if (fullHttpResponse.status().equals(HttpResponseStatus.SWITCHING_PROTOCOLS)) {
            HttpHeaders headers = fullHttpResponse.headers();
            String str = headers.get(HttpHeaderNames.UPGRADE);
            if (WEBSOCKET.contentEqualsIgnoreCase(str)) {
                AsciiString asciiString = HttpHeaderNames.CONNECTION;
                if (!headers.containsValue(asciiString, HttpHeaderValues.UPGRADE, true)) {
                    throw new WebSocketHandshakeException("Invalid handshake response connection: " + headers.get(asciiString));
                } else if (!fullHttpResponse.content().equals(this.expectedChallengeResponseBytes)) {
                    throw new WebSocketHandshakeException("Invalid challenge");
                }
            } else {
                throw new WebSocketHandshakeException("Invalid handshake response upgrade: " + ((Object) str));
            }
        } else {
            throw new WebSocketHandshakeException("Invalid handshake response getStatus: " + fullHttpResponse.status());
        }
    }

    public WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i, long j) {
        this(uri, webSocketVersion, str, httpHeaders, i, j, false);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public WebSocketClientHandshaker00 setForceCloseTimeoutMillis(long j) {
        super.setForceCloseTimeoutMillis(j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i, long j, boolean z) {
        super(uri, webSocketVersion, str, httpHeaders, i, j, z);
    }
}
