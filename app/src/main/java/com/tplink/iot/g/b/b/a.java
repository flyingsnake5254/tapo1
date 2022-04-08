package com.tplink.iot.g.b.b;

import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: ColorPaintingItem.kt */
/* loaded from: classes2.dex */
public final class a extends com.tplink.iot.g.b.b.e.a {

    /* renamed from: b  reason: collision with root package name */
    private LightingEffectData f7943b;

    /* renamed from: c  reason: collision with root package name */
    private String f7944c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Integer> f7945d;

    /* renamed from: e  reason: collision with root package name */
    private final List<Integer> f7946e;

    /* renamed from: f  reason: collision with root package name */
    private CustomizedEffect f7947f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String title, List<Integer> colors, List<Integer> parts, CustomizedEffect customizedEffect) {
        super(false);
        j.e(title, "title");
        j.e(colors, "colors");
        j.e(parts, "parts");
        this.f7944c = title;
        this.f7945d = colors;
        this.f7946e = parts;
        this.f7947f = customizedEffect;
    }

    public final List<Integer> c() {
        return this.f7945d;
    }

    public final CustomizedEffect d() {
        return this.f7947f;
    }

    public final String e() {
        CustomizedEffect customizedEffect = this.f7947f;
        if (customizedEffect != null) {
            return customizedEffect.getId();
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.a(this.f7944c, aVar.f7944c) && j.a(this.f7945d, aVar.f7945d) && j.a(this.f7946e, aVar.f7946e) && j.a(this.f7947f, aVar.f7947f);
    }

    public final List<Integer> f() {
        return this.f7946e;
    }

    public final LightingEffectData g() {
        return this.f7943b;
    }

    public final String h() {
        return this.f7944c;
    }

    public int hashCode() {
        String str = this.f7944c;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Integer> list = this.f7945d;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Integer> list2 = this.f7946e;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        CustomizedEffect customizedEffect = this.f7947f;
        if (customizedEffect != null) {
            i = customizedEffect.hashCode();
        }
        return hashCode3 + i;
    }

    public final void i(LightingEffectData lightingEffectData) {
        this.f7943b = lightingEffectData;
    }

    public String toString() {
        return "ColorPaintingItem(title=" + this.f7944c + ", colors=" + this.f7945d + ", parts=" + this.f7946e + ", customizedEffect=" + this.f7947f + ")";
    }
}
