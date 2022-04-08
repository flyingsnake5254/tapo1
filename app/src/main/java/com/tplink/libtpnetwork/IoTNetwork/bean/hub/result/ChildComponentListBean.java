package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.google.gson.q.c;
import java.util.List;

/* loaded from: classes3.dex */
public class ChildComponentListBean {
    @c("child_component_list")
    private List<ChildComponentBean> childComponentList;
    @c("start_index")
    private int startIndex;
    private int sum;

    public List<ChildComponentBean> getChildComponentList() {
        return this.childComponentList;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public int getSum() {
        return this.sum;
    }

    public void setChildComponentList(List<ChildComponentBean> list) {
        this.childComponentList = list;
    }

    public void setStartIndex(int i) {
        this.startIndex = i;
    }

    public void setSum(int i) {
        this.sum = i;
    }
}
