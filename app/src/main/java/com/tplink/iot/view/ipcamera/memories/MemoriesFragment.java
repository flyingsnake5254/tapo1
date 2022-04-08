package com.tplink.iot.view.ipcamera.memories;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.core.view.PointerIconCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.e;
import com.tplink.iot.adapter.home.HomeMainSpaceItemDecoration;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentPhotosBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.memories.MemoriesAdapter;
import com.tplink.iot.view.ipcamera.memories.MemoryDeleteDialogFragment;
import com.tplink.iot.view.ipcamera.memories.filter.MemoriesFilterActivity;
import com.tplink.iot.view.ipcamera.memories.filter.MemoriesFilterBean;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;
import com.tplink.libtpmediaother.memory.MemoryBean;
import com.tplink.libtpmediaother.memory.r;
import com.tplink.libtpnetwork.Utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/* loaded from: classes2.dex */
public class MemoriesFragment extends BaseFragment implements MemoriesAdapter.b, MemoriesAdapter.d, MemoriesAdapter.c, g, EasyPermissions.PermissionCallbacks {
    private Animation p0;
    private Animation p1;
    private c p3;
    private FragmentPhotosBinding q;
    private MemoriesAdapter x;
    private MemoriesViewModel y;
    private MemoriesFilterBean z = new MemoriesFilterBean();
    private int p2 = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<List<MemoryBean>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<MemoryBean> list) {
            MemoriesFragment.this.y.o.set(false);
            if (list != null) {
                MemoriesFragment.this.x.J(list);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements MemoryDeleteDialogFragment.a {
        final /* synthetic */ MemoryDeleteDialogFragment a;

        b(MemoryDeleteDialogFragment memoryDeleteDialogFragment) {
            this.a = memoryDeleteDialogFragment;
        }

        @Override // com.tplink.iot.view.ipcamera.memories.MemoryDeleteDialogFragment.a
        public void a() {
            this.a.dismiss();
        }

        @Override // com.tplink.iot.view.ipcamera.memories.MemoryDeleteDialogFragment.a
        public void b() {
            this.a.dismiss();
            MemoriesFragment.this.x.o();
            MemoriesFragment.this.Z0();
            MemoriesFragment.this.y.f10388d.set(false);
            MemoriesFragment.this.y.g.set(false);
            MemoriesFragment.this.y.f10389e.set(false);
            MemoriesFragment.this.y.f10390f.set(false);
            MemoriesFragment.this.K0();
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void T();

        void k(int i);
    }

    private boolean L0() {
        return EasyPermissions.a(requireContext(), com.tplink.iot.Utils.a1.b.a());
    }

    private void P0() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.p0 = translateAnimation;
        translateAnimation.setDuration(300L);
        this.p0.setFillAfter(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.p1 = translateAnimation2;
        translateAnimation2.setFillAfter(false);
        this.p1.setDuration(300L);
    }

    private void Q0() {
        MemoriesAdapter memoriesAdapter = new MemoriesAdapter(getActivity());
        this.x = memoriesAdapter;
        memoriesAdapter.I(this);
        this.x.L(this);
        this.x.K(this);
        P0();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(1);
        this.q.q.setLayoutManager(gridLayoutManager);
        this.q.q.addItemDecoration(new HomeMainSpaceItemDecoration(getActivity(), 4));
        this.q.q.setAdapter(this.x);
    }

    private void R0() {
        this.y.o.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public /* synthetic */ void V0(String str) {
        TSnackbar.A(TSnackbar.s(this), str, -1).N();
    }

    private void X0() {
        e.x();
    }

    private void Y0() {
        int y = this.x.y();
        c cVar = this.p3;
        if (cVar != null) {
            cVar.k(y);
        }
        if (y == 0) {
            this.y.f10388d.set(false);
            this.y.f10389e.set(false);
            this.y.f10390f.set(false);
            this.y.g.set(false);
            this.q.z.f6783c.setAlpha(0.6f);
            return;
        }
        this.y.f10388d.set(true);
        this.y.f10389e.set(true);
        this.y.f10390f.set(true);
        this.y.g.set(true);
        this.q.z.f6783c.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        if (this.z == null) {
            this.z = new MemoriesFilterBean();
        }
        if (this.z.isSelectAll()) {
            this.y.w();
            return;
        }
        r.d dVar = new r.d();
        if (this.z.getOnlyDeviceName().size() > 0) {
            dVar.c(this.z.getOnlyDeviceName());
        }
        if (this.z.isOnlyLike()) {
            dVar.f(Boolean.TRUE);
        }
        if (this.z.isOnlyUnLick()) {
            dVar.h(Boolean.TRUE);
        }
        if (this.z.isHasVideo()) {
            dVar.i(Boolean.TRUE);
        }
        if (this.z.isHasPicture()) {
            dVar.g(Boolean.TRUE);
        }
        if (this.z.isHasCloudVideo()) {
            dVar.e(Boolean.TRUE);
        }
        if (this.z.getDesignatedDeviceidMD5() != null) {
            dVar.d(this.z.getDesignatedDeviceidMD5());
        }
        this.y.x(dVar);
    }

    private void a1(int i, String str) {
        EasyPermissions.h(this, str, i, com.tplink.iot.Utils.a1.b.a());
    }

    private void b1() {
        if (!this.y.f10387c.get()) {
            ObservableBoolean observableBoolean = this.y.f10387c;
            observableBoolean.set(!observableBoolean.get());
        }
        this.y.h.set(this.x.w());
        Y0();
    }

    private void e1() {
        this.y.i().observe(getViewLifecycleOwner(), new a());
        j.c(this.y.q, this, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.view.ipcamera.memories.d
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                MemoriesFragment.this.V0((String) obj);
            }
        });
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void E0(int i, List<String> list) {
        if (4 == i) {
            this.x.q();
            K0();
        }
    }

    public void K0() {
        ObservableBoolean observableBoolean;
        MemoriesAdapter memoriesAdapter = this.x;
        if (memoriesAdapter != null) {
            memoriesAdapter.H(false);
        }
        MemoriesViewModel memoriesViewModel = this.y;
        if (!(memoriesViewModel == null || (observableBoolean = memoriesViewModel.f10387c) == null)) {
            observableBoolean.set(false);
        }
        c cVar = this.p3;
        if (cVar != null) {
            cVar.T();
        }
    }

    public void N0() {
        MemoriesAdapter memoriesAdapter = this.x;
        if (memoriesAdapter != null && memoriesAdapter.getItemCount() > 0) {
            if (!this.x.x()) {
                this.x.H(true);
            } else if (this.x.v()) {
                this.x.n();
            } else {
                this.x.G();
            }
            b1();
        }
    }

    public void O0() {
        d1();
        K0();
    }

    @Override // com.tplink.iot.view.ipcamera.memories.MemoriesAdapter.c
    public void R(List<MemoryBean> list) {
        if (!list.isEmpty()) {
            this.y.g(list);
        }
    }

    public boolean S0() {
        MemoriesAdapter memoriesAdapter = this.x;
        return memoriesAdapter != null && memoriesAdapter.x();
    }

    public boolean T0() {
        MemoriesAdapter memoriesAdapter = this.x;
        return memoriesAdapter != null && memoriesAdapter.x() && this.x.v();
    }

    public void W0() {
        if (getContext() != null && this.y != null) {
            Z0();
        }
    }

    @Override // com.tplink.iot.view.ipcamera.memories.MemoriesAdapter.b
    public void Z(View view, int i, MemoryBean memoryBean) {
        if (!this.y.f10387c.get()) {
            ObservableBoolean observableBoolean = this.y.f10387c;
            observableBoolean.set(!observableBoolean.get());
        }
        this.y.f10388d.set(true);
        this.y.f10389e.set(true);
        this.y.f10390f.set(true);
        this.y.g.set(true);
        this.y.h.set(this.x.w());
        Y0();
    }

    public void c1(c cVar) {
        this.p3 = cVar;
    }

    @Override // com.tplink.iot.base.BaseFragment, com.tplink.iot.i.a
    public boolean d() {
        if (!this.y.f10387c.get()) {
            return super.d();
        }
        K0();
        return false;
    }

    public void d1() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent(activity, MemoriesFilterActivity.class);
            intent.putExtra("memories_filter_bean", this.z);
            startActivityForResult(intent, PointerIconCompat.TYPE_ALL_SCROLL);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1011 && i2 == 1012) {
            if (this.p2 != -1) {
                if (intent.getBooleanExtra("MemoryDelete", false)) {
                    this.x.p(this.p2);
                } else {
                    MemoryBean memoryBean = (MemoryBean) intent.getSerializableExtra("MemoryBean");
                    if (memoryBean != null) {
                        this.x.E(memoryBean, this.p2);
                    }
                }
                this.p2 = -1;
            }
        } else if (i == 1013 && i2 == 1014) {
            MemoriesFilterBean memoriesFilterBean = (MemoriesFilterBean) intent.getSerializableExtra("memories_filter_bean");
            if (memoriesFilterBean != null) {
                this.z = memoriesFilterBean.clone();
            }
        } else if (5 == i && L0()) {
            this.x.q();
            K0();
        }
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_delete_item /* 2131364400 */:
                MemoryDeleteDialogFragment A0 = MemoryDeleteDialogFragment.A0();
                A0.B0(new b(A0));
                A0.show(getChildFragmentManager(), "MemoryDeleteDialogFragment");
                return;
            case R.id.tv_download_item /* 2131364424 */:
                if (L0()) {
                    this.x.q();
                    K0();
                    return;
                }
                a1(4, getString(R.string.permission_storage_requested));
                return;
            case R.id.tv_favorite_item /* 2131364458 */:
                ObservableBoolean observableBoolean = this.y.h;
                observableBoolean.set(!observableBoolean.get());
                this.x.D(this.y.h.get());
                K0();
                return;
            case R.id.tv_share_item /* 2131364626 */:
                X0();
                this.x.M();
                K0();
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.q = (FragmentPhotosBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_photos, viewGroup, false);
        MemoriesViewModel memoriesViewModel = (MemoriesViewModel) ViewModelProviders.of(this).get(MemoriesViewModel.class);
        this.y = memoriesViewModel;
        memoriesViewModel.f10387c.set(false);
        this.q.i(this);
        this.q.h(this.y);
        Q0();
        R0();
        e1();
        return this.q.getRoot();
    }

    @Override // com.tplink.iot.view.ipcamera.memories.MemoriesAdapter.d
    public void onDataChanged() {
        if (this.x.getItemCount() <= 0) {
            this.y.i.set(true);
        } else {
            this.y.i.set(false);
        }
    }

    @Override // androidx.fragment.app.Fragment, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        EasyPermissions.d(i, strArr, iArr, this);
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Z0();
    }

    @Override // com.tplink.iot.view.ipcamera.memories.MemoriesAdapter.b
    public void s(View view, int i, MemoryBean memoryBean) {
        Intent intent;
        this.p2 = i;
        if (memoryBean.getVideoPath() == null) {
            intent = new Intent(getActivity(), MemoriesImageActivity.class);
            intent.putExtra("MemoryBean", memoryBean);
        } else {
            intent = new Intent(getActivity(), MemoriesVideoPlayActivity.class);
            intent.putExtra("MemoryBean", memoryBean);
        }
        startActivityForResult(intent, PointerIconCompat.TYPE_COPY);
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(@Nullable Bundle bundle) {
        super.setArguments(bundle);
        if (bundle != null) {
            this.z.setDesignatedDeviceidMD5(bundle.getString("device_id_md5"));
        }
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void t(int i, List<String> list) {
        new AppSettingsDialog.b(this).d(R.string.permission_setting_ask_again).c(R.string.common_ok).b(R.string.common_cancel).e(4 == i ? 5 : -1).a().d();
    }

    @Override // com.tplink.iot.view.ipcamera.memories.MemoriesAdapter.c
    public void v(List<MemoryBean> list) {
        String str;
        Uri uri;
        Uri uri2;
        if (!list.isEmpty()) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (MemoryBean memoryBean : list) {
                boolean z = false;
                if (memoryBean.getVideoPath() == null) {
                    str = memoryBean.getThumbnailPath();
                    z = true;
                } else {
                    str = memoryBean.getVideoPath();
                }
                File file = new File(str);
                if (file.exists()) {
                    if (z) {
                        Uri fromFile = Uri.fromFile(file);
                        if (Build.VERSION.SDK_INT < 20 || !"file".equals(fromFile.getScheme())) {
                            uri = requireContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
                        } else {
                            try {
                                uri = FileProvider.getUriForFile(requireContext(), b.d.q.b.p.b.n().concat(".provider"), file);
                            } catch (IllegalArgumentException e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        arrayList.add(uri);
                    } else {
                        Uri fromFile2 = Uri.fromFile(file);
                        if (Build.VERSION.SDK_INT < 20 || !"file".equals(fromFile2.getScheme())) {
                            uri2 = requireContext().getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new ContentValues());
                        } else {
                            try {
                                uri2 = FileProvider.getUriForFile(requireContext(), b.d.q.b.p.b.n().concat(".provider"), file);
                            } catch (IllegalArgumentException e3) {
                                e3.printStackTrace();
                                return;
                            }
                        }
                        arrayList.add(uri2);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
                intent.setType("*/*");
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                startActivity(intent);
            }
        }
    }

    @Override // com.tplink.iot.view.ipcamera.memories.MemoriesAdapter.b
    public void w0(int i, MemoryBean memoryBean) {
        this.y.f10388d.set(this.x.u());
        this.y.f10389e.set(this.x.u());
        this.y.f10390f.set(this.x.u());
        this.y.g.set(this.x.u());
        this.y.h.set(this.x.w());
        Y0();
    }
}
