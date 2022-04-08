package com.tplink.iot.g.b.b;

import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: PredefinedEffectsItem.kt */
/* loaded from: classes2.dex */
public final class d extends com.tplink.iot.g.b.b.e.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f7954b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private LightingEffectData f7955c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7956d;

    /* renamed from: e  reason: collision with root package name */
    private LightStateBean f7957e;

    /* renamed from: f  reason: collision with root package name */
    private String f7958f;
    private final int g;
    private PredefinedEffect h;

    /* compiled from: PredefinedEffectsItem.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public /* synthetic */ d(String str, int i, PredefinedEffect predefinedEffect, int i2, f fVar) {
        this(str, i, (i2 & 4) != 0 ? null : predefinedEffect);
    }

    public final LightStateBean c() {
        return this.f7957e;
    }

    public final int d() {
        return this.g;
    }

    public final PredefinedEffect e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return j.a(this.f7958f, dVar.f7958f) && this.g == dVar.g && j.a(this.h, dVar.h);
    }

    public final String f() {
        PredefinedEffect predefinedEffect = this.h;
        if (predefinedEffect != null) {
            return predefinedEffect.getId();
        }
        return null;
    }

    public final LightingEffectData g() {
        return this.f7955c;
    }

    public final String h() {
        return this.f7958f;
    }

    public int hashCode() {
        String str = this.f7958f;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.g) * 31;
        PredefinedEffect predefinedEffect = this.h;
        if (predefinedEffect != null) {
            i = predefinedEffect.hashCode();
        }
        return hashCode + i;
    }

    public final boolean i() {
        return this.f7956d;
    }

    public final void j(boolean z) {
        this.f7956d = z;
    }

    public final void k(LightStateBean lightStateBean) {
        this.f7957e = lightStateBean;
    }

    public final void l(PredefinedEffect predefinedEffect) {
        this.h = predefinedEffect;
    }

    public final void m(LightingEffectData lightingEffectData) {
        this.f7955c = lightingEffectData;
    }

    public String toString() {
        return "PredefinedEffectsItem(title=" + this.f7958f + ", imgId=" + this.g + ", predefinedEffect=" + this.h + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String title, int i, PredefinedEffect predefinedEffect) {
        super(false);
        j.e(title, "title");
        this.f7958f = title;
        this.g = i;
        this.h = predefinedEffect;
    }
}
