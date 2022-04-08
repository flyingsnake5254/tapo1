package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class VHttpd {
    private String desc;
    @c("ext_port")
    private String extPort;
    @c("inner_port")
    private String innerPort;
    private String ipaddr;
    private String proto;
    private String status;

    public VHttpd(String str, String str2, String proto, String str3, String str4, String str5) {
        j.e(proto, "proto");
        this.ipaddr = str;
        this.status = str2;
        this.proto = proto;
        this.innerPort = str3;
        this.desc = str4;
        this.extPort = str5;
    }

    public static /* synthetic */ VHttpd copy$default(VHttpd vHttpd, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vHttpd.ipaddr;
        }
        if ((i & 2) != 0) {
            str2 = vHttpd.status;
        }
        if ((i & 4) != 0) {
            str3 = vHttpd.proto;
        }
        if ((i & 8) != 0) {
            str4 = vHttpd.innerPort;
        }
        if ((i & 16) != 0) {
            str5 = vHttpd.desc;
        }
        if ((i & 32) != 0) {
            str6 = vHttpd.extPort;
        }
        return vHttpd.copy(str, str2, str3, str4, str5, str6);
    }

    public final String component1() {
        return this.ipaddr;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.proto;
    }

    public final String component4() {
        return this.innerPort;
    }

    public final String component5() {
        return this.desc;
    }

    public final String component6() {
        return this.extPort;
    }

    public final VHttpd copy(String str, String str2, String proto, String str3, String str4, String str5) {
        j.e(proto, "proto");
        return new VHttpd(str, str2, proto, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VHttpd)) {
            return false;
        }
        VHttpd vHttpd = (VHttpd) obj;
        return j.a(this.ipaddr, vHttpd.ipaddr) && j.a(this.status, vHttpd.status) && j.a(this.proto, vHttpd.proto) && j.a(this.innerPort, vHttpd.innerPort) && j.a(this.desc, vHttpd.desc) && j.a(this.extPort, vHttpd.extPort);
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getExtPort() {
        return this.extPort;
    }

    public final String getInnerPort() {
        return this.innerPort;
    }

    public final String getIpaddr() {
        return this.ipaddr;
    }

    public final String getProto() {
        return this.proto;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.ipaddr;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.proto;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.innerPort;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.desc;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.extPort;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setExtPort(String str) {
        this.extPort = str;
    }

    public final void setInnerPort(String str) {
        this.innerPort = str;
    }

    public final void setIpaddr(String str) {
        this.ipaddr = str;
    }

    public final void setProto(String str) {
        j.e(str, "<set-?>");
        this.proto = str;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        return "VHttpd(ipaddr=" + this.ipaddr + ", status=" + this.status + ", proto=" + this.proto + ", innerPort=" + this.innerPort + ", desc=" + this.desc + ", extPort=" + this.extPort + ")";
    }
}
