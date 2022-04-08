package com.tplink.iot.cloud.bean.family.common;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.common.PreviewAudio;
import java.util.List;

/* loaded from: classes2.dex */
public class FamilyInfo {
    private String id;
    @c(PreviewAudio.AUDIO_DEFAULT)
    private boolean isDefault;
    private String name;
    private List<RoomInfo> rooms;

    public FamilyInfo() {
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<RoomInfo> getRooms() {
        return this.rooms;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public void setDefault(boolean z) {
        this.isDefault = z;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRooms(List<RoomInfo> list) {
        this.rooms = list;
    }

    public FamilyInfo(String str, String str2) {
        this.id = str;
        this.name = str2;
    }
}
