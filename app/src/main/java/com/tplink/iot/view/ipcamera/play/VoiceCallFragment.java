package com.tplink.iot.view.ipcamera.play;

import android.content.Context;
import android.content.DialogInterface;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.e;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentVoiceCallBinding;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import com.tplink.libtpstreampreconnect.bean.TalkMode;
import java.util.Objects;

/* loaded from: classes2.dex */
public class VoiceCallFragment extends BaseFragment {
    private AudioManager p0;
    private String p1;
    private VolumeControlDialogFragment p2;
    private FragmentVoiceCallBinding q;
    private VideoPlayViewModel x;
    private TalkViewModel y;
    private ContentObserver z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            VoiceCallFragment.this.R0();
        }
    }

    private void I0() {
        this.y.k(TalkMode.AEC);
        AudioManager audioManager = this.p0;
        if (audioManager != null) {
            this.y.S(audioManager.getStreamMaxVolume(3), this.p0.getStreamVolume(3));
        }
    }

    private void J0() {
        AudioManager audioManager = (AudioManager) getActivity().getSystemService("audio");
        this.p0 = audioManager;
        audioManager.setMode(-1);
        this.p0.setSpeakerphoneOn(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void N0(DialogInterface dialogInterface) {
        this.q.f7137d.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0(DialogInterface dialogInterface) {
        this.y.t.set(false);
        this.q.f7137d.setAlpha(1.0f);
    }

    private void Q0() {
        long p = this.y.p();
        if (p != 0) {
            e.D(this.p1, (System.currentTimeMillis() - p) / 1000.0d);
            this.y.R(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        AudioManager audioManager = this.p0;
        if (audioManager != null) {
            int streamVolume = audioManager.getStreamVolume(3);
            this.y.S(this.p0.getStreamMaxVolume(3), streamVolume);
        }
    }

    private void T0() {
        this.q.f7137d.setAlpha(0.4f);
        VolumeControlDialogFragment S0 = VolumeControlDialogFragment.S0(false);
        this.p2 = S0;
        S0.Q0(new DialogInterface.OnDismissListener() { // from class: com.tplink.iot.view.ipcamera.play.z3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VoiceCallFragment.this.N0(dialogInterface);
            }
        });
        this.p2.B0(this.q.f7137d, 0, 0);
        this.p2.Q0(new DialogInterface.OnDismissListener() { // from class: com.tplink.iot.view.ipcamera.play.y3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VoiceCallFragment.this.P0(dialogInterface);
            }
        });
        this.p2.show(getChildFragmentManager(), "VOLUME_DIALOG");
        this.y.t.set(true);
    }

    private void U0() {
        if (this.z != null) {
            Context context = getContext();
            Objects.requireNonNull(context);
            context.getContentResolver().unregisterContentObserver(this.z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_tv /* 2131362002 */:
                this.x.y("VideoPlay.VideoControlPanelFragment");
                return;
            case R.id.call_button /* 2131362168 */:
                this.y.k.set(false);
                this.x.y("VideoPlay.VideoControlPanelFragment");
                return;
            case R.id.control_iv /* 2131362334 */:
                T0();
                return;
            case R.id.microphone_button /* 2131363456 */:
                this.y.c0();
                return;
            case R.id.speaker_button /* 2131364080 */:
                this.y.b0();
                return;
            default:
                return;
        }
    }

    public void S0() {
        this.z = new a(new Handler());
        Context context = getContext();
        Objects.requireNonNull(context);
        context.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.z);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.q = (FragmentVoiceCallBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_voice_call, viewGroup, false);
        J0();
        VideoPlayViewModel videoPlayViewModel = (VideoPlayViewModel) ViewModelProviders.of(getActivity()).get(VideoPlayViewModel.class);
        this.x = videoPlayViewModel;
        this.p1 = videoPlayViewModel.j;
        TalkViewModel talkViewModel = (TalkViewModel) ViewModelProviders.of(getActivity()).get(TalkViewModel.class);
        this.y = talkViewModel;
        talkViewModel.m();
        this.y.k.set(true);
        this.y.m.set(true);
        this.q.i(this.y);
        this.q.h(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.x3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceCallFragment.this.onClick(view);
            }
        });
        I0();
        return this.q.getRoot();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Q0();
        VolumeControlDialogFragment volumeControlDialogFragment = this.p2;
        if (volumeControlDialogFragment != null) {
            volumeControlDialogFragment.dismissAllowingStateLoss();
        }
        if (this.y.i.get()) {
            this.y.P(false, this.p1);
        }
        this.y.k.set(false);
        this.y.m.set(false);
        if (this.y.n.get() != null) {
            this.x.B(this.y.n.get());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        U0();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        S0();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.y.l(this.p1);
        this.y.m.set(false);
        this.y.Z();
        this.x.y("VideoPlay.VideoControlPanelFragment");
    }
}
