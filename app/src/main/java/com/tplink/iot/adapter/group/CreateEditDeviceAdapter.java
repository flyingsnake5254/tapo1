package com.tplink.iot.adapter.group;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.j;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.widget.RippleCardView;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class CreateEditDeviceAdapter extends RecyclerView.Adapter {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private List<BaseALIoTDevice> f5624b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, BaseALIoTDevice> f5625c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private String f5626d;

    /* renamed from: e  reason: collision with root package name */
    private a f5627e;

    /* loaded from: classes2.dex */
    public interface a {
        void b(int i);

        void o();
    }

    /* loaded from: classes2.dex */
    private class b extends RecyclerView.ViewHolder {
        View a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5628b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5629c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f5630d;

        /* renamed from: e  reason: collision with root package name */
        TPCheckboxCompat f5631e;

        /* renamed from: f  reason: collision with root package name */
        RippleCardView f5632f;
        ImageView g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements TPCheckboxCompat.a {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ BaseALIoTDevice f5633c;

            a(BaseALIoTDevice baseALIoTDevice) {
                this.f5633c = baseALIoTDevice;
            }

            @Override // com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat.a
            public void c(CompoundButton compoundButton, boolean z, boolean z2) {
                if (z2) {
                    if (!z) {
                        CreateEditDeviceAdapter.this.f5625c.remove(this.f5633c.getDeviceId());
                    } else if (CreateEditDeviceAdapter.this.f5625c.size() >= 32) {
                        b.this.f5631e.setChecked(false);
                        if (CreateEditDeviceAdapter.this.f5627e != null) {
                            CreateEditDeviceAdapter.this.f5627e.o();
                        }
                    } else {
                        CreateEditDeviceAdapter.this.f5625c.put(this.f5633c.getDeviceId(), this.f5633c);
                    }
                }
                if (CreateEditDeviceAdapter.this.f5627e != null) {
                    CreateEditDeviceAdapter.this.f5627e.b(CreateEditDeviceAdapter.this.f5625c.size());
                }
            }
        }

        b(View view) {
            super(view);
            this.a = view;
            this.f5628b = (TextView) view.findViewById(R.id.tv_device_name);
            this.f5629c = (TextView) view.findViewById(R.id.tv_home_location);
            this.f5630d = (ImageView) view.findViewById(R.id.iv_home_plug_icon);
            this.f5631e = (TPCheckboxCompat) view.findViewById(R.id.cb_home_item);
            this.f5632f = (RippleCardView) view.findViewById(R.id.cv_home_item_card);
            this.g = (ImageView) view.findViewById(R.id.iv_device_show_icon);
        }

        public void c(BaseALIoTDevice baseALIoTDevice, int i) {
            this.f5628b.setText(l.e(CreateEditDeviceAdapter.this.a, baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceName(), baseALIoTDevice.getDeviceModel()));
            l.o(CreateEditDeviceAdapter.this.a, baseALIoTDevice, this.f5630d);
            this.f5629c.setText(l.b(CreateEditDeviceAdapter.this.a, baseALIoTDevice));
            this.g.setImageResource(R.mipmap.home_item_share_device);
            this.g.setVisibility(baseALIoTDevice.isUserRoleTypeDevice() ? 0 : 4);
            this.f5632f.setCardElevation(j.a(CreateEditDeviceAdapter.this.a, 2.0f));
            this.f5631e.setCompoundDrawablesRelativeWithIntrinsicBounds(CreateEditDeviceAdapter.this.a.getResources().getDrawable(R.drawable.selector_home_long_click_off), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f5632f.setCardBackgroundColor(CreateEditDeviceAdapter.this.a.getResources().getColor(R.color.white));
            this.f5628b.setTextColor(CreateEditDeviceAdapter.this.a.getResources().getColor(R.color.color_333333));
            this.f5629c.setTextColor(CreateEditDeviceAdapter.this.a.getResources().getColor(R.color.color_home_location_off));
            this.f5628b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, CreateEditDeviceAdapter.this.a.getResources().getDrawable(R.mipmap.gray_arrow_right), (Drawable) null);
            this.f5631e.setOnCheckedChangeListener(new a(baseALIoTDevice));
            if (CreateEditDeviceAdapter.this.f5626d == null || !CreateEditDeviceAdapter.this.f5626d.equals(baseALIoTDevice.getDeviceId())) {
                this.f5631e.setEnabled(true);
            } else {
                CreateEditDeviceAdapter.this.f5625c.put(baseALIoTDevice.getDeviceId(), baseALIoTDevice);
                this.f5631e.setEnabled(false);
            }
            this.f5631e.setChecked(CreateEditDeviceAdapter.this.f5625c.containsKey(baseALIoTDevice.getDeviceId()));
        }
    }

    public CreateEditDeviceAdapter(Activity activity) {
        this.a = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<BaseALIoTDevice> list = this.f5624b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((b) viewHolder).c(this.f5624b.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_group_edit_device, viewGroup, false));
    }

    public List<BaseALIoTDevice> q() {
        return new ArrayList(this.f5625c.values());
    }

    public void r(List<BaseALIoTDevice> list) {
        this.f5624b.clear();
        if (list != null) {
            this.f5624b.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void s(String str) {
        this.f5626d = str;
    }

    public void t(a aVar) {
        this.f5627e = aVar;
    }
}
