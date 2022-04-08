package io.netty.handler.codec.stomp;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
public class DefaultStompHeadersSubframe implements StompHeadersSubframe {
    protected final StompCommand command;
    protected DecoderResult decoderResult;
    protected final DefaultStompHeaders headers;

    public DefaultStompHeadersSubframe(StompCommand stompCommand) {
        this(stompCommand, null);
    }

    @Override // io.netty.handler.codec.stomp.StompHeadersSubframe
    public StompCommand command() {
        return this.command;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    @Override // io.netty.handler.codec.stomp.StompHeadersSubframe
    public StompHeaders headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public void setDecoderResult(DecoderResult decoderResult) {
        this.decoderResult = decoderResult;
    }

    public String toString() {
        return "StompFrame{command=" + this.command + ", headers=" + this.headers + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultStompHeadersSubframe(StompCommand stompCommand, DefaultStompHeaders defaultStompHeaders) {
        this.decoderResult = DecoderResult.SUCCESS;
        this.command = (StompCommand) ObjectUtil.checkNotNull(stompCommand, "command");
        this.headers = defaultStompHeaders == null ? new DefaultStompHeaders() : defaultStompHeaders;
    }
}
