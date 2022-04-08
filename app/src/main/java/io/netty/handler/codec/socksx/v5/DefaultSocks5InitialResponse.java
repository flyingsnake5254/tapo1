package io.netty.handler.codec.socksx.v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* loaded from: classes3.dex */
public class DefaultSocks5InitialResponse extends AbstractSocks5Message implements Socks5InitialResponse {
    private final Socks5AuthMethod authMethod;

    public DefaultSocks5InitialResponse(Socks5AuthMethod socks5AuthMethod) {
        this.authMethod = (Socks5AuthMethod) ObjectUtil.checkNotNull(socks5AuthMethod, "authMethod");
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5InitialResponse
    public Socks5AuthMethod authMethod() {
        return this.authMethod;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (!decoderResult.isSuccess()) {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", authMethod: ");
        } else {
            sb.append("(authMethod: ");
        }
        sb.append(authMethod());
        sb.append(')');
        return sb.toString();
    }
}
