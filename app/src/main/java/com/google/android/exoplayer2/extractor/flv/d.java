package com.google.android.exoplayer2.extractor.flv;

import androidx.annotation.Nullable;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.exoplayer2.o2.i;
import com.google.android.exoplayer2.util.d0;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ScriptTagPayloadReader.java */
/* loaded from: classes.dex */
final class d extends TagPayloadReader {

    /* renamed from: b  reason: collision with root package name */
    private long f2259b = -9223372036854775807L;

    /* renamed from: c  reason: collision with root package name */
    private long[] f2260c = new long[0];

    /* renamed from: d  reason: collision with root package name */
    private long[] f2261d = new long[0];

    public d() {
        super(new i());
    }

    private static Boolean g(d0 d0Var) {
        boolean z = true;
        if (d0Var.D() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @Nullable
    private static Object h(d0 d0Var, int i) {
        if (i == 0) {
            return j(d0Var);
        }
        if (i == 1) {
            return g(d0Var);
        }
        if (i == 2) {
            return n(d0Var);
        }
        if (i == 3) {
            return l(d0Var);
        }
        if (i == 8) {
            return k(d0Var);
        }
        if (i == 10) {
            return m(d0Var);
        }
        if (i != 11) {
            return null;
        }
        return i(d0Var);
    }

    private static Date i(d0 d0Var) {
        Date date = new Date((long) j(d0Var).doubleValue());
        d0Var.Q(2);
        return date;
    }

    private static Double j(d0 d0Var) {
        return Double.valueOf(Double.longBitsToDouble(d0Var.w()));
    }

    private static HashMap<String, Object> k(d0 d0Var) {
        int H = d0Var.H();
        HashMap<String, Object> hashMap = new HashMap<>(H);
        for (int i = 0; i < H; i++) {
            String n = n(d0Var);
            Object h = h(d0Var, o(d0Var));
            if (h != null) {
                hashMap.put(n, h);
            }
        }
        return hashMap;
    }

    private static HashMap<String, Object> l(d0 d0Var) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String n = n(d0Var);
            int o = o(d0Var);
            if (o == 9) {
                return hashMap;
            }
            Object h = h(d0Var, o);
            if (h != null) {
                hashMap.put(n, h);
            }
        }
    }

    private static ArrayList<Object> m(d0 d0Var) {
        int H = d0Var.H();
        ArrayList<Object> arrayList = new ArrayList<>(H);
        for (int i = 0; i < H; i++) {
            Object h = h(d0Var, o(d0Var));
            if (h != null) {
                arrayList.add(h);
            }
        }
        return arrayList;
    }

    private static String n(d0 d0Var) {
        int J = d0Var.J();
        int e2 = d0Var.e();
        d0Var.Q(J);
        return new String(d0Var.d(), e2, J);
    }

    private static int o(d0 d0Var) {
        return d0Var.D();
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean b(d0 d0Var) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean c(d0 d0Var, long j) {
        if (!(o(d0Var) == 2 && "onMetaData".equals(n(d0Var)) && o(d0Var) == 8)) {
            return false;
        }
        HashMap<String, Object> k = k(d0Var);
        Object obj = k.get(ThingModelDefine.Service.INPUT_PARAM_DURATION);
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > Utils.DOUBLE_EPSILON) {
                this.f2259b = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = k.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f2260c = new long[size];
                this.f2261d = new long[size];
                for (int i = 0; i < size; i++) {
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f2260c = new long[0];
                        this.f2261d = new long[0];
                        break;
                    }
                    this.f2260c[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f2261d[i] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public long d() {
        return this.f2259b;
    }

    public long[] e() {
        return this.f2261d;
    }

    public long[] f() {
        return this.f2260c;
    }
}
