package com.tplink.libtpnetwork.IoTNetwork.repository.kb;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HolderIoTDeviceContext.java */
/* loaded from: classes3.dex */
public class a implements g {
    private static final b a = new b();

    /* renamed from: b  reason: collision with root package name */
    private f f13332b = new f();

    /* compiled from: HolderIoTDeviceContext.java */
    /* loaded from: classes3.dex */
    static class b {
        private Map<TPBaseDeviceContext, a> a;

        void a(TPBaseDeviceContext tPBaseDeviceContext) {
            a remove;
            if (tPBaseDeviceContext != null && (remove = this.a.remove(tPBaseDeviceContext)) != null) {
                remove.e();
            }
        }

        a b(TPBaseDeviceContext tPBaseDeviceContext) {
            a aVar = this.a.get(tPBaseDeviceContext);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.a.put(tPBaseDeviceContext, aVar2);
            return aVar2;
        }

        private b() {
            this.a = new HashMap();
        }
    }

    public static void c(TPBaseDeviceContext tPBaseDeviceContext) {
        a.a(tPBaseDeviceContext);
    }

    public static a d(TPBaseDeviceContext tPBaseDeviceContext) {
        return a.b(tPBaseDeviceContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f13332b.a();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.g
    @NonNull
    public f a() {
        return this.f13332b;
    }
}
