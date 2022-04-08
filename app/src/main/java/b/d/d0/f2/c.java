package b.d.d0.f2;

import androidx.core.app.NotificationManagerCompat;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TMPNetworkDefine.java */
/* loaded from: classes3.dex */
public class c {
    public static final Map<Byte, String> a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<Byte, String> f259b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<Byte, String> f260c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<Byte, String> f261d;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<Byte, String> f262e;

    /* renamed from: f  reason: collision with root package name */
    public static final Map<Byte, String> f263f;
    public static final Map<Integer, String> g;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put((byte) 0, "TMP_APPV2_ERR_NO_ERROR");
        hashMap.put((byte) 1, "TMP_APPV2_ERR_UNKNOWN_ERROR");
        hashMap.put((byte) 2, "TMP_APPV2_ERR_BUSINESS_TYPE");
        hashMap.put((byte) 3, "TMP_APPV2_ERR_BUSINESS_VERSION");
        hashMap.put((byte) 4, "TMP_APPV2_ERR_OPERATION");
        hashMap.put((byte) 5, "TMP_APPV2_ERR_FLAGS");
        hashMap.put((byte) 6, "TMP_APPV2_ERR_TRANS_ID");
        hashMap.put((byte) 7, "TMP_APPV2_ERR_TRANS_CRC32");
        hashMap.put((byte) 8, "TMP_APPV2_ERR_TRANS_TOTAL_BYTES");
        hashMap.put((byte) 9, "TMP_APPV2_ERR_TRANS_START_BYTE");
        hashMap.put((byte) 10, "TMP_APPV2_ERR_TOKEN_EXPIRED");
        hashMap.put((byte) 11, "TMP_APPV2_ERR_TOKEN_ALLOC");
        hashMap.put((byte) 12, "TMP_APPV2_ERR_BUSINESS_FAILED");
        HashMap hashMap2 = new HashMap();
        f259b = hashMap2;
        hashMap2.put((byte) 1, "TMP_APPV2_FLAGS_ACK");
        hashMap2.put((byte) 2, "TMP_APPV2_FLAGS_PUSH");
        hashMap2.put((byte) 4, "TMP_APPV2_FLAGS_PULL");
        hashMap2.put((byte) 3, "TMP_APPV2_FLAGS_PUSH_ACK");
        hashMap2.put((byte) 5, "TMP_APPV2_FLAGS_PULL_ACK");
        HashMap hashMap3 = new HashMap();
        f260c = hashMap3;
        hashMap3.put((byte) 0, "TMP_ERR_OK");
        hashMap3.put((byte) 1, "TMP_ERR_FAILED");
        hashMap3.put((byte) 2, "TMP_ERR_VERSION");
        hashMap3.put((byte) 3, "TMP_ERR_PAYLOADLEN");
        hashMap3.put((byte) 4, "TMP_ERR_SN");
        hashMap3.put((byte) 5, "TMP_ERR_CHECKSUM");
        HashMap hashMap4 = new HashMap();
        f261d = hashMap4;
        hashMap4.put((byte) 0, "TMP_HDR_FLAG_NONE");
        hashMap4.put((byte) 1, "TMP_HDR_FLAG_COMPRESS");
        hashMap4.put((byte) 2, "TMP_HDR_FLAG_ENCRYPT");
        HashMap hashMap5 = new HashMap();
        f262e = hashMap5;
        hashMap5.put((byte) 0, "TMP_GPH_REASON_NO_REASON");
        hashMap5.put((byte) 1, "TMP_GPH_REASON_UNKNOWN_REASON");
        hashMap5.put((byte) 2, "TMP_GPH_REASON_HEART_BEAT_TIME_OUT");
        hashMap5.put((byte) 3, "TMP_GPH_REASON_CLIENT_LIMIT");
        hashMap5.put((byte) 4, "TMP_GPH_REASON_SYSTEM_REBOOT");
        hashMap5.put((byte) 5, "TMP_GPH_REASON_WIRELESS_DOWN");
        hashMap5.put((byte) 6, "TMP_GPH_REASON_SYSTEM_UPGRADE");
        HashMap hashMap6 = new HashMap();
        f263f = hashMap6;
        hashMap6.put((byte) 1, "TMP_GPH_CC_ASSOC_REQ");
        hashMap6.put((byte) 2, "TMP_GPH_CC_ASSOC_ACCEPT");
        hashMap6.put((byte) 3, "TMP_GPH_CC_ASSOC_REFUSE");
        hashMap6.put((byte) 4, "TMP_GPH_CC_HELLO");
        hashMap6.put((byte) 5, "TMP_GPH_CC_DATA_TRANSFER");
        hashMap6.put((byte) 6, "TMP_GPH_CC_BYE");
        HashMap hashMap7 = new HashMap();
        g = hashMap7;
        hashMap7.put(0, "ERR_SUCCESS");
        hashMap7.put(-1, "ERR_COMMON_FAILED");
        hashMap7.put(Integer.valueOf((int) NotificationManagerCompat.IMPORTANCE_UNSPECIFIED), "ERR_OPEN_TMPCLIENT_PARAMS_NULL");
        hashMap7.put(Integer.valueOf((int) FirmwareDownloadState.UPGRADE_STATE_DOWNLOAD_FAIL), "ERR_INVALID_TRANSPORT_PARAMS_SSH2_SERVER_IP_EMPTY");
        hashMap7.put(Integer.valueOf((int) FirmwareDownloadState.UPGRADE_STATE_CHECK_FAIL), "ERR_INVALID_TRANSPORT_PARAMS_USERNAME_EMPTY");
        hashMap7.put(Integer.valueOf((int) FirmwareDownloadState.UPGRADE_STATE_TRANSFER_FAIL), "ERR_INVALID_TRANSPORT_PARAMS_PASSWORD_EMPTY");
        hashMap7.put(-1004, "ERR_INVALID_TRANSPORT_PARAMS_HOST_EMPTY");
        hashMap7.put(-1005, "ERR_INVALID_TRANSPORT_PARAMS_DEVICEID_EMPTY");
        hashMap7.put(-1006, "ERR_INVALID_TRANSPORT_PARAMS_BLETRANSPORT_CALLBACK_EMPTY");
        hashMap7.put(-1007, "ERR_INVALID_TRANSPORT_PARAMS_TRANSPORT_TYPE_EMPTY");
        hashMap7.put(-1100, "ERR_INVALID_ALL_PAYLOAD_CHECKSUM");
        hashMap7.put(-1101, "ERR_TRANSACTION_HANDLING");
        hashMap7.put(-1201, "ERR_UNKNOWN_TRANSPORT");
        hashMap7.put(-1202, "ERR_INVALID_TMP_MAIN_VERSION");
        hashMap7.put(-1203, "ERR_INVALID_TMP_SECOND_VERSION");
        hashMap7.put(-1204, "ERR_INVALID_TMP_BYE_NO_RESON");
        hashMap7.put(-1205, "ERR_INVALID_TMP_BYE_UNKNOWN_REASON");
        hashMap7.put(-1206, "ERR_INVALID_TMP_BYE_HEART_BEAT_TIME_OUT");
        hashMap7.put(-1207, "ERR_INVALID_TMP_BYE_CLIENT_LIMIT");
        hashMap7.put(-1208, "ERR_INVALID_TMP_BYE_SYSTEM_REBOOT");
        hashMap7.put(-1209, "ERR_INVALID_TMP_BYE_WIRELESS_DOWN");
        hashMap7.put(-1210, "ERR_INVALID_TMP_BYE_SYSTEM_UPGRADE");
        hashMap7.put(-1211, "ERR_INVALID_TMP_INVALID_CHECKSUM");
        hashMap7.put(-1212, "ERR_INVALID_TMP_INVALID_BUSINESS_TYPE");
        hashMap7.put(-1213, "ERR_INVALID_TMP_INVALID_BUSINESS_VER");
        hashMap7.put(-1214, "ERR_INVALID_TMP_INVALID_BUSINESS_CONFIG_INFO_LACKED");
        hashMap7.put(-1215, "ERR_INVALID_TMP_INVALID_TOTAL_PAYLOAD_LENGTH");
        hashMap7.put(-1216, "ERR_INVALID_TMP_APPV2_TRANSACTION_HANDLER_NULL");
        hashMap7.put(-1217, "ERR_INVALID_TMP_INVALID_APPV2_CONFIG_INFO_LACKED");
        hashMap7.put(-1218, "ERR_INVALID_TMP_GENERAL_CONFIG_VERSION");
        hashMap7.put(-1219, "ERR_INVALID_TMP_GENERAL_CONFIG_PAYLOADLEN");
        hashMap7.put(-1220, "ERR_INVALID_TMP_GENERAL_CONFIG_SN");
        hashMap7.put(-1221, "ERR_INVALID_TMP_GENERAL_CONFIG_CHECKSUM");
        hashMap7.put(-1222, "ERR_TMP_APPV2_BUSINESS_TYPE");
        hashMap7.put(-1223, "ERR_TMP_APPV2_BUSINESS_VERSION");
        hashMap7.put(-1224, "ERR_TMP_APPV2_OPERATION");
        hashMap7.put(-1225, "ERR_TMP_APPV2_FLAGS");
        hashMap7.put(-1226, "ERR_TMP_APPV2_TRANS_ID");
        hashMap7.put(-1227, "ERR_TMP_APPV2_TRANS_CRC32");
        hashMap7.put(-1228, "ERR_TMP_APPV2_TRANS_TOTAL_BYTES");
        hashMap7.put(-1229, "ERR_TMP_APPV2_TRANS_START_BYTE");
        hashMap7.put(-1230, "ERR_TMP_APPV2_TOKEN_EXPIRED");
        hashMap7.put(-1231, "ERR_TMP_APPV2_TOKEN_ALLOC");
        hashMap7.put(-1232, "ERR_TMP_APPV2_BUSINESS_FAILED");
        hashMap7.put(-1233, "ERR_TMP_VER_ASSOC_REFUSE");
        hashMap7.put(-1234, "ERR_TMP_VER_ASSOC_FAIL");
        hashMap7.put(-1235, "ERR_TMP_COMP_ASSOC_FAIL");
        hashMap7.put(-1236, "ERR_TMP_BYE_USER_COUNT_EXCEED");
        hashMap7.put(-1237, "ERR_TMP_BYE_AUTH_CHANGED");
        hashMap7.put(-1238, "ERR_TMP_BYE_KICK_OUT");
        hashMap7.put(-1239, "ERR_TMP_BYE_UNKNOWN");
        hashMap7.put(-1240, "ERR_TMP_BYE_COMPONENT_CHANGED");
        hashMap7.put(-1008, "ERR_NULL_AVAILABLE_TMPCLIENT");
        hashMap7.put(-1009, "ERR_BUSINESSLAYER_NULL");
        hashMap7.put(-1010, "ERR_CMD_COMMAND_CANCEL");
        hashMap7.put(-1011, "ERR_TMPLAYER_NULL");
        hashMap7.put(-1012, "ERR_INVALID_TRANSPORT_PARAMS_BLETRANSPORT_DEVICE_ADDRESS_EMPTY");
        hashMap7.put(-1013, "ERR_CLIENT_MANUAL_CLOSED");
        hashMap7.put(-1300, "ERR_ATA_DISCONNECTED_NETWORK");
        hashMap7.put(-1301, "ERR_ATA_DISCONNECTED_HANDLING");
        hashMap7.put(-1302, "ERR_ATA_DISCONNECTED_RAW_DATA");
        hashMap7.put(-1303, "ERR_ATA_DISCONNECTED_SN");
        hashMap7.put(-1304, "ERR_ATA_DISCONNECTED_CONNECT");
        hashMap7.put(-1305, "ERR_ATA_DISCONNECTED_TOKEN_EXPIRED");
        hashMap7.put(-1410, "ERR_SSH2_AUTH_FAIL");
        hashMap7.put(-1411, "ERR_SSH2_TIMEOUT");
        hashMap7.put(-1412, "ERR_SSH2_EXEC_SCP_FAIL");
    }
}
