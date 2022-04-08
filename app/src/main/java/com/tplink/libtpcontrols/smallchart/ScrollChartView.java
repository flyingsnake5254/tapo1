package com.tplink.libtpcontrols.smallchart;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ScrollChartView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private Context f12411c;

    /* renamed from: d  reason: collision with root package name */
    private CurveLineView f12412d = null;

    /* renamed from: f  reason: collision with root package name */
    private List<Integer> f12413f = new ArrayList();
    private List<String> q = new ArrayList();

    public ScrollChartView(Context context) {
        super(context);
    }

    private void a(List<Integer> list, String str) {
        if (str == null) {
            b(list);
        } else {
            c(list, str);
        }
    }

    private void b(List<Integer> list) {
        String str;
        this.q.clear();
        this.q.add("");
        for (int i = 1; i <= list.size(); i++) {
            int i2 = i % 10;
            if (i2 == 1 && i != 11) {
                str = "" + i + "st";
            } else if (i2 == 2 && i != 12) {
                str = "" + i + "nd";
            } else if (i2 != 3 || i == 13) {
                str = "" + i + "th";
            } else {
                str = "" + i + "rd";
            }
            this.q.add(str);
        }
    }

    private void c(List<Integer> list, String str) {
        this.q.clear();
        this.q.add("");
        for (int i = 1; i <= list.size(); i++) {
            this.q.add(str + i);
        }
    }

    private void d(Context context) {
        this.f12411c = context;
        LayoutInflater.from(context).inflate(t0.scroll_chart_layout, (ViewGroup) this, true);
        this.f12412d = (CurveLineView) findViewById(s0.line_view);
    }

    private void e(List<String> list) {
        this.f12412d.setDrawDotLine(Boolean.TRUE);
        this.f12412d.setShowPopup(1);
        this.f12412d.setBottomTextList((ArrayList) this.q);
        if (list == null || list.isEmpty()) {
            this.f12412d.r(null, (ArrayList) this.f12413f);
        } else {
            this.f12412d.r((ArrayList) list, (ArrayList) this.f12413f);
        }
    }

    @TargetApi(17)
    private boolean f(Context context) {
        return Build.VERSION.SDK_INT >= 17 && context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public void setChartDataList(List<Integer> list) {
        if (list != null && list.size() > 0) {
            this.f12413f.clear();
            this.f12413f.add(list.get(0));
            this.f12413f.addAll(list);
            a(list, null);
            if (f(this.f12411c)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int size = this.f12413f.size() - 1; size >= 0; size--) {
                    arrayList.add(this.f12413f.get(size));
                }
                for (int size2 = this.q.size() - 1; size2 >= 0; size2--) {
                    arrayList2.add(this.q.get(size2));
                }
                this.f12413f = arrayList;
                this.q = arrayList2;
            }
            e(null);
        }
    }

    public ScrollChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }
}
