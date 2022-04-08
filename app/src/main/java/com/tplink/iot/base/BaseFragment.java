package com.tplink.iot.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.base.b;
import com.tplink.iot.i.a;

/* loaded from: classes2.dex */
public class BaseFragment extends Fragment implements b.a, com.tplink.iot.i.a {

    /* renamed from: c  reason: collision with root package name */
    protected b f6075c;

    /* renamed from: d  reason: collision with root package name */
    private com.tplink.iot.i.b f6076d = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6077f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BaseFragment.this.getFragmentManager() != null && BaseFragment.this.f6077f) {
                BaseFragment.this.getFragmentManager().popBackStack();
            }
        }
    }

    public void B0() {
        this.f6075c.post(new a());
    }

    public void C0(Class<?> cls) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivity(new Intent(activity, cls));
        }
    }

    public boolean G0(Intent intent) {
        return false;
    }

    @Override // com.tplink.iot.i.a
    public boolean d() {
        return a.C0212a.a(this);
    }

    @Override // com.tplink.iot.base.b.a
    public void handleMessage(Message message) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6075c = new b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f6075c.f6083b = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.tplink.iot.i.b bVar = this.f6076d;
        if (bVar != null) {
            bVar.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            B0();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f6077f = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f6077f = false;
    }
}
