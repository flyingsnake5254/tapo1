package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;

/* loaded from: classes3.dex */
public class ModeAlarmSettingViewModel extends AndroidViewModel {
    public ObservableBoolean a = new ObservableBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public ObservableBoolean f10530b = new ObservableBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public ObservableBoolean f10531c = new ObservableBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public ObservableField<String> f10532d = new ObservableField<>();

    /* renamed from: e  reason: collision with root package name */
    public ObservableField<String> f10533e = new ObservableField<>();

    /* renamed from: f  reason: collision with root package name */
    public ObservableField<String> f10534f = new ObservableField<>("00:00");
    public ObservableField<String> g = new ObservableField<>("23:59");
    public ObservableField<boolean[]> h = new ObservableField<>();
    public ObservableBoolean i = new ObservableBoolean(false);
    public ObservableBoolean j = new ObservableBoolean(false);

    public ModeAlarmSettingViewModel(@NonNull Application application) {
        super(application);
    }
}
