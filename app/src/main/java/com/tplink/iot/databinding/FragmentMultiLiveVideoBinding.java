package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentMultiLiveVideoBinding extends ViewDataBinding {
    @Bindable
    protected g H3;
    @Bindable
    protected VideoPlayViewModel I3;
    @Bindable
    protected TalkViewModel J3;
    @Bindable
    protected MultiLiveVideoViewModel K3;
    @Bindable
    protected CloudTerraceControlViewModel L3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7035c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LayoutFullScreenBottomBarBinding f7036d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LayoutFullScreenControlBinding f7037f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final CloudTerraceControlPanel p1;
    @NonNull
    public final TipsBar p2;
    @NonNull
    public final LayoutMultiLiveToolbarBottomBinding p3;
    @NonNull
    public final LayoutDayNightModeBinding q;
    @NonNull
    public final LayoutFullScreenQualityBinding x;
    @NonNull
    public final LayoutVoiceTalkPanelBinding y;
    @NonNull
    public final RecyclerView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentMultiLiveVideoBinding(Object obj, View view, int i, ImageView imageView, LayoutFullScreenBottomBarBinding layoutFullScreenBottomBarBinding, LayoutFullScreenControlBinding layoutFullScreenControlBinding, LayoutDayNightModeBinding layoutDayNightModeBinding, LayoutFullScreenQualityBinding layoutFullScreenQualityBinding, LayoutVoiceTalkPanelBinding layoutVoiceTalkPanelBinding, RecyclerView recyclerView, TextView textView, CloudTerraceControlPanel cloudTerraceControlPanel, TipsBar tipsBar, LayoutMultiLiveToolbarBottomBinding layoutMultiLiveToolbarBottomBinding) {
        super(obj, view, i);
        this.f7035c = imageView;
        this.f7036d = layoutFullScreenBottomBarBinding;
        this.f7037f = layoutFullScreenControlBinding;
        this.q = layoutDayNightModeBinding;
        this.x = layoutFullScreenQualityBinding;
        this.y = layoutVoiceTalkPanelBinding;
        this.z = recyclerView;
        this.p0 = textView;
        this.p1 = cloudTerraceControlPanel;
        this.p2 = tipsBar;
        this.p3 = layoutMultiLiveToolbarBottomBinding;
    }

    public abstract void h(@Nullable CloudTerraceControlViewModel cloudTerraceControlViewModel);

    public abstract void i(@Nullable MultiLiveVideoViewModel multiLiveVideoViewModel);

    public abstract void l(@Nullable VideoPlayViewModel videoPlayViewModel);

    public abstract void m(@Nullable g gVar);

    public abstract void n(@Nullable TalkViewModel talkViewModel);
}
