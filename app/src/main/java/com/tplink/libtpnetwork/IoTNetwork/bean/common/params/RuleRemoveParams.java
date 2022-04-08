package com.tplink.libtpnetwork.IoTNetwork.bean.common.params;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RuleRemoveParams {
    @c("remove_all")
    private boolean removeAll;
    @c("rule_list")
    private List<RuleIdParams> ruleList;

    public RuleRemoveParams() {
    }

    public List<RuleIdParams> getRuleList() {
        return this.ruleList;
    }

    public boolean isRemoveAll() {
        return this.removeAll;
    }

    public void setRemoveAll(boolean z) {
        this.removeAll = z;
    }

    public void setRuleList(List<RuleIdParams> list) {
        this.ruleList = list;
    }

    public RuleRemoveParams(boolean z, List<String> list) {
        this.removeAll = z;
        if (list != null) {
            this.ruleList = new ArrayList();
            for (String str : list) {
                this.ruleList.add(new RuleIdParams(str));
            }
        }
    }
}
