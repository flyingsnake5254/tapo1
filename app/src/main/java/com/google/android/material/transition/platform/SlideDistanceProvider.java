package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
/* loaded from: classes2.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;
    @Px
    private int slideDistance = -1;
    private int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i) {
        this.slideEdge = i;
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i, @Px int i2) {
        if (i == 3) {
            return createTranslationXAnimator(view2, i2, 0.0f);
        }
        if (i == 5) {
            return createTranslationXAnimator(view2, -i2, 0.0f);
        }
        if (i == 48) {
            return createTranslationYAnimator(view2, -i2, 0.0f);
        }
        if (i == 80) {
            return createTranslationYAnimator(view2, i2, 0.0f);
        }
        if (i == 8388611) {
            return createTranslationXAnimator(view2, isRtl(view) ? i2 : -i2, 0.0f);
        } else if (i == 8388613) {
            return createTranslationXAnimator(view2, isRtl(view) ? -i2 : i2, 0.0f);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + i);
        }
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i, @Px int i2) {
        if (i == 3) {
            return createTranslationXAnimator(view2, 0.0f, -i2);
        }
        if (i == 5) {
            return createTranslationXAnimator(view2, 0.0f, i2);
        }
        if (i == 48) {
            return createTranslationYAnimator(view2, 0.0f, i2);
        }
        if (i == 80) {
            return createTranslationYAnimator(view2, 0.0f, -i2);
        }
        if (i == 8388611) {
            return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? -i2 : i2);
        } else if (i == 8388613) {
            return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? i2 : -i2);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + i);
        }
    }

    private static Animator createTranslationXAnimator(View view, float f2, float f3) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f2, f3));
    }

    private static Animator createTranslationYAnimator(View view, float f2, float f3) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f2, f3));
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i = this.slideDistance;
        return i != -1 ? i : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int i) {
        if (i >= 0) {
            this.slideDistance = i;
            return;
        }
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int i) {
        this.slideEdge = i;
    }
}
