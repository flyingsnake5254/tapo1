package com.tplink.iot.k.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.media.AudioRecord;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.d;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.TPLongThreeMaterialDialog;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.b0;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmGlobalConfigBean;
import com.tplink.iot.musicphonerhythm.enumerate.Sensitivity;
import com.tplink.iot.musicphonerhythm.enumerate.SpeedGap;
import com.tplink.iot.musicphonerhythm.views.MusicRhymeFirstShowGuideDialog;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.view.feedback.HelpAndFeedbackActivity;
import java.util.ArrayList;

/* compiled from: MusicRhythmUtil.java */
/* loaded from: classes2.dex */
public class b {

    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    static class a implements TPMaterialDialogV2.d {
        a() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
        }
    }

    /* compiled from: MusicRhythmUtil.java */
    /* renamed from: com.tplink.iot.k.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0213b implements TPMaterialDialogV2.d {
        final /* synthetic */ p a;

        C0213b(p pVar) {
            this.a = pVar;
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            this.a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public static class c implements TPMaterialDialogV2.d {
        c() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public static class d implements TPMaterialDialogV2.d {
        final /* synthetic */ q a;

        d(q qVar) {
            this.a = qVar;
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            this.a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public static class e implements com.airbnb.lottie.j {
        final /* synthetic */ LottieAnimationView a;

        /* compiled from: MusicRhythmUtil.java */
        /* loaded from: classes2.dex */
        class a implements com.airbnb.lottie.w.e<Integer[]> {
            a() {
            }

            /* renamed from: b */
            public Integer[] a(com.airbnb.lottie.w.b<Integer[]> bVar) {
                return new Integer[]{Integer.valueOf(Color.argb(153, 219, 27, 255)), Integer.valueOf(Color.argb(255, 237, 139, 255))};
            }
        }

        /* compiled from: MusicRhythmUtil.java */
        /* renamed from: com.tplink.iot.k.c.b$e$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0214b implements com.airbnb.lottie.w.e<Integer[]> {
            C0214b() {
            }

            /* renamed from: b */
            public Integer[] a(com.airbnb.lottie.w.b<Integer[]> bVar) {
                return new Integer[]{Integer.valueOf(Color.argb(127, 245, 151, 163)), Integer.valueOf(Color.argb(219, (int) ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 202, 208))};
            }
        }

        /* compiled from: MusicRhythmUtil.java */
        /* loaded from: classes2.dex */
        class c implements com.airbnb.lottie.w.e<Integer[]> {
            c() {
            }

            /* renamed from: b */
            public Integer[] a(com.airbnb.lottie.w.b<Integer[]> bVar) {
                return new Integer[]{Integer.valueOf(Color.argb(173, 62, 210, 242)), Integer.valueOf(Color.argb(255, 70, 224, 255))};
            }
        }

        /* compiled from: MusicRhythmUtil.java */
        /* loaded from: classes2.dex */
        class d implements com.airbnb.lottie.w.e<Integer[]> {
            d() {
            }

            /* renamed from: b */
            public Integer[] a(com.airbnb.lottie.w.b<Integer[]> bVar) {
                return new Integer[]{Integer.valueOf(Color.argb(173, 62, 210, 242)), Integer.valueOf(Color.argb(255, 70, 224, 255))};
            }
        }

        e(LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        @Override // com.airbnb.lottie.j
        @SuppressLint({"RestrictedApi"})
        public void a(com.airbnb.lottie.d dVar) {
            for (com.airbnb.lottie.model.d dVar2 : this.a.p(new com.airbnb.lottie.model.d("**"))) {
                b.d.w.c.a.c("mirror", dVar2.g());
                if (dVar2.h("矩形备份 2", 1) || dVar2.h("矩形备份 5", 1) || dVar2.h("矩形备份 8", 1) || dVar2.h("矩形备份 11", 1) || dVar2.h("矩形备份 14", 1) || dVar2.h("矩形备份 17", 1) || dVar2.h("矩形备份 20", 1)) {
                    this.a.f(dVar2, com.airbnb.lottie.k.D, new a());
                } else if (dVar2.h("矩形备份 3", 1) || dVar2.h("矩形备份 6", 1) || dVar2.h("矩形备份 9", 1) || dVar2.h("矩形备份 12", 1) || dVar2.h("矩形备份 15", 1) || dVar2.h("矩形备份 18", 1) || dVar2.h("矩形备份 21", 1)) {
                    this.a.f(dVar2, com.airbnb.lottie.k.D, new C0214b());
                } else if (dVar2.h("矩形备份 4", 1) || dVar2.h("矩形备份 7", 1) || dVar2.h("矩形备份 10", 1) || dVar2.h("矩形备份 13", 1) || dVar2.h("矩形备份 16", 1) || dVar2.h("矩形备份 19", 1)) {
                    this.a.f(dVar2, com.airbnb.lottie.k.D, new c());
                } else {
                    this.a.f(dVar2, com.airbnb.lottie.k.D, new d());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public static class f implements TPMaterialDialogV2.d {
        final /* synthetic */ TPMaterialDialogV2 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f8017b;

        f(TPMaterialDialogV2 tPMaterialDialogV2, o oVar) {
            this.a = tPMaterialDialogV2;
            this.f8017b = oVar;
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            this.a.dismiss();
            this.f8017b.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public static class g implements TPMaterialDialogV2.d {
        final /* synthetic */ o a;

        g(o oVar) {
            this.a = oVar;
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            this.a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public static class h implements TPLongThreeMaterialDialog.e {
        final /* synthetic */ TPLongThreeMaterialDialog a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f8018b;

        h(TPLongThreeMaterialDialog tPLongThreeMaterialDialog, o oVar) {
            this.a = tPLongThreeMaterialDialog;
            this.f8018b = oVar;
        }

        @Override // com.tplink.iot.Utils.TPLongThreeMaterialDialog.e
        public void onClick(View view) {
            this.a.dismiss();
            this.f8018b.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public static class i implements TPLongThreeMaterialDialog.e {
        final /* synthetic */ o a;

        i(o oVar) {
            this.a = oVar;
        }

        @Override // com.tplink.iot.Utils.TPLongThreeMaterialDialog.e
        public void onClick(View view) {
            this.a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public static class j implements TPLongThreeMaterialDialog.e {
        final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f8019b;

        j(Activity activity, o oVar) {
            this.a = activity;
            this.f8019b = oVar;
        }

        @Override // com.tplink.iot.Utils.TPLongThreeMaterialDialog.e
        public void onClick(View view) {
            Activity activity = this.a;
            HelpAndFeedbackActivity.m1(activity, "https://www.tapo.com/app/#/faqDetail/122?locale=" + com.tplink.iot.model.about.d.f(), b0.a(R.string.iot_light_strips), EnumFeedbackCategory.LIGHT_STRIP);
            this.f8019b.cancel();
        }
    }

    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    static class k implements TPLongMaterialDialogV2.d {
        final /* synthetic */ TPLongMaterialDialogV2 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f8020b;

        k(TPLongMaterialDialogV2 tPLongMaterialDialogV2, Activity activity) {
            this.a = tPLongMaterialDialogV2;
            this.f8020b = activity;
        }

        @Override // com.tplink.iot.Utils.TPLongMaterialDialogV2.d
        public void onClick(View view) {
            this.a.dismiss();
            this.f8020b.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public static class l implements TPLongMaterialDialogV2.d {
        final /* synthetic */ TPLongMaterialDialogV2 a;

        l(TPLongMaterialDialogV2 tPLongMaterialDialogV2) {
            this.a = tPLongMaterialDialogV2;
        }

        @Override // com.tplink.iot.Utils.TPLongMaterialDialogV2.d
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    static class m implements TPLongMaterialDialogV2.d {
        final /* synthetic */ TPLongMaterialDialogV2 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f8021b;

        m(TPLongMaterialDialogV2 tPLongMaterialDialogV2, Activity activity) {
            this.a = tPLongMaterialDialogV2;
            this.f8021b = activity;
        }

        @Override // com.tplink.iot.Utils.TPLongMaterialDialogV2.d
        public void onClick(View view) {
            this.a.dismiss();
            this.f8021b.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public static class n implements TPLongMaterialDialogV2.d {
        final /* synthetic */ TPLongMaterialDialogV2 a;

        n(TPLongMaterialDialogV2 tPLongMaterialDialogV2) {
            this.a = tPLongMaterialDialogV2;
        }

        @Override // com.tplink.iot.Utils.TPLongMaterialDialogV2.d
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public interface o {
        void a();

        void cancel();
    }

    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public interface p {
        void a();
    }

    /* compiled from: MusicRhythmUtil.java */
    /* loaded from: classes2.dex */
    public interface q {
        void a();
    }

    public static ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("single_lamp");
        return arrayList;
    }

    public static MusicRhythmGlobalConfigBean b() {
        return new MusicRhythmGlobalConfigBean(false, 280, 0, 100);
    }

    private static String c(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1731972241:
                if (str.equals("single_lamp")) {
                    c2 = 0;
                    break;
                }
                break;
            case -208977225:
                if (str.equals("light_flow")) {
                    c2 = 1;
                    break;
                }
                break;
            case 440747165:
                if (str.equals("power_mode")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return "music_rhythm_single_lamp_mode.json";
            case 1:
                return "music_rhythm_flowing_beam_mode.json";
            case 2:
                return "music_rhythm_power_mode.json";
            default:
                return null;
        }
    }

    public static ArrayList<String> d() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("single_lamp");
        return arrayList;
    }

    public static String e(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1731972241:
                if (str.equals("single_lamp")) {
                    c2 = 0;
                    break;
                }
                break;
            case -208977225:
                if (str.equals("light_flow")) {
                    c2 = 1;
                    break;
                }
                break;
            case 440747165:
                if (str.equals("power_mode")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return b0.a(R.string.music_rhythm_chameleon_control);
            case 1:
                return b0.a(R.string.music_rhythm_flowing_beam);
            case 2:
                return b0.a(R.string.music_rhythm_powerful_pulse);
            default:
                return b0.a(R.string.music_rhythm_chameleon_control);
        }
    }

    public static Sensitivity f(int i2) {
        if (i2 == 0) {
            return Sensitivity.LESS_SENSITIVE;
        }
        if (i2 == 1) {
            return Sensitivity.LITTLE_SENSITIVE;
        }
        if (i2 == 2) {
            return Sensitivity.NORMAL_SENSITIVE;
        }
        if (i2 == 3) {
            return Sensitivity.SENSITIVE;
        }
        if (i2 != 4) {
            return Sensitivity.NORMAL_SENSITIVE;
        }
        return Sensitivity.VERY_SENSITIVE;
    }

    public static SpeedGap g(int i2) {
        if (i2 == 0) {
            return SpeedGap.VERY_SLOW;
        }
        if (i2 == 1) {
            return SpeedGap.SLOW;
        }
        if (i2 == 2) {
            return SpeedGap.NORMAL_SPEED;
        }
        if (i2 == 3) {
            return SpeedGap.FAST;
        }
        if (i2 != 4) {
            return SpeedGap.NORMAL_SPEED;
        }
        return SpeedGap.VERY_FAST;
    }

    public static void h(Activity activity, int i2, o oVar) {
        if (activity != null) {
            if (i2 < 2) {
                TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(activity);
                TPMaterialDialogV2 a2 = builder.create();
                builder.j(activity.getApplicationContext().getString(R.string.music_rhythm_not_in_same_wlan)).o(R.string.common_retry, R.color.common_iot_main_blue, new g(oVar)).m(R.string.common_cancel, new f(a2, oVar)).g(8, 0).setCancelable(false).c(false).create();
                a2.show();
                return;
            }
            TPLongThreeMaterialDialog.Builder builder2 = new TPLongThreeMaterialDialog.Builder(activity);
            TPLongThreeMaterialDialog a3 = builder2.create();
            builder2.setMessage(R.string.music_rhythm_more_troubleshooting_message).k(R.string.music_rhythm_more_troubleshooting_button, R.color.common_iot_main_blue, new j(activity, oVar)).m(R.string.common_retry, R.color.common_iot_main_blue, new i(oVar)).i(R.string.common_cancel, new h(a3, oVar)).d(8, 0).setCancelable(false).c(false).create();
            a3.show();
        }
    }

    public static void i(Activity activity, p pVar) {
        if (activity != null) {
            new TPMaterialDialogV2.Builder(activity).setMessage(R.string.music_rhythm_double_check_quit_notice).l(R.string.common_leave, R.color.common_grey, new C0213b(pVar)).o(R.string.camera_alarm_stay, R.color.common_iot_main_blue, new a()).g(8, 8).setCancelable(false).c(false).create().show();
        }
    }

    public static void j(FragmentManager fragmentManager) {
        MusicRhymeFirstShowGuideDialog.G0().show(fragmentManager, MusicRhymeFirstShowGuideDialog.f8265c);
    }

    public static void k(Activity activity) {
        if (activity != null) {
            TPLongMaterialDialogV2.Builder builder = new TPLongMaterialDialogV2.Builder(activity);
            TPLongMaterialDialogV2 a2 = builder.create();
            builder.g(activity.getApplicationContext().getString(R.string.music_rhythm_others_stop)).l(R.string.common_ok, R.color.common_iot_main_blue, new m(a2, activity)).d(8, 0).setCancelable(false).c(false).create();
            if (!a2.isShowing()) {
                a2.show();
            }
        }
    }

    public static void l(Activity activity) {
        if (activity != null) {
            TPLongMaterialDialogV2.Builder builder = new TPLongMaterialDialogV2.Builder(activity);
            TPLongMaterialDialogV2 a2 = builder.create();
            builder.g(activity.getApplicationContext().getString(R.string.music_rhythm_not_in_same_wlan)).l(R.string.common_ok, R.color.common_iot_main_blue, new k(a2, activity)).d(8, 0).setCancelable(false).c(false).create();
            if (!a2.isShowing()) {
                a2.show();
            }
        }
    }

    public static void m(Activity activity) {
        if (activity != null) {
            TPLongMaterialDialogV2.Builder builder = new TPLongMaterialDialogV2.Builder(activity);
            TPLongMaterialDialogV2 a2 = builder.create();
            builder.g(activity.getApplicationContext().getString(R.string.lightstrip_detail_music_rhythm_note)).l(R.string.common_ok, R.color.common_iot_main_blue, new l(a2)).d(8, 0).setCancelable(false).c(false).create();
            if (!a2.isShowing()) {
                a2.show();
            }
        }
    }

    public static void n(Activity activity, q qVar) {
        if (activity != null) {
            new TPMaterialDialogV2.Builder(activity).setMessage(R.string.music_rhythm_others_stop_note).l(R.string.smart_action_device_turn_off, R.color.common_grey, new d(qVar)).o(R.string.common_cancel, R.color.common_iot_main_blue, new c()).g(8, 8).setCancelable(false).c(false).create().show();
        }
    }

    public static void o(Activity activity) {
        if (activity != null) {
            TPLongMaterialDialogV2.Builder builder = new TPLongMaterialDialogV2.Builder(activity);
            TPLongMaterialDialogV2 a2 = builder.create();
            builder.g(activity.getApplicationContext().getString(R.string.music_rhythm_is_user_device)).l(R.string.common_ok, R.color.common_iot_main_blue, new n(a2)).d(8, 0).setCancelable(false).c(false).create();
            a2.show();
        }
    }

    public static void p(LottieAnimationView lottieAnimationView, String str) {
        try {
            lottieAnimationView.setImageAssetsFolder("images/");
            com.airbnb.lottie.d a2 = d.a.a(lottieAnimationView.getContext(), c(str));
            lottieAnimationView.g();
            lottieAnimationView.setProgress(0.0f);
            if (a2 != null) {
                lottieAnimationView.setComposition(a2);
            }
            lottieAnimationView.o();
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.d(new e(lottieAnimationView));
        } catch (Exception unused) {
            Log.e("lottie", "load local lottie anim error");
        }
    }

    public static boolean q() {
        AudioRecord audioRecord = new AudioRecord(1, 44100, 16, 1, 44100);
        boolean z = false;
        try {
            z = audioRecord.getRecordingState() == 1;
            if (audioRecord.getState() == 1) {
                audioRecord.startRecording();
                if (audioRecord.getRecordingState() != 3) {
                    audioRecord.stop();
                    z = false;
                }
                audioRecord.stop();
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            audioRecord.release();
            throw th;
        }
        audioRecord.release();
        return z;
    }
}
