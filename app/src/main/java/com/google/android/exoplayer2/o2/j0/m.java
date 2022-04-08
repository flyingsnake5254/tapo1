package com.google.android.exoplayer2.o2.j0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.util.d0;
import com.google.common.base.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SefReader.java */
/* loaded from: classes.dex */
final class m {
    private static final r a = r.d(':');

    /* renamed from: b  reason: collision with root package name */
    private static final r f2814b = r.d('*');

    /* renamed from: c  reason: collision with root package name */
    private final List<a> f2815c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private int f2816d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f2817e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SefReader.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final long f2818b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2819c;

        public a(int i, long j, int i2) {
            this.a = i;
            this.f2818b = j;
            this.f2819c = i2;
        }
    }

    private void a(k kVar, x xVar) throws IOException {
        d0 d0Var = new d0(8);
        kVar.readFully(d0Var.d(), 0, 8);
        this.f2817e = d0Var.q() + 8;
        if (d0Var.n() != 1397048916) {
            xVar.a = 0L;
            return;
        }
        xVar.a = kVar.getPosition() - (this.f2817e - 12);
        this.f2816d = 2;
    }

    private static int b(String str) throws ParserException {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1711564334:
                if (str.equals("SlowMotion_Data")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1332107749:
                if (str.equals("Super_SlowMotion_Edit_Data")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1251387154:
                if (str.equals("Super_SlowMotion_Data")) {
                    c2 = 2;
                    break;
                }
                break;
            case -830665521:
                if (str.equals("Super_SlowMotion_Deflickering_On")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1760745220:
                if (str.equals("Super_SlowMotion_BGM")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2192;
            case 1:
                return 2819;
            case 2:
                return 2816;
            case 3:
                return 2820;
            case 4:
                return 2817;
            default:
                throw ParserException.createForMalformedContainer("Invalid SEF name", null);
        }
    }

    private void d(k kVar, x xVar) throws IOException {
        long a2 = kVar.a();
        int i = (this.f2817e - 12) - 8;
        d0 d0Var = new d0(i);
        kVar.readFully(d0Var.d(), 0, i);
        for (int i2 = 0; i2 < i / 12; i2++) {
            d0Var.Q(2);
            short s = d0Var.s();
            if (s == 2192 || s == 2816 || s == 2817 || s == 2819 || s == 2820) {
                this.f2815c.add(new a(s, (a2 - this.f2817e) - d0Var.q(), d0Var.q()));
            } else {
                d0Var.Q(8);
            }
        }
        if (this.f2815c.isEmpty()) {
            xVar.a = 0L;
            return;
        }
        this.f2816d = 3;
        xVar.a = this.f2815c.get(0).f2818b;
    }

    private void e(k kVar, List<Metadata.Entry> list) throws IOException {
        long position = kVar.getPosition();
        int a2 = (int) ((kVar.a() - kVar.getPosition()) - this.f2817e);
        d0 d0Var = new d0(a2);
        kVar.readFully(d0Var.d(), 0, a2);
        for (int i = 0; i < this.f2815c.size(); i++) {
            a aVar = this.f2815c.get(i);
            d0Var.P((int) (aVar.f2818b - position));
            d0Var.Q(4);
            int q = d0Var.q();
            int b2 = b(d0Var.A(q));
            int i2 = aVar.f2819c - (q + 8);
            if (b2 == 2192) {
                list.add(f(d0Var, i2));
            } else if (!(b2 == 2816 || b2 == 2817 || b2 == 2819 || b2 == 2820)) {
                throw new IllegalStateException();
            }
        }
    }

    private static SlowMotionData f(d0 d0Var, int i) throws ParserException {
        ArrayList arrayList = new ArrayList();
        List<String> f2 = f2814b.f(d0Var.A(i));
        for (int i2 = 0; i2 < f2.size(); i2++) {
            List<String> f3 = a.f(f2.get(i2));
            if (f3.size() == 3) {
                try {
                    arrayList.add(new SlowMotionData.Segment(Long.parseLong(f3.get(0)), Long.parseLong(f3.get(1)), 1 << (Integer.parseInt(f3.get(2)) - 1)));
                } catch (NumberFormatException e2) {
                    throw ParserException.createForMalformedContainer(null, e2);
                }
            } else {
                throw ParserException.createForMalformedContainer(null, null);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public int c(k kVar, x xVar, List<Metadata.Entry> list) throws IOException {
        int i = this.f2816d;
        long j = 0;
        if (i == 0) {
            long a2 = kVar.a();
            if (a2 != -1 && a2 >= 8) {
                j = a2 - 8;
            }
            xVar.a = j;
            this.f2816d = 1;
        } else if (i == 1) {
            a(kVar, xVar);
        } else if (i == 2) {
            d(kVar, xVar);
        } else if (i == 3) {
            e(kVar, list);
            xVar.a = 0L;
        } else {
            throw new IllegalStateException();
        }
        return 1;
    }

    public void g() {
        this.f2815c.clear();
        this.f2816d = 0;
    }
}
