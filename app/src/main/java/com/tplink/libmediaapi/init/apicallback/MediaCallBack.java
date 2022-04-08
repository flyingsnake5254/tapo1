package com.tplink.libmediaapi.init.apicallback;

import android.util.Pair;
import com.tplink.libmediaapi.live.apienum.EnumBitStreamType;
import io.reactivex.q;

/* loaded from: classes3.dex */
public interface MediaCallBack {
    void forceUpdateP2PSharePassword(String str);

    q<Pair<byte[], byte[]>> getAesEncryptKey(String str);

    EnumBitStreamType getBitStreamType(String str);

    String getLoginCloudUserName();

    String getLoginToken();

    String getMediaLoginPassword();

    String getPskId(String str);

    String getPskPwd(String str);

    String getServerUrl();

    String getUpnpIp(String str);

    int getUpnpPort(String str);

    String getUpnpStatus(String str);

    int getUpnpTimestamp(String str);

    String getUuid();

    boolean isUpnpEnabled(String str);

    q renewUpnpPsk(String str);

    void storeBitStreamType(String str, EnumBitStreamType enumBitStreamType);

    void storeFileMemory(String str, String str2, String str3, int i);

    void storePreImageUrl(String str, String str2);

    void syncDeviceAccount(String str);

    void updateUpnpCommStatus(String str, String str2);
}
