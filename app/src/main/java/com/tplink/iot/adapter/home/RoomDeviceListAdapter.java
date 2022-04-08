package com.tplink.iot.adapter.home;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.model.home.DeviceInfoHolder;
import com.tplink.iot.model.home.TitleHolder;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.g;
import com.tplink.iot.model.home.h;
import com.tplink.iot.model.home.j;
import com.tplink.iot.model.home.k;
import com.tplink.iot.viewmodel.home.t;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class RoomDeviceListAdapter extends RecyclerView.Adapter implements DeviceInfoHolder.e {
    private Context a;

    /* renamed from: f  reason: collision with root package name */
    private Animation f5734f;
    private h g;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, e> f5732d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private boolean f5733e = false;

    /* renamed from: b  reason: collision with root package name */
    private List<h> f5730b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Boolean> f5731c = new HashMap();

    /* loaded from: classes2.dex */
    class a extends GridLayoutManager.SpanSizeLookup {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return ((h) RoomDeviceListAdapter.this.f5730b.get(i)).b() ? 2 : 1;
        }
    }

    public RoomDeviceListAdapter(Activity activity) {
        this.a = activity;
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.anim_common_roate);
        this.f5734f = loadAnimation;
        loadAnimation.setInterpolator(new LinearInterpolator());
    }

    private static String n(Context context, String str, BaseALIoTDevice<?> baseALIoTDevice) {
        EnumDeviceType fromType = EnumDeviceType.fromType(str);
        if (EnumDeviceType.BULB == fromType) {
            return context.getResources().getString(R.string.iot_bulbs);
        }
        if (EnumDeviceType.CAMERA == fromType) {
            return context.getResources().getString(R.string.iot_cameras);
        }
        if (EnumDeviceType.HUB == fromType) {
            return context.getResources().getString(R.string.iot_hubs);
        }
        if (EnumDeviceType.SENSOR == fromType) {
            return context.getResources().getString(R.string.iot_sensors);
        }
        if (EnumDeviceType.SWITCH == fromType) {
            return context.getResources().getString(R.string.iot_switches);
        }
        if (EnumDeviceType.ENERGY == fromType) {
            return context.getResources().getString(R.string.iot_thermostats);
        }
        return context.getResources().getString(R.string.iot_plugs);
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public boolean a() {
        return this.f5733e;
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void b(e eVar) {
        this.f5732d.put(eVar.e(), eVar);
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void c(boolean z) {
        this.f5733e = z;
        if (!z) {
            this.f5732d.clear();
        }
        notifyDataSetChanged();
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void d(e eVar) {
        this.f5732d.remove(eVar.e());
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public boolean g(e eVar) {
        return this.f5732d.containsValue(eVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f5730b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.f5730b.isEmpty()) {
            return 1;
        }
        return this.f5730b.get(i).a();
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void h() {
        h hVar = this.g;
        if (hVar != null) {
            hVar.b(this.f5732d.size());
        }
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void i(e eVar) {
        h hVar = this.g;
        if (hVar != null) {
            hVar.i(eVar);
        }
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void j(e eVar) {
        h hVar = this.g;
        if (hVar != null) {
            hVar.j(eVar);
        }
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void l(int i, e eVar, boolean z) {
        h hVar = this.g;
        if (hVar != null) {
            hVar.l(i, eVar, z);
        }
    }

    public List<e> o() {
        return new ArrayList(this.f5732d.values());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        ((GridLayoutManager) recyclerView.getLayoutManager()).setSpanSizeLookup(new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof DeviceInfoHolder) {
            h hVar = this.f5730b.get(i);
            if (hVar instanceof e) {
                ((DeviceInfoHolder) viewHolder).s((e) hVar, i, this);
            }
        } else if (viewHolder instanceof TitleHolder) {
            h hVar2 = this.f5730b.get(i);
            if (hVar2 instanceof j) {
                ((TitleHolder) viewHolder).c((j) hVar2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new TitleHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_all_devices_category_iot_typet_layout, viewGroup, false));
        }
        return new DeviceInfoHolder(this.a, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_device_info, viewGroup, false), this.f5734f);
    }

    public boolean p() {
        ArrayList<e> arrayList = new ArrayList(this.f5732d.values());
        if (arrayList.isEmpty()) {
            return false;
        }
        for (e eVar : arrayList) {
            if (eVar instanceof k) {
                if (!((k) eVar).q()) {
                    return true;
                }
            } else if ((eVar instanceof g) && !((g) eVar).j()) {
                return true;
            }
        }
        return false;
    }

    public boolean q() {
        return this.f5731c.size() > 1;
    }

    public void r(List<e> list) {
        this.f5730b.clear();
        this.f5731c.clear();
        if (list != null && !list.isEmpty()) {
            for (e eVar : list) {
                if (eVar instanceof k) {
                    k kVar = (k) eVar;
                    if (kVar.g() != null) {
                        String c2 = t.c(kVar);
                        if (this.f5731c.get(c2) == null) {
                            this.f5731c.put(c2, Boolean.TRUE);
                            this.f5730b.add(new j(n(this.a, c2, kVar.g())));
                        }
                        this.f5730b.add(eVar);
                    }
                } else if ((eVar instanceof g) && ((g) eVar).h() != null) {
                    if (this.f5731c.get("group") == null) {
                        this.f5731c.put("group", Boolean.TRUE);
                        this.f5730b.add(new j(this.a.getString(R.string.groups)));
                    }
                    this.f5730b.add(eVar);
                }
            }
        }
        if (this.f5731c.size() == 1) {
            this.f5730b.remove(0);
        }
        notifyDataSetChanged();
    }

    public void s(h hVar) {
        this.g = hVar;
    }
}
