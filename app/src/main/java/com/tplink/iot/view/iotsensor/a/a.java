package com.tplink.iot.view.iotsensor.a;

import android.content.Context;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.tplink.iot.R;
import com.tplink.iot.widget.ItemSettingLayout;
import kotlin.jvm.internal.j;

/* compiled from: BindingAdapters.kt */
/* loaded from: classes2.dex */
public final class a {
    @BindingAdapter({"intervalInfo"})
    public static final void a(ItemSettingLayout view, Integer num) {
        j.e(view, "view");
        Context context = view.getContext();
        if (num == null || num.intValue() < 0) {
            view.setItemInfo("");
        } else if (num.intValue() <= 1) {
            view.setItemInfo(context.getString(R.string.time_second, num));
        } else {
            view.setItemInfo(context.getString(R.string.time_seconds, num));
        }
    }

    @BindingAdapter({"sensitivityHintColor"})
    public static final void b(TextView view, Integer num) {
        j.e(view, "view");
        int parseInt = Integer.parseInt(view.getTag().toString());
        if (num != null && parseInt == num.intValue()) {
            Context context = view.getContext();
            j.d(context, "view.context");
            view.setTextColor(context.getResources().getColor(R.color.common_iot_dark_black));
            return;
        }
        Context context2 = view.getContext();
        j.d(context2, "view.context");
        view.setTextColor(context2.getResources().getColor(R.color.common_iot_light_gray));
    }

    @BindingAdapter({"sensitivityInfo"})
    public static final void c(ItemSettingLayout view, String str) {
        String str2;
        j.e(view, "view");
        Context context = view.getContext();
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1039745817) {
                if (hashCode != 107348) {
                    if (hashCode == 3202466 && str.equals("high")) {
                        str2 = context.getString(R.string.mode_sound_sensitive_high);
                    }
                } else if (str.equals("low")) {
                    str2 = context.getString(R.string.mode_sound_sensitive_low);
                }
            } else if (str.equals("normal")) {
                str2 = context.getString(R.string.mode_sound_sensitive_normal);
            }
            j.d(str2, "when (sensitivity) {\n   …\n        else -> \"\"\n    }");
            view.setItemInfo(str2);
        }
        str2 = "";
        j.d(str2, "when (sensitivity) {\n   …\n        else -> \"\"\n    }");
        view.setItemInfo(str2);
    }
}
