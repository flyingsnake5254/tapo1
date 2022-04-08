package com.tplink.iot.view.ipcamera.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class DetectConfigSuccessDialog extends DialogFragment {

    /* renamed from: c  reason: collision with root package name */
    a f9087c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f9088d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f9089f;
    private String q;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ void B0(View view) {
        dismiss();
        a aVar = this.f9087c;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_detect_config_success, viewGroup, false);
        this.f9088d = (TextView) inflate.findViewById(R.id.mode_success_btn);
        TextView textView = (TextView) inflate.findViewById(R.id.mode_success_hint_tv);
        this.f9089f = textView;
        textView.setText(this.q);
        this.f9088d.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetectConfigSuccessDialog.this.B0(view);
            }
        });
        return inflate;
    }
}
