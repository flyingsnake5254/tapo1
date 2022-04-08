package com.tplink.iot.adapter.quicksetup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.iot.IoTSettingAvatarAdapter;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import java.util.List;

/* loaded from: classes2.dex */
public class IoTIconAdapter extends RecyclerView.Adapter<b> {
    private List<e> a;

    /* renamed from: b  reason: collision with root package name */
    private EnumDeviceType f5884b;

    /* renamed from: c  reason: collision with root package name */
    private int f5885c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f5886d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f5887c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f5888d;

        a(e eVar, int i) {
            this.f5887c = eVar;
            this.f5888d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f5887c.b()) {
                IoTIconAdapter.this.f5885c = this.f5888d;
                for (e eVar : IoTIconAdapter.this.a) {
                    eVar.d(false);
                }
                this.f5887c.d(true);
                IoTIconAdapter.this.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        ImageView a;

        /* renamed from: b  reason: collision with root package name */
        View f5890b;

        b(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.icon);
            this.f5890b = view.findViewById(R.id.select);
        }
    }

    public IoTIconAdapter(List<e> list, EnumDeviceType enumDeviceType) {
        this.a = list;
        this.f5884b = enumDeviceType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<e> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public String o() {
        int i = this.f5885c;
        if (i < 0 || i >= this.a.size()) {
            return EnumIoTAvatarType.PLUG.getName();
        }
        return this.a.get(this.f5885c).a();
    }

    /* renamed from: p */
    public void onBindViewHolder(@NonNull b bVar, int i) {
        e eVar = this.a.get(i);
        if (eVar.b()) {
            this.f5885c = i;
            bVar.f5890b.setVisibility(0);
        } else {
            bVar.f5890b.setVisibility(8);
        }
        bVar.a.setImageResource(IoTSettingAvatarAdapter.p(this.f5884b, eVar.a(), this.f5886d));
        bVar.itemView.setOnClickListener(new a(eVar, i));
    }

    @NonNull
    /* renamed from: q */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_plug_icon_item, viewGroup, false));
    }

    public void r(int i) {
        if (i != this.f5885c && i >= 0 && i < getItemCount()) {
            int i2 = this.f5885c;
            this.a.get(i2).d(false);
            this.a.get(i).d(true);
            notifyItemChanged(i2);
            notifyItemChanged(i);
            this.f5885c = i;
        }
    }

    public IoTIconAdapter(List<e> list, EnumDeviceType enumDeviceType, String str) {
        this.a = list;
        this.f5884b = enumDeviceType;
        this.f5886d = str;
    }
}
