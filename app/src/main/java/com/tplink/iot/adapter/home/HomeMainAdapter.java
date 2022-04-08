package com.tplink.iot.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s;
import com.tplink.iot.model.home.DeviceInfoHolder;
import com.tplink.iot.model.home.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class HomeMainAdapter extends RecyclerView.Adapter implements DeviceInfoHolder.e {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private List<e> f5701b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, e> f5702c;

    /* renamed from: d  reason: collision with root package name */
    private Context f5703d;

    /* renamed from: e  reason: collision with root package name */
    private Animation f5704e;

    /* renamed from: f  reason: collision with root package name */
    private h f5705f;
    private boolean g;

    public HomeMainAdapter(Context context) {
        this(context, true);
    }

    private void p(List<e> list, int i, int i2) {
        if (list != null && list.size() >= 2 && i != i2 && i >= 0 && i < list.size() && i2 >= 0 && i2 < list.size()) {
            list.add(i2, list.remove(i));
        }
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public boolean a() {
        return this.a;
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void b(e eVar) {
        this.f5702c.put(eVar.e(), eVar);
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void c(boolean z) {
        this.a = z;
        if (!z) {
            this.f5702c.clear();
        }
        notifyDataSetChanged();
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void d(e eVar) {
        this.f5702c.remove(eVar.e());
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public boolean g(e eVar) {
        return this.f5702c.containsValue(eVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<e> list = this.f5701b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void h() {
        h hVar = this.f5705f;
        if (hVar != null) {
            hVar.b(this.f5702c.size());
        }
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void i(e eVar) {
        h hVar = this.f5705f;
        if (hVar != null) {
            hVar.i(eVar);
        }
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void j(e eVar) {
        h hVar = this.f5705f;
        if (hVar != null) {
            hVar.j(eVar);
        }
    }

    @Override // com.tplink.iot.model.home.DeviceInfoHolder.e
    public void l(int i, e eVar, boolean z) {
        h hVar = this.f5705f;
        if (hVar != null) {
            hVar.l(i, eVar, z);
        }
    }

    public List<e> m() {
        return this.f5701b;
    }

    public List<e> n() {
        return new ArrayList(this.f5702c.values());
    }

    public boolean o() {
        return s.b(this.f5701b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((DeviceInfoHolder) viewHolder).s(this.f5701b.get(i), i, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DeviceInfoHolder(this.f5703d, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_device_info, viewGroup, false), this.f5704e, this.g);
    }

    public void q(int i) {
    }

    public boolean r(int i, int i2) {
        p(this.f5701b, i, i2);
        notifyItemMoved(i, i2);
        h hVar = this.f5705f;
        if (hVar == null) {
            return true;
        }
        hVar.f(i, i2);
        return true;
    }

    public void s(List<e> list) {
        if (this.f5701b == null) {
            this.f5701b = new ArrayList();
        }
        this.f5701b.clear();
        if (list != null && !list.isEmpty()) {
            this.f5701b.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void t(List<e> list) {
        if (this.f5701b == null) {
            this.f5701b = new ArrayList();
        }
        this.f5701b.clear();
        this.f5701b.addAll(list);
        this.f5702c.clear();
        notifyDataSetChanged();
    }

    public void u(h hVar) {
        this.f5705f = hVar;
    }

    public HomeMainAdapter(Context context, boolean z) {
        this.a = false;
        this.f5702c = new HashMap();
        this.g = true;
        this.f5703d = context;
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_common_roate);
        this.f5704e = loadAnimation;
        loadAnimation.setInterpolator(new LinearInterpolator());
        this.g = z;
    }
}
