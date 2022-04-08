package b.d.d.j;

import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import io.reactivex.q;

/* compiled from: TPMediaSDKCallBack.java */
/* loaded from: classes3.dex */
public interface a {
    void forceUpdateP2PSharePassword(String str);

    q<b.d.p.a> getAesEncryptKey(String str);

    BitStreamType getBitStreamType(String str);

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

    void storeBitStreamType(String str, BitStreamType bitStreamType);

    void storeFileMemory(String str, String str2, String str3, int i);

    void storePreImageUrl(String str, String str2);

    void syncDeviceAccount(String str);

    void updateUpnpCommStatus(String str, String str2);
}
