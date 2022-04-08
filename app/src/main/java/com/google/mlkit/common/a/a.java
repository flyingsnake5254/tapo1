package com.google.mlkit.common.a;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes2.dex */
public class a {
    private static final Map<BaseModel, String> a = new EnumMap(BaseModel.class);
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    private static final Map<BaseModel, String> f4935b = new EnumMap(BaseModel.class);
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f4936c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final BaseModel f4937d;

    /* renamed from: e  reason: collision with root package name */
    private String f4938e;

    @KeepForSdk
    public String a() {
        return this.f4938e;
    }

    @KeepForSdk
    public String b() {
        String str = this.f4936c;
        return str != null ? str : f4935b.get(this.f4937d);
    }

    @KeepForSdk
    public String c() {
        String str = this.f4936c;
        if (str != null) {
            return str;
        }
        String valueOf = String.valueOf(f4935b.get(this.f4937d));
        return valueOf.length() != 0 ? "COM.GOOGLE.BASE_".concat(valueOf) : new String("COM.GOOGLE.BASE_");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Objects.equal(this.f4936c, aVar.f4936c) && Objects.equal(this.f4937d, aVar.f4937d);
    }

    public int hashCode() {
        return Objects.hashCode(this.f4936c, this.f4937d);
    }
}
