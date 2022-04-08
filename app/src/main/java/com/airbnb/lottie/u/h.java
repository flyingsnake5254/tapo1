package com.airbnb.lottie.u;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: DocumentDataParser.java */
/* loaded from: classes.dex */
public class h implements j0<DocumentData> {
    public static final h a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f1138b = JsonReader.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private h() {
    }

    /* renamed from: b */
    public DocumentData a(JsonReader jsonReader, float f2) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.e();
        String str = null;
        DocumentData.Justification justification2 = justification;
        String str2 = null;
        float f3 = 0.0f;
        int i = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f6 = 0.0f;
        boolean z = true;
        while (jsonReader.j()) {
            switch (jsonReader.y(f1138b)) {
                case 0:
                    str = jsonReader.u();
                    break;
                case 1:
                    str2 = jsonReader.u();
                    break;
                case 2:
                    f3 = (float) jsonReader.l();
                    break;
                case 3:
                    int s = jsonReader.s();
                    justification2 = DocumentData.Justification.CENTER;
                    if (s <= justification2.ordinal() && s >= 0) {
                        justification2 = DocumentData.Justification.values()[s];
                        break;
                    }
                    break;
                case 4:
                    i = jsonReader.s();
                    break;
                case 5:
                    f4 = (float) jsonReader.l();
                    break;
                case 6:
                    f5 = (float) jsonReader.l();
                    break;
                case 7:
                    i2 = p.d(jsonReader);
                    break;
                case 8:
                    i3 = p.d(jsonReader);
                    break;
                case 9:
                    f6 = (float) jsonReader.l();
                    break;
                case 10:
                    z = jsonReader.k();
                    break;
                default:
                    jsonReader.z();
                    jsonReader.A();
                    break;
            }
        }
        jsonReader.i();
        return new DocumentData(str, str2, f3, justification2, i, f4, f5, i2, i3, f6, z);
    }
}
