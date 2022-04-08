package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.util.o0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: GaplessInfoHolder.java */
/* loaded from: classes.dex */
public final class u {
    private static final Pattern a = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: b  reason: collision with root package name */
    public int f3071b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f3072c = -1;

    private boolean b(String str) {
        Matcher matcher = a.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt((String) o0.i(matcher.group(1)), 16);
            int parseInt2 = Integer.parseInt((String) o0.i(matcher.group(2)), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f3071b = parseInt;
            this.f3072c = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.f3071b == -1 || this.f3072c == -1) ? false : true;
    }

    public boolean c(Metadata metadata) {
        for (int i = 0; i < metadata.d(); i++) {
            Metadata.Entry c2 = metadata.c(i);
            if (c2 instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) c2;
                if ("iTunSMPB".equals(commentFrame.f2565f) && b(commentFrame.q)) {
                    return true;
                }
            } else if (c2 instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) c2;
                if ("com.apple.iTunes".equals(internalFrame.f2569d) && "iTunSMPB".equals(internalFrame.f2570f) && b(internalFrame.q)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean d(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.f3071b = i2;
        this.f3072c = i3;
        return true;
    }
}
