package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class Model__ModelKt {
    public static final Account passwordDigest(Account passwordDigest) {
        j.e(passwordDigest, "$this$passwordDigest");
        return passwordDigest.getHashed() ? passwordDigest : Account.copy$default(passwordDigest, null, com.tplink.libtpnetwork.cameranetwork.util.j.a(passwordDigest.getPassword()), true, 1, null);
    }
}
