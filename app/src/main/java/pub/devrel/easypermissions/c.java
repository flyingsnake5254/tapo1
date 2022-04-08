package pub.devrel.easypermissions;

import android.content.DialogInterface;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Arrays;
import pub.devrel.easypermissions.EasyPermissions;

/* compiled from: RationaleDialogClickListener.java */
/* loaded from: classes4.dex */
class c implements DialogInterface.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private Object f17539c;

    /* renamed from: d  reason: collision with root package name */
    private d f17540d;

    /* renamed from: f  reason: collision with root package name */
    private EasyPermissions.PermissionCallbacks f17541f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(RationaleDialogFragmentCompat rationaleDialogFragmentCompat, d dVar, EasyPermissions.PermissionCallbacks permissionCallbacks) {
        Object obj;
        if (rationaleDialogFragmentCompat.getParentFragment() != null) {
            obj = rationaleDialogFragmentCompat.getParentFragment();
        } else {
            obj = rationaleDialogFragmentCompat.getActivity();
        }
        this.f17539c = obj;
        this.f17540d = dVar;
        this.f17541f = permissionCallbacks;
    }

    private void a() {
        EasyPermissions.PermissionCallbacks permissionCallbacks = this.f17541f;
        if (permissionCallbacks != null) {
            d dVar = this.f17540d;
            permissionCallbacks.t(dVar.f17543c, Arrays.asList(dVar.f17545e));
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            Object obj = this.f17539c;
            if (obj instanceof Fragment) {
                d dVar = this.f17540d;
                ((Fragment) obj).requestPermissions(dVar.f17545e, dVar.f17543c);
            } else if (obj instanceof android.app.Fragment) {
                if (Build.VERSION.SDK_INT >= 23) {
                    d dVar2 = this.f17540d;
                    ((android.app.Fragment) obj).requestPermissions(dVar2.f17545e, dVar2.f17543c);
                    return;
                }
                throw new IllegalArgumentException("Target SDK needs to be greater than 23 if caller is android.app.Fragment");
            } else if (obj instanceof FragmentActivity) {
                d dVar3 = this.f17540d;
                ActivityCompat.requestPermissions((FragmentActivity) obj, dVar3.f17545e, dVar3.f17543c);
            }
        } else {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(api = 11)
    public c(e eVar, d dVar, EasyPermissions.PermissionCallbacks permissionCallbacks) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 17) {
            if (eVar.getParentFragment() != null) {
                obj = eVar.getParentFragment();
            } else {
                obj = eVar.getActivity();
            }
            this.f17539c = obj;
        } else {
            this.f17539c = eVar.getActivity();
        }
        this.f17540d = dVar;
        this.f17541f = permissionCallbacks;
    }
}
