package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.tplink.iot.R;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MarkPositionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerracePoint;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceResetInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.MarkPositionConfirmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MarkedPositionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MarkedPositionListInfo;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: CloudTerracePresetViewModel.kt */
/* loaded from: classes3.dex */
public final class CloudTerracePresetViewModel extends AndroidViewModel implements LifecycleObserver {

    /* renamed from: c  reason: collision with root package name */
    private static final String f10503c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f10504d = new a(null);
    private MarkPositionRepository J3;
    private DataBindingListAdapter R3;

    /* renamed from: f  reason: collision with root package name */
    private String f10505f;
    private TPCameraDeviceContext q;
    private CloudTerraceControlViewModel x;
    private boolean y;
    private Bitmap z;
    private final ArrayList<String> p0 = new ArrayList<>();
    private final ArrayList<Integer> p1 = new ArrayList<>();
    private final ArrayList<Object> p2 = new ArrayList<>();
    private final MediatorLiveData<ArrayList<MarkedPositionInfo>> p3 = new MediatorLiveData<>();
    private final MutableLiveData<String> H3 = new MutableLiveData<>();
    private final io.reactivex.e0.b I3 = new io.reactivex.e0.b();
    private MutableLiveData<Boolean> K3 = new MutableLiveData<>();
    private final MutableLiveData<Boolean> L3 = new MutableLiveData<>();
    private final MutableLiveData<Boolean> M3 = new MutableLiveData<>();
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> N3 = new MutableLiveData<>();
    private final MutableLiveData<b.d.d.m.f<Pair<Bitmap, String>>> O3 = new MutableLiveData<>();
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> P3 = new MutableLiveData<>();
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> Q3 = new MutableLiveData<>();

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements kotlin.jvm.b.l<MarkedPositionListInfo, ArrayList<MarkedPositionInfo>> {
        b(CloudTerracePresetViewModel cloudTerracePresetViewModel) {
            super(1, cloudTerracePresetViewModel, CloudTerracePresetViewModel.class, "parseData", "parseData(Lcom/tplink/libtpnetwork/cameranetwork/model/MarkedPositionListInfo;)Ljava/util/ArrayList;", 0);
        }

        /* renamed from: a */
        public final ArrayList<MarkedPositionInfo> invoke(MarkedPositionListInfo p1) {
            kotlin.jvm.internal.j.e(p1, "p1");
            return ((CloudTerracePresetViewModel) this.receiver).a0(p1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class c<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f10507d;

        c(boolean z) {
            this.f10507d = z;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            if (this.f10507d) {
                CloudTerracePresetViewModel.this.i0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class d extends FunctionReferenceImpl implements kotlin.jvm.b.a<kotlin.p> {
        d(CloudTerracePresetViewModel cloudTerracePresetViewModel) {
            super(0, cloudTerracePresetViewModel, CloudTerracePresetViewModel.class, "closeLoading", "closeLoading()V", 0);
        }

        public final void a() {
            ((CloudTerracePresetViewModel) this.receiver).x();
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class e<T> implements io.reactivex.g0.g<ArrayList<MarkedPositionInfo>> {

        /* renamed from: c  reason: collision with root package name */
        public static final e f10508c = new e();

        e() {
        }

        /* renamed from: a */
        public final void accept(ArrayList<MarkedPositionInfo> arrayList) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class f<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f10510d;

        f(boolean z) {
            this.f10510d = z;
        }

        /* renamed from: a */
        public final void accept(Throwable it) {
            if (this.f10510d) {
                CloudTerracePresetViewModel cloudTerracePresetViewModel = CloudTerracePresetViewModel.this;
                kotlin.jvm.internal.j.d(it, "it");
                CloudTerracePresetViewModel.T(cloudTerracePresetViewModel, it, null, 2, null);
            } else {
                CloudTerracePresetViewModel cloudTerracePresetViewModel2 = CloudTerracePresetViewModel.this;
                kotlin.jvm.internal.j.d(it, "it");
                cloudTerracePresetViewModel2.S(it, null);
            }
            CloudTerracePresetViewModel.this.p3.postValue(new ArrayList());
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class g<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        g() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            CloudTerracePresetViewModel.this.i0();
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final /* synthetic */ class h extends FunctionReferenceImpl implements kotlin.jvm.b.a<kotlin.p> {
        h(CloudTerracePresetViewModel cloudTerracePresetViewModel) {
            super(0, cloudTerracePresetViewModel, CloudTerracePresetViewModel.class, "closeLoading", "closeLoading()V", 0);
        }

        public final void a() {
            ((CloudTerracePresetViewModel) this.receiver).x();
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class i<T> implements io.reactivex.g0.g<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public static final i f10512c = new i();

        i() {
        }

        /* renamed from: a */
        public final void accept(Boolean bool) {
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class j<T> implements io.reactivex.g0.g<Throwable> {
        j() {
        }

        /* renamed from: a */
        public final void accept(Throwable it) {
            CloudTerracePresetViewModel cloudTerracePresetViewModel = CloudTerracePresetViewModel.this;
            kotlin.jvm.internal.j.d(it, "it");
            CloudTerracePresetViewModel.T(cloudTerracePresetViewModel, it, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class k extends FunctionReferenceImpl implements kotlin.jvm.b.l<ArrayList<MarkedPositionInfo>, kotlin.p> {
        k(MediatorLiveData mediatorLiveData) {
            super(1, mediatorLiveData, MediatorLiveData.class, "setValue", "setValue(Ljava/lang/Object;)V", 0);
        }

        public final void a(ArrayList<MarkedPositionInfo> arrayList) {
            ((MediatorLiveData) this.receiver).setValue(arrayList);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.p invoke(ArrayList<MarkedPositionInfo> arrayList) {
            a(arrayList);
            return kotlin.p.a;
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class l<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        l() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            CloudTerracePresetViewModel.this.i0();
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final /* synthetic */ class m extends FunctionReferenceImpl implements kotlin.jvm.b.a<kotlin.p> {
        m(CloudTerracePresetViewModel cloudTerracePresetViewModel) {
            super(0, cloudTerracePresetViewModel, CloudTerracePresetViewModel.class, "closeLoading", "closeLoading()V", 0);
        }

        public final void a() {
            ((CloudTerracePresetViewModel) this.receiver).x();
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class n<T> implements io.reactivex.g0.g<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f10516d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f10517f;

        n(int i, String str) {
            this.f10516d = i;
            this.f10517f = str;
        }

        /* renamed from: a */
        public final void accept(Boolean bool) {
            CloudTerracePresetViewModel cloudTerracePresetViewModel = CloudTerracePresetViewModel.this;
            String str = cloudTerracePresetViewModel.f10505f;
            kotlin.jvm.internal.j.c(str);
            cloudTerracePresetViewModel.y(str, this.f10516d, this.f10517f);
            int size = CloudTerracePresetViewModel.this.p1.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                Integer num = (Integer) CloudTerracePresetViewModel.this.p1.get(i);
                if (num != null && num.intValue() == this.f10516d) {
                    CloudTerracePresetViewModel.this.p0.remove(i);
                    CloudTerracePresetViewModel.this.p2.remove(i);
                    CloudTerracePresetViewModel.this.p1.remove(i);
                    break;
                }
                i++;
            }
            DataBindingListAdapter H = CloudTerracePresetViewModel.this.H();
            if (H != null) {
                H.s();
            }
            if (CloudTerracePresetViewModel.this.p1.size() == 0 && !((Boolean) com.tplink.libtpnetwork.Utils.j.e(CloudTerracePresetViewModel.this.I(), Boolean.FALSE)).booleanValue()) {
                CloudTerracePresetViewModel.this.I().setValue(Boolean.TRUE);
            }
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class o<T> implements io.reactivex.g0.g<Throwable> {
        o() {
        }

        /* renamed from: a */
        public final void accept(Throwable it) {
            CloudTerracePresetViewModel cloudTerracePresetViewModel = CloudTerracePresetViewModel.this;
            kotlin.jvm.internal.j.d(it, "it");
            CloudTerracePresetViewModel.T(cloudTerracePresetViewModel, it, null, 2, null);
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class p<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f10520d;

        p(String str) {
            this.f10520d = str;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            CloudTerracePresetViewModel.this.i0();
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class q<T> implements io.reactivex.g0.g<MarkPositionConfirmInfo> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f10522d;

        q(String str) {
            this.f10522d = str;
        }

        /* renamed from: a */
        public final void accept(MarkPositionConfirmInfo markPositionConfirmInfo) {
            CloudTerracePresetViewModel cloudTerracePresetViewModel = CloudTerracePresetViewModel.this;
            String str = cloudTerracePresetViewModel.f10505f;
            kotlin.jvm.internal.j.c(str);
            cloudTerracePresetViewModel.j0(str, markPositionConfirmInfo.getId(), markPositionConfirmInfo.getName(), CloudTerracePresetViewModel.this.M());
            MutableLiveData<Boolean> I = CloudTerracePresetViewModel.this.I();
            Boolean bool = Boolean.FALSE;
            Object e2 = com.tplink.libtpnetwork.Utils.j.e(I, bool);
            kotlin.jvm.internal.j.d(e2, "LiveDataUtils.getValue(o…owMarkPositionBtn, false)");
            if (((Boolean) e2).booleanValue()) {
                CloudTerracePresetViewModel.this.I().setValue(bool);
            }
            CloudTerracePresetViewModel.this.p1.add(0, Integer.valueOf(markPositionConfirmInfo.getId()));
            ArrayList arrayList = CloudTerracePresetViewModel.this.p2;
            CloudTerracePresetViewModel cloudTerracePresetViewModel2 = CloudTerracePresetViewModel.this;
            String str2 = cloudTerracePresetViewModel2.f10505f;
            kotlin.jvm.internal.j.c(str2);
            arrayList.add(0, cloudTerracePresetViewModel2.K(str2, markPositionConfirmInfo.getId(), markPositionConfirmInfo.getName()));
            CloudTerracePresetViewModel.this.p0.add(0, markPositionConfirmInfo.getName());
            DataBindingListAdapter H = CloudTerracePresetViewModel.this.H();
            if (H != null) {
                H.s();
            }
            CloudTerracePresetViewModel.this.O().postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(CloudTerracePresetViewModel.this.N(R.string.wss_success)));
            com.tplink.iot.Utils.x0.e.o(CloudTerracePresetViewModel.this.f10505f);
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class r<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f10524d;

        r(String str) {
            this.f10524d = str;
        }

        /* renamed from: a */
        public final void accept(Throwable it) {
            CloudTerracePresetViewModel cloudTerracePresetViewModel = CloudTerracePresetViewModel.this;
            kotlin.jvm.internal.j.d(it, "it");
            CloudTerracePresetViewModel.T(cloudTerracePresetViewModel, it, null, 2, null);
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final /* synthetic */ class s extends FunctionReferenceImpl implements kotlin.jvm.b.a<kotlin.p> {
        s(CloudTerracePresetViewModel cloudTerracePresetViewModel) {
            super(0, cloudTerracePresetViewModel, CloudTerracePresetViewModel.class, "closeLoading", "closeLoading()V", 0);
        }

        public final void a() {
            ((CloudTerracePresetViewModel) this.receiver).x();
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class t<T> implements io.reactivex.g0.g<CameraComponent> {
        t() {
        }

        /* renamed from: a */
        public final void accept(CameraComponent cameraComponent) {
            if (cameraComponent.hasComponent(ComponentType.PTZ)) {
                CloudTerracePresetViewModel cloudTerracePresetViewModel = CloudTerracePresetViewModel.this;
                TPCameraDeviceContext tPCameraDeviceContext = cloudTerracePresetViewModel.q;
                kotlin.jvm.internal.j.c(tPCameraDeviceContext);
                cloudTerracePresetViewModel.U(tPCameraDeviceContext);
            }
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class u<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        public static final u f10526c = new u();

        u() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.e(CloudTerracePresetViewModel.f10503c, Log.getStackTraceString(th));
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class v<T> implements Observer<ArrayList<MarkedPositionInfo>> {
        v() {
        }

        /* renamed from: a */
        public final void onChanged(ArrayList<MarkedPositionInfo> arrayList) {
            boolean z;
            CloudTerracePresetViewModel.this.p1.clear();
            CloudTerracePresetViewModel.this.p2.clear();
            CloudTerracePresetViewModel.this.p0.clear();
            if (arrayList != null) {
                Iterator<MarkedPositionInfo> it = arrayList.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    MarkedPositionInfo next = it.next();
                    CloudTerracePresetViewModel.this.p1.add(0, Integer.valueOf(next.getId()));
                    CloudTerracePresetViewModel.this.p2.add(0, next.getFileOrBitmap());
                    CloudTerracePresetViewModel.this.p0.add(0, next.getName());
                }
                DataBindingListAdapter H = CloudTerracePresetViewModel.this.H();
                if (H != null) {
                    H.s();
                }
                if (arrayList.size() == 0) {
                    z = true;
                }
                if (!com.tplink.libtpnetwork.Utils.j.b(CloudTerracePresetViewModel.this.I(), Boolean.valueOf(z))) {
                    CloudTerracePresetViewModel.this.I().postValue(Boolean.valueOf(z));
                }
            }
        }
    }

    /* compiled from: CloudTerracePresetViewModel.kt */
    /* loaded from: classes3.dex */
    static final class w<T> implements Observer<Boolean> {
        w() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (com.tplink.libtpnetwork.Utils.j.h(CloudTerracePresetViewModel.this.X()) && kotlin.jvm.internal.j.a(bool, Boolean.TRUE)) {
                CloudTerracePresetViewModel.this.X().postValue(Boolean.FALSE);
            }
        }
    }

    static {
        String simpleName = CloudTerracePresetViewModel.class.getSimpleName();
        kotlin.jvm.internal.j.d(simpleName, "CloudTerracePresetViewModel::class.java.simpleName");
        f10503c = simpleName;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudTerracePresetViewModel(Application application) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        this.K3.setValue(Boolean.TRUE);
    }

    private final File J(String str) {
        return new File(b.d.q.b.p.b.f(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File K(String str, int i2, String str2) {
        return J(str + "_" + i2 + "_" + str2 + ".PNG");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String N(@StringRes int i2) {
        String string = getApplication().getString(i2);
        kotlin.jvm.internal.j.d(string, "getApplication<Application>().getString(id)");
        return string;
    }

    private final boolean Q() {
        if (!V()) {
            return false;
        }
        this.P3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(N(R.string.cloud_terrace_correcting_hint)));
        return true;
    }

    private final boolean R() {
        if (!W()) {
            return false;
        }
        this.P3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(N(R.string.cloud_terrace_cruising_hint)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(Throwable th, String str) {
        b.d.w.c.a.e(f10503c, Log.getStackTraceString(th));
        if (th instanceof CameraException) {
            switch (((CameraException) th).getErrorCode()) {
                case -64306:
                    this.N3.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
                    return;
                case -64305:
                case -64303:
                    this.P3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(N(R.string.cloud_terrace_motor_busy_hint_v2)));
                    return;
                case -64304:
                    this.P3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(N(R.string.video_live_ptz_ready_boundary)));
                    return;
            }
        }
        if (str != null) {
            this.P3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(str));
        }
    }

    static /* synthetic */ void T(CloudTerracePresetViewModel cloudTerracePresetViewModel, Throwable th, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = cloudTerracePresetViewModel.N(R.string.general_failed);
        }
        cloudTerracePresetViewModel.S(th, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(@NonNull TPCameraDeviceContext tPCameraDeviceContext) {
        MarkPositionRepository markPositionRepository = this.J3;
        if (markPositionRepository != null) {
            this.p3.removeSource(markPositionRepository.u());
        }
        MarkPositionRepository markPositionRepository2 = (MarkPositionRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(tPCameraDeviceContext, MarkPositionRepository.class);
        this.J3 = markPositionRepository2;
        if (markPositionRepository2 != null) {
            this.p3.removeSource(markPositionRepository2.u());
        }
        MediatorLiveData<ArrayList<MarkedPositionInfo>> mediatorLiveData = this.p3;
        MarkPositionRepository markPositionRepository3 = this.J3;
        kotlin.jvm.internal.j.c(markPositionRepository3);
        mediatorLiveData.addSource(markPositionRepository3.u(), new b3(new k(this.p3)));
        G(this.y);
    }

    private final boolean V() {
        CloudTerraceControlViewModel cloudTerraceControlViewModel = this.x;
        if (cloudTerraceControlViewModel == null) {
            kotlin.jvm.internal.j.t("cloudTerraceControlViewModel");
        }
        return cloudTerraceControlViewModel.y();
    }

    private final boolean W() {
        CloudTerraceControlViewModel cloudTerraceControlViewModel = this.x;
        if (cloudTerraceControlViewModel == null) {
            kotlin.jvm.internal.j.t("cloudTerraceControlViewModel");
        }
        return cloudTerraceControlViewModel.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<MarkedPositionInfo> a0(MarkedPositionListInfo markedPositionListInfo) {
        ArrayList<MarkedPositionInfo> arrayList = new ArrayList<>();
        int length = markedPositionListInfo.getIdList().length;
        for (int i2 = 0; i2 < length; i2++) {
            int intValue = markedPositionListInfo.getIdList()[i2].intValue();
            String str = markedPositionListInfo.getNameList()[i2];
            double d2 = markedPositionListInfo.getPositionPanList()[i2];
            double d3 = markedPositionListInfo.getPositionTiltList()[i2];
            String str2 = this.f10505f;
            kotlin.jvm.internal.j.c(str2);
            arrayList.add(new MarkedPositionInfo(intValue, str, Integer.valueOf(markedPositionListInfo.getReadOnlyList()[i2]), Double.valueOf(d2), Double.valueOf(d3), K(str2, intValue, str)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        if (com.tplink.libtpnetwork.Utils.j.g(this.M3)) {
            this.M3.postValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(String str, int i2, String str2, Bitmap bitmap) {
        if (bitmap != null) {
            k0(str + "_" + String.valueOf(i2) + "_" + str2 + ".PNG", bitmap);
        }
    }

    private final void k0(String str, Bitmap bitmap) {
        if (str != null) {
            if (!(str.length() == 0) && bitmap != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(b.d.q.b.p.b.f(), str));
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    bitmap.recycle();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private final void w() {
        String[] list;
        boolean A;
        boolean p2;
        if (!(this.f10505f == null || this.p1.size() == 0 || (list = new File(b.d.q.b.p.b.f()).list()) == null)) {
            ArrayList arrayList = new ArrayList();
            int size = this.p1.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(this.f10505f + "_" + String.valueOf(this.p1.get(i2).intValue()) + "_" + this.p0.get(i2) + ".PNG");
            }
            for (String str : list) {
                String str2 = this.f10505f;
                kotlin.jvm.internal.j.c(str2);
                A = kotlin.text.v.A(str, str2, false, 2, null);
                if (A) {
                    p2 = kotlin.text.v.p(str, ".PNG", false, 2, null);
                    if (p2 && !arrayList.contains(str)) {
                        getApplication().deleteFile(str);
                        b.d.w.c.a.i(f10503c, "delete redundant picture:" + str);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String str, int i2, String str2) {
        Application application = getApplication();
        application.deleteFile(str + "_" + String.valueOf(i2) + "_" + str2 + ".PNG");
    }

    public final MutableLiveData<b.d.d.m.f<Pair<Bitmap, String>>> A() {
        return this.O3;
    }

    public final MutableLiveData<Boolean> B() {
        return this.M3;
    }

    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> C() {
        return this.Q3;
    }

    public final ArrayList<Integer> D() {
        return this.p1;
    }

    public final ArrayList<String> E() {
        return this.p0;
    }

    public final ArrayList<Object> F() {
        return this.p2;
    }

    public final void G(boolean z) {
        MarkPositionRepository markPositionRepository = this.J3;
        if (markPositionRepository != null) {
            kotlin.jvm.internal.j.c(markPositionRepository);
            this.I3.b(markPositionRepository.t(new b(this)).F(new c(z)).y(new d3(new d(this))).H0(e.f10508c, new f(z)));
        }
    }

    public final DataBindingListAdapter H() {
        return this.R3;
    }

    public final MutableLiveData<Boolean> I() {
        return this.K3;
    }

    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> L() {
        return this.N3;
    }

    public final Bitmap M() {
        return this.z;
    }

    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> O() {
        return this.P3;
    }

    public final void P(int i2) {
        if (!Q() && !R()) {
            MarkPositionRepository markPositionRepository = this.J3;
            kotlin.jvm.internal.j.c(markPositionRepository);
            this.I3.b(markPositionRepository.v(i2).F(new g()).y(new d3(new h(this))).H0(i.f10512c, new j()));
        }
    }

    public final MutableLiveData<Boolean> X() {
        return this.L3;
    }

    public final boolean Y() {
        return this.p1.size() >= 8;
    }

    public final void Z() {
        if (!(Q() || R())) {
            i0();
            String str = this.f10505f;
            kotlin.jvm.internal.j.c(str);
            LiveMediaAPI.snapshot(str, this.O3);
            String str2 = "";
            for (int i2 = 1; i2 <= 8; i2++) {
                Application application = getApplication();
                kotlin.jvm.internal.j.d(application, "getApplication<Application>()");
                boolean z = false;
                str2 = application.getResources().getString(R.string.cloud_terrace_mark_position_name_default, String.valueOf(i2));
                kotlin.jvm.internal.j.d(str2, "getApplication<Applicati…me_default, i.toString())");
                Iterator<String> it = this.p0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (kotlin.jvm.internal.j.a(str2, it.next())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    break;
                }
            }
            this.H3.setValue(str2);
        }
    }

    public final void b0(String name, int i2) {
        kotlin.jvm.internal.j.e(name, "name");
        if (!Q() && !R()) {
            MarkPositionRepository markPositionRepository = this.J3;
            kotlin.jvm.internal.j.c(markPositionRepository);
            this.I3.b(markPositionRepository.y(new CloudTerraceResetInfo(new String[]{String.valueOf(i2)})).l0(io.reactivex.d0.b.a.a()).F(new l()).y(new d3(new m(this))).H0(new n(i2, name), new o()));
        }
    }

    public final void c0() {
        Object e2 = com.tplink.libtpnetwork.Utils.j.e(this.H3, "");
        kotlin.jvm.internal.j.d(e2, "LiveDataUtils.getValue(c…PositionNameLiveData, \"\")");
        String str = (String) e2;
        MarkPositionRepository markPositionRepository = this.J3;
        if (markPositionRepository != null) {
            this.I3.b(markPositionRepository.x(new CloudTerracePoint(str, "1")).l0(io.reactivex.d0.b.a.a()).F(new p(str)).y(new c3(new s(this))).H0(new q(str), new r(str)));
        }
    }

    public final void d0(String str) {
        if (!d0.a(this.f10505f, str)) {
            this.f10505f = str;
            this.q = null;
            this.J3 = null;
            if (str != null) {
                kotlin.jvm.internal.j.c(str);
                TPCameraDeviceContext K1 = TPIoTClientManager.K1(str);
                this.q = K1;
                kotlin.jvm.internal.j.c(K1);
                this.I3.b(((CommonCameraRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(K1, CommonCameraRepository.class)).K0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new t(), u.f10526c));
            }
        }
    }

    public final void e0(LifecycleOwner lifeCycleOwner) {
        kotlin.jvm.internal.j.e(lifeCycleOwner, "lifeCycleOwner");
        lifeCycleOwner.getLifecycle().addObserver(this);
        this.p3.observe(lifeCycleOwner, new v());
        this.K3.observe(lifeCycleOwner, new w());
    }

    public final void f0(DataBindingListAdapter dataBindingListAdapter) {
        this.R3 = dataBindingListAdapter;
    }

    public final void g0(Bitmap bitmap) {
        this.z = bitmap;
    }

    public final void h0(boolean z) {
        this.y = z;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onActivityDestroyed() {
        this.I3.d();
        w();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onActivityStarted() {
        G(this.p1.size() == 0 && this.y);
    }

    public final void v(CloudTerraceControlViewModel viewModel) {
        kotlin.jvm.internal.j.e(viewModel, "viewModel");
        this.x = viewModel;
    }

    public final void x() {
        if (com.tplink.libtpnetwork.Utils.j.h(this.M3)) {
            this.M3.postValue(Boolean.FALSE);
        }
    }

    public final MutableLiveData<String> z() {
        return this.H3;
    }
}
