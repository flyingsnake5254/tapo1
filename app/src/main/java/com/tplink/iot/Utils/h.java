package com.tplink.iot.Utils;

import android.content.Context;
import androidx.lifecycle.MediatorLiveData;
import b.d.b.f.b;
import com.google.gson.Gson;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: CameraLiveConfigManager.kt */
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: d  reason: collision with root package name */
    private final b.d.w.g.a f5315d;

    /* renamed from: e  reason: collision with root package name */
    private final List<ALCameraDevice> f5316e;
    private final Context i;
    private final String j;
    private final String a = "CameraLiveConfigManager";

    /* renamed from: b  reason: collision with root package name */
    private final boolean f5313b = true;

    /* renamed from: c  reason: collision with root package name */
    private final Gson f5314c = new Gson();
    private final ArrayList<String> g = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private final g f5317f = d();
    private final boolean h = true;

    /* compiled from: CameraLiveConfigManager.kt */
    /* loaded from: classes2.dex */
    public static final class a extends com.google.gson.r.a<g> {
        a() {
        }
    }

    public h(Context context, String mainDeviceIdMD5) {
        List<ALCameraDevice> arrayList;
        j.e(context, "context");
        j.e(mainDeviceIdMD5, "mainDeviceIdMD5");
        this.i = context;
        this.j = mainDeviceIdMD5;
        this.f5315d = new b.d.w.g.a(context, "CameraLiveConfig");
        TPIoTClientManager tpCameraClientManager = (TPIoTClientManager) b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
        j.d(tpCameraClientManager, "tpCameraClientManager");
        MediatorLiveData<List<ALCameraDevice>> M1 = tpCameraClientManager.M1();
        this.f5316e = (M1 == null || (arrayList = M1.getValue()) == null) ? new ArrayList<>() : arrayList;
    }

    private final g d() {
        String f2 = this.f5315d.f(this.j, "");
        if (this.f5313b) {
            String str = this.a;
            b.d.w.c.a.c(str, "read:" + f2);
        }
        return (g) this.f5314c.m(f2, new a().getType());
    }

    private final void e(g gVar) {
        String u = this.f5314c.u(gVar);
        if (this.f5313b) {
            String str = this.a;
            b.d.w.c.a.c(str, "write:" + u);
        }
        this.f5315d.k(this.j, u);
    }

    public final ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            arrayList.add(null);
        }
        if (this.f5317f == null) {
            if (this.f5313b) {
                b.d.w.c.a.c(this.a, "get():无配置信息,直接返回");
            }
            arrayList.set(0, this.j);
            return arrayList;
        }
        for (ALCameraDevice aLCameraDevice : this.f5316e) {
            String deviceIdMD5 = aLCameraDevice.getDeviceIdMD5();
            this.g.add(deviceIdMD5);
            Integer num = this.f5317f.a().get(deviceIdMD5);
            if (num != null) {
                if (this.f5313b) {
                    String str = this.a;
                    b.d.w.c.a.c(str, "get():位置" + num + " -> 播放设备" + deviceIdMD5);
                }
                arrayList.set(num.intValue(), deviceIdMD5);
            }
        }
        return arrayList;
    }

    public final boolean b() {
        return this.h;
    }

    public final void c(boolean z, List<String> deviceIDMD5List) {
        String b2;
        j.e(deviceIDMD5List, "deviceIDMD5List");
        if (deviceIDMD5List.contains(this.j)) {
            HashMap hashMap = new HashMap();
            int size = deviceIDMD5List.size();
            for (int i = 0; i < size; i++) {
                String str = deviceIDMD5List.get(i);
                if (str != null) {
                    hashMap.put(str, Integer.valueOf(i));
                }
            }
            g gVar = this.f5317f;
            if (gVar != null) {
                HashMap<String, Integer> a2 = gVar.a();
                ArrayList arrayList = new ArrayList();
                for (String str2 : a2.keySet()) {
                    if (!this.g.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                if (this.f5313b) {
                    String str3 = this.a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("put(),unfoundedDeviceIDMD5List: ");
                    b2 = i.b(arrayList);
                    sb.append(b2);
                    b.d.w.c.a.c(str3, sb.toString());
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String deviceIDMD5 = (String) it.next();
                    Integer num = a2.get(deviceIDMD5);
                    if (num != null) {
                        j.d(num, "preMapping[deviceIDMD5] ?: return");
                        int intValue = num.intValue();
                        if (!hashMap.values().contains(Integer.valueOf(intValue))) {
                            j.d(deviceIDMD5, "deviceIDMD5");
                            hashMap.put(deviceIDMD5, Integer.valueOf(intValue));
                            if (this.f5313b) {
                                String str4 = this.a;
                                b.d.w.c.a.c(str4, "put():未扫描到的设备" + deviceIDMD5 + " -> 位置" + intValue);
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
            e(new g(z, hashMap));
        }
    }
}
