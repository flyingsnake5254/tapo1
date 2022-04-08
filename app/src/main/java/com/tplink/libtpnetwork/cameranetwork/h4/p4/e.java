package com.tplink.libtpnetwork.cameranetwork.h4.p4;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.h4.h4;
import com.tplink.libtpnetwork.cameranetwork.h4.k4;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.q;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RemoteCameraTransport.java */
/* loaded from: classes3.dex */
public class e extends h4 {

    /* renamed from: c  reason: collision with root package name */
    private g f14849c;

    /* renamed from: d  reason: collision with root package name */
    private String f14850d;

    /* renamed from: e  reason: collision with root package name */
    private f f14851e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f14852f;
    private com.tplink.libtpnetwork.cameranetwork.h4.m4.a.a g = new a();

    /* compiled from: RemoteCameraTransport.java */
    /* loaded from: classes3.dex */
    class a implements com.tplink.libtpnetwork.cameranetwork.h4.m4.a.a {
        a() {
        }

        @Override // com.tplink.libtpnetwork.cameranetwork.h4.m4.a.a
        public Map<String, String> a(@NonNull String str) {
            if (e.this.f14852f != null) {
                return e.this.f14852f;
            }
            return null;
        }

        @Override // com.tplink.libtpnetwork.cameranetwork.h4.m4.a.a
        public Map<String, String> b(@NonNull String str) {
            return null;
        }
    }

    public e(g gVar) {
        this.f14849c = gVar;
        if (gVar.a() != null) {
            com.tplink.cloud.context.a a2 = gVar.a();
            j4(a2.b(), a2.q(), a2.o(), a2.d(), a2.n(), a2.l());
        }
        k4 k4Var = new k4();
        this.f14850d = gVar.d();
        this.f14851e = k4Var.a(gVar.c(), null, this.g, gVar.b());
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.h4.h4
    protected q<Response<Wrappers>> c3(Request<MultipleRequest> request) {
        if (TextUtils.isEmpty(this.f14850d)) {
            return q.J(new Throwable("cloud token is null"));
        }
        return this.f14851e.a(this.f14850d, request);
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.h4.h4
    protected q<Response<MultipleResponse>> d3(Request<MultipleRequest> request) {
        if (TextUtils.isEmpty(this.f14850d)) {
            return q.J(new Throwable("cloud token is null"));
        }
        return this.f14851e.b(this.f14850d, request);
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.h4.h4
    protected q<Response<Wrappers>> e3(Request request) {
        return this.f14851e.c(request);
    }

    public g i4() {
        return this.f14849c;
    }

    public void j4(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @NonNull String str6) {
        HashMap hashMap = new HashMap(5);
        this.f14852f = hashMap;
        hashMap.put("appName", str);
        this.f14852f.put("termID", str2);
        this.f14852f.put("ospf", str3);
        this.f14852f.put("appVer", str4);
        this.f14852f.put("netType", str5);
        this.f14852f.put("locale", str6);
    }

    public void k4(g gVar) {
        if (gVar.a() != null) {
            com.tplink.cloud.context.a a2 = gVar.a();
            j4(a2.b(), a2.q(), a2.o(), a2.d(), a2.n(), a2.l());
        }
        if (!TextUtils.equals(this.f14850d, gVar.d())) {
            this.f14850d = gVar.d();
        }
        this.f14849c = gVar;
    }
}
