package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
/* loaded from: classes.dex */
public class TextBlock implements Text {
    private Point[] cornerPoints;
    private zzah[] zzei;
    private List<Line> zzej;
    private String zzek;
    private Rect zzel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextBlock(SparseArray<zzah> sparseArray) {
        this.zzei = new zzah[sparseArray.size()];
        int i = 0;
        while (true) {
            zzah[] zzahVarArr = this.zzei;
            if (i < zzahVarArr.length) {
                zzahVarArr[i] = sparseArray.valueAt(i);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.gms.vision.text.Text
    public Rect getBoundingBox() {
        if (this.zzel == null) {
            this.zzel = zzc.zza(this);
        }
        return this.zzel;
    }

    @Override // com.google.android.gms.vision.text.Text
    public List<? extends Text> getComponents() {
        if (this.zzei.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzej == null) {
            this.zzej = new ArrayList(this.zzei.length);
            for (zzah zzahVar : this.zzei) {
                this.zzej.add(new Line(zzahVar));
            }
        }
        return this.zzej;
    }

    @Override // com.google.android.gms.vision.text.Text
    public Point[] getCornerPoints() {
        TextBlock textBlock;
        zzah[] zzahVarArr;
        TextBlock textBlock2 = this;
        if (textBlock2.cornerPoints == null) {
            char c2 = 0;
            if (textBlock2.zzei.length == 0) {
                textBlock2.cornerPoints = new Point[0];
            } else {
                int i = Integer.MIN_VALUE;
                int i2 = Integer.MIN_VALUE;
                int i3 = Integer.MAX_VALUE;
                int i4 = Integer.MAX_VALUE;
                int i5 = 0;
                while (true) {
                    zzahVarArr = textBlock2.zzei;
                    if (i5 >= zzahVarArr.length) {
                        break;
                    }
                    zzab zzabVar = zzahVarArr[i5].zzeq;
                    zzab zzabVar2 = zzahVarArr[c2].zzeq;
                    double sin = Math.sin(Math.toRadians(zzabVar2.zzeo));
                    double cos = Math.cos(Math.toRadians(zzabVar2.zzeo));
                    Point[] pointArr = new Point[4];
                    pointArr[c2] = new Point(zzabVar.left, zzabVar.top);
                    pointArr[c2].offset(-zzabVar2.left, -zzabVar2.top);
                    int i6 = (int) ((pointArr[c2].x * cos) + (pointArr[c2].y * sin));
                    int i7 = (int) (((-pointArr[0].x) * sin) + (pointArr[0].y * cos));
                    pointArr[0].x = i6;
                    pointArr[0].y = i7;
                    pointArr[1] = new Point(zzabVar.width + i6, i7);
                    pointArr[2] = new Point(zzabVar.width + i6, zzabVar.height + i7);
                    pointArr[3] = new Point(i6, i7 + zzabVar.height);
                    i2 = i2;
                    for (int i8 = 0; i8 < 4; i8++) {
                        Point point = pointArr[i8];
                        i3 = Math.min(i3, point.x);
                        i = Math.max(i, point.x);
                        i4 = Math.min(i4, point.y);
                        i2 = Math.max(i2, point.y);
                    }
                    i5++;
                    c2 = 0;
                    textBlock2 = this;
                }
                zzab zzabVar3 = zzahVarArr[0].zzeq;
                int i9 = zzabVar3.left;
                int i10 = zzabVar3.top;
                double sin2 = Math.sin(Math.toRadians(zzabVar3.zzeo));
                double cos2 = Math.cos(Math.toRadians(zzabVar3.zzeo));
                Point[] pointArr2 = {new Point(i3, i4), new Point(i, i4), new Point(i, i2), new Point(i3, i2)};
                for (int i11 = 0; i11 < 4; i11++) {
                    pointArr2[i11].x = (int) ((pointArr2[i11].x * cos2) - (pointArr2[i11].y * sin2));
                    pointArr2[i11].y = (int) ((pointArr2[i11].x * sin2) + (pointArr2[i11].y * cos2));
                    pointArr2[i11].offset(i9, i10);
                }
                textBlock = this;
                textBlock.cornerPoints = pointArr2;
                return textBlock.cornerPoints;
            }
        }
        textBlock = textBlock2;
        return textBlock.cornerPoints;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getLanguage() {
        zzah[] zzahVarArr;
        String str = this.zzek;
        if (str != null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        for (zzah zzahVar : this.zzei) {
            hashMap.put(zzahVar.zzek, Integer.valueOf((hashMap.containsKey(zzahVar.zzek) ? ((Integer) hashMap.get(zzahVar.zzek)).intValue() : 0) + 1));
        }
        String str2 = (String) ((Map.Entry) Collections.max(hashMap.entrySet(), new zza(this))).getKey();
        this.zzek = str2;
        if (str2 == null || str2.isEmpty()) {
            this.zzek = "und";
        }
        return this.zzek;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getValue() {
        zzah[] zzahVarArr = this.zzei;
        if (zzahVarArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zzahVarArr[0].zzet);
        for (int i = 1; i < this.zzei.length; i++) {
            sb.append("\n");
            sb.append(this.zzei[i].zzet);
        }
        return sb.toString();
    }
}