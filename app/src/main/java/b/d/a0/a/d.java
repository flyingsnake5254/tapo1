package b.d.a0.a;

import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;

/* compiled from: VodConnection.java */
/* loaded from: classes3.dex */
public class d extends BaseConnection {
    public d(String str, DeviceModel deviceModel) {
        super(str, deviceModel);
        this.mediaType = 1;
        this.streamType = 1;
    }

    /* renamed from: a */
    public d clone() {
        d dVar = new d(this.deviceIdMD5, this.deviceModel);
        dVar.isLocal = this.isLocal;
        dVar.portId = this.portId;
        dVar.statistics = this.statistics;
        dVar.url = this.url;
        dVar.audioType = this.audioType;
        dVar.connectionType = this.connectionType;
        dVar.createTime = this.createTime;
        dVar.encryptType = this.encryptType;
        dVar.relayTime = this.relayTime;
        dVar.bitStreamType = this.bitStreamType;
        return dVar;
    }

    public String toString() {
        int i = this.streamType;
        String str = 1 == i ? "MIXED" : 3 == i ? "DUAL VIDEO" : "DUAL AUDIO";
        int i2 = this.connectionType;
        String str2 = 256 == i2 ? "Local" : 16 == i2 ? "P2P" : "Relay";
        if (this.statistics != null) {
            str2 = str2.concat("\nstatistics : ").concat(this.statistics.toString());
        }
        String concat = "\n".concat(this.deviceIdMD5).concat("\nisLocal : ").concat(String.valueOf(this.isLocal)).concat("\nurl : ");
        String str3 = this.url;
        String str4 = "";
        if (str3 == null) {
            str3 = str4;
        }
        String concat2 = concat.concat(str3).concat("\nstreamType : ").concat(str).concat("\nconnectionType : ").concat(str2).concat("\ncreateTime : ");
        String concat3 = concat2.concat(str4 + this.createTime).concat("\nencryptType : ");
        String str5 = this.encryptType;
        if (str5 != null) {
            str4 = str5;
        }
        return concat3.concat(String.valueOf(str4)).concat("\nrelayTime : ").concat(String.valueOf(this.relayTime)).concat("\nresolution : ");
    }
}
