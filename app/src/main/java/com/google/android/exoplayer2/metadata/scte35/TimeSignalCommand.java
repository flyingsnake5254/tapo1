package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;

/* loaded from: classes.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final long f2610c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2611d;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<TimeSignalCommand> {
        a() {
        }

        /* renamed from: a */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), null);
        }

        /* renamed from: b */
        public TimeSignalCommand[] newArray(int i) {
            return new TimeSignalCommand[i];
        }
    }

    /* synthetic */ TimeSignalCommand(long j, long j2, a aVar) {
        this(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TimeSignalCommand a(d0 d0Var, long j, l0 l0Var) {
        long b2 = b(d0Var, j);
        return new TimeSignalCommand(b2, l0Var.b(b2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(d0 d0Var, long j) {
        long D = d0Var.D();
        if ((128 & D) != 0) {
            return 8589934591L & ((((D & 1) << 32) | d0Var.F()) + j);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f2610c);
        parcel.writeLong(this.f2611d);
    }

    private TimeSignalCommand(long j, long j2) {
        this.f2610c = j;
        this.f2611d = j2;
    }
}
