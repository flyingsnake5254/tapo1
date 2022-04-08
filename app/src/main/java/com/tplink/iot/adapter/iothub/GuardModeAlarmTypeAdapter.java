package com.tplink.iot.adapter.iothub;

import android.content.Context;
import androidx.annotation.StringRes;
import com.tplink.iot.R;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkViewHolder;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.text.v;
import kotlin.text.w;

/* compiled from: GuardModeAdapters.kt */
/* loaded from: classes2.dex */
public final class GuardModeAlarmTypeAdapter extends SingleCheckMarkAdapter<String> {
    public static final a g = new a(null);

    /* compiled from: GuardModeAdapters.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: GuardModeAdapters.kt */
        /* renamed from: com.tplink.iot.adapter.iothub.GuardModeAlarmTypeAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0194a extends Lambda implements p<String, Integer, String> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f5809c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0194a(String str) {
                super(2);
                this.f5809c = str;
            }

            public final String a(String prefix, @StringRes int i) {
                CharSequence t0;
                j.e(prefix, "prefix");
                String str = this.f5809c;
                int length = prefix.length();
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(length);
                j.d(substring, "(this as java.lang.String).substring(startIndex)");
                Objects.requireNonNull(substring, "null cannot be cast to non-null type kotlin.CharSequence");
                t0 = w.t0(substring);
                String string = AppContext.f6185c.getString(i, new Object[]{t0.toString()});
                j.d(string, "AppContext.instance.getString(resId, numStr)");
                return string;
            }

            @Override // kotlin.jvm.b.p
            public /* bridge */ /* synthetic */ String invoke(String str, Integer num) {
                return a(str, num.intValue());
            }
        }

        private a() {
        }

        public final String a(String rawName) {
            boolean A;
            boolean A2;
            boolean A3;
            j.e(rawName, "rawName");
            C0194a aVar = new C0194a(rawName);
            A = v.A(rawName, "Doorbell Ring", false, 2, null);
            if (A) {
                return aVar.a("Doorbell Ring", R.string.alarm_doorbell_ring);
            }
            A2 = v.A(rawName, "Alarm", false, 2, null);
            if (A2) {
                return aVar.a("Alarm", R.string.alarm_alarm);
            }
            A3 = v.A(rawName, "Connection", false, 2, null);
            if (A3) {
                return aVar.a("Connection", R.string.alarm_connection);
            }
            if (j.a(rawName, "Phone Ring")) {
                String string = AppContext.f6185c.getString(R.string.alarm_phone_ring);
                j.d(string, "AppContext.instance.getS….string.alarm_phone_ring)");
                return string;
            } else if (!j.a(rawName, "Dripping Tap")) {
                return rawName;
            } else {
                String string2 = AppContext.f6185c.getString(R.string.alarm_dripping_tap);
                j.d(string2, "AppContext.instance.getS…tring.alarm_dripping_tap)");
                return string2;
            }
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuardModeAlarmTypeAdapter(List<String> dataList, Context context) {
        super(context, dataList, 0, 4, null);
        j.e(dataList, "dataList");
        j.e(context, "context");
    }

    /* renamed from: A */
    public void n(SingleCheckMarkViewHolder holder, String data, int i) {
        j.e(holder, "holder");
        j.e(data, "data");
        holder.d().setText(g.a(data));
    }

    public final void B(String str) {
        if (str == null) {
            z(0);
        } else {
            z(q().indexOf(str));
        }
    }
}
