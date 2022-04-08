package com.tplink.iot.view.familymanager;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.R;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public class AddRoomActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private AddRoomActivity f8439b;

    /* renamed from: c  reason: collision with root package name */
    private View f8440c;

    /* loaded from: classes2.dex */
    class a extends b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ AddRoomActivity f8441f;

        a(AddRoomActivity addRoomActivity) {
            this.f8441f = addRoomActivity;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8441f.addRoom();
        }
    }

    @UiThread
    public AddRoomActivity_ViewBinding(AddRoomActivity addRoomActivity, View view) {
        this.f8439b = addRoomActivity;
        View c2 = c.c(view, R.id.btn_add_room, "field 'mAddRoomBtn' and method 'addRoom'");
        addRoomActivity.mAddRoomBtn = (TPRefreshableButton) c.b(c2, R.id.btn_add_room, "field 'mAddRoomBtn'", TPRefreshableButton.class);
        this.f8440c = c2;
        c2.setOnClickListener(new a(addRoomActivity));
        addRoomActivity.mAddRoomEditText = (DrawableEditText) c.d(view, R.id.add_room_name_et, "field 'mAddRoomEditText'", DrawableEditText.class);
        addRoomActivity.mLineBreakLayout = (LineBreakLayout) c.d(view, R.id.lineBreakLayout, "field 'mLineBreakLayout'", LineBreakLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        AddRoomActivity addRoomActivity = this.f8439b;
        if (addRoomActivity != null) {
            this.f8439b = null;
            addRoomActivity.mAddRoomBtn = null;
            addRoomActivity.mAddRoomEditText = null;
            addRoomActivity.mLineBreakLayout = null;
            this.f8440c.setOnClickListener(null);
            this.f8440c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
