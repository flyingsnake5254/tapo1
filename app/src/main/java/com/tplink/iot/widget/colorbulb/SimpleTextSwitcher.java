package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class SimpleTextSwitcher extends TextSwitcher implements ViewSwitcher.ViewFactory {
    public SimpleTextSwitcher(Context context) {
        this(context, null);
    }

    public void a(boolean z, int i, boolean z2) {
        String str;
        TextView textView = (TextView) getNextView();
        textView.setTextColor(z ? getResources().getColor(R.color.common_iot_dark_black) : -1);
        if (z) {
            str = i + "%";
        } else {
            str = getResources().getString(R.string.common_off);
        }
        textView.setText(str);
        if (!z2) {
            setInAnimation(null);
            setOutAnimation(null);
        } else if (z) {
            setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_from_bottom));
            setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_from_top));
        } else {
            textView.setText(getResources().getString(R.string.common_off));
            setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_from_top));
            setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_from_bottom));
        }
        showNext();
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setTextSize(2, 20.0f);
        return textView;
    }

    public SimpleTextSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFactory(this);
    }
}
