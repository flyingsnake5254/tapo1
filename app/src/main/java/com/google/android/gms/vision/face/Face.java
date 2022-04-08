package com.google.android.gms.vision.face;

import android.graphics.PointF;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
/* loaded from: classes.dex */
public class Face {
    public static final float UNCOMPUTED_PROBABILITY = -1.0f;
    private float height;
    private int id;
    private float width;
    private PointF zzcg;
    private float zzch;
    private float zzci;
    private float zzcj;
    private List<Landmark> zzck;
    private final List<Contour> zzcl;
    private float zzcm;
    private float zzcn;
    private float zzco;
    private final float zzcp;

    public Face(int i, PointF pointF, float f2, float f3, float f4, float f5, float f6, Landmark[] landmarkArr, Contour[] contourArr, float f7, float f8, float f9, float f10) {
        this.id = i;
        this.zzcg = pointF;
        this.width = f2;
        this.height = f3;
        this.zzch = f4;
        this.zzci = f5;
        this.zzcj = f6;
        this.zzck = Arrays.asList(landmarkArr);
        this.zzcl = Arrays.asList(contourArr);
        this.zzcm = zza(f7);
        this.zzcn = zza(f8);
        this.zzco = zza(f9);
        this.zzcp = zza(f10);
    }

    private static float zza(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            return -1.0f;
        }
        return f2;
    }

    public List<Contour> getContours() {
        return this.zzcl;
    }

    @ShowFirstParty
    @KeepForSdk
    public float getEulerX() {
        return this.zzcj;
    }

    public float getEulerY() {
        return this.zzch;
    }

    public float getEulerZ() {
        return this.zzci;
    }

    public float getHeight() {
        return this.height;
    }

    public int getId() {
        return this.id;
    }

    public float getIsLeftEyeOpenProbability() {
        return this.zzcm;
    }

    public float getIsRightEyeOpenProbability() {
        return this.zzcn;
    }

    public float getIsSmilingProbability() {
        return this.zzco;
    }

    public List<Landmark> getLandmarks() {
        return this.zzck;
    }

    public PointF getPosition() {
        PointF pointF = this.zzcg;
        return new PointF(pointF.x - (this.width / 2.0f), pointF.y - (this.height / 2.0f));
    }

    public float getWidth() {
        return this.width;
    }
}
