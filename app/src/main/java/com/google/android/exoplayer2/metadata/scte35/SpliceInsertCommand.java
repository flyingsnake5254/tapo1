package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new a();
    public final int H3;
    public final int I3;

    /* renamed from: c  reason: collision with root package name */
    public final long f2598c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2599d;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f2600f;
    public final List<b> p0;
    public final boolean p1;
    public final long p2;
    public final int p3;
    public final boolean q;
    public final boolean x;
    public final long y;
    public final long z;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<SpliceInsertCommand> {
        a() {
        }

        /* renamed from: a */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel, null);
        }

        /* renamed from: b */
        public SpliceInsertCommand[] newArray(int i) {
            return new SpliceInsertCommand[i];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final long f2601b;

        /* renamed from: c  reason: collision with root package name */
        public final long f2602c;

        /* synthetic */ b(int i, long j, long j2, a aVar) {
            this(i, j, j2);
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.f2601b);
            parcel.writeLong(this.f2602c);
        }

        private b(int i, long j, long j2) {
            this.a = i;
            this.f2601b = j;
            this.f2602c = j2;
        }
    }

    /* synthetic */ SpliceInsertCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpliceInsertCommand a(d0 d0Var, long j, l0 l0Var) {
        boolean z;
        int i;
        int i2;
        int i3;
        long j2;
        boolean z2;
        long j3;
        boolean z3;
        boolean z4;
        long F = d0Var.F();
        boolean z5 = (d0Var.D() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (!z5) {
            int D = d0Var.D();
            z4 = (D & 128) != 0;
            boolean z6 = (D & 64) != 0;
            boolean z7 = (D & 32) != 0;
            boolean z8 = (D & 16) != 0;
            j3 = (!z6 || z8) ? -9223372036854775807L : TimeSignalCommand.b(d0Var, j);
            if (!z6) {
                int D2 = d0Var.D();
                ArrayList arrayList = new ArrayList(D2);
                for (int i4 = 0; i4 < D2; i4++) {
                    int D3 = d0Var.D();
                    long b2 = !z8 ? TimeSignalCommand.b(d0Var, j) : -9223372036854775807L;
                    arrayList.add(new b(D3, b2, l0Var.b(b2), null));
                }
                emptyList = arrayList;
            }
            if (z7) {
                long D4 = d0Var.D();
                z2 = (128 & D4) != 0;
                j2 = ((((D4 & 1) << 32) | d0Var.F()) * 1000) / 90;
            } else {
                z2 = false;
                j2 = -9223372036854775807L;
            }
            i3 = d0Var.J();
            z = z6;
            i2 = d0Var.D();
            i = d0Var.D();
            z3 = z8;
        } else {
            emptyList = emptyList;
            z4 = false;
            z3 = false;
            j3 = -9223372036854775807L;
            z2 = false;
            j2 = -9223372036854775807L;
            i3 = 0;
            i2 = 0;
            i = 0;
            z = false;
        }
        return new SpliceInsertCommand(F, z5, z4, z, z3, j3, l0Var.b(j3), emptyList, z2, j2, i3, i2, i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f2598c);
        parcel.writeByte(this.f2599d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2600f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.q ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.x ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.y);
        parcel.writeLong(this.z);
        int size = this.p0.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.p0.get(i2).b(parcel);
        }
        parcel.writeByte(this.p1 ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.p2);
        parcel.writeInt(this.p3);
        parcel.writeInt(this.H3);
        parcel.writeInt(this.I3);
    }

    private SpliceInsertCommand(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<b> list, boolean z5, long j4, int i, int i2, int i3) {
        this.f2598c = j;
        this.f2599d = z;
        this.f2600f = z2;
        this.q = z3;
        this.x = z4;
        this.y = j2;
        this.z = j3;
        this.p0 = Collections.unmodifiableList(list);
        this.p1 = z5;
        this.p2 = j4;
        this.p3 = i;
        this.H3 = i2;
        this.I3 = i3;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.f2598c = parcel.readLong();
        boolean z = false;
        this.f2599d = parcel.readByte() == 1;
        this.f2600f = parcel.readByte() == 1;
        this.q = parcel.readByte() == 1;
        this.x = parcel.readByte() == 1;
        this.y = parcel.readLong();
        this.z = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(b.a(parcel));
        }
        this.p0 = Collections.unmodifiableList(arrayList);
        this.p1 = parcel.readByte() == 1 ? true : z;
        this.p2 = parcel.readLong();
        this.p3 = parcel.readInt();
        this.H3 = parcel.readInt();
        this.I3 = parcel.readInt();
    }
}
