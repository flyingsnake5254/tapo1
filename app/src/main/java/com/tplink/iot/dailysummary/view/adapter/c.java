package com.tplink.iot.dailysummary.view.adapter;

import androidx.databinding.BindingAdapter;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.jvm.internal.j;

/* compiled from: TimeAxisBindingAdapter.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    @BindingAdapter({"summary_clip_split_point_list"})
    public static final void a(SummaryTimeAxisLayout timeAxisLayout, ArrayList<Long> arrayList) {
        j.e(timeAxisLayout, "timeAxisLayout");
        if (arrayList != null) {
            timeAxisLayout.setClipSplitPointList(arrayList);
        }
    }

    @BindingAdapter({"summary_clip_hightlight"})
    public static final void b(SummaryTimeAxisLayout timeAxisLayout, boolean z) {
        j.e(timeAxisLayout, "timeAxisLayout");
        timeAxisLayout.e(z);
    }

    @BindingAdapter({"summary_thumbnail_list"})
    public static final void c(SummaryTimeAxisLayout timeAxisLayout, LinkedList<com.tplink.iot.dailysummary.model.c> linkedList) {
        j.e(timeAxisLayout, "timeAxisLayout");
        if (linkedList != null) {
            timeAxisLayout.setThumbnailList(linkedList);
        }
    }

    @BindingAdapter({"player_currentTime"})
    public static final void d(SummaryTimeAxisLayout timeAxisLayout, long j) {
        j.e(timeAxisLayout, "timeAxisLayout");
        timeAxisLayout.setPlayerCurrentTime(j);
    }

    @BindingAdapter({"summary_duration"})
    public static final void e(SummaryTimeAxisLayout timeAxisLayout, Long l) {
        j.e(timeAxisLayout, "timeAxisLayout");
        if (l != null) {
            timeAxisLayout.setSummaryDuration(l.longValue());
        }
    }

    @BindingAdapter({"time_changed_listener"})
    public static final void f(SummaryTimeAxisLayout timeAxisLayout, SummaryTimeAxisLayout.b bVar) {
        j.e(timeAxisLayout, "timeAxisLayout");
        timeAxisLayout.setOnTimeChangedListener(bVar);
    }
}
