package com.tplink.tmp.exception;

import b.d.d0.f2.c;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TPGeneralNetworkException extends Exception {
    private int errCode;
    private String errMsg;

    public TPGeneralNetworkException(int i) {
        this.errCode = i;
        this.errMsg = c.g.get(Integer.valueOf(i));
    }

    public static boolean isCancelException(Throwable th) {
        return (th instanceof TPGeneralNetworkException) && -1010 == ((TPGeneralNetworkException) th).getErrCode();
    }

    public static boolean isClientException(Throwable th) {
        return (th instanceof TPGeneralNetworkException) && -1008 == ((TPGeneralNetworkException) th).getErrCode();
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", this.errCode);
            jSONObject.put("errMsg", this.errMsg);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public TPGeneralNetworkException(int i, String str) {
        this.errCode = i;
        this.errMsg = str;
    }
}
