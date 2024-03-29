package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
public interface StompFrame extends StompHeadersSubframe, LastStompContentSubframe {
    StompFrame copy();

    StompFrame duplicate();

    StompFrame replace(ByteBuf byteBuf);

    StompFrame retain();

    StompFrame retain(int i);

    StompFrame retainedDuplicate();

    StompFrame touch();

    StompFrame touch(Object obj);
}
