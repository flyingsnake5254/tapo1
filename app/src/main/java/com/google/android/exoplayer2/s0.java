package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.audio.p;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioFocusManager.java */
/* loaded from: classes.dex */
public final class s0 {
    private final AudioManager a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3130b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private b f3131c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private p f3132d;

    /* renamed from: f  reason: collision with root package name */
    private int f3134f;
    private AudioFocusRequest h;
    private boolean i;
    private float g = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private int f3133e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AudioFocusManager.java */
    /* loaded from: classes.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: c  reason: collision with root package name */
        private final Handler f3135c;

        public a(Handler handler) {
            this.f3135c = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(int i) {
            s0.this.h(i);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            this.f3135c.post(new Runnable() { // from class: com.google.android.exoplayer2.b
                @Override // java.lang.Runnable
                public final void run() {
                    s0.a.this.b(i);
                }
            });
        }
    }

    /* compiled from: AudioFocusManager.java */
    /* loaded from: classes.dex */
    public interface b {
        void A(int i);

        void z(float f2);
    }

    public s0(Context context, Handler handler, b bVar) {
        this.a = (AudioManager) g.e((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.f3131c = bVar;
        this.f3130b = new a(handler);
    }

    private void a() {
        this.a.abandonAudioFocus(this.f3130b);
    }

    private void b() {
        if (this.f3133e != 0) {
            if (o0.a >= 26) {
                c();
            } else {
                a();
            }
            n(0);
        }
    }

    @RequiresApi(26)
    private void c() {
        AudioFocusRequest audioFocusRequest = this.h;
        if (audioFocusRequest != null) {
            this.a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int e(@Nullable p pVar) {
        if (pVar == null) {
            return 0;
        }
        int i = pVar.f2110e;
        switch (i) {
            case 0:
                u.h("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                break;
            case 11:
                if (pVar.f2108c == 1) {
                    return 2;
                }
                break;
            case 15:
            default:
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unidentified audio usage: ");
                sb.append(i);
                u.h("AudioFocusManager", sb.toString());
                return 0;
            case 16:
                return o0.a >= 19 ? 4 : 2;
        }
        return 3;
    }

    private void f(int i) {
        b bVar = this.f3131c;
        if (bVar != null) {
            bVar.A(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i) {
        if (i == -3 || i == -2) {
            if (i == -2 || q()) {
                f(0);
                n(2);
                return;
            }
            n(3);
        } else if (i == -1) {
            f(-1);
            b();
        } else if (i != 1) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("Unknown focus change type: ");
            sb.append(i);
            u.h("AudioFocusManager", sb.toString());
        } else {
            n(1);
            f(1);
        }
    }

    private int j() {
        if (this.f3133e == 1) {
            return 1;
        }
        if ((o0.a >= 26 ? l() : k()) == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    private int k() {
        return this.a.requestAudioFocus(this.f3130b, o0.Y(((p) g.e(this.f3132d)).f2110e), this.f3134f);
    }

    @RequiresApi(26)
    private int l() {
        AudioFocusRequest.Builder builder;
        AudioFocusRequest audioFocusRequest = this.h;
        if (audioFocusRequest == null || this.i) {
            if (audioFocusRequest == null) {
                builder = new AudioFocusRequest.Builder(this.f3134f);
            } else {
                builder = new AudioFocusRequest.Builder(this.h);
            }
            this.h = builder.setAudioAttributes(((p) g.e(this.f3132d)).a()).setWillPauseWhenDucked(q()).setOnAudioFocusChangeListener(this.f3130b).build();
            this.i = false;
        }
        return this.a.requestAudioFocus(this.h);
    }

    private void n(int i) {
        if (this.f3133e != i) {
            this.f3133e = i;
            float f2 = i == 3 ? 0.2f : 1.0f;
            if (this.g != f2) {
                this.g = f2;
                b bVar = this.f3131c;
                if (bVar != null) {
                    bVar.z(f2);
                }
            }
        }
    }

    private boolean o(int i) {
        return i == 1 || this.f3134f != 1;
    }

    private boolean q() {
        p pVar = this.f3132d;
        return pVar != null && pVar.f2108c == 1;
    }

    public float g() {
        return this.g;
    }

    public void i() {
        this.f3131c = null;
        b();
    }

    public void m(@Nullable p pVar) {
        if (!o0.b(this.f3132d, pVar)) {
            this.f3132d = pVar;
            int e2 = e(pVar);
            this.f3134f = e2;
            boolean z = true;
            if (!(e2 == 1 || e2 == 0)) {
                z = false;
            }
            g.b(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        }
    }

    public int p(boolean z, int i) {
        if (o(i)) {
            b();
            return z ? 1 : -1;
        } else if (z) {
            return j();
        } else {
            return -1;
        }
    }
}
