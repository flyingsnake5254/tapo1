package com.tplink.iot.adapter.smart;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkViewHolder;
import com.tplink.iot.model.smart.a;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: DeviceTriggerSingleChoiceAdapter.kt */
/* loaded from: classes2.dex */
public final class DeviceTriggerSingleChoiceAdapter extends SingleCheckMarkAdapter<a> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceTriggerSingleChoiceAdapter(Context context, List<a> itemList) {
        super(context, itemList, 0);
        j.e(context, "context");
        j.e(itemList, "itemList");
    }

    /* renamed from: A */
    public void n(SingleCheckMarkViewHolder holder, a data, int i) {
        j.e(holder, "holder");
        j.e(data, "data");
        holder.d().setText(data.e());
        TextView textView = (TextView) holder.e(R.id.tv_subtitle);
        if (textView != null) {
            String c2 = data.c();
            int i2 = 0;
            if (!(!(c2 == null || c2.length() == 0))) {
                i2 = 8;
            }
            textView.setVisibility(i2);
            String c3 = data.c();
            if (c3 == null) {
                c3 = "";
            }
            textView.setText(c3);
        }
        View view = holder.itemView;
        j.d(view, "holder.itemView");
        view.setEnabled(data.b());
        View view2 = holder.itemView;
        j.d(view2, "holder.itemView");
        view2.setAlpha(data.b() ? 1.0f : 0.5f);
    }

    public final void B(String id, Object obj) {
        j.e(id, "id");
        Iterator<a> it = q().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            a next = it.next();
            if (j.a(next.d(), id) && j.a(next.a(), obj)) {
                break;
            }
            i++;
        }
        if (i != -1) {
            z(i);
        }
    }

    @Override // com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter
    /* renamed from: w */
    public SingleCheckMarkViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        j.e(parent, "parent");
        View inflate = r().inflate(R.layout.item_single_check_mark_with_subtitle, parent, false);
        j.d(inflate, "mInflater.inflate(R.layo…_subtitle, parent, false)");
        return new SingleCheckMarkViewHolder(inflate);
    }
}
