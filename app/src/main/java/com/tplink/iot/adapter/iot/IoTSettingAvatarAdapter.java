package com.tplink.iot.adapter.iot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.Utils.z0.p;
import com.tplink.iot.Utils.z0.q;
import com.tplink.iot.Utils.z0.r;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumHubAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumTRVAvatarType;
import java.util.List;

/* loaded from: classes2.dex */
public class IoTSettingAvatarAdapter extends RecyclerView.Adapter<c> {
    private List<com.tplink.iot.model.iot.d> a;

    /* renamed from: b  reason: collision with root package name */
    private int f5775b;

    /* renamed from: c  reason: collision with root package name */
    private d f5776c;

    /* renamed from: d  reason: collision with root package name */
    private EnumDeviceType f5777d;

    /* renamed from: e  reason: collision with root package name */
    private String f5778e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5779c;

        a(int i) {
            this.f5779c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IoTSettingAvatarAdapter.this.t(this.f5779c);
            IoTSettingAvatarAdapter.this.f5775b = this.f5779c;
            if (IoTSettingAvatarAdapter.this.f5776c != null) {
                IoTSettingAvatarAdapter.this.f5776c.e(this.f5779c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumDeviceType.values().length];
            a = iArr;
            try {
                iArr[EnumDeviceType.PLUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumDeviceType.BULB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumDeviceType.HUB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumDeviceType.SENSOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumDeviceType.SWITCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumDeviceType.ENERGY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends RecyclerView.ViewHolder {
        private ImageView a;

        /* renamed from: b  reason: collision with root package name */
        private ImageView f5781b;

        public c(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.iv_avatar);
            this.f5781b = (ImageView) view.findViewById(R.id.iv_selected_flag);
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void e(int i);
    }

    public IoTSettingAvatarAdapter(List<com.tplink.iot.model.iot.d> list, EnumDeviceType enumDeviceType, String str) {
        this.a = list;
        this.f5777d = enumDeviceType;
        this.f5778e = str;
    }

    public static int p(EnumDeviceType enumDeviceType, String str, String str2) {
        if (enumDeviceType != null) {
            switch (b.a[enumDeviceType.ordinal()]) {
                case 1:
                    return q.i(EnumIoTAvatarType.fromString(str));
                case 2:
                    if (com.tplink.iot.g.b.c.c.i(str2)) {
                        return com.tplink.iot.g.b.c.c.d(EnumLightStripAvatarType.fromString(str));
                    }
                    return g.e(EnumBulbAvatarType.fromString(str));
                case 3:
                    return p.f(EnumHubAvatarType.fromString(str));
                case 4:
                    return r.g(str, str2);
                case 5:
                    return com.tplink.iot.g.c.a.b.c(EnumSwitchAvatarType.fromString(str), str2);
                case 6:
                    return com.tplink.iot.g.d.a.b.h(EnumTRVAvatarType.fromString(str));
            }
        }
        return q.i(EnumIoTAvatarType.fromString(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i) {
        for (int i2 = 0; i2 < getItemCount(); i2++) {
            this.a.get(i2).c(false);
        }
        this.a.get(i).c(true);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<com.tplink.iot.model.iot.d> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public String q() {
        return this.a.get(this.f5775b).a();
    }

    /* renamed from: r */
    public void onBindViewHolder(@NonNull c cVar, int i) {
        com.tplink.iot.model.iot.d dVar = this.a.get(i);
        cVar.a.setImageResource(p(this.f5777d, dVar.a(), this.f5778e));
        if (dVar.b()) {
            cVar.f5781b.setVisibility(0);
            this.f5775b = i;
        } else {
            cVar.f5781b.setVisibility(8);
        }
        cVar.itemView.setOnClickListener(new a(i));
    }

    @NonNull
    /* renamed from: s */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_setting_avatar, viewGroup, false));
    }

    public void u(d dVar) {
        this.f5776c = dVar;
    }
}
