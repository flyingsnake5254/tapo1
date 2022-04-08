package com.tplink.iot.adapter.iothub;

import android.content.Context;
import com.tplink.iot.R;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkViewHolder;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: GuardModeAdapters.kt */
/* loaded from: classes2.dex */
public final class GuardModeAlarmVolumeAdapter extends SingleCheckMarkAdapter<a> {
    private static final List<a> g;
    public static final b h = new b(null);

    /* compiled from: GuardModeAdapters.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final EnumGuardModeAlarmVolume f5810b;

        public a(int i, EnumGuardModeAlarmVolume volume) {
            j.e(volume, "volume");
            this.a = i;
            this.f5810b = volume;
        }

        public final int a() {
            return this.a;
        }

        public final EnumGuardModeAlarmVolume b() {
            return this.f5810b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && j.a(this.f5810b, aVar.f5810b);
        }

        public int hashCode() {
            int i = this.a * 31;
            EnumGuardModeAlarmVolume enumGuardModeAlarmVolume = this.f5810b;
            return i + (enumGuardModeAlarmVolume != null ? enumGuardModeAlarmVolume.hashCode() : 0);
        }

        public String toString() {
            return "AlarmVolume(titleRes=" + this.a + ", volume=" + this.f5810b + ")";
        }
    }

    /* compiled from: GuardModeAdapters.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public final int a(EnumGuardModeAlarmVolume volume) {
            Object obj;
            boolean z;
            j.e(volume, "volume");
            Iterator it = GuardModeAlarmVolumeAdapter.g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((a) obj).b() == volume) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            a aVar = (a) obj;
            return aVar != null ? aVar.a() : R.string.voice_mute;
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    static {
        List<a> g2;
        g2 = n.g(new a(R.string.voice_mute, EnumGuardModeAlarmVolume.MUTE), new a(R.string.mode_sound_sensitive_low, EnumGuardModeAlarmVolume.LOW), new a(R.string.mode_sound_sensitive_normal, EnumGuardModeAlarmVolume.NORMAL), new a(R.string.mode_sound_sensitive_high, EnumGuardModeAlarmVolume.HIGH));
        g = g2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuardModeAlarmVolumeAdapter(Context context) {
        super(context, g, 0, 4, null);
        j.e(context, "context");
    }

    /* renamed from: B */
    public void n(SingleCheckMarkViewHolder holder, a data, int i) {
        j.e(holder, "holder");
        j.e(data, "data");
        holder.d().setText(data.a());
    }

    public final void C(EnumGuardModeAlarmVolume volume) {
        j.e(volume, "volume");
        Iterator<a> it = g.iterator();
        boolean z = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().b() == volume) {
                break;
            }
            i++;
        }
        Integer valueOf = Integer.valueOf(i);
        if (valueOf.intValue() != -1) {
            z = true;
        }
        if (!z) {
            valueOf = null;
        }
        if (valueOf != null) {
            z(valueOf.intValue());
        }
    }
}
