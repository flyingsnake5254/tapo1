package com.airbnb.lottie.u;

import com.airbnb.lottie.model.b;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: FontParser.java */
/* loaded from: classes.dex */
class k {
    private static final JsonReader.a a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(JsonReader jsonReader) throws IOException {
        jsonReader.e();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f2 = 0.0f;
        while (jsonReader.j()) {
            int y = jsonReader.y(a);
            if (y == 0) {
                str = jsonReader.u();
            } else if (y == 1) {
                str2 = jsonReader.u();
            } else if (y == 2) {
                str3 = jsonReader.u();
            } else if (y != 3) {
                jsonReader.z();
                jsonReader.A();
            } else {
                f2 = (float) jsonReader.l();
            }
        }
        jsonReader.i();
        return new b(str, str2, str3, f2);
    }
}
