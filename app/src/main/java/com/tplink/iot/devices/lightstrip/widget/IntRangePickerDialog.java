package com.tplink.iot.devices.lightstrip.widget;

import android.os.Bundle;
import android.view.View;
import com.tplink.iot.R;
import com.tplink.iot.databinding.DialogIntRangePickerBinding;
import com.tplink.iot.widget.NumberPickerView;
import com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.l;
import kotlin.collections.o;
import kotlin.collections.v;
import kotlin.collections.z;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: IntRangePickerDialog.kt */
/* loaded from: classes2.dex */
public final class IntRangePickerDialog extends BaseBottomSheetDialog<DialogIntRangePickerBinding> {
    public static final a p1 = new a(null);
    private b H3;
    private HashMap I3;
    private int p2;
    private int p3 = 100;

    /* compiled from: IntRangePickerDialog.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final IntRangePickerDialog a(int i, int i2, Pair<Integer, Integer> pair) {
            IntRangePickerDialog intRangePickerDialog = new IntRangePickerDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("ArgMinInt", i);
            bundle.putInt("ArgMaxInt", i2);
            if (pair != null) {
                bundle.putInt("ArgInitStartInt", pair.getFirst().intValue());
                bundle.putInt("ArgInitEndInt", pair.getSecond().intValue());
            }
            p pVar = p.a;
            intRangePickerDialog.setArguments(bundle);
            return intRangePickerDialog;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: IntRangePickerDialog.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void a(int i, int i2);
    }

    /* compiled from: IntRangePickerDialog.kt */
    /* loaded from: classes2.dex */
    static final class c implements NumberPickerView.d {
        c() {
        }

        @Override // com.tplink.iot.widget.NumberPickerView.d
        public final void a(NumberPickerView numberPickerView, int i, int i2) {
            int b1 = IntRangePickerDialog.this.b1(i2);
            int e1 = IntRangePickerDialog.this.e1();
            if (b1 > e1) {
                IntRangePickerDialog.this.j1(e1);
            }
        }
    }

    /* compiled from: IntRangePickerDialog.kt */
    /* loaded from: classes2.dex */
    static final class d implements NumberPickerView.d {
        d() {
        }

        @Override // com.tplink.iot.widget.NumberPickerView.d
        public final void a(NumberPickerView numberPickerView, int i, int i2) {
            int g1 = IntRangePickerDialog.this.g1();
            if (IntRangePickerDialog.this.b1(i2) < g1) {
                IntRangePickerDialog.this.h1(g1);
            }
        }
    }

    /* compiled from: IntRangePickerDialog.kt */
    /* loaded from: classes2.dex */
    static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            IntRangePickerDialog.this.dismissAllowingStateLoss();
        }
    }

    /* compiled from: IntRangePickerDialog.kt */
    /* loaded from: classes2.dex */
    static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int e1 = IntRangePickerDialog.this.e1();
            int min = Math.min(IntRangePickerDialog.this.g1(), e1);
            b bVar = IntRangePickerDialog.this.H3;
            if (bVar != null) {
                bVar.a(min, e1);
            }
            IntRangePickerDialog.this.dismissAllowingStateLoss();
        }
    }

    private final int a1(int i) {
        List S;
        S = v.S(f1());
        int indexOf = S.indexOf(Integer.valueOf(i));
        if (indexOf != -1) {
            return indexOf;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b1(int i) {
        List S;
        S = v.S(f1());
        Integer num = (Integer) l.z(S, i);
        return num != null ? num.intValue() : this.p2;
    }

    private final void c1() {
        this.p2 = Math.max(0, this.p2);
        int max = Math.max(0, this.p3);
        this.p3 = max;
        if (this.p2 > max) {
            this.p2 = max;
        }
    }

    private final String[] d1() {
        int l;
        kotlin.v.d f1 = f1();
        l = o.l(f1, 10);
        ArrayList arrayList = new ArrayList(l);
        Iterator<Integer> it = f1.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((z) it).nextInt()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int e1() {
        NumberPickerView numberPickerView = O0().f6779f;
        j.d(numberPickerView, "mBinding.numberPickerEnd");
        return b1(numberPickerView.getValue());
    }

    private final kotlin.v.d f1() {
        c1();
        return new kotlin.v.d(this.p2, this.p3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int g1() {
        NumberPickerView numberPickerView = O0().q;
        j.d(numberPickerView, "mBinding.numberPickerStart");
        return b1(numberPickerView.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1(int i) {
        NumberPickerView numberPickerView = O0().f6779f;
        j.d(numberPickerView, "mBinding.numberPickerEnd");
        numberPickerView.setValue(a1(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(int i) {
        NumberPickerView numberPickerView = O0().q;
        j.d(numberPickerView, "mBinding.numberPickerStart");
        numberPickerView.setValue(a1(i));
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public void A0() {
        HashMap hashMap = this.I3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public int L0() {
        return R.layout.dialog_int_range_picker;
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog
    public void Q0() {
        O0().q.S(d1());
        O0().f6779f.S(d1());
        O0().q.setOnValueChangedListener(new c());
        O0().f6779f.setOnValueChangedListener(new d());
        O0().f6777c.setOnClickListener(new e());
        O0().f6778d.setOnClickListener(new f());
        Bundle arguments = getArguments();
        if (arguments != null) {
            j1(arguments.getInt("ArgInitStartInt", this.p2));
            h1(arguments.getInt("ArgInitEndInt", this.p3));
        }
    }

    public final void i1(b listener) {
        j.e(listener, "listener");
        this.H3 = listener;
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.p2 = arguments.getInt("ArgMinInt", 0);
            this.p3 = arguments.getInt("ArgMaxInt", 100);
        }
        c1();
    }

    @Override // com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        A0();
    }
}
