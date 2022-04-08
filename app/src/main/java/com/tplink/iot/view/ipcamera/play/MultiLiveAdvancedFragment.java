package com.tplink.iot.view.ipcamera.play;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import b.d.d.m.f;
import com.tplink.iot.R;
import com.tplink.iot.Utils.MultiScreenSnapHelper;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.iot.databinding.DialogMultiLiveDragBinding;
import com.tplink.iot.view.ipcamera.play.SelectDeviceDialogFragment;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.widget.cameralive.VideoSurfaceViewLayout;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.Utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes2.dex */
public class MultiLiveAdvancedFragment extends MultiLiveBaseFragment {
    private final String u4 = MultiLiveAdvancedFragment.class.getSimpleName();
    protected com.tplink.iot.adapter.databinding.d v4 = new com.tplink.iot.adapter.databinding.d() { // from class: com.tplink.iot.view.ipcamera.play.p
        @Override // com.tplink.iot.adapter.databinding.d
        public final void a(View view, int i) {
            MultiLiveAdvancedFragment.this.n2(view, i);
        }
    };
    protected com.tplink.iot.adapter.databinding.e w4 = new com.tplink.iot.adapter.databinding.e() { // from class: com.tplink.iot.view.ipcamera.play.v
        @Override // com.tplink.iot.adapter.databinding.e
        public final boolean a(View view, int i) {
            return MultiLiveAdvancedFragment.this.p2(view, i);
        }
    };
    protected RecyclerView.OnItemTouchListener x4 = new a();

