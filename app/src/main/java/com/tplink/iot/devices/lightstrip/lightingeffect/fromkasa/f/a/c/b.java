package com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c;

import androidx.annotation.VisibleForTesting;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.LEColor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.e0;
import kotlin.collections.v;

/* compiled from: TemplateFilterRegistry.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final C0201b a = new C0201b(null);

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class a implements a {
        private String a;

        public a(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            Object obj2 = params.get(0);
            if (!(obj2 instanceof List)) {
                obj2 = null;
            }
            return b((List) obj2);
        }

        @VisibleForTesting
        public final Integer b(List<LEColor> list) {
            ArrayList arrayList;
            double u;
            int l;
            if (list != null) {
                l = kotlin.collections.o.l(list, 10);
                arrayList = new ArrayList(l);
                for (LEColor lEColor : list) {
                    arrayList.add(lEColor.getH());
                }
            } else {
                arrayList = null;
            }
            if (!(arrayList instanceof List)) {
                arrayList = null;
            }
            if (arrayList == null) {
                return null;
            }
            u = v.u(arrayList);
            return Integer.valueOf((int) u);
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ a(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "avgHue" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    /* renamed from: com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0201b {
        private C0201b() {
        }

        public final Map<String, a> a() {
            HashMap e2;
            e2 = e0.e(kotlin.n.a("mapSpeed", new h(null, 1, null)), kotlin.n.a("minHue", new k(null, 1, null)), kotlin.n.a("maxHue", new i(null, 1, null)), kotlin.n.a("minSat", new l(null, 1, null)), kotlin.n.a("maxSat", new j(null, 1, null)), kotlin.n.a("plusHue", new n(null, 1, null)), kotlin.n.a("minusHue", new m(null, 1, null)), kotlin.n.a("sortHue", new p(null, 1, null)), kotlin.n.a("sortHueDescending", new o(null, 1, null)), kotlin.n.a("avgHue", new a(null, 1, null)), kotlin.n.a("equals", new c(null, 1, null)), kotlin.n.a("lessThan", new g(null, 1, null)), kotlin.n.a("lessEqualsThan", new f(null, 1, null)), kotlin.n.a("greaterThan", new e(null, 1, null)), kotlin.n.a("greaterEqualsThan", new d(null, 1, null)));
            return e2;
        }

        public /* synthetic */ C0201b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class c implements a {
        private String a;

        public c(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        private final boolean c(String str) {
            if (str == null) {
                return false;
            }
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException unused) {
                return false;
            }
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            return Boolean.valueOf(b(params.get(0), params.get(1)));
        }

        @VisibleForTesting
        public final boolean b(Object obj, Object obj2) {
            String str;
            Integer num;
            Integer num2 = null;
            String obj3 = obj != null ? obj.toString() : null;
            if (obj2 != null) {
                str = obj2.toString();
            } else {
                str = null;
            }
            if (!c(obj3) || !c(str)) {
                return kotlin.jvm.internal.j.a(obj3, str);
            }
            if (obj3 != null) {
                num = Integer.valueOf(Integer.parseInt(obj3));
            } else {
                num = null;
            }
            if (str != null) {
                num2 = Integer.valueOf(Integer.parseInt(str));
            }
            return kotlin.jvm.internal.j.a(num, num2);
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ c(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "equals" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class d implements a {
        private String a;

        public d(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            return Boolean.valueOf(b(params.get(0), params.get(1)));
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0034 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        @androidx.annotation.VisibleForTesting
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean b(java.lang.Object r3, java.lang.Object r4) {
            /*
                r2 = this;
                r0 = 0
                r1 = 0
                if (r3 == 0) goto L_0x0015
                java.lang.String r3 = r3.toString()     // Catch: NumberFormatException -> 0x0013
                if (r3 == 0) goto L_0x0015
                int r3 = java.lang.Integer.parseInt(r3)     // Catch: NumberFormatException -> 0x0013
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: NumberFormatException -> 0x0013
                goto L_0x0016
            L_0x0013:
                r3 = move-exception
                goto L_0x0036
            L_0x0015:
                r3 = r0
            L_0x0016:
                if (r4 == 0) goto L_0x0026
                java.lang.String r4 = r4.toString()     // Catch: NumberFormatException -> 0x0013
                if (r4 == 0) goto L_0x0026
                int r4 = java.lang.Integer.parseInt(r4)     // Catch: NumberFormatException -> 0x0013
                java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch: NumberFormatException -> 0x0013
            L_0x0026:
                if (r3 == 0) goto L_0x0039
                if (r0 == 0) goto L_0x0039
                int r3 = r3.intValue()     // Catch: NumberFormatException -> 0x0013
                int r4 = r0.intValue()     // Catch: NumberFormatException -> 0x0013
                if (r3 < r4) goto L_0x0035
                r1 = 1
            L_0x0035:
                return r1
            L_0x0036:
                r3.printStackTrace()
            L_0x0039:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.b.d.b(java.lang.Object, java.lang.Object):boolean");
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ d(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "greaterEqualsThan" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class e implements a {
        private String a;

        public e(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            return Boolean.valueOf(b(params.get(0), params.get(1)));
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0034 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        @androidx.annotation.VisibleForTesting
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean b(java.lang.Object r3, java.lang.Object r4) {
            /*
                r2 = this;
                r0 = 0
                r1 = 0
                if (r3 == 0) goto L_0x0015
                java.lang.String r3 = r3.toString()     // Catch: NumberFormatException -> 0x0013
                if (r3 == 0) goto L_0x0015
                int r3 = java.lang.Integer.parseInt(r3)     // Catch: NumberFormatException -> 0x0013
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: NumberFormatException -> 0x0013
                goto L_0x0016
            L_0x0013:
                r3 = move-exception
                goto L_0x0036
            L_0x0015:
                r3 = r0
            L_0x0016:
                if (r4 == 0) goto L_0x0026
                java.lang.String r4 = r4.toString()     // Catch: NumberFormatException -> 0x0013
                if (r4 == 0) goto L_0x0026
                int r4 = java.lang.Integer.parseInt(r4)     // Catch: NumberFormatException -> 0x0013
                java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch: NumberFormatException -> 0x0013
            L_0x0026:
                if (r3 == 0) goto L_0x0039
                if (r0 == 0) goto L_0x0039
                int r3 = r3.intValue()     // Catch: NumberFormatException -> 0x0013
                int r4 = r0.intValue()     // Catch: NumberFormatException -> 0x0013
                if (r3 <= r4) goto L_0x0035
                r1 = 1
            L_0x0035:
                return r1
            L_0x0036:
                r3.printStackTrace()
            L_0x0039:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.b.e.b(java.lang.Object, java.lang.Object):boolean");
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ e(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "greaterThan" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class f implements a {
        private String a;

        public f(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            return Boolean.valueOf(b(params.get(0), params.get(1)));
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0034 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        @androidx.annotation.VisibleForTesting
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean b(java.lang.Object r3, java.lang.Object r4) {
            /*
                r2 = this;
                r0 = 0
                r1 = 0
                if (r3 == 0) goto L_0x0015
                java.lang.String r3 = r3.toString()     // Catch: NumberFormatException -> 0x0013
                if (r3 == 0) goto L_0x0015
                int r3 = java.lang.Integer.parseInt(r3)     // Catch: NumberFormatException -> 0x0013
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: NumberFormatException -> 0x0013
                goto L_0x0016
            L_0x0013:
                r3 = move-exception
                goto L_0x0036
            L_0x0015:
                r3 = r0
            L_0x0016:
                if (r4 == 0) goto L_0x0026
                java.lang.String r4 = r4.toString()     // Catch: NumberFormatException -> 0x0013
                if (r4 == 0) goto L_0x0026
                int r4 = java.lang.Integer.parseInt(r4)     // Catch: NumberFormatException -> 0x0013
                java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch: NumberFormatException -> 0x0013
            L_0x0026:
                if (r3 == 0) goto L_0x0039
                if (r0 == 0) goto L_0x0039
                int r3 = r3.intValue()     // Catch: NumberFormatException -> 0x0013
                int r4 = r0.intValue()     // Catch: NumberFormatException -> 0x0013
                if (r3 > r4) goto L_0x0035
                r1 = 1
            L_0x0035:
                return r1
            L_0x0036:
                r3.printStackTrace()
            L_0x0039:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.b.f.b(java.lang.Object, java.lang.Object):boolean");
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ f(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "lessEqualsThan" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class g implements a {
        private String a;

        public g(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            return Boolean.valueOf(b(params.get(0), params.get(1)));
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0034 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        @androidx.annotation.VisibleForTesting
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean b(java.lang.Object r3, java.lang.Object r4) {
            /*
                r2 = this;
                r0 = 0
                r1 = 0
                if (r3 == 0) goto L_0x0015
                java.lang.String r3 = r3.toString()     // Catch: NumberFormatException -> 0x0013
                if (r3 == 0) goto L_0x0015
                int r3 = java.lang.Integer.parseInt(r3)     // Catch: NumberFormatException -> 0x0013
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: NumberFormatException -> 0x0013
                goto L_0x0016
            L_0x0013:
                r3 = move-exception
                goto L_0x0036
            L_0x0015:
                r3 = r0
            L_0x0016:
                if (r4 == 0) goto L_0x0026
                java.lang.String r4 = r4.toString()     // Catch: NumberFormatException -> 0x0013
                if (r4 == 0) goto L_0x0026
                int r4 = java.lang.Integer.parseInt(r4)     // Catch: NumberFormatException -> 0x0013
                java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch: NumberFormatException -> 0x0013
            L_0x0026:
                if (r3 == 0) goto L_0x0039
                if (r0 == 0) goto L_0x0039
                int r3 = r3.intValue()     // Catch: NumberFormatException -> 0x0013
                int r4 = r0.intValue()     // Catch: NumberFormatException -> 0x0013
                if (r3 >= r4) goto L_0x0035
                r1 = 1
            L_0x0035:
                return r1
            L_0x0036:
                r3.printStackTrace()
            L_0x0039:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.b.g.b(java.lang.Object, java.lang.Object):boolean");
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ g(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "lessThan" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class h implements a {
        private String a;

        public h(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            return Integer.valueOf(b(Integer.parseInt(params.get(0).toString()), Integer.parseInt(params.get(1).toString()), Integer.parseInt(params.get(2).toString())));
        }

        @VisibleForTesting
        public final int b(int i, int i2, int i3) {
            return (int) (((i3 - i2) * (i / 100.0f)) + i2);
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ h(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "mapSpeed" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class i implements a {
        private String a;

        public i(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            Object obj2 = params.get(0);
            if (!(obj2 instanceof List)) {
                obj2 = null;
            }
            return Integer.valueOf(b((List) obj2));
        }

        @VisibleForTesting
        public final int b(List<LEColor> list) {
            int i = Integer.MIN_VALUE;
            if (list != null) {
                for (LEColor lEColor : list) {
                    Integer h = lEColor.getH();
                    if (h != null) {
                        i = Math.max(i, h.intValue());
                    }
                }
            }
            return i;
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ i(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "maxHue" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class j implements a {
        private String a;

        public j(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            Object obj2 = params.get(0);
            if (!(obj2 instanceof List)) {
                obj2 = null;
            }
            return Integer.valueOf(b((List) obj2));
        }

        @VisibleForTesting
        public final int b(List<LEColor> list) {
            int i = Integer.MIN_VALUE;
            if (list != null) {
                for (LEColor lEColor : list) {
                    Integer s = lEColor.getS();
                    if (s != null) {
                        i = Math.max(i, s.intValue());
                    }
                }
            }
            return i;
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ j(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "maxSat" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class k implements a {
        private String a;

        public k(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            Object obj2 = params.get(0);
            if (!(obj2 instanceof List)) {
                obj2 = null;
            }
            return Integer.valueOf(b((List) obj2));
        }

        @VisibleForTesting
        public final int b(List<LEColor> list) {
            int i = Integer.MAX_VALUE;
            if (list != null) {
                for (LEColor lEColor : list) {
                    Integer h = lEColor.getH();
                    if (h != null) {
                        i = Math.min(i, h.intValue());
                    }
                }
            }
            return i;
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ k(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "minHue" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class l implements a {
        private String a;

        public l(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            Object obj2 = params.get(0);
            if (!(obj2 instanceof List)) {
                obj2 = null;
            }
            return Integer.valueOf(b((List) obj2));
        }

        @VisibleForTesting
        public final int b(List<LEColor> list) {
            int i = Integer.MAX_VALUE;
            if (list != null) {
                for (LEColor lEColor : list) {
                    Integer s = lEColor.getS();
                    if (s != null) {
                        i = Math.min(i, s.intValue());
                    }
                }
            }
            return i;
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ l(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "minSat" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class m implements a {
        private String a;

        public m(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            return Integer.valueOf(b(Integer.parseInt(params.get(0).toString()), Integer.parseInt(params.get(1).toString())));
        }

        @VisibleForTesting
        public final int b(int i, int i2) {
            return Math.max(i - i2, 0);
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ m(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "minusHue" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class n implements a {
        private String a;

        public n(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            return Integer.valueOf(b(Integer.parseInt(params.get(0).toString()), Integer.parseInt(params.get(1).toString())));
        }

        @VisibleForTesting
        public final int b(int i, int i2) {
            return Math.min(i + i2, 360);
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ n(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "plusHue" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class o implements a {
        private String a;

        /* compiled from: Comparisons.kt */
        /* loaded from: classes2.dex */
        public static final class a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int a;
                a = kotlin.q.b.a(((LEColor) t2).getH(), ((LEColor) t).getH());
                return a;
            }
        }

        public o(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            Object obj2 = params.get(0);
            if (!(obj2 instanceof List)) {
                obj2 = null;
            }
            return b((List) obj2);
        }

        @VisibleForTesting
        public final List<LEColor> b(List<LEColor> list) {
            List<LEColor> O;
            if (list == null) {
                return null;
            }
            O = v.O(list, new a());
            return O;
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ o(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "sortHueDescending" : str);
        }
    }

    /* compiled from: TemplateFilterRegistry.kt */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class p implements a {
        private String a;

        /* compiled from: Comparisons.kt */
        /* loaded from: classes2.dex */
        public static final class a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int a;
                a = kotlin.q.b.a(((LEColor) t).getH(), ((LEColor) t2).getH());
                return a;
            }
        }

        public p(String id) {
            kotlin.jvm.internal.j.e(id, "id");
            this.a = id;
        }

        @Override // com.samskivert.mustache.f.k
        public Object a(Object obj, List<Object> params) {
            kotlin.jvm.internal.j.e(params, "params");
            Object obj2 = params.get(0);
            if (!(obj2 instanceof List)) {
                obj2 = null;
            }
            return b((List) obj2);
        }

        @VisibleForTesting
        public final List<LEColor> b(List<LEColor> list) {
            List<LEColor> O;
            if (list == null) {
                return null;
            }
            O = v.O(list, new a());
            return O;
        }

        @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a
        public String getId() {
            return this.a;
        }

        public /* synthetic */ p(String str, int i, kotlin.jvm.internal.f fVar) {
            this((i & 1) != 0 ? "sortHue" : str);
        }
    }
}
