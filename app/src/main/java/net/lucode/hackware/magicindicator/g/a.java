package net.lucode.hackware.magicindicator.g;

/* compiled from: ArgbEvaluatorHolder.java */
/* loaded from: classes4.dex */
public class a {
    public static int a(float f2, int i, int i2) {
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return ((i3 + ((int) ((((i2 >> 24) & 255) - i3) * f2))) << 24) | ((i4 + ((int) ((((i2 >> 16) & 255) - i4) * f2))) << 16) | ((i5 + ((int) ((((i2 >> 8) & 255) - i5) * f2))) << 8) | (i6 + ((int) (f2 * ((i2 & 255) - i6))));
    }
}
