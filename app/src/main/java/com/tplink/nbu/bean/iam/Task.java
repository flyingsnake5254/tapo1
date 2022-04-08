package com.tplink.nbu.bean.iam;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes3.dex */
public class Task {
    private String businessType;
    private Material material;
    private String materialId;
    private List<String> pageList;
    private int priority;
    private boolean show;
    private String taskId;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface BusinessType {
        public static final String ANNOUNCEMENT = "announcement";
        public static final String BRAND_PROMOTION = "brandPromotion";
        public static final String MARKET_PROMOTION = "marketPromotion";
        public static final String OTHER = "other";
        public static final String USER_RESEARCH = "userResearch";
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public Material getMaterial() {
        return this.material;
    }

    public String getMaterialId() {
        return this.materialId;
    }

    public List<String> getPageList() {
        return this.pageList;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public boolean isShow() {
        return this.show;
    }

    public void setBusinessType(String str) {
        this.businessType = str;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setMaterialId(String str) {
        this.materialId = str;
    }

    public void setPageList(List<String> list) {
        this.pageList = list;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setShow(boolean z) {
        this.show = z;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }
}
