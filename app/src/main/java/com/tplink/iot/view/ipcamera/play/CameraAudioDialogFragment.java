package com.tplink.iot.view.ipcamera.play;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerConstraintLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.l0.a;
import io.reactivex.q;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class CameraAudioDialogFragment extends AppCompatDialogFragment {

    /* renamed from: c  reason: collision with root package name */
    protected boolean f8865c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f8866d;

    /* renamed from: f  reason: collision with root package name */
    protected DialogInterface.OnDismissListener f8867f;
    protected TalkViewModel p2;
    protected c p3;
    protected boolean q;
    protected View.OnTouchListener x;
    protected TouchListenerConstraintLayout y;
    protected int z = -1;
    protected int p0 = -1;
    protected int p1 = -1;
    @SuppressLint({"ClickableViewAccessibility"})
    protected View.OnTouchListener H3 = new View.OnTouchListener() { // from class: com.tplink.iot.view.ipcamera.play.b
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return CameraAudioDialogFragment.this.I0(view, motionEvent);
        }
    };

    private void G0(Window window) {
        window.setFlags(1024, 1024);
        window.getDecorView().setSystemUiVisibility(2566);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ boolean I0(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
            return false;
        }
        O0();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0(Window window, DialogInterface dialogInterface) {
        window.clearFlags(8);
        G0(window);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void N0(Long l) throws Exception {
        TalkViewModel talkViewModel = this.p2;
        if (talkViewModel != null) {
            talkViewModel.N();
        }
    }

    public void A0(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.p0 = iArr[0] + i + view.getWidth();
        this.p1 = iArr[1] + i2;
    }

    public void B0(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.p0 = iArr[0] + i + view.getWidth();
        this.z = iArr[1] + i2;
    }

    public void C0(boolean z) {
        if (!this.q) {
            this.f8866d = z;
            dismissAllowingStateLoss();
        }
    }

    protected void O0() {
        c cVar = this.p3;
        if (cVar != null && !cVar.isDisposed()) {
            this.p3.dispose();
        }
        this.p3 = q.W0(1L, TimeUnit.SECONDS).L0(a.c()).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: com.tplink.iot.view.ipcamera.play.a
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraAudioDialogFragment.this.N0((Long) obj);
            }
        });
    }

    public void P0(View.OnTouchListener onTouchListener) {
        this.x = onTouchListener;
        TouchListenerConstraintLayout touchListenerConstraintLayout = this.y;
        if (touchListenerConstraintLayout != null) {
            touchListenerConstraintLayout.setDispatchEventListener(onTouchListener);
        }
    }

    public void Q0(DialogInterface.OnDismissListener onDismissListener) {
        this.f8867f = onDismissListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R0(TouchListenerConstraintLayout touchListenerConstraintLayout) {
        this.y = touchListenerConstraintLayout;
        View.OnTouchListener onTouchListener = this.x;
        if (onTouchListener != null) {
            touchListenerConstraintLayout.setDispatchEventListener(onTouchListener);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() != null) {
            this.p2 = (TalkViewModel) ViewModelProviders.of(getActivity()).get(TalkViewModel.class);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        c cVar;
        super.onDestroyView();
        if (!this.f8866d && (cVar = this.p3) != null && !cVar.isDisposed()) {
            this.p3.dispose();
        }
        TalkViewModel talkViewModel = this.p2;
        if (talkViewModel != null) {
            talkViewModel.N();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.q) {
            this.q = true;
            super.onDismiss(dialogInterface);
            DialogInterface.OnDismissListener onDismissListener = this.f8867f;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        final Window window;
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Objects.requireNonNull(arguments);
        this.f8865c = arguments.getBoolean("isFullScreen");
        if (getDialog() != null && this.f8865c && (window = getDialog().getWindow()) != null) {
            window.addFlags(8);
            getDialog().setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tplink.iot.view.ipcamera.play.c
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    CameraAudioDialogFragment.this.K0(window, dialogInterface);
                }
            });
        }
    }
}
