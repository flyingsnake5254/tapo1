package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.provider.Settings;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.d;
import java.util.Arrays;

/* compiled from: AudioCapabilities.java */
/* loaded from: classes.dex */
public final class q {
    public static final q a = new q(new int[]{2}, 8);

    /* renamed from: b  reason: collision with root package name */
    private static final q f2115b = new q(new int[]{2, 5, 6}, 8);

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f2116c = {5, 6, 18, 17, 14, 7, 8};

    /* renamed from: d  reason: collision with root package name */
    private final int[] f2117d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2118e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AudioCapabilities.java */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static final class a {
        @DoNotInline
        public static int[] a() {
            int[] iArr;
            ImmutableList.a builder = ImmutableList.builder();
            for (int i : q.f2116c) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(i).setSampleRate(48000).build(), new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build())) {
                    builder.a(Integer.valueOf(i));
                }
            }
            builder.a(2);
            return d.j(builder.j());
        }
    }

    public q(@Nullable int[] iArr, int i) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f2117d = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f2117d = new int[0];
        }
        this.f2118e = i;
    }

    private static boolean b() {
        if (o0.a >= 17) {
            String str = o0.f3934c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static q c(Context context) {
        return d(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static q d(Context context, @Nullable Intent intent) {
        if (b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return f2115b;
        }
        if (o0.a >= 29 && o0.n0(context)) {
            return new q(a.a(), 8);
        }
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return a;
        }
        return new q(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }

    public int e() {
        return this.f2118e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return Arrays.equals(this.f2117d, qVar.f2117d) && this.f2118e == qVar.f2118e;
    }

    public boolean f(int i) {
        return Arrays.binarySearch(this.f2117d, i) >= 0;
    }

    public int hashCode() {
        return this.f2118e + (Arrays.hashCode(this.f2117d) * 31);
    }

    public String toString() {
        int i = this.f2118e;
        String arrays = Arrays.toString(this.f2117d);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
