package com.tplink.iot.devices.lightstrip.view.effects;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ActivityLightingEffectDebugBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.lightstrip.adapter.HorizontalPredefinedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.view.effects.ColorPickerDialogFragment;
import com.tplink.iot.devices.lightstrip.widget.IntRangePickerDialog;
import com.tplink.iot.g.b.a.a;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* compiled from: LightingEffectDebugActivity.kt */
/* loaded from: classes2.dex */
public final class LightingEffectDebugActivity extends IoTMVVMBaseActivity<ActivityLightingEffectDebugBinding> implements View.OnClickListener {
    public static final b p0 = new b(null);
    private com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c H3;
    private HorizontalPredefinedEffectsAdapter I3;
    private boolean J3;
    private final kotlin.f K3;
    private final kotlin.f p1;
    private final kotlin.f p2;
    private final kotlin.f p3;

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class a implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.a.b().set(z);
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class a0<T> implements Observer<List<? extends PredefinedEffect>> {
        a0() {
        }

        /* renamed from: a */
        public final void onChanged(List<? extends PredefinedEffect> list) {
            if (list != null) {
                LightingEffectDebugActivity.this.S1(list);
            }
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final ObservableBoolean f7636b;

        public c(String name, ObservableBoolean visible) {
            kotlin.jvm.internal.j.e(name, "name");
            kotlin.jvm.internal.j.e(visible, "visible");
            this.a = name;
            this.f7636b = visible;
        }

        public final String a() {
            return this.a;
        }

        public final ObservableBoolean b() {
            return this.f7636b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return kotlin.jvm.internal.j.a(this.a, cVar.a) && kotlin.jvm.internal.j.a(this.f7636b, cVar.f7636b);
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            ObservableBoolean observableBoolean = this.f7636b;
            if (observableBoolean != null) {
                i = observableBoolean.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "EffectParamItem(name=" + this.a + ", visible=" + this.f7636b + ")";
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements com.tplink.iot.g.b.a.a<com.tplink.iot.g.b.b.d> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ HorizontalPredefinedEffectsAdapter f7637c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LightingEffectDebugActivity f7638d;

        d(HorizontalPredefinedEffectsAdapter horizontalPredefinedEffectsAdapter, LightingEffectDebugActivity lightingEffectDebugActivity) {
            this.f7637c = horizontalPredefinedEffectsAdapter;
            this.f7638d = lightingEffectDebugActivity;
        }

        @Override // com.tplink.iot.g.b.a.a
        public void b() {
            a.C0210a.a(this);
        }

        /* renamed from: c */
        public void a(com.tplink.iot.g.b.b.d data, int i) {
            kotlin.jvm.internal.j.e(data, "data");
            this.f7637c.Q(i);
            this.f7638d.L1(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e extends Lambda implements kotlin.jvm.b.a<kotlin.p> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LightingEffectDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> {
            a() {
                super(1);
            }

            public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c it) {
                kotlin.jvm.internal.j.e(it, "it");
                LightingEffectDebugActivity.this.F1().D(it);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ kotlin.p invoke(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar) {
                a(cVar);
                return kotlin.p.a;
            }
        }

        e() {
            super(0);
        }

        public final void a() {
            LightingEffectDebugActivity.N1(LightingEffectDebugActivity.this, null, new a(), 1, null);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f extends Lambda implements kotlin.jvm.b.p<Integer, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LightingEffectDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f7643d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i) {
                super(1);
                this.f7643d = i;
            }

            public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c it) {
                kotlin.jvm.internal.j.e(it, "it");
                LightingEffectDebugActivity.this.E1().M(this.f7643d, it);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ kotlin.p invoke(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar) {
                a(cVar);
                return kotlin.p.a;
            }
        }

        f() {
            super(2);
        }

        public final void a(int i, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c hsb) {
            kotlin.jvm.internal.j.e(hsb, "hsb");
            LightingEffectDebugActivity.this.M1(hsb, new a(i));
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar) {
            a(num.intValue(), cVar);
            return kotlin.p.a;
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ChipGroup chipGroup = LightingEffectDebugActivity.p1(LightingEffectDebugActivity.this).z;
            kotlin.jvm.internal.j.d(chipGroup, "mBinding.chipGroupParams");
            ChipGroup chipGroup2 = LightingEffectDebugActivity.p1(LightingEffectDebugActivity.this).z;
            kotlin.jvm.internal.j.d(chipGroup2, "mBinding.chipGroupParams");
            int i = 0;
            if (!(!(chipGroup2.getVisibility() == 0))) {
                i = 8;
            }
            chipGroup.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class h extends Lambda implements kotlin.jvm.b.a<kotlin.p> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LightingEffectDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> {
            a() {
                super(1);
            }

            public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c it) {
                kotlin.jvm.internal.j.e(it, "it");
                LightingEffectDebugActivity.this.F1().D(it);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ kotlin.p invoke(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar) {
                a(cVar);
                return kotlin.p.a;
            }
        }

        h() {
            super(0);
        }

        public final void a() {
            LightingEffectDebugActivity.this.H1(new a());
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class i extends Lambda implements kotlin.jvm.b.p<Integer, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LightingEffectDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f7649d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i) {
                super(1);
                this.f7649d = i;
            }

            public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c it) {
                kotlin.jvm.internal.j.e(it, "it");
                LightingEffectDebugActivity.this.F1().M(this.f7649d, it);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ kotlin.p invoke(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar) {
                a(cVar);
                return kotlin.p.a;
            }
        }

        i() {
            super(2);
        }

        public final void a(int i, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c hsb) {
            kotlin.jvm.internal.j.e(hsb, "hsb");
            LightingEffectDebugActivity.this.M1(hsb, new a(i));
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar) {
            a(num.intValue(), cVar);
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class j extends Lambda implements kotlin.jvm.b.a<kotlin.p> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LightingEffectDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> {
            a() {
                super(1);
            }

            public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c it) {
                kotlin.jvm.internal.j.e(it, "it");
                LightingEffectDebugActivity.this.D1().D(it);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ kotlin.p invoke(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar) {
                a(cVar);
                return kotlin.p.a;
            }
        }

        j() {
            super(0);
        }

        public final void a() {
            LightingEffectDebugActivity.N1(LightingEffectDebugActivity.this, null, new a(), 1, null);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class k extends Lambda implements kotlin.jvm.b.a<kotlin.p> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LightingEffectDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> {
            a() {
                super(1);
            }

            public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c it) {
                kotlin.jvm.internal.j.e(it, "it");
                LightingEffectDebugActivity.this.D1().D(it);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ kotlin.p invoke(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar) {
                a(cVar);
                return kotlin.p.a;
            }
        }

        k() {
            super(0);
        }

        public final void a() {
            LightingEffectDebugActivity.this.H1(new a());
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class l extends Lambda implements kotlin.jvm.b.p<Integer, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LightingEffectDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f7656d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i) {
                super(1);
                this.f7656d = i;
            }

            public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c it) {
                kotlin.jvm.internal.j.e(it, "it");
                LightingEffectDebugActivity.this.D1().M(this.f7656d, it);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ kotlin.p invoke(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar) {
                a(cVar);
                return kotlin.p.a;
            }
        }

        l() {
            super(2);
        }

        public final void a(int i, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c hsb) {
            kotlin.jvm.internal.j.e(hsb, "hsb");
            LightingEffectDebugActivity.this.M1(hsb, new a(i));
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar) {
            a(num.intValue(), cVar);
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class m extends Lambda implements kotlin.jvm.b.a<kotlin.p> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LightingEffectDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> {
            a() {
                super(1);
            }

            public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c it) {
                kotlin.jvm.internal.j.e(it, "it");
                LightingEffectDebugActivity.this.E1().D(it);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ kotlin.p invoke(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar) {
                a(cVar);
                return kotlin.p.a;
            }
        }

        m() {
            super(0);
        }

        public final void a() {
            LightingEffectDebugActivity.N1(LightingEffectDebugActivity.this, null, new a(), 1, null);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class n extends Lambda implements kotlin.jvm.b.a<kotlin.p> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LightingEffectDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements kotlin.jvm.b.l<com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> {
            a() {
                super(1);
            }

            public final void a(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c it) {
                kotlin.jvm.internal.j.e(it, "it");
                LightingEffectDebugActivity.this.E1().D(it);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ kotlin.p invoke(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar) {
                a(cVar);
                return kotlin.p.a;
            }
        }

        n() {
            super(0);
        }

        public final void a() {
            LightingEffectDebugActivity.this.H1(new a());
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class o implements DialogInterface.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText f7662d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.b.l f7663f;

        o(EditText editText, kotlin.jvm.b.l lVar) {
            this.f7662d = editText;
            this.f7663f = lVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.f7663f.invoke(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.d.a.a(Color.parseColor(this.f7662d.getText().toString())).c());
            } catch (Exception unused) {
                Toast.makeText(LightingEffectDebugActivity.this, "输入错误", 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class p implements DialogInterface.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText f7665d;

        p(EditText editText) {
            this.f7665d = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                Object b2 = com.tplink.libtpnetwork.Utils.i.b(this.f7665d.getText().toString(), LightingEffectData.class);
                kotlin.jvm.internal.j.d(b2, "GsonUtils.fromJson(editT…ngEffectData::class.java)");
                LightingEffectDebugActivity.this.K1((LightingEffectData) b2);
                HorizontalPredefinedEffectsAdapter horizontalPredefinedEffectsAdapter = LightingEffectDebugActivity.this.I3;
                if (horizontalPredefinedEffectsAdapter != null) {
                    horizontalPredefinedEffectsAdapter.C();
                }
            } catch (Exception unused) {
                Toast.makeText(LightingEffectDebugActivity.this, "参数错误", 0).show();
            }
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class q extends Lambda implements kotlin.jvm.b.a<a> {
        q() {
            super(0);
        }

        /* renamed from: a */
        public final a invoke() {
            return new a(LightingEffectDebugActivity.this);
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class r extends Lambda implements kotlin.jvm.b.a<a> {
        r() {
            super(0);
        }

        /* renamed from: a */
        public final a invoke() {
            return new a(LightingEffectDebugActivity.this);
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class s extends Lambda implements kotlin.jvm.b.a<a> {
        s() {
            super(0);
        }

        /* renamed from: a */
        public final a invoke() {
            return new a(LightingEffectDebugActivity.this);
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class t extends Lambda implements kotlin.jvm.b.a<LightingEffectDebugViewModel> {
        t() {
            super(0);
        }

        /* renamed from: a */
        public final LightingEffectDebugViewModel invoke() {
            LightingEffectDebugActivity lightingEffectDebugActivity = LightingEffectDebugActivity.this;
            ViewModel viewModel = new ViewModelProvider(lightingEffectDebugActivity, new IoTViewModelFactory(lightingEffectDebugActivity, lightingEffectDebugActivity.g1())).get(LightingEffectDebugViewModel.class);
            kotlin.jvm.internal.j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (LightingEffectDebugViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class u extends Lambda implements kotlin.jvm.b.p<Integer, Integer, kotlin.p> {
        u() {
            super(2);
        }

        public final void a(int i, int i2) {
            LightingEffectDebugActivity.this.G1().B().set(i);
            LightingEffectDebugActivity.this.G1().A().set(i2);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num, Integer num2) {
            a(num.intValue(), num2.intValue());
            return kotlin.p.a;
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class v extends Lambda implements kotlin.jvm.b.p<Integer, Integer, kotlin.p> {
        v() {
            super(2);
        }

        public final void a(int i, int i2) {
            LightingEffectDebugActivity.this.G1().M().set(i);
            LightingEffectDebugActivity.this.G1().L().set(i2);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num, Integer num2) {
            a(num.intValue(), num2.intValue());
            return kotlin.p.a;
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class w extends Lambda implements kotlin.jvm.b.p<Integer, Integer, kotlin.p> {
        w() {
            super(2);
        }

        public final void a(int i, int i2) {
            LightingEffectDebugActivity.this.G1().m().set(i);
            LightingEffectDebugActivity.this.G1().l().set(i2);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num, Integer num2) {
            a(num.intValue(), num2.intValue());
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class x implements ColorPickerDialogFragment.b {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ColorPickerDialogFragment f7673c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LightingEffectDebugActivity f7674d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c f7675f;
        final /* synthetic */ kotlin.jvm.b.l q;

        x(ColorPickerDialogFragment colorPickerDialogFragment, LightingEffectDebugActivity lightingEffectDebugActivity, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar, kotlin.jvm.b.l lVar) {
            this.f7673c = colorPickerDialogFragment;
            this.f7674d = lightingEffectDebugActivity;
            this.f7675f = cVar;
            this.q = lVar;
        }

        @Override // com.tplink.iot.devices.lightstrip.view.effects.ColorPickerDialogFragment.b
        public final void Q(int i, int i2, int i3) {
            com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(i2, i3, this.f7673c.b1());
            this.f7674d.H3 = cVar;
            this.q.invoke(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class y implements DialogInterface.OnClickListener {
        y() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            LightingEffectDebugActivity.this.C1();
        }
    }

    /* compiled from: LightingEffectDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class z<T> implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> {
        z() {
        }

        /* renamed from: a */
        public final void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> aVar) {
            Integer a = aVar != null ? aVar.a() : null;
            if (a != null && a.intValue() == 100) {
                com.tplink.iot.Utils.extension.e.m(LightingEffectDebugActivity.this, null, 1, null);
            } else if (a != null && a.intValue() == 200) {
                com.tplink.iot.Utils.extension.e.g(LightingEffectDebugActivity.this, null, 1, null);
            } else if (a != null && a.intValue() == 300) {
                com.tplink.iot.Utils.extension.e.e(LightingEffectDebugActivity.this, null, 1, null);
            }
        }
    }

    public LightingEffectDebugActivity() {
        kotlin.f b2;
        kotlin.f b3;
        kotlin.f b4;
        kotlin.f b5;
        b2 = kotlin.i.b(new s());
        this.p1 = b2;
        b3 = kotlin.i.b(new q());
        this.p2 = b3;
        b4 = kotlin.i.b(new r());
        this.p3 = b4;
        b5 = kotlin.i.b(new t());
        this.K3 = b5;
    }

    private final LightingEffectData B1() {
        G1().Z(F1().H());
        G1().X(D1().H());
        G1().Y(E1().H());
        return G1().i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1() {
        String j2 = com.tplink.libtpnetwork.Utils.i.j(B1());
        Object systemService = getSystemService("clipboard");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("光效参数", j2));
        Toast.makeText(this, "复制成功", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a D1() {
        return (a) this.p2.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a E1() {
        return (a) this.p3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a F1() {
        return (a) this.p1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LightingEffectDebugViewModel G1() {
        return (LightingEffectDebugViewModel) this.K3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1(kotlin.jvm.b.l<? super com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> lVar) {
        EditText editText = new EditText(this);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.setMargins(32, 32, 32, 32);
        kotlin.p pVar = kotlin.p.a;
        editText.setLayoutParams(marginLayoutParams);
        new MaterialAlertDialogBuilder(this, 2132017744).setTitle((CharSequence) "输入颜色。RGB格式：#FFFFFF").setView((View) editText).setNegativeButton((CharSequence) "取消", (DialogInterface.OnClickListener) null).setPositiveButton((CharSequence) "确定", (DialogInterface.OnClickListener) new o(editText, lVar)).show();
    }

    private final void I1() {
        EditText editText = new EditText(this);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.setMargins(32, 32, 32, 32);
        kotlin.p pVar = kotlin.p.a;
        editText.setLayoutParams(marginLayoutParams);
        editText.setPadding(36, editText.getPaddingTop(), 36, editText.getPaddingBottom());
        new MaterialAlertDialogBuilder(this, 2132017744).setTitle((CharSequence) "输入光效参数（JSON格式）。").setView((View) editText).setNegativeButton((CharSequence) "取消", (DialogInterface.OnClickListener) null).setPositiveButton((CharSequence) "确定", (DialogInterface.OnClickListener) new p(editText)).show();
    }

    private final void J1() {
        com.tplink.iot.g.b.b.d o2;
        if (!this.J3) {
            HorizontalPredefinedEffectsAdapter horizontalPredefinedEffectsAdapter = this.I3;
            if (horizontalPredefinedEffectsAdapter != null) {
                horizontalPredefinedEffectsAdapter.Q(0);
            }
            HorizontalPredefinedEffectsAdapter horizontalPredefinedEffectsAdapter2 = this.I3;
            if (horizontalPredefinedEffectsAdapter2 != null && (o2 = horizontalPredefinedEffectsAdapter2.o(0)) != null) {
                this.J3 = true;
                L1(o2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1(LightingEffectData lightingEffectData) {
        T1(lightingEffectData.sequence);
        Q1(lightingEffectData.backgrounds);
        R1(lightingEffectData.init_states);
        G1().a0(lightingEffectData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1(com.tplink.iot.g.b.b.d dVar) {
        String h2 = dVar.h();
        int hashCode = h2.hashCode();
        if (hashCode == -1807305034 ? !h2.equals("Sunset") : hashCode != -191907083 || !h2.equals("Sunrise")) {
            PredefinedEffect e2 = dVar.e();
            if (e2 != null) {
                K1(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.C(e2));
                return;
            }
            return;
        }
        LightingEffectData g2 = dVar.g();
        if (g2 != null) {
            K1(g2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1(com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar, kotlin.jvm.b.l<? super com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c, kotlin.p> lVar) {
        ColorPickerDialogFragment colorPickerDialogFragment = new ColorPickerDialogFragment();
        com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar2 = cVar != null ? cVar : this.H3;
        if (cVar2 == null) {
            cVar2 = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(0, 0, 100);
        }
        colorPickerDialogFragment.h1(cVar2.g(), cVar2.b(), cVar2.c());
        colorPickerDialogFragment.e1(cVar2.a());
        colorPickerDialogFragment.i1(new x(colorPickerDialogFragment, this, cVar, lVar));
        colorPickerDialogFragment.f1(true);
        colorPickerDialogFragment.show(getSupportFragmentManager(), (String) null);
    }

    static /* synthetic */ void N1(LightingEffectDebugActivity lightingEffectDebugActivity, com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar, kotlin.jvm.b.l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cVar = null;
        }
        lightingEffectDebugActivity.M1(cVar, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.tplink.iot.devices.lightstrip.view.effects.c] */
    private final void O1(int i2, int i3, Pair<Integer, Integer> pair, kotlin.jvm.b.p<? super Integer, ? super Integer, kotlin.p> pVar) {
        IntRangePickerDialog a2 = IntRangePickerDialog.p1.a(i2, i3, pair);
        if (pVar != null) {
            pVar = new c(pVar);
        }
        a2.i1((IntRangePickerDialog.b) pVar);
        a2.show(getSupportFragmentManager(), (String) null);
    }

    private final void P1() {
        new MaterialAlertDialogBuilder(this, 2132017744).setTitle((CharSequence) "光效参数").setMessage((CharSequence) com.tplink.libtpnetwork.Utils.i.j(B1())).setNegativeButton((CharSequence) "取消", (DialogInterface.OnClickListener) null).setPositiveButton((CharSequence) "复制", (DialogInterface.OnClickListener) new y()).show();
    }

    private final void Q1(Integer[][] numArr) {
        Collection collection;
        if (numArr != null) {
            collection = new ArrayList();
            for (Integer[] numArr2 : numArr) {
                com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar = numArr2.length == 3 ? new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(numArr2[0].intValue(), numArr2[1].intValue(), numArr2[2].intValue()) : null;
                if (cVar != null) {
                    collection.add(cVar);
                }
            }
        } else {
            collection = kotlin.collections.n.d();
        }
        D1().y(collection);
    }

    private final void R1(Integer[][] numArr) {
        Collection collection;
        if (numArr != null) {
            collection = new ArrayList();
            for (Integer[] numArr2 : numArr) {
                com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar = numArr2.length == 3 ? new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(numArr2[0].intValue(), numArr2[1].intValue(), numArr2[2].intValue()) : null;
                if (cVar != null) {
                    collection.add(cVar);
                }
            }
        } else {
            collection = kotlin.collections.n.d();
        }
        E1().y(collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(List<? extends PredefinedEffect> list) {
        String alias;
        com.tplink.iot.g.b.b.d b2;
        ArrayList arrayList = new ArrayList();
        com.tplink.iot.g.b.b.d dVar = new com.tplink.iot.g.b.b.d("Sunrise", R.mipmap.ls_effect_valentines, null, 4, null);
        dVar.m(b.f7696d);
        com.tplink.iot.g.b.b.d dVar2 = new com.tplink.iot.g.b.b.d("Sunset", R.mipmap.ls_effect_valentines, null, 4, null);
        dVar2.m(b.f7697e);
        arrayList.add(dVar);
        arrayList.add(dVar2);
        for (PredefinedEffect predefinedEffect : list) {
            LightingEffectMeta meta = predefinedEffect.getMeta();
            if (!(meta == null || (alias = meta.getAlias()) == null || (b2 = PredefinedEffectsAdapter.h.b(alias)) == null)) {
                b2.l(predefinedEffect);
                arrayList.add(b2);
            }
        }
        HorizontalPredefinedEffectsAdapter horizontalPredefinedEffectsAdapter = this.I3;
        if (horizontalPredefinedEffectsAdapter != null) {
            horizontalPredefinedEffectsAdapter.T(arrayList);
        }
        J1();
    }

    private final void T1(Integer[][] numArr) {
        Collection collection;
        if (numArr != null) {
            collection = new ArrayList();
            for (Integer[] numArr2 : numArr) {
                com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c cVar = numArr2.length == 3 ? new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(numArr2[0].intValue(), numArr2[1].intValue(), numArr2[2].intValue()) : null;
                if (cVar != null) {
                    collection.add(cVar);
                }
            }
        } else {
            collection = kotlin.collections.n.d();
        }
        F1().y(collection);
    }

    public static final /* synthetic */ ActivityLightingEffectDebugBinding p1(LightingEffectDebugActivity lightingEffectDebugActivity) {
        return lightingEffectDebugActivity.f1();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_lighting_effect_debug;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        List d2;
        List<c> g2;
        c1("调试光效参数");
        F1().L(new e(), new h(), new i());
        f1().p3.setAdapter(F1());
        D1().L(new j(), new k(), new l());
        RecyclerView recyclerView = f1().p0;
        kotlin.jvm.internal.j.d(recyclerView, "mBinding.rvBackgroundsColors");
        recyclerView.setAdapter(D1());
        E1().L(new m(), new n(), new f());
        RecyclerView recyclerView2 = f1().p1;
        kotlin.jvm.internal.j.d(recyclerView2, "mBinding.rvInitStatesColors");
        recyclerView2.setAdapter(E1());
        d2 = kotlin.collections.n.d();
        HorizontalPredefinedEffectsAdapter horizontalPredefinedEffectsAdapter = new HorizontalPredefinedEffectsAdapter(this, d2, 0, 4, null);
        horizontalPredefinedEffectsAdapter.S(new d(horizontalPredefinedEffectsAdapter, this));
        kotlin.p pVar = kotlin.p.a;
        this.I3 = horizontalPredefinedEffectsAdapter;
        RecyclerView recyclerView3 = f1().p2;
        recyclerView3.setAdapter(this.I3);
        com.tplink.iot.Utils.extension.i.g(recyclerView3);
        g2 = kotlin.collections.n.g(new c("Effect Type", G1().v()), new c("Repeat Times", G1().K()), new c("Direction", G1().p()), new c("Transition", G1().V()), new c("Duration", G1().s()), new c("Sequence colos", G1().O()), new c("Expansion strategy", G1().x()), new c("Spread number", G1().Q()), new c("Transition range", G1().U()), new c("Fade off", G1().z()), new c("Backgrounds", G1().k()), new c("Random seed", G1().I()), new c("Hue range", G1().C()), new c("Saturation range", G1().N()), new c("Brightness range", G1().n()), new c("Init states", G1().D()));
        for (c cVar : g2) {
            View inflate = getLayoutInflater().inflate(R.layout.chip_filter, (ViewGroup) f1().z, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
            final Chip chip = (Chip) inflate;
            chip.setText(cVar.a());
            chip.setChecked(true);
            chip.setOnCheckedChangeListener(new a(cVar));
            cVar.b().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.tplink.iot.devices.lightstrip.view.effects.LightingEffectDebugActivity$initView$13$chip$1$2
                @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                public void onPropertyChanged(Observable observable, int i2) {
                    if (!(observable instanceof ObservableBoolean)) {
                        observable = null;
                    }
                    ObservableBoolean observableBoolean = (ObservableBoolean) observable;
                    if (observableBoolean != null) {
                        Chip.this.setChecked(observableBoolean.get());
                    }
                }
            });
            f1().z.addView(chip);
        }
        f1().R3.setOnClickListener(new g());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
        super.l1();
        f1().h(this);
        f1().i(G1());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        G1().j().observe(this, new z());
        G1().G().observe(this, new a0());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.btn_remove_seq_color) {
            F1().K();
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_remove_bg_color) {
            D1().K();
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_remove_init_states_color) {
            E1().K();
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_hue_range) {
            O1(0, 360, kotlin.n.a(Integer.valueOf(G1().B().get()), Integer.valueOf(G1().A().get())), new u());
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_saturation_range) {
            O1(0, 100, kotlin.n.a(Integer.valueOf(G1().M().get()), Integer.valueOf(G1().L().get())), new v());
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_brightness_range) {
            O1(0, 100, kotlin.n.a(Integer.valueOf(G1().m().get()), Integer.valueOf(G1().l().get())), new w());
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lighting_effect_debug, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        kotlin.jvm.internal.j.e(item, "item");
        switch (item.getItemId()) {
            case R.id.btn_apply /* 2131362036 */:
                G1().g(B1()).y();
                return true;
            case R.id.btn_copy /* 2131362043 */:
                C1();
                return true;
            case R.id.btn_input /* 2131362070 */:
                I1();
                return true;
            case R.id.btn_see /* 2131362105 */:
                P1();
                return true;
            default:
                super.onOptionsItemSelected(item);
                return true;
        }
    }
}
