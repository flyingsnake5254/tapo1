package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class MarkedPositionInfo implements Cloneable {
    private final Object fileOrBitmap;
    private final int id;
    private final String name;
    private final Double positionPan;
    private final Double positionTilt;
    private final Integer readOnly;

    public MarkedPositionInfo(int i, String name, Integer num, Double d2, Double d3, Object fileOrBitmap) {
        j.e(name, "name");
        j.e(fileOrBitmap, "fileOrBitmap");
        this.id = i;
        this.name = name;
        this.readOnly = num;
        this.positionPan = d2;
        this.positionTilt = d3;
        this.fileOrBitmap = fileOrBitmap;
    }

    public static /* synthetic */ MarkedPositionInfo copy$default(MarkedPositionInfo markedPositionInfo, int i, String str, Integer num, Double d2, Double d3, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = markedPositionInfo.id;
        }
        if ((i2 & 2) != 0) {
            str = markedPositionInfo.name;
        }
        if ((i2 & 4) != 0) {
            num = markedPositionInfo.readOnly;
        }
        if ((i2 & 8) != 0) {
            d2 = markedPositionInfo.positionPan;
        }
        if ((i2 & 16) != 0) {
            d3 = markedPositionInfo.positionTilt;
        }
        if ((i2 & 32) != 0) {
            obj = markedPositionInfo.fileOrBitmap;
        }
        return markedPositionInfo.copy(i, str, num, d2, d3, obj);
    }

    public Object clone() throws CloneNotSupportedException {
        return copy$default(this, 0, null, null, null, null, null, 63, null);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final Integer component3() {
        return this.readOnly;
    }

    public final Double component4() {
        return this.positionPan;
    }

    public final Double component5() {
        return this.positionTilt;
    }

    public final Object component6() {
        return this.fileOrBitmap;
    }

    public final MarkedPositionInfo copy(int i, String name, Integer num, Double d2, Double d3, Object fileOrBitmap) {
        j.e(name, "name");
        j.e(fileOrBitmap, "fileOrBitmap");
        return new MarkedPositionInfo(i, name, num, d2, d3, fileOrBitmap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MarkedPositionInfo)) {
            return false;
        }
        MarkedPositionInfo markedPositionInfo = (MarkedPositionInfo) obj;
        return this.id == markedPositionInfo.id && j.a(this.name, markedPositionInfo.name) && j.a(this.readOnly, markedPositionInfo.readOnly) && j.a(this.positionPan, markedPositionInfo.positionPan) && j.a(this.positionTilt, markedPositionInfo.positionTilt) && j.a(this.fileOrBitmap, markedPositionInfo.fileOrBitmap);
    }

    public final Object getFileOrBitmap() {
        return this.fileOrBitmap;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Double getPositionPan() {
        return this.positionPan;
    }

    public final Double getPositionTilt() {
        return this.positionTilt;
    }

    public final Integer getReadOnly() {
        return this.readOnly;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.readOnly;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Double d2 = this.positionPan;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.positionTilt;
        int hashCode4 = (hashCode3 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Object obj = this.fileOrBitmap;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        return "MarkedPositionInfo(id=" + this.id + ", name=" + this.name + ", readOnly=" + this.readOnly + ", positionPan=" + this.positionPan + ", positionTilt=" + this.positionTilt + ", fileOrBitmap=" + this.fileOrBitmap + ")";
    }
}
