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
import com.tplink.iot.adapter.smart.SmartDeviceTaskAdapter;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.model.smart.h;
import com.tplink.iot.viewmodel.smart.DeviceChooseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class SmartDeviceTaskAdapter extends RecyclerView.Adapter {
    private List<h> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Context f5971b;

    /* renamed from: c  reason: collision with root package name */
    private DeviceChooseViewModel f5972c;

    /* renamed from: d  reason: collision with root package name */
    private b f5973d;

    /* loaded from: classes2.dex */
    private abstract class a extends RecyclerView.ViewHolder {
        a(View view) {
            super(view);
        }

        public abstract void c(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Y(ThingInfo thingInfo);
    }

    /* loaded from: classes2.dex */
    private class c extends a {

        /* renamed from: b  reason: collision with root package name */
        private RelativeLayout f5974b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f5975c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f5976d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f5977e;

        /* renamed from: f  reason: collision with root package name */
        private View f5978f;

        c(View view) {
            super(view);
            this.f5974b = (RelativeLayout) view.findViewById(R.id.rl_smart_settings);
            this.f5975c = (ImageView) view.findViewById(R.id.iv_item_icon);
            this.f5976d = (TextView) view.findViewById(R.id.item_title_hint);
            this.f5977e = (TextView) view.findViewById(R.id.item_info);
            this.f5978f = view.findViewById(R.id.bottom_divider);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void e(BaseALIoTDevice baseALIoTDevice, View view) {
            if (SmartDeviceTaskAdapter.this.f5973d != null && baseALIoTDevice != null && baseALIoTDevice.getThingDevice() != null) {
                SmartDeviceTaskAdapter.this.f5973d.Y(baseALIoTDevice.getThingDevice().getThingInfo());
            }
        }

        private void f(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f5977e.setText(str);
                this.f5977e.setVisibility(0);
                return;
            }
            this.f5977e.setText("");
            this.f5977e.setVisibility(8);
        }

        @Override // com.tplink.iot.adapter.smart.SmartDeviceTaskAdapter.a
        public void c(int i) {
            final BaseALIoTDevice a = ((h) SmartDeviceTaskAdapter.this.a.get(i)).a();
            if (a != null) {
                this.f5976d.setText(l.e(SmartDeviceTaskAdapter.this.f5971b, a.getDeviceType(), a.getDeviceName(), a.getDeviceModel()));
                l.o(SmartDeviceTaskAdapter.this.f5971b, a, this.f5975c);
                f(l.b(SmartDeviceTaskAdapter.this.f5971b, a));
            }
            int i2 = i + 1;
            this.f5978f.setVisibility((i2 >= SmartDeviceTaskAdapter.this.a.size() || ((h) SmartDeviceTaskAdapter.this.a.get(i2)).c() != 1) ? 0 : 8);
            this.f5974b.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.adapter.smart.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmartDeviceTaskAdapter.c.this.e(a, view);
                }
            });
        }
    }

    /* loaded from: classes2.dex */
    private class d extends a {

        /* renamed from: b  reason: collision with root package name */
        private TextView f5979b;

        d(View view) {
            super(view);
            this.f5979b = (TextView) view.findViewById(R.id.tv_smart_list_type_name);
        }

        @Override // com.tplink.iot.adapter.smart.SmartDeviceTaskAdapter.a
        public void c(int i) {
            this.f5979b.setText(((h) SmartDeviceTaskAdapter.this.a.get(i)).b());
        }
    }

    public SmartDeviceTaskAdapter(Context context, DeviceChooseViewModel deviceChooseViewModel) {
        this.f5971b = context;
        this.f5972c = deviceChooseViewModel;
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
            for (String str : com.tplink.iot.view.smart.a.a.f9715d) {
                List list3 = (List) hashMap.get(str);
                if (list3 != null) {
                    this.a.addAll(list3);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void q(b bVar) {
        this.f5973d = bVar;
    }
}
