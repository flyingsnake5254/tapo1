package com.airbnb.lottie.u;

import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.model.content.f;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RectangleShapeParser.java */
/* loaded from: classes.dex */
public class a0 {
    private static JsonReader.a a = JsonReader.a.a("nm", "p", "s", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f a(JsonReader jsonReader, d dVar) throws IOException {
        String str = null;
        m<PointF, PointF> mVar = null;
        com.airbnb.lottie.model.i.f fVar = null;
        b bVar = null;
        boolean z = false;
        while (jsonReader.j()) {
            int y = jsonReader.y(a);
            if (y == 0) {
                str = jsonReader.u();
            } else if (y == 1) {
                mVar = a.b(jsonReader, dVar);
            } else if (y == 2) {
                fVar = d.i(jsonReader, dVar);
            } else if (y == 3) {
                bVar = d.e(jsonReader, dVar);
            } else if (y != 4) {
                jsonReader.A();
            } else {
                z = jsonReader.k();
            }
        }
        return new f(str, mVar, fVar, bVar, z);
    }
}
