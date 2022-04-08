package com.airbnb.lottie.u;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: PointFParser.java */
/* loaded from: classes.dex */
public class y implements j0<PointF> {
    public static final y a = new y();

    private y() {
    }

    /* renamed from: b */
    public PointF a(JsonReader jsonReader, float f2) throws IOException {
        JsonReader.Token w = jsonReader.w();
        if (w == JsonReader.Token.BEGIN_ARRAY) {
            return p.e(jsonReader, f2);
        }
        if (w == JsonReader.Token.BEGIN_OBJECT) {
            return p.e(jsonReader, f2);
        }
        if (w == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.l()) * f2, ((float) jsonReader.l()) * f2);
            while (jsonReader.j()) {
                jsonReader.A();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + w);
    }
}
