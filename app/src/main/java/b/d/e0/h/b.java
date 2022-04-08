package b.d.e0.h;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraConfigurationManager.java */
/* loaded from: classes3.dex */
public final class b {
    private static final String a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f400b = Pattern.compile(SSLClient.COMMA);

    /* renamed from: c  reason: collision with root package name */
    private final Context f401c;

    /* renamed from: d  reason: collision with root package name */
    private Point f402d;

    /* renamed from: e  reason: collision with root package name */
    private Point f403e;

    /* renamed from: f  reason: collision with root package name */
    private int f404f;
    private String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f401c = context;
    }

    private static int a(CharSequence charSequence, int i) {
        int i2 = 0;
        for (String str : f400b.split(charSequence)) {
            try {
                double parseDouble = Double.parseDouble(str.trim());
                i2 = (int) (10.0d * parseDouble);
                if (Math.abs(i - parseDouble) < Math.abs(i - i2)) {
                }
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i2;
    }

    private static Point b(CharSequence charSequence, Point point) {
        String[] split = f400b.split(charSequence);
        int length = split.length;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String trim = split[i2].trim();
            int indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                String str = a;
                Log.w(str, "Bad preview-size: " + trim);
            } else {
                try {
                    int parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    int parseInt2 = Integer.parseInt(trim.substring(indexOf + 1));
                    int abs = Math.abs(parseInt - point.x) + Math.abs(parseInt2 - point.y);
                    if (abs == 0) {
                        i4 = parseInt2;
                        i3 = parseInt;
                        break;
                    } else if (abs < i) {
                        i4 = parseInt2;
                        i = abs;
                        i3 = parseInt;
                    }
                } catch (NumberFormatException unused) {
                    String str2 = a;
                    Log.w(str2, "Bad preview-size: " + trim);
                }
            }
            i2++;
        }
        if (i3 <= 0 || i4 <= 0) {
            return null;
        }
        return new Point(i3, i4);
    }

    private static Point d(Camera.Parameters parameters, Point point) {
        String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        Point point2 = null;
        if (str != null) {
            String str2 = a;
            Log.d(str2, "preview-size-values parameter: " + str);
            point2 = b(str, point);
        }
        return point2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : point2;
    }

    private void j(Camera.Parameters parameters) {
        if (!Build.MODEL.contains("Behold II") || c.f408e != 3) {
            parameters.set("flash-value", 2);
        } else {
            parameters.set("flash-value", 1);
        }
        parameters.set("flash-mode", "off");
    }

    private void k(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int i = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                    String str3 = a;
                    Log.w(str3, "Bad max-zoom: " + str2);
                }
            }
            String str4 = parameters.get("taking-picture-zoom-max");
            if (str4 != null) {
                try {
                    int parseInt = Integer.parseInt(str4);
                    if (i > parseInt) {
                        i = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                    String str5 = a;
                    Log.w(str5, "Bad taking-picture-zoom-max: " + str4);
                }
            }
            String str6 = parameters.get("mot-zoom-values");
            if (str6 != null) {
                i = a(str6, i);
            }
            String str7 = parameters.get("mot-zoom-step");
            if (str7 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str7.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i -= i % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (!(str2 == null && str6 == null)) {
                parameters.set("zoom", String.valueOf(i / 10.0d));
            }
            if (str4 != null) {
                parameters.set("taking-picture-zoom", i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point c() {
        return this.f403e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f404f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point g() {
        return this.f402d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.f404f = parameters.getPreviewFormat();
        this.g = parameters.get("preview-format");
        String str = a;
        Log.d(str, "Default preview format: " + this.f404f + '/' + this.g);
        Display defaultDisplay = ((WindowManager) this.f401c.getSystemService("window")).getDefaultDisplay();
        this.f402d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        Log.d(str, "Screen resolution: " + this.f402d);
        Point point = new Point();
        Point point2 = this.f402d;
        point.x = point2.x;
        point.y = point2.y;
        int i = point2.x;
        int i2 = point2.y;
        if (i < i2) {
            point.x = i2;
            point.y = point2.x;
        }
        Log.i("#########", "screenX:" + point.x + "   screenY:" + point.y);
        this.f403e = d(parameters, point);
        StringBuilder sb = new StringBuilder();
        sb.append("Camera resolution: ");
        sb.append(this.f402d);
        Log.d(str, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        String str = a;
        Log.d(str, "Setting preview size: " + this.f403e);
        Point point = this.f403e;
        parameters.setPreviewSize(point.x, point.y);
        j(parameters);
        k(parameters);
        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);
    }
}
