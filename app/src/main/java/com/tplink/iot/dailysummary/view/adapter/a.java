package com.tplink.iot.dailysummary.view.adapter;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.c;
import com.tplink.iot.dailysummary.model.SummaryClipItem;
import com.tplink.iot.dailysummary.network.bean.common.SummaryImage;
import com.tplink.iot.e.a.b;
import com.tplink.iot.e.a.d;
import kotlin.jvm.internal.j;

/* compiled from: ImageBindingAdapter.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    @BindingAdapter({"summary_clip"})
    public static final void a(ImageView view, SummaryClipItem summaryClipItem) {
        j.e(view, "view");
        if (summaryClipItem != null) {
            c.u(view.getContext()).r(new b(summaryClipItem)).f(com.bumptech.glide.load.engine.j.a).c().x0(view);
        }
    }

    @BindingAdapter({"summary"})
    public static final void b(ImageView view, com.tplink.iot.dailysummary.model.b bVar) {
        j.e(view, "view");
        if (bVar != null) {
            SummaryImage k = bVar.k();
            String l = bVar.l();
            if (l != null && k != null && l.length() != 0) {
                c.u(view.getContext()).r(new d(bVar)).f(com.bumptech.glide.load.engine.j.a).c().x0(view);
            }
        }
    }
}
