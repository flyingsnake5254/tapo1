package com.tplink.iot.Utils.z0;

import com.tplink.iot.R;
import java.util.HashMap;
import kotlin.jvm.internal.f;

/* compiled from: ControlComponent.kt */
/* loaded from: classes2.dex */
public final class j {
    private static final HashMap<Integer, k> a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f5396b = new a(null);

    /* compiled from: ControlComponent.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final HashMap<Integer, k> a() {
            return j.a;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        HashMap<Integer, k> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put(0, new k(0, R.string.video_control_talk, R.drawable.talking, null, 8, null));
        hashMap.put(1, new k(1, R.string.video_control_voice_call, R.drawable.call, null, 8, null));
        hashMap.put(2, new k(2, R.string.video_control_tilt_control, R.drawable.control, null, 8, null));
        hashMap.put(3, new k(3, R.string.video_control_privacy_mode, R.drawable.obstruct, null, 8, null));
        hashMap.put(4, new k(4, R.string.camera_alarm_sound_siren, R.drawable.alarm, null, 8, null));
        hashMap.put(5, new k(5, R.string.video_control_playback_and_memory, R.drawable.memory, null, 8, null));
        hashMap.put(9, new k(9, R.string.tapo_care, R.mipmap.tapocare, null, 8, null));
    }
}
