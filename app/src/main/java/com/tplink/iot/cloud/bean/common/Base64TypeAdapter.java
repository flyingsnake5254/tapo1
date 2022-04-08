package com.tplink.iot.cloud.bean.common;

import b.d.w.h.b;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.a;
import java.io.IOException;

/* loaded from: classes2.dex */
public class Base64TypeAdapter extends TypeAdapter<String> {
    @Override // com.google.gson.TypeAdapter
    public String read(a aVar) throws IOException {
        String E = aVar.E();
        if (b.d(E) || E.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$")) {
            return b.d.w.h.a.a(E);
        }
        b.d.w.c.a.m("Attention!!! illegal base64 string");
        return E;
    }

    public void write(com.google.gson.stream.b bVar, String str) throws IOException {
        if (str != null) {
            bVar.J(b.d.w.h.a.b(str));
        }
    }
}
