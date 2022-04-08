package com.google.android.exoplayer2.o2.j0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.u;
import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: PsshAtomUtil.java */
/* loaded from: classes.dex */
public final class l {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PsshAtomUtil.java */
    /* loaded from: classes.dex */
    public static class a {
        private final UUID a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2812b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f2813c;

        public a(UUID uuid, int i, byte[] bArr) {
            this.a = uuid;
            this.f2812b = i;
            this.f2813c = bArr;
        }
    }

    public static byte[] a(UUID uuid, @Nullable byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, @Nullable UUID[] uuidArr, @Nullable byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (!(bArr == null || bArr.length == 0)) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    @Nullable
    private static a d(byte[] bArr) {
        d0 d0Var = new d0(bArr);
        if (d0Var.f() < 32) {
            return null;
        }
        d0Var.P(0);
        if (d0Var.n() != d0Var.a() + 4 || d0Var.n() != 1886614376) {
            return null;
        }
        int c2 = e.c(d0Var.n());
        if (c2 > 1) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Unsupported pssh version: ");
            sb.append(c2);
            u.h("PsshAtomUtil", sb.toString());
            return null;
        }
        UUID uuid = new UUID(d0Var.w(), d0Var.w());
        if (c2 == 1) {
            d0Var.Q(d0Var.H() * 16);
        }
        int H = d0Var.H();
        if (H != d0Var.a()) {
            return null;
        }
        byte[] bArr2 = new byte[H];
        d0Var.j(bArr2, 0, H);
        return new a(uuid, c2, bArr2);
    }

    @Nullable
    public static byte[] e(byte[] bArr, UUID uuid) {
        a d2 = d(bArr);
        if (d2 == null) {
            return null;
        }
        if (uuid.equals(d2.a)) {
            return d2.f2813c;
        }
        String valueOf = String.valueOf(uuid);
        String valueOf2 = String.valueOf(d2.a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 33 + valueOf2.length());
        sb.append("UUID mismatch. Expected: ");
        sb.append(valueOf);
        sb.append(", got: ");
        sb.append(valueOf2);
        sb.append(".");
        u.h("PsshAtomUtil", sb.toString());
        return null;
    }

    @Nullable
    public static UUID f(byte[] bArr) {
        a d2 = d(bArr);
        if (d2 == null) {
            return null;
        }
        return d2.a;
    }

    public static int g(byte[] bArr) {
        a d2 = d(bArr);
        if (d2 == null) {
            return -1;
        }
        return d2.f2812b;
    }
}
