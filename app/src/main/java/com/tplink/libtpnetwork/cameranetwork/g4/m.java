package com.tplink.libtpnetwork.cameranetwork.g4;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;

/* compiled from: RxUtils.java */
/* loaded from: classes3.dex */
public final class m {
    public static <T> u<Response<T>, T> a() {
        return b(null);
    }

    public static <T> u<Response<T>, T> b(@Nullable final Request request) {
        return new u() { // from class: com.tplink.libtpnetwork.cameranetwork.g4.h
            @Override // io.reactivex.u
            public final t a(q qVar) {
                t N;
                N = qVar.N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.g4.c
                    @Override // io.reactivex.g0.j
                    public final Object apply(Object obj) {
                        return m.n(Request.this, (Response) obj);
                    }
                });
                return N;
            }
        };
    }

    public static <T> u<Response<T>, Response<T>> c(@Nullable final Request request) {
        return new u() { // from class: com.tplink.libtpnetwork.cameranetwork.g4.j
            @Override // io.reactivex.u
            public final t a(q qVar) {
                t N;
                N = qVar.N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.cameranetwork.g4.f
                    @Override // io.reactivex.g0.j
                    public final Object apply(Object obj) {
                        return m.o(Request.this, (Response) obj);
                    }
                });
                return N;
            }
        };
    }

    public static <T> u<Response<T>, Response<T>> d() {
        return e(null);
    }

    public static <T> u<Response<T>, Response<T>> e(@Nullable final Request request) {
        return new u() { // from class: com.tplink.libtpnetwork.cameranetwork.g4.g
            @Override // io.reactivex.u
            public final t a(q qVar) {
                t N;
                N = qVar.N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.g4.d
                    @Override // io.reactivex.g0.j
                    public final Object apply(Object obj) {
                        return m.m(Request.this, (Response) obj);
                    }
                });
                return N;
            }
        };
    }

    private static CameraException f(@Nullable Request request, @NonNull Response response) {
        String method = response.getMethod();
        if (TextUtils.isEmpty(method) && request != null) {
            method = request.getMethod();
        }
        StringBuilder sb = new StringBuilder();
        if (request != null) {
            sb.append(request.toString());
        }
        sb.append(response.toString());
        return new CameraException(response.getErrorCode(), method, sb.toString());
    }

    public static u<Response, Boolean> g() {
        return h(null);
    }

    public static u<Response, Boolean> h(@Nullable final Request request) {
        return new u() { // from class: com.tplink.libtpnetwork.cameranetwork.g4.e
            @Override // io.reactivex.u
            public final t a(q qVar) {
                t O0;
                O0 = qVar.O0(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.g4.i
                    @Override // io.reactivex.g0.j
                    public final Object apply(Object obj) {
                        return m.p(Request.this, (Response) obj);
                    }
                });
                return O0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ t m(Request request, Response response) throws Exception {
        if (response.isSuccess()) {
            return q.f0(response);
        }
        return q.J(f(request, response));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ t n(Request request, Response response) throws Exception {
        if (response.isSuccess()) {
            return q.f0(response.getResult());
        }
        return q.J(f(request, response));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ t o(Request request, Response response) throws Exception {
        if (response.isSuccess()) {
            return q.f0(response);
        }
        return q.J(f(request, response));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ t p(Request request, Response response) throws Exception {
        if (response.isSuccess()) {
            return q.f0(Boolean.TRUE);
        }
        return q.J(f(request, response));
    }
}
