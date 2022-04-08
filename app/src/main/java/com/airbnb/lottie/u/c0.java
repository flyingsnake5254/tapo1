package com.airbnb.lottie.u;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.w.d;
import java.io.IOException;

/* compiled from: ScaleXYParser.java */
/* loaded from: classes.dex */
public class c0 implements j0<d> {
    public static final c0 a = new c0();

    private c0() {
    }

    /* renamed from: b */
    public d a(JsonReader jsonReader, float f2) throws IOException {
        boolean z = jsonReader.w() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.c();
        }
        float l = (float) jsonReader.l();
        float l2 = (float) jsonReader.l();
        while (jsonReader.j()) {
            jsonReader.A();
        }
        if (z) {
            jsonReader.g();
        }
        return new d((l / 100.0f) * f2, (l2 / 100.0f) * f2);
    }
}
