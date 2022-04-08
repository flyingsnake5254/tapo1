package com.tplink.iot.cloud.bean.billing.result;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class JudgeReceiptResult {
    private int status;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface JudgeStatus {
        public static final int EXPIRED = -10107;
        public static final int MATCHING = 0;
        public static final int NOT_MATCHING = -10102;
        public static final int RECEIPT_NOT_FOUND = -10105;
        public static final int VERIFY_FAIL = -10106;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
