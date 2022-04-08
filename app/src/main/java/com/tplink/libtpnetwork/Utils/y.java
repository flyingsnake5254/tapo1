package com.tplink.libtpnetwork.Utils;

import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.IoTCloudExceptionDataResult;
import com.tplink.libtpnetwork.exception.IoTException;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import com.tplink.tmp.exception.TPGeneralNetworkException;

/* compiled from: ThrowableUtils.java */
/* loaded from: classes3.dex */
public class y {
    public static int a(Throwable th) {
        int i;
        IoTCloudExceptionDataResult ioTCloudExceptionDataResult;
        if (th instanceof IoTTransportException) {
            i = ((IoTTransportException) th).getErrCode();
        } else if (th instanceof IoTException) {
            i = ((IoTException) th).getErrCode();
        } else if (th instanceof TPGeneralNetworkException) {
            i = ((TPGeneralNetworkException) th).getErrCode();
        } else if (th instanceof IoTCloudException) {
            try {
                ioTCloudExceptionDataResult = (IoTCloudExceptionDataResult) i.a(((IoTCloudException) th).getData(), IoTCloudExceptionDataResult.class);
            } catch (Exception unused) {
                ioTCloudExceptionDataResult = null;
            }
            if (ioTCloudExceptionDataResult != null) {
                i = ioTCloudExceptionDataResult.getCodeFromDevice();
            } else {
                i = ((IoTCloudException) th).getCode();
            }
        } else {
            i = -1;
        }
        if (i == 0) {
            return -1;
        }
        return i;
    }
}
