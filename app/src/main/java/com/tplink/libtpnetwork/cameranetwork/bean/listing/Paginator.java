package com.tplink.libtpnetwork.cameranetwork.bean.listing;

/* loaded from: classes3.dex */
public class Paginator {
    private Long endingBefore;
    private Long from;
    private Long pageSize;
    private Long startingAfter;
    private Long to;
    private Long total;

    public static Paginator getDefault() {
        Paginator paginator = new Paginator();
        paginator.setFrom(0L);
        paginator.setPageSize(20L);
        return paginator;
    }

    public Long getEndingBefore() {
        return this.endingBefore;
    }

    public Long getFrom() {
        return this.from;
    }

    public Long getPageSize() {
        return this.pageSize;
    }

    public Long getStartingAfter() {
        return this.startingAfter;
    }

    public Long getTo() {
        return this.to;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setEndingBefore(Long l) {
        this.endingBefore = l;
    }

    public void setFrom(Long l) {
        this.from = l;
    }

    public void setPageSize(Long l) {
        this.pageSize = l;
    }

    public void setStartingAfter(Long l) {
        this.startingAfter = l;
    }

    public void setTo(Long l) {
        this.to = l;
    }

    public void setTotal(Long l) {
        this.total = l;
    }
}
