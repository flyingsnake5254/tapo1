package com.airbnb.lottie.u;

import com.airbnb.lottie.d;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.e;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.c;
import com.airbnb.lottie.model.i.f;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientStrokeParser.java */
/* loaded from: classes.dex */
public class n {
    private static JsonReader.a a = JsonReader.a.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f1142b = JsonReader.a.a("p", "k");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.a f1143c = JsonReader.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(JsonReader jsonReader, d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType = null;
        c cVar = null;
        com.airbnb.lottie.model.i.d dVar2 = null;
        f fVar = null;
        f fVar2 = null;
        b bVar = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f2 = 0.0f;
        b bVar2 = null;
        boolean z = false;
        while (jsonReader.j()) {
            switch (jsonReader.y(a)) {
                case 0:
                    str = jsonReader.u();
                    break;
                case 1:
                    int i = -1;
                    jsonReader.e();
                    while (jsonReader.j()) {
                        int y = jsonReader.y(f1142b);
                        if (y != 0) {
                            cVar = cVar;
                            if (y != 1) {
                                jsonReader.z();
                                jsonReader.A();
                            } else {
                                cVar = d.g(jsonReader, dVar, i);
                            }
                        } else {
                            cVar = cVar;
                            i = jsonReader.s();
                        }
                    }
                    jsonReader.i();
                    break;
                case 2:
                    dVar2 = d.h(jsonReader, dVar);
                    break;
                case 3:
                    gradientType = jsonReader.s() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    fVar = d.i(jsonReader, dVar);
                    break;
                case 5:
                    fVar2 = d.i(jsonReader, dVar);
                    break;
                case 6:
                    bVar = d.e(jsonReader, dVar);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.s() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.s() - 1];
                    break;
                case 9:
                    f2 = (float) jsonReader.l();
                    break;
                case 10:
                    z = jsonReader.k();
                    break;
                case 11:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        jsonReader.e();
                        String str2 = null;
                        b bVar3 = null;
                        while (jsonReader.j()) {
                            int y2 = jsonReader.y(f1143c);
                            if (y2 != 0) {
                                if (y2 != 1) {
                                    jsonReader.z();
                                    jsonReader.A();
                                } else {
                                    bVar3 = d.e(jsonReader, dVar);
                                }
                                bVar2 = bVar2;
                            } else {
                                str2 = jsonReader.u();
                            }
                        }
                        jsonReader.i();
                        if (str2.equals("o")) {
                            bVar2 = bVar3;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                dVar.t(true);
                                arrayList.add(bVar3);
                            }
                            bVar2 = bVar2;
                        }
                    }
                    jsonReader.g();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar2 = bVar2;
                    break;
                default:
                    jsonReader.z();
                    jsonReader.A();
                    break;
            }
        }
        return new e(str, gradientType, cVar, dVar2, fVar, fVar2, bVar, lineCapType, lineJoinType, f2, arrayList, bVar2, z);
    }
}
