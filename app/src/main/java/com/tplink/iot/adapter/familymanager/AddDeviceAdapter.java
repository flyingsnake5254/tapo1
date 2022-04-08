package com.tplink.iot.adapter.familymanager;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.Utils.z0.o;
import com.tplink.iot.Utils.z0.p;
import com.tplink.iot.Utils.z0.q;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumHubAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumTRVAvatarType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class AddDeviceAdapter extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    private Context f5527d;

    /* renamed from: e  reason: collision with root package name */
    private d f5528e;
    private final int a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final int f5525b = 2;

    /* renamed from: c  reason: collision with root package name */
    private final int f5526c = 3;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, com.tplink.iot.j.a.a> f5529f = new HashMap();
    private List<String> g = new ArrayList();
    private List<DeviceBean> h = new ArrayList();
    private List<GroupInfo> i = new ArrayList();
    private Map<String, List<BaseALIoTDevice>> j = new HashMap();

    /* loaded from: classes2.dex */
    class DeviceTitleViewHolder extends RecyclerView.ViewHolder {
        @BindView
        TextView mDeviceTitleTv;

        public DeviceTitleViewHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: classes2.dex */
    public class DeviceTitleViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private DeviceTitleViewHolder f5530b;

        @UiThread
        public DeviceTitleViewHolder_ViewBinding(DeviceTitleViewHolder deviceTitleViewHolder, View view) {
            this.f5530b = deviceTitleViewHolder;
            deviceTitleViewHolder.mDeviceTitleTv = (TextView) butterknife.internal.c.d(view, R.id.tv_title, "field 'mDeviceTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void a() {
            DeviceTitleViewHolder deviceTitleViewHolder = this.f5530b;
            if (deviceTitleViewHolder != null) {
                this.f5530b = null;
                deviceTitleViewHolder.mDeviceTitleTv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes2.dex */
    static class DeviceViewHolder extends RecyclerView.ViewHolder {
        @BindView
        TextView mDeviceCategoryTv;
        @BindView
        ImageView mDeviceImageIv;
        @BindView
        View mDeviceItem;
        @BindView
        TextView mDeviceOfRoomTv;
        @BindView
        ImageView mDeviceSelectIv;

        public DeviceViewHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: classes2.dex */
    public class DeviceViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private DeviceViewHolder f5531b;

        @UiThread
        public DeviceViewHolder_ViewBinding(DeviceViewHolder deviceViewHolder, View view) {
            this.f5531b = deviceViewHolder;
            deviceViewHolder.mDeviceItem = butterknife.internal.c.c(view, R.id.item_device, "field 'mDeviceItem'");
            deviceViewHolder.mDeviceImageIv = (ImageView) butterknife.internal.c.d(view, R.id.iv_device_image, "field 'mDeviceImageIv'", ImageView.class);
            deviceViewHolder.mDeviceCategoryTv = (TextView) butterknife.internal.c.d(view, R.id.tv_device_category, "field 'mDeviceCategoryTv'", TextView.class);
            deviceViewHolder.mDeviceOfRoomTv = (TextView) butterknife.internal.c.d(view, R.id.tv_device_of_room, "field 'mDeviceOfRoomTv'", TextView.class);
            deviceViewHolder.mDeviceSelectIv = (ImageView) butterknife.internal.c.d(view, R.id.iv_device_select, "field 'mDeviceSelectIv'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void a() {
            DeviceViewHolder deviceViewHolder = this.f5531b;
            if (deviceViewHolder != null) {
                this.f5531b = null;
                deviceViewHolder.mDeviceItem = null;
                deviceViewHolder.mDeviceImageIv = null;
                deviceViewHolder.mDeviceCategoryTv = null;
                deviceViewHolder.mDeviceOfRoomTv = null;
                deviceViewHolder.mDeviceSelectIv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes2.dex */
    static class GroupViewHolder extends RecyclerView.ViewHolder {
        @BindView
        TextView mDeviceCategoryTv;
        @BindView
        ImageView mDeviceImageIv;
        @BindView
        View mDeviceItem;
        @BindView
        TextView mDeviceOfRoomTv;
        @BindView
        ImageView mDeviceSelectIv;

        public GroupViewHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: classes2.dex */
    public class GroupViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private GroupViewHolder f5532b;

        @UiThread
        public GroupViewHolder_ViewBinding(GroupViewHolder groupViewHolder, View view) {
            this.f5532b = groupViewHolder;
            groupViewHolder.mDeviceItem = butterknife.internal.c.c(view, R.id.item_device, "field 'mDeviceItem'");
            groupViewHolder.mDeviceImageIv = (ImageView) butterknife.internal.c.d(view, R.id.iv_device_image, "field 'mDeviceImageIv'", ImageView.class);
            groupViewHolder.mDeviceCategoryTv = (TextView) butterknife.internal.c.d(view, R.id.tv_device_category, "field 'mDeviceCategoryTv'", TextView.class);
            groupViewHolder.mDeviceOfRoomTv = (TextView) butterknife.internal.c.d(view, R.id.tv_device_of_room, "field 'mDeviceOfRoomTv'", TextView.class);
            groupViewHolder.mDeviceSelectIv = (ImageView) butterknife.internal.c.d(view, R.id.iv_device_select, "field 'mDeviceSelectIv'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void a() {
            GroupViewHolder groupViewHolder = this.f5532b;
            if (groupViewHolder != null) {
                this.f5532b = null;
                groupViewHolder.mDeviceItem = null;
                groupViewHolder.mDeviceImageIv = null;
                groupViewHolder.mDeviceCategoryTv = null;
                groupViewHolder.mDeviceOfRoomTv = null;
                groupViewHolder.mDeviceSelectIv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ GroupInfo f5533c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f5534d;

        a(GroupInfo groupInfo, int i) {
            this.f5533c = groupInfo;
            this.f5534d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AddDeviceAdapter.this.i.contains(this.f5533c)) {
                AddDeviceAdapter.this.i.remove(this.f5533c);
            } else {
                AddDeviceAdapter.this.i.add(this.f5533c);
            }
            AddDeviceAdapter.this.notifyItemChanged(this.f5534d);
            if (AddDeviceAdapter.this.f5528e != null) {
                AddDeviceAdapter.this.f5528e.k();
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DeviceBean f5536c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f5537d;

        b(DeviceBean deviceBean, int i) {
            this.f5536c = deviceBean;
            this.f5537d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AddDeviceAdapter.this.h.contains(this.f5536c)) {
                AddDeviceAdapter.this.h.remove(this.f5536c);
            } else {
                AddDeviceAdapter.this.h.add(this.f5536c);
            }
            AddDeviceAdapter.this.notifyItemChanged(this.f5537d);
            if (AddDeviceAdapter.this.f5528e != null) {
                AddDeviceAdapter.this.f5528e.k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumDeviceType.values().length];
            a = iArr;
            try {
                iArr[EnumDeviceType.BULB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumDeviceType.PLUG.ordinal()] = 2;
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
            try {
                a[EnumDeviceType.CAMERA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void k();
    }

    public AddDeviceAdapter(Context context) {
        this.f5527d = context;
    }

    private void s(String str, ImageView imageView, String str2) {
        ALCameraDevice aLCameraDevice;
        if (!TextUtils.isEmpty(str2)) {
            BaseALIoTDevice I1 = TPIoTClientManager.I1(b.d.p.c.b(str2));
            if (I1 instanceof ALCameraDevice) {
                aLCameraDevice = (ALCameraDevice) I1;
                h.y(this.f5527d, aLCameraDevice, imageView);
            }
        }
        aLCameraDevice = null;
        h.y(this.f5527d, aLCameraDevice, imageView);
    }

    private void u(String str, String str2, ImageView imageView, String str3, String str4) {
        switch (c.a[EnumDeviceType.fromType(str).ordinal()]) {
            case 1:
                if (com.tplink.iot.g.b.c.c.i(str4)) {
                    imageView.setImageResource(com.tplink.iot.g.b.c.c.b(EnumLightStripAvatarType.fromString(str2)));
                    return;
                } else {
                    imageView.setImageResource(g.c(EnumBulbAvatarType.fromString(str2)));
                    return;
                }
            case 2:
                imageView.setImageResource(q.g(EnumIoTAvatarType.fromString(str2)));
                return;
            case 3:
                imageView.setImageResource(p.d(EnumHubAvatarType.fromString(str2)));
                return;
            case 4:
                imageView.setImageResource(r.e(str2, str4));
                return;
            case 5:
                imageView.setImageResource(com.tplink.iot.g.c.a.b.a(EnumSwitchAvatarType.fromString(str2), str4));
                return;
            case 6:
                imageView.setImageResource(com.tplink.iot.g.d.a.b.f(EnumTRVAvatarType.fromString(str2)));
                return;
            case 7:
                s(str2, imageView, str3);
                return;
            default:
                return;
        }
    }

    private void w(Map<String, com.tplink.iot.j.a.a> map) {
        for (String str : map.keySet()) {
            com.tplink.iot.j.a.a aVar = map.get(str);
            if (aVar != null) {
                List<DeviceBean> b2 = aVar.b();
                if (b2 != null && b2.size() > 1) {
                    com.tplink.iot.viewmodel.familymanager.b.c(b2);
                }
                List<GroupInfo> c2 = aVar.c();
                if (c2 != null && c2.size() > 1) {
                    com.tplink.iot.viewmodel.familymanager.b.d(c2);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i;
        int i2 = 0;
        for (String str : this.g) {
            if (this.f5529f.containsKey(str)) {
                i = this.f5529f.get(str).e();
            } else {
                i = this.j.get(str).size();
            }
            i2 = i2 + i + 1;
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int i2;
        int i3;
        if (i == 0) {
            return 1;
        }
        int i4 = 0;
        for (String str : this.g) {
            if (this.f5529f.containsKey(str)) {
                i2 = this.f5529f.get(str).e();
                i3 = this.f5529f.get(str).d();
            } else {
                i2 = this.j.get(str).size();
                i3 = 0;
            }
            i4 = i4 + i2 + 1;
            if (i == i4) {
                return 1;
            }
            if (i >= i4 - i3 && i < i4) {
                return 3;
            }
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        int i3;
        DeviceBean deviceBean;
        GroupInfo groupInfo;
        if (i == 0) {
            ((DeviceTitleViewHolder) viewHolder).mDeviceTitleTv.setText(this.g.get(0));
            return;
        }
        int i4 = 0;
        int i5 = 0;
        for (String str : this.g) {
            if (this.f5529f.containsKey(str)) {
                i2 = this.f5529f.get(str).e();
            } else {
                i2 = this.j.get(str).size();
            }
            i4 += i2 + 1;
            if (i5 == i) {
                ((DeviceTitleViewHolder) viewHolder).mDeviceTitleTv.setText(str);
                return;
            } else if (i <= i5 || i >= i4) {
                i5 = i4;
            } else if (this.f5529f.containsKey(str)) {
                com.tplink.iot.j.a.a aVar = this.f5529f.get(str);
                if (aVar != null) {
                    boolean z = viewHolder instanceof GroupViewHolder;
                    int i6 = R.mipmap.radio_button_on;
                    if (z) {
                        List<GroupInfo> c2 = aVar.c();
                        if (!(c2 == null || c2.isEmpty())) {
                            int size = c2.size();
                            int i7 = (i + size) - i4;
                            if (i7 >= 0 && i7 < size && (groupInfo = c2.get(i7)) != null) {
                                GroupViewHolder groupViewHolder = (GroupViewHolder) viewHolder;
                                groupViewHolder.mDeviceCategoryTv.setText(o.d(this.f5527d, groupInfo.getName()));
                                groupViewHolder.mDeviceOfRoomTv.setText(o.a(groupInfo));
                                if (!this.i.contains(groupInfo)) {
                                    i6 = R.mipmap.radio_button_off;
                                }
                                groupViewHolder.mDeviceSelectIv.setImageResource(i6);
                                o.g(groupInfo, groupViewHolder.mDeviceImageIv);
                                groupViewHolder.itemView.setOnClickListener(new a(groupInfo, i));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    DeviceViewHolder deviceViewHolder = (DeviceViewHolder) viewHolder;
                    List<DeviceBean> b2 = aVar.b();
                    if (!(b2 == null || b2.isEmpty() || (i - i5) - 1 < 0 || i3 >= b2.size() || (deviceBean = b2.get(i3)) == null)) {
                        deviceViewHolder.mDeviceCategoryTv.setText(l.e(this.f5527d, deviceBean.getDeviceType(), deviceBean.getDeviceName(), deviceBean.getDeviceModel()));
                        deviceViewHolder.mDeviceOfRoomTv.setText(deviceBean.getRoomName());
                        if (!this.h.contains(deviceBean)) {
                            i6 = R.mipmap.radio_button_off;
                        }
                        deviceViewHolder.mDeviceSelectIv.setImageResource(i6);
                        u(deviceBean.getDeviceType(), deviceBean.getAvatarUrl(), deviceViewHolder.mDeviceImageIv, deviceBean.getDeviceId(), deviceBean.getDeviceModel());
                        deviceViewHolder.itemView.setOnClickListener(new b(deviceBean, i));
                        return;
                    }
                    return;
                }
                return;
            } else {
                DeviceViewHolder deviceViewHolder2 = (DeviceViewHolder) viewHolder;
                int i8 = (i - i5) - 1;
                List<BaseALIoTDevice> list = this.j.get(str);
                if (list != null && !list.isEmpty() && i8 >= 0 && i8 < list.size()) {
                    BaseALIoTDevice baseALIoTDevice = list.get(i8);
                    deviceViewHolder2.mDeviceCategoryTv.setText(l.e(this.f5527d, baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceName(), baseALIoTDevice.getDeviceModel()));
                    l.o(this.f5527d, baseALIoTDevice, deviceViewHolder2.mDeviceImageIv);
                    deviceViewHolder2.mDeviceItem.setAlpha(0.4f);
                    deviceViewHolder2.mDeviceItem.setEnabled(false);
                    deviceViewHolder2.mDeviceOfRoomTv.setVisibility(8);
                    return;
                }
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new DeviceTitleViewHolder(LayoutInflater.from(this.f5527d).inflate(R.layout.item_list_title, viewGroup, false));
        }
        if (i == 2) {
            return new DeviceViewHolder(LayoutInflater.from(this.f5527d).inflate(R.layout.item_device, viewGroup, false));
        }
        if (i != 3) {
            return new DeviceViewHolder(LayoutInflater.from(this.f5527d).inflate(R.layout.item_device, viewGroup, false));
        }
        return new GroupViewHolder(LayoutInflater.from(this.f5527d).inflate(R.layout.item_group, viewGroup, false));
    }

    public List<DeviceBean> p() {
        return this.h;
    }

    public List<GroupInfo> q() {
        return this.i;
    }

    public int r() {
        List<DeviceBean> list = this.h;
        int i = 0;
        int size = list == null ? 0 : list.size();
        List<GroupInfo> list2 = this.i;
        if (list2 != null) {
            i = list2.size();
        }
        return size + i;
    }

    public void t(Map<String, com.tplink.iot.j.a.a> map, Map<String, List<BaseALIoTDevice>> map2) {
        if (map != null) {
            this.f5529f.clear();
            this.f5529f.putAll(map);
            w(this.f5529f);
            this.g.clear();
            this.g.addAll(this.f5529f.keySet());
            this.j.clear();
            if (map2 != null && map2.size() > 0) {
                this.j.putAll(map2);
                this.g.addAll(this.j.keySet());
            }
            notifyDataSetChanged();
        }
    }

    public void v(d dVar) {
        this.f5528e = dVar;
    }
}
