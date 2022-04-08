package com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a;

import com.samskivert.mustache.f;
import com.samskivert.mustache.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;

/* compiled from: TemplateProcessor.kt */
/* loaded from: classes2.dex */
public final class b implements a {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final f.C0186f f7521b;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.d.a> f7522c;

    /* renamed from: d  reason: collision with root package name */
    private final List<com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a> f7523d;

    /* compiled from: TemplateProcessor.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final b a() {
            f.C0186f b2 = f.b();
            j.d(b2, "Mustache.compiler()");
            return new b(b2, new ArrayList(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.d.b.a.a().values()), new ArrayList(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.b.a.a().values()));
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(f.C0186f mustache, List<? extends com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.d.a> templateLambdas, List<? extends com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a> templateFilters) {
        j.e(mustache, "mustache");
        j.e(templateLambdas, "templateLambdas");
        j.e(templateFilters, "templateFilters");
        this.f7521b = mustache;
        this.f7522c = templateLambdas;
        this.f7523d = templateFilters;
    }

    private final g b(String str) {
        g b2 = this.f7521b.b(str);
        j.d(b2, "mustache.compile(template)");
        return b2;
    }

    private final String c(g gVar, Map<String, Object> map) {
        for (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.d.a aVar : this.f7522c) {
            map.put(aVar.getId(), aVar);
        }
        for (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a aVar2 : this.f7523d) {
            map.put(aVar2.getId(), aVar2);
        }
        String c2 = gVar.c(map);
        j.d(c2, "template.execute(input)");
        return c2;
    }

    @Override // com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.a
    public String a(String template, Map<String, Object> input) {
        j.e(template, "template");
        j.e(input, "input");
        return c(b(template), input);
    }
}
