package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.text.TextUtils;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.push.NotificationMsgBean;
import com.tplink.cloud.bean.push.params.NotificationMsgIdListParams;
import com.tplink.cloud.bean.push.params.NotificationMsgTypeListParams;
import com.tplink.cloud.bean.push.params.NotificationParams;
import com.tplink.cloud.bean.push.params.PushInfoParams;
import com.tplink.cloud.bean.push.params.SubscribeItemParams;
import com.tplink.cloud.bean.push.params.UnsubscribeMsgParams;
import com.tplink.cloud.bean.push.result.NotificationMsgListResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.push.params.IoTSubscribeMsgParams;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.SubscribeItemBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class TCMessagePushRepository extends AbstractIoTCloudRepository {
    private b.d.b.c.e h;
    private com.tplink.iot.c.b.g i;
    private final List<SubscribeItemBean> j = new ArrayList();
    private boolean k = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements io.reactivex.g0.a {
        a() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            TCMessagePushRepository.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public void run() {
            TCMessagePushRepository.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements s<Boolean> {

        /* loaded from: classes3.dex */
        class a implements io.reactivex.g0.g<Throwable> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ r f13904c;

            a(r rVar) {
                this.f13904c = rVar;
            }

            /* renamed from: a */
            public void accept(Throwable th) throws Exception {
                this.f13904c.onError(th);
            }
        }

        /* loaded from: classes3.dex */
        class b implements io.reactivex.g0.a {
            final /* synthetic */ r a;

            b(r rVar) {
                this.a = rVar;
            }

            @Override // io.reactivex.g0.a
            public void run() throws Exception {
                this.a.onNext(Boolean.TRUE);
                this.a.onComplete();
            }
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ io.reactivex.e b(String str) throws Exception {
            TCMessagePushRepository tCMessagePushRepository = TCMessagePushRepository.this;
            return tCMessagePushRepository.A(str, tCMessagePushRepository.z()).C(io.reactivex.l0.a.c());
        }

        @Override // io.reactivex.s
        public void subscribe(r<Boolean> rVar) throws Exception {
            TCMessagePushRepository.this.d().R(new j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.g1
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return TCMessagePushRepository.c.this.b((String) obj);
                }
            }).C(io.reactivex.l0.a.c()).i(new b(rVar)).j(new a(rVar)).y();
        }
    }

    /* loaded from: classes3.dex */
    class d implements l<Throwable> {
        d() {
        }

        /* renamed from: a */
        public boolean test(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                CloudException cloudException = (CloudException) th;
                if (-2 == cloudException.getErrCode() && "retry_get_data".equals(cloudException.getMsg())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    class e implements j<NotificationMsgListResult, List<NotificationMsgBean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f13908c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ NotificationParams f13909d;

        e(List list, NotificationParams notificationParams) {
            this.f13908c = list;
            this.f13909d = notificationParams;
        }

        /* renamed from: a */
        public List<NotificationMsgBean> apply(NotificationMsgListResult notificationMsgListResult) throws Exception {
            if (notificationMsgListResult != null) {
                int total = notificationMsgListResult.getTotal();
                if (this.f13908c.size() >= total) {
                    Collections.reverse(this.f13908c);
                    return this.f13908c;
                }
                List<NotificationMsgBean> notifications = notificationMsgListResult.getNotifications();
                if (notifications != null && !notifications.isEmpty()) {
                    this.f13908c.addAll(notifications);
                }
                if (this.f13908c.size() >= total || !notificationMsgListResult.isHasNextPage()) {
                    Collections.reverse(this.f13908c);
                    return this.f13908c;
                }
                this.f13909d.setIndex(this.f13908c.size());
                throw new CloudException(-2, "retry_get_data");
            }
            throw new CloudException(-1, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements j<CloudResult<NotificationMsgListResult>, NotificationMsgListResult> {
        f() {
        }

        /* renamed from: a */
        public NotificationMsgListResult apply(CloudResult<NotificationMsgListResult> cloudResult) throws Exception {
            return cloudResult.getResult();
        }
    }

    /* loaded from: classes3.dex */
    class g implements j<CloudResult<Void>, Boolean> {
        g() {
        }

        /* renamed from: a */
        public Boolean apply(CloudResult<Void> cloudResult) throws Exception {
            return Boolean.valueOf(cloudResult.getErrorCode() == 0);
        }
    }

    public TCMessagePushRepository(com.tplink.iot.c.c.a aVar) {
        super(aVar);
        this.h = (b.d.b.c.e) aVar.d().R1(b.d.b.c.e.class);
        this.i = (com.tplink.iot.c.b.g) aVar.k().R1(com.tplink.iot.c.b.g.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.a A(String str, IoTSubscribeMsgParams ioTSubscribeMsgParams) {
        if (!TextUtils.isEmpty(o.h0().Q())) {
            return this.i.n0(str, ioTSubscribeMsgParams);
        }
        return io.reactivex.a.e();
    }

    private q<NotificationMsgListResult> F(NotificationParams notificationParams) {
        return this.h.b(new CloudParams<>("getAppNotificationByPage", notificationParams)).L0(io.reactivex.l0.a.c()).g0(new f());
    }

    private boolean I(String str, List<SubscribeItemBean> list) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (SubscribeItemBean subscribeItemBean : list) {
            if (str.equals(subscribeItemBean.getDeviceId())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ io.reactivex.e K(String str) throws Exception {
        return A(str, z()).C(io.reactivex.l0.a.c());
    }

    private void P(List<String> list, List<SubscribeItemBean> list2) {
        synchronized (this.j) {
            List<SubscribeItemBean> arrayList = new ArrayList<>();
            for (SubscribeItemBean subscribeItemBean : this.j) {
                if (list.contains(subscribeItemBean.getDeviceId())) {
                    arrayList.add(subscribeItemBean);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str : list) {
                if (str != null && !str.isEmpty() && !I(str, arrayList)) {
                    arrayList2.add(new SubscribeItemBean(str));
                }
            }
            arrayList.addAll(arrayList2);
            for (SubscribeItemBean subscribeItemBean2 : list2) {
                Iterator<SubscribeItemBean> it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        SubscribeItemBean next = it.next();
                        if (next.getDeviceId().equals(subscribeItemBean2.getDeviceId())) {
                            next.setDeviceSubscribeOffBit(subscribeItemBean2.getDeviceSubscribeOffBit());
                            break;
                        }
                    }
                }
            }
            this.j.clear();
            this.j.addAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IoTSubscribeMsgParams z() {
        IoTSubscribeMsgParams ioTSubscribeMsgParams;
        synchronized (this.j) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (SubscribeItemBean subscribeItemBean : this.j) {
                BaseALIoTDevice I1 = TPIoTClientManager.I1(b.d.w.h.a.g(subscribeItemBean.getDeviceId()));
                boolean isSubDevice = I1.isSubDevice();
                String deviceType = I1.getDeviceType();
                if (!isSubDevice) {
                    arrayList.add(new SubscribeItemParams(subscribeItemBean.getDeviceId(), subscribeItemBean.toSubscribeList(deviceType)));
                } else {
                    arrayList2.add(new SubscribeItemParams(subscribeItemBean.getDeviceId(), subscribeItemBean.toSubscribeList(deviceType)));
                }
            }
            ioTSubscribeMsgParams = new IoTSubscribeMsgParams(arrayList, arrayList2);
        }
        return ioTSubscribeMsgParams;
    }

    public io.reactivex.a B(NotificationMsgTypeListParams notificationMsgTypeListParams) {
        return this.h.c(new CloudParams<>("delAppNotification", notificationMsgTypeListParams)).Z().C(io.reactivex.l0.a.c());
    }

    public io.reactivex.a C(NotificationMsgIdListParams notificationMsgIdListParams) {
        return this.h.d(new CloudParams<>("delAppNotificationById", notificationMsgIdListParams)).Z().C(io.reactivex.l0.a.c());
    }

    public q<List<NotificationMsgBean>> D(NotificationParams notificationParams) {
        ArrayList arrayList = new ArrayList();
        notificationParams.setIndex(0);
        return F(notificationParams).g0(new e(arrayList, notificationParams)).w0(new d());
    }

    public SubscribeItemBean E(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (SubscribeItemBean subscribeItemBean : G()) {
            if (str.equals(subscribeItemBean.getDeviceId())) {
                return subscribeItemBean;
            }
        }
        return null;
    }

    public List<SubscribeItemBean> G() {
        ArrayList arrayList;
        synchronized (this.j) {
            arrayList = new ArrayList();
            for (SubscribeItemBean subscribeItemBean : this.j) {
                arrayList.add(com.tplink.libtpnetwork.Utils.e.a(subscribeItemBean));
            }
        }
        return arrayList;
    }

    public boolean H() {
        b.d.b.c.e eVar = this.h;
        return !(eVar instanceof b.d.b.b) || ((b.d.b.b) eVar).S1();
    }

    public void L() {
        synchronized (this.j) {
            TCAccountBean c2 = this.f100b.c();
            if (c2 != null) {
                String cloudUserName = c2.getCloudUserName();
                if (cloudUserName != null && !cloudUserName.isEmpty()) {
                    this.j.clear();
                    List d2 = com.tplink.libtpnetwork.Utils.s.d(cloudUserName + "_" + cloudUserName, "subscribed", "subscribedInfoList", SubscribeItemBean.class);
                    if (d2 != null && !d2.isEmpty()) {
                        this.j.addAll(d2);
                    }
                    if (this.k) {
                        this.k = false;
                        if (!o.h0().d0()) {
                            o.h0().Q0();
                            boolean isEmpty = this.j.isEmpty();
                            for (SubscribeItemBean subscribeItemBean : this.j) {
                                if (subscribeItemBean.isSubscribeNewFirmwareOld()) {
                                    isEmpty = true;
                                }
                                if (!subscribeItemBean.isSubscribeCameraMotionOld()) {
                                    subscribeItemBean.removeSubscribeFunc(EnumMsgSubscribeType.CAMERA_MOTION);
                                }
                            }
                            o.h0().g1(isEmpty);
                            o.h0().i1(true);
                        }
                    }
                }
            }
        }
    }

    public void M(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        N(str, i, str2, str3, str4, str5, str6).C(io.reactivex.l0.a.c()).y();
    }

    public io.reactivex.a N(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        return this.h.a(new CloudParams<>("postPushInfo", new PushInfoParams(str, i, str2, str3, str4, str5, str6, true))).Z();
    }

    public void O() {
        synchronized (this.j) {
            TCAccountBean c2 = this.f100b.c();
            if (c2 != null) {
                String cloudUserName = c2.getCloudUserName();
                if (cloudUserName != null && !cloudUserName.isEmpty()) {
                    com.tplink.libtpnetwork.Utils.s.k(cloudUserName + "_" + cloudUserName, this.j, "subscribed", "subscribedInfoList");
                }
            }
        }
    }

    public io.reactivex.a Q(List<String> list) {
        List<SubscribeItemBean> arrayList = new ArrayList<>();
        List<SubscribeItemBean> G = G();
        if (G.size() == 0) {
            for (String str : list) {
                arrayList.add(new SubscribeItemBean(str));
            }
        } else {
            arrayList.addAll(G);
        }
        return R(list, arrayList);
    }

    public io.reactivex.a R(List<String> list, List<SubscribeItemBean> list2) {
        P(list, list2);
        return d().R(new j() { // from class: com.tplink.libtpnetwork.TPCloudNetwork.repository.h1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return TCMessagePushRepository.this.K((String) obj);
            }
        }).C(io.reactivex.l0.a.c()).s().h(new a());
    }

    public q<Boolean> S(String str, SubscribeItemBean subscribeItemBean) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        synchronized (this.j) {
            for (SubscribeItemBean subscribeItemBean2 : this.j) {
                arrayList2.add(subscribeItemBean2.getDeviceId());
            }
            if (!arrayList2.contains(str)) {
                arrayList2.add(str);
            }
            arrayList = new ArrayList(this.j);
            Iterator<SubscribeItemBean> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getDeviceId().equals(str)) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            arrayList.add(subscribeItemBean);
        }
        P(arrayList2, arrayList);
        return q.m(new c()).q0(Boolean.TRUE).L0(io.reactivex.l0.a.c()).y(new b());
    }

    public q<Boolean> T(UnsubscribeMsgParams unsubscribeMsgParams) {
        return this.h.e(new CloudParams<>("unsubscribeNotification", unsubscribeMsgParams)).g0(new g()).L0(io.reactivex.l0.a.c());
    }
}
