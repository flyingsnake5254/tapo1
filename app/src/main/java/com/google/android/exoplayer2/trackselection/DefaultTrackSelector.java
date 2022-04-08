package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.e2;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.d;
import com.google.android.exoplayer2.trackselection.g;
import com.google.android.exoplayer2.trackselection.i;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.a2;
import com.google.common.collect.c0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class DefaultTrackSelector extends i {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f3602d = new int[0];

    /* renamed from: e  reason: collision with root package name */
    private static final a2<Integer> f3603e = a2.a(c.f3629c);

    /* renamed from: f  reason: collision with root package name */
    private static final a2<Integer> f3604f = a2.a(b.f3628c);
    private final g.b g;
    private final AtomicReference<Parameters> h;

    /* loaded from: classes.dex */
    public static final class Parameters extends TrackSelectionParameters implements Parcelable {
        public static final Parcelable.Creator<Parameters> CREATOR = new a();
        public static final Parameters U3;
        @Deprecated
        public static final Parameters V3;
        public final int W3;
        public final boolean X3;
        public final boolean Y3;
        public final boolean Z3;
        public final boolean a4;
        public final boolean b4;
        public final boolean c4;
        public final boolean d4;
        public final boolean e4;
        public final boolean f4;
        public final boolean g4;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> h4;
        private final SparseBooleanArray i4;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<Parameters> {
            a() {
            }

            /* renamed from: a */
            public Parameters createFromParcel(Parcel parcel) {
                return new Parameters(parcel);
            }

            /* renamed from: b */
            public Parameters[] newArray(int i) {
                return new Parameters[i];
            }
        }

        static {
            Parameters O = new d().w();
            U3 = O;
            V3 = O;
        }

        private static boolean c(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean d(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (indexOfKey < 0 || !e(sparseArray.valueAt(i), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static boolean e(java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r4, java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto L_0x000c
                return r2
            L_0x000c:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x0014:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                com.google.android.exoplayer2.source.TrackGroupArray r1 = (com.google.android.exoplayer2.source.TrackGroupArray) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = com.google.android.exoplayer2.util.o0.b(r0, r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.e(java.util.Map, java.util.Map):boolean");
        }

        public static Parameters h(Context context) {
            return new d(context).w();
        }

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> n(Parcel parcel) {
            int readInt = parcel.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i2 = 0; i2 < readInt3; i2++) {
                    hashMap.put((TrackGroupArray) com.google.android.exoplayer2.util.g.e((TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader())), (SelectionOverride) parcel.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            return sparseArray;
        }

        private static void o(Parcel parcel, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                Map<TrackGroupArray, SelectionOverride> valueAt = sparseArray.valueAt(i);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry<TrackGroupArray, SelectionOverride> entry : valueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return super.equals(parameters) && this.X3 == parameters.X3 && this.Y3 == parameters.Y3 && this.Z3 == parameters.Z3 && this.a4 == parameters.a4 && this.b4 == parameters.b4 && this.c4 == parameters.c4 && this.d4 == parameters.d4 && this.W3 == parameters.W3 && this.e4 == parameters.e4 && this.f4 == parameters.f4 && this.g4 == parameters.g4 && c(this.i4, parameters.i4) && d(this.h4, parameters.h4);
        }

        public d f() {
            return new d(this);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public int hashCode() {
            return ((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.X3 ? 1 : 0)) * 31) + (this.Y3 ? 1 : 0)) * 31) + (this.Z3 ? 1 : 0)) * 31) + (this.a4 ? 1 : 0)) * 31) + (this.b4 ? 1 : 0)) * 31) + (this.c4 ? 1 : 0)) * 31) + (this.d4 ? 1 : 0)) * 31) + this.W3) * 31) + (this.e4 ? 1 : 0)) * 31) + (this.f4 ? 1 : 0)) * 31) + (this.g4 ? 1 : 0);
        }

        public final boolean i(int i) {
            return this.i4.get(i);
        }

        @Nullable
        public final SelectionOverride l(int i, TrackGroupArray trackGroupArray) {
            Map<TrackGroupArray, SelectionOverride> map = this.h4.get(i);
            if (map != null) {
                return map.get(trackGroupArray);
            }
            return null;
        }

        public final boolean m(int i, TrackGroupArray trackGroupArray) {
            Map<TrackGroupArray, SelectionOverride> map = this.h4.get(i);
            return map != null && map.containsKey(trackGroupArray);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            o0.N0(parcel, this.X3);
            o0.N0(parcel, this.Y3);
            o0.N0(parcel, this.Z3);
            o0.N0(parcel, this.a4);
            o0.N0(parcel, this.b4);
            o0.N0(parcel, this.c4);
            o0.N0(parcel, this.d4);
            parcel.writeInt(this.W3);
            o0.N0(parcel, this.e4);
            o0.N0(parcel, this.f4);
            o0.N0(parcel, this.g4);
            o(parcel, this.h4);
            parcel.writeSparseBooleanArray(this.i4);
        }

        private Parameters(d dVar) {
            super(dVar);
            this.X3 = dVar.w;
            this.Y3 = dVar.x;
            this.Z3 = dVar.y;
            this.a4 = dVar.z;
            this.b4 = dVar.A;
            this.c4 = dVar.B;
            this.d4 = dVar.C;
            this.W3 = dVar.D;
            this.e4 = dVar.E;
            this.f4 = dVar.F;
            this.g4 = dVar.G;
            this.h4 = dVar.H;
            this.i4 = dVar.I;
        }

        Parameters(Parcel parcel) {
            super(parcel);
            this.X3 = o0.A0(parcel);
            this.Y3 = o0.A0(parcel);
            this.Z3 = o0.A0(parcel);
            this.a4 = o0.A0(parcel);
            this.b4 = o0.A0(parcel);
            this.c4 = o0.A0(parcel);
            this.d4 = o0.A0(parcel);
            this.W3 = parcel.readInt();
            this.e4 = o0.A0(parcel);
            this.f4 = o0.A0(parcel);
            this.g4 = o0.A0(parcel);
            this.h4 = n(parcel);
            this.i4 = (SparseBooleanArray) o0.i(parcel.readSparseBooleanArray());
        }
    }

    /* loaded from: classes.dex */
    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public final int f3605c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f3606d;

        /* renamed from: f  reason: collision with root package name */
        public final int f3607f;
        public final int q;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<SelectionOverride> {
            a() {
            }

            /* renamed from: a */
            public SelectionOverride createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }

            /* renamed from: b */
            public SelectionOverride[] newArray(int i) {
                return new SelectionOverride[i];
            }
        }

        public SelectionOverride(int i, int... iArr) {
            this(i, iArr, 0);
        }

        public boolean a(int i) {
            for (int i2 : this.f3606d) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            return this.f3605c == selectionOverride.f3605c && Arrays.equals(this.f3606d, selectionOverride.f3606d) && this.q == selectionOverride.q;
        }

        public int hashCode() {
            return (((this.f3605c * 31) + Arrays.hashCode(this.f3606d)) * 31) + this.q;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3605c);
            parcel.writeInt(this.f3606d.length);
            parcel.writeIntArray(this.f3606d);
            parcel.writeInt(this.q);
        }

        public SelectionOverride(int i, int[] iArr, int i2) {
            this.f3605c = i;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f3606d = copyOf;
            this.f3607f = iArr.length;
            this.q = i2;
            Arrays.sort(copyOf);
        }

        SelectionOverride(Parcel parcel) {
            this.f3605c = parcel.readInt();
            int readByte = parcel.readByte();
            this.f3607f = readByte;
            int[] iArr = new int[readByte];
            this.f3606d = iArr;
            parcel.readIntArray(iArr);
            this.q = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class b implements Comparable<b> {
        private final int H3;
        private final int I3;
        private final int J3;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f3608c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final String f3609d;

        /* renamed from: f  reason: collision with root package name */
        private final Parameters f3610f;
        private final int p0;
        private final int p1;
        private final boolean p2;
        private final int p3;
        private final boolean q;
        private final int x;
        private final int y;
        private final int z;

        public b(Format format, Parameters parameters, int i) {
            int i2;
            int i3;
            int i4;
            this.f3610f = parameters;
            this.f3609d = DefaultTrackSelector.A(format.f2006f);
            int i5 = 0;
            this.q = DefaultTrackSelector.u(i, false);
            int i6 = 0;
            while (true) {
                i2 = Integer.MAX_VALUE;
                if (i6 >= parameters.K3.size()) {
                    i6 = Integer.MAX_VALUE;
                    i3 = 0;
                    break;
                }
                i3 = DefaultTrackSelector.q(format, parameters.K3.get(i6), false);
                if (i3 > 0) {
                    break;
                }
                i6++;
            }
            this.y = i6;
            this.x = i3;
            this.z = Integer.bitCount(format.x & parameters.L3);
            boolean z = true;
            this.p2 = (format.q & 1) != 0;
            int i7 = format.U3;
            this.p3 = i7;
            this.H3 = format.V3;
            int i8 = format.p0;
            this.I3 = i8;
            if ((i8 != -1 && i8 > parameters.N3) || (i7 != -1 && i7 > parameters.M3)) {
                z = false;
            }
            this.f3608c = z;
            String[] a0 = o0.a0();
            int i9 = 0;
            while (true) {
                if (i9 >= a0.length) {
                    i9 = Integer.MAX_VALUE;
                    i4 = 0;
                    break;
                }
                i4 = DefaultTrackSelector.q(format, a0[i9], false);
                if (i4 > 0) {
                    break;
                }
                i9++;
            }
            this.p0 = i9;
            this.p1 = i4;
            while (true) {
                if (i5 < parameters.O3.size()) {
                    String str = format.H3;
                    if (str != null && str.equals(parameters.O3.get(i5))) {
                        i2 = i5;
                        break;
                    }
                    i5++;
                } else {
                    break;
                }
            }
            this.J3 = i2;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            a2 j = (!this.f3608c || !this.q) ? DefaultTrackSelector.f3603e.j() : DefaultTrackSelector.f3603e;
            c0 g = c0.k().h(this.q, bVar.q).g(Integer.valueOf(this.y), Integer.valueOf(bVar.y), a2.g().j()).d(this.x, bVar.x).d(this.z, bVar.z).h(this.f3608c, bVar.f3608c).g(Integer.valueOf(this.J3), Integer.valueOf(bVar.J3), a2.g().j()).g(Integer.valueOf(this.I3), Integer.valueOf(bVar.I3), this.f3610f.S3 ? DefaultTrackSelector.f3603e.j() : DefaultTrackSelector.f3604f).h(this.p2, bVar.p2).g(Integer.valueOf(this.p0), Integer.valueOf(bVar.p0), a2.g().j()).d(this.p1, bVar.p1).g(Integer.valueOf(this.p3), Integer.valueOf(bVar.p3), j).g(Integer.valueOf(this.H3), Integer.valueOf(bVar.H3), j);
            Integer valueOf = Integer.valueOf(this.I3);
            Integer valueOf2 = Integer.valueOf(bVar.I3);
            if (!o0.b(this.f3609d, bVar.f3609d)) {
                j = DefaultTrackSelector.f3604f;
            }
            return g.g(valueOf, valueOf2, j).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class c implements Comparable<c> {

        /* renamed from: c  reason: collision with root package name */
        private final boolean f3611c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f3612d;

        public c(Format format, int i) {
            this.f3611c = (format.q & 1) == 0 ? false : true;
            this.f3612d = DefaultTrackSelector.u(i, false);
        }

        /* renamed from: a */
        public int compareTo(c cVar) {
            return c0.k().h(this.f3612d, cVar.f3612d).h(this.f3611c, cVar.f3611c).j();
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends TrackSelectionParameters.b {
        private boolean A;
        private boolean B;
        private boolean C;
        private int D;
        private boolean E;
        private boolean F;
        private boolean G;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> H;
        private final SparseBooleanArray I;
        private boolean w;
        private boolean x;
        private boolean y;
        private boolean z;

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> Q(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
            for (int i = 0; i < sparseArray.size(); i++) {
                sparseArray2.put(sparseArray.keyAt(i), new HashMap(sparseArray.valueAt(i)));
            }
            return sparseArray2;
        }

        private void R() {
            this.w = true;
            this.x = false;
            this.y = true;
            this.z = true;
            this.A = false;
            this.B = false;
            this.C = false;
            this.D = 0;
            this.E = true;
            this.F = false;
            this.G = true;
        }

        /* renamed from: O */
        public Parameters w() {
            return new Parameters(this);
        }

        public final d P(int i) {
            Map<TrackGroupArray, SelectionOverride> map = this.H.get(i);
            if (map != null && !map.isEmpty()) {
                this.H.remove(i);
            }
            return this;
        }

        /* renamed from: S */
        public d x(Context context) {
            super.x(context);
            return this;
        }

        public final d T(int i, boolean z) {
            if (this.I.get(i) == z) {
                return this;
            }
            if (z) {
                this.I.put(i, true);
            } else {
                this.I.delete(i);
            }
            return this;
        }

        public final d U(int i, TrackGroupArray trackGroupArray, @Nullable SelectionOverride selectionOverride) {
            Map<TrackGroupArray, SelectionOverride> map = this.H.get(i);
            if (map == null) {
                map = new HashMap<>();
                this.H.put(i, map);
            }
            if (map.containsKey(trackGroupArray) && o0.b(map.get(trackGroupArray), selectionOverride)) {
                return this;
            }
            map.put(trackGroupArray, selectionOverride);
            return this;
        }

        /* renamed from: V */
        public d z(int i, int i2, boolean z) {
            super.z(i, i2, z);
            return this;
        }

        /* renamed from: W */
        public d A(Context context, boolean z) {
            super.A(context, z);
            return this;
        }

        @Deprecated
        public d() {
            this.H = new SparseArray<>();
            this.I = new SparseBooleanArray();
            R();
        }

        public d(Context context) {
            super(context);
            this.H = new SparseArray<>();
            this.I = new SparseBooleanArray();
            R();
        }

        private d(Parameters parameters) {
            super(parameters);
            this.D = parameters.W3;
            this.w = parameters.X3;
            this.x = parameters.Y3;
            this.y = parameters.Z3;
            this.z = parameters.a4;
            this.A = parameters.b4;
            this.B = parameters.c4;
            this.C = parameters.d4;
            this.E = parameters.e4;
            this.F = parameters.f4;
            this.G = parameters.g4;
            this.H = Q(parameters.h4);
            this.I = parameters.i4.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class e implements Comparable<e> {

        /* renamed from: c  reason: collision with root package name */
        public final boolean f3613c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f3614d;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f3615f;
        private final int p0;
        private final boolean p1;
        private final boolean q;
        private final int x;
        private final int y;
        private final int z;

        public e(Format format, Parameters parameters, int i, @Nullable String str) {
            ImmutableList<String> immutableList;
            int i2;
            boolean z = false;
            this.f3614d = DefaultTrackSelector.u(i, false);
            int i3 = format.q & (~parameters.W3);
            this.f3615f = (i3 & 1) != 0;
            this.q = (i3 & 2) != 0;
            int i4 = Integer.MAX_VALUE;
            if (parameters.P3.isEmpty()) {
                immutableList = ImmutableList.of("");
            } else {
                immutableList = parameters.P3;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= immutableList.size()) {
                    i2 = 0;
                    break;
                }
                i2 = DefaultTrackSelector.q(format, immutableList.get(i5), parameters.R3);
                if (i2 > 0) {
                    i4 = i5;
                    break;
                }
                i5++;
            }
            this.x = i4;
            this.y = i2;
            int bitCount = Integer.bitCount(format.x & parameters.Q3);
            this.z = bitCount;
            this.p1 = (format.x & 1088) != 0;
            int q = DefaultTrackSelector.q(format, str, DefaultTrackSelector.A(str) == null);
            this.p0 = q;
            if (i2 > 0 || ((parameters.P3.isEmpty() && bitCount > 0) || this.f3615f || (this.q && q > 0))) {
                z = true;
            }
            this.f3613c = z;
        }

        /* renamed from: a */
        public int compareTo(e eVar) {
            c0 d2 = c0.k().h(this.f3614d, eVar.f3614d).g(Integer.valueOf(this.x), Integer.valueOf(eVar.x), a2.g().j()).d(this.y, eVar.y).d(this.z, eVar.z).h(this.f3615f, eVar.f3615f).g(Boolean.valueOf(this.q), Boolean.valueOf(eVar.q), this.y == 0 ? a2.g() : a2.g().j()).d(this.p0, eVar.p0);
            if (this.z == 0) {
                d2 = d2.i(this.p1, eVar.p1);
            }
            return d2.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class f implements Comparable<f> {

        /* renamed from: c  reason: collision with root package name */
        public final boolean f3616c;

        /* renamed from: d  reason: collision with root package name */
        private final Parameters f3617d;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f3618f;
        private final boolean q;
        private final int x;
        private final int y;
        private final int z;

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
            if (r10 < r8.p1) goto L_0x005e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x005b, code lost:
            if (r10 < r8.p2) goto L_0x005e;
         */
        /* JADX WARN: Removed duplicated region for block: B:34:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0091 A[EDGE_INSN: B:52:0x0091->B:50:0x0091 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public f(com.google.android.exoplayer2.Format r7, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r8, int r9, boolean r10) {
            /*
                r6 = this;
                r6.<init>()
                r6.f3617d = r8
                r0 = -1082130432(0xffffffffbf800000, float:-1.0)
                r1 = 1
                r2 = 0
                r3 = -1
                if (r10 == 0) goto L_0x0033
                int r4 = r7.M3
                if (r4 == r3) goto L_0x0014
                int r5 = r8.f3621f
                if (r4 > r5) goto L_0x0033
            L_0x0014:
                int r4 = r7.N3
                if (r4 == r3) goto L_0x001c
                int r5 = r8.q
                if (r4 > r5) goto L_0x0033
            L_0x001c:
                float r4 = r7.O3
                int r5 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r5 == 0) goto L_0x0029
                int r5 = r8.x
                float r5 = (float) r5
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 > 0) goto L_0x0033
            L_0x0029:
                int r4 = r7.p0
                if (r4 == r3) goto L_0x0031
                int r5 = r8.y
                if (r4 > r5) goto L_0x0033
            L_0x0031:
                r4 = 1
                goto L_0x0034
            L_0x0033:
                r4 = 0
            L_0x0034:
                r6.f3616c = r4
                if (r10 == 0) goto L_0x005e
                int r10 = r7.M3
                if (r10 == r3) goto L_0x0040
                int r4 = r8.z
                if (r10 < r4) goto L_0x005e
            L_0x0040:
                int r10 = r7.N3
                if (r10 == r3) goto L_0x0048
                int r4 = r8.p0
                if (r10 < r4) goto L_0x005e
            L_0x0048:
                float r10 = r7.O3
                int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r0 == 0) goto L_0x0055
                int r0 = r8.p1
                float r0 = (float) r0
                int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r10 < 0) goto L_0x005e
            L_0x0055:
                int r10 = r7.p0
                if (r10 == r3) goto L_0x005f
                int r0 = r8.p2
                if (r10 < r0) goto L_0x005e
                goto L_0x005f
            L_0x005e:
                r1 = 0
            L_0x005f:
                r6.f3618f = r1
                boolean r9 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.u(r9, r2)
                r6.q = r9
                int r9 = r7.p0
                r6.x = r9
                int r9 = r7.c()
                r6.y = r9
                r9 = 2147483647(0x7fffffff, float:NaN)
            L_0x0074:
                com.google.common.collect.ImmutableList<java.lang.String> r10 = r8.J3
                int r10 = r10.size()
                if (r2 >= r10) goto L_0x0091
                java.lang.String r10 = r7.H3
                if (r10 == 0) goto L_0x008e
                com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.J3
                java.lang.Object r0 = r0.get(r2)
                boolean r10 = r10.equals(r0)
                if (r10 == 0) goto L_0x008e
                r9 = r2
                goto L_0x0091
            L_0x008e:
                int r2 = r2 + 1
                goto L_0x0074
            L_0x0091:
                r6.z = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.f.<init>(com.google.android.exoplayer2.Format, com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters, int, boolean):void");
        }

        /* renamed from: a */
        public int compareTo(f fVar) {
            a2 j = (!this.f3616c || !this.q) ? DefaultTrackSelector.f3603e.j() : DefaultTrackSelector.f3603e;
            return c0.k().h(this.q, fVar.q).h(this.f3616c, fVar.f3616c).h(this.f3618f, fVar.f3618f).g(Integer.valueOf(this.z), Integer.valueOf(fVar.z), a2.g().j()).g(Integer.valueOf(this.x), Integer.valueOf(fVar.x), this.f3617d.S3 ? DefaultTrackSelector.f3603e.j() : DefaultTrackSelector.f3604f).g(Integer.valueOf(this.y), Integer.valueOf(fVar.y), j).g(Integer.valueOf(this.x), Integer.valueOf(fVar.x), j).j();
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this(Parameters.U3, new d.b());
    }

    @Nullable
    protected static String A(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    private static boolean B(int[][] iArr, TrackGroupArray trackGroupArray, g gVar) {
        if (gVar == null) {
            return false;
        }
        int b2 = trackGroupArray.b(gVar.m());
        for (int i = 0; i < gVar.length(); i++) {
            if (c2.e(iArr[b2][gVar.h(i)]) != 32) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private static g.a C(TrackGroupArray trackGroupArray, int[][] iArr, int i, Parameters parameters) {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i2 = parameters2.Z3 ? 24 : 16;
        boolean z = parameters2.Y3 && (i & i2) != 0;
        int i3 = 0;
        while (i3 < trackGroupArray2.f3161d) {
            TrackGroup a2 = trackGroupArray2.a(i3);
            int[] p = p(a2, iArr[i3], z, i2, parameters2.f3621f, parameters2.q, parameters2.x, parameters2.y, parameters2.z, parameters2.p0, parameters2.p1, parameters2.p2, parameters2.p3, parameters2.H3, parameters2.I3);
            if (p.length > 0) {
                return new g.a(a2, p);
            }
            i3++;
            trackGroupArray2 = trackGroupArray;
            parameters2 = parameters;
        }
        return null;
    }

    @Nullable
    private static g.a F(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        int i = -1;
        TrackGroup trackGroup = null;
        f fVar = null;
        for (int i2 = 0; i2 < trackGroupArray.f3161d; i2++) {
            TrackGroup a2 = trackGroupArray.a(i2);
            List<Integer> t = t(a2, parameters.p3, parameters.H3, parameters.I3);
            int[] iArr2 = iArr[i2];
            for (int i3 = 0; i3 < a2.f3157c; i3++) {
                Format a3 = a2.a(i3);
                if ((a3.x & 16384) == 0 && u(iArr2[i3], parameters.e4)) {
                    f fVar2 = new f(a3, parameters, iArr2[i3], t.contains(Integer.valueOf(i3)));
                    if ((fVar2.f3616c || parameters.X3) && (fVar == null || fVar2.compareTo(fVar) > 0)) {
                        trackGroup = a2;
                        i = i3;
                        fVar = fVar2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new g.a(trackGroup, i);
    }

    private static void m(TrackGroup trackGroup, int[] iArr, int i, @Nullable String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!w(trackGroup.a(intValue), str, iArr[intValue], i, i2, i3, i4, i5, i6, i7, i8, i9)) {
                list.remove(size);
            }
        }
    }

    private static int[] n(TrackGroup trackGroup, int[] iArr, int i, int i2, boolean z, boolean z2, boolean z3) {
        Format a2 = trackGroup.a(i);
        int[] iArr2 = new int[trackGroup.f3157c];
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroup.f3157c; i4++) {
            if (i4 == i || v(trackGroup.a(i4), iArr[i4], a2, i2, z, z2, z3)) {
                i3++;
                iArr2[i3] = i4;
            }
        }
        return Arrays.copyOf(iArr2, i3);
    }

    private static int o(TrackGroup trackGroup, int[] iArr, int i, @Nullable String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, List<Integer> list) {
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            int intValue = list.get(i11).intValue();
            if (w(trackGroup.a(intValue), str, iArr[intValue], i, i2, i3, i4, i5, i6, i7, i8, i9)) {
                i10++;
            }
        }
        return i10;
    }

    private static int[] p(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z2) {
        String str;
        int i12;
        if (trackGroup.f3157c < 2) {
            return f3602d;
        }
        List<Integer> t = t(trackGroup, i10, i11, z2);
        if (t.size() < 2) {
            return f3602d;
        }
        if (!z) {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i13 = 0;
            for (int i14 = 0; i14 < t.size(); i14 = i12 + 1) {
                String str3 = trackGroup.a(t.get(i14).intValue()).H3;
                if (hashSet.add(str3)) {
                    i13 = i13;
                    i12 = i14;
                    hashSet = hashSet;
                    int o = o(trackGroup, iArr, i, str3, i2, i3, i4, i5, i6, i7, i8, i9, t);
                    if (o > i13) {
                        i13 = o;
                        str2 = str3;
                    }
                } else {
                    i13 = i13;
                    i12 = i14;
                    hashSet = hashSet;
                }
            }
            str = str2;
        } else {
            str = null;
        }
        m(trackGroup, iArr, i, str, i2, i3, i4, i5, i6, i7, i8, i9, t);
        return t.size() < 2 ? f3602d : com.google.common.primitives.d.j(t);
    }

    protected static int q(Format format, @Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(format.f2006f)) {
            return 4;
        }
        String A = A(str);
        String A2 = A(format.f2006f);
        if (A2 == null || A == null) {
            return (!z || A2 != null) ? 0 : 1;
        }
        if (A2.startsWith(A) || A.startsWith(A2)) {
            return 3;
        }
        return o0.F0(A2, "-")[0].equals(o0.F0(A, "-")[0]) ? 2 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000d, code lost:
        if (r1 != r3) goto L_0x0013;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Point r(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x0010
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = 0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r3 = 0
        L_0x000d:
            if (r1 == r3) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0013:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0023
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2.util.o0.k(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.o0.k(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.r(boolean, int, int, int, int):android.graphics.Point");
    }

    private static List<Integer> t(TrackGroup trackGroup, int i, int i2, boolean z) {
        int i3;
        ArrayList arrayList = new ArrayList(trackGroup.f3157c);
        for (int i4 = 0; i4 < trackGroup.f3157c; i4++) {
            arrayList.add(Integer.valueOf(i4));
        }
        if (!(i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE)) {
            int i5 = Integer.MAX_VALUE;
            for (int i6 = 0; i6 < trackGroup.f3157c; i6++) {
                Format a2 = trackGroup.a(i6);
                int i7 = a2.M3;
                if (i7 > 0 && (i3 = a2.N3) > 0) {
                    Point r = r(z, i, i2, i7, i3);
                    int i8 = a2.M3;
                    int i9 = a2.N3;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (r.x * 0.98f)) && i9 >= ((int) (r.y * 0.98f)) && i10 < i5) {
                        i5 = i10;
                    }
                }
            }
            if (i5 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int c2 = trackGroup.a(((Integer) arrayList.get(size)).intValue()).c();
                    if (c2 == -1 || c2 > i5) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    protected static boolean u(int i, boolean z) {
        int d2 = c2.d(i);
        return d2 == 4 || (z && d2 == 3);
    }

    private static boolean v(Format format, int i, Format format2, int i2, boolean z, boolean z2, boolean z3) {
        int i3;
        int i4;
        String str;
        int i5;
        if (!u(i, false) || (i3 = format.p0) == -1 || i3 > i2) {
            return false;
        }
        if (!z3 && ((i5 = format.U3) == -1 || i5 != format2.U3)) {
            return false;
        }
        if (z || ((str = format.H3) != null && TextUtils.equals(str, format2.H3))) {
            return z2 || ((i4 = format.V3) != -1 && i4 == format2.V3);
        }
        return false;
    }

    private static boolean w(Format format, @Nullable String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if ((format.x & 16384) != 0 || !u(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !o0.b(format.H3, str)) {
            return false;
        }
        int i12 = format.M3;
        if (i12 != -1 && (i7 > i12 || i12 > i3)) {
            return false;
        }
        int i13 = format.N3;
        if (i13 != -1 && (i8 > i13 || i13 > i4)) {
            return false;
        }
        float f2 = format.O3;
        return (f2 == -1.0f || (((float) i9) <= f2 && f2 <= ((float) i5))) && (i11 = format.p0) != -1 && i10 <= i11 && i11 <= i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int x(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int y(Integer num, Integer num2) {
        return 0;
    }

    private static void z(i.a aVar, int[][][] iArr, e2[] e2VarArr, g[] gVarArr) {
        boolean z;
        boolean z2 = false;
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < aVar.c(); i3++) {
            int d2 = aVar.d(i3);
            g gVar = gVarArr[i3];
            if ((d2 == 1 || d2 == 2) && gVar != null && B(iArr[i3], aVar.e(i3), gVar)) {
                if (d2 == 1) {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i3;
                } else if (i != -1) {
                    z = false;
                    break;
                } else {
                    i = i3;
                }
            }
        }
        z = true;
        if (!(i2 == -1 || i == -1)) {
            z2 = true;
        }
        if (z && z2) {
            e2 e2Var = new e2(true);
            e2VarArr[i2] = e2Var;
            e2VarArr[i] = e2Var;
        }
    }

    protected g.a[] D(i.a aVar, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        int i;
        int i2;
        int c2 = aVar.c();
        g.a[] aVarArr = new g.a[c2];
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = 1;
            if (i3 >= c2) {
                break;
            }
            if (2 == aVar.d(i3)) {
                if (!z) {
                    aVarArr[i3] = I(aVar.e(i3), iArr[i3], iArr2[i3], parameters, true);
                    z = aVarArr[i3] != null;
                }
                if (aVar.e(i3).f3161d <= 0) {
                    i = 0;
                }
                i4 |= i;
            }
            i3++;
        }
        b bVar = null;
        String str = null;
        int i5 = -1;
        int i6 = 0;
        while (i6 < c2) {
            if (i == aVar.d(i6)) {
                i5 = i5;
                bVar = bVar;
                str = str;
                i2 = i6;
                Pair<g.a, b> E = E(aVar.e(i6), iArr[i6], iArr2[i6], parameters, parameters.g4 || i4 == 0);
                if (E != null && (bVar == null || ((b) E.second).compareTo(bVar) > 0)) {
                    if (i5 != -1) {
                        aVarArr[i5] = null;
                    }
                    g.a aVar2 = (g.a) E.first;
                    aVarArr[i2] = aVar2;
                    str = aVar2.a.a(aVar2.f3641b[0]).f2006f;
                    bVar = (b) E.second;
                    i5 = i2;
                    i6 = i2 + 1;
                    i = 1;
                }
            } else {
                i5 = i5;
                bVar = bVar;
                str = str;
                i2 = i6;
            }
            i6 = i2 + 1;
            i = 1;
        }
        String str2 = str;
        e eVar = null;
        int i7 = -1;
        for (int i8 = 0; i8 < c2; i8++) {
            int d2 = aVar.d(i8);
            if (d2 != 1) {
                if (d2 != 2) {
                    if (d2 != 3) {
                        aVarArr[i8] = G(d2, aVar.e(i8), iArr[i8], parameters);
                    } else {
                        str2 = str2;
                        Pair<g.a, e> H = H(aVar.e(i8), iArr[i8], parameters, str2);
                        if (H != null && (eVar == null || ((e) H.second).compareTo(eVar) > 0)) {
                            if (i7 != -1) {
                                aVarArr[i7] = null;
                            }
                            aVarArr[i8] = (g.a) H.first;
                            eVar = (e) H.second;
                            i7 = i8;
                        }
                    }
                }
                str2 = str2;
            } else {
                str2 = str2;
            }
        }
        return aVarArr;
    }

    @Nullable
    protected Pair<g.a, b> E(TrackGroupArray trackGroupArray, int[][] iArr, int i, Parameters parameters, boolean z) throws ExoPlaybackException {
        g.a aVar = null;
        b bVar = null;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < trackGroupArray.f3161d; i4++) {
            TrackGroup a2 = trackGroupArray.a(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < a2.f3157c; i5++) {
                if (u(iArr2[i5], parameters.e4)) {
                    b bVar2 = new b(a2.a(i5), parameters, iArr2[i5]);
                    if ((bVar2.f3608c || parameters.a4) && (bVar == null || bVar2.compareTo(bVar) > 0)) {
                        i2 = i4;
                        i3 = i5;
                        bVar = bVar2;
                    }
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        TrackGroup a3 = trackGroupArray.a(i2);
        if (!parameters.T3 && !parameters.S3 && z) {
            int[] n = n(a3, iArr[i2], i3, parameters.N3, parameters.b4, parameters.c4, parameters.d4);
            if (n.length > 1) {
                aVar = new g.a(a3, n);
            }
        }
        if (aVar == null) {
            aVar = new g.a(a3, i3);
        }
        return Pair.create(aVar, (b) com.google.android.exoplayer2.util.g.e(bVar));
    }

    @Nullable
    protected g.a G(int i, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        c cVar = null;
        int i2 = 0;
        for (int i3 = 0; i3 < trackGroupArray.f3161d; i3++) {
            TrackGroup a2 = trackGroupArray.a(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < a2.f3157c; i4++) {
                if (u(iArr2[i4], parameters.e4)) {
                    c cVar2 = new c(a2.a(i4), iArr2[i4]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        trackGroup = a2;
                        i2 = i4;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new g.a(trackGroup, i2);
    }

    @Nullable
    protected Pair<g.a, e> H(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, @Nullable String str) throws ExoPlaybackException {
        int i = -1;
        TrackGroup trackGroup = null;
        e eVar = null;
        for (int i2 = 0; i2 < trackGroupArray.f3161d; i2++) {
            TrackGroup a2 = trackGroupArray.a(i2);
            int[] iArr2 = iArr[i2];
            for (int i3 = 0; i3 < a2.f3157c; i3++) {
                if (u(iArr2[i3], parameters.e4)) {
                    e eVar2 = new e(a2.a(i3), parameters, iArr2[i3], str);
                    if (eVar2.f3613c && (eVar == null || eVar2.compareTo(eVar) > 0)) {
                        trackGroup = a2;
                        i = i3;
                        eVar = eVar2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return Pair.create(new g.a(trackGroup, i), (e) com.google.android.exoplayer2.util.g.e(eVar));
    }

    @Nullable
    protected g.a I(TrackGroupArray trackGroupArray, int[][] iArr, int i, Parameters parameters, boolean z) throws ExoPlaybackException {
        g.a C = (parameters.T3 || parameters.S3 || !z) ? null : C(trackGroupArray, iArr, i, parameters);
        return C == null ? F(trackGroupArray, iArr, parameters) : C;
    }

    public void J(Parameters parameters) {
        com.google.android.exoplayer2.util.g.e(parameters);
        if (!this.h.getAndSet(parameters).equals(parameters)) {
            c();
        }
    }

    public void K(d dVar) {
        J(dVar.w());
    }

    @Override // com.google.android.exoplayer2.trackselection.i
    protected final Pair<e2[], g[]> j(i.a aVar, int[][][] iArr, int[] iArr2, e0.a aVar2, j2 j2Var) throws ExoPlaybackException {
        Parameters parameters = this.h.get();
        int c2 = aVar.c();
        g.a[] D = D(aVar, iArr, iArr2, parameters);
        int i = 0;
        while (true) {
            g.a aVar3 = null;
            if (i >= c2) {
                break;
            }
            if (parameters.i(i)) {
                D[i] = null;
            } else {
                TrackGroupArray e2 = aVar.e(i);
                if (parameters.m(i, e2)) {
                    SelectionOverride l = parameters.l(i, e2);
                    if (l != null) {
                        aVar3 = new g.a(e2.a(l.f3605c), l.f3606d, l.q);
                    }
                    D[i] = aVar3;
                }
            }
            i++;
        }
        g[] a2 = this.g.a(D, a(), aVar2, j2Var);
        e2[] e2VarArr = new e2[c2];
        for (int i2 = 0; i2 < c2; i2++) {
            e2VarArr[i2] = !parameters.i(i2) && (aVar.d(i2) == 7 || a2[i2] != null) ? e2.a : null;
        }
        if (parameters.f4) {
            z(aVar, iArr, e2VarArr, a2);
        }
        return Pair.create(e2VarArr, a2);
    }

    public Parameters s() {
        return this.h.get();
    }

    public DefaultTrackSelector(Context context) {
        this(context, new d.b());
    }

    public DefaultTrackSelector(Context context, g.b bVar) {
        this(Parameters.h(context), bVar);
    }

    public DefaultTrackSelector(Parameters parameters, g.b bVar) {
        this.g = bVar;
        this.h = new AtomicReference<>(parameters);
    }
}
