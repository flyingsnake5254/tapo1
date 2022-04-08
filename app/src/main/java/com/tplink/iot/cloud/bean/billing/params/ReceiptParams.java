package com.tplink.iot.cloud.bean.billing.params;

/* loaded from: classes2.dex */
public class ReceiptParams {
    private String accountId;
    private String platform;
    private PurchaseData purchaseData;

    /* loaded from: classes2.dex */
    public static class PurchaseData {
        private String packageName;
        private String productId;
        private String purchaseToken;

        public String getPackageName() {
            return this.packageName;
        }

        public String getProductId() {
            return this.productId;
        }

        public String getPurchaseToken() {
            return this.purchaseToken;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setProductId(String str) {
            this.productId = str;
        }

        public void setPurchaseToken(String str) {
            this.purchaseToken = str;
        }
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getPlatform() {
        return this.platform;
    }

    public PurchaseData getPurchaseData() {
        return this.purchaseData;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setPurchaseData(PurchaseData purchaseData) {
        this.purchaseData = purchaseData;
    }
}
