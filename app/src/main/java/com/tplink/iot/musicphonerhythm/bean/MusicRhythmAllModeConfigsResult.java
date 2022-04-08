package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.common.PreviewAudio;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class MusicRhythmAllModeConfigsResult {
    @c(PreviewAudio.AUDIO_ENABLE)
    private boolean enable;
    @c("rule_list")
    private ArrayList<MusicRhythmModeConfigParams> ruleList;
    @c("rule_max_count")
    private int ruleMaxCount;
    @c("start_index")
    private int startIndex;
    @c("sum")
    private int sum;

    public ArrayList<MusicRhythmModeConfigParams> getRuleList() {
        return this.ruleList;
    }

    public int getRuleMaxCount() {
        return this.ruleMaxCount;
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

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setRuleList(ArrayList<MusicRhythmModeConfigParams> arrayList) {
        this.ruleList = arrayList;
    }

    public void setRuleMaxCount(int i) {
        this.ruleMaxCount = i;
    }

    public void setStartIndex(int i) {
        this.startIndex = i;
    }

    public void setSum(int i) {
        this.sum = i;
    }
}
