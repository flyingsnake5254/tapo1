package com.tplink.libtpnetwork.cameranetwork.util;

import android.content.Context;
import com.google.gson.Gson;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: DaylightParser.java */
/* loaded from: classes3.dex */
public class d {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Map<String, b>> f15003b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f15004c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DaylightParser.java */
    /* loaded from: classes3.dex */
    public class a extends com.google.gson.r.a<Map<String, Map<String, b>>> {
        a() {
        }
    }

    /* compiled from: DaylightParser.java */
    /* loaded from: classes3.dex */
    public static class b {
        @com.google.gson.q.c("zone_id")
        private String a;
        @com.google.gson.q.c("year")

        /* renamed from: b  reason: collision with root package name */
        private Integer f15005b;
        @com.google.gson.q.c("dst_saving")

        /* renamed from: c  reason: collision with root package name */
        private int f15006c;
        @com.google.gson.q.c("start_time")

        /* renamed from: d  reason: collision with root package name */
        private long f15007d;
        @com.google.gson.q.c("end_time")

        /* renamed from: e  reason: collision with root package name */
        private long f15008e;

        public long a() {
            return this.f15008e;
        }

        public long b() {
            return this.f15007d;
        }
    }

    /* compiled from: DaylightParser.java */
    /* loaded from: classes3.dex */
    private static class c {
        private static final d a = new d(null);
    }

    /* synthetic */ d(a aVar) {
        this();
    }

    private Map<String, Map<String, b>> a(Context context) {
        try {
            return (Map) new Gson().m(f("daylight_saving.json", context), new a().getType());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private Map<String, b> b(String str) {
        Map<String, b> map = this.f15003b.get(str);
        return map != null ? map : new HashMap();
    }

    public static d c() {
        return c.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ t e(String str) throws Exception {
        Map<String, b> map;
        synchronized (this.f15004c) {
            if (!this.f15003b.isEmpty()) {
                map = b(str);
            } else {
                Map<String, Map<String, b>> a2 = a(this.a);
                if (a2 != null) {
                    this.f15003b.putAll(a2);
                }
                map = b(str);
            }
        }
        return q.f0(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x006b: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:37:0x006b */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.Reader, java.io.InputStreamReader] */
    private String f(String str, Context context) {
        BufferedReader bufferedReader;
        Exception e2;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    str = context.getResources().getAssets().open(str);
                    try {
                        context = new InputStreamReader(str);
                    } catch (Exception e3) {
                        e2 = e3;
                        bufferedReader = null;
                        context = 0;
                    } catch (Throwable th) {
                        th = th;
                        context = 0;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e2 = e5;
                context = 0;
                bufferedReader = null;
                str = 0;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                context = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            bufferedReader = new BufferedReader(context);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (Exception e6) {
                    e2 = e6;
                    e2.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (context != 0) {
                        context.close();
                    }
                    if (str != 0) {
                        str.close();
                    }
                    return sb.toString();
                }
            }
            bufferedReader.close();
            context.close();
            if (str != 0) {
                str.close();
            }
        } catch (Exception e7) {
            e2 = e7;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                    throw th;
                }
            }
            if (context != 0) {
                context.close();
            }
            if (str != 0) {
                str.close();
            }
            throw th;
        }
        return sb.toString();
    }

    public q<Map<String, b>> g(String str) {
        return q.f0(str).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.util.a
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return d.this.e((String) obj);
            }
        }).L0(io.reactivex.l0.a.c());
    }

    public void h(Context context) {
        this.a = context;
    }

    private d() {
        this.f15003b = new LinkedHashMap();
        this.f15004c = new Object();
    }
}
