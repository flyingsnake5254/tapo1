package com.tplink.libtpnetwork.libwss.bean.result;

import com.tplink.libtpnetwork.libwss.enumerate.WssAccountLinkStatus;
import com.tplink.libtpnetwork.libwss.enumerate.WssFfsLinkStatus;
import com.tplink.libtpnetwork.libwss.enumerate.WssSkillEnableStatus;

/* loaded from: classes3.dex */
public class AccountAndSkillStatusResult {
    private WssAccountLinkStatus accountLinkStatus;
    private WssFfsLinkStatus ffsLinkStatus;
    private WssSkillEnableStatus skillEnableStatus;

    public WssAccountLinkStatus getAccountLinkStatus() {
        return this.accountLinkStatus;
    }

    public WssFfsLinkStatus getFfsLinkStatus() {
        return this.ffsLinkStatus;
    }

    public WssSkillEnableStatus getSkillEnableStatus() {
        return this.skillEnableStatus;
    }

    public boolean isStatusOk() {
        return this.accountLinkStatus == WssAccountLinkStatus.LINKED && this.skillEnableStatus == WssSkillEnableStatus.ENABLED;
    }

    public void setAccountLinkStatus(WssAccountLinkStatus wssAccountLinkStatus) {
        this.accountLinkStatus = wssAccountLinkStatus;
    }

    public void setFfsLinkStatus(WssFfsLinkStatus wssFfsLinkStatus) {
        this.ffsLinkStatus = wssFfsLinkStatus;
    }

    public void setSkillEnableStatus(WssSkillEnableStatus wssSkillEnableStatus) {
        this.skillEnableStatus = wssSkillEnableStatus;
    }
}
