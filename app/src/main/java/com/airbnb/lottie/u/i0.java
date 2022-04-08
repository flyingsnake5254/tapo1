package com.airbnb.lottie.u;

import com.airbnb.lottie.d;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: ShapeTrimPathParser.java */
/* loaded from: classes.dex */
class i0 {
    private static JsonReader.a a = JsonReader.a.a("s", "e", "o", "nm", "m", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeTrimPath a(JsonReader jsonReader, d dVar) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        b bVar = null;
        b bVar2 = null;
        b bVar3 = null;
        boolean z = false;
        while (jsonReader.j()) {
            int y = jsonReader.y(a);
            if (y == 0) {
                bVar = d.f(jsonReader, dVar, false);
            } else if (y == 1) {
                bVar2 = d.f(jsonReader, dVar, false);
            } else if (y == 2) {
                bVar3 = d.f(jsonReader, dVar, false);
            } else if (y == 3) {
                str = jsonReader.u();
            } else if (y == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.s());
            } else if (y != 5) {
                jsonReader.A();
            } else {
                z = jsonReader.k();
            }
        }
        return new ShapeTrimPath(str, type, bVar, bVar2, bVar3, z);
    }
}
