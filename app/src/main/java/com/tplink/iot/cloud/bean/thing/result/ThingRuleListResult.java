package com.tplink.iot.cloud.bean.thing.result;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ThingRuleListResult<T> {
    @c(alternate = {"current_rule_id"}, value = "currentRuleId")
    private String currentRuleId;
    @c(alternate = {"antitheft_rule_max_count", "countdown_rule_max_count", "schedule_rule_max_count", "max_count"}, value = "maxCount")
    private int maxCount;
    @c(alternate = {"start_index"}, value = "startIndex")
    private int startIndex;
    private int sum;
    private boolean enable = true;
    @c(alternate = {"rule_list"}, value = "ruleList")
    private List<T> ruleList = new ArrayList();

    public String getCurrentRuleId() {
        return this.currentRuleId;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    public List<T> getRuleList() {
        return this.ruleList;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public int getSum() {
        return this.sum;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setCurrentRuleId(String str) {
        this.currentRuleId = str;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setMaxCount(int i) {
        this.maxCount = i;
    }

    public void setRuleList(List<T> list) {
        this.ruleList = list;
    }

    public void setStartIndex(int i) {
        this.startIndex = i;
    }

    public void setSum(int i) {
        this.sum = i;
    }
}
