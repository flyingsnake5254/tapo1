package com.airbnb.lottie.v;

/* compiled from: GammaEvaluator.java */
/* loaded from: classes.dex */
public class b {
    private static float a(float f2) {
        return f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float b(float f2) {
        return f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow(f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float f2, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f3 = ((i >> 24) & 255) / 255.0f;
        float a = a(((i >> 16) & 255) / 255.0f);
        float a2 = a(((i >> 8) & 255) / 255.0f);
        float a3 = a((i & 255) / 255.0f);
        float a4 = a(((i2 >> 16) & 255) / 255.0f);
        float a5 = a(((i2 >> 8) & 255) / 255.0f);
        float a6 = a3 + (f2 * (a((i2 & 255) / 255.0f) - a3));
        return (Math.round(b(a + ((a4 - a) * f2)) * 255.0f) << 16) | (Math.round((f3 + (((((i2 >> 24) & 255) / 255.0f) - f3) * f2)) * 255.0f) << 24) | (Math.round(b(a2 + ((a5 - a2) * f2)) * 255.0f) << 8) | Math.round(b(a6) * 255.0f);
    }
}
