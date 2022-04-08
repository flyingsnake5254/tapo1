package com.tplink.iot.adapter.iothub;

import android.content.Context;
import com.tplink.iot.R;
import com.tplink.iot.adapter.iothub.a;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import java.util.List;
import java.util.Map;
import kotlin.collections.e0;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.n;

/* compiled from: HubAlarmLogAdapter.kt */
/* loaded from: classes2.dex */
public final class HubAlarmLogAdapter extends GeneralAdapter<a> {

    /* renamed from: d  reason: collision with root package name */
    private final f f5811d;

    /* compiled from: HubAlarmLogAdapter.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<Map<EnumGuardMode, ? extends String>> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final Map<EnumGuardMode, String> invoke() {
            Map<EnumGuardMode, String> f2;
            f2 = e0.f(n.a(EnumGuardMode.HOME, HubAlarmLogAdapter.this.r().getString(R.string.camera_home_mode)), n.a(EnumGuardMode.AWAY, HubAlarmLogAdapter.this.r().getString(R.string.camera_away_mode)), n.a(EnumGuardMode.SLEEP, HubAlarmLogAdapter.this.r().getString(R.string.guard_sleep_mode)));
            return f2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubAlarmLogAdapter(Context context, List<a> dataList) {
        super(context, dataList);
        f b2;
        j.e(context, "context");
        j.e(dataList, "dataList");
        b2 = i.b(new a());
        this.f5811d = b2;
    }

    private final Map<EnumGuardMode, String> C() {
        return (Map) this.f5811d.getValue();
    }

    /* renamed from: B */
    public void m(GeneralAdapter.GeneralVH holder, a data, int i) {
        String str;
        j.e(holder, "holder");
        j.e(data, "data");
        String str2 = "";
        if (data.c()) {
            String a2 = data.a();
            if (a2 != null) {
                str2 = a2;
            }
            holder.d(R.id.date_text, str2);
            return;
        }
        a.b b2 = data.b();
        if (b2 != null) {
            holder.d(R.id.time_text, b2.c());
            String a3 = b2.a();
            if (!(a3.length() > 0)) {
                a3 = null;
            }
            if (a3 == null) {
                a3 = r().getString(R.string.common_unknown_device);
                j.d(a3, "mContext.getString(R.string.common_unknown_device)");
            }
            EnumGuardMode b3 = b2.b();
            if (!(b3 == null || (str = C().get(b3)) == null)) {
                str2 = str;
            }
            holder.d(R.id.content_text, r().getString(R.string.alarm_log_content, str2, a3));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return s().get(i).c() ? 1 : 2;
    }

    @Override // com.tplink.iot.devicecommon.adapter.GeneralAdapter
    public int p(int i) {
        return i == 1 ? R.layout.item_hub_alarm_log_date : R.layout.item_hub_alarm_log_content;
    }
}
