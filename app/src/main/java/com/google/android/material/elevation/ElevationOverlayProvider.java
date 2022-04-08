package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes2.dex */
public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2.0f;
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(@NonNull Context context) {
        this.elevationOverlayEnabled = MaterialAttributes.resolveBoolean(context, R.attr.elevationOverlayEnabled, false);
        this.elevationOverlayColor = MaterialColors.getColor(context, R.attr.elevationOverlayColor, 0);
        this.colorSurface = MaterialColors.getColor(context, R.attr.colorSurface, 0);
        this.displayDensity = context.getResources().getDisplayMetrics().density;
    }

    private boolean isThemeSurfaceColor(@ColorInt int i) {
        return ColorUtils.setAlphaComponent(i, 255) == this.colorSurface;
    }

    public int calculateOverlayAlpha(float f2) {
        return Math.round(calculateOverlayAlphaFraction(f2) * 255.0f);
    }

    public float calculateOverlayAlphaFraction(float f2) {
        float f3 = this.displayDensity;
        if (f3 <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / f3)) * FORMULA_MULTIPLIER) + FORMULA_OFFSET) / 100.0f, 1.0f);
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int i, float f2, @NonNull View view) {
        return compositeOverlay(i, f2 + getParentAbsoluteElevation(view));
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int i, float f2, @NonNull View view) {
        return compositeOverlayIfNeeded(i, f2 + getParentAbsoluteElevation(view));
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f2, @NonNull View view) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(f2 + getParentAbsoluteElevation(view));
    }

    public float getParentAbsoluteElevation(@NonNull View view) {
        return ViewUtils.getParentAbsoluteElevation(view);
    }

    @ColorInt
    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    @ColorInt
    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int i, float f2) {
        float calculateOverlayAlphaFraction = calculateOverlayAlphaFraction(f2);
        return ColorUtils.setAlphaComponent(MaterialColors.layer(ColorUtils.setAlphaComponent(i, 255), this.elevationOverlayColor, calculateOverlayAlphaFraction), Color.alpha(i));
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int i, float f2) {
        return (!this.elevationOverlayEnabled || !isThemeSurfaceColor(i)) ? i : compositeOverlay(i, f2);
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f2) {
        return compositeOverlayIfNeeded(this.colorSurface, f2);
    }
}
