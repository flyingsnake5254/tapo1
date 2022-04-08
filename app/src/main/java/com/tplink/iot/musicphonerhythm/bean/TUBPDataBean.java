package com.tplink.iot.musicphonerhythm.bean;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.q.c;

/* loaded from: classes2.dex */
public class TUBPDataBean {
    @c(FirebaseAnalytics.Param.METHOD)
    private String method;
    @c("params")
    private TUBPColorDbBean params;

    public TUBPDataBean(String str, TUBPColorDbBean tUBPColorDbBean) {
        this.method = str;
        this.params = tUBPColorDbBean;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setParams(TUBPColorDbBean tUBPColorDbBean) {
        this.params = tUBPColorDbBean;
    }
}
