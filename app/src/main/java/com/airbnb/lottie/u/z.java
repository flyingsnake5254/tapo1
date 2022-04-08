package com.airbnb.lottie.u;

import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PolystarShapeParser.java */
/* loaded from: classes.dex */
public class z {
    private static final JsonReader.a a = JsonReader.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PolystarShape a(JsonReader jsonReader, d dVar) throws IOException {
        String str = null;
        PolystarShape.Type type = null;
        b bVar = null;
        m<PointF, PointF> mVar = null;
        b bVar2 = null;
        b bVar3 = null;
        b bVar4 = null;
        b bVar5 = null;
        b bVar6 = null;
        boolean z = false;
        while (jsonReader.j()) {
            switch (jsonReader.y(a)) {
                case 0:
                    str = jsonReader.u();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.s());
                    break;
                case 2:
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 3:
                    mVar = a.b(jsonReader, dVar);
                    break;
                case 4:
                    bVar2 = d.f(jsonReader, dVar, false);
                    break;
                case 5:
                    bVar4 = d.e(jsonReader, dVar);
                    break;
                case 6:
                    bVar6 = d.f(jsonReader, dVar, false);
                    break;
                case 7:
                    bVar3 = d.e(jsonReader, dVar);
                    break;
                case 8:
                    bVar5 = d.f(jsonReader, dVar, false);
                    break;
                case 9:
                    z = jsonReader.k();
                    break;
                default:
                    jsonReader.z();
                    jsonReader.A();
                    break;
            }
        }
        return new PolystarShape(str, type, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6, z);
    }
}
