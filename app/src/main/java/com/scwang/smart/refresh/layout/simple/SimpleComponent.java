package com.scwang.smart.refresh.layout.simple;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.a.a;
import com.scwang.smart.refresh.layout.a.c;
import com.scwang.smart.refresh.layout.a.d;
import com.scwang.smart.refresh.layout.a.e;
import com.scwang.smart.refresh.layout.a.f;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.constant.b;

/* loaded from: classes2.dex */
public abstract class SimpleComponent extends RelativeLayout implements a {

    /* renamed from: c  reason: collision with root package name */
    protected View f5230c;

    /* renamed from: d  reason: collision with root package name */
    protected b f5231d;

    /* renamed from: f  reason: collision with root package name */
    protected a f5232f;

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleComponent(@NonNull View view) {
        this(view, view instanceof a ? (a) view : null);
    }

    @SuppressLint({"RestrictedApi"})
    public boolean b(boolean z) {
        a aVar = this.f5232f;
        return (aVar instanceof c) && ((c) aVar).b(z);
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return (obj instanceof a) && getView() == ((a) obj).getView();
        }
        return true;
    }

    @Override // com.scwang.smart.refresh.layout.a.a
    public int f(@NonNull f fVar, boolean z) {
        a aVar = this.f5232f;
        if (aVar == null || aVar == this) {
            return 0;
        }
        return aVar.f(fVar, z);
    }

    @Override // com.scwang.smart.refresh.layout.a.a
    public void g(@NonNull e eVar, int i, int i2) {
        a aVar = this.f5232f;
        if (aVar == null || aVar == this) {
            View view = this.f5230c;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                    eVar.e(this, ((SmartRefreshLayout.LayoutParams) layoutParams).a);
                    return;
                }
                return;
            }
            return;
        }
        aVar.g(eVar, i, i2);
    }

    @Override // com.scwang.smart.refresh.layout.a.a
    @NonNull
    public b getSpinnerStyle() {
        int i;
        b[] bVarArr;
        b bVar = this.f5231d;
        if (bVar != null) {
            return bVar;
        }
        a aVar = this.f5232f;
        if (!(aVar == null || aVar == this)) {
            return aVar.getSpinnerStyle();
        }
        View view = this.f5230c;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                b bVar2 = ((SmartRefreshLayout.LayoutParams) layoutParams).f5187b;
                this.f5231d = bVar2;
                if (bVar2 != null) {
                    return bVar2;
                }
            }
            if (layoutParams != null && ((i = layoutParams.height) == 0 || i == -1)) {
                for (b bVar3 : b.f5224f) {
                    if (bVar3.i) {
                        this.f5231d = bVar3;
                        return bVar3;
                    }
                }
            }
        }
        b bVar4 = b.a;
        this.f5231d = bVar4;
        return bVar4;
    }

    @Override // com.scwang.smart.refresh.layout.a.a
    @NonNull
    public View getView() {
        View view = this.f5230c;
        return view == null ? this : view;
    }

    @Override // com.scwang.smart.refresh.layout.c.h
    public void h(@NonNull f fVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        a aVar = this.f5232f;
        if (aVar != null && aVar != this) {
            if ((this instanceof c) && (aVar instanceof d)) {
                if (refreshState.isFooter) {
                    refreshState = refreshState.toHeader();
                }
                if (refreshState2.isFooter) {
                    refreshState2 = refreshState2.toHeader();
                }
            } else if ((this instanceof d) && (aVar instanceof c)) {
                if (refreshState.isHeader) {
                    refreshState = refreshState.toFooter();
                }
                if (refreshState2.isHeader) {
                    refreshState2 = refreshState2.toFooter();
                }
            }
            a aVar2 = this.f5232f;
            if (aVar2 != null) {
                aVar2.h(fVar, refreshState, refreshState2);
            }
        }
    }

    @Override // com.scwang.smart.refresh.layout.a.a
    public void i(@NonNull f fVar, int i, int i2) {
        a aVar = this.f5232f;
        if (aVar != null && aVar != this) {
            aVar.i(fVar, i, i2);
        }
    }

    @Override // com.scwang.smart.refresh.layout.a.a
    public void j(@NonNull f fVar, int i, int i2) {
        a aVar = this.f5232f;
        if (aVar != null && aVar != this) {
            aVar.j(fVar, i, i2);
        }
    }

    @Override // com.scwang.smart.refresh.layout.a.a
    public void k(float f2, int i, int i2) {
        a aVar = this.f5232f;
        if (aVar != null && aVar != this) {
            aVar.k(f2, i, i2);
        }
    }

    @Override // com.scwang.smart.refresh.layout.a.a
    public boolean n() {
        a aVar = this.f5232f;
        return (aVar == null || aVar == this || !aVar.n()) ? false : true;
    }

    @Override // com.scwang.smart.refresh.layout.a.a
    public void s(boolean z, float f2, int i, int i2, int i3) {
        a aVar = this.f5232f;
        if (aVar != null && aVar != this) {
            aVar.s(z, f2, i, i2, i3);
        }
    }

    @Override // com.scwang.smart.refresh.layout.a.a
    public void setPrimaryColors(@ColorInt int... iArr) {
        a aVar = this.f5232f;
        if (aVar != null && aVar != this) {
            aVar.setPrimaryColors(iArr);
        }
    }

    protected SimpleComponent(@NonNull View view, @Nullable a aVar) {
        super(view.getContext(), null, 0);
        this.f5230c = view;
        this.f5232f = aVar;
        if ((this instanceof c) && (aVar instanceof d) && aVar.getSpinnerStyle() == b.f5223e) {
            aVar.getView().setScaleY(-1.0f);
        } else if (this instanceof d) {
            a aVar2 = this.f5232f;
            if ((aVar2 instanceof c) && aVar2.getSpinnerStyle() == b.f5223e) {
                aVar.getView().setScaleY(-1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleComponent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
