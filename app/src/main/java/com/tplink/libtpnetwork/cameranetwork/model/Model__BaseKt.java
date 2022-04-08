package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Base.kt */
/* loaded from: classes3.dex */
final /* synthetic */ class Model__BaseKt {
    public static final <R> Response<R> safeCast(Response<? extends Object> safeCast, Method method) {
        j.e(safeCast, "$this$safeCast");
        j.e(method, "method");
        if (j.a(method.getValue(), safeCast.getMethod())) {
            return safeCast.repack(safeCast.getResult());
        }
        return null;
    }
}
