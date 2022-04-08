package com.tplink.iot.k.a;

import android.graphics.Color;
import android.media.AudioRecord;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.tplink.iot.k.c.b;
import com.tplink.iot.musicphonerhythm.activitys.MusicPhoneRhythmFragment;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmGlobalConfigBean;
import com.tplink.iot.musicphonerhythm.bean.TUBPColorDbBean;
import com.tplink.iot.musicphonerhythm.bean.TUBPDataBean;
import com.tplink.iot.musicphonerhythm.jniInterface.MusicRhythmJni;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import java.net.InetSocketAddress;
import java.util.ArrayList;

/* compiled from: RecordThread.java */
/* loaded from: classes2.dex */
public class a extends Thread implements MusicPhoneRhythmFragment.h {

    /* renamed from: c  reason: collision with root package name */
    private static final int f8006c = AudioRecord.getMinBufferSize(16000, 16, 2);

    /* renamed from: d  reason: collision with root package name */
    private static final int f8007d = AudioRecord.getMinBufferSize(44000, 16, 2);

    /* renamed from: f  reason: collision with root package name */
    private static com.tplink.iot.k.c.a f8008f;
    private int I3;
    InetSocketAddress K3;
    int M3;
    private int p0;
    private boolean p1;
    private int p2;
    private int p3;
    private AudioRecord q;
    private com.tplink.iot.k.b.a y;
    private volatile boolean x = false;
    private Integer z = 0;
    private int H3 = -30;
    int J3 = 0;
    int L3 = 0;

    public a(String str, String str2, String str3, int i, MusicPhoneRhythmFragment musicPhoneRhythmFragment, MusicRhythmGlobalConfigBean musicRhythmGlobalConfigBean, int i2, int i3) {
        this.p0 = 100;
        this.p1 = false;
        this.p2 = 0;
        this.p3 = 0;
        this.I3 = 7;
        this.K3 = null;
        if (i2 == 1) {
            this.q = new AudioRecord(1, 16000, 2, 2, f8006c);
            this.M3 = 0;
        } else if (i2 == 2) {
            this.q = new AudioRecord(1, 44000, 2, 2, f8007d);
            this.M3 = 1;
        } else {
            this.q = new AudioRecord(1, 44000, 2, 2, f8007d);
        }
        f8008f = new com.tplink.iot.k.c.a(str, str2);
        this.K3 = new InetSocketAddress(str3, i);
        musicPhoneRhythmFragment.r1(this);
        boolean isSingleColorEnable = musicRhythmGlobalConfigBean.isSingleColorEnable();
        this.p1 = isSingleColorEnable;
        if (isSingleColorEnable) {
            this.p2 = musicRhythmGlobalConfigBean.getHue();
            this.p3 = musicRhythmGlobalConfigBean.getSaturation();
        }
        this.p0 = musicRhythmGlobalConfigBean.getBaseBrightness();
        this.I3 = i3;
    }

    private int d(float f2) {
        return Double.valueOf((f2 * 1.8d) + 190.0d).intValue();
    }

