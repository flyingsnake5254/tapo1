package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class WebSocketClientExtensionHandler extends ChannelDuplexHandler {
    private final List<WebSocketClientExtensionHandshaker> extensionHandshakers;

    public WebSocketClientExtensionHandler(WebSocketClientExtensionHandshaker... webSocketClientExtensionHandshakerArr) {
        ObjectUtil.checkNotNull(webSocketClientExtensionHandshakerArr, "extensionHandshakers");
        if (webSocketClientExtensionHandshakerArr.length != 0) {
            this.extensionHandshakers = Arrays.asList(webSocketClientExtensionHandshakerArr);
            return;
        }
        throw new IllegalArgumentException("extensionHandshakers must contains at least one handshaker");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) obj;
            if (WebSocketExtensionUtil.isWebsocketUpgrade(httpResponse.headers())) {
                String asString = httpResponse.headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
                if (asString != null) {
                    List<WebSocketExtensionData> extractExtensions = WebSocketExtensionUtil.extractExtensions(asString);
                    ArrayList<a> arrayList = new ArrayList(extractExtensions.size());
                    int i = 0;
                    for (WebSocketExtensionData webSocketExtensionData : extractExtensions) {
                        Iterator<WebSocketClientExtensionHandshaker> it = this.extensionHandshakers.iterator();
                        a aVar = null;
                        while (aVar == null && it.hasNext()) {
                            aVar = it.next().handshakeExtension(webSocketExtensionData);
                        }
                        if (aVar == null || (aVar.rsv() & i) != 0) {
                            throw new CodecException("invalid WebSocket Extension handshake for \"" + asString + StringUtil.DOUBLE_QUOTE);
                        }
                        i |= aVar.rsv();
                        arrayList.add(aVar);
                    }
                    for (a aVar2 : arrayList) {
                        WebSocketExtensionDecoder newExtensionDecoder = aVar2.newExtensionDecoder();
                        WebSocketExtensionEncoder newExtensionEncoder = aVar2.newExtensionEncoder();
                        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), newExtensionDecoder.getClass().getName(), newExtensionDecoder);
                        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), newExtensionEncoder.getClass().getName(), newExtensionEncoder);
                    }
                }
                channelHandlerContext.pipeline().remove(channelHandlerContext.name());
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (obj instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) obj;
            if (WebSocketExtensionUtil.isWebsocketUpgrade(httpRequest.headers())) {
                String asString = httpRequest.headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
                for (WebSocketClientExtensionHandshaker webSocketClientExtensionHandshaker : this.extensionHandshakers) {
                    WebSocketExtensionData newRequestData = webSocketClientExtensionHandshaker.newRequestData();
                    asString = WebSocketExtensionUtil.appendExtension(asString, newRequestData.name(), newRequestData.parameters());
                }
                httpRequest.headers().set(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS, asString);
            }
        }
        super.write(channelHandlerContext, obj, channelPromise);
    }
}
