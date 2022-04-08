package com.tplink.tpble;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.os.Build;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.m0.d;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* compiled from: BLEScanClient.java */
/* loaded from: classes3.dex */
class u {
    private BluetoothAdapter a;

    /* renamed from: b  reason: collision with root package name */
    private v f15260b;

    /* renamed from: e  reason: collision with root package name */
    private g<List<t>> f15263e;

    /* renamed from: f  reason: collision with root package name */
    private b f15264f;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f15261c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<t> f15262d = new ArrayList();
    private BluetoothAdapter.LeScanCallback g = new a();

    /* compiled from: BLEScanClient.java */
    /* loaded from: classes3.dex */
    class a implements BluetoothAdapter.LeScanCallback {
        a() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (Build.VERSION.SDK_INT < 21) {
                List u = u.this.u(bArr);
                u uVar = u.this;
                if (!uVar.i(u, uVar.f15260b.a())) {
                    return;
                }
            }
            if (bluetoothDevice != null && bluetoothDevice.getAddress() != null && !u.this.f15261c.contains(bluetoothDevice.getAddress())) {
                u.this.f15261c.add(bluetoothDevice.getAddress());
                u.this.f15262d.add(new t(i, bluetoothDevice));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Application application, v vVar) {
        BluetoothManager bluetoothManager = (BluetoothManager) application.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            this.a = bluetoothManager.getAdapter();
        }
        this.f15260b = vVar;
        this.f15263e = d.n1();
        this.f15264f = new b();
    }

    private List<t> f() {
        if (!this.f15262d.isEmpty()) {
            Collections.sort(this.f15262d, i.f15244c);
        }
        return this.f15262d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.f15263e.j1() && !this.f15263e.k1()) {
            this.f15263e.onComplete();
        }
        b bVar = this.f15264f;
        if (bVar != null) {
            bVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Throwable th) {
        if (!this.f15263e.j1() && !this.f15263e.k1()) {
            this.f15263e.onError(th);
        }
        b bVar = this.f15264f;
        if (bVar != null) {
            bVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(List<UUID> list, String str) {
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).toString().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int l(t tVar, t tVar2) {
        return tVar2.b() - tVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(c cVar) throws Exception {
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(Long l) throws Exception {
        List<t> f2 = f();
        if (!f2.isEmpty()) {
            this.f15263e.onNext(f2);
            g();
        } else if (l.longValue() == 1) {
            this.f15263e.onNext(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ t r(Boolean bool) throws Exception {
        w();
        return this.f15263e.l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t() throws Exception {
        g();
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<UUID> u(byte[] bArr) {
        byte b2;
        ArrayList arrayList = new ArrayList();
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        while (order.remaining() > 2 && (b2 = order.get()) != 0) {
            byte b3 = order.get();
            if (b3 == 2 || b3 == 3) {
                while (b2 >= 2) {
                    arrayList.add(UUID.fromString(String.format("%08x-0000-1000-8000-00805f9b34fb", Short.valueOf(order.getShort()))));
                    b2 = (byte) (b2 - 2);
                }
            } else if (b3 == 6 || b3 == 7) {
                while (b2 >= 16) {
                    arrayList.add(new UUID(order.getLong(), order.getLong()));
                    b2 = (byte) (b2 - 16);
                }
            } else {
                order.position((order.position() + b2) - 1);
            }
        }
        return arrayList;
    }

    private void v() {
        if (Build.VERSION.SDK_INT >= 21) {
            UUID[] uuidArr = {UUID.fromString(this.f15260b.a())};
            BluetoothAdapter bluetoothAdapter = this.a;
            if (bluetoothAdapter != null) {
                bluetoothAdapter.startLeScan(uuidArr, this.g);
                return;
            }
            return;
        }
        BluetoothAdapter bluetoothAdapter2 = this.a;
        if (bluetoothAdapter2 != null) {
            bluetoothAdapter2.startLeScan(this.g);
        }
    }

    private void w() {
        this.f15264f.b(q.c0(5000L, TimeUnit.MILLISECONDS).Q0(2L).F(new io.reactivex.g0.g() { // from class: com.tplink.tpble.c
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                u.this.n((io.reactivex.e0.c) obj);
            }
        }).I0(new io.reactivex.g0.g() { // from class: com.tplink.tpble.e
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                u.this.p((Long) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.tpble.f
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                u.this.h((Throwable) obj);
            }
        }, new io.reactivex.g0.a() { // from class: com.tplink.tpble.g
            @Override // io.reactivex.g0.a
            public final void run() {
                u.this.g();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q<List<t>> x() {
        return q.f0(Boolean.TRUE).N(new j() { // from class: com.tplink.tpble.d
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return u.this.r((Boolean) obj);
            }
        }).q0(new ArrayList()).y(new io.reactivex.g0.a() { // from class: com.tplink.tpble.h
            @Override // io.reactivex.g0.a
            public final void run() {
                u.this.t();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        BluetoothAdapter bluetoothAdapter = this.a;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.stopLeScan(this.g);
        }
    }
}
