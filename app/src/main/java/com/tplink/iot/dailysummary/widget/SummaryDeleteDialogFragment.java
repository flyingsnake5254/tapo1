package com.tplink.iot.dailysummary.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.tplink.iot.R;
import java.util.HashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: SummaryDeleteDialogFragment.kt */
/* loaded from: classes2.dex */
public final class SummaryDeleteDialogFragment extends DialogFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final a f6466c = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private b f6467d;

    /* renamed from: f  reason: collision with root package name */
    private final int f6468f;
    private HashMap q;

    /* compiled from: SummaryDeleteDialogFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: SummaryDeleteDialogFragment.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b();
    }

    public SummaryDeleteDialogFragment(int i) {
        this.f6468f = i;
    }

    public void A0() {
        HashMap hashMap = this.q;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void B0(b summaryDeleteDialogListener) {
        j.e(summaryDeleteDialogListener, "summaryDeleteDialogListener");
        this.f6467d = summaryDeleteDialogListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        j.e(v, "v");
        switch (v.getId()) {
            case R.id.btn_dialog_summary_delete_no /* 2131362050 */:
                b bVar = this.f6467d;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            case R.id.btn_dialog_summary_delete_yes /* 2131362051 */:
                b bVar2 = this.f6467d;
                if (bVar2 != null) {
                    bVar2.b();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        CharSequence charSequence;
        j.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_summary_delete, viewGroup, false);
        j.d(inflate, "inflater.inflate(R.layou…delete, container, false)");
        View findViewById = inflate.findViewById(R.id.tv_dialog_summary_delete);
        j.d(findViewById, "view.findViewById<TextVi…tv_dialog_summary_delete)");
        TextView textView = (TextView) findViewById;
        if (this.f6468f > 1) {
            charSequence = getText(R.string.daily_summary_delete_dialog_more);
        } else {
            charSequence = getText(R.string.daily_summary_delete_dialog_one);
        }
        textView.setText(charSequence);
        inflate.findViewById(R.id.btn_dialog_summary_delete_yes).setOnClickListener(this);
        inflate.findViewById(R.id.btn_dialog_summary_delete_no).setOnClickListener(this);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        A0();
    }
}
