package pub.devrel.easypermissions;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatDialogFragment;
import pub.devrel.easypermissions.EasyPermissions;

@RequiresApi(17)
/* loaded from: classes4.dex */
public class RationaleDialogFragmentCompat extends AppCompatDialogFragment {

    /* renamed from: c  reason: collision with root package name */
    private EasyPermissions.PermissionCallbacks f17538c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RationaleDialogFragmentCompat A0(@StringRes int i, @StringRes int i2, @NonNull String str, int i3, @NonNull String[] strArr) {
        RationaleDialogFragmentCompat rationaleDialogFragmentCompat = new RationaleDialogFragmentCompat();
        rationaleDialogFragmentCompat.setArguments(new d(i, i2, str, i3, strArr).b());
        return rationaleDialogFragmentCompat;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() != null && (getParentFragment() instanceof EasyPermissions.PermissionCallbacks)) {
            this.f17538c = (EasyPermissions.PermissionCallbacks) getParentFragment();
        } else if (context instanceof EasyPermissions.PermissionCallbacks) {
            this.f17538c = (EasyPermissions.PermissionCallbacks) context;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        setCancelable(false);
        d dVar = new d(getArguments());
        return dVar.a(getContext(), new c(this, dVar, this.f17538c));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f17538c = null;
    }
}
