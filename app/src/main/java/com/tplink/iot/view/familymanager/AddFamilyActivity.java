package com.tplink.iot.view.familymanager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.annotation.Nullable;
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
import com.tplink.iot.viewmodel.familymanager.FamilyViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;

/* loaded from: classes2.dex */
public class AddFamilyActivity extends BaseActivity implements TextWatcher {
    @BindView
    TPRefreshableButton mAddHomeBtn;
    @BindView
    DrawableEditText mAddHomeEditText;
    private CharSequence y;
    private FamilyViewModel z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<FamilyBean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable FamilyBean familyBean) {
            AddFamilyActivity.this.i1(familyBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Integer> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            AddFamilyActivity.this.mAddHomeBtn.h();
            s0.g();
            if (num.intValue() == 15008) {
                AddFamilyActivity.this.j1();
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
            AddFamilyActivity.this.W0(AddRoomActivity.class);
            AddFamilyActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements TPMaterialDialogV2.d {
        d() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            AddFamilyActivity.this.h1();
            AddFamilyActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements TPMaterialDialogV2.d {
        e() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            AddFamilyActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1() {
        Intent intent = new Intent(this, FamilyDetailActivity.class);
        intent.putExtra("args_key_need_add_home", false);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(FamilyBean familyBean) {
        this.mAddHomeBtn.h();
        s0.g();
        if (familyBean != null) {
            new TPMaterialDialogV2.Builder(this).t(getString(R.string.add_home_confirm_dialog_title)).j(getString(R.string.add_home_confirm_dialog_text)).l(R.string.common_later, R.color.common_iot_light_black, new d()).o(R.string.add_rooms, R.color.common_iot_main_blue, new c()).g(8, 8).setCancelable(false).c(false).create().show();
        } else {
            s0.p(this, "Failed add a home.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        new TPMaterialDialogV2.Builder(this).j(getString(R.string.family_num_out_of_range, new Object[]{8})).o(R.string.action_got_it, R.color.common_iot_main_blue, new e()).g(8, 8).setCancelable(false).c(false).create().show();
    }

    private void k1() {
        this.z.r().observe(this, new a());
        this.z.p().observe(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void addHome() {
        b.d.w.f.a.g(this);
        FamilyDataManager familyDataManager = FamilyDataManager.INSTANCE;
        if ((familyDataManager.getFamilyList() == null || this.y.length() <= 0) ? false : familyDataManager.isHomeNameAlreadyExist(this.y.toString())) {
            this.mAddHomeBtn.h();
            s0.p(this, getString(R.string.same_name_home_exist));
            return;
        }
        s0.l(this);
        this.z.t(null, this.y.toString(), true);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int length = this.y.toString().getBytes().length;
        if (length == 0) {
            this.mAddHomeBtn.setEnabled(false);
            return;
        }
        this.mAddHomeBtn.setEnabled(true);
        if (length > 64) {
            editable.delete(this.y.length() - 1, this.y.length());
            this.mAddHomeEditText.setText(editable);
            this.mAddHomeEditText.setSelection(editable.length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.add_home_activity);
            ButterKnife.a(this);
            b1(R.string.add_home);
            this.mAddHomeEditText.m();
            this.mAddHomeEditText.f(this);
            this.mAddHomeBtn.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.z = (FamilyViewModel) ViewModelProviders.of(this).get(FamilyViewModel.class);
        k1();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.y = charSequence;
    }
}
