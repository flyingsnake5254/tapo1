package com.tplink.iot.view.ipcamera.setting.video;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.adapter.camera.VideoQualityAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityVideoQualityBinding;
import com.tplink.iot.databinding.MenuSaveBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.video.VideoQualityViewModel;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: VideoQualityActivity.kt */
/* loaded from: classes2.dex */
public final class VideoQualityActivity extends BaseActivity implements View.OnClickListener {
    private String p0;
    private MenuItem p1;
    private VideoQualityAdapter p2;
    private final VideoQualityAdapter.a p3 = new e();
    private ActivityVideoQualityBinding y;
    private VideoQualityViewModel z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoQualityActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements com.tplink.libtpnetwork.Utils.f0.b<Boolean> {
        a() {
        }

        /* renamed from: b */
        public final void a(Boolean it) {
            j.d(it, "it");
            if (it.booleanValue()) {
                VideoQualityActivity.this.finish();
            } else if (t0.g(VideoQualityActivity.this)) {
                TSnackbar.x(VideoQualityActivity.this, R.string.general_failed, 0).N();
            } else {
                TSnackbar.x(VideoQualityActivity.this, R.string.no_internet_connection_tip, 0).N();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoQualityActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer<ResolutionType> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(ResolutionType it) {
            VideoQualityActivity.e1(VideoQualityActivity.this).r(it);
            VideoQualityViewModel f1 = VideoQualityActivity.f1(VideoQualityActivity.this);
            j.d(it, "it");
            f1.p(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoQualityActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer<List<? extends ResolutionType>> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(List<? extends ResolutionType> list) {
            VideoQualityActivity.e1(VideoQualityActivity.this).s(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoQualityActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VideoQualityActivity.this.onBackPressed();
        }
    }

    /* compiled from: VideoQualityActivity.kt */
    /* loaded from: classes2.dex */
    static final class e implements VideoQualityAdapter.a {
        e() {
        }

        @Override // com.tplink.iot.adapter.camera.VideoQualityAdapter.a
        public final void a(ResolutionType resolutionType) {
            VideoQualityViewModel f1 = VideoQualityActivity.f1(VideoQualityActivity.this);
            j.d(resolutionType, "resolutionType");
            f1.p(resolutionType);
        }
    }

    /* compiled from: VideoQualityActivity.kt */
    /* loaded from: classes2.dex */
    static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VideoQualityViewModel f1 = VideoQualityActivity.f1(VideoQualityActivity.this);
            ResolutionType q = VideoQualityActivity.e1(VideoQualityActivity.this).q();
            j.d(q, "mVideoQualityAdapter.checkedRes");
            f1.o(q);
        }
    }

    public static final /* synthetic */ VideoQualityAdapter e1(VideoQualityActivity videoQualityActivity) {
        VideoQualityAdapter videoQualityAdapter = videoQualityActivity.p2;
        if (videoQualityAdapter == null) {
            j.t("mVideoQualityAdapter");
        }
        return videoQualityAdapter;
    }

    public static final /* synthetic */ VideoQualityViewModel f1(VideoQualityActivity videoQualityActivity) {
        VideoQualityViewModel videoQualityViewModel = videoQualityActivity.z;
        if (videoQualityViewModel == null) {
            j.t("mViewModel");
        }
        return videoQualityViewModel;
    }

    private final void g1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.p0 = stringExtra;
        if (stringExtra == null) {
            j.t("mDeviceIdMD5");
        }
        ViewModel viewModel = ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(VideoQualityViewModel.class);
        j.d(viewModel, "ViewModelProviders.of(th…ityViewModel::class.java)");
        this.z = (VideoQualityViewModel) viewModel;
        this.p2 = new VideoQualityAdapter(this, this.p3);
    }

    private final void h1() {
        VideoQualityViewModel videoQualityViewModel = this.z;
        if (videoQualityViewModel == null) {
            j.t("mViewModel");
        }
        com.tplink.libtpnetwork.Utils.j.c(videoQualityViewModel.l(), this, new a());
        VideoQualityViewModel videoQualityViewModel2 = this.z;
        if (videoQualityViewModel2 == null) {
            j.t("mViewModel");
        }
        videoQualityViewModel2.j().observe(this, new b());
        VideoQualityViewModel videoQualityViewModel3 = this.z;
        if (videoQualityViewModel3 == null) {
            j.t("mViewModel");
        }
        videoQualityViewModel3.k().observe(this, new c());
    }

    private final void i1() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_video_quality);
        j.d(contentView, "DataBindingUtil.setConte…t.activity_video_quality)");
        ActivityVideoQualityBinding activityVideoQualityBinding = (ActivityVideoQualityBinding) contentView;
        this.y = activityVideoQualityBinding;
        if (activityVideoQualityBinding == null) {
            j.t("mBinding");
        }
        activityVideoQualityBinding.setLifecycleOwner(this);
        ActivityVideoQualityBinding activityVideoQualityBinding2 = this.y;
        if (activityVideoQualityBinding2 == null) {
            j.t("mBinding");
        }
        VideoQualityViewModel videoQualityViewModel = this.z;
        if (videoQualityViewModel == null) {
            j.t("mViewModel");
        }
        activityVideoQualityBinding2.i(videoQualityViewModel);
        ActivityVideoQualityBinding activityVideoQualityBinding3 = this.y;
        if (activityVideoQualityBinding3 == null) {
            j.t("mBinding");
        }
        activityVideoQualityBinding3.h(this);
        ActivityVideoQualityBinding activityVideoQualityBinding4 = this.y;
        if (activityVideoQualityBinding4 == null) {
            j.t("mBinding");
        }
        RecyclerView recyclerView = activityVideoQualityBinding4.f6766d;
        j.d(recyclerView, "mBinding.rv");
        VideoQualityAdapter videoQualityAdapter = this.p2;
        if (videoQualityAdapter == null) {
            j.t("mVideoQualityAdapter");
        }
        recyclerView.setAdapter(videoQualityAdapter);
        setTitle(R.string.video_quality_title);
        View findViewById = findViewById(R.id.toolbar);
        j.d(findViewById, "findViewById(R.id.toolbar)");
        ((Toolbar) findViewById).setNavigationOnClickListener(new d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g1();
        i1();
        h1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.common_save, menu);
        MenuItem findItem = menu.findItem(R.id.common_save);
        j.d(findItem, "menu.findItem(R.id.common_save)");
        this.p1 = findItem;
        if (findItem == null) {
            j.t("mSaveMenu");
        }
        findItem.setActionView(R.layout.menu_save);
        MenuItem menuItem = this.p1;
        if (menuItem == null) {
            j.t("mSaveMenu");
        }
        MenuSaveBinding menuSaveBinding = (MenuSaveBinding) DataBindingUtil.bind(menuItem.getActionView());
        if (menuSaveBinding != null) {
            menuSaveBinding.setLifecycleOwner(this);
            VideoQualityViewModel videoQualityViewModel = this.z;
            if (videoQualityViewModel == null) {
                j.t("mViewModel");
            }
            menuSaveBinding.h(videoQualityViewModel.g());
            menuSaveBinding.f7325c.setOnClickListener(new f());
        }
        return true;
    }
}
