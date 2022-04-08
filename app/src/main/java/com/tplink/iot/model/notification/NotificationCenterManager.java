package com.tplink.iot.model.notification;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.push.EnumNotificationDirection;
import com.tplink.cloud.bean.push.NotificationMsgBean;
import com.tplink.cloud.bean.push.params.NotificationMsgIdListParams;
import com.tplink.cloud.bean.push.params.NotificationMsgIdParams;
import com.tplink.cloud.bean.push.params.NotificationMsgTypeListParams;
import com.tplink.cloud.bean.push.params.NotificationMsgTypeParams;
import com.tplink.cloud.bean.push.params.NotificationParams;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.s;
import com.tplink.iot.model.notification.NotificationCenterManager;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.NotificationMsgCacheBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.Utils.x;
import com.tplink.libtpnetwork.enumerate.EnumNotificationMsgType;
import io.reactivex.b;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class NotificationCenterManager extends b.d.b.f.a {

    /* renamed from: c  reason: collision with root package name */
    private static Comparator<NotificationMsgBean> f8173c = new c();

    /* renamed from: d  reason: collision with root package name */
    private TCMessagePushRepository f8174d;
    private String l;

    /* renamed from: e  reason: collision with root package name */
    private MutableLiveData<List<NotificationMsgBean>> f8175e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<Boolean> f8176f = new MutableLiveData<>();
    private MutableLiveData<Boolean> g = new MutableLiveData<>();
    private long h = -1;
    private boolean i = false;
    private Map<String, NotificationMsgBean> j = Collections.synchronizedMap(new LinkedHashMap());
    private Map<String, NotificationMsgBean> k = Collections.synchronizedMap(new LinkedHashMap());
    private Set<String> m = new HashSet();
    private AtomicInteger n = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements io.reactivex.g0.a {
        a() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            NotificationCenterManager.this.n.decrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements io.reactivex.g0.a {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            NotificationCenterManager.this.N(this.a);
        }
    }

    /* loaded from: classes2.dex */
    static class c implements Comparator<NotificationMsgBean> {
        c() {
        }

        /* renamed from: a */
        public int compare(NotificationMsgBean notificationMsgBean, NotificationMsgBean notificationMsgBean2) {
            if (notificationMsgBean2.getTime() > notificationMsgBean.getTime()) {
                return 1;
            }
            if (notificationMsgBean2.getTime() == notificationMsgBean.getTime()) {
                if (notificationMsgBean2.isReadFlag() && !notificationMsgBean.isReadFlag()) {
                    return 1;
                }
                if (notificationMsgBean2.isReadFlag() == notificationMsgBean.isReadFlag()) {
                    return 0;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumNotificationMsgType.values().length];
            a = iArr;
            try {
                iArr[EnumNotificationMsgType.SHARE_LAUNCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumNotificationMsgType.NEW_FIRMWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumNotificationMsgType.FFS_NEW_DEVICE_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumNotificationMsgType.DEVICE_ACTIVITY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumNotificationMsgType.MOTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumNotificationMsgType.AUDIO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[EnumNotificationMsgType.PERSON_DETECTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[EnumNotificationMsgType.PERSON_ENHANCED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[EnumNotificationMsgType.CRYING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[EnumNotificationMsgType.SD_NEED_INITIALIZATION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[EnumNotificationMsgType.SD_INSUFFICIENT_STORAGE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[EnumNotificationMsgType.AREA_INTRUSION_DETECTION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[EnumNotificationMsgType.LINE_CROSSING_DETECTION.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[EnumNotificationMsgType.CAMERA_TAMPERING.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_CARE_TRIAL_EXPIRING_IN_3_DAYS.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_CARE_SUBSCRIPTION_PAYMENT_FAILED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_CARE_SUBSCRIPTION_EXPIRED.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_CARE_SUBSCRIPTION_EXPIRING_IN_3_DAYS.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_CARE_TRIAL_EXPIRED.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_HUB_TRIGGERED.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_CONTACT_SENSOR_TRIGGERED.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_MOTION_SENSOR_TRIGGERED.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_SMART_BUTTON_TRIGGERED.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_SMART_SWITCH_TRIGGERED.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_THERMOSTAT_RADIATOR_VALVE.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_DEVICE_LOW_BATTERY.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_SENSOR_FREQUENTLY_TRIGGERED.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_DAILY_SUMMARY_CAN_CREATE.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                a[EnumNotificationMsgType.TAPO_DAILY_SUMMARY_CREATED.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                a[EnumNotificationMsgType.BRAND_PROMOTION.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                a[EnumNotificationMsgType.MARKET_PROMOTION.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                a[EnumNotificationMsgType.ANNOUNCEMENT.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                a[EnumNotificationMsgType.USER_RESEARCH.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                a[EnumNotificationMsgType.OTHER.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements io.reactivex.g0.a {
        e() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            NotificationCenterManager.this.g.postValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements io.reactivex.g0.a {
        f() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            NotificationCenterManager.this.n.decrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ NotificationParams f8178c;

        g(NotificationParams notificationParams) {
            this.f8178c = notificationParams;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            NotificationCenterManager.this.m(null, new ArrayList(NotificationCenterManager.this.k.values()), this.f8178c.getLocale());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements io.reactivex.g0.g<List<NotificationMsgBean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ NotificationParams f8180c;

        h(NotificationParams notificationParams) {
            this.f8180c = notificationParams;
        }

        /* renamed from: a */
        public void accept(List<NotificationMsgBean> list) throws Exception {
            NotificationCenterManager.this.m(list, new ArrayList(NotificationCenterManager.this.k.values()), this.f8180c.getLocale());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements io.reactivex.g0.a {
        i() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            NotificationCenterManager.this.n.decrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f8182c;

        j(boolean z) {
            this.f8182c = z;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            NotificationCenterManager.this.q(new ArrayList(NotificationCenterManager.this.m), this.f8182c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class k implements io.reactivex.g0.a {
        final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8184b;

        k(List list, boolean z) {
            this.a = list;
            this.f8184b = z;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            NotificationCenterManager.this.q(this.a, this.f8184b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class l implements io.reactivex.d {
        final /* synthetic */ t[] a;

        l(t[] tVarArr) {
            this.a = tVarArr;
        }

        @Override // io.reactivex.d
        public void a(final io.reactivex.b bVar) throws Exception {
            q.i0(this.a).T0(30L, TimeUnit.SECONDS).z(new io.reactivex.g0.a() { // from class: com.tplink.iot.model.notification.a
                @Override // io.reactivex.g0.a
                public final void run() {
                    b.this.onComplete();
                }
            }).C(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.notification.b
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    io.reactivex.b.this.onError((Throwable) obj);
                }
            }).L0(io.reactivex.l0.a.c()).F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class m implements io.reactivex.g0.a {
        final /* synthetic */ NotificationMsgIdListParams a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f8187b;

        m(NotificationMsgIdListParams notificationMsgIdListParams, n nVar) {
            this.a = notificationMsgIdListParams;
            this.f8187b = nVar;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            List<NotificationMsgIdParams> msgIdList = this.a.getMsgIdList();
            if (msgIdList != null && !msgIdList.isEmpty()) {
                for (NotificationMsgIdParams notificationMsgIdParams : msgIdList) {
                    if (notificationMsgIdParams != null && !TextUtils.isEmpty(notificationMsgIdParams.getMsgId())) {
                        NotificationCenterManager.this.m.add(notificationMsgIdParams.getMsgId());
                    }
                }
            }
            this.f8187b.b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class n {
        private boolean a;

        public n(boolean z) {
            this.a = z;
        }

        public void b(boolean z) {
            this.a = z;
        }
    }

    public NotificationCenterManager(com.tplink.cloud.context.b bVar) {
        super(bVar);
        this.f8174d = (TCMessagePushRepository) b.d.b.f.b.a(bVar, TCMessagePushRepository.class);
        P();
    }

    private boolean A(NotificationMsgBean notificationMsgBean, int i2, long j2) {
        return B(notificationMsgBean, i2, j2);
    }

    private boolean B(NotificationMsgBean notificationMsgBean, int i2, long j2) {
        return i2 < 128 && J(j2, notificationMsgBean.getTime()) && this.j.get(notificationMsgBean.getMsgId()) == null;
    }

    private boolean C(NotificationMsgBean notificationMsgBean, int i2, long j2) {
        return i2 < 32 && J(j2, notificationMsgBean.getTime()) && this.j.get(notificationMsgBean.getMsgId()) == null;
    }

    private boolean D(NotificationMsgBean notificationMsgBean, int i2, long j2) {
        return i2 < 64 && I(j2, notificationMsgBean.getTime()) && this.j.get(notificationMsgBean.getMsgId()) == null;
    }

    private boolean E(NotificationMsgBean notificationMsgBean, int i2, long j2) {
        return i2 < 64 && J(j2, notificationMsgBean.getTime()) && this.j.get(notificationMsgBean.getMsgId()) == null;
    }

    private boolean F(NotificationMsgBean notificationMsgBean, int i2, long j2) {
        return B(notificationMsgBean, i2, j2);
    }

    private boolean G(NotificationMsgBean notificationMsgBean, int i2, long j2) {
        return C(notificationMsgBean, i2, j2);
    }

    private boolean H(NotificationMsgBean notificationMsgBean, int i2, long j2) {
        return C(notificationMsgBean, i2, j2);
    }

    private boolean I(long j2, long j3) {
        return j2 - j3 < 2592000000L;
    }

    private boolean J(long j2, long j3) {
        return j2 - j3 < 432000000;
    }

    private boolean K(NotificationMsgBean notificationMsgBean, int i2, long j2) {
        return C(notificationMsgBean, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(List<NotificationMsgBean> list) {
        NotificationMsgBean notificationMsgBean;
        if (list != null) {
            if (list.isEmpty()) {
                for (NotificationMsgBean notificationMsgBean2 : new ArrayList(this.j.values())) {
                    notificationMsgBean2.setReadFlag(true);
                }
            } else {
                for (NotificationMsgBean notificationMsgBean3 : list) {
                    if (!(notificationMsgBean3 == null || TextUtils.isEmpty(notificationMsgBean3.getMsgId()) || (notificationMsgBean = this.j.get(notificationMsgBean3.getMsgId())) == null)) {
                        notificationMsgBean.setReadFlag(true);
                    }
                }
            }
            O();
        }
    }

    private synchronized void O() {
        ArrayList arrayList = new ArrayList(this.j.values());
        this.k.clear();
        boolean z = true;
        for (NotificationMsgBean notificationMsgBean : arrayList) {
            if (notificationMsgBean != null && !TextUtils.isEmpty(notificationMsgBean.getMsgId())) {
                this.k.put(notificationMsgBean.getMsgId(), notificationMsgBean);
                if (z) {
                    this.h = notificationMsgBean.getTime();
                    z = false;
                }
            }
        }
        Q(arrayList);
        S(arrayList);
        this.f8175e.postValue(arrayList);
    }

    private void P() {
        NotificationMsgCacheBean notificationMsgCacheBean;
        TCAccountBean c2 = this.f100b.c();
        String cloudUserName = c2 != null ? c2.getCloudUserName() : null;
        if (!TextUtils.isEmpty(cloudUserName)) {
            String g2 = b.d.w.h.a.g(cloudUserName);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    notificationMsgCacheBean = (NotificationMsgCacheBean) b.d.w.d.a.b(g2, "account_notification_msg_cache_list_key2", "account_notification_msg_cache_list_key2", NotificationMsgCacheBean.class);
                } catch (Exception unused) {
                    notificationMsgCacheBean = new NotificationMsgCacheBean();
                }
                if (!(notificationMsgCacheBean == null || s.b(notificationMsgCacheBean.getList()))) {
                    this.l = notificationMsgCacheBean.getLocale();
                    boolean z = true;
                    for (NotificationMsgBean notificationMsgBean : notificationMsgCacheBean.getList()) {
                        if (notificationMsgBean != null && !TextUtils.isEmpty(notificationMsgBean.getMsgId())) {
                            if (z) {
                                this.h = notificationMsgBean.getTime();
                                z = false;
                            }
                            this.k.put(notificationMsgBean.getMsgId(), notificationMsgBean);
                        }
                    }
                }
            }
        }
    }

    private void S(List<NotificationMsgBean> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            for (NotificationMsgBean notificationMsgBean : list) {
                if (!notificationMsgBean.isReadFlag()) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        this.f8176f.postValue(Boolean.valueOf(z));
    }

    private NotificationMsgTypeListParams k() {
        EnumNotificationMsgType[] values;
        ArrayList arrayList = new ArrayList();
        for (EnumNotificationMsgType enumNotificationMsgType : EnumNotificationMsgType.values()) {
            NotificationMsgTypeParams notificationMsgTypeParams = new NotificationMsgTypeParams();
            notificationMsgTypeParams.setIndexTime(-1L);
            notificationMsgTypeParams.setDirection(EnumNotificationDirection.ASC);
            notificationMsgTypeParams.setMsgType(enumNotificationMsgType.getName());
            arrayList.add(notificationMsgTypeParams);
        }
        NotificationMsgTypeListParams notificationMsgTypeListParams = new NotificationMsgTypeListParams();
        notificationMsgTypeListParams.setMsgList(arrayList);
        return notificationMsgTypeListParams;
    }

    private NotificationParams l() {
        b.d.s.a.b.a a2 = com.tplink.iot.core.n.a();
        NotificationParams notificationParams = new NotificationParams();
        String d2 = x.d(Locale.getDefault());
        long max = Math.max(System.currentTimeMillis() - 2592000000L, v(d2));
        ArrayList arrayList = new ArrayList();
        for (EnumNotificationMsgType enumNotificationMsgType : EnumNotificationMsgType.values()) {
            arrayList.add(enumNotificationMsgType.getName());
        }
        notificationParams.setMsgTypes(arrayList);
        notificationParams.setTerminalUUID(a2.g());
        notificationParams.setMobileType("ANDROID");
        notificationParams.setAppType(a2.b());
        if (TextUtils.isEmpty(a2.e())) {
            notificationParams.setDeviceToken("");
        } else {
            notificationParams.setDeviceToken(a2.e());
        }
        notificationParams.setLocale(d2);
        notificationParams.setDirection(EnumNotificationDirection.ASC);
        notificationParams.setIndex(0);
        notificationParams.setIndexTime(max);
        notificationParams.setLimit(50);
        return notificationParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:128:0x052e A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m(java.util.List<com.tplink.cloud.bean.push.NotificationMsgBean> r29, java.util.List<com.tplink.cloud.bean.push.NotificationMsgBean> r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 1578
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.model.notification.NotificationCenterManager.m(java.util.List, java.util.List, java.lang.String):void");
    }

    private io.reactivex.a n(List<NotificationMsgBean> list) {
        if (list == null) {
            return io.reactivex.a.e();
        }
        boolean isEmpty = list.isEmpty();
        ArrayList arrayList = new ArrayList();
        if (!isEmpty) {
            for (NotificationMsgBean notificationMsgBean : list) {
                if (notificationMsgBean != null && !TextUtils.isEmpty(notificationMsgBean.getMsgId())) {
                    arrayList.add(notificationMsgBean.getMsgId());
                }
            }
        }
        return p(list, isEmpty).i(new k(arrayList, isEmpty)).j(new j(isEmpty));
    }

    private q<Boolean> o(NotificationMsgIdListParams notificationMsgIdListParams) {
        final n nVar = new n(true);
        return this.f8174d.C(notificationMsgIdListParams).i(new m(notificationMsgIdListParams, nVar)).j(new io.reactivex.g0.g() { // from class: com.tplink.iot.model.notification.c
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                NotificationCenterManager.n.this.b(false);
            }
        }).d(q.f0(Boolean.valueOf(nVar.a)));
    }

    private io.reactivex.a p(List<NotificationMsgBean> list, boolean z) {
        this.m.clear();
        if (z) {
            return this.f8174d.B(k());
        }
        ArrayList arrayList = new ArrayList();
        for (NotificationMsgBean notificationMsgBean : list) {
            if (notificationMsgBean != null && !TextUtils.isEmpty(notificationMsgBean.getMsgId())) {
                NotificationMsgIdParams notificationMsgIdParams = new NotificationMsgIdParams();
                notificationMsgIdParams.setMsgId(notificationMsgBean.getMsgId());
                arrayList.add(notificationMsgIdParams);
            }
        }
        return s(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(List<String> list, boolean z) {
        if (list != null) {
            if (z) {
                this.j.clear();
            } else {
                for (String str : list) {
                    this.j.remove(str);
                }
            }
            O();
        }
    }

    private long v(String str) {
        if (!TextUtils.equals(str, this.l)) {
            return -1L;
        }
        return Math.max(-1L, this.h);
    }

    private boolean z(NotificationMsgBean notificationMsgBean, int i2, long j2) {
        return B(notificationMsgBean, i2, j2);
    }

    public io.reactivex.a M(List<NotificationMsgBean> list) {
        this.n.incrementAndGet();
        return io.reactivex.a.n(new b(list)).h(new a());
    }

    public void Q(List<NotificationMsgBean> list) {
        NotificationMsgCacheBean notificationMsgCacheBean = new NotificationMsgCacheBean();
        notificationMsgCacheBean.setLocale(this.l);
        notificationMsgCacheBean.setList(list);
        b.d.w.d.a.l(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), notificationMsgCacheBean, "account_notification_msg_cache_list_key2", "account_notification_msg_cache_list_key2");
    }

    public void R(boolean z) {
        this.i = z;
    }

    public io.reactivex.a r(List<NotificationMsgBean> list) {
        this.n.incrementAndGet();
        return n(list).h(new i());
    }

    public io.reactivex.a s(List<NotificationMsgIdParams> list) {
        int size = list.size();
        int i2 = 0;
        int i3 = (size / 50) + (size % 50 != 0 ? 1 : 0);
        t[] tVarArr = new t[i3];
        while (i2 < i3) {
            ArrayList arrayList = new ArrayList(list.subList(i2 * 50, i2 == i3 + (-1) ? size : (i2 + 1) * 50));
            NotificationMsgIdListParams notificationMsgIdListParams = new NotificationMsgIdListParams();
            notificationMsgIdListParams.setMsgIdList(arrayList);
            tVarArr[i2] = o(notificationMsgIdListParams);
            i2++;
        }
        return io.reactivex.a.g(new l(tVarArr));
    }

    public q<List<NotificationMsgBean>> t() {
        if (this.n.get() > 0) {
            return q.f0(new ArrayList()).y(new e());
        }
        this.n.incrementAndGet();
        NotificationParams l2 = l();
        return this.f8174d.D(l2).E(new h(l2)).C(new g(l2)).y(new f());
    }

    public void u() {
        Boolean value = this.f8176f.getValue();
        if ((value == null || !value.booleanValue()) && !this.i) {
            t().F0();
        }
    }

    public MutableLiveData<List<NotificationMsgBean>> w() {
        return this.f8175e;
    }

    public MutableLiveData<Boolean> x() {
        return this.f8176f;
    }

    public MutableLiveData<Boolean> y() {
        return this.g;
    }
}
