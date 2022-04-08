package com.airbnb.lottie.u;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
class p {
    private static final JsonReader.a a = JsonReader.a.a("x", "y");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JsonUtils.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF a(JsonReader jsonReader, float f2) throws IOException {
        jsonReader.c();
        float l = (float) jsonReader.l();
        float l2 = (float) jsonReader.l();
        while (jsonReader.w() != JsonReader.Token.END_ARRAY) {
            jsonReader.A();
        }
        jsonReader.g();
        return new PointF(l * f2, l2 * f2);
    }

    private static PointF b(JsonReader jsonReader, float f2) throws IOException {
        float l = (float) jsonReader.l();
        float l2 = (float) jsonReader.l();
        while (jsonReader.j()) {
            jsonReader.A();
        }
        return new PointF(l * f2, l2 * f2);
    }

    private static PointF c(JsonReader jsonReader, float f2) throws IOException {
        jsonReader.e();
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (jsonReader.j()) {
            int y = jsonReader.y(a);
            if (y == 0) {
                f3 = g(jsonReader);
            } else if (y != 1) {
                jsonReader.z();
                jsonReader.A();
            } else {
                f4 = g(jsonReader);
            }
        }
        jsonReader.i();
        return new PointF(f3 * f2, f4 * f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ColorInt
    public static int d(JsonReader jsonReader) throws IOException {
        jsonReader.c();
        int l = (int) (jsonReader.l() * 255.0d);
        int l2 = (int) (jsonReader.l() * 255.0d);
        int l3 = (int) (jsonReader.l() * 255.0d);
        while (jsonReader.j()) {
            jsonReader.A();
        }
        jsonReader.g();
        return Color.argb(255, l, l2, l3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF e(JsonReader jsonReader, float f2) throws IOException {
        int i = a.a[jsonReader.w().ordinal()];
        if (i == 1) {
            return b(jsonReader, f2);
        }
        if (i == 2) {
            return a(jsonReader, f2);
        }
        if (i == 3) {
            return c(jsonReader, f2);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.w());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PointF> f(JsonReader jsonReader, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.c();
        while (jsonReader.w() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            arrayList.add(e(jsonReader, f2));
            jsonReader.g();
        }
        jsonReader.g();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float g(JsonReader jsonReader) throws IOException {
        JsonReader.Token w = jsonReader.w();
        int i = a.a[w.ordinal()];
        if (i == 1) {
            return (float) jsonReader.l();
        }
        if (i == 2) {
            jsonReader.c();
            float l = (float) jsonReader.l();
            while (jsonReader.j()) {
                jsonReader.A();
            }
            jsonReader.g();
            return l;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + w);
    }
}
