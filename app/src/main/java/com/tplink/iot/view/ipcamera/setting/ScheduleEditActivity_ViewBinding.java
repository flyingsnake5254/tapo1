package com.tplink.iot.view.ipcamera.setting;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class ScheduleEditActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private ScheduleEditActivity f9147b;

    /* renamed from: c  reason: collision with root package name */
    private View f9148c;

    /* loaded from: classes2.dex */
    class a extends b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ScheduleEditActivity f9149f;

        a(ScheduleEditActivity scheduleEditActivity) {
            this.f9149f = scheduleEditActivity;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f9149f.onDeleteClick();
        }
    }

    @UiThread
    public ScheduleEditActivity_ViewBinding(ScheduleEditActivity scheduleEditActivity, View view) {
        this.f9147b = scheduleEditActivity;
        View c2 = c.c(view, R.id.start, "method 'onDeleteClick'");
        this.f9148c = c2;
        c2.setOnClickListener(new a(scheduleEditActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        if (this.f9147b != null) {
            this.f9147b = null;
            this.f9148c.setOnClickListener(null);
            this.f9148c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
