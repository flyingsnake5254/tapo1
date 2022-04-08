package com.tplink.iot.view.familymanager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.familymanager.LineBreakLayout;
import com.tplink.iot.viewmodel.familymanager.RoomViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AddRoomActivity extends BaseActivity implements TextWatcher, LineBreakLayout.b {
    @BindView
    TPRefreshableButton mAddRoomBtn;
    @BindView
    DrawableEditText mAddRoomEditText;
    @BindView
    LineBreakLayout mLineBreakLayout;
    private CharSequence p0;
    private RoomViewModel p1;
    private List<String> y = new ArrayList();
    private List<String> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<RoomBean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(RoomBean roomBean) {
            AddRoomActivity.this.h1(roomBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Integer> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(Integer num) {
            AddRoomActivity.this.mAddRoomBtn.h();
            s0.g();
            if (num.intValue() == 15009) {
                AddRoomActivity.this.i1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TPMaterialDialogV2.d {
        c() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            AddRoomActivity.this.finish();
        }
    }

    private void g1() {
        this.y.add(getString(R.string.location_living_room));
        this.y.add(getString(R.string.location_bedroom));
        this.y.add(getString(R.string.location_hallway));
        this.y.add(getString(R.string.location_kitchen));
        this.y.add(getString(R.string.location_master_bedroom));
        this.y.add(getString(R.string.location_office));
        this.y.add(getString(R.string.location_study));
        this.mLineBreakLayout.setSingleSelectionLables(this.y);
        this.mLineBreakLayout.setListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(RoomBean roomBean) {
        this.mAddRoomBtn.h();
        s0.g();
        if (roomBean != null) {
            W0(AddDeviceActivity.class);
            finish();
            return;
        }
        s0.n(this, R.string.operation_failed_try_again);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        new TPMaterialDialogV2.Builder(this).j(getString(R.string.room_num_out_of_range, new Object[]{32})).o(R.string.action_got_it, R.color.common_iot_main_blue, new c()).g(8, 8).setCancelable(false).c(false).create().show();
    }

    private void j1() {
        this.p1.v().observe(this, new a());
        this.p1.t().observe(this, new b());
    }

    @Override // com.tplink.iot.view.familymanager.LineBreakLayout.b
    public void M() {
        List<String> selectedLables = this.mLineBreakLayout.getSelectedLables();
        this.z = selectedLables;
        if (selectedLables != null && selectedLables.size() > 0) {
            this.mAddRoomEditText.setText(this.z.get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void addRoom() {
        b.d.w.f.a.g(this);
        FamilyDataManager familyDataManager = FamilyDataManager.INSTANCE;
        if (familyDataManager.isRoomNameAlreadyExist(this.p0.toString())) {
            this.mAddRoomBtn.h();
            s0.p(this, getString(R.string.same_name_home_exist));
        } else if (familyDataManager.getCurFamily() != null) {
            s0.l(this);
            this.p1.C(familyDataManager.getCurFamily().getFamilyId(), null, this.p0.toString(), true);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int length = this.p0.toString().getBytes().length;
        if (length == 0) {
            this.mAddRoomBtn.setEnabled(false);
        } else {
            this.mAddRoomBtn.setEnabled(true);
            if (length > 64) {
                editable.delete(this.p0.length() - 1, this.p0.length());
                this.mAddRoomEditText.setText(editable);
                this.mAddRoomEditText.setSelection(editable.length());
            }
        }
        if (!this.y.contains(this.p0.toString())) {
            this.mLineBreakLayout.d();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.add_room_activity);
            ButterKnife.a(this);
            b1(R.string.add_rooms);
            this.mAddRoomEditText.m();
            this.mAddRoomEditText.f(this);
            this.mAddRoomBtn.setEnabled(false);
            g1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.p1 = (RoomViewModel) ViewModelProviders.of(this).get(RoomViewModel.class);
        j1();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.p0 = charSequence;
    }
}
