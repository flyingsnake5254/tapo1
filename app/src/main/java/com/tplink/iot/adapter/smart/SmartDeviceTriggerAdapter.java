package com.tplink.iot.adapter.smart;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.Utils.z0.n;
import com.tplink.iot.adapter.smart.SmartDeviceTriggerAdapter;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.model.smart.h;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class SmartDeviceTriggerAdapter extends RecyclerView.Adapter {
    private List<h> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Context f5981b;

    /* renamed from: c  reason: collision with root package name */
    private b f5982c;

    /* loaded from: classes2.dex */
    private abstract class a extends RecyclerView.ViewHolder {
        a(View view) {
            super(view);
        }

        public abstract void c(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void l0(ThingInfo thingInfo);
    }

    /* loaded from: classes2.dex */
    private class c extends a {

        /* renamed from: b  reason: collision with root package name */
        private RelativeLayout f5983b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f5984c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f5985d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f5986e;

        /* renamed from: f  reason: collision with root package name */
        private View f5987f;

        c(View view) {
            super(view);
            this.f5983b = (RelativeLayout) view.findViewById(R.id.rl_smart_settings);
            this.f5984c = (ImageView) view.findViewById(R.id.iv_item_icon);
            this.f5985d = (TextView) view.findViewById(R.id.item_title_hint);
            this.f5986e = (TextView) view.findViewById(R.id.item_info);
            this.f5987f = view.findViewById(R.id.bottom_divider);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void e(BaseALIoTDevice baseALIoTDevice, View view) {
            if (SmartDeviceTriggerAdapter.this.f5982c != null && baseALIoTDevice != null && baseALIoTDevice.getThingDevice() != null) {
                SmartDeviceTriggerAdapter.this.f5982c.l0(baseALIoTDevice.getThingDevice().getThingInfo());
            }
        }

        private void f(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f5986e.setText(str);
                this.f5986e.setVisibility(0);
                return;
            }
            this.f5986e.setText("");
            this.f5986e.setVisibility(8);
        }

        @Override // com.tplink.iot.adapter.smart.SmartDeviceTriggerAdapter.a
        public void c(int i) {
            final BaseALIoTDevice a = ((h) SmartDeviceTriggerAdapter.this.a.get(i)).a();
            if (a != null) {
                this.f5985d.setText(l.e(SmartDeviceTriggerAdapter.this.f5981b, a.getDeviceType(), a.getDeviceName(), a.getDeviceModel()));
                l.o(SmartDeviceTriggerAdapter.this.f5981b, a, this.f5984c);
                f(l.b(SmartDeviceTriggerAdapter.this.f5981b, a));
            }
            int i2 = i + 1;
            this.f5987f.setVisibility((i2 >= SmartDeviceTriggerAdapter.this.a.size() || ((h) SmartDeviceTriggerAdapter.this.a.get(i2)).c() != 1) ? 0 : 8);
            this.f5983b.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.adapter.smart.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmartDeviceTriggerAdapter.c.this.e(a, view);
                }
            });
        }
    }

    /* loaded from: classes2.dex */
    private class d extends a {

        /* renamed from: b  reason: collision with root package name */
        private TextView f5988b;

        d(View view) {
            super(view);
            this.f5988b = (TextView) view.findViewById(R.id.tv_smart_list_type_name);
        }

        @Override // com.tplink.iot.adapter.smart.SmartDeviceTriggerAdapter.a
        public void c(int i) {
            this.f5988b.setText(((h) SmartDeviceTriggerAdapter.this.a.get(i)).b());
        }
    }

    public SmartDeviceTriggerAdapter(Context context) {
        this.f5981b = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<h> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.a.get(i).c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((a) viewHolder).c(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_smart_layout, viewGroup, false));
        }
        return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_smart_list_title, viewGroup, false));
    }

    public void p(List<BaseALIoTDevice> list) {
        this.a.clear();
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (BaseALIoTDevice baseALIoTDevice : list) {
                String category = baseALIoTDevice.getCategory();
                EnumIoTCategory fromString = EnumIoTCategory.fromString(category);
                if (!(category == null || fromString == null)) {
                    List list2 = (List) hashMap.get(category);
                    if (list2 == null) {
                        list2 = new ArrayList();
                        list2.add(new h(n.d(fromString), 1));
                        hashMap.put(category, list2);
                    }
                    list2.add(new h(baseALIoTDevice, 0));
                }
            }
            for (String str : com.tplink.iot.view.smart.a.a.f9713b) {
                List list3 = (List) hashMap.get(str);
                if (list3 != null) {
                    this.a.addAll(list3);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void q(b bVar) {
        this.f5982c = bVar;
    }
}
