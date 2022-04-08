package com.tplink.iot.viewmodel.ipcamera.setting;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.OsdInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.g0.g;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.w;

/* compiled from: OSDTextSettingViewModel.kt */
/* loaded from: classes3.dex */
public final class OSDTextSettingViewModel extends ViewModel {
    private CameraSettingRepository a;

    /* renamed from: b  reason: collision with root package name */
    private CommonCameraRepository f10795b;

    /* renamed from: c  reason: collision with root package name */
    private String f10796c;

    /* renamed from: d  reason: collision with root package name */
    private OsdInfoCache f10797d;

    /* renamed from: e  reason: collision with root package name */
    private io.reactivex.e0.b f10798e = new io.reactivex.e0.b();

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<String> f10799f = new MutableLiveData<>();
    private final MutableLiveData<Boolean> g = new MutableLiveData<>();
    private final MutableLiveData<Boolean> h = new MutableLiveData<>();
    private final MutableLiveData<Boolean> i = new MutableLiveData<>();
    private ObservableBoolean j = new ObservableBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OSDTextSettingViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements kotlin.jvm.b.a<io.reactivex.e0.c> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CommonCameraRepository f10800c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ OSDTextSettingViewModel f10801d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OSDTextSettingViewModel.kt */
        /* renamed from: com.tplink.iot.viewmodel.ipcamera.setting.OSDTextSettingViewModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0239a<T> implements g<CameraComponent> {
            C0239a() {
            }

            /* renamed from: a */
            public final void accept(CameraComponent cameraComponent) {
                a.this.f10801d.j.set(cameraComponent.isSupportOsdLogo());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(CommonCameraRepository commonCameraRepository, OSDTextSettingViewModel oSDTextSettingViewModel) {
            super(0);
            this.f10800c = commonCameraRepository;
            this.f10801d = oSDTextSettingViewModel;
        }

        /* renamed from: a */
        public final io.reactivex.e0.c invoke() {
            return this.f10800c.K0().H0(new C0239a(), k9.f10986c);
        }
    }

    /* compiled from: OSDTextSettingViewModel.kt */
    /* loaded from: classes3.dex */
    static final class b<T> implements g<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OsdInfoCache f10803c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ OSDTextSettingViewModel f10804d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f10805f;

        b(OsdInfoCache osdInfoCache, OSDTextSettingViewModel oSDTextSettingViewModel, String str) {
            this.f10803c = osdInfoCache;
            this.f10804d = oSDTextSettingViewModel;
            this.f10805f = str;
        }

        /* renamed from: a */
        public final void accept(Boolean bool) {
            this.f10803c.setName(this.f10805f);
            this.f10804d.j().postValue(Boolean.FALSE);
            this.f10804d.i().postValue(Boolean.TRUE);
        }
    }

    /* compiled from: OSDTextSettingViewModel.kt */
    /* loaded from: classes3.dex */
    static final class c<T> implements g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OsdInfoCache f10806c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ OSDTextSettingViewModel f10807d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f10808f;

        c(OsdInfoCache osdInfoCache, OSDTextSettingViewModel oSDTextSettingViewModel, String str) {
            this.f10806c = osdInfoCache;
            this.f10807d = oSDTextSettingViewModel;
            this.f10808f = str;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f10807d.j().postValue(Boolean.FALSE);
            this.f10807d.h().postValue(Boolean.TRUE);
        }
    }

    public final boolean g(String text) {
        boolean D;
        j.e(text, "text");
        int length = text.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            String substring = text.substring(i, i2);
            j.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            D = w.D("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ- ", substring, false, 2, null);
            if (!D) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    public final MutableLiveData<Boolean> h() {
        return this.h;
    }

    public final MutableLiveData<Boolean> i() {
        return this.g;
    }

    public final MutableLiveData<Boolean> j() {
        return this.i;
    }

    public final MutableLiveData<String> k() {
        return this.f10799f;
    }

    public final void l(String str) {
        SettingsData x;
        this.f10796c = str;
        if (str != null) {
            CameraSettingRepository cameraSettingRepository = (CameraSettingRepository) e.c(str, CameraSettingRepository.class);
            this.a = cameraSettingRepository;
            String str2 = null;
            OsdInfoCache osdConfig = (cameraSettingRepository == null || (x = cameraSettingRepository.x()) == null) ? null : x.getOsdConfig();
            this.f10797d = osdConfig;
            MutableLiveData<String> mutableLiveData = this.f10799f;
            if (osdConfig != null) {
                str2 = osdConfig.getName();
            }
            mutableLiveData.postValue(str2);
            CommonCameraRepository commonCameraRepository = (CommonCameraRepository) e.c(str, CommonCameraRepository.class);
            this.f10795b = commonCameraRepository;
            if (commonCameraRepository != null) {
                new a(commonCameraRepository, this);
            }
        }
    }

    public final void m(String text) {
        CameraSettingRepository cameraSettingRepository;
        j.e(text, "text");
        OsdInfoCache osdInfoCache = this.f10797d;
        if (osdInfoCache != null && (cameraSettingRepository = this.a) != null) {
            this.i.postValue(Boolean.TRUE);
            io.reactivex.e0.b bVar = this.f10798e;
            OptionSwitch enable = osdInfoCache.getEnable();
            OptionSwitch optionSwitch = OptionSwitch.ON;
            boolean z = true;
            boolean z2 = enable == optionSwitch;
            if (osdInfoCache.getTextEnable() != optionSwitch) {
                z = false;
            }
            bVar.b(cameraSettingRepository.D1(z2, z, text, this.j.get()).H0(new b(osdInfoCache, this, text), new c(osdInfoCache, this, text)));
        }
    }
}
