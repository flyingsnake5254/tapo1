package com.airbnb.lottie.u;

import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.model.content.a;
import com.airbnb.lottie.model.i.f;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CircleShapeParser.java */
/* loaded from: classes.dex */
public class e {
    private static JsonReader.a a = JsonReader.a.a("nm", "p", "s", "hd", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(JsonReader jsonReader, d dVar, int i) throws IOException {
        boolean z = i == 3;
        String str = null;
        m<PointF, PointF> mVar = null;
        f fVar = null;
        boolean z2 = false;
        while (jsonReader.j()) {
            int y = jsonReader.y(a);
            if (y == 0) {
                str = jsonReader.u();
            } else if (y == 1) {
                mVar = a.b(jsonReader, dVar);
            } else if (y == 2) {
                fVar = d.i(jsonReader, dVar);
            } else if (y == 3) {
                z2 = jsonReader.k();
            } else if (y != 4) {
                jsonReader.z();
                jsonReader.A();
            } else {
                z = jsonReader.s() == 3;
            }
        }
        return new a(str, mVar, fVar, z, z2);
    }
}
