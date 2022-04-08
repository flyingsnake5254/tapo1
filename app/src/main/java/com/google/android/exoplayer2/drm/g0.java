package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.e0;
import com.google.android.exoplayer2.o2.j0.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.w0;
import com.google.common.base.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: FrameworkMediaDrm.java */
@RequiresApi(18)
/* loaded from: classes.dex */
public final class g0 implements e0 {
    public static final e0.c a = n.a;

    /* renamed from: b  reason: collision with root package name */
    private final UUID f2220b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaDrm f2221c;

    /* renamed from: d  reason: collision with root package name */
    private int f2222d = 1;

    private g0(UUID uuid) throws UnsupportedSchemeException {
        g.e(uuid);
        g.b(!w0.f4081b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f2220b = uuid;
        MediaDrm mediaDrm = new MediaDrm(p(uuid));
        this.f2221c = mediaDrm;
        if (w0.f4083d.equals(uuid) && x()) {
            r(mediaDrm);
        }
    }

    private static byte[] l(byte[] bArr) {
        d0 d0Var = new d0(bArr);
        int q = d0Var.q();
        short s = d0Var.s();
        short s2 = d0Var.s();
        if (s == 1 && s2 == 1) {
            short s3 = d0Var.s();
            Charset charset = e.f4127e;
            String B = d0Var.B(s3, charset);
            if (B.contains("<LA_URL>")) {
                return bArr;
            }
            int indexOf = B.indexOf("</DATA>");
            if (indexOf == -1) {
                u.h("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
            }
            String substring = B.substring(0, indexOf);
            String substring2 = B.substring(indexOf);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 26 + String.valueOf(substring2).length());
            sb.append(substring);
            sb.append("<LA_URL>https://x</LA_URL>");
            sb.append(substring2);
            String sb2 = sb.toString();
            int i = q + 52;
            ByteBuffer allocate = ByteBuffer.allocate(i);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(i);
            allocate.putShort(s);
            allocate.putShort(s2);
            allocate.putShort((short) (sb2.length() * 2));
            allocate.put(sb2.getBytes(charset));
            return allocate.array();
        }
        u.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
        return bArr;
    }

    private static byte[] m(UUID uuid, byte[] bArr) {
        return w0.f4082c.equals(uuid) ? r.a(bArr) : bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
        if ("AFTT".equals(r0) == false) goto L_0x005f;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] n(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = com.google.android.exoplayer2.w0.f4084e
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L_0x0018
            byte[] r1 = com.google.android.exoplayer2.o2.j0.l.e(r4, r3)
            if (r1 != 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r4 = r1
        L_0x0010:
            byte[] r4 = l(r4)
            byte[] r4 = com.google.android.exoplayer2.o2.j0.l.a(r0, r4)
        L_0x0018:
            int r1 = com.google.android.exoplayer2.util.o0.a
            r2 = 23
            if (r1 >= r2) goto L_0x0026
            java.util.UUID r1 = com.google.android.exoplayer2.w0.f4083d
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0058
        L_0x0026:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = com.google.android.exoplayer2.util.o0.f3934c
            java.lang.String r1 = "Amazon"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = com.google.android.exoplayer2.util.o0.f3935d
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x005f
        L_0x0058:
            byte[] r3 = com.google.android.exoplayer2.o2.j0.l.e(r4, r3)
            if (r3 == 0) goto L_0x005f
            return r3
        L_0x005f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.g0.n(java.util.UUID, byte[]):byte[]");
    }

    private static String o(UUID uuid, String str) {
        return (o0.a >= 26 || !w0.f4082c.equals(uuid) || (!"video/mp4".equals(str) && !"audio/mp4".equals(str))) ? str : "cenc";
    }

    private static UUID p(UUID uuid) {
        return (o0.a >= 27 || !w0.f4082c.equals(uuid)) ? uuid : w0.f4081b;
    }

    @SuppressLint({"WrongConstant"})
    private static void r(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static DrmInitData.SchemeData t(UUID uuid, List<DrmInitData.SchemeData> list) {
        boolean z;
        if (!w0.f4083d.equals(uuid)) {
            return list.get(0);
        }
        if (o0.a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = list.get(0);
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                DrmInitData.SchemeData schemeData2 = list.get(i2);
                byte[] bArr = (byte[]) g.e(schemeData2.x);
                if (!o0.b(schemeData2.q, schemeData.q) || !o0.b(schemeData2.f2207f, schemeData.f2207f) || !l.c(bArr)) {
                    z = false;
                    break;
                }
                i += bArr.length;
            }
            z = true;
            if (z) {
                byte[] bArr2 = new byte[i];
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    byte[] bArr3 = (byte[]) g.e(list.get(i4).x);
                    int length = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i3, length);
                    i3 += length;
                }
                return schemeData.a(bArr2);
            }
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            DrmInitData.SchemeData schemeData3 = list.get(i5);
            int g = l.g((byte[]) g.e(schemeData3.x));
            int i6 = o0.a;
            if (i6 < 23 && g == 0) {
                return schemeData3;
            }
            if (i6 >= 23 && g == 1) {
                return schemeData3;
            }
        }
        return list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(e0.b bVar, MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        bVar.a(this, bArr, i, i2, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ e0 w(UUID uuid) {
        try {
            return y(uuid);
        } catch (UnsupportedDrmException unused) {
            String valueOf = String.valueOf(uuid);
            StringBuilder sb = new StringBuilder(valueOf.length() + 53);
            sb.append("Failed to instantiate a FrameworkMediaDrm for uuid: ");
            sb.append(valueOf);
            sb.append(".");
            u.c("FrameworkMediaDrm", sb.toString());
            return new b0();
        }
    }

    private static boolean x() {
        return "ASUS_Z00AD".equals(o0.f3935d);
    }

    public static g0 y(UUID uuid) throws UnsupportedDrmException {
        try {
            return new g0(uuid);
        } catch (UnsupportedSchemeException e2) {
            throw new UnsupportedDrmException(1, e2);
        } catch (Exception e3) {
            throw new UnsupportedDrmException(2, e3);
        }
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public Class<f0> a() {
        return f0.class;
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public Map<String, String> b(byte[] bArr) {
        return this.f2221c.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public e0.d d() {
        MediaDrm.ProvisionRequest provisionRequest = this.f2221c.getProvisionRequest();
        return new e0.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public byte[] e() throws MediaDrmException {
        return this.f2221c.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public void f(byte[] bArr, byte[] bArr2) {
        this.f2221c.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public void g(@Nullable final e0.b bVar) {
        this.f2221c.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: com.google.android.exoplayer2.drm.o
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                g0.this.v(bVar, mediaDrm, bArr, i, i2, bArr2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public void h(byte[] bArr) throws DeniedByServerException {
        this.f2221c.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public void i(byte[] bArr) {
        this.f2221c.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.e0
    @Nullable
    public byte[] j(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (w0.f4082c.equals(this.f2220b)) {
            bArr2 = r.b(bArr2);
        }
        return this.f2221c.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public e0.a k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException {
        String str;
        byte[] bArr2;
        DrmInitData.SchemeData schemeData = null;
        if (list != null) {
            schemeData = t(this.f2220b, list);
            bArr2 = n(this.f2220b, (byte[]) g.e(schemeData.x));
            str = o(this.f2220b, schemeData.q);
        } else {
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f2221c.getKeyRequest(bArr, bArr2, str, i, hashMap);
        byte[] m = m(this.f2220b, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeData != null && !TextUtils.isEmpty(schemeData.f2207f)) {
            defaultUrl = schemeData.f2207f;
        }
        return new e0.a(m, defaultUrl, o0.a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    /* renamed from: q */
    public f0 c(byte[] bArr) throws MediaCryptoException {
        return new f0(p(this.f2220b), bArr, o0.a < 21 && w0.f4083d.equals(this.f2220b) && "L3".equals(s("securityLevel")));
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public synchronized void release() {
        int i = this.f2222d - 1;
        this.f2222d = i;
        if (i == 0) {
            this.f2221c.release();
        }
    }

    public String s(String str) {
        return this.f2221c.getPropertyString(str);
    }
}
