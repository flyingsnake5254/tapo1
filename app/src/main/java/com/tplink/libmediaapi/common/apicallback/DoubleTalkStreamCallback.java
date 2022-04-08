package com.tplink.libmediaapi.common.apicallback;

/* loaded from: classes3.dex */
public interface DoubleTalkStreamCallback {
    void onDoubleTalkClose(String str);

    void onDoubleTalkCreateFailure(String str, int i);

    void onDoubleTalkCreateSuccess(String str);

    void onDoubleTalkSendDataFailure(String str, int i, Exception exc);
}
