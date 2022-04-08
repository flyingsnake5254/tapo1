package com.tplink.iot.view.authflip;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.viewmodel.authflip.AppFlipAuthViewModel;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class BaseAppFlipFragment extends Fragment {

    /* renamed from: c  reason: collision with root package name */
    protected View f8326c;

    /* renamed from: d  reason: collision with root package name */
    protected z1 f8327d;

    /* renamed from: f  reason: collision with root package name */
    protected AppFlipAuthViewModel f8328f;

    @LayoutRes
    public abstract int A0();

    /* JADX INFO: Access modifiers changed from: protected */
    public void B0() {
        View peekDecorView;
        InputMethodManager inputMethodManager;
        FragmentActivity activity = getActivity();
        if (activity != null && (peekDecorView = activity.getWindow().peekDecorView()) != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getActivity() instanceof z1) {
            this.f8327d = (z1) getActivity();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f8326c = layoutInflater.inflate(A0(), viewGroup, false);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity);
        this.f8328f = (AppFlipAuthViewModel) ViewModelProviders.of(activity).get(AppFlipAuthViewModel.class);
        return this.f8326c;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        B0();
    }
}
