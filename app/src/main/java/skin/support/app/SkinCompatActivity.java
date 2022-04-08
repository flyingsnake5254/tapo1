package skin.support.app;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import f.a.f.a.d;
import f.a.f.a.e;
import skin.support.widget.c;

@Deprecated
/* loaded from: classes4.dex */
public class SkinCompatActivity extends AppCompatActivity {

    /* renamed from: c  reason: collision with root package name */
    private SkinCompatDelegate f17682c;

    @NonNull
    public SkinCompatDelegate P0() {
        if (this.f17682c == null) {
            this.f17682c = SkinCompatDelegate.a(this);
        }
        return this.f17682c;
    }

    protected boolean Q0() {
        return true;
    }

    protected void R0() {
        if (Q0() && Build.VERSION.SDK_INT >= 21) {
            int d2 = e.d(this);
            int a = e.a(this);
            if (c.a(d2) != 0) {
                getWindow().setStatusBarColor(d.a(this, d2));
            } else if (c.a(a) != 0) {
                getWindow().setStatusBarColor(d.a(this, a));
            }
        }
    }

    protected void S0() {
        Drawable d2;
        int i = e.i(this);
        if (c.a(i) != 0 && (d2 = d.d(this, i)) != null) {
            getWindow().setBackgroundDrawable(d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), P0());
        super.onCreate(bundle);
        R0();
        S0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f.a.e.a();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        f.a.e.a();
        throw null;
    }
}
