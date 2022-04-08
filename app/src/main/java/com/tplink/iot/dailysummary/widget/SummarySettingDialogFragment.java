package com.tplink.iot.dailysummary.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.tplink.iot.R;
import java.util.HashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: SummarySettingDialogFragment.kt */
/* loaded from: classes2.dex */
public final class SummarySettingDialogFragment extends DialogFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final a f6469c = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private b f6470d;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f6471f;

    /* compiled from: SummarySettingDialogFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: SummarySettingDialogFragment.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b();
    }

    public void A0() {
        HashMap hashMap = this.f6471f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void B0(b summarySettingDialogListener) {
        j.e(summarySettingDialogListener, "summarySettingDialogListener");
        this.f6470d = summarySettingDialogListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        j.e(v, "v");
        switch (v.getId()) {
            case R.id.btn_dialog_summary_save_setting_no /* 2131362052 */:
                b bVar = this.f6470d;
                if (bVar != null) {
                    bVar.b();
                    return;
                }
                return;
            case R.id.btn_dialog_summary_save_setting_yes /* 2131362053 */:
                b bVar2 = this.f6470d;
                if (bVar2 != null) {
                    bVar2.a();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_summary_setting, viewGroup, false);
        j.d(inflate, "inflater.inflate(R.layou…etting, container, false)");
        inflate.findViewById(R.id.btn_dialog_summary_save_setting_yes).setOnClickListener(this);
        inflate.findViewById(R.id.btn_dialog_summary_save_setting_no).setOnClickListener(this);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        A0();
    }
}
