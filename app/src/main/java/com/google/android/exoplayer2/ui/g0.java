package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.y;
import java.util.Locale;

/* compiled from: DefaultTrackNameProvider.java */
/* loaded from: classes.dex */
public class g0 implements z0 {
    private final Resources a;

    public g0(Resources resources) {
        this.a = (Resources) g.e(resources);
    }

    private String b(Format format) {
        int i = format.U3;
        if (i == -1 || i < 1) {
            return "";
        }
        if (i == 1) {
            return this.a.getString(r0.exo_track_mono);
        }
        if (i == 2) {
            return this.a.getString(r0.exo_track_stereo);
        }
        if (i == 6 || i == 7) {
            return this.a.getString(r0.exo_track_surround_5_point_1);
        }
        if (i != 8) {
            return this.a.getString(r0.exo_track_surround);
        }
        return this.a.getString(r0.exo_track_surround_7_point_1);
    }

    private String c(Format format) {
        int i = format.p0;
        return i == -1 ? "" : this.a.getString(r0.exo_track_bitrate, Float.valueOf(i / 1000000.0f));
    }

    private String d(Format format) {
        return TextUtils.isEmpty(format.f2005d) ? "" : format.f2005d;
    }

    private String e(Format format) {
        String j = j(f(format), h(format));
        return TextUtils.isEmpty(j) ? d(format) : j;
    }

    private String f(Format format) {
        String str = format.f2006f;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        return (o0.a >= 21 ? Locale.forLanguageTag(str) : new Locale(str)).getDisplayName();
    }

    private String g(Format format) {
        int i = format.M3;
        int i2 = format.N3;
        return (i == -1 || i2 == -1) ? "" : this.a.getString(r0.exo_track_resolution, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private String h(Format format) {
        String string = (format.x & 2) != 0 ? this.a.getString(r0.exo_track_role_alternate) : "";
        if ((format.x & 4) != 0) {
            string = j(string, this.a.getString(r0.exo_track_role_supplementary));
        }
        if ((format.x & 8) != 0) {
            string = j(string, this.a.getString(r0.exo_track_role_commentary));
        }
        return (format.x & 1088) != 0 ? j(string, this.a.getString(r0.exo_track_role_closed_captions)) : string;
    }

    private static int i(Format format) {
        int k = y.k(format.H3);
        if (k != -1) {
            return k;
        }
        if (y.n(format.p1) != null) {
            return 2;
        }
        if (y.c(format.p1) != null) {
            return 1;
        }
        if (format.M3 == -1 && format.N3 == -1) {
            return (format.U3 == -1 && format.V3 == -1) ? -1 : 1;
        }
        return 2;
    }

    private String j(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                str = TextUtils.isEmpty(str) ? str2 : this.a.getString(r0.exo_item_list, str, str2);
            }
        }
        return str;
    }

    @Override // com.google.android.exoplayer2.ui.z0
    public String a(Format format) {
        String str;
        int i = i(format);
        if (i == 2) {
            str = j(h(format), g(format), c(format));
        } else if (i == 1) {
            str = j(e(format), b(format), c(format));
        } else {
            str = e(format);
        }
        return str.length() == 0 ? this.a.getString(r0.exo_track_unknown) : str;
    }
}
