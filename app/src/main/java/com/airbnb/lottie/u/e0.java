package com.airbnb.lottie.u;

import android.graphics.Path;
import com.airbnb.lottie.d;
import com.airbnb.lottie.model.content.i;
import com.airbnb.lottie.model.i.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.tplink.iot.Utils.hls.c;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeFillParser.java */
/* loaded from: classes.dex */
public class e0 {
    private static final JsonReader.a a = JsonReader.a.a("nm", c.n, "o", "fillEnabled", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i a(JsonReader jsonReader, d dVar) throws IOException {
        String str = null;
        a aVar = null;
        com.airbnb.lottie.model.i.d dVar2 = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.j()) {
            int y = jsonReader.y(a);
            if (y == 0) {
                str = jsonReader.u();
            } else if (y == 1) {
                aVar = d.c(jsonReader, dVar);
            } else if (y == 2) {
                dVar2 = d.h(jsonReader, dVar);
            } else if (y == 3) {
                z = jsonReader.k();
            } else if (y == 4) {
                i = jsonReader.s();
            } else if (y != 5) {
                jsonReader.z();
                jsonReader.A();
            } else {
                z2 = jsonReader.k();
            }
        }
        return new i(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar2, z2);
    }
}
