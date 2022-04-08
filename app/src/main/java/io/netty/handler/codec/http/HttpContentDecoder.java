package io.netty.handler.codec.http;

import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class HttpContentDecoder extends MessageToMessageDecoder<HttpObject> {
    static final String IDENTITY = HttpHeaderValues.IDENTITY.toString();
    private boolean continueResponse;
    protected ChannelHandlerContext ctx;
    private EmbeddedChannel decoder;
    private boolean needRead = true;

    private void cleanup() {
        EmbeddedChannel embeddedChannel = this.decoder;
        if (embeddedChannel != null) {
            embeddedChannel.finishAndReleaseAll();
            this.decoder = null;
        }
    }

    private void cleanupSafely(ChannelHandlerContext channelHandlerContext) {
        try {
            cleanup();
        } catch (Throwable th) {
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    private void decodeContent(HttpContent httpContent, List<Object> list) {
        decode(httpContent.content(), list);
        if (httpContent instanceof LastHttpContent) {
            finishDecode(list);
            HttpHeaders trailingHeaders = ((LastHttpContent) httpContent).trailingHeaders();
            if (trailingHeaders.isEmpty()) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
            } else {
                list.add(new ComposedLastHttpContent(trailingHeaders, DecoderResult.SUCCESS));
            }
        }
    }

    private void fetchDecoderOutput(List<Object> list) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) this.decoder.readInbound();
            if (byteBuf != null) {
                if (!byteBuf.isReadable()) {
                    byteBuf.release();
                } else {
                    list.add(new DefaultHttpContent(byteBuf));
                }
            } else {
                return;
            }
        }
    }

    private void finishDecode(List<Object> list) {
        if (this.decoder.finish()) {
            fetchDecoderOutput(list);
        }
        this.decoder = null;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanupSafely(channelHandlerContext);
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        boolean z = this.needRead;
        this.needRead = true;
        try {
            channelHandlerContext.fireChannelReadComplete();
            if (!z) {
                return;
            }
        } finally {
            if (z && !channelHandlerContext.channel().config().isAutoRead()) {
                channelHandlerContext.read();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List list) throws Exception {
        decode2(channelHandlerContext, httpObject, (List<Object>) list);
    }

    protected String getTargetContentEncoding(String str) throws Exception {
        return IDENTITY;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanupSafely(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    protected abstract EmbeddedChannel newContentDecoder(String str) throws Exception;

    /* renamed from: decode  reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        String str;
        HttpMessage httpMessage;
        try {
            if ((httpObject instanceof HttpResponse) && ((HttpResponse) httpObject).status().code() == 100) {
                if (!(httpObject instanceof LastHttpContent)) {
                    this.continueResponse = true;
                }
                list.add(ReferenceCountUtil.retain(httpObject));
            } else if (this.continueResponse) {
                if (httpObject instanceof LastHttpContent) {
                    this.continueResponse = false;
                }
                list.add(ReferenceCountUtil.retain(httpObject));
            } else {
                if (httpObject instanceof HttpMessage) {
                    cleanup();
                    HttpMessage httpMessage2 = (HttpMessage) httpObject;
                    HttpHeaders headers = httpMessage2.headers();
                    AsciiString asciiString = HttpHeaderNames.CONTENT_ENCODING;
                    String str2 = headers.get(asciiString);
                    if (str2 != null) {
                        str = str2.trim();
                    } else {
                        String str3 = headers.get(HttpHeaderNames.TRANSFER_ENCODING);
                        if (str3 != null) {
                            int indexOf = str3.indexOf(SSLClient.COMMA);
                            if (indexOf != -1) {
                                str = str3.substring(0, indexOf).trim();
                            } else {
                                str = str3.trim();
                            }
                        } else {
                            str = IDENTITY;
                        }
                    }
                    EmbeddedChannel newContentDecoder = newContentDecoder(str);
                    this.decoder = newContentDecoder;
                    if (newContentDecoder == null) {
                        if (httpMessage2 instanceof HttpContent) {
                            ((HttpContent) httpMessage2).retain();
                        }
                        list.add(httpMessage2);
                    } else {
                        AsciiString asciiString2 = HttpHeaderNames.CONTENT_LENGTH;
                        if (headers.contains(asciiString2)) {
                            headers.remove(asciiString2);
                            headers.set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
                        }
                        String targetContentEncoding = getTargetContentEncoding(str);
                        if (HttpHeaderValues.IDENTITY.contentEquals(targetContentEncoding)) {
                            headers.remove(asciiString);
                        } else {
                            headers.set(asciiString, targetContentEncoding);
                        }
                        if (httpMessage2 instanceof HttpContent) {
                            if (httpMessage2 instanceof HttpRequest) {
                                HttpRequest httpRequest = (HttpRequest) httpMessage2;
                                httpMessage = new DefaultHttpRequest(httpRequest.protocolVersion(), httpRequest.method(), httpRequest.uri());
                            } else if (httpMessage2 instanceof HttpResponse) {
                                HttpResponse httpResponse = (HttpResponse) httpMessage2;
                                httpMessage = new DefaultHttpResponse(httpResponse.protocolVersion(), httpResponse.status());
                            } else {
                                throw new CodecException("Object of class " + httpMessage2.getClass().getName() + " is not an HttpRequest or HttpResponse");
                            }
                            httpMessage.headers().set(httpMessage2.headers());
                            httpMessage.setDecoderResult(httpMessage2.decoderResult());
                            list.add(httpMessage);
                        } else {
                            list.add(httpMessage2);
                        }
                    }
                }
                if (httpObject instanceof HttpContent) {
                    HttpContent httpContent = (HttpContent) httpObject;
                    if (this.decoder == null) {
                        list.add(httpContent.retain());
                    } else {
                        decodeContent(httpContent, list);
                    }
                }
            }
        } finally {
            this.needRead = list.isEmpty();
        }
    }

    private void decode(ByteBuf byteBuf, List<Object> list) {
        this.decoder.writeInbound(byteBuf.retain());
        fetchDecoderOutput(list);
    }
}
