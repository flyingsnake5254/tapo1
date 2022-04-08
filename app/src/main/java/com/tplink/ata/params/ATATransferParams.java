package com.tplink.ata.params;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.ata.common.ATAMethodType;
import com.tplink.ata.common.ByteArrayBase64TypeAdapter;

/* loaded from: classes2.dex */
public class ATATransferParams extends ATABaseParams {
    @c("raw_data")
    @b(ByteArrayBase64TypeAdapter.class)
    private byte[] rawData;
    private long sn;

    public ATATransferParams() {
    }

    public byte[] getRawData() {
        return this.rawData;
    }

    public long getSn() {
        return this.sn;
    }

    public void setRawData(byte[] bArr) {
        this.rawData = bArr;
    }

    public void setSn(long j) {
        this.sn = j;
    }

    public ATATransferParams(String str, long j, byte[] bArr) {
        super(str, ATAMethodType.TRANSFER);
        this.sn = j;
        this.rawData = bArr;
    }
}
