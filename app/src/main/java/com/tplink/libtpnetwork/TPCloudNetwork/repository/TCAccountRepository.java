package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.cloud.bean.account.params.CheckPasswordParams;
import com.tplink.cloud.bean.account.params.CloudUserEmailParams;
import com.tplink.cloud.bean.account.params.CloudUserParams;
import com.tplink.cloud.bean.account.params.LoginParams;
import com.tplink.cloud.bean.account.params.ModifyCloudPasswordParams;
import com.tplink.cloud.bean.account.params.RegisterParams;
import com.tplink.cloud.bean.account.params.TopicSubscriptionParams;
import com.tplink.cloud.bean.account.params.UpdateAccountInfoParams;
import com.tplink.cloud.bean.account.params.UpdateTopicSubscriptionParams;
import com.tplink.cloud.bean.account.result.AccountStatusResult;
import com.tplink.cloud.bean.account.result.CheckPasswordV1Result;
import com.tplink.cloud.bean.account.result.CloudUserResult;
import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.cloud.bean.account.result.TopicSubscriptionResult;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.webservice.params.WebServiceInfoParams;
import com.tplink.cloud.bean.webservice.result.AccountAvatarResult;
import com.tplink.cloud.bean.webservice.result.WebServiceInfoResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.cloud.define.EnumAccountStatus;
import com.tplink.libtpnetwork.TPCloudNetwork.exception.CloudAccountV1Exception;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.t;
import java.util.Collections;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* loaded from: classes3.dex */
public class TCAccountRepository extends b.d.b.f.a {

    /* renamed from: c  reason: collision with root package name */
    private b.d.b.c.a f13817c;

    /* renamed from: d  reason: collision with root package name */
    private b.d.b.c.j f13818d;

    /* renamed from: e  reason: collision with root package name */
    private com.tplink.libtpnetwork.Utils.o f13819e = com.tplink.libtpnetwork.Utils.o.h0();

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<TCAccountBean> f13820f = new MutableLiveData<>();
    private SingleLiveEvent<TCAccountBean> g = new SingleLiveEvent<>();

    /* loaded from: classes3.dex */
    class a implements io.reactivex.g0.j<CloudResult<Void>, io.reactivex.e> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13821c;

        a(String str) {
            this.f13821c = str;
        }