    /* loaded from: classes2.dex */
    class a extends RecyclerView.SimpleOnItemTouchListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            MultiLiveAdvancedFragment.this.f8915f.z();
            Dialog dialog = MultiLiveAdvancedFragment.this.h4;
            if (dialog == null || !dialog.isShowing() || MultiLiveAdvancedFragment.this.j4 == null) {
                return super.onInterceptTouchEvent(recyclerView, motionEvent);
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                MultiLiveAdvancedFragment.this.U1();
                Dialog dialog2 = MultiLiveAdvancedFragment.this.h4;
                if (dialog2 != null && dialog2.isShowing()) {
                    MultiLiveAdvancedFragment.this.h4.dismiss();
                }
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            MultiLiveAdvancedFragment.this.W1(motionEvent);
            super.onTouchEvent(recyclerView, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends DataBindingListAdapter {
        b(int i, int[] iArr, int[] iArr2, Object... objArr) {
            super(i, iArr, iArr2, objArr);
        }

        @Override // com.tplink.iot.adapter.databinding.DataBindingListAdapter
        /* renamed from: u */
        public void onBindViewHolder(DataBindingListAdapter.ViewHolder viewHolder, int i) {
            boolean z = MultiLiveAdvancedFragment.this.f8915f.p0.get();
            MultiLiveAdvancedFragment multiLiveAdvancedFragment = MultiLiveAdvancedFragment.this;
            if (multiLiveAdvancedFragment.R3 != multiLiveAdvancedFragment.O3.getWidth()) {
                MultiLiveAdvancedFragment multiLiveAdvancedFragment2 = MultiLiveAdvancedFragment.this;
                multiLiveAdvancedFragment2.R3 = multiLiveAdvancedFragment2.O3.getWidth();
                MultiLiveAdvancedFragment multiLiveAdvancedFragment3 = MultiLiveAdvancedFragment.this;
                multiLiveAdvancedFragment3.Q3 = (int) (multiLiveAdvancedFragment3.R3 / 2.0f);
            }
            viewHolder.itemView.getLayoutParams().width = z ? MultiLiveAdvancedFragment.this.Q3 : MultiLiveAdvancedFragment.this.R3;
            super.onBindViewHolder(viewHolder, i);
        }
    }

    /* loaded from: classes2.dex */
    class c extends GridLayoutManager {
        c(Context context, int i, int i2, boolean z) {
            super(context, i, i2, z);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutCompleted(RecyclerView.State state) {
            MultiLiveAdvancedFragment multiLiveAdvancedFragment;
            int i;
            super.onLayoutCompleted(state);
            MultiLiveAdvancedFragment multiLiveAdvancedFragment2 = MultiLiveAdvancedFragment.this;
            if (multiLiveAdvancedFragment2.N3) {
                if (multiLiveAdvancedFragment2.M3 < multiLiveAdvancedFragment2.L3.getItemCount() && (i = (multiLiveAdvancedFragment = MultiLiveAdvancedFragment.this).M3) >= 0) {
                    try {
                        multiLiveAdvancedFragment.J3.z.smoothScrollToPosition(i);
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                    }
                }
                String str = MultiLiveAdvancedFragment.this.u4;
                b.d.w.c.a.c(str, "scrollToBrowsingPos:" + MultiLiveAdvancedFragment.this.M3);
                MultiLiveAdvancedFragment multiLiveAdvancedFragment3 = MultiLiveAdvancedFragment.this;
                multiLiveAdvancedFragment3.N3 = false;
                multiLiveAdvancedFragment3.f8915f.o0();
            }
            MultiLiveAdvancedFragment.this.D2();
        }
    }

    /* loaded from: classes2.dex */
    class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                recyclerView.invalidateItemDecorations();
                MultiLiveAdvancedFragment.this.E2();
                MultiLiveAdvancedFragment.this.D2();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            MultiLiveAdvancedFragment.this.E2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Dialog dialog = MultiLiveAdvancedFragment.this.p1;
            if (dialog != null && dialog.isShowing()) {
                MultiLiveAdvancedFragment.this.p1.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A2 */
    public /* synthetic */ void B2(int i, DialogInterface dialogInterface) {
        this.p2.setImageBitmap(this.p3);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.p2.getLayoutParams();
        marginLayoutParams.setMarginStart(this.I3.left);
        Rect rect = this.I3;
        marginLayoutParams.topMargin = rect.top - i;
        marginLayoutParams.height = rect.height();
        marginLayoutParams.width = this.I3.width();
        this.p2.setLayoutParams(marginLayoutParams);
        final int a2 = (this.H3.top - this.I3.top) - b.d.w.f.a.a(getContext(), 16.0f);
        Rect rect2 = this.H3;
        final int i2 = rect2.left - this.I3.left;
        final float height = rect2.height() / this.I3.height();
        final float width = this.H3.width() / this.I3.width();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.iot.view.ipcamera.play.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                MultiLiveAdvancedFragment.this.r2(r2, width, height, i2, a2, valueAnimator);
            }
        });
        ofFloat.addListener(new e());
        ofFloat.start();
    }

    private void P0() {
        MultiLiveVideoViewModel multiLiveVideoViewModel = this.f8915f;
        b bVar = new b(R.layout.item_multi_live, new int[]{16, 86, 9, 59, 46, 13, 83, 39, 25, 101}, new int[]{16}, this.z, this.p4, this.v4, this.w4, multiLiveVideoViewModel.p0, multiLiveVideoViewModel.y, this.o4, multiLiveVideoViewModel.X3, this.f8914d.G, multiLiveVideoViewModel.Z3);
        this.L3 = bVar;
        bVar.B(this);
    }

    private void S0() {
        this.J3.z.addOnItemTouchListener(this.x4);
    }

    private int V1(Rect rect, Rect rect2) {
        int i;
        int i2 = rect.left;
        int i3 = rect2.left;
        if (i2 <= i3) {
            i2 = i3;
        }
        int i4 = rect.right;
        int i5 = rect2.right;
        if (i4 >= i5) {
            i4 = i5;
        }
        if (i2 >= i4) {
            return 0;
        }
        int i6 = rect.top;
        int i7 = rect2.top;
        if (i6 <= i7) {
            i6 = i7;
        }
        int i8 = rect.bottom;
        int i9 = rect2.bottom;
        if (i8 >= i9) {
            i8 = i9;
        }
        if (i6 < i8 && (i = (i8 - i6) * (i4 - i2)) >= 0) {
            return i;
        }
        return 0;
    }

    private void X1() {
        if (this.s4 != null && this.y.t.get()) {
            this.s4.C0(true);
            this.y.t.set(false);
        }
    }

    private void Y1(GridLayoutManager gridLayoutManager, int i) {
        int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        boolean z = false;
        for (int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            View findViewByPosition = gridLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (!(findViewByPosition == null || findViewByPosition.getWidth() == i)) {
                findViewByPosition.getLayoutParams().width = i;
                z = true;
            }
        }
        if (z) {
            this.P3.setInitialPrefetchItemCount(0);
            this.P3.setItemPrefetchEnabled(false);
            this.J3.z.setItemViewCacheSize(0);
            this.P3.setInitialPrefetchItemCount(2);
            this.P3.setItemPrefetchEnabled(true);
            this.J3.z.setItemViewCacheSize(2);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void b2() {
        this.y.t.set(true);
        this.s4.show(getChildFragmentManager(), "CameraAudioDialog");
        this.s4.Q0(new DialogInterface.OnDismissListener() { // from class: com.tplink.iot.view.ipcamera.play.s
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                MultiLiveAdvancedFragment.this.f2(dialogInterface);
            }
        });
        this.s4.P0(new View.OnTouchListener() { // from class: com.tplink.iot.view.ipcamera.play.o
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return MultiLiveAdvancedFragment.this.h2(view, motionEvent);
            }
        });
        this.f8915f.Q3.set(false);
        this.f8915f.a4.set(false);
    }

    private void d2(boolean z) {
        com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String> value = this.f8914d.l().getValue();
        String c2 = value == null ? "" : value.c();
        if (z) {
            if ("VideoPlay.CloudTerraceControlFragment".equals(c2)) {
                this.f8915f.I3.set(true);
            } else if ("VideoPlay.VideoControlPanelFragment".equals(c2)) {
                this.f8915f.I3.set(false);
            }
        } else if (this.y.k.get()) {
        } else {
            if (this.f8915f.I3.get()) {
                if ("VideoPlay.VideoControlPanelFragment".equals(c2)) {
                    this.f8914d.y("VideoPlay.CloudTerraceControlFragment");
                }
            } else if ("VideoPlay.CloudTerraceControlFragment".equals(c2)) {
                this.f8914d.y("VideoPlay.VideoControlPanelFragment");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e2 */
    public /* synthetic */ void f2(DialogInterface dialogInterface) {
        this.y.t.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g2 */
    public /* synthetic */ boolean h2(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            LiveMediaAPI.disableRelayTimer();
            this.f8915f.A();
        } else if (action == 1 || action == 3) {
            LiveMediaAPI.enableRelayTimer();
            this.f8915f.B();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i2 */
    public /* synthetic */ boolean j2(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        this.a4 = motionEvent.getX();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k2 */
    public /* synthetic */ void l2(View view) {
        boolean z = this.f8915f.p0.get();
        int i = 1;
        int i2 = this.Y3 - 1;
        if (this.a4 * 3.0f < view.getWidth()) {
            i2--;
        } else if (this.a4 * 3.0f > view.getWidth() * 2) {
            i2++;
        }
        if (z) {
            i = 4;
        }
        int i3 = i2 * i;
        if (i3 >= 0 && i3 != this.P3.getItemCount()) {
            this.J3.z.smoothScrollToPosition(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m2 */
    public /* synthetic */ void n2(View view, int i) {
        if (!j.h(this.f8915f.p1)) {
            if (view.getId() == R.id.add_device_btn_small || view.getId() == R.id.add_device_btn_big) {
                this.X3 = i;
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = this.z.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        arrayList.add(next);
                    }
                }
                if (this.f8914d.G.get()) {
                    SelectDeviceDialogFragment selectDeviceDialogFragment = new SelectDeviceDialogFragment();
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("added_mac_list", arrayList);
                    bundle.putString("persisted_mac", this.p0);
                    selectDeviceDialogFragment.setArguments(bundle);
                    selectDeviceDialogFragment.O0(new SelectDeviceDialogFragment.b() { // from class: com.tplink.iot.view.ipcamera.play.d4
                        @Override // com.tplink.iot.view.ipcamera.play.SelectDeviceDialogFragment.b
                        public final void a(ArrayList arrayList2, ArrayList arrayList3) {
                            MultiLiveAdvancedFragment.this.S1(arrayList2, arrayList3);
                        }
                    });
                    FragmentManager fragmentManager = getFragmentManager();
                    Objects.requireNonNull(fragmentManager);
                    selectDeviceDialogFragment.show(fragmentManager, SelectDeviceDialogFragment.f8926c);
                    return;
                }
                Intent intent = new Intent(getContext(), SelectDeviceActivity.class);
                intent.putExtra("added_mac_list", arrayList);
                intent.putExtra("persisted_mac", this.p0);
                startActivityForResult(intent, 2);
            } else if (j.b(this.f8915f.y, Integer.valueOf(i))) {
                this.f8915f.w();
            } else {
                this.f8915f.y.setValue(Integer.valueOf(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o2 */
    public /* synthetic */ boolean p2(View view, int i) {
        String str = this.z.get(i);
        if (str == null) {
            return true;
        }
        this.n4.setValue(Boolean.valueOf(str.equals(this.p0)));
        this.b4 = i;
        View findViewByPosition = this.P3.findViewByPosition(i);
        if (findViewByPosition == null) {
            return false;
        }
        VideoSurfaceViewLayout videoSurfaceViewLayout = (VideoSurfaceViewLayout) findViewByPosition.findViewById(R.id.video_surface_view);
        if (videoSurfaceViewLayout.p3.get() || videoSurfaceViewLayout.p2.get()) {
            Bitmap K0 = K0(videoSurfaceViewLayout);
            if (this.f8915f.p0.get() && getContext() != null) {
                int a2 = b.d.w.f.a.a(getContext(), 1.0f);
                if (K0 != null) {
                    int i2 = a2 * 2;
                    K0 = Bitmap.createBitmap(K0, a2, a2, K0.getWidth() - i2, K0.getHeight() - i2);
                }
            }
            this.m4.setValue(new f<>(new Pair(K0, null)));
        } else {
            LiveMediaAPI.snapshot(str, this.m4);
        }
        videoSurfaceViewLayout.c0();
        if (this.f8915f.p0.get()) {
            this.f4 = (view.getWidth() * view.getHeight()) >> 2;
            Rect[] rectArr = new Rect[4];
            this.g4 = rectArr;
            rectArr[0] = J0(view);
            this.f8915f.F(this.g4, view.getWidth(), view.getHeight(), i);
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = this.c4;
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.bottom = iArr[1] + view.getHeight();
        this.c4.right = iArr[0] + view.getWidth();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q2 */
    public /* synthetic */ void r2(float f2, float f3, float f4, int i, int i2, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f5 = 1.0f - floatValue;
        this.p2.setAlpha((f2 * floatValue) + f5);
        this.p2.setScaleX((f3 * floatValue) + f5);
        this.p2.setScaleY((f4 * floatValue) + f5);
        this.p2.setTranslationX(i * floatValue);
        this.p2.setTranslationY(i2 * floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s2 */
    public /* synthetic */ void t2(View view, int i) {
        if (this.f8914d.G.get()) {
            view.setSystemUiVisibility(Build.VERSION.SDK_INT >= 19 ? 5894 : 1799);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u2 */
    public /* synthetic */ void v2(DialogInterface dialogInterface) {
        this.o4.setValue(Boolean.FALSE);
        this.j4.setTranslationX(0.0f);
        this.j4.setTranslationY(0.0f);
        this.d4 = -1;
        this.e4 = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w2 */
    public /* synthetic */ void x2(DialogInterface dialogInterface) {
        Window window = this.h4.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.8f;
            window.setAttributes(attributes);
            window.addFlags(2);
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            Rect rect2 = this.i4;
            Rect rect3 = this.c4;
            rect2.left = rect3.left - rect.left;
            rect2.top = rect3.top - rect.top;
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.j4.getLayoutParams();
            layoutParams.setMarginStart(this.i4.left);
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.i4.top;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = this.c4.height();
            ((ViewGroup.MarginLayoutParams) layoutParams).width = this.c4.width();
            this.j4.setLayoutParams(layoutParams);
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.k4.getLayoutParams();
            layoutParams2.setMarginStart(this.i4.left);
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = this.i4.top;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = this.c4.height();
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = this.c4.width();
            this.k4.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y2 */
    public /* synthetic */ boolean z2(View view, MotionEvent motionEvent) {
        W1(motionEvent);
        return true;
    }

    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment
    protected void B0() {
        if (this.f8914d.j != null) {
            com.tplink.iot.Utils.x0.e.d(this.f8915f.C());
        }
        if (this.f8915f.y()) {
            TSnackbar B = TSnackbar.B(this, R.string.multi_live_debut_hint, PathInterpolatorCompat.MAX_NUM_POINTS);
            B.J(Color.parseColor("#4CA6FF"));
            if (getContext() != null) {
                B.G(getContext().getResources().getDrawable(R.mipmap.close_white), null);
            }
            B.N();
        }
        LiveMediaAPI.keepDoubleTalk(this.f8915f.C());
        boolean z = this.f8915f.p0.get();
        P1();
        this.f8915f.E0();
        this.L3.n();
        MultiLiveVideoViewModel multiLiveVideoViewModel = this.f8915f;
        this.M3 = (this.Y3 - 1) * multiLiveVideoViewModel.x;
        MutableLiveData<Integer> mutableLiveData = multiLiveVideoViewModel.y;
        boolean z2 = false;
        int intValue = ((Integer) j.e(mutableLiveData, 0)).intValue();
        int i = 4;
        if (z) {
            int i2 = this.M3;
            if (intValue > i2 && intValue - i2 < 4) {
                z2 = true;
            }
            if (z2) {
                this.M3 = intValue;
            }
        }
        boolean z3 = !z;
        MultiLiveVideoViewModel multiLiveVideoViewModel2 = this.f8915f;
        multiLiveVideoViewModel2.x = z3 ? 4 : 1;
        multiLiveVideoViewModel2.p0.set(z3);
        MultiScreenSnapHelper multiScreenSnapHelper = this.K3;
        if (!z3) {
            i = 1;
        }
        multiScreenSnapHelper.d(i);
        this.N3 = true;
        c cVar = new c(getContext(), z3 ? 2 : 1, 0, false);
        this.P3 = cVar;
        this.J3.z.setLayoutManager(cVar);
    }

    protected void C2() {
        if (this.z.get(this.b4) == null || this.z.get(this.b4).equals(this.p0) || !c2()) {
            this.l4.setBackground(null);
            this.k4.setVisibility(0);
            if (this.f8915f.p0.get()) {
                int a2 = a2();
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.k4.getLayoutParams();
                if (a2 == -1) {
                    int marginStart = layoutParams.getMarginStart();
                    Rect rect = this.i4;
                    int i = rect.left;
                    if (marginStart != i || ((ViewGroup.MarginLayoutParams) layoutParams).topMargin != rect.top) {
                        layoutParams.setMarginStart(i);
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.i4.top;
                        this.k4.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                }
                Rect rect2 = this.g4[a2 & 3];
                Rect rect3 = this.i4;
                int i2 = rect3.left;
                int i3 = rect2.left;
                Rect rect4 = this.c4;
                int i4 = i2 + (i3 - rect4.left);
                int i5 = rect3.top + (rect2.top - rect4.top);
                if (layoutParams.getMarginStart() != i4 || ((ViewGroup.MarginLayoutParams) layoutParams).topMargin != i5) {
                    layoutParams.setMarginStart(i4);
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i5;
                    this.k4.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            return;
        }
        this.l4.setBackground(getResources().getDrawable(R.drawable.circle_bg));
        this.k4.setVisibility(4);
    }

    protected void D2() {
        int findFirstVisibleItemPosition = this.P3.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.P3.findLastVisibleItemPosition();
        int intValue = ((Integer) j.e(this.f8915f.y, 0)).intValue();
        if (findFirstVisibleItemPosition == -1) {
            return;
        }
        if (findFirstVisibleItemPosition > intValue || intValue > findLastVisibleItemPosition) {
            for (int i = findFirstVisibleItemPosition; i <= findLastVisibleItemPosition; i++) {
                if (!TextUtils.isEmpty(this.f8915f.z.get(i))) {
                    this.f8915f.y.setValue(Integer.valueOf(i));
                    return;
                }
            }
            if (!j.b(this.f8915f.y, Integer.valueOf(findFirstVisibleItemPosition))) {
                this.f8915f.y.setValue(Integer.valueOf(findFirstVisibleItemPosition));
            }
        }
    }

    protected void E2() {
        boolean z = this.f8915f.p0.get();
        int i = z ? 8 : 32;
        boolean z2 = true;
        if (this.Z3 != i) {
            this.Z3 = i;
            z2 = true;
        } else {
            z2 = false;
        }
        int findFirstVisibleItemPosition = this.P3.findFirstVisibleItemPosition();
        if (!z || (findFirstVisibleItemPosition & 3) <= 1) {
            int i2 = (findFirstVisibleItemPosition / this.f8915f.x) + 1;
            if (this.Y3 != i2) {
                this.Y3 = i2;
            }
            if (z2) {
                this.J3.p0.setText(Z1());
            }
        }
    }

    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment
    protected void H0() {
        X1();
    }

    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment
    protected void I0() {
        X1();
    }

    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment
    @SuppressLint({"ClickableViewAccessibility"})
    protected void J1() {
        if (!this.y.t.get()) {
            this.s4 = MicrophoneControlDialogFragment.S0(this.f8914d.G.get());
            Context context = getContext();
            if (context != null) {
                if (this.f8914d.G.get()) {
                    this.s4.A0(this.J3.f7036d.f7234f, b.d.w.f.a.a(context, 27.0f), -b.d.w.f.a.a(context, 6.0f));
                } else {
                    this.s4.A0(this.J3.p3.p3, b.d.w.f.a.a(context, 74.0f), -b.d.w.f.a.a(context, 36.0f));
                }
            }
            b2();
        }
    }

    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment
    @SuppressLint({"ClickableViewAccessibility"})
    protected void K1() {
        if (getContext() != null) {
            Dialog dialog = this.h4;
            if (dialog == null) {
                Dialog dialog2 = new Dialog(getContext(), R.style.LiveDragDialog);
                this.h4 = dialog2;
                dialog2.setContentView(R.layout.dialog_multi_live_drag);
                H1(this.h4);
                DialogMultiLiveDragBinding dialogMultiLiveDragBinding = (DialogMultiLiveDragBinding) DataBindingUtil.bind(this.h4.findViewById(R.id.container));
                if (dialogMultiLiveDragBinding != null) {
                    dialogMultiLiveDragBinding.setLifecycleOwner(this);
                    dialogMultiLiveDragBinding.h(this.n4);
                }
                ImageView imageView = (ImageView) this.h4.findViewById(R.id.multi_live_bin);
                this.l4 = imageView;
                imageView.setImageResource(R.drawable.bin);
                this.h4.findViewById(R.id.container).setOnTouchListener(new View.OnTouchListener() { // from class: com.tplink.iot.view.ipcamera.play.x
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return MultiLiveAdvancedFragment.this.z2(view, motionEvent);
                    }
                });
                this.k4 = this.h4.findViewById(R.id.position_trend_frame);
                this.j4 = (ImageView) this.h4.findViewById(R.id.image);
                this.h4.setCanceledOnTouchOutside(false);
                this.h4.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tplink.iot.view.ipcamera.play.u
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MultiLiveAdvancedFragment.this.v2(dialogInterface);
                    }
                });
                this.h4.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tplink.iot.view.ipcamera.play.w
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        MultiLiveAdvancedFragment.this.x2(dialogInterface);
                    }
                });
            } else {
                H1(dialog);
            }
            this.h4.show();
        }
    }

    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment
    protected void M1(Bitmap bitmap) {
        if (getContext() != null && bitmap != null) {
            Dialog dialog = this.h4;
            if ((dialog == null || !dialog.isShowing()) && getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                this.p3 = bitmap;
                if (this.H3 == null) {
                    this.H3 = new Rect();
                    FragmentActivity activity = getActivity();
                    Objects.requireNonNull(activity);
                    View findViewById = activity.findViewById(R.id.memory_tv);
                    if (findViewById != null) {
                        int[] iArr = new int[2];
                        findViewById.getLocationOnScreen(iArr);
                        Rect rect = this.H3;
                        int i = iArr[0];
                        rect.left = i;
                        rect.top = iArr[1];
                        rect.right = i + findViewById.getWidth();
                        Rect rect2 = this.H3;
                        rect2.bottom = rect2.top + findViewById.getHeight();
                    } else {
                        return;
                    }
                }
                View findViewByPosition = this.P3.findViewByPosition(this.f8915f.z.indexOf(this.f8915f.C()));
                if (findViewByPosition != null) {
                    int[] iArr2 = new int[2];
                    findViewByPosition.getLocationOnScreen(iArr2);
                    Rect rect3 = this.I3;
                    int i2 = iArr2[0];
                    rect3.left = i2;
                    rect3.top = iArr2[1];
                    rect3.right = i2 + findViewByPosition.getWidth();
                    Rect rect4 = this.I3;
                    rect4.bottom = rect4.top + findViewByPosition.getHeight();
                    if (this.p1 == null) {
                        Dialog dialog2 = new Dialog(getContext(), R.style.LiveDragDialog);
                        this.p1 = dialog2;
                        dialog2.setContentView(R.layout.dialog_multi_live_screen_shot);
                        H1(this.p1);
                        this.p1.setCancelable(false);
                        ImageView imageView = (ImageView) this.p1.findViewById(R.id.screen_shot);
                        this.p2 = imageView;
                        imageView.setPivotX(0.0f);
                        this.p2.setPivotY(0.0f);
                        Window window = this.p1.getWindow();
                        if (window != null) {
                            window.setDimAmount(0.2f);
                            Rect rect5 = new Rect();
                            window.getDecorView().getWindowVisibleDisplayFrame(rect5);
                            final int i3 = rect5.top;
                            this.p1.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tplink.iot.view.ipcamera.play.t
                                @Override // android.content.DialogInterface.OnShowListener
                                public final void onShow(DialogInterface dialogInterface) {
                                    MultiLiveAdvancedFragment.this.B2(i3, dialogInterface);
                                }
                            });
                        } else {
                            return;
                        }
                    }
                    this.p1.show();
                }
            }
        }
    }

    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment
    protected void N1() {
        if (!this.y.t.get()) {
            this.s4 = VolumeControlDialogFragment.S0(true);
            Context context = getContext();
            if (context != null) {
                this.s4.A0(this.J3.f7036d.x, -b.d.w.f.a.a(context, 10.0f), -b.d.w.f.a.a(context, 6.0f));
                b2();
            }
        }
    }

    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment
    protected void P1() {
        for (int i = 0; i < 32; i += 4) {
            int i2 = i + 1;
            String str = this.z.get(i2);
            int i3 = i + 2;
            String str2 = this.z.get(i3);
            if (str != null || str2 != null) {
                this.z.set(i2, str2);
                this.z.set(i3, str);
            }
        }
    }

    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment
    @SuppressLint({"ClickableViewAccessibility"})
    protected void Q0() {
        this.J3.p0.setText("<   01/32   >");
        this.J3.z.addOnScrollListener(new d());
        this.J3.p0.setOnTouchListener(new View.OnTouchListener() { // from class: com.tplink.iot.view.ipcamera.play.r
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return MultiLiveAdvancedFragment.this.j2(view, motionEvent);
            }
        });
        this.J3.p0.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiLiveAdvancedFragment.this.l2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment
    public void S1(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            if (this.f8915f.p0.get()) {
                P1();
                int i = this.X3;
                int i2 = i & 3;
                if (i2 == 2) {
                    i--;
                } else if (i2 == 1) {
                    i++;
                }
                this.f8915f.J0(arrayList, arrayList2, i);
                P1();
            } else {
                this.f8915f.J0(arrayList, arrayList2, this.X3);
            }
            if (arrayList.size() > 0) {
                this.f8915f.y.setValue(Integer.valueOf(this.X3));
            }
            this.M3 = this.f8915f.E(this.X3);
            this.L3.s();
            this.P3.scrollToPositionWithOffset(this.M3, 0);
        }
    }

    protected void U1() {
        int a2;
        if (!TextUtils.equals(this.z.get(this.b4), this.p0) && c2()) {
            this.z.set(this.b4, null);
            this.L3.notifyItemChanged(this.b4);
            if (!this.f8915f.p0.get()) {
                int i = this.f8915f.p3;
                this.M3 = i;
                this.P3.scrollToPosition(i);
            } else {
                MultiLiveVideoViewModel multiLiveVideoViewModel = this.f8915f;
                int i2 = multiLiveVideoViewModel.p3;
                this.M3 = i2;
                multiLiveVideoViewModel.y.setValue(Integer.valueOf(i2));
            }
            this.J3.z.invalidateItemDecorations();
        } else if (this.f8915f.p0.get() && (a2 = a2()) != -1) {
            this.z.set(a2, this.z.get(this.b4));
            this.z.set(this.b4, this.z.get(a2));
            this.M3 = this.f8915f.E(a2);
            this.f8915f.y.setValue(Integer.valueOf(a2));
            this.L3.s();
            if ((a2 & 3) == 0) {
                this.P3.scrollToPositionWithOffset(this.M3, 0);
            } else {
                this.P3.scrollToPosition(this.M3);
            }
            this.J3.z.invalidateItemDecorations();
        }
    }

    protected void W1(MotionEvent motionEvent) {
        this.f8915f.z();
        Dialog dialog = this.h4;
        if (dialog != null && dialog.isShowing() && this.j4 != null) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return;
                    }
                } else if (this.d4 == -1) {
                    this.d4 = (int) motionEvent.getRawX();
                    this.e4 = (int) motionEvent.getRawY();
                    return;
                } else {
                    int rawX = (int) motionEvent.getRawX();
                    int rawY = (int) motionEvent.getRawY();
                    ImageView imageView = this.j4;
                    imageView.setTranslationX(imageView.getTranslationX() + (rawX - this.d4));
                    ImageView imageView2 = this.j4;
                    imageView2.setTranslationY(imageView2.getTranslationY() + (rawY - this.e4));
                    this.d4 = rawX;
                    this.e4 = rawY;
                    C2();
                    return;
                }
            }
            U1();
            Dialog dialog2 = this.h4;
            if (dialog2 != null && dialog2.isShowing()) {
                this.h4.dismiss();
            }
        }
    }

    protected String Z1() {
        StringBuilder sb = new StringBuilder();
        sb.append("<   ");
        String str = "0";
        sb.append(this.Y3 < 10 ? str : "");
        sb.append(this.Y3);
        sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (this.Z3 >= 10) {
            str = "";
        }
        sb.append(str);
        sb.append(this.Z3);
        sb.append("   >");
        return sb.toString();
    }

    protected int a2() {
        Rect J0 = J0(this.j4);
        int i = this.f4;
        int E = this.f8915f.E(this.b4);
        if (this.g4 == null) {
            return -1;
        }
        int i2 = -1;
        for (int i3 = 0; i3 < 4; i3++) {
            int V1 = V1(this.g4[i3], J0);
            if (V1 > i) {
                i2 = E + i3;
                i = V1;
            }
        }
        if (this.b4 == i2) {
            return -1;
        }
        return i2;
    }

    protected boolean c2() {
        return V1(J0(this.l4), J0(this.j4)) > 0;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        GridLayoutManager gridLayoutManager;
        super.onConfigurationChanged(configuration);
        if (j.a(this.f8914d.f10584f, R.string.live_video_change_resolutions_tips)) {
            this.f8914d.f10584f.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(""));
        }
        boolean z = true;
        if (!(getActivity() == null || (gridLayoutManager = this.P3) == null)) {
            int findLastVisibleItemPosition = this.P3.findLastVisibleItemPosition();
            boolean e2 = com.tplink.iot.Utils.j.e(getActivity());
            b.d.w.c.a.a("CameraScreen hasCutout: " + e2);
            if (configuration.orientation != 2 || !e2) {
                this.R3 = this.O3.getHeight();
            } else {
                this.R3 = this.O3.getHeight() - b.d.w.f.a.f(getActivity());
            }
            this.Q3 = (int) (this.R3 / 2.0f);
            boolean z2 = this.f8915f.p0.get();
            for (int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
                View findViewByPosition = this.P3.findViewByPosition(findFirstVisibleItemPosition);
                if (findViewByPosition != null) {
                    findViewByPosition.getLayoutParams().width = z2 ? this.Q3 : this.R3;
                }
            }
            this.P3.setInitialPrefetchItemCount(0);
            this.P3.setItemPrefetchEnabled(false);
            this.J3.z.setItemViewCacheSize(0);
            this.P3.setInitialPrefetchItemCount(2);
            this.P3.setItemPrefetchEnabled(true);
            this.J3.z.setItemViewCacheSize(2);
        }
        if (configuration.orientation != 2) {
            z = false;
        }
        d2(z);
    }

    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        P0();
        if (getActivity() != null) {
            final View decorView = getActivity().getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.tplink.iot.view.ipcamera.play.q
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public final void onSystemUiVisibilityChange(int i) {
                    MultiLiveAdvancedFragment.this.t2(decorView, i);
                }
            });
        }
    }

    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        S0();
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Y1(this.P3, this.f8915f.p0.get() ? this.Q3 : this.R3);
        LiveMediaAPI.bindRecordingVariable(this.f8915f.e4);
    }

    @Override // com.tplink.iot.view.ipcamera.play.MultiLiveBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (LiveMediaAPI.getRecordingObservable() == this.f8915f.e4) {
            LiveMediaAPI.bindRecordingVariable(null);
        }
    }
}
