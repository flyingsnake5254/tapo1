package com.tplink.libtpnetwork.IoTNetwork.transport.remote.MultiRequest;

import android.text.TextUtils;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTRequest;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTResponse;
import com.tplink.libtpnetwork.IoTNetwork.transport.remote.MultiRequest.RequestMethod;
import io.reactivex.g;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MultiRequestQueue.java */
/* loaded from: classes3.dex */
public class a {
    private volatile CopyOnWriteArrayList<TPIoTRequest> a = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private volatile ArrayList<TPIoTRequest> f13624b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<TPIoTRequest, List<g<TPIoTResponse>>> f13625c = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiRequestQueue.java */
    /* renamed from: com.tplink.libtpnetwork.IoTNetwork.transport.remote.MultiRequest.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0264a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RequestMethod.RequestMethodType.values().length];
            a = iArr;
            try {
                iArr[RequestMethod.RequestMethodType.REPLACE_DIRECT_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RequestMethod.RequestMethodType.REPLACE_COMBINE_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RequestMethod.RequestMethodType.NOT_REPLACE_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private TPIoTRequest c() {
        TPIoTRequest tPIoTRequest = new TPIoTRequest();
        MultiRequestBean multiRequestBean = new MultiRequestBean();
        tPIoTRequest.setMethod("multipleRequest");
        ArrayList arrayList = new ArrayList();
        this.f13624b.clear();
        if (!this.a.isEmpty()) {
            if (!RequestMethod.b(this.a.get(0).getMethod())) {
                TPIoTRequest tPIoTRequest2 = this.a.get(0);
                this.f13624b.add(this.a.remove(0));
                return tPIoTRequest2;
            }
            Iterator<TPIoTRequest> it = this.a.iterator();
            while (it.hasNext() && arrayList.size() <= 3) {
                TPIoTRequest next = it.next();
                if (RequestMethod.b(next.getMethod()) && !j(arrayList, next)) {
                    q(arrayList, next);
                    this.a.remove(0);
                }
            }
        }
        this.f13624b.addAll(arrayList);
        multiRequestBean.setRequests(arrayList);
        tPIoTRequest.setParams(multiRequestBean);
        return tPIoTRequest;
    }

    private boolean d(TPIoTRequest tPIoTRequest, TPIoTRequest tPIoTRequest2) {
        if (this.f13625c.isEmpty()) {
            return false;
        }
        List<g<TPIoTResponse>> list = this.f13625c.get(tPIoTRequest);
        List<g<TPIoTResponse>> list2 = this.f13625c.get(tPIoTRequest2);
        if (list == null) {
            return false;
        }
        list.addAll(list2);
        this.f13625c.remove(tPIoTRequest2);
        return true;
    }

    private Object e(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return obj;
        }
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        Field[] declaredFields2 = cls2.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            Field field2 = declaredFields2[i];
            field.setAccessible(true);
            field2.setAccessible(true);
            try {
                if (field.get(obj) != null) {
                    field2.set(obj2, field.get(obj));
                }
            } catch (IllegalAccessException | IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        return obj2;
    }

    private void f(Throwable th, TPIoTRequest tPIoTRequest) {
        List<g<TPIoTResponse>> list = this.f13625c.get(tPIoTRequest);
        if (!(list == null || list.size() == 0)) {
            for (g<TPIoTResponse> gVar : list) {
                gVar.onError(th);
            }
        }
    }

    private void g(TPIoTResponse tPIoTResponse, TPIoTRequest tPIoTRequest) {
        List<g<TPIoTResponse>> list = this.f13625c.get(tPIoTRequest);
        if (!(list == null || list.size() == 0)) {
            for (g<TPIoTResponse> gVar : list) {
                gVar.onNext(tPIoTResponse);
                gVar.onComplete();
            }
        }
    }

    private boolean j(List<TPIoTRequest> list, TPIoTRequest tPIoTRequest) {
        return TextUtils.equals(RequestMethod.a(tPIoTRequest.getMethod()).toString(), RequestMethod.RequestMethodType.NOT_REPLACE_TYPE.toString()) && k(list, tPIoTRequest);
    }

    private boolean k(List<TPIoTRequest> list, TPIoTRequest tPIoTRequest) {
        if (list != null && !list.isEmpty()) {
            for (TPIoTRequest tPIoTRequest2 : list) {
                if (TextUtils.equals(tPIoTRequest2.getMethod(), tPIoTRequest.getMethod())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void o(List<TPIoTRequest> list, TPIoTRequest tPIoTRequest) {
        if (list.isEmpty()) {
            list.add(tPIoTRequest);
            return;
        }
        Iterator<TPIoTRequest> it = list.iterator();
        while (it.hasNext()) {
            TPIoTRequest next = it.next();
            if (TextUtils.equals(next.getMethod(), tPIoTRequest.getMethod())) {
                it.remove();
                tPIoTRequest.setParams(e(tPIoTRequest.getParams(), next.getParams()));
                d(tPIoTRequest, next);
            }
        }
        list.add(tPIoTRequest);
    }

    private void p(List<TPIoTRequest> list, TPIoTRequest tPIoTRequest) {
        if (list.isEmpty()) {
            list.add(tPIoTRequest);
            return;
        }
        for (TPIoTRequest tPIoTRequest2 : list) {
            if (TextUtils.equals(tPIoTRequest2.getMethod(), tPIoTRequest.getMethod()) && d(tPIoTRequest2, tPIoTRequest)) {
                return;
            }
        }
        list.add(tPIoTRequest);
    }

    private void q(List<TPIoTRequest> list, TPIoTRequest tPIoTRequest) {
        int i = C0264a.a[RequestMethod.a(tPIoTRequest.getMethod()).ordinal()];
        if (i == 1) {
            p(list, tPIoTRequest);
        } else if (i == 2) {
            o(list, tPIoTRequest);
        } else if (i != 3) {
            list.add(tPIoTRequest);
        } else {
            list.add(tPIoTRequest);
        }
    }

    public void a(TPIoTRequest tPIoTRequest) {
        this.a.add(tPIoTRequest);
    }

    public void b(TPIoTRequest tPIoTRequest, List<g<TPIoTResponse>> list) {
        this.f13625c.put(tPIoTRequest, list);
    }

    public synchronized TPIoTRequest h() {
        return c();
    }

    public boolean i() {
        return this.a.isEmpty();
    }

    public boolean l() {
        Iterator<TPIoTRequest> it = this.f13624b.iterator();
        while (it.hasNext()) {
            if (!RequestMethod.b(it.next().getMethod())) {
                return false;
            }
        }
        return true;
    }

    public void m(Throwable th) {
        if (!this.f13624b.isEmpty() && !this.f13625c.isEmpty()) {
            Iterator<TPIoTRequest> it = this.f13624b.iterator();
            while (it.hasNext()) {
                TPIoTRequest next = it.next();
                f(th, next);
                it.remove();
                this.f13625c.remove(next);
            }
        }
    }

    public void n(TPIoTResponse tPIoTResponse) {
        if (!this.f13624b.isEmpty() && !this.f13625c.isEmpty()) {
            g(tPIoTResponse, this.f13624b.get(0));
            this.f13625c.remove(this.f13624b.remove(0));
        }
    }
}
