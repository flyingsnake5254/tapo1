package com.tplink.iot.viewmodel.login;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

/* compiled from: RegionListItemViewModel.java */
/* loaded from: classes3.dex */
public class a {
    public final ObservableField<String> a;

    /* renamed from: b  reason: collision with root package name */
    public final ObservableField<String> f11174b;

    /* renamed from: c  reason: collision with root package name */
    public final ObservableBoolean f11175c;

    public a(String str, String str2, boolean z) {
        ObservableField<String> observableField = new ObservableField<>();
        this.a = observableField;
        ObservableField<String> observableField2 = new ObservableField<>();
        this.f11174b = observableField2;
        ObservableBoolean observableBoolean = new ObservableBoolean(false);
        this.f11175c = observableBoolean;
        observableField.set(str);
        observableField2.set(str2);
        observableBoolean.set(z);
    }
}
