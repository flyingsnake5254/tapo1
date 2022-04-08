package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class WebSocketServerExtensionHandler extends ChannelDuplexHandler {
    private final List<WebSocketServerExtensionHandshaker> extensionHandshakers;
    private List<WebSocketServerExtension> validExtensions;

    public WebSocketServerExtensionHandler(WebSocketServerExtensionHandshaker... webSocketServerExtensionHandshakerArr) {
        ObjectUtil.checkNotNull(webSocketServerExtensionHandshakerArr, "extensionHandshakers");
        if (webSocketServerExtensionHandshakerArr.length != 0) {
            this.extensionHandshakers = Arrays.asList(webSocketServerExtensionHandshakerArr);
            return;
        }
        throw new IllegalArgumentException("extensionHandshakers must contains at least one handshaker");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        String asString;
        if (obj instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) obj;
            if (WebSocketExtensionUtil.isWebsocketUpgrade(httpRequest.headers()) && (asString = httpRequest.headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS)) != null) {
                int i = 0;
                for (WebSocketExtensionData webSocketExtensionData : WebSocketExtensionUtil.extractExtensions(asString)) {
                    Iterator<WebSocketServerExtensionHandshaker> it = this.extensionHandshakers.iterator();
                    WebSocketServerExtension webSocketServerExtension = null;
                    while (webSocketServerExtension == null && it.hasNext()) {
                        webSocketServerExtension = it.next().handshakeExtension(webSocketExtensionData);
                    }
                    if (webSocketServerExtension != null && (webSocketServerExtension.rsv() & i) == 0) {
                        if (this.validExtensions == null) {
                            this.validExtensions = new ArrayList(1);
                        }
                        i |= webSocketServerExtension.rsv();
                        this.validExtensions.add(webSocketServerExtension);
                    }
                }
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(final ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (obj instanceof HttpResponse) {
            HttpHeaders headers = ((HttpResponse) obj).headers();
            if (WebSocketExtensionUtil.isWebsocketUpgrade(headers)) {
                if (this.validExtensions != null) {
                    String asString = headers.getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
                    for (WebSocketServerExtension webSocketServerExtension : this.validExtensions) {
                        WebSocketExtensionData newReponseData = webSocketServerExtension.newReponseData();
                        asString = WebSocketExtensionUtil.appendExtension(asString, newReponseData.name(), newReponseData.parameters());
                    }
                    channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandler.1
                        public void operationComplete(ChannelFuture channelFuture) {
                            if (channelFuture.isSuccess()) {
                                for (WebSocketServerExtension webSocketServerExtension2 : WebSocketServerExtensionHandler.this.validExtensions) {
                                    WebSocketExtensionDecoder newExtensionDecoder = webSocketServerExtension2.newExtensionDecoder();
                                    WebSocketExtensionEncoder newExtensionEncoder = webSocketServerExtension2.newExtensionEncoder();
                                    channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), newExtensionDecoder.getClass().getName(), newExtensionDecoder).addAfter(channelHandlerContext.name(), newExtensionEncoder.getClass().getName(), newExtensionEncoder);
                                }
                            }
                        }
                    });
                    if (asString != null) {
                        headers.set(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS, asString);
                    }
                }
                channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandler.2
                    public void operationComplete(ChannelFuture channelFuture) {
                        if (channelFuture.isSuccess()) {
                            channelHandlerContext.pipeline().remove(WebSocketServerExtensionHandler.this);
                        }
                    }
                });
            }
        }
        super.write(channelHandlerContext, obj, channelPromise);
    }
}
