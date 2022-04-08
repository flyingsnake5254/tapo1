package b.d.m.a;

import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;

/* compiled from: DownloadConnection.java */
/* loaded from: classes3.dex */
public class a extends BaseConnection {
    public a(String str, DeviceModel deviceModel) {
        super(str, deviceModel);
        this.mediaType = 3;
        this.streamType = 1;
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

    @Override // com.tplink.libtpstreampreconnect.bean.BaseConnection
    public BaseConnection clone() {
        a aVar = new a(this.deviceIdMD5, this.deviceModel);
        aVar.isLocal = this.isLocal;
        aVar.portId = this.portId;
        aVar.statistics = this.statistics;
        aVar.url = this.url;
        aVar.audioType = this.audioType;
        aVar.connectionType = this.connectionType;
        aVar.createTime = this.createTime;
        aVar.encryptType = this.encryptType;
        aVar.relayTime = this.relayTime;
        aVar.bitStreamType = this.bitStreamType;
        return aVar;
    }
}
