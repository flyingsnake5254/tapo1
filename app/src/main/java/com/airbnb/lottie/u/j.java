package com.airbnb.lottie.u;

import com.airbnb.lottie.d;
import com.airbnb.lottie.model.c;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.github.mikephil.charting.utils.Utils;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontCharacterParser.java */
/* loaded from: classes.dex */
public class j {
    private static final JsonReader.a a = JsonReader.a.a("ch", "size", "w", "style", "fFamily", Constants.ScionAnalytics.MessageType.DATA_MESSAGE);

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f1140b = JsonReader.a.a("shapes");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(JsonReader jsonReader, d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.e();
        String str = null;
        double d2 = Utils.DOUBLE_EPSILON;
        String str2 = null;
        double d3 = 0.0d;
        char c2 = 0;
        while (jsonReader.j()) {
            int y = jsonReader.y(a);
            if (y == 0) {
                c2 = jsonReader.u().charAt(0);
            } else if (y == 1) {
                d2 = jsonReader.l();
            } else if (y == 2) {
                d3 = jsonReader.l();
            } else if (y == 3) {
                str = jsonReader.u();
            } else if (y == 4) {
                str2 = jsonReader.u();
            } else if (y != 5) {
                jsonReader.z();
                jsonReader.A();
            } else {
                jsonReader.e();
                while (jsonReader.j()) {
                    if (jsonReader.y(f1140b) != 0) {
                        jsonReader.z();
                        jsonReader.A();
                    } else {
                        jsonReader.c();
                        while (jsonReader.j()) {
                            arrayList.add((com.airbnb.lottie.model.content.j) g.a(jsonReader, dVar));
                        }
                        jsonReader.g();
                    }
                }
                jsonReader.i();
            }
        }
        jsonReader.i();
        return new c(arrayList, c2, d2, d3, str, str2);
    }
}
