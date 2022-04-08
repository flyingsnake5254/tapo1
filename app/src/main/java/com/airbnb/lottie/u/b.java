package com.airbnb.lottie.u;

import com.airbnb.lottie.d;
import com.airbnb.lottie.model.i.a;
import com.airbnb.lottie.model.i.k;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: AnimatableTextPropertiesParser.java */
/* loaded from: classes.dex */
public class b {
    private static JsonReader.a a = JsonReader.a.a("a");

    /* renamed from: b  reason: collision with root package name */
    private static JsonReader.a f1135b = JsonReader.a.a("fc", "sc", "sw", "t");

    public static k a(JsonReader jsonReader, d dVar) throws IOException {
        jsonReader.e();
        k kVar = null;
        while (jsonReader.j()) {
            if (jsonReader.y(a) != 0) {
                jsonReader.z();
                jsonReader.A();
            } else {
                kVar = b(jsonReader, dVar);
            }
        }
        jsonReader.i();
        return kVar == null ? new k(null, null, null, null) : kVar;
    }

    private static k b(JsonReader jsonReader, d dVar) throws IOException {
        jsonReader.e();
        a aVar = null;
        a aVar2 = null;
        com.airbnb.lottie.model.i.b bVar = null;
        com.airbnb.lottie.model.i.b bVar2 = null;
        while (jsonReader.j()) {
            int y = jsonReader.y(f1135b);
            if (y == 0) {
                aVar = d.c(jsonReader, dVar);
            } else if (y == 1) {
                aVar2 = d.c(jsonReader, dVar);
            } else if (y == 2) {
                bVar = d.e(jsonReader, dVar);
            } else if (y != 3) {
                jsonReader.z();
                jsonReader.A();
            } else {
                bVar2 = d.e(jsonReader, dVar);
            }
        }
        jsonReader.i();
        return new k(aVar, aVar2, bVar, bVar2);
    }
}
