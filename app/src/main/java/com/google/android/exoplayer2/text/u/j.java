package com.google.android.exoplayer2.text.u;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WebvttParserUtil.java */
/* loaded from: classes.dex */
public final class j {
    private static final Pattern a = Pattern.compile("^NOTE([ \t].*)?$");

    @Nullable
    public static Matcher a(d0 d0Var) {
        String p;
        while (true) {
            String p2 = d0Var.p();
            if (p2 == null) {
                return null;
            }
            if (a.matcher(p2).matches()) {
                do {
                    p = d0Var.p();
                    if (p != null) {
                    }
                } while (!p.isEmpty());
            } else {
                Matcher matcher = h.a.matcher(p2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(d0 d0Var) {
        String p = d0Var.p();
        return p != null && p.startsWith("WEBVTT");
    }

    public static float c(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) throws NumberFormatException {
        String[] F0 = o0.F0(str, "\\.");
        long j = 0;
        for (String str2 : o0.E0(F0[0], SSLClient.COLON)) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (F0.length == 2) {
            j2 += Long.parseLong(F0[1]);
        }
        return j2 * 1000;
    }

    public static void e(d0 d0Var) throws ParserException {
        int e2 = d0Var.e();
        if (!b(d0Var)) {
            d0Var.P(e2);
            String valueOf = String.valueOf(d0Var.p());
            throw ParserException.createForMalformedContainer(valueOf.length() != 0 ? "Expected WEBVTT. Got ".concat(valueOf) : new String("Expected WEBVTT. Got "), null);
        }
    }
}
