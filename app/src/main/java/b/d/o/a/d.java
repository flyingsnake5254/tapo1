package b.d.o.a;

import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;

/* compiled from: LiveConnection.java */
/* loaded from: classes3.dex */
public class d extends BaseConnection {
    public d(String str, int i, int i2, DeviceModel deviceModel) {
        super(str, deviceModel);
        this.mediaType = 0;
        this.connectionType = i;
        this.streamType = i2;
    }

    /* renamed from: a */
    public d clone() {
        d dVar = new d(this.deviceIdMD5, this.connectionType, this.streamType, this.deviceModel);
        dVar.isLocal = this.isLocal;
        dVar.portId = this.portId;
        dVar.statistics = this.statistics;
        dVar.url = this.url;
        dVar.streamType = this.streamType;
        dVar.audioType = this.audioType;
        dVar.connectionType = this.connectionType;
        dVar.createTime = this.createTime;
        dVar.encryptType = this.encryptType;
        dVar.relayTime = this.relayTime;
        dVar.bitStreamType = this.bitStreamType;
        return dVar;
    }

    public boolean b() {
        return System.currentTimeMillis() - this.createTime < 300000;
    }

    public String toString() {
        int i = this.streamType;
        String str = 1 == i ? "MIXED" : 3 == i ? "DUAL VIDEO" : "DUAL AUDIO";
        int i2 = this.connectionType;
        String str2 = 256 == i2 ? "Local" : 16 == i2 ? "P2P" : "Relay";
        if (this.statistics != null) {
            str2 = str2.concat("\nstatistics : ").concat(this.statistics.toString());
        }
        String concat = "\n".concat(String.valueOf(this.deviceIdMD5)).concat("\nisLocal : ").concat(String.valueOf(this.isLocal)).concat("\nurl : ").concat(String.valueOf(this.url)).concat("\nstreamType : ").concat(str).concat("\nconnectionType : ").concat(str2).concat("\ncreateTime : ");
        return concat.concat("" + this.createTime).concat("\nencryptType : ").concat(String.valueOf(this.encryptType)).concat("\nrelayTime : ").concat(String.valueOf(this.relayTime)).concat("\nresolution : ").concat("\nport : ").concat(String.valueOf(this.port)).concat("\nportId : ").concat(String.valueOf(this.portId)).concat("\nmodel : ").concat(this.deviceModel.value());
    }
}
