package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.platform.VisibilityAnimatorProvider;
import java.util.ArrayList;

@RequiresApi(21)
/* loaded from: classes2.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final P primaryAnimatorProvider;
    @Nullable
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    /* JADX INFO: Access modifiers changed from: protected */
    public MaterialVisibility(P p, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.primaryAnimatorProvider = p;
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    private Animator createAnimator(ViewGroup viewGroup, View view, boolean z) {
        Animator animator;
        Animator animator2;
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z) {
            animator = this.primaryAnimatorProvider.createAppear(viewGroup, view);
        } else {
            animator = this.primaryAnimatorProvider.createDisappear(viewGroup, view);
        }
        if (animator != null) {
            arrayList.add(animator);
        }
        VisibilityAnimatorProvider visibilityAnimatorProvider = this.secondaryAnimatorProvider;
        if (visibilityAnimatorProvider != null) {
            if (z) {
                animator2 = visibilityAnimatorProvider.createAppear(viewGroup, view);
            } else {
                animator2 = visibilityAnimatorProvider.createDisappear(viewGroup, view);
            }
            if (animator2 != null) {
                arrayList.add(animator2);
            }
        }
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    @NonNull
    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    @Nullable
    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, false);
    }

    public void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }
}
