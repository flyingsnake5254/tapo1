package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/* loaded from: classes.dex */
public class TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final TrackSelectionParameters f3619c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final TrackSelectionParameters f3620d;
    public final int H3;
    public final boolean I3;
    public final ImmutableList<String> J3;
    public final ImmutableList<String> K3;
    public final int L3;
    public final int M3;
    public final int N3;
    public final ImmutableList<String> O3;
    public final ImmutableList<String> P3;
    public final int Q3;
    public final boolean R3;
    public final boolean S3;
    public final boolean T3;

    /* renamed from: f  reason: collision with root package name */
    public final int f3621f;
    public final int p0;
    public final int p1;
    public final int p2;
    public final int p3;
    public final int q;
    public final int x;
    public final int y;
    public final int z;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<TrackSelectionParameters> {
        a() {
        }

        /* renamed from: a */
        public TrackSelectionParameters createFromParcel(Parcel parcel) {
            return new TrackSelectionParameters(parcel);
        }

        /* renamed from: b */
        public TrackSelectionParameters[] newArray(int i) {
            return new TrackSelectionParameters[i];
        }
    }

    static {
        TrackSelectionParameters w = new b().w();
        f3619c = w;
        f3620d = w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TrackSelectionParameters(b bVar) {
        this.f3621f = bVar.a;
        this.q = bVar.f3622b;
        this.x = bVar.f3623c;
        this.y = bVar.f3624d;
        this.z = bVar.f3625e;
        this.p0 = bVar.f3626f;
        this.p1 = bVar.g;
        this.p2 = bVar.h;
        this.p3 = bVar.i;
        this.H3 = bVar.j;
        this.I3 = bVar.k;
        this.J3 = bVar.l;
        this.K3 = bVar.m;
        this.L3 = bVar.n;
        this.M3 = bVar.o;
        this.N3 = bVar.p;
        this.O3 = bVar.q;
        this.P3 = bVar.r;
        this.Q3 = bVar.s;
        this.R3 = bVar.t;
        this.S3 = bVar.u;
        this.T3 = bVar.v;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return this.f3621f == trackSelectionParameters.f3621f && this.q == trackSelectionParameters.q && this.x == trackSelectionParameters.x && this.y == trackSelectionParameters.y && this.z == trackSelectionParameters.z && this.p0 == trackSelectionParameters.p0 && this.p1 == trackSelectionParameters.p1 && this.p2 == trackSelectionParameters.p2 && this.I3 == trackSelectionParameters.I3 && this.p3 == trackSelectionParameters.p3 && this.H3 == trackSelectionParameters.H3 && this.J3.equals(trackSelectionParameters.J3) && this.K3.equals(trackSelectionParameters.K3) && this.L3 == trackSelectionParameters.L3 && this.M3 == trackSelectionParameters.M3 && this.N3 == trackSelectionParameters.N3 && this.O3.equals(trackSelectionParameters.O3) && this.P3.equals(trackSelectionParameters.P3) && this.Q3 == trackSelectionParameters.Q3 && this.R3 == trackSelectionParameters.R3 && this.S3 == trackSelectionParameters.S3 && this.T3 == trackSelectionParameters.T3;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((this.f3621f + 31) * 31) + this.q) * 31) + this.x) * 31) + this.y) * 31) + this.z) * 31) + this.p0) * 31) + this.p1) * 31) + this.p2) * 31) + (this.I3 ? 1 : 0)) * 31) + this.p3) * 31) + this.H3) * 31) + this.J3.hashCode()) * 31) + this.K3.hashCode()) * 31) + this.L3) * 31) + this.M3) * 31) + this.N3) * 31) + this.O3.hashCode()) * 31) + this.P3.hashCode()) * 31) + this.Q3) * 31) + (this.R3 ? 1 : 0)) * 31) + (this.S3 ? 1 : 0)) * 31) + (this.T3 ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.K3);
        parcel.writeInt(this.L3);
        parcel.writeList(this.P3);
        parcel.writeInt(this.Q3);
        o0.N0(parcel, this.R3);
        parcel.writeInt(this.f3621f);
        parcel.writeInt(this.q);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.z);
        parcel.writeInt(this.p0);
        parcel.writeInt(this.p1);
        parcel.writeInt(this.p2);
        parcel.writeInt(this.p3);
        parcel.writeInt(this.H3);
        o0.N0(parcel, this.I3);
        parcel.writeList(this.J3);
        parcel.writeInt(this.M3);
        parcel.writeInt(this.N3);
        parcel.writeList(this.O3);
        o0.N0(parcel, this.S3);
        o0.N0(parcel, this.T3);
    }

    /* loaded from: classes.dex */
    public static class b {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f3622b;

        /* renamed from: c  reason: collision with root package name */
        private int f3623c;

        /* renamed from: d  reason: collision with root package name */
        private int f3624d;

        /* renamed from: e  reason: collision with root package name */
        private int f3625e;

        /* renamed from: f  reason: collision with root package name */
        private int f3626f;
        private int g;
        private int h;
        private int i;
        private int j;
        private boolean k;
        private ImmutableList<String> l;
        private ImmutableList<String> m;
        private int n;
        private int o;
        private int p;
        private ImmutableList<String> q;
        private ImmutableList<String> r;
        private int s;
        private boolean t;
        private boolean u;
        private boolean v;

        @Deprecated
        public b() {
            this.a = Integer.MAX_VALUE;
            this.f3622b = Integer.MAX_VALUE;
            this.f3623c = Integer.MAX_VALUE;
            this.f3624d = Integer.MAX_VALUE;
            this.i = Integer.MAX_VALUE;
            this.j = Integer.MAX_VALUE;
            this.k = true;
            this.l = ImmutableList.of();
            this.m = ImmutableList.of();
            this.n = 0;
            this.o = Integer.MAX_VALUE;
            this.p = Integer.MAX_VALUE;
            this.q = ImmutableList.of();
            this.r = ImmutableList.of();
            this.s = 0;
            this.t = false;
            this.u = false;
            this.v = false;
        }

        @RequiresApi(19)
        private void y(Context context) {
            CaptioningManager captioningManager;
            if ((o0.a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.s = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.r = ImmutableList.of(o0.Q(locale));
                }
            }
        }

        public b A(Context context, boolean z) {
            Point J = o0.J(context);
            return z(J.x, J.y, z);
        }

        public TrackSelectionParameters w() {
            return new TrackSelectionParameters(this);
        }

        public b x(Context context) {
            if (o0.a >= 19) {
                y(context);
            }
            return this;
        }

        public b z(int i, int i2, boolean z) {
            this.i = i;
            this.j = i2;
            this.k = z;
            return this;
        }

        public b(Context context) {
            this();
            x(context);
            A(context, true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b(TrackSelectionParameters trackSelectionParameters) {
            this.a = trackSelectionParameters.f3621f;
            this.f3622b = trackSelectionParameters.q;
            this.f3623c = trackSelectionParameters.x;
            this.f3624d = trackSelectionParameters.y;
            this.f3625e = trackSelectionParameters.z;
            this.f3626f = trackSelectionParameters.p0;
            this.g = trackSelectionParameters.p1;
            this.h = trackSelectionParameters.p2;
            this.i = trackSelectionParameters.p3;
            this.j = trackSelectionParameters.H3;
            this.k = trackSelectionParameters.I3;
            this.l = trackSelectionParameters.J3;
            this.m = trackSelectionParameters.K3;
            this.n = trackSelectionParameters.L3;
            this.o = trackSelectionParameters.M3;
            this.p = trackSelectionParameters.N3;
            this.q = trackSelectionParameters.O3;
            this.r = trackSelectionParameters.P3;
            this.s = trackSelectionParameters.Q3;
            this.t = trackSelectionParameters.R3;
            this.u = trackSelectionParameters.S3;
            this.v = trackSelectionParameters.T3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackSelectionParameters(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, null);
        this.K3 = ImmutableList.copyOf((Collection) arrayList);
        this.L3 = parcel.readInt();
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, null);
        this.P3 = ImmutableList.copyOf((Collection) arrayList2);
        this.Q3 = parcel.readInt();
        this.R3 = o0.A0(parcel);
        this.f3621f = parcel.readInt();
        this.q = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readInt();
        this.z = parcel.readInt();
        this.p0 = parcel.readInt();
        this.p1 = parcel.readInt();
        this.p2 = parcel.readInt();
        this.p3 = parcel.readInt();
        this.H3 = parcel.readInt();
        this.I3 = o0.A0(parcel);
        ArrayList arrayList3 = new ArrayList();
        parcel.readList(arrayList3, null);
        this.J3 = ImmutableList.copyOf((Collection) arrayList3);
        this.M3 = parcel.readInt();
        this.N3 = parcel.readInt();
        ArrayList arrayList4 = new ArrayList();
        parcel.readList(arrayList4, null);
        this.O3 = ImmutableList.copyOf((Collection) arrayList4);
        this.S3 = o0.A0(parcel);
        this.T3 = o0.A0(parcel);
    }
}
