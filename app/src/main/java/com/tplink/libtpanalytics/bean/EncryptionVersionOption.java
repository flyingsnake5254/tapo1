package com.tplink.libtpanalytics.bean;

import androidx.annotation.NonNull;
import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class EncryptionVersionOption {
    @c("evoi")
    private String encryptionVersionOptionId;
    private String key;
    @c("ks")
    private int keySize;
    @c("transformation")
    private String transformation;

    public String getEncryptionVersionOptionId() {
        return this.encryptionVersionOptionId;
    }

    public String getKey() {
        return this.key;
    }

    public int getKeySize() {
        return this.keySize;
    }

    public String getTransformation() {
        return this.transformation;
    }

    public void setEncryptionVersionOptionId(String str) {
        this.encryptionVersionOptionId = str;
    }

    public void setKey(@NonNull String str) {
        this.key = str;
    }

    public void setKeySize(int i) {
        this.keySize = i;
    }

    public void setTransformation(@NonNull String str) {
        this.transformation = str;
    }
}
