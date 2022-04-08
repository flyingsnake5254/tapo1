package com.tplink.tdp.bean;

import b.d.c0.m.e.a;
import com.tplink.tdp.tlv.adapter.c;

/* loaded from: classes3.dex */
public class TDPTLVDevice$ByteToBoolAdapter extends c<Boolean> {
    /* renamed from: b */
    public Boolean a(a aVar) {
        Byte e2 = aVar.e();
        return Boolean.valueOf((e2 == null || e2.byteValue() == 0) ? false : true);
    }
}
