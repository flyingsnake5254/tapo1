package com.tplink.iot.devices.lightstrip.lightingeffect;

import androidx.recyclerview.widget.DiffUtil;
import com.tplink.iot.devices.lightstrip.lightingeffect.common.KasaLightState;
import java.util.Objects;
import kotlin.jvm.internal.j;

/* compiled from: ColorPaintingSegment.kt */
/* loaded from: classes2.dex */
public final class ColorPaintingSegment {
    private KasaLightState a;

    /* renamed from: b  reason: collision with root package name */
    private int f7503b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7504c;

    /* compiled from: ColorPaintingSegment.kt */
    /* loaded from: classes2.dex */
    public static final class DiffCallback extends DiffUtil.ItemCallback<ColorPaintingSegment> {
        /* renamed from: a */
        public boolean areContentsTheSame(ColorPaintingSegment oldItem, ColorPaintingSegment newItem) {
            j.e(oldItem, "oldItem");
            j.e(newItem, "newItem");
            return j.a(oldItem.e().getHue(), newItem.e().getHue()) && j.a(oldItem.e().getSaturation(), newItem.e().getSaturation()) && j.a(oldItem.e().getBrightness(), newItem.e().getBrightness()) && j.a(oldItem.e().getRelayState(), newItem.e().getRelayState()) && oldItem.c() == newItem.c();
        }

        /* renamed from: b */
        public boolean areItemsTheSame(ColorPaintingSegment oldItem, ColorPaintingSegment newItem) {
            j.e(oldItem, "oldItem");
            j.e(newItem, "newItem");
            return oldItem.d() == newItem.d();
        }
    }

    public ColorPaintingSegment(KasaLightState lightState, int i, boolean z) {
        j.e(lightState, "lightState");
        this.a = lightState;
        this.f7503b = i;
        this.f7504c = z;
    }

    public static /* synthetic */ ColorPaintingSegment b(ColorPaintingSegment colorPaintingSegment, KasaLightState kasaLightState, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kasaLightState = colorPaintingSegment.a;
        }
        if ((i2 & 2) != 0) {
            i = colorPaintingSegment.f7503b;
        }
        if ((i2 & 4) != 0) {
            z = colorPaintingSegment.f7504c;
        }
        return colorPaintingSegment.a(kasaLightState, i, z);
    }

    public final ColorPaintingSegment a(KasaLightState lightState, int i, boolean z) {
        j.e(lightState, "lightState");
        return new ColorPaintingSegment(lightState, i, z);
    }

    public final boolean c() {
        return this.f7504c;
    }

    public final int d() {
        return this.f7503b;
    }

    public final KasaLightState e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!j.a(ColorPaintingSegment.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.tplink.iot.devices.lightstrip.lightingeffect.ColorPaintingSegment");
        return this.f7503b == ((ColorPaintingSegment) obj).f7503b;
    }

    public final boolean f() {
        Integer saturation;
        Integer hue;
        Integer brightness = this.a.getBrightness();
        return brightness != null && brightness.intValue() == 0 && (saturation = this.a.getSaturation()) != null && saturation.intValue() == 0 && (hue = this.a.getHue()) != null && hue.intValue() == 0;
    }

    public int hashCode() {
        return this.f7503b;
    }

    public String toString() {
        return "ColorPaintingSegment(lightState=" + this.a + ", index=" + this.f7503b + ", enabled=" + this.f7504c + ")";
    }
}
