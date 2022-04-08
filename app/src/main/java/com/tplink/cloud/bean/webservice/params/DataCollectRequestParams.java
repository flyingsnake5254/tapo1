package com.tplink.cloud.bean.webservice.params;

import com.google.gson.k;
import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DataCollectRequestParams {
    @c("el")
    private List<DataCollectEventBean> eventList;
    @c("ex")
    private k extension;
    @c("lg")
    private String language;
    @c("sr")
    private String source;
    @c("srp")
    private k sourceParams;
    @c("tz")
    private Integer timeZone;
    private String uvi;

    public void addEvent(DataCollectEventBean dataCollectEventBean) {
        if (this.eventList == null) {
            this.eventList = new ArrayList();
        }
        this.eventList.add(dataCollectEventBean);
    }

    public List<DataCollectEventBean> getEventList() {
        return this.eventList;
    }

    public k getExtension() {
        return this.extension;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getSource() {
        return this.source;
    }

    public k getSourceParams() {
        return this.sourceParams;
    }

    public Integer getTimeZone() {
        return this.timeZone;
    }

    public String getUvi() {
        return this.uvi;
    }

    public void setEventList(ArrayList<DataCollectEventBean> arrayList) {
        this.eventList = arrayList;
    }

    public void setExtension(k kVar) {
        this.extension = kVar;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setSourceParams(k kVar) {
        this.sourceParams = kVar;
    }

    public void setTimeZone(Integer num) {
        this.timeZone = num;
    }

    public void setUvi(String str) {
        this.uvi = str;
    }
}
