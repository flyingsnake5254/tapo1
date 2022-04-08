package com.wdullaer.materialdatetimepicker.time;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DefaultTimepointLimiter implements TimepointLimiter {
    public static final Parcelable.Creator<DefaultTimepointLimiter> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private TreeSet<Timepoint> f15309c;

    /* renamed from: d  reason: collision with root package name */
    private TreeSet<Timepoint> f15310d;

    /* renamed from: f  reason: collision with root package name */
    private TreeSet<Timepoint> f15311f;
    private Timepoint q;
    private Timepoint x;

    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator<DefaultTimepointLimiter> {
        a() {
        }

        /* renamed from: a */
        public DefaultTimepointLimiter createFromParcel(Parcel parcel) {
            return new DefaultTimepointLimiter(parcel);
        }

        /* renamed from: b */
        public DefaultTimepointLimiter[] newArray(int i) {
            return new DefaultTimepointLimiter[i];
        }
    }

    DefaultTimepointLimiter() {
        this.f15309c = new TreeSet<>();
        this.f15310d = new TreeSet<>();
        this.f15311f = new TreeSet<>();
    }

    private TreeSet<Timepoint> a(TreeSet<Timepoint> treeSet, TreeSet<Timepoint> treeSet2) {
        TreeSet<Timepoint> treeSet3 = new TreeSet<>((SortedSet<Timepoint>) treeSet);
        treeSet3.removeAll(treeSet2);
        return treeSet3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.q, i);
        parcel.writeParcelable(this.x, i);
        TreeSet<Timepoint> treeSet = this.f15309c;
        parcel.writeTypedArray((Parcelable[]) treeSet.toArray(new Timepoint[treeSet.size()]), i);
        TreeSet<Timepoint> treeSet2 = this.f15310d;
        parcel.writeTypedArray((Parcelable[]) treeSet2.toArray(new Timepoint[treeSet2.size()]), i);
    }

    public DefaultTimepointLimiter(Parcel parcel) {
        this.f15309c = new TreeSet<>();
        this.f15310d = new TreeSet<>();
        this.f15311f = new TreeSet<>();
        this.q = (Timepoint) parcel.readParcelable(Timepoint.class.getClassLoader());
        this.x = (Timepoint) parcel.readParcelable(Timepoint.class.getClassLoader());
        TreeSet<Timepoint> treeSet = this.f15309c;
        Parcelable.Creator<Timepoint> creator = Timepoint.CREATOR;
        treeSet.addAll(Arrays.asList(parcel.createTypedArray(creator)));
        this.f15310d.addAll(Arrays.asList(parcel.createTypedArray(creator)));
        this.f15311f = a(this.f15309c, this.f15310d);
    }
}
