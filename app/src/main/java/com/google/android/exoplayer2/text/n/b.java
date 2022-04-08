package com.google.android.exoplayer2.text.n;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: DvbParser.java */
/* loaded from: classes.dex */
final class b {
    private static final byte[] a = {0, 7, 8, BinaryMemcacheOpcodes.PREPEND};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f3474b = {0, 119, -120, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f3475c = {0, BinaryMemcacheOpcodes.SETQ, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: d  reason: collision with root package name */
    private final Paint f3476d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f3477e;

    /* renamed from: f  reason: collision with root package name */
    private final Canvas f3478f = new Canvas();
    private final C0085b g = new C0085b(719, 575, 0, 719, 0, 575);
    private final a h = new a(0, c(), d(), e());
    private final h i;
    private Bitmap j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DvbParser.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f3479b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f3480c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f3481d;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.a = i;
            this.f3479b = iArr;
            this.f3480c = iArr2;
            this.f3481d = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DvbParser.java */
    /* renamed from: com.google.android.exoplayer2.text.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0085b {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3482b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3483c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3484d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3485e;

        /* renamed from: f  reason: collision with root package name */
        public final int f3486f;

        public C0085b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.f3482b = i2;
            this.f3483c = i3;
            this.f3484d = i4;
            this.f3485e = i5;
            this.f3486f = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DvbParser.java */
    /* loaded from: classes.dex */
    public static final class c {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3487b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f3488c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f3489d;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.a = i;
            this.f3487b = z;
            this.f3488c = bArr;
            this.f3489d = bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DvbParser.java */
    /* loaded from: classes.dex */
    public static final class d {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3490b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3491c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<e> f3492d;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.a = i;
            this.f3490b = i2;
            this.f3491c = i3;
            this.f3492d = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DvbParser.java */
    /* loaded from: classes.dex */
    public static final class e {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3493b;

        public e(int i, int i2) {
            this.a = i;
            this.f3493b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DvbParser.java */
    /* loaded from: classes.dex */
    public static final class f {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3494b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3495c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3496d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3497e;

        /* renamed from: f  reason: collision with root package name */
        public final int f3498f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final SparseArray<g> k;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.a = i;
            this.f3494b = z;
            this.f3495c = i2;
            this.f3496d = i3;
            this.f3497e = i4;
            this.f3498f = i5;
            this.g = i6;
            this.h = i7;
            this.i = i8;
            this.j = i9;
            this.k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray<g> sparseArray = fVar.k;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.k.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DvbParser.java */
    /* loaded from: classes.dex */
    public static final class g {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3499b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3500c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3501d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3502e;

        /* renamed from: f  reason: collision with root package name */
        public final int f3503f;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.f3499b = i2;
            this.f3500c = i3;
            this.f3501d = i4;
            this.f3502e = i5;
            this.f3503f = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DvbParser.java */
    /* loaded from: classes.dex */
    public static final class h {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3504b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray<f> f3505c = new SparseArray<>();

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<a> f3506d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<c> f3507e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        public final SparseArray<a> f3508f = new SparseArray<>();
        public final SparseArray<c> g = new SparseArray<>();
        @Nullable
        public C0085b h;
        @Nullable
        public d i;

        public h(int i, int i2) {
            this.a = i;
            this.f3504b = i2;
        }

        public void a() {
            this.f3505c.clear();
            this.f3506d.clear();
            this.f3507e.clear();
            this.f3508f.clear();
            this.g.clear();
            this.h = null;
            this.i = null;
        }
    }

    public b(int i, int i2) {
        Paint paint = new Paint();
        this.f3476d = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f3477e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.i = new h(i, i2);
    }

    private static byte[] a(int i, int i2, c0 c0Var) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) c0Var.h(i2);
        }
        return bArr;
    }

    private static int[] c() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = f(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i2 = 127;
                int i3 = (i & 1) != 0 ? 127 : 0;
                int i4 = (i & 2) != 0 ? 127 : 0;
                if ((i & 4) == 0) {
                    i2 = 0;
                }
                iArr[i] = f(255, i3, i4, i2);
            }
        }
        return iArr;
    }

    private static int[] e() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            int i2 = 255;
            if (i < 8) {
                int i3 = (i & 1) != 0 ? 255 : 0;
                int i4 = (i & 2) != 0 ? 255 : 0;
                if ((i & 4) == 0) {
                    i2 = 0;
                }
                iArr[i] = f(63, i3, i4, i2);
            } else {
                int i5 = i & 136;
                int i6 = 170;
                int i7 = 85;
                if (i5 == 0) {
                    int i8 = ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0);
                    int i9 = ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0);
                    if ((i & 4) == 0) {
                        i7 = 0;
                    }
                    if ((i & 64) == 0) {
                        i6 = 0;
                    }
                    iArr[i] = f(255, i8, i9, i7 + i6);
                } else if (i5 != 8) {
                    int i10 = 43;
                    if (i5 == 128) {
                        int i11 = ((i & 1) != 0 ? 43 : 0) + 127 + ((i & 16) != 0 ? 85 : 0);
                        int i12 = ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0);
                        if ((i & 4) == 0) {
                            i10 = 0;
                        }
                        int i13 = i10 + 127;
                        if ((i & 64) == 0) {
                            i7 = 0;
                        }
                        iArr[i] = f(255, i11, i12, i13 + i7);
                    } else if (i5 == 136) {
                        int i14 = ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0);
                        int i15 = ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0);
                        if ((i & 4) == 0) {
                            i10 = 0;
                        }
                        if ((i & 64) == 0) {
                            i7 = 0;
                        }
                        iArr[i] = f(255, i14, i15, i10 + i7);
                    }
                } else {
                    int i16 = ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0);
                    int i17 = ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0);
                    if ((i & 4) == 0) {
                        i7 = 0;
                    }
                    if ((i & 64) == 0) {
                        i6 = 0;
                    }
                    iArr[i] = f(127, i16, i17, i7 + i6);
                }
            }
        }
        return iArr;
    }

    private static int f(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0063 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083 A[LOOP:0: B:3:0x0009->B:33:0x0083, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int g(com.google.android.exoplayer2.util.c0 r13, int[] r14, @androidx.annotation.Nullable byte[] r15, int r16, int r17, @androidx.annotation.Nullable android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 2
            int r4 = r13.h(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0014
            r11 = r2
        L_0x0012:
            r12 = 1
            goto L_0x0061
        L_0x0014:
            boolean r4 = r13.g()
            r6 = 3
            if (r4 == 0) goto L_0x0028
            int r4 = r13.h(r6)
            int r4 = r4 + r6
            int r3 = r13.h(r3)
        L_0x0024:
            r11 = r2
            r12 = r4
            r4 = r3
            goto L_0x0061
        L_0x0028:
            boolean r4 = r13.g()
            if (r4 == 0) goto L_0x0031
            r11 = r2
            r4 = 0
            goto L_0x0012
        L_0x0031:
            int r4 = r13.h(r3)
            if (r4 == 0) goto L_0x005e
            if (r4 == r5) goto L_0x005a
            if (r4 == r3) goto L_0x004e
            if (r4 == r6) goto L_0x0041
            r11 = r2
            r4 = 0
        L_0x003f:
            r12 = 0
            goto L_0x0061
        L_0x0041:
            r4 = 8
            int r4 = r13.h(r4)
            int r4 = r4 + 29
            int r3 = r13.h(r3)
            goto L_0x0024
        L_0x004e:
            r4 = 4
            int r4 = r13.h(r4)
            int r4 = r4 + 12
            int r3 = r13.h(r3)
            goto L_0x0024
        L_0x005a:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L_0x0061
        L_0x005e:
            r4 = 0
            r11 = 1
            goto L_0x003f
        L_0x0061:
            if (r12 == 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            if (r15 == 0) goto L_0x0069
            byte r4 = r15[r4]
        L_0x0069:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x007f:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0083
            return r10
        L_0x0083:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.n.b.g(com.google.android.exoplayer2.util.c0, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0070 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008e A[LOOP:0: B:3:0x0009->B:36:0x008e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008d A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int h(com.google.android.exoplayer2.util.c0 r13, int[] r14, @androidx.annotation.Nullable byte[] r15, int r16, int r17, @androidx.annotation.Nullable android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 4
            int r4 = r13.h(r3)
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0016
            r11 = r2
        L_0x0013:
            r12 = 1
            goto L_0x006e
        L_0x0016:
            boolean r4 = r13.g()
            r7 = 3
            if (r4 != 0) goto L_0x002c
            int r3 = r13.h(r7)
            if (r3 == 0) goto L_0x0029
            int r5 = r3 + 2
            r11 = r2
            r12 = r5
            r4 = 0
            goto L_0x006e
        L_0x0029:
            r4 = 0
            r11 = 1
            goto L_0x004d
        L_0x002c:
            boolean r4 = r13.g()
            if (r4 != 0) goto L_0x003f
            int r4 = r13.h(r5)
            int r5 = r4 + 4
            int r4 = r13.h(r3)
        L_0x003c:
            r11 = r2
            r12 = r5
            goto L_0x006e
        L_0x003f:
            int r4 = r13.h(r5)
            if (r4 == 0) goto L_0x006b
            if (r4 == r6) goto L_0x0067
            if (r4 == r5) goto L_0x005c
            if (r4 == r7) goto L_0x004f
            r11 = r2
            r4 = 0
        L_0x004d:
            r12 = 0
            goto L_0x006e
        L_0x004f:
            r4 = 8
            int r4 = r13.h(r4)
            int r5 = r4 + 25
            int r4 = r13.h(r3)
            goto L_0x003c
        L_0x005c:
            int r4 = r13.h(r3)
            int r5 = r4 + 9
            int r4 = r13.h(r3)
            goto L_0x003c
        L_0x0067:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L_0x006e
        L_0x006b:
            r11 = r2
            r4 = 0
            goto L_0x0013
        L_0x006e:
            if (r12 == 0) goto L_0x008a
            if (r8 == 0) goto L_0x008a
            if (r15 == 0) goto L_0x0076
            byte r4 = r15[r4]
        L_0x0076:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r5 = (float) r2
            int r2 = r1 + 1
            float r6 = (float) r2
            r2 = r19
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x008a:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x008e
            return r10
        L_0x008e:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.n.b.h(com.google.android.exoplayer2.util.c0, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    private static int i(c0 c0Var, int[] iArr, @Nullable byte[] bArr, int i, int i2, @Nullable Paint paint, Canvas canvas) {
        int i3;
        boolean z;
        byte b2;
        int i4 = i;
        boolean z2 = false;
        while (true) {
            int h2 = c0Var.h(8);
            if (h2 != 0) {
                z = z2;
                i3 = 1;
                b2 = h2;
            } else if (!c0Var.g()) {
                int h3 = c0Var.h(7);
                if (h3 != 0) {
                    z = z2;
                    i3 = h3;
                    b2 = 0;
                } else {
                    b2 = 0;
                    z = true;
                    i3 = 0;
                }
            } else {
                z = z2;
                i3 = c0Var.h(7);
                b2 = c0Var.h(8);
            }
            if (!(i3 == 0 || paint == null)) {
                if (bArr != 0) {
                    b2 = bArr[b2];
                }
                paint.setColor(iArr[b2 == true ? 1 : 0]);
                canvas.drawRect(i4, i2, i4 + i3, i2 + 1, paint);
            }
            i4 += i3;
            if (z) {
                return i4;
            }
            z2 = z;
        }
    }

    private static void j(byte[] bArr, int[] iArr, int i, int i2, int i3, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        c0 c0Var = new c0(bArr);
        int i4 = i2;
        int i5 = i3;
        byte[] bArr4 = null;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        while (c0Var.b() != 0) {
            int h2 = c0Var.h(8);
            if (h2 != 240) {
                switch (h2) {
                    case 16:
                        if (i == 3) {
                            bArr2 = bArr4 == null ? f3474b : bArr4;
                        } else if (i == 2) {
                            bArr2 = bArr6 == null ? a : bArr6;
                        } else {
                            bArr2 = null;
                            i4 = g(c0Var, iArr, bArr2, i4, i5, paint, canvas);
                            c0Var.c();
                            continue;
                        }
                        i4 = g(c0Var, iArr, bArr2, i4, i5, paint, canvas);
                        c0Var.c();
                        continue;
                    case 17:
                        if (i == 3) {
                            bArr3 = bArr5 == null ? f3475c : bArr5;
                        } else {
                            bArr3 = null;
                        }
                        i4 = h(c0Var, iArr, bArr3, i4, i5, paint, canvas);
                        c0Var.c();
                        continue;
                    case 18:
                        i4 = i(c0Var, iArr, null, i4, i5, paint, canvas);
                        continue;
                    default:
                        switch (h2) {
                            case 32:
                                bArr6 = a(4, 4, c0Var);
                                continue;
                            case 33:
                                bArr4 = a(4, 8, c0Var);
                                continue;
                            case 34:
                                bArr5 = a(16, 8, c0Var);
                                continue;
                            default:
                                continue;
                        }
                }
            } else {
                i5 += 2;
                i4 = i2;
            }
        }
    }

    private static void k(c cVar, a aVar, int i, int i2, int i3, @Nullable Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = aVar.f3481d;
        } else if (i == 2) {
            iArr = aVar.f3480c;
        } else {
            iArr = aVar.f3479b;
        }
        j(cVar.f3488c, iArr, i, i2, i3, paint, canvas);
        j(cVar.f3489d, iArr, i, i2, i3 + 1, paint, canvas);
    }

    private static a l(c0 c0Var, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 8;
        int h2 = c0Var.h(8);
        c0Var.r(8);
        int i7 = 2;
        int i8 = i - 2;
        int[] c2 = c();
        int[] d2 = d();
        int[] e2 = e();
        while (i8 > 0) {
            int h3 = c0Var.h(i6);
            int h4 = c0Var.h(i6);
            int i9 = i8 - 2;
            int[] iArr = (h4 & 128) != 0 ? c2 : (h4 & 64) != 0 ? d2 : e2;
            if ((h4 & 1) != 0) {
                i5 = c0Var.h(i6);
                i4 = c0Var.h(i6);
                i3 = c0Var.h(i6);
                i2 = c0Var.h(i6);
                i8 = i9 - 4;
            } else {
                i5 = c0Var.h(6) << i7;
                i4 = c0Var.h(4) << 4;
                i3 = c0Var.h(4) << 4;
                i2 = c0Var.h(i7) << 6;
                i8 = i9 - 2;
            }
            if (i5 == 0) {
                i4 = 0;
                i3 = 0;
                i2 = 255;
            }
            double d3 = i5;
            double d4 = i4 - 128;
            double d5 = i3 - 128;
            iArr[h3] = f((byte) (255 - (i2 & 255)), o0.p((int) (d3 + (1.402d * d4)), 0, 255), o0.p((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 0, 255), o0.p((int) (d3 + (d5 * 1.772d)), 0, 255));
            h2 = h2;
            i6 = 8;
            i7 = 2;
        }
        return new a(h2, c2, d2, e2);
    }

    private static C0085b m(c0 c0Var) {
        int i;
        int i2;
        int i3;
        int i4;
        c0Var.r(4);
        boolean g2 = c0Var.g();
        c0Var.r(3);
        int h2 = c0Var.h(16);
        int h3 = c0Var.h(16);
        if (g2) {
            int h4 = c0Var.h(16);
            int h5 = c0Var.h(16);
            int h6 = c0Var.h(16);
            i = c0Var.h(16);
            i3 = h5;
            i2 = h6;
            i4 = h4;
        } else {
            i3 = h2;
            i = h3;
            i4 = 0;
            i2 = 0;
        }
        return new C0085b(h2, h3, i4, i3, i2, i);
    }

    private static c n(c0 c0Var) {
        byte[] bArr;
        int h2 = c0Var.h(16);
        c0Var.r(4);
        int h3 = c0Var.h(2);
        boolean g2 = c0Var.g();
        c0Var.r(1);
        byte[] bArr2 = o0.f3937f;
        if (h3 == 1) {
            c0Var.r(c0Var.h(8) * 16);
        } else if (h3 == 0) {
            int h4 = c0Var.h(16);
            int h5 = c0Var.h(16);
            if (h4 > 0) {
                bArr2 = new byte[h4];
                c0Var.k(bArr2, 0, h4);
            }
            if (h5 > 0) {
                bArr = new byte[h5];
                c0Var.k(bArr, 0, h5);
                return new c(h2, g2, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(h2, g2, bArr2, bArr);
    }

    private static d o(c0 c0Var, int i) {
        int h2 = c0Var.h(8);
        int h3 = c0Var.h(4);
        int h4 = c0Var.h(2);
        c0Var.r(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int h5 = c0Var.h(8);
            c0Var.r(8);
            i2 -= 6;
            sparseArray.put(h5, new e(c0Var.h(16), c0Var.h(16)));
        }
        return new d(h2, h3, h4, sparseArray);
    }

    private static f p(c0 c0Var, int i) {
        int i2;
        int i3;
        int h2 = c0Var.h(8);
        c0Var.r(4);
        boolean g2 = c0Var.g();
        c0Var.r(3);
        int i4 = 16;
        int h3 = c0Var.h(16);
        int h4 = c0Var.h(16);
        int h5 = c0Var.h(3);
        int h6 = c0Var.h(3);
        int i5 = 2;
        c0Var.r(2);
        int h7 = c0Var.h(8);
        int h8 = c0Var.h(8);
        int h9 = c0Var.h(4);
        int h10 = c0Var.h(2);
        c0Var.r(2);
        int i6 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i6 > 0) {
            int h11 = c0Var.h(i4);
            int h12 = c0Var.h(i5);
            int h13 = c0Var.h(i5);
            int h14 = c0Var.h(12);
            c0Var.r(4);
            int h15 = c0Var.h(12);
            i6 -= 6;
            if (h12 == 1 || h12 == 2) {
                i6 -= 2;
                i3 = c0Var.h(8);
                i2 = c0Var.h(8);
            } else {
                i3 = 0;
                i2 = 0;
            }
            sparseArray.put(h11, new g(h12, h13, h14, h15, i3, i2));
            h10 = h10;
            i5 = 2;
            i4 = 16;
        }
        return new f(h2, g2, h3, h4, h5, h6, h7, h8, h9, h10, sparseArray);
    }

    private static void q(c0 c0Var, h hVar) {
        f fVar;
        int h2 = c0Var.h(8);
        int h3 = c0Var.h(16);
        int h4 = c0Var.h(16);
        int d2 = c0Var.d() + h4;
        if (h4 * 8 > c0Var.b()) {
            u.h("DvbParser", "Data field length exceeds limit");
            c0Var.r(c0Var.b());
            return;
        }
        switch (h2) {
            case 16:
                if (h3 == hVar.a) {
                    d dVar = hVar.i;
                    d o = o(c0Var, h4);
                    if (o.f3491c == 0) {
                        if (!(dVar == null || dVar.f3490b == o.f3490b)) {
                            hVar.i = o;
                            break;
                        }
                    } else {
                        hVar.i = o;
                        hVar.f3505c.clear();
                        hVar.f3506d.clear();
                        hVar.f3507e.clear();
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.i;
                if (h3 == hVar.a && dVar2 != null) {
                    f p = p(c0Var, h4);
                    if (dVar2.f3491c == 0 && (fVar = hVar.f3505c.get(p.a)) != null) {
                        p.a(fVar);
                    }
                    hVar.f3505c.put(p.a, p);
                    break;
                }
                break;
            case 18:
                if (h3 != hVar.a) {
                    if (h3 == hVar.f3504b) {
                        a l = l(c0Var, h4);
                        hVar.f3508f.put(l.a, l);
                        break;
                    }
                } else {
                    a l2 = l(c0Var, h4);
                    hVar.f3506d.put(l2.a, l2);
                    break;
                }
                break;
            case 19:
                if (h3 != hVar.a) {
                    if (h3 == hVar.f3504b) {
                        c n = n(c0Var);
                        hVar.g.put(n.a, n);
                        break;
                    }
                } else {
                    c n2 = n(c0Var);
                    hVar.f3507e.put(n2.a, n2);
                    break;
                }
                break;
            case 20:
                if (h3 == hVar.a) {
                    hVar.h = m(c0Var);
                    break;
                }
                break;
        }
        c0Var.s(d2 - c0Var.d());
    }

    public List<com.google.android.exoplayer2.text.c> b(byte[] bArr, int i) {
        int i2;
        int i3;
        c0 c0Var = new c0(bArr, i);
        while (c0Var.b() >= 48 && c0Var.h(8) == 15) {
            q(c0Var, this.i);
        }
        h hVar = this.i;
        d dVar = hVar.i;
        if (dVar == null) {
            return Collections.emptyList();
        }
        C0085b bVar = hVar.h;
        if (bVar == null) {
            bVar = this.g;
        }
        Bitmap bitmap = this.j;
        if (!(bitmap != null && bVar.a + 1 == bitmap.getWidth() && bVar.f3482b + 1 == this.j.getHeight())) {
            Bitmap createBitmap = Bitmap.createBitmap(bVar.a + 1, bVar.f3482b + 1, Bitmap.Config.ARGB_8888);
            this.j = createBitmap;
            this.f3478f.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = dVar.f3492d;
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            this.f3478f.save();
            e valueAt = sparseArray.valueAt(i4);
            f fVar = this.i.f3505c.get(sparseArray.keyAt(i4));
            int i5 = valueAt.a + bVar.f3483c;
            int i6 = valueAt.f3493b + bVar.f3485e;
            this.f3478f.clipRect(i5, i6, Math.min(fVar.f3495c + i5, bVar.f3484d), Math.min(fVar.f3496d + i6, bVar.f3486f));
            a aVar = this.i.f3506d.get(fVar.g);
            if (aVar == null && (aVar = this.i.f3508f.get(fVar.g)) == null) {
                aVar = this.h;
            }
            SparseArray<g> sparseArray2 = fVar.k;
            int i7 = 0;
            while (i7 < sparseArray2.size()) {
                int keyAt = sparseArray2.keyAt(i7);
                g valueAt2 = sparseArray2.valueAt(i7);
                c cVar = this.i.f3507e.get(keyAt);
                c cVar2 = cVar == null ? this.i.g.get(keyAt) : cVar;
                if (cVar2 != null) {
                    i3 = i7;
                    sparseArray2 = sparseArray2;
                    k(cVar2, aVar, fVar.f3498f, valueAt2.f3500c + i5, i6 + valueAt2.f3501d, cVar2.f3487b ? null : this.f3476d, this.f3478f);
                } else {
                    i3 = i7;
                    sparseArray2 = sparseArray2;
                }
                i7 = i3 + 1;
            }
            if (fVar.f3494b) {
                int i8 = fVar.f3498f;
                if (i8 == 3) {
                    i2 = aVar.f3481d[fVar.h];
                } else if (i8 == 2) {
                    i2 = aVar.f3480c[fVar.i];
                } else {
                    i2 = aVar.f3479b[fVar.j];
                }
                this.f3477e.setColor(i2);
                this.f3478f.drawRect(i5, i6, fVar.f3495c + i5, fVar.f3496d + i6, this.f3477e);
            }
            arrayList.add(new c.b().f(Bitmap.createBitmap(this.j, i5, i6, fVar.f3495c, fVar.f3496d)).k(i5 / bVar.a).l(0).h(i6 / bVar.f3482b, 0).i(0).n(fVar.f3495c / bVar.a).g(fVar.f3496d / bVar.f3482b).a());
            this.f3478f.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f3478f.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void r() {
        this.i.a();
    }
}
