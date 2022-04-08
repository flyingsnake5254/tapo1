package b.d.s.c;

import android.text.TextUtils;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.e;

/* compiled from: AppConstant.java */
/* loaded from: classes3.dex */
public class a {
    private static final String[] a;

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f714b;

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f715c;

    static {
        EnumDeviceType enumDeviceType = EnumDeviceType.PLUG;
        EnumDeviceType enumDeviceType2 = EnumDeviceType.BULB;
        EnumDeviceType enumDeviceType3 = EnumDeviceType.CAMERA;
        a = new String[]{enumDeviceType.getDeviceType(), enumDeviceType2.getDeviceType(), enumDeviceType3.getDeviceType()};
        f714b = new String[]{enumDeviceType.getDeviceType(), enumDeviceType2.getDeviceType(), enumDeviceType3.getDeviceType()};
        f715c = new String[]{enumDeviceType.getDeviceType(), enumDeviceType2.getDeviceType()};
    }

    public static String[] a() {
        return a;
    }

    public static String b() {
        String[] strArr = f714b;
        if (strArr.length == 0) {
            return null;
        }
        return e.b(strArr, SSLClient.COMMA);
    }

    public static String c(String... strArr) {
        if (strArr.length == 0) {
            return null;
        }
        return TextUtils.join(SSLClient.COMMA, strArr);
    }

    public static List<String> d() {
        return Arrays.asList(a);
    }

    public static List<String> e() {
        return Arrays.asList(f715c);
    }
}
