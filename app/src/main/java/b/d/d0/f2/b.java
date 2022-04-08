package b.d.d0.f2;

import com.tplink.tmp.exception.TPGeneralNetworkException;

/* compiled from: NetworkErrorTransfer.java */
/* loaded from: classes3.dex */
public class b {
    public static b.d.d0.i2.b a(byte b2) {
        if (b2 == 0) {
            return new b.d.d0.i2.b(0);
        }
        switch (b2) {
            case 2:
                return new b.d.d0.i2.b(-1222);
            case 3:
                return new b.d.d0.i2.b(-1223);
            case 4:
                return new b.d.d0.i2.b(-1224);
            case 5:
                return new b.d.d0.i2.b(-1225);
            case 6:
                return new b.d.d0.i2.b(-1226);
            case 7:
                return new b.d.d0.i2.b(-1227);
            case 8:
                return new b.d.d0.i2.b(-1228);
            case 9:
                return new b.d.d0.i2.b(-1229);
            case 10:
                return new b.d.d0.i2.b(-1230);
            case 11:
                return new b.d.d0.i2.b(-1231);
            case 12:
                return new b.d.d0.i2.b(-1232);
            default:
                return new b.d.d0.i2.b(-1);
        }
    }

    public static TPGeneralNetworkException b(byte b2) {
        if (b2 == 7) {
            return new TPGeneralNetworkException(-1236);
        }
        if (b2 == 8) {
            return new TPGeneralNetworkException(-1237);
        }
        if (b2 == 16) {
            return new TPGeneralNetworkException(-1238);
        }
        if (b2 != 17) {
            return new TPGeneralNetworkException(-1239);
        }
        return new TPGeneralNetworkException(-1240);
    }

    public static TPGeneralNetworkException c(byte b2) {
        if (b2 == 0) {
            return new TPGeneralNetworkException(-1204);
        }
        if (b2 == 2) {
            return new TPGeneralNetworkException(-1206);
        }
        if (b2 == 3) {
            return new TPGeneralNetworkException(-1207);
        }
        if (b2 == 4) {
            return new TPGeneralNetworkException(-1208);
        }
        if (b2 == 5) {
            return new TPGeneralNetworkException(-1209);
        }
        if (b2 != 6) {
            return new TPGeneralNetworkException(-1205);
        }
        return new TPGeneralNetworkException(-1210);
    }
}
