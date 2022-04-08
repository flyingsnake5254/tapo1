package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class AESEncryptKey {
    private final String aes_iv;
    private final String aes_key;

    public AESEncryptKey(String aes_key, String aes_iv) {
        j.e(aes_key, "aes_key");
        j.e(aes_iv, "aes_iv");
        this.aes_key = aes_key;
        this.aes_iv = aes_iv;
    }

    public static /* synthetic */ AESEncryptKey copy$default(AESEncryptKey aESEncryptKey, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aESEncryptKey.aes_key;
        }
        if ((i & 2) != 0) {
            str2 = aESEncryptKey.aes_iv;
        }
        return aESEncryptKey.copy(str, str2);
    }

    public final String component1() {
        return this.aes_key;
    }

    public final String component2() {
        return this.aes_iv;
    }

    public final AESEncryptKey copy(String aes_key, String aes_iv) {
        j.e(aes_key, "aes_key");
        j.e(aes_iv, "aes_iv");
        return new AESEncryptKey(aes_key, aes_iv);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AESEncryptKey)) {
            return false;
        }
        AESEncryptKey aESEncryptKey = (AESEncryptKey) obj;
        return j.a(this.aes_key, aESEncryptKey.aes_key) && j.a(this.aes_iv, aESEncryptKey.aes_iv);
    }

    public final String getAes_iv() {
        return this.aes_iv;
    }

    public final String getAes_key() {
        return this.aes_key;
    }

    public int hashCode() {
        String str = this.aes_key;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.aes_iv;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AESEncryptKey(aes_key=" + this.aes_key + ", aes_iv=" + this.aes_iv + ")";
    }
}
