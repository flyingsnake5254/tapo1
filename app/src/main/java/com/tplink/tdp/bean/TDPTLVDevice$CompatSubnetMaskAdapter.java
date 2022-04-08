package com.tplink.tdp.bean;

import b.d.c0.m.e.a;
import b.d.w.e.b;
import com.tplink.tdp.tlv.adapter.IPAdapter;

/* loaded from: classes3.dex */
public class TDPTLVDevice$CompatSubnetMaskAdapter extends IPAdapter {
    @Override // com.tplink.tdp.tlv.adapter.IPAdapter
    /* renamed from: b */
    public String a(a aVar) {
        String[] split;
        String str;
        String b2 = super.a(aVar);
        if (b2 == null || b.d(b2)) {
            return b2;
        }
        if (b2.split("\\.").length == 4) {
            str = split[3] + "." + split[2] + "." + split[1] + "." + split[0];
        } else {
            str = "";
        }
        return b.d(str) ? str : b2;
    }
}
