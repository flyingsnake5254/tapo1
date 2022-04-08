package com.tplink.libtpnetwork.TDPNetwork;

import android.app.Application;
import android.net.Network;
import android.util.Base64;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.camera.TDPCameraDiscoverRequest;
import com.tplink.libtpnetwork.TDPNetwork.bean.camera.TDPCameraEncryptResult;
import com.tplink.libtpnetwork.TDPNetwork.bean.camera.TDPCameraResult;
import com.tplink.libtpnetwork.TDPNetwork.bean.iot.CommonTDPResult;
import com.tplink.libtpnetwork.TDPNetwork.bean.iot.TDPIoTResult;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.tdp.bean.BaseTDPDevice;
import io.reactivex.q;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/* compiled from: TDPNetworkService.java */
/* loaded from: classes3.dex */
public class a {
    private Application a;

    /* renamed from: b  reason: collision with root package name */
    private io.reactivex.e0.b f13694b;

    /* renamed from: c  reason: collision with root package name */
    private com.tplink.libtpnetwork.cameranetwork.util.b f13695c;

    /* renamed from: d  reason: collision with root package name */
    private b.d.c0.k f13696d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TDPNetworkService.java */
    /* renamed from: com.tplink.libtpnetwork.TDPNetwork.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0272a implements io.reactivex.g0.j<List<TDPCameraResult>, Map<String, TDPCameraDevice>> {
        C0272a() {
        }

        /* renamed from: a */
        public Map<String, TDPCameraDevice> apply(List<TDPCameraResult> list) throws Exception {
            HashMap hashMap = new HashMap();
            for (TDPCameraResult tDPCameraResult : list) {
                TDPCameraDevice i = a.this.i(tDPCameraResult);
                hashMap.put(i.getDeviceIdMd5(), i);
            }
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TDPNetworkService.java */
    /* loaded from: classes3.dex */
    public class b implements io.reactivex.g0.j<List<TDPCameraResult>, List<TDPCameraResult>> {
        b() {
        }

        /* renamed from: a */
        public List<TDPCameraResult> apply(List<TDPCameraResult> list) throws Exception {
            return a.this.m(list);
        }
    }

    /* compiled from: TDPNetworkService.java */
    /* loaded from: classes3.dex */
    class c implements io.reactivex.g0.j<List<TDPCameraResult>, Map<String, TDPCameraDevice>> {
        c() {
        }

        /* renamed from: a */
        public Map<String, TDPCameraDevice> apply(List<TDPCameraResult> list) throws Exception {
            HashMap hashMap = new HashMap();
            for (TDPCameraResult tDPCameraResult : list) {
                TDPCameraDevice i = a.this.i(tDPCameraResult);
                hashMap.put(i.getDeviceIdMd5(), i);
            }
            return hashMap;
        }
    }

    /* compiled from: TDPNetworkService.java */
    /* loaded from: classes3.dex */
    class d implements io.reactivex.g0.j<List<TDPCameraResult>, List<TDPCameraResult>> {
        d() {
        }

        /* renamed from: a */
        public List<TDPCameraResult> apply(List<TDPCameraResult> list) throws Exception {
            return a.this.m(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TDPNetworkService.java */
    /* loaded from: classes3.dex */
    public class e implements io.reactivex.g0.j<List<CommonTDPResult>, Map<String, ? extends TDPIoTDevice>> {
        e() {
        }

        /* renamed from: a */
        public Map<String, ? extends TDPIoTDevice> apply(List<CommonTDPResult> list) throws Exception {
            HashMap hashMap = new HashMap();
            for (CommonTDPResult commonTDPResult : list) {
                TDPIoTDevice h = a.this.h(commonTDPResult);
                hashMap.put(h.getDeviceIdMd5(), h);
            }
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TDPNetworkService.java */
    /* loaded from: classes3.dex */
    public class f implements io.reactivex.g0.j<List<CommonTDPResult>, List<CommonTDPResult>> {
        f() {
        }

        /* renamed from: a */
        public List<CommonTDPResult> apply(List<CommonTDPResult> list) throws Exception {
            return a.this.l(list, b.d.s.c.a.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TDPNetworkService.java */
    /* loaded from: classes3.dex */
    public class g implements io.reactivex.g0.j<List<CommonTDPResult>, Map<String, ? extends TDPIoTDevice>> {
        g() {
        }

        /* renamed from: a */
        public Map<String, ? extends TDPIoTDevice> apply(List<CommonTDPResult> list) throws Exception {
            HashMap hashMap = new HashMap();
            for (CommonTDPResult commonTDPResult : list) {
                TDPIoTDevice h = a.this.h(commonTDPResult);
                hashMap.put(h.getDeviceIdMd5(), h);
            }
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TDPNetworkService.java */
    /* loaded from: classes3.dex */
    public class h implements io.reactivex.g0.j<List<CommonTDPResult>, List<CommonTDPResult>> {
        h() {
        }

        /* renamed from: a */
        public List<CommonTDPResult> apply(List<CommonTDPResult> list) throws Exception {
            return a.this.l(list, b.d.s.c.a.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TDPNetworkService.java */
    /* loaded from: classes3.dex */
    public class i implements io.reactivex.g0.j<List<TDPIoTResult>, Map<String, TDPIoTDevice>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f13705c;

        i(List list) {
            this.f13705c = list;
        }

        /* renamed from: a */
        public Map<String, TDPIoTDevice> apply(List<TDPIoTResult> list) throws Exception {
            return a.this.n(list, this.f13705c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TDPNetworkService.java */
    /* loaded from: classes3.dex */
    public class j implements io.reactivex.g0.g<io.reactivex.e0.c> {
        j() {
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            a.this.f13694b.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TDPNetworkService.java */
    /* loaded from: classes3.dex */
    public static class k {
        private static final a a = new a(null);
    }

    /* synthetic */ a(e eVar) {
        this();
    }

    private <T extends BaseTDPDevice> q<List<T>> g(com.tplink.tdp.common.c<T> cVar) {
        b.d.c0.k kVar = new b.d.c0.k(this.a, true);
        this.f13696d = kVar;
        return kVar.D(cVar).n(new ArrayList()).q0(new ArrayList()).F(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TDPIoTDevice h(CommonTDPResult commonTDPResult) {
        if (EnumDeviceType.fromType(commonTDPResult.getDeviceType()) == EnumDeviceType.CAMERA) {
            return j(commonTDPResult);
        }
        return new TDPIoTDevice(commonTDPResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TDPCameraDevice i(TDPCameraResult tDPCameraResult) {
        TDPCameraDevice tDPCameraDevice = new TDPCameraDevice();
        tDPCameraDevice.setDeviceName(tDPCameraResult.getDeviceName());
        tDPCameraDevice.setFirmwareVer(tDPCameraResult.getFirmwareVer());
        tDPCameraDevice.setHardwareVer(tDPCameraResult.getHardwareVer());
        tDPCameraDevice.setIp(tDPCameraResult.getIp());
        tDPCameraDevice.setMac(com.tplink.libtpnetwork.cameranetwork.util.f.a(tDPCameraResult.getMac()));
        tDPCameraDevice.setDeviceModel(tDPCameraResult.getDeviceModel());
        tDPCameraDevice.setResetWiFi(tDPCameraResult.isResetWiFi());
        tDPCameraDevice.setSupportIoTCloud(tDPCameraResult.isSupportIoTCloud());
        k(tDPCameraDevice, tDPCameraResult.getEncryptedInfo().getKey(), tDPCameraResult.getEncryptedInfo().getData());
        return tDPCameraDevice;
    }

    private TDPCameraDevice j(CommonTDPResult commonTDPResult) {
        TDPCameraDevice tDPCameraDevice = new TDPCameraDevice();
        tDPCameraDevice.setDeviceName(commonTDPResult.getDeviceName());
        tDPCameraDevice.setFirmwareVer(commonTDPResult.getFirmwareVer());
        tDPCameraDevice.setHardwareVer(commonTDPResult.getHardwareVer());
        tDPCameraDevice.setIp(commonTDPResult.getIp());
        tDPCameraDevice.setMac(com.tplink.libtpnetwork.cameranetwork.util.f.a(commonTDPResult.getMac()));
        tDPCameraDevice.setDeviceModel(commonTDPResult.getDeviceModel());
        tDPCameraDevice.setResetWiFi(commonTDPResult.isResetWiFi());
        tDPCameraDevice.setSupportIoTCloud(commonTDPResult.isSupportIoTCloud());
        k(tDPCameraDevice, commonTDPResult.getEncryptedInfo().getKey(), commonTDPResult.getEncryptedInfo().getData());
        return tDPCameraDevice;
    }

    private void k(TDPCameraDevice tDPCameraDevice, String str, String str2) {
        try {
            byte[] a = com.tplink.libtpnetwork.cameranetwork.util.g.b().a(Base64.decode(str, 2));
            byte[] decode = Base64.decode(str2, 2);
            this.f13695c.c(Arrays.copyOfRange(a, 0, 16), Arrays.copyOfRange(a, 16, 32));
            byte[] bArr = new byte[4096];
            TDPCameraEncryptResult tDPCameraEncryptResult = (TDPCameraEncryptResult) com.tplink.libtpnetwork.Utils.i.b(new String(bArr, 0, this.f13695c.a(decode, bArr, decode.length)), TDPCameraEncryptResult.class);
            tDPCameraDevice.setConnectSsid(tDPCameraEncryptResult.getConnectSsid());
            tDPCameraDevice.setConnectType(tDPCameraEncryptResult.getConnectType());
            tDPCameraDevice.setDeviceId(tDPCameraEncryptResult.getDeviceId());
            tDPCameraDevice.setDeviceIdMd5(b.d.w.h.a.g(tDPCameraEncryptResult.getDeviceId()));
            tDPCameraDevice.setHttpPort(tDPCameraEncryptResult.getHttpPort());
            tDPCameraDevice.setLastAlarmTime(tDPCameraEncryptResult.getLastAlarmTime());
            tDPCameraDevice.setLastAlarmType(tDPCameraEncryptResult.getLastAlarmType());
            tDPCameraDevice.setOwner(tDPCameraEncryptResult.getOwner());
            tDPCameraDevice.setSdStatus(tDPCameraEncryptResult.getSdStatus());
        } catch (InvalidAlgorithmParameterException e2) {
            e2.printStackTrace();
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
        } catch (BadPaddingException e4) {
            e4.printStackTrace();
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<CommonTDPResult> l(List<CommonTDPResult> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        for (CommonTDPResult commonTDPResult : list) {
            if (list2.contains(commonTDPResult.getDeviceType())) {
                arrayList.add(commonTDPResult);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TDPCameraResult> m(List<TDPCameraResult> list) {
        ArrayList arrayList = new ArrayList();
        for (TDPCameraResult tDPCameraResult : list) {
            if (EnumDeviceType.CAMERA.getDeviceType().equals(tDPCameraResult.getDeviceType())) {
                arrayList.add(tDPCameraResult);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, TDPIoTDevice> n(List<TDPIoTResult> list, List<String> list2) {
        HashMap hashMap = new HashMap();
        for (TDPIoTResult tDPIoTResult : list) {
            String deviceIdMd5 = tDPIoTResult.getDeviceIdMd5();
            if (deviceIdMd5 != null && !deviceIdMd5.isEmpty() && list2.contains(tDPIoTResult.getDeviceType())) {
                hashMap.put(deviceIdMd5, new TDPIoTDevice(tDPIoTResult));
            }
        }
        return hashMap;
    }

    private com.tplink.tdp.common.c<TDPCameraResult> o(int i2, int i3, int i4) {
        com.tplink.tdp.common.c<TDPCameraResult> cVar = new com.tplink.tdp.common.c<>((byte) 2, TDPCameraResult.class, "255.255.255.255", i2, i3, i4);
        try {
            cVar.j(com.tplink.libtpnetwork.Utils.i.f(new TDPCameraDiscoverRequest(com.tplink.libtpnetwork.cameranetwork.util.g.b().c())));
        } catch (IOException e2) {
            b.d.w.c.a.e(a.class.toString(), e2.toString());
        }
        return cVar;
    }

    private com.tplink.tdp.common.c<CommonTDPResult> p(int i2, int i3, int i4) {
        com.tplink.tdp.common.c<CommonTDPResult> cVar = new com.tplink.tdp.common.c<>((byte) 2, CommonTDPResult.class, "255.255.255.255", i2, i3, i4);
        try {
            cVar.j(com.tplink.libtpnetwork.Utils.i.f(new TDPCameraDiscoverRequest(com.tplink.libtpnetwork.cameranetwork.util.g.b().c())));
        } catch (IOException e2) {
            b.d.w.c.a.e(a.class.toString(), e2.toString());
        }
        return cVar;
    }

    public static a q() {
        return k.a;
    }

    public void A() {
        this.f13694b.d();
    }

    public Network r() {
        b.d.c0.k kVar = this.f13696d;
        if (kVar == null) {
            return null;
        }
        return kVar.d();
    }

    public void s(Application application) {
        this.a = application;
    }

    public q<Map<String, ? extends TDPIoTDevice>> t(int i2, int i3, int i4) {
        return g(p(i2, i3, i4)).R0(1).g0(new f()).g0(new e());
    }

    public q<Map<String, ? extends TDPIoTDevice>> u() {
        return v(8, 300, 900);
    }

    public q<Map<String, ? extends TDPIoTDevice>> v(int i2, int i3, int i4) {
        return g(p(i2, i3, i4)).g0(new h()).g0(new g());
    }

    public q<Map<String, TDPCameraDevice>> w(int i2, int i3, int i4) {
        return g(o(i2, i3, i4)).R0(1).g0(new b()).g0(new C0272a());
    }

    public q<Map<String, TDPCameraDevice>> x(int i2, int i3, int i4) {
        return g(o(i2, i3, i4)).g0(new d()).g0(new c());
    }

    public q<Map<String, TDPIoTDevice>> y(String str, int i2, int i3, int i4) {
        return z(str, i2, i3, i4, b.d.s.c.a.e());
    }

    public q<Map<String, TDPIoTDevice>> z(String str, int i2, int i3, int i4, List<String> list) {
        return g(new com.tplink.tdp.common.c((byte) 2, TDPIoTResult.class, str, i2, i3, i4)).g0(new i(list));
    }

    private a() {
        this.f13694b = new io.reactivex.e0.b();
        this.f13695c = new com.tplink.libtpnetwork.cameranetwork.util.b();
    }
}
