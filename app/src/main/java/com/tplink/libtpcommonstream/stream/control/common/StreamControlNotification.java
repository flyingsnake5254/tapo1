package com.tplink.libtpcommonstream.stream.control.common;

import com.google.gson.q.a;
import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class StreamControlNotification<T> {
    @c("event_type")
    private String eventType;
    @a(deserialize = false, serialize = false)
    private T result;

    public StreamControlNotification() {
    }

    public String getEventType() {
        return this.eventType;
    }

    public T getResult() {
        return this.result;
    }

    public void setEventType(String str) {
        this.eventType = str;
    }

    public void setResult(T t) {
        this.result = t;
    }

    public StreamControlNotification(String str, T t) {
        this.eventType = str;
        this.result = t;
    }
}
