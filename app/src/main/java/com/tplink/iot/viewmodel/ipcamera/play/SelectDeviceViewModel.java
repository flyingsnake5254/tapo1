package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import b.d.d.m.f;
import b.d.q.b.l;
import com.tplink.iot.R;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel;
import com.tplink.libtpmediaother.database.model.c;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class SelectDeviceViewModel extends AndroidViewModel {

    /* renamed from: c  reason: collision with root package name */
    private List<String> f10560c;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<String> f10563f;
    private ArrayList<String> g;
    private ArrayList<a> a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private List<ALCameraDevice> f10559b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, MutableLiveData<f<String>>> f10561d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public MutableLiveData<Integer> f10562e = new MutableLiveData<>();

    /* loaded from: classes3.dex */
    public static class a {
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f10564b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10565c;

        /* renamed from: d  reason: collision with root package name */
        public String f10566d;

        /* renamed from: e  reason: collision with root package name */
        public String f10567e;

        /* renamed from: f  reason: collision with root package name */
        public String f10568f;
        public final ObservableBoolean g;

        a(boolean z, boolean z2, boolean z3, String str, String str2, String str3) {
            ObservableBoolean observableBoolean = new ObservableBoolean();
            this.g = observableBoolean;
            this.f10565c = z;
            this.a = z2;
            this.f10564b = z3;
            this.f10566d = str == null ? "" : str;
            this.f10567e = str2;
            this.f10568f = str3;
            observableBoolean.set(z2 || z);
        }
    }

    public SelectDeviceViewModel(@NonNull Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t(String str, String str2, c cVar) {
        this.a.add(new a(str.equals(str2), true, true, cVar.i() == null ? "" : cVar.i(), cVar.a(), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(String str, c cVar) {
        this.a.add(new a(false, false, false, cVar.i() == null ? "" : cVar.i(), cVar.a(), str));
    }

    public void f(int i) {
        g(this.a.get(i));
    }

    public void g(a aVar) {
        int i = 1;
        boolean z = !aVar.g.get();
        aVar.g.set(z);
        MutableLiveData<Integer> mutableLiveData = this.f10562e;
        int intValue = ((Integer) j.e(mutableLiveData, 0)).intValue();
        if (!z) {
            i = -1;
        }
        mutableLiveData.setValue(Integer.valueOf(intValue + i));
        String str = aVar.f10568f;
        boolean contains = this.f10560c.contains(str);
        if (!z && contains) {
            this.g.add(str);
        } else if (z && !contains) {
            this.f10563f.add(str);
        }
        if (!z && this.f10563f.contains(str)) {
            this.f10563f.remove(str);
        }
    }

    public Intent h() {
        Intent intent = new Intent();
        intent.putExtra("incremental_mac_list", this.f10563f);
        intent.putExtra("reduced_mac_list", this.g);
        return intent;
    }

    public void i(Intent intent) {
        o(intent.getStringArrayListExtra("added_mac_list"), intent.getStringExtra("persisted_mac"));
    }

    public String j(int i) {
        return getApplication().getString(R.string.common_ok) + " (" + i + "/32)";
    }

    public ArrayList<String> k() {
        return this.f10563f;
    }

    public ArrayList<a> l() {
        return this.a;
    }

    public ArrayList<String> m() {
        return this.g;
    }

    public MutableLiveData<Integer> n() {
        return this.f10562e;
    }

    public void o(ArrayList<String> arrayList, final String str) {
        this.f10563f = new ArrayList<>();
        this.g = new ArrayList<>();
        TPIoTClientManager tPIoTClientManager = (TPIoTClientManager) b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
        if (tPIoTClientManager.M1().getValue() != null) {
            this.f10559b.addAll(tPIoTClientManager.M1().getValue());
        }
        Collections.sort(this.f10559b, u1.f10660c);
        this.f10560c = arrayList;
        this.f10562e.setValue(Integer.valueOf(arrayList.size()));
        this.f10561d.clear();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f10561d.put(it.next(), new MediatorLiveData());
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (final ALCameraDevice aLCameraDevice : this.f10559b) {
            String deviceIdMD5 = aLCameraDevice.getDeviceIdMD5();
            arrayList2.add(deviceIdMD5);
            l.r(deviceIdMD5, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.play.s1
                @Override // com.tplink.libtpnetwork.Utils.f0.b
                public final void a(Object obj) {
                    ((c) obj).l(ALCameraDevice.this.getDeviceAlias());
                }
            });
            if (!com.tplink.libtpnetwork.Utils.f.f(deviceIdMD5)) {
                arrayList3.add(deviceIdMD5);
            }
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            final String next = it2.next();
            l.e(next, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.play.t1
                @Override // com.tplink.libtpnetwork.Utils.f0.b
                public final void a(Object obj) {
                    SelectDeviceViewModel.this.t(next, str, (c) obj);
                }
            });
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            final String str2 = (String) it3.next();
            if (!arrayList.contains(str2) && !arrayList3.contains(str2)) {
                l.e(str2, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.play.w1
                    @Override // com.tplink.libtpnetwork.Utils.f0.b
                    public final void a(Object obj) {
                        SelectDeviceViewModel.this.v(str2, (c) obj);
                    }
                });
            }
        }
    }

    public int x(String str) {
        Iterator<a> it = this.a.iterator();
        int i = -1;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            final a next = it.next();
            i++;
            if (next.f10568f.equalsIgnoreCase(str)) {
                l.e(str, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.play.v1
                    @Override // com.tplink.libtpnetwork.Utils.f0.b
                    public final void a(Object obj) {
                        SelectDeviceViewModel.a.this.f10566d = r2.i() == null ? "" : ((c) obj).i();
                    }
                });
                break;
            }
        }
        return i;
    }
}
