package com.tplink.iot.view.ipcamera.play;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import b.d.d.m.f;
import com.tplink.iot.R;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.databinding.DialogSelectDeviceBinding;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.Utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class SelectDeviceDialogFragment extends DialogFragment {

    /* renamed from: c  reason: collision with root package name */
    public static String f8926c = "SelectDeviceDialogFragment";

    /* renamed from: d  reason: collision with root package name */
    SelectDeviceViewModel f8927d;

    /* renamed from: f  reason: collision with root package name */
    RecyclerView f8928f;
    DataBindingListAdapter q;
    b x;
    int y;

    /* loaded from: classes2.dex */
    class a extends RecyclerView.ItemDecoration {
        int a;

        a() {
            this.a = b.d.w.f.a.a(SelectDeviceDialogFragment.this.getContext(), 0.5f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                int i = this.a;
                rect.set(0, i, 0, i);
                return;
            }
            rect.set(0, 0, 0, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void a(ArrayList<String> arrayList, ArrayList<String> arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ void B0(View view, int i) {
        this.f8927d.f(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0 */
    public /* synthetic */ void G0(View view) {
        b bVar = this.x;
        if (bVar != null) {
            bVar.a(this.f8927d.k(), this.f8927d.m());
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(View view) {
        Iterator<SelectDeviceViewModel.a> it = this.f8927d.l().iterator();
        while (it.hasNext()) {
            SelectDeviceViewModel.a next = it.next();
            if (!next.g.get()) {
                this.f8927d.g(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0(f fVar) {
        int x = this.f8927d.x((String) fVar.a());
        if (x >= 0 && x < this.f8927d.l().size()) {
            this.q.notifyItemChanged(x);
        }
    }

    private void L0() {
        for (Map.Entry<String, MutableLiveData<f<String>>> entry : this.f8927d.f10561d.entrySet()) {
            LiveMediaAPI.previewCapture(entry.getKey(), entry.getValue());
        }
    }

    private void N0() {
        for (Map.Entry<String, MutableLiveData<f<String>>> entry : this.f8927d.f10561d.entrySet()) {
            entry.getValue().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.play.a2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SelectDeviceDialogFragment.this.K0((f) obj);
                }
            });
        }
    }

    private int P0(Context context, float f2) {
        return Math.round(TypedValue.applyDimension(2, f2, context.getResources().getDisplayMetrics()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(b bVar) {
        this.x = bVar;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f8927d = (SelectDeviceViewModel) ViewModelProviders.of(this).get(SelectDeviceViewModel.class);
        if (getArguments() != null) {
            this.f8927d.o(getArguments().getStringArrayList("added_mac_list"), getArguments().getString("persisted_mac"));
        }
        Paint paint = new Paint();
        paint.setTextSize(P0(getContext(), 14.0f));
        String string = getResources().getString(R.string.select_all);
        String string2 = getResources().getString(R.string.select_camera);
        SelectDeviceViewModel selectDeviceViewModel = this.f8927d;
        String j = selectDeviceViewModel.j(((Integer) j.e(selectDeviceViewModel.f10562e, 0)).intValue());
        float measureText = paint.measureText(string);
        float measureText2 = paint.measureText(string2);
        float measureText3 = paint.measureText(j);
        if (measureText <= measureText3) {
            measureText = measureText3;
        }
        this.y = ((int) ((measureText * 2.0f) + measureText2 + b.d.w.f.a.a(getContext(), 90.0f))) + 1;
        N0();
        L0();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        DialogSelectDeviceBinding dialogSelectDeviceBinding = (DialogSelectDeviceBinding) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_select_device, viewGroup, true);
        dialogSelectDeviceBinding.setLifecycleOwner(this);
        dialogSelectDeviceBinding.h(this.f8927d);
        this.f8928f = dialogSelectDeviceBinding.f6808d;
        DataBindingListAdapter dataBindingListAdapter = new DataBindingListAdapter(R.layout.item_camera_select_device_full_screen, new int[]{31, 9}, new int[]{31}, this.f8927d.l(), new d() { // from class: com.tplink.iot.view.ipcamera.play.z1
            @Override // com.tplink.iot.adapter.databinding.d
            public final void a(View view, int i) {
                SelectDeviceDialogFragment.this.B0(view, i);
            }
        });
        this.q = dataBindingListAdapter;
        dataBindingListAdapter.B(this);
        this.f8928f.setAdapter(this.q);
        this.f8928f.addItemDecoration(new a());
        dialogSelectDeviceBinding.f6807c.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectDeviceDialogFragment.this.G0(view);
            }
        });
        dialogSelectDeviceBinding.f6809f.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.play.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectDeviceDialogFragment.this.I0(view);
            }
        });
        return dialogSelectDeviceBinding.getRoot();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = ((int) (displayMetrics.widthPixels * 0.5d)) + 1;
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = GravityCompat.END;
            int i2 = this.y;
            if (i <= i2) {
                i = i2;
            }
            attributes.width = i;
            attributes.height = -1;
            window.setAttributes(attributes);
        }
    }
}
