package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;

/* loaded from: classes.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public final long f2595c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2596d;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f2597f;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<PrivateCommand> {
        a() {
        }

        /* renamed from: a */
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel, null);
        }

        /* renamed from: b */
        public PrivateCommand[] newArray(int i) {
            return new PrivateCommand[i];
        }
    }

    /* synthetic */ PrivateCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PrivateCommand a(d0 d0Var, int i, long j) {
        long F = d0Var.F();
        int i2 = i - 4;
        byte[] bArr = new byte[i2];
        d0Var.j(bArr, 0, i2);
        return new PrivateCommand(F, bArr, j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f2595c);
        parcel.writeLong(this.f2596d);
        parcel.writeByteArray(this.f2597f);
    }

    private PrivateCommand(long j, byte[] bArr, long j2) {
        this.f2595c = j2;
        this.f2596d = j;
        this.f2597f = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.f2595c = parcel.readLong();
        this.f2596d = parcel.readLong();
        this.f2597f = (byte[]) o0.i(parcel.createByteArray());
    }
}
