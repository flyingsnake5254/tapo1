package pub.devrel.easypermissions;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import pub.devrel.easypermissions.EasyPermissions;

/* compiled from: RationaleDialogFragment.java */
@RequiresApi(11)
/* loaded from: classes4.dex */
public class e extends DialogFragment {

    /* renamed from: c  reason: collision with root package name */
    private EasyPermissions.PermissionCallbacks f17546c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(@StringRes int i, @StringRes int i2, @NonNull String str, int i3, @NonNull String[] strArr) {
        e eVar = new e();
        eVar.setArguments(new d(i, i2, str, i3, strArr).b());
        return eVar;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @SuppressLint({"NewApi"})
    public void onAttach(Context context) {
        super.onAttach(context);
        if ((Build.VERSION.SDK_INT >= 17) && getParentFragment() != null && (getParentFragment() instanceof EasyPermissions.PermissionCallbacks)) {
            this.f17546c = (EasyPermissions.PermissionCallbacks) getParentFragment();
        } else if (context instanceof EasyPermissions.PermissionCallbacks) {
            this.f17546c = (EasyPermissions.PermissionCallbacks) context;
        }
    }

    @Override // android.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        setCancelable(false);
        d dVar = new d(getArguments());
        return dVar.a(getActivity(), new c(this, dVar, this.f17546c));
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f17546c = null;
    }
}
