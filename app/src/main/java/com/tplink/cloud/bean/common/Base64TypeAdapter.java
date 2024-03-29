package com.tplink.cloud.bean.common;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import java.io.IOException;

/* loaded from: classes2.dex */
public class Base64TypeAdapter extends TypeAdapter<String> {
    @Override // com.google.gson.TypeAdapter
    public String read(a aVar) throws IOException {
        return b.d.w.h.a.a(aVar.E());
    }

    public void write(b bVar, String str) throws IOException {
        if (str != null) {
            bVar.J(b.d.w.h.a.b(str));
        }
    }
}
