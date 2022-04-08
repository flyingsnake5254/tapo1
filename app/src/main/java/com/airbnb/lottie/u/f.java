package com.airbnb.lottie.u;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: ColorParser.java */
/* loaded from: classes.dex */
public class f implements j0<Integer> {
    public static final f a = new f();

    private f() {
    }

    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f2) throws IOException {
        boolean z = jsonReader.w() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.c();
        }
        double l = jsonReader.l();
        double l2 = jsonReader.l();
        double l3 = jsonReader.l();
        double l4 = jsonReader.l();
        if (z) {
            jsonReader.g();
        }
        if (l <= 1.0d && l2 <= 1.0d && l3 <= 1.0d) {
            l *= 255.0d;
            l2 *= 255.0d;
            l3 *= 255.0d;
            if (l4 <= 1.0d) {
                l4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) l4, (int) l, (int) l2, (int) l3));
    }
}