        /* renamed from: a */
        public io.reactivex.e apply(CloudResult<Void> cloudResult) throws Exception {
            TCAccountRepository.this.U(this.f13821c);
            return io.reactivex.a.e();
        }
    }

    /* loaded from: classes3.dex */
    class b implements io.reactivex.g0.j<CloudResult<Void>, io.reactivex.e> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13823c;

        b(String str) {
            this.f13823c = str;
        }

        /* renamed from: a */
        public io.reactivex.e apply(CloudResult<Void> cloudResult) throws Exception {
            TCAccountRepository.this.Q(this.f13823c);
            return io.reactivex.a.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements io.reactivex.g0.j<CloudResult<CloudUserResult>, CloudUserResult> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13825c;

        c(String str) {
            this.f13825c = str;
        }

        /* renamed from: a */
        public CloudUserResult apply(CloudResult<CloudUserResult> cloudResult) throws Exception {
            TCAccountRepository.this.V(this.f13825c, cloudResult.getResult());
            return cloudResult.getResult();
        }
    }

    /* loaded from: classes3.dex */
    class d implements io.reactivex.g0.j<CloudResult<CheckPasswordV1Result>, CheckPasswordV1Result> {
        d() {
        }

        /* renamed from: a */
        public CheckPasswordV1Result apply(CloudResult<CheckPasswordV1Result> cloudResult) throws Exception {
            b.d.w.c.a.e("login_checkPwd", com.tplink.libtpnetwork.Utils.i.h(cloudResult));
            return cloudResult.getResult();
        }
    }

    /* loaded from: classes3.dex */
    class e implements io.reactivex.g0.j<CloudResult<TopicSubscriptionResult>, TopicSubscriptionResult> {
        e() {
        }

        /* renamed from: a */
        public TopicSubscriptionResult apply(CloudResult<TopicSubscriptionResult> cloudResult) throws Exception {
            return cloudResult.getResult();
        }
    }

    /* loaded from: classes3.dex */
    class f implements io.reactivex.g0.j<CloudResult<Void>, io.reactivex.e> {
        f() {
        }

        /* renamed from: a */
        public io.reactivex.e apply(CloudResult<Void> cloudResult) throws Exception {
            return io.reactivex.a.e();
        }
    }

    /* loaded from: classes3.dex */
    class g implements io.reactivex.g0.j<CloudResult<AccountAvatarResult>, AccountAvatarResult> {
        g() {
        }

        /* renamed from: a */
        public AccountAvatarResult apply(CloudResult<AccountAvatarResult> cloudResult) throws Exception {
            TCAccountRepository.this.S(cloudResult.getResult());
            return cloudResult.getResult();
        }
    }

    /* loaded from: classes3.dex */
    class h implements io.reactivex.g0.j<CloudResult<WebServiceInfoResult>, t<CloudResult<AccountAvatarResult>>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13831c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ byte[] f13832d;

        h(String str, byte[] bArr) {
            this.f13831c = str;
            this.f13832d = bArr;
        }

        /* renamed from: a */
        public t<CloudResult<AccountAvatarResult>> apply(CloudResult<WebServiceInfoResult> cloudResult) throws Exception {
            String str = cloudResult.getResult().getServiceUrls().get("account.avatar");
            if (str == null) {
                return io.reactivex.q.J(new CloudException(-1, null));
            }
            return TCAccountRepository.this.f13818d.Y(str + "/res/uploadAccountAvatar", MultipartBody.Part.createFormData("attachment", "avatar.png", RequestBody.create(MediaType.get(this.f13831c), this.f13832d)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i implements io.reactivex.g0.g<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TCAccountBean f13834c;

        i(TCAccountBean tCAccountBean) {
            this.f13834c = tCAccountBean;
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            TCAccountRepository.this.s(this.f13834c.getCloudUserName()).L0(io.reactivex.l0.a.c()).F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j implements io.reactivex.g0.j<CloudResult<LoginV1Result>, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13836c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f13837d;

        j(String str, String str2) {
            this.f13836c = str;
            this.f13837d = str2;
        }

        /* renamed from: a */
        public Boolean apply(CloudResult<LoginV1Result> cloudResult) throws Exception {
            b.d.w.c.a.e(FirebaseAnalytics.Event.LOGIN, com.tplink.libtpnetwork.Utils.i.h(cloudResult));
            if (cloudResult.getErrorCode() == 0) {
                LoginV1Result result = cloudResult.getResult();
                if (result == null || result.getErrorCode() != 0) {
                    throw new CloudAccountV1Exception(result);
                }
                TCAccountRepository.this.W(this.f13836c, this.f13837d, result);
                return Boolean.TRUE;
            }
            throw new CloudException(cloudResult.getErrorCode(), cloudResult.getMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k implements io.reactivex.g0.j<CloudResult<Void>, Boolean> {
        k() {
        }

        /* renamed from: a */
        public Boolean apply(CloudResult<Void> cloudResult) throws Exception {
            TCAccountRepository.this.T(EnumAccountStatus.ACCOUNT_STATUS_NORMAL);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class l implements io.reactivex.g0.j<Throwable, t<Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TCAccountBean f13840c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f13841d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f13842f;
        final /* synthetic */ String q;
        final /* synthetic */ String x;
        final /* synthetic */ boolean y;

        l(TCAccountBean tCAccountBean, String str, String str2, String str3, String str4, boolean z) {
            this.f13840c = tCAccountBean;
            this.f13841d = str;
            this.f13842f = str2;
            this.q = str3;
            this.x = str4;
            this.y = z;
        }

        /* renamed from: a */
        public t<Boolean> apply(Throwable th) throws Exception {
            int errCode;
            if (!(th instanceof CloudException) || ((errCode = ((CloudException) th).getErrCode()) != -20652 && errCode != -20651)) {
                return io.reactivex.q.J(th);
            }
            return TCAccountRepository.this.D(this.f13840c, this.f13841d, this.f13842f, this.q, this.x, this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class m implements io.reactivex.g0.j<Boolean, t<Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TCAccountBean f13843c;

        m(TCAccountBean tCAccountBean) {
            this.f13843c = tCAccountBean;
        }

        /* renamed from: a */
        public t<Boolean> apply(Boolean bool) throws Exception {
            if (bool.booleanValue()) {
                return io.reactivex.q.J(new CloudException(-20651, ""));
            }
            return TCAccountRepository.this.F(this.f13843c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class n implements io.reactivex.g0.j<CloudResult<Void>, io.reactivex.e> {
        n() {
        }

        /* renamed from: a */
        public io.reactivex.e apply(CloudResult<Void> cloudResult) throws Exception {
            TCAccountRepository.this.I();
            return io.reactivex.a.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class o implements io.reactivex.g0.j<Boolean, io.reactivex.e> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements io.reactivex.g0.a {
            a() {
            }

            @Override // io.reactivex.g0.a
            public void run() throws Exception {
                TCAccountRepository.this.I();
            }
        }

        o() {
        }

        /* renamed from: a */
        public io.reactivex.e apply(Boolean bool) throws Exception {
            if (!bool.booleanValue()) {
                return io.reactivex.a.n(new a());
            }
            TCAccountRepository tCAccountRepository = TCAccountRepository.this;
            return tCAccountRepository.H(tCAccountRepository.u().getCloudUserName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class p implements io.reactivex.g0.j<CloudResult<AccountStatusResult>, Integer> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13847c;

        p(String str) {
            this.f13847c = str;
        }

        /* renamed from: a */
        public Integer apply(CloudResult<AccountStatusResult> cloudResult) throws Exception {
            TCAccountRepository.this.Y(this.f13847c, cloudResult.getResult().getStatus());
            return Integer.valueOf(cloudResult.getResult().getStatus());
        }
    }

    /* loaded from: classes3.dex */
    class q implements io.reactivex.g0.j<CloudResult<Void>, io.reactivex.e> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13849c;

        q(String str) {
            this.f13849c = str;
        }

        /* renamed from: a */
        public io.reactivex.e apply(CloudResult<Void> cloudResult) throws Exception {
            TCAccountRepository.this.X(this.f13849c);
            return io.reactivex.a.e();
        }
    }

    public TCAccountRepository(com.tplink.cloud.context.b bVar) {
        super(bVar);
        this.f13817c = bVar.d();
        this.f13818d = bVar.d();
    }

    private boolean B() {
        TCAccountBean u = u();
        return (u == null || u.getCloudUserName() == null || u.getToken() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> D(TCAccountBean tCAccountBean, String str, String str2, String str3, String str4, boolean z) {
        return E(tCAccountBean.getCloudUserName(), tCAccountBean.getPassword(), str, str2, str3, str4, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.reactivex.q<Boolean> F(TCAccountBean tCAccountBean) {
        return G(tCAccountBean.getCloudUserName()).E(new i(tCAccountBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        TCAccountBean u = u();
        u.setPassword(null);
        u.setToken(null);
        this.f100b.g(u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(String str) {
        TCAccountBean u = u();
        u.setCountryCode(str);
        this.f13819e.t0(u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(AccountAvatarResult accountAvatarResult) {
        TCAccountBean u = u();
        u.setAvatarUrl(accountAvatarResult.getAvatarUrl() == null ? "" : accountAvatarResult.getAvatarUrl());
        this.f13820f.postValue(u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(EnumAccountStatus enumAccountStatus) {
        TCAccountBean u = u();
        u.setAccountStatus(enumAccountStatus);
        this.f13820f.postValue(u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(String str) {
        TCAccountBean u = u();
        u.setNickName(str);
        this.f13819e.s0(u.getCloudUserName(), u.getNickName());
        this.f13819e.t0(u);
        this.f13820f.postValue(u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str, CloudUserResult cloudUserResult) {
        TCAccountBean u = u();
        u.setAccountId(cloudUserResult.getAccountId());
        u.setEmail(cloudUserResult.getEmail());
        u.setUserName(cloudUserResult.getUsername());
        u.setNickName(cloudUserResult.getNickname());
        u.setRegTime(cloudUserResult.getRegTime());
        u.setAvatarUrl(cloudUserResult.getAvatarUrl() == null ? "" : cloudUserResult.getAvatarUrl());
        u.setCountryCode(cloudUserResult.getCountryCode());
        if (str.equalsIgnoreCase(cloudUserResult.getEmail())) {
            u.setCloudUserName(cloudUserResult.getEmail());
        } else {
            u.setCloudUserName(str);
        }
        this.f13819e.s0(u.getCloudUserName(), u.getNickName());
        this.f13819e.t0(u);
        this.f13820f.postValue(u);
        this.g.postValue(u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str, String str2, LoginV1Result loginV1Result) {
        TCAccountBean u = u();
        u.setAccountId(loginV1Result.getAccountId());
        u.setEmail(loginV1Result.getEmail());
        u.setToken(loginV1Result.getToken());
        u.setUserName(loginV1Result.getUsername());
        u.setNickName(loginV1Result.getNickname());
        u.setRegTime(loginV1Result.getRegTime());
        u.setRefreshToken(loginV1Result.getRefreshToken());
        u.setCountryCode(loginV1Result.getCountryCode());
        u.setAvatarUrl(loginV1Result.getAvatarUrl() == null ? "" : loginV1Result.getAvatarUrl());
        if (str.equalsIgnoreCase(loginV1Result.getEmail())) {
            u.setCloudUserName(loginV1Result.getEmail());
        } else {
            u.setCloudUserName(str);
        }
        u.setPassword(str2);
        u.setAccountStatus(EnumAccountStatus.ACCOUNT_STATUS_NORMAL);
        this.f100b.g(u);
        this.f13819e.s0(u.getCloudUserName(), u.getNickName());
        this.f13819e.t0(u);
        this.f13820f.postValue(u);
        this.g.postValue(u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(String str) {
        TCAccountBean u = u();
        u.setPassword(str);
        this.f13820f.postValue(u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(String str, int i2) {
        EnumAccountStatus enumAccountStatus = EnumAccountStatus.ACCOUNT_STATUS_NORMAL;
        if (i2 == 0) {
            enumAccountStatus = EnumAccountStatus.ACCOUNT_STATUS_UNREGISTERED;
        } else if (i2 != 1) {
            if (i2 == 2) {
                enumAccountStatus = EnumAccountStatus.ACCOUNT_STATUS_LOCKED;
            } else if (i2 == 3) {
                enumAccountStatus = EnumAccountStatus.ACCOUNT_STATUS_UNACTIVATED;
            }
        }
        if (!TextUtils.isEmpty(str) && str.equals(u().getCloudUserName())) {
            T(enumAccountStatus);
        }
    }

    public boolean A() {
        TCAccountBean u = u();
        return u != null && u.isAccountInfoValid();
    }

    public io.reactivex.q<Boolean> C(TCAccountBean tCAccountBean, String str, String str2, String str3, String str4, boolean z) {
        return io.reactivex.q.f0(Boolean.valueOf(tCAccountBean.getToken() == null || tCAccountBean.getToken().isEmpty())).N(new m(tCAccountBean)).o0(new l(tCAccountBean, str, str2, str3, str4, z));
    }

    public io.reactivex.q<Boolean> E(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        LoginParams loginParams = new LoginParams();
        loginParams.setCloudUserName(str);
        loginParams.setCloudPassword(str2);
        loginParams.setAppType(str3);
        loginParams.setTerminalUUID(str4);
        loginParams.setPlatform(str5);
        loginParams.setAppVersion(str6);
        loginParams.setRefreshTokenNeeded(z);
        return this.f13817c.L1(new CloudParams<>(FirebaseAnalytics.Event.LOGIN, loginParams)).g0(new j(str, str2));
    }

    public io.reactivex.q<Boolean> G(String str) {
        return this.f13817c.f(new CloudParams<>(FirebaseAnalytics.Event.LOGIN, new CloudUserParams(str))).g0(new k());
    }

    public io.reactivex.a H(String str) {
        return this.f13817c.e1(new CloudParams<>("logout", new CloudUserParams(str))).R(new n());
    }

    public io.reactivex.a J() {
        return io.reactivex.q.f0(Boolean.valueOf(B())).R(new o());
    }

    public io.reactivex.a K(String str, String str2, String str3) {
        return this.f13817c.s1(new CloudParams<>("modifyCloudPassword", new ModifyCloudPasswordParams(str, str2, str3))).R(new q(str3));
    }

    public void L() {
        TCAccountBean u = u();
        if (u != null) {
            this.f100b.g(u);
            this.f13820f.postValue(u);
        }
    }

    public io.reactivex.a M(String str, String str2, String str3, String str4, String str5, String str6, Map<String, Boolean> map) {
        return this.f13817c.o1(new CloudParams<>("register", new RegisterParams(str, str2, str3, str4, str5, str6, map))).Z();
    }

    public io.reactivex.a N(String str, String str2) {
        return this.f13817c.U0(new CloudParams<>("resendRegEmail", new CloudUserEmailParams(str, str2))).Z();
    }

    public void O(TCAccountBean tCAccountBean) {
        this.f100b.g(tCAccountBean);
    }

    public io.reactivex.a P(String str, String str2, String str3) {
        return this.f13817c.N0(new CloudParams<>("updateAccountInfo", new UpdateAccountInfoParams(str, str2, str3))).R(new b(str3));
    }

    public io.reactivex.a R(String str, String str2) {
        return this.f13817c.N0(new CloudParams<>("updateAccountInfo", new UpdateAccountInfoParams(str, str2))).R(new a(str2));
    }

    public void Z() {
        TCAccountBean u = u();
        if (u != null) {
            u.setNickName(this.f13819e.s(u.getCloudUserName()));
            this.f13820f.postValue(u);
        }
    }

    public io.reactivex.a a0(String str, String str2, Map<String, Boolean> map) {
        return this.f13817c.f0(new CloudParams<>("updateTopicSubscription", new UpdateTopicSubscriptionParams(str, str2, map))).R(new f());
    }

    public io.reactivex.q<AccountAvatarResult> b0(String str, byte[] bArr) {
        return this.f13818d.S0(new CloudParams<>("getWebServiceInfo", new WebServiceInfoParams(Collections.singletonList("account.avatar")))).N(new h(str, bArr)).g0(new g());
    }

    public io.reactivex.q<CheckPasswordV1Result> p(String str, String str2) {
        return this.f13817c.J1(new CloudParams<>("checkPassword", new CheckPasswordParams(str, str2))).g0(new d());
    }

    public void q() {
        TCAccountBean u = u();
        if (u != null) {
            u.setToken(null);
            this.f100b.g(u);
            this.f13820f.postValue(u);
        }
        this.f13819e.p();
    }

    public LiveData<TCAccountBean> r() {
        return this.f13820f;
    }

    public io.reactivex.q<CloudUserResult> s(String str) {
        return this.f13817c.p(new CloudParams<>("getAccountInfo", new CloudUserParams(str))).g0(new c(str));
    }

    public io.reactivex.q<Integer> t(String str) {
        return this.f13817c.x1(new CloudParams<>("getCloudAccountStatus", new CloudUserParams(str))).g0(new p(str));
    }

    public TCAccountBean u() {
        return this.f100b.c();
    }

    public io.reactivex.a v(String str, String str2) {
        return this.f13817c.T(new CloudParams<>("getResetPasswordEmail", new CloudUserEmailParams(str, str2))).Z();
    }

    public SingleLiveEvent<TCAccountBean> w() {
        return this.g;
    }

    public io.reactivex.q<TopicSubscriptionResult> x(String str, String str2) {
        return this.f13817c.C1(new CloudParams<>("getTopicSubscription", new TopicSubscriptionParams(str, str2))).g0(new e());
    }

    public boolean y() {
        b.d.b.c.a aVar = this.f13817c;
        return !(aVar instanceof b.d.b.b) || ((b.d.b.b) aVar).S1();
    }

    public boolean z() {
        TCAccountBean u = u();
        return u != null && u.isAccountInfoFullValid();
    }
}
