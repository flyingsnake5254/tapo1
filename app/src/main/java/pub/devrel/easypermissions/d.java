package pub.devrel.easypermissions;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;

/* compiled from: RationaleDialogConfig.java */
/* loaded from: classes4.dex */
class d {
    int a;

    /* renamed from: b  reason: collision with root package name */
    int f17542b;

    /* renamed from: c  reason: collision with root package name */
    int f17543c;

    /* renamed from: d  reason: collision with root package name */
    String f17544d;

    /* renamed from: e  reason: collision with root package name */
    String[] f17545e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(@StringRes int i, @StringRes int i2, @NonNull String str, int i3, @NonNull String[] strArr) {
        this.a = i;
        this.f17542b = i2;
        this.f17544d = str;
        this.f17543c = i3;
        this.f17545e = strArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        return new AlertDialog.Builder(context).setCancelable(false).setPositiveButton(this.a, onClickListener).setNegativeButton(this.f17542b, onClickListener).setMessage(this.f17544d).create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt("positiveButton", this.a);
        bundle.putInt("negativeButton", this.f17542b);
        bundle.putString("rationaleMsg", this.f17544d);
        bundle.putInt("requestCode", this.f17543c);
        bundle.putStringArray("permissions", this.f17545e);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Bundle bundle) {
        this.a = bundle.getInt("positiveButton");
        this.f17542b = bundle.getInt("negativeButton");
        this.f17544d = bundle.getString("rationaleMsg");
        this.f17543c = bundle.getInt("requestCode");
        this.f17545e = bundle.getStringArray("permissions");
    }
}