    private int e(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
        }
        return 50;
    }

    private int g(int i) {
        if (i != 0) {
            this.L3++;
        }
        switch (this.L3 % 8) {
            case 0:
                return Color.rgb(253, 255, 246);
            case 1:
                return Color.rgb(3, 255, 212);
            case 2:
                return Color.rgb(9, 116, 242);
            case 3:
                return Color.rgb(105, 253, 255);
            case 4:
                return Color.rgb(120, 101, 237);
            case 5:
                return Color.rgb((int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 222, 246);
            case 6:
                return Color.rgb(255, 60, 109);
            case 7:
                return Color.rgb(255, 135, 86);
            default:
                return 0;
        }
    }

    public static short h(byte[] bArr, int i) {
        return (short) ((bArr[i] & 255) | ((bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK));
    }

    @Override // com.tplink.iot.musicphonerhythm.activitys.MusicPhoneRhythmFragment.h
    public void a(int i) {
        if (i == 0) {
            this.p1 = false;
            return;
        }
        this.p1 = true;
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        this.p2 = (int) fArr[0];
        this.p3 = (int) (fArr[1] * 100.0f);
        b.d.w.c.a.c("onSaveColorModeChange", "onSaveColorMode" + this.p2 + "  " + this.p3);
    }

    @Override // com.tplink.iot.musicphonerhythm.activitys.MusicPhoneRhythmFragment.h
    public void b(int i) {
        this.H3 = b.f(i).getValue()[1];
    }

    @Override // com.tplink.iot.musicphonerhythm.activitys.MusicPhoneRhythmFragment.h
    public void c(int i) {
        b.d.w.c.a.c("onSaveLightPercentModeChange", "onSaveLightPercentMode=" + i);
        this.p0 = i;
    }

    public int f(int i, float f2) {
        if (f2 < -90.0f) {
            return Color.rgb(0, 0, 255);
        }
        switch (i) {
            case 0:
                return Color.rgb(255, 0, 0);
            case 1:
                return Color.rgb(144, 0, 255);
            case 2:
                return Color.rgb(255, 255, 0);
            case 3:
                return Color.rgb(183, 70, 139);
            case 4:
                return Color.rgb(195, 242, 255);
            case 5:
                return Color.rgb(171, 0, 52);
            case 6:
                return Color.rgb(127, 139, 253);
            case 7:
                return Color.rgb(255, 127, 0);
            case 8:
                return Color.rgb(187, 117, 252);
            case 9:
                return Color.rgb(51, 204, 51);
            case 10:
                return Color.rgb(168, 103, 124);
            case 11:
                return Color.rgb(142, 201, 255);
            default:
                return 0;
        }
    }

    public void i() {
        this.x = false;
    }

    public void j(byte[] bArr) {
        float[] fArr = new float[1024];
        short[] sArr = new short[1024];
        for (int i = 0; i < 1024; i++) {
            sArr[i] = h(bArr, i * 2);
        }
        for (int i2 = 0; i2 < 1024; i2++) {
            fArr[i2] = (float) (sArr[i2] / Math.pow(2.0d, 15.0d));
        }
        float[] audioResult = MusicRhythmJni.getAudioResult(fArr, this.M3, this.I3);
        int i3 = (int) audioResult[0];
        float f2 = audioResult[1];
        int f3 = f(i3, f2);
        int d2 = d(f2);
        b.d.w.c.a.c("getData v1.0", "线程为 " + getId() + "频率： " + i3 + "Hz 能量： " + f2 + "dB颜色： " + f3);
        float[] fArr2 = new float[3];
        Color.colorToHSV(f3, fArr2);
        int i4 = (int) fArr2[0];
        int i5 = (int) (fArr2[1] * 100.0f);
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (this.p1) {
            arrayList.add(Integer.valueOf(this.p2));
            arrayList.add(Integer.valueOf(this.p3));
        } else {
            arrayList.add(Integer.valueOf(i4));
            arrayList.add(Integer.valueOf(i5));
        }
        int i6 = 100;
        int i7 = (d2 * this.p0) / 100;
        if (i7 < 1) {
            i6 = 1;
        } else if (i7 <= 100) {
            i6 = i7;
        }
        arrayList.add(Integer.valueOf(i6));
        arrayList.add(this.z);
        TUBPColorDbBean tUBPColorDbBean = new TUBPColorDbBean();
        tUBPColorDbBean.setColorState(arrayList);
        tUBPColorDbBean.setDeltaDb((int) (f2 - this.H3));
        String b2 = f8008f.b(JsonUtils.g(new TUBPDataBean("play_music_rhythm", tUBPColorDbBean)));
        this.y.a(this.J3, b2);
        b.d.w.c.a.c("getData", "handleTDPSend=decrypt=" + f8008f.a(b2));
        this.J3 = this.J3 + 1;
    }

    public void k(byte[] bArr) {
        float[] fArr = new float[1024];
        short[] sArr = new short[1024];
        for (int i = 0; i < 1024; i++) {
            sArr[i] = h(bArr, i * 2);
        }
        for (int i2 = 0; i2 < 1024; i2++) {
            fArr[i2] = (float) (sArr[i2] / Math.pow(2.0d, 15.0d));
        }
        float[] audioResult = MusicRhythmJni.getAudioResult(fArr, this.M3, this.I3);
        int i3 = (int) audioResult[0];
        int i4 = (int) audioResult[1];
        int g = g(i3);
        int e2 = e(i4);
        float[] fArr2 = new float[3];
        Color.colorToHSV(g, fArr2);
        int i5 = (int) fArr2[0];
        int i6 = (int) (fArr2[1] * 100.0f);
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (this.p1) {
            arrayList.add(Integer.valueOf(this.p2));
            arrayList.add(Integer.valueOf(this.p3));
        } else {
            arrayList.add(Integer.valueOf(i5));
            arrayList.add(Integer.valueOf(i6));
        }
        int i7 = (e2 * this.p0) / 100;
        if (i7 < 1) {
            i7 = 1;
        } else if (i7 > 100) {
            i7 = 100;
        }
        arrayList.add(Integer.valueOf(i7));
        arrayList.add(this.z);
        TUBPColorDbBean tUBPColorDbBean = new TUBPColorDbBean();
        tUBPColorDbBean.setColorState(arrayList);
        tUBPColorDbBean.setDeltaDb(100);
        String b2 = f8008f.b(JsonUtils.g(new TUBPDataBean("play_music_rhythm", tUBPColorDbBean)));
        if (i4 != 0) {
            b.d.w.c.a.c("getData v1.1", "线程为 " + getId() + "亮灭=： " + i4 + " 换色= ： " + i3 + "  颜色： " + g);
            this.y.a(this.J3, b2);
            StringBuilder sb = new StringBuilder();
            sb.append("handleTDPSend=decrypt=");
            sb.append(f8008f.a(b2));
            b.d.w.c.a.c("getData", sb.toString());
        }
        this.J3++;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        this.y = new com.tplink.iot.k.b.a(this.K3);
        MusicRhythmJni.init(this.M3);
        b.d.w.c.a.c("spl", "初始化");
        boolean q = b.q();
        b.d.w.c.a.c("spl", "初始化 Availability=" + q);
        if (!q || this.q.getState() != 1) {
            this.x = false;
            b.d.w.c.a.c("spl", "初始化 麦克风用不了！！！");
        } else {
            this.q.startRecording();
            this.x = true;
            this.y.b();
        }
        byte[] bArr = new byte[2048];
        int i = this.M3;
        if (i == 0) {
            while (this.x) {
                if (this.q.read(bArr, 0, 2048) == 2048) {
                    j(bArr);
                }
            }
        } else if (i == 1) {
            while (this.x) {
                if (this.q.read(bArr, 0, 2048) == 2048) {
                    k(bArr);
                }
            }
        }
        this.q.stop();
    }

    @Override // java.lang.Thread
    public void start() {
        if (!this.x) {
            super.start();
        }
    }
}
