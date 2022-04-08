package com.tplink.iot.view.ipcamera.play;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel;

/* loaded from: classes2.dex */
public class CloudTerraceControlFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private CloudTerraceControlFragment f8872b;

    /* renamed from: c  reason: collision with root package name */
    private View f8873c;

    /* renamed from: d  reason: collision with root package name */
    private View f8874d;

    /* renamed from: e  reason: collision with root package name */
    private View f8875e;

    /* renamed from: f  reason: collision with root package name */
    private View f8876f;
    private View g;

    /* loaded from: classes2.dex */
    class a extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudTerraceControlFragment f8877f;

        a(CloudTerraceControlFragment cloudTerraceControlFragment) {
            this.f8877f = cloudTerraceControlFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8877f.move((CloudTerraceControlPanel) butterknife.internal.c.a(view, "doClick", 0, "move", 0, CloudTerraceControlPanel.class));
        }
    }

    /* loaded from: classes2.dex */
    class b extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudTerraceControlFragment f8878f;

        b(CloudTerraceControlFragment cloudTerraceControlFragment) {
            this.f8878f = cloudTerraceControlFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8878f.markPosition();
        }
    }

    /* loaded from: classes2.dex */
    class c extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudTerraceControlFragment f8879f;

        c(CloudTerraceControlFragment cloudTerraceControlFragment) {
            this.f8879f = cloudTerraceControlFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8879f.openSensitivityPanel();
        }
    }

    /* loaded from: classes2.dex */
    class d extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudTerraceControlFragment f8880f;

        d(CloudTerraceControlFragment cloudTerraceControlFragment) {
            this.f8880f = cloudTerraceControlFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8880f.cruiseVertical();
        }
    }

    /* loaded from: classes2.dex */
    class e extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudTerraceControlFragment f8881f;

        e(CloudTerraceControlFragment cloudTerraceControlFragment) {
            this.f8881f = cloudTerraceControlFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8881f.cruiseHorizontal();
        }
    }

    @UiThread
    public CloudTerraceControlFragment_ViewBinding(CloudTerraceControlFragment cloudTerraceControlFragment, View view) {
        this.f8872b = cloudTerraceControlFragment;
        View c2 = butterknife.internal.c.c(view, R.id.panel, "field 'controlPanel' and method 'move'");
        cloudTerraceControlFragment.controlPanel = (CloudTerraceControlPanel) butterknife.internal.c.b(c2, R.id.panel, "field 'controlPanel'", CloudTerraceControlPanel.class);
        this.f8873c = c2;
        c2.setOnClickListener(new a(cloudTerraceControlFragment));
        View c3 = butterknife.internal.c.c(view, R.id.mark_position, "method 'markPosition'");
        this.f8874d = c3;
        c3.setOnClickListener(new b(cloudTerraceControlFragment));
        View c4 = butterknife.internal.c.c(view, R.id.sensitivity_setting, "method 'openSensitivityPanel'");
        this.f8875e = c4;
        c4.setOnClickListener(new c(cloudTerraceControlFragment));
        View c5 = butterknife.internal.c.c(view, R.id.cloud_terrace_cruise_vertical, "method 'cruiseVertical'");
        this.f8876f = c5;
        c5.setOnClickListener(new d(cloudTerraceControlFragment));
        View c6 = butterknife.internal.c.c(view, R.id.cloud_terrace_cruise_horizontal, "method 'cruiseHorizontal'");
        this.g = c6;
        c6.setOnClickListener(new e(cloudTerraceControlFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        CloudTerraceControlFragment cloudTerraceControlFragment = this.f8872b;
        if (cloudTerraceControlFragment != null) {
            this.f8872b = null;
            cloudTerraceControlFragment.controlPanel = null;
            this.f8873c.setOnClickListener(null);
            this.f8873c = null;
            this.f8874d.setOnClickListener(null);
            this.f8874d = null;
            this.f8875e.setOnClickListener(null);
            this.f8875e = null;
            this.f8876f.setOnClickListener(null);
            this.f8876f = null;
            this.g.setOnClickListener(null);
            this.g = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
