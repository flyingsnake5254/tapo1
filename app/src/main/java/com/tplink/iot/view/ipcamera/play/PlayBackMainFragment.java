package com.tplink.iot.view.ipcamera.play;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import b.d.q.b.o;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.ActivityPlaybackNewIpcBinding;
import com.tplink.iot.view.ipcamera.play.RelayLimitDialogFragment;
import com.tplink.iot.view.ipcamera.setting.StoreManageActivity;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoDisplayMode;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import java.util.Objects;

/* loaded from: classes2.dex */
public class PlayBackMainFragment extends BaseFragment {
    private boolean p0 = false;
    private PlayBackFragment q;
    private PlayBackControlFragment x;
    private ActivityPlaybackNewIpcBinding y;
    private PlaybackMainViewModel z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String> aVar) {
            String a = aVar.a();
            if (a != null) {
                PlayBackMainFragment.this.Z0(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements RelayLimitDialogFragment.a {
        b() {
        }

        @Override // com.tplink.iot.view.ipcamera.play.RelayLimitDialogFragment.a
        public void a() {
            PlayBackMainFragment.this.B0();
        }

        @Override // com.tplink.iot.view.ipcamera.play.RelayLimitDialogFragment.a
        public void b() {
            PlayBackMainFragment.this.z.y.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
        }
    }

    private void J0() {
        if (this.x == null) {
            this.x = new PlayBackControlFragment();
        }
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity);
        FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
        if (!this.x.isAdded()) {
            PlayBackControlFragment playBackControlFragment = this.x;
            beginTransaction.add(R.id.control_fragment, playBackControlFragment, playBackControlFragment.getClass().getName());
        }
        beginTransaction.commitAllowingStateLoss();
    }

    private void K0() {
        if (this.q == null) {
            this.q = new PlayBackFragment();
        }
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity);
        FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
        if (!this.q.isAdded()) {
            PlayBackFragment playBackFragment = this.q;
            beginTransaction.add(R.id.video_fragment, playBackFragment, playBackFragment.getClass().getName());
        }
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void O0(String str, View view) {
        Intent intent = new Intent(getContext(), StoreManageActivity.class);
        intent.putExtra("device_id_md5", str);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ void Q0(DialogInterface dialogInterface) {
        this.p0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0 */
    public /* synthetic */ void S0(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        String str = (String) aVar.a();
        if (str != null) {
            TSnackbar.A(TSnackbar.s(this), str, PathInterpolatorCompat.MAX_NUM_POINTS).N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0 */
    public /* synthetic */ void U0(PlaybackMainViewModel.b bVar) {
        TipsBar tipsBar = this.y.f6641f;
        String str = bVar.a;
        boolean z = bVar.f10557b;
        tipsBar.o(str, z, z ? 0L : 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V0 */
    public /* synthetic */ void W0() {
        this.y.f6641f.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(String str) {
        if (getActivity() != null && !this.p0) {
            this.p0 = true;
            RelayLimitDialogFragment relayLimitDialogFragment = new RelayLimitDialogFragment();
            relayLimitDialogFragment.J0(str);
            relayLimitDialogFragment.L0(new b());
            relayLimitDialogFragment.K0(new DialogInterface.OnDismissListener() { // from class: com.tplink.iot.view.ipcamera.play.o1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PlayBackMainFragment.this.Q0(dialogInterface);
                }
            });
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity);
            relayLimitDialogFragment.show(activity.getSupportFragmentManager(), "main.RelayLimitDialogFragment");
        }
    }

    private void a1() {
        this.z.l().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.m1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PlayBackMainFragment.this.S0((a) obj);
            }
        });
        this.z.x.observe(this, new a());
        j.d(this.z.j, this, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.view.ipcamera.play.k1
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                PlayBackMainFragment.this.U0((PlaybackMainViewModel.b) obj);
            }
        }, new Runnable() { // from class: com.tplink.iot.view.ipcamera.play.n1
            @Override // java.lang.Runnable
            public final void run() {
                PlayBackMainFragment.this.W0();
            }
        });
    }

    public boolean L0() {
        PlayBackFragment playBackFragment = this.q;
        return playBackFragment != null && playBackFragment.J0();
    }

    public void X0() {
        PlayBackFragment playBackFragment = this.q;
        if (playBackFragment != null) {
            playBackFragment.W0();
        }
    }

    public void Y0() {
        PlayBackFragment playBackFragment = this.q;
        if (playBackFragment != null) {
            playBackFragment.Y0();
        }
    }

    public void b1() {
        if (getActivity() != null) {
            if (this.z.r.get()) {
                FragmentActivity activity = getActivity();
                Objects.requireNonNull(activity);
                activity.getWindow().getDecorView().setSystemUiVisibility(4102);
                FragmentActivity activity2 = getActivity();
                Objects.requireNonNull(activity2);
                activity2.getWindow().setFlags(1024, 1024);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.y.q.getLayoutParams();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                FragmentActivity activity3 = getActivity();
                Objects.requireNonNull(activity3);
                activity3.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                layoutParams.width = displayMetrics.widthPixels;
                layoutParams.height = displayMetrics.heightPixels;
                this.y.f6639c.setVisibility(8);
                return;
            }
            FragmentActivity activity4 = getActivity();
            Objects.requireNonNull(activity4);
            activity4.getWindow().getDecorView().setSystemUiVisibility(0);
            FragmentActivity activity5 = getActivity();
            Objects.requireNonNull(activity5);
            WindowManager.LayoutParams attributes = activity5.getWindow().getAttributes();
            attributes.flags &= -1025;
            FragmentActivity activity6 = getActivity();
            Objects.requireNonNull(activity6);
            activity6.getWindow().setAttributes(attributes);
            FragmentActivity activity7 = getActivity();
            Objects.requireNonNull(activity7);
            activity7.getWindow().clearFlags(512);
            StatusBarUtils.l(getActivity(), true);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.y.q.getLayoutParams();
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            FragmentActivity activity8 = getActivity();
            Objects.requireNonNull(activity8);
            activity8.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics2);
            layoutParams2.width = displayMetrics2.widthPixels;
            Context context = getContext();
            Objects.requireNonNull(context);
            int a2 = o.a(context, 271.0f);
            int a3 = ((int) (displayMetrics2.widthPixels / 1.7777778f)) + o.a(getContext(), 75.0f);
            if (a2 < a3) {
                a2 = a3;
            }
            layoutParams2.height = a2;
            this.y.f6639c.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.y = (ActivityPlaybackNewIpcBinding) DataBindingUtil.inflate(layoutInflater, R.layout.activity_playback_new_ipc, viewGroup, false);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity);
        activity.getWindow().addFlags(128);
        final String stringExtra = getActivity().getIntent().getStringExtra("device_id_md5");
        PlaybackMainViewModel playbackMainViewModel = (PlaybackMainViewModel) ViewModelProviders.of(getActivity(), new CameraViewModelFactory(getActivity(), stringExtra)).get(PlaybackMainViewModel.class);
        this.z = playbackMainViewModel;
        playbackMainViewModel.B(VideoDisplayMode.PLAY_BACK);
        if (this.z.r.get()) {
            this.z.x(true);
        }
        K0();
        J0();
        a1();
        b1();
        this.y.f6641f.setCloseBtnImageResId(R.mipmap.arrow_more_white);
        this.y.f6641f.setCloseBtnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayBackMainFragment.this.O0(stringExtra, view);
            }
        });
        return this.y.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.z.h();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.y.f6641f.j();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        PlayBackFragment playBackFragment = this.q;
        if (playBackFragment != null) {
            playBackFragment.setUserVisibleHint(z);
        }
    }
}
