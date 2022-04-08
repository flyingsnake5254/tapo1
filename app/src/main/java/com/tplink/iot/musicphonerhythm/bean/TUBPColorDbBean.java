package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class TUBPColorDbBean {
    @c("color_state")
    private ArrayList<Integer> colorState;
    @c("delta_db")
    private int deltaDb;

    public TUBPColorDbBean() {
    }

    public void setColorState(ArrayList<Integer> arrayList) {
        this.colorState = arrayList;
    }

    public void setDeltaDb(int i) {
        this.deltaDb = i;
    }

    public TUBPColorDbBean(ArrayList<Integer> arrayList, int i) {
        this.colorState = arrayList;
        this.deltaDb = i;
    }
}
