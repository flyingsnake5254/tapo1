package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider;
import io.netty.handler.codec.http.websocketx.extensions.a;
import io.netty.util.internal.ObjectUtil;
import java.util.Collections;

/* loaded from: classes3.dex */
public final class DeflateFrameClientExtensionHandshaker implements WebSocketClientExtensionHandshaker {
    private final int compressionLevel;
    private final WebSocketExtensionFilterProvider extensionFilterProvider;
    private final boolean useWebkitExtensionName;

    /* loaded from: classes3.dex */
    private static class DeflateFrameClientExtension implements a {
        private final int compressionLevel;
        private final WebSocketExtensionFilterProvider extensionFilterProvider;

        DeflateFrameClientExtension(int i, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
            this.compressionLevel = i;
            this.extensionFilterProvider = webSocketExtensionFilterProvider;
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionDecoder newExtensionDecoder() {
            return new PerFrameDeflateDecoder(false, this.extensionFilterProvider.decoderFilter());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionEncoder newExtensionEncoder() {
            return new PerFrameDeflateEncoder(this.compressionLevel, 15, false, this.extensionFilterProvider.encoderFilter());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public int rsv() {
            return 4;
        }
    }

    public DeflateFrameClientExtensionHandshaker(boolean z) {
        this(6, z);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker
    public a handshakeExtension(WebSocketExtensionData webSocketExtensionData) {
        if (("x-webkit-deflate-frame".equals(webSocketExtensionData.name()) || "deflate-frame".equals(webSocketExtensionData.name())) && webSocketExtensionData.parameters().isEmpty()) {
            return new DeflateFrameClientExtension(this.compressionLevel, this.extensionFilterProvider);
        }
        return null;
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker
    public WebSocketExtensionData newRequestData() {
        return new WebSocketExtensionData(this.useWebkitExtensionName ? "x-webkit-deflate-frame" : "deflate-frame", Collections.emptyMap());
    }

    public DeflateFrameClientExtensionHandshaker(int i, boolean z) {
        this(i, z, WebSocketExtensionFilterProvider.DEFAULT);
    }

    public DeflateFrameClientExtensionHandshaker(int i, boolean z, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i + " (expected: 0-9)");
        }
        this.compressionLevel = i;
        this.useWebkitExtensionName = z;
        this.extensionFilterProvider = (WebSocketExtensionFilterProvider) ObjectUtil.checkNotNull(webSocketExtensionFilterProvider, "extensionFilterProvider");
    }
}
