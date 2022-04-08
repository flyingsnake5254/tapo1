package com.tplink.libtpnetwork.Utils;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.i;
import com.google.gson.k;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTResponse;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.IoTSubResponse;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.exception.IoTException;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import java.util.Iterator;

/* compiled from: RxUtils.java */
/* loaded from: classes3.dex */
public class n {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxUtils.java */
    /* loaded from: classes3.dex */
    public static class a implements u<TPIoTResponse, IoTResult<T>> {
        final /* synthetic */ Class a;

        /* compiled from: RxUtils.java */
        /* renamed from: com.tplink.libtpnetwork.Utils.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0274a implements j<TPIoTResponse, IoTResult<T>> {
            C0274a() {
            }

            /* renamed from: a */
            public IoTResult<T> apply(TPIoTResponse tPIoTResponse) throws Exception {
                IoTResult ioTResult = (IoTResult) i.b(tPIoTResponse.getResult(), new h(IoTResult.class, new Class[]{a.this.a}, null));
                IoTResult ioTResult2 = ioTResult;
                if (ioTResult == null) {
                    ioTResult2 = new IoTResult();
                }
                if (ioTResult2.getErrCode() == 0) {
                    return ioTResult2;
                }
                throw new IoTException(ioTResult2.getErrCode(), ioTResult2.getMsg());
            }
        }

        /* compiled from: RxUtils.java */
        /* loaded from: classes3.dex */
        class b implements l<TPIoTResponse> {
            b() {
            }

            /* renamed from: a */
            public boolean test(TPIoTResponse tPIoTResponse) throws Exception {
                if (tPIoTResponse.getErrorCode() == 0) {
                    return true;
                }
                throw new TPGeneralNetworkException(tPIoTResponse.getErrorCode(), tPIoTResponse.getErrorMsg());
            }
        }

        a(Class cls) {
            this.a = cls;
        }

        @Override // io.reactivex.u
        public t<IoTResult<T>> a(q<TPIoTResponse> qVar) {
            return qVar.L(new b()).g0(new C0274a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxUtils.java */
    /* loaded from: classes3.dex */
    public static class b implements u<i, IoTSubResponse<T>> {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f14080b;

        /* compiled from: RxUtils.java */
        /* loaded from: classes3.dex */
        class a implements j<i, IoTSubResponse<T>> {
            a() {
            }

            /* renamed from: a */
            public IoTSubResponse<T> apply(i iVar) throws Exception {
                try {
                    k c2 = iVar.c().n("responseData").c();
                    if (c2 != null) {
                        Iterator<i> it = c2.c().n(ThingModelDefine.Service.OUTPUT_PARAMS_RESULT).c().n("responses").b().iterator();
                        while (it.hasNext()) {
                            i next = it.next();
                            if (TextUtils.equals(next.c().n(FirebaseAnalytics.Param.METHOD).e(), b.this.a)) {
                                int a = next.c().n("error_code").a();
                                if (a == 0) {
                                    return new IoTSubResponse<>(a, b.this.a, i.b(next.c().n(ThingModelDefine.Service.OUTPUT_PARAMS_RESULT) != null ? next.c().n(ThingModelDefine.Service.OUTPUT_PARAMS_RESULT).toString() : null, b.this.f14080b));
                                }
                                throw new IoTException(a, null);
                            }
                        }
                        throw new IoTException(-1, null);
                    }
                    throw new IoTException(1200, null);
                } catch (Exception e2) {
                    if (e2 instanceof IoTException) {
                        throw e2;
                    }
                    throw new IoTException(-1, null);
                }
            }
        }

        b(String str, Class cls) {
            this.a = str;
            this.f14080b = cls;
        }

        @Override // io.reactivex.u
        public t<IoTSubResponse<T>> a(q<i> qVar) {
            if (qVar == null) {
                return q.J(new IoTTransportException(1200));
            }
            return qVar.g0(new a());
        }
    }

    public static <T> u<TPIoTResponse, IoTResult<T>> a(Class<T> cls) {
        return new a(cls);
    }

    public static <T> u<i, IoTSubResponse<T>> b(String str, Class<T> cls) {
        return new b(str, cls);
    }
}
