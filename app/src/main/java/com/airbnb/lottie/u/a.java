package com.airbnb.lottie.u;

import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.e;
import com.airbnb.lottie.model.i.i;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.v.h;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: AnimatablePathValueParser.java */
/* loaded from: classes.dex */
public class a {
    private static JsonReader.a a = JsonReader.a.a("k", "x", "y");

    public static e a(JsonReader jsonReader, d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.w() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            while (jsonReader.j()) {
                arrayList.add(w.a(jsonReader, dVar));
            }
            jsonReader.g();
            r.b(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.w.a(p.e(jsonReader, h.e())));
        }
        return new e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m<PointF, PointF> b(JsonReader jsonReader, d dVar) throws IOException {
        jsonReader.e();
        e eVar = null;
        b bVar = null;
        b bVar2 = null;
        boolean z = false;
        while (jsonReader.w() != JsonReader.Token.END_OBJECT) {
            int y = jsonReader.y(a);
            if (y == 0) {
                eVar = a(jsonReader, dVar);
            } else if (y != 1) {
                if (y != 2) {
                    jsonReader.z();
                    jsonReader.A();
                } else if (jsonReader.w() == JsonReader.Token.STRING) {
                    jsonReader.A();
                    z = true;
                } else {
                    bVar2 = d.e(jsonReader, dVar);
                }
            } else if (jsonReader.w() == JsonReader.Token.STRING) {
                jsonReader.A();
                z = true;
            } else {
                bVar = d.e(jsonReader, dVar);
            }
        }
        jsonReader.i();
        if (z) {
            dVar.a("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new i(bVar, bVar2);
    }
}
