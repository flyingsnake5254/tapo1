package com.tplink.iot.g.b.b;

import com.tplink.iot.g.b.b.e.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: CustomizedEffectsItem.kt */
/* loaded from: classes2.dex */
public final class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private LightingEffectData f7948b;

    /* renamed from: c  reason: collision with root package name */
    private String f7949c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Integer> f7950d;

    /* renamed from: e  reason: collision with root package name */
    private CustomizedEffect f7951e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String title, List<Integer> colors, CustomizedEffect customizedEffect) {
        super(false);
        j.e(title, "title");
        j.e(colors, "colors");
        this.f7949c = title;
        this.f7950d = colors;
        this.f7951e = customizedEffect;
    }

    public final List<Integer> c() {
        return this.f7950d;
    }

    public final CustomizedEffect d() {
        return this.f7951e;
    }

    public final String e() {
        CustomizedEffect customizedEffect = this.f7951e;
        if (customizedEffect != null) {
            return customizedEffect.getId();
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return j.a(this.f7949c, bVar.f7949c) && j.a(this.f7950d, bVar.f7950d) && j.a(this.f7951e, bVar.f7951e);
    }

    public final LightingEffectData f() {
        return this.f7948b;
    }

    public final String g() {
        return this.f7949c;
    }

    public final void h(LightingEffectData lightingEffectData) {
        this.f7948b = lightingEffectData;
    }

    public int hashCode() {
        String str = this.f7949c;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Integer> list = this.f7950d;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        CustomizedEffect customizedEffect = this.f7951e;
        if (customizedEffect != null) {
            i = customizedEffect.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CustomizedEffectsItem(title=" + this.f7949c + ", colors=" + this.f7950d + ", customizedEffect=" + this.f7951e + ")";
    }
}
