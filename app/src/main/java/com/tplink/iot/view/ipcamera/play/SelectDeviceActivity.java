package com.tplink.iot.view.ipcamera.play;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import b.d.d.m.f;
import com.tplink.iot.R;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySelectDeviceBinding;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import java.util.Map;

/* loaded from: classes2.dex */
public class SelectDeviceActivity extends BaseActivity {
    DataBindingListAdapter p0;
    SelectDeviceViewModel y;
    RecyclerView z;

    /* loaded from: classes2.dex */
    class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.getChildAdapterPosition(view) + 1 != recyclerView.getLayoutManager().getItemCount()) {
                rect.set(0, 0, 0, b.d.w.f.a.a(SelectDeviceActivity.this, 2.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1 */
    public /* synthetic */ void f1(View view, int i) {
        this.y.f(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1(View view) {
        setResult(-1, this.y.h());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1(f fVar) {
        int x = this.y.x((String) fVar.a());
        if (x >= 0 && x < this.y.l().size()) {
            this.p0.notifyItemChanged(x);
        }
    }

    private void k1() {
        for (Map.Entry<String, MutableLiveData<f<String>>> entry : this.y.f10561d.entrySet()) {
            LiveMediaAPI.previewCapture(entry.getKey(), entry.getValue());
        }
    }

    private void l1() {
        for (Map.Entry<String, MutableLiveData<f<String>>> entry : this.y.f10561d.entrySet()) {
            entry.getValue().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.u1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SelectDeviceActivity.this.j1((f) obj);
                }
            });
        }
    }

    private void m1() {
        setTitle(getApplication().getString(R.string.add_camera));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        SelectDeviceViewModel selectDeviceViewModel = (SelectDeviceViewModel) ViewModelProviders.of(this).get(SelectDeviceViewModel.class);
        this.y = selectDeviceViewModel;
        selectDeviceViewModel.i(getIntent());
        ActivitySelectDeviceBinding activitySelectDeviceBinding = (ActivitySelectDeviceBinding) DataBindingUtil.setContentView(this, R.layout.activity_select_device);
        activitySelectDeviceBinding.setLifecycleOwner(this);
        activitySelectDeviceBinding.h(this.y);
        m1();
        this.z = activitySelectDeviceBinding.f6670d;
        DataBindingListAdapter dataBindingListAdapter = new DataBindingListAdapter(R.layout.item_camera_select_device, new int[]{31, 9}, new int[]{31}, this.y.l(), new d() { // from class: com.tplink.iot.view.ipcamera.play.w1
            @Override // com.tplink.iot.adapter.databinding.d
            public final void a(View view, int i) {
                SelectDeviceActivity.this.f1(view, i);
            }
        });
        this.p0 = dataBindingListAdapter;
        dataBindingListAdapter.B(this);
        this.z.setAdapter(this.p0);
        this.z.addItemDecoration(new a());
        activitySelectDeviceBinding.f6669c.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectDeviceActivity.this.h1(view);
            }
        });
        l1();
        k1();
    }
}
