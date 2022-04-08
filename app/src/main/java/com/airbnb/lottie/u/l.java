package com.airbnb.lottie.u;

import android.graphics.Color;
import androidx.annotation.IntRange;
import com.airbnb.lottie.model.content.c;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.v.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientColorParser.java */
/* loaded from: classes.dex */
public class l implements j0<c> {
    private int a;

    public l(int i) {
        this.a = i;
    }

    private void b(c cVar, List<Float> list) {
        int i = this.a * 4;
        if (list.size() > i) {
            int size = (list.size() - i) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i2 = 0;
            while (i < list.size()) {
                if (i % 2 == 0) {
                    dArr[i2] = list.get(i).floatValue();
                } else {
                    dArr2[i2] = list.get(i).floatValue();
                    i2++;
                }
                i++;
            }
            for (int i3 = 0; i3 < cVar.c(); i3++) {
                int i4 = cVar.a()[i3];
                cVar.a()[i3] = Color.argb(c(cVar.b()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
    }

    @IntRange(from = 0, to = 255)
    private int c(double d2, double[] dArr, double[] dArr2) {
        double d3;
        int i = 1;
        while (true) {
            if (i >= dArr.length) {
                d3 = dArr2[dArr2.length - 1];
                break;
            }
            int i2 = i - 1;
            double d4 = dArr[i2];
            double d5 = dArr[i];
            if (dArr[i] >= d2) {
                d3 = g.i(dArr2[i2], dArr2[i], (d2 - d4) / (d5 - d4));
                break;
            }
            i++;
        }
        return (int) (d3 * 255.0d);
    }

    /* renamed from: d */
    public c a(JsonReader jsonReader, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.w() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.c();
        }
        while (jsonReader.j()) {
            arrayList.add(Float.valueOf((float) jsonReader.l()));
        }
        if (z) {
            jsonReader.g();
        }
        if (this.a == -1) {
            this.a = arrayList.size() / 4;
        }
        int i = this.a;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.a * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = arrayList.get(i4).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        c cVar = new c(fArr, iArr);
        b(cVar, arrayList);
        return cVar;
    }
}
