package com.tplink.iot.view.familymanager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.familymanager.RoomViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;

/* loaded from: classes2.dex */
public class EditRoomNameActivity extends BaseActivity implements TextWatcher {
    @BindView
    DrawableEditText mRoomNameEditText;
    private CharSequence p0;
    private RoomViewModel p1;
    private MenuItem y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<RoomBean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable RoomBean roomBean) {
            EditRoomNameActivity.this.j1(roomBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TPMaterialDialogV2.d {
        b() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            EditRoomNameActivity.this.finish();
        }
    }

    private boolean f1(String str) {
        return !TextUtils.isEmpty(str) && !str.equals(this.z);
    }

    private void g1() {
        b.d.w.f.a.g(this);
        if (f1(this.mRoomNameEditText.getText().toString())) {
            i1();
        } else {
            finish();
        }
    }

    private void h1() {
        FamilyDataManager familyDataManager = FamilyDataManager.INSTANCE;
        if (familyDataManager.isRoomNameAlreadyExist(this.p0.toString())) {
            s0.p(this, getString(R.string.same_name_home_exist));
        } else {
            this.p1.C(familyDataManager.getCurFamily().getFamilyId(), familyDataManager.getCurRoombean().getRoomId(), this.p0.toString(), false);
        }
    }

    private void i1() {
        new TPMaterialDialogV2.Builder(this).i(R.string.discard_changes_tip, R.color.common_tplink_light_gray).o(R.string.common_discard, R.color.common_iot_main_blue, new b()).l(R.string.common_cancel, R.color.common_iot_light_black, null).g(8, 8).setCancelable(false).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(RoomBean roomBean) {
        s0.g();
        if (roomBean != null) {
            finish();
        } else {
            s0.n(this, R.string.operation_failed_try_again);
        }
    }

    private void k1() {
        this.p1.v().observe(this, new a());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z = true;
        if (this.p0.toString().getBytes().length > 64) {
            editable.delete(this.p0.length() - 1, this.p0.length());
            this.mRoomNameEditText.setText(editable);
            this.mRoomNameEditText.setSelection(editable.length());
        }
        if (this.y != null) {
            if (TextUtils.isEmpty(editable.toString()) || (!TextUtils.isEmpty(this.z) && this.z.equals(editable.toString()))) {
                z = false;
            }
            this.y.setEnabled(z);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        g1();
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.edit_room_name_activity);
            ButterKnife.a(this);
            b1(R.string.edit_room_name);
            FamilyDataManager familyDataManager = FamilyDataManager.INSTANCE;
            if (familyDataManager.getCurRoombean() == null || familyDataManager.getCurRoomList() == null) {
                finish();
            }
            this.mRoomNameEditText.m();
            this.mRoomNameEditText.f(this);
            String roomName = familyDataManager.getCurRoombean().getRoomName();
            this.z = roomName;
            if (!TextUtils.isEmpty(roomName)) {
                l.m(this.mRoomNameEditText, this.z);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_save, menu);
        this.y = menu.findItem(R.id.common_save);
        this.y.setEnabled(this.mRoomNameEditText != null && ((TextUtils.isEmpty(this.z) && !TextUtils.isEmpty(this.mRoomNameEditText.getText())) || !TextUtils.equals(this.z, this.mRoomNameEditText.getText().toString())));
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.common_save) {
            s0.l(this);
            h1();
        } else if (itemId == 16908332) {
            g1();
            return false;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.p1 = (RoomViewModel) ViewModelProviders.of(this).get(RoomViewModel.class);
        k1();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.p0 = charSequence;
    }
}
