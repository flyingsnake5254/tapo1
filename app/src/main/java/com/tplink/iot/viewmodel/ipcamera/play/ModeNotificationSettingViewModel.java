package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.core.view.PointerIconCompat;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.Utils.v0.d;

/* loaded from: classes3.dex */
public class ModeNotificationSettingViewModel extends AndroidViewModel {
    public ObservableBoolean i;
    public ObservableBoolean a = new ObservableBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public ObservableBoolean f10540b = new ObservableBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public ObservableBoolean f10541c = new ObservableBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public ObservableBoolean f10542d = new ObservableBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public ObservableField<String> f10543e = new ObservableField<>("09:00");

    /* renamed from: f  reason: collision with root package name */
    public ObservableField<String> f10544f = new ObservableField<>("17:00");
    public ObservableField<boolean[]> g = new ObservableField<>();
    public ObservableBoolean h = new ObservableBoolean(false);
    public int j = 540;
    public int k = PointerIconCompat.TYPE_GRAB;
    public int l = 127;

    public ModeNotificationSettingViewModel(@NonNull Application application) {
        super(application);
        ObservableBoolean observableBoolean = new ObservableBoolean(false);
        this.i = observableBoolean;
        observableBoolean.set(d.a());
    }
}
