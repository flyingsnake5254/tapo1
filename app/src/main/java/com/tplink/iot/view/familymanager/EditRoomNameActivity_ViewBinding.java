package com.tplink.iot.view.familymanager;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;
import com.tplink.iot.R;
import com.tplink.iot.widget.DrawableEditText;

/* loaded from: classes2.dex */
public class EditRoomNameActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private EditRoomNameActivity f8443b;

    @UiThread
    public EditRoomNameActivity_ViewBinding(EditRoomNameActivity editRoomNameActivity, View view) {
        this.f8443b = editRoomNameActivity;
        editRoomNameActivity.mRoomNameEditText = (DrawableEditText) c.d(view, R.id.edit_room_name_et, "field 'mRoomNameEditText'", DrawableEditText.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        EditRoomNameActivity editRoomNameActivity = this.f8443b;
        if (editRoomNameActivity != null) {
            this.f8443b = null;
            editRoomNameActivity.mRoomNameEditText = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
