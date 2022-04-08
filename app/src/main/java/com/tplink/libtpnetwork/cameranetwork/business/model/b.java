package com.tplink.libtpnetwork.cameranetwork.business.model;

import androidx.annotation.Nullable;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmSoundType;

/* compiled from: AlarmSetting.java */
/* loaded from: classes3.dex */
public class b {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14113b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14114c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14115d;

    /* renamed from: e  reason: collision with root package name */
    private AlarmSoundType f14116e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private a f14117f;

    public b a() {
        b bVar = new b();
        bVar.a = this.a;
        bVar.f14113b = this.f14113b;
        bVar.f14114c = this.f14114c;
        bVar.f14115d = this.f14115d;
        bVar.f14116e = this.f14116e;
        a aVar = this.f14117f;
        if (aVar != null) {
            bVar.f14117f = aVar.a();
        }
        return bVar;
    }

    @Nullable
    public a b() {
        return this.f14117f;
    }

    public AlarmSoundType c() {
        return this.f14116e;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean d() {
        return this.a;
    }

    public boolean e() {
        return this.f14114c;
    }

    public boolean f() {
        return this.f14115d;
    }

    public boolean g() {
        return this.f14113b;
    }

    public void h(boolean z) {
        this.a = z;
    }

    public void i(boolean z) {
        this.f14114c = z;
    }

    public void j(@Nullable a aVar) {
        this.f14117f = aVar;
    }

    public void k(boolean z) {
        this.f14115d = z;
    }

    public void l(boolean z) {
        this.f14113b = z;
    }

    public void m(AlarmSoundType alarmSoundType) {
        this.f14116e = alarmSoundType;
    }
}
