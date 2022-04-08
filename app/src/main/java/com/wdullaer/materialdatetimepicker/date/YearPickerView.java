package com.wdullaer.materialdatetimepicker.date;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class YearPickerView extends ListView implements AdapterView.OnItemClickListener, b {

    /* renamed from: c  reason: collision with root package name */
    private final a f15301c;

    /* renamed from: d  reason: collision with root package name */
    private TextViewWithCircularIndicator f15302d;

    private static int a(TextView textView) {
        return Integer.valueOf(textView.getText().toString()).intValue();
    }

    public int getFirstPositionOffset() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return childAt.getTop();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4096) {
            accessibilityEvent.setFromIndex(0);
            accessibilityEvent.setToIndex(0);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f15301c.a();
        TextViewWithCircularIndicator textViewWithCircularIndicator = (TextViewWithCircularIndicator) view;
        if (textViewWithCircularIndicator != null) {
            TextViewWithCircularIndicator textViewWithCircularIndicator2 = this.f15302d;
            if (textViewWithCircularIndicator != textViewWithCircularIndicator2) {
                if (textViewWithCircularIndicator2 != null) {
                    textViewWithCircularIndicator2.a(false);
                    this.f15302d.requestLayout();
                }
                textViewWithCircularIndicator.a(true);
                textViewWithCircularIndicator.requestLayout();
                this.f15302d = textViewWithCircularIndicator;
            }
            this.f15301c.n(a(textViewWithCircularIndicator));
            throw null;
        }
    }
}
