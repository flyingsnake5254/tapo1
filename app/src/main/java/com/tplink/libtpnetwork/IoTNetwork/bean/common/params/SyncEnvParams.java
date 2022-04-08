package com.tplink.libtpnetwork.IoTNetwork.bean.common.params;

import com.tplink.libtpnetwork.Utils.x;
import java.util.Locale;

/* loaded from: classes3.dex */
public class SyncEnvParams {
    private String lang;

    public SyncEnvParams() {
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public SyncEnvParams(Locale locale) {
        this.lang = x.d(locale);
    }
}
