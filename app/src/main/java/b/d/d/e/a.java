package b.d.d.e;

import b.d.d.d.c;
import b.d.p.d;
import b.d.p.e.b;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import java.util.HashMap;

/* compiled from: DisplayMediaUtils.java */
/* loaded from: classes3.dex */
public class a {
    private static final String a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, BitStreamType> f187b = new HashMap<>();

    public static void a(String str, b<BitStreamType> bVar) {
        HashMap<String, BitStreamType> hashMap = f187b;
        BitStreamType bitStreamType = hashMap.get(str);
        if (bitStreamType != null) {
            String str2 = a;
            d.a(str2, "use last display resolution:" + bitStreamType);
            bVar.a(bitStreamType);
        } else if (!c.i(str)) {
            String str3 = a;
            StringBuilder sb = new StringBuilder();
            sb.append("remote device, default resolution:");
            BitStreamType bitStreamType2 = BitStreamType.MINOR_VGA;
            sb.append(bitStreamType2);
            d.a(str3, sb.toString());
            hashMap.put(str, bitStreamType2);
            bVar.a(bitStreamType2);
        } else {
            BitStreamType a2 = b.d.d.l.a.a(str);
            if (a2 == null) {
                a2 = BitStreamType.MAIN_HD;
                String str4 = a;
                d.a(str4, "local device, default resolution:" + a2);
            }
            hashMap.put(str, a2);
            bVar.a(a2);
        }
    }

    public static BitStreamType b(String str) {
        if (c.c(str) == null) {
            return BitStreamType.MINOR_VGA;
        }
        return !c.i(str) ? BitStreamType.MINOR_VGA : BitStreamType.MAIN_HD;
    }

    public static void c(String str, BitStreamType bitStreamType) {
        f187b.put(str, bitStreamType);
        if (c.i(str)) {
            b.d.d.l.a.b(str, bitStreamType);
        }
    }
}
