package com.tplink.iot.view.familymanager;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;
import com.tplink.iot.R;
import com.tplink.iot.widget.DrawableEditText;

/* loaded from: classes2.dex */
public class EditFamilyNameActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private EditFamilyNameActivity f8442b;

    @UiThread
    public EditFamilyNameActivity_ViewBinding(EditFamilyNameActivity editFamilyNameActivity, View view) {
        this.f8442b = editFamilyNameActivity;
        editFamilyNameActivity.mHomeNameEditText = (DrawableEditText) c.d(view, R.id.edit_home_name_et, "field 'mHomeNameEditText'", DrawableEditText.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        EditFamilyNameActivity editFamilyNameActivity = this.f8442b;
        if (editFamilyNameActivity != null) {
            this.f8442b = null;
            editFamilyNameActivity.mHomeNameEditText = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
