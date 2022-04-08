package com.tplink.iot.widget.colorbulb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class DetailBottomRuleViewV2 extends LinearLayout implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private boolean f11763c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11764d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f11765f;
    private a p0;
    private TextView q;
    private View x;
    private View y;
    private int z;

    /* loaded from: classes3.dex */
    public interface a {
        void onBottomRuleClick(View view);
    }

    public DetailBottomRuleViewV2(Context context) {
        this(context, null);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void b(int i) {
        if (i == 0) {
            this.f11764d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getResources().getDrawable(R.mipmap.ic_mode), (Drawable) null, (Drawable) null);
            this.x.setVisibility(0);
            this.y.setVisibility(8);
            this.f11764d.setText(R.string.scene_theme);
            return;
        }
        this.x.setVisibility(8);
        this.y.setVisibility(0);
        this.f11764d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getResources().getDrawable(R.mipmap.ic_mode_back), (Drawable) null, (Drawable) null);
        this.f11764d.setText("");
    }

    public void a(String str, String str2) {
        this.f11765f.setText(str);
        this.q.setText(str2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.item_mode) {
            a aVar = this.p0;
            if (aVar != null) {
                aVar.onBottomRuleClick(view);
                return;
            }
            return;
        }
        int i = this.z == 0 ? 1 : 0;
        this.z = i;
        b(i);
    }

    public void setOnBottomRuleClickListener(a aVar) {
        this.p0 = aVar;
    }

    public void setSupportLightEffect(boolean z) {
        this.f11763c = z;
        if (z) {
            this.f11764d.setVisibility(0);
            return;
        }
        this.f11764d.setVisibility(8);
        this.y.setVisibility(8);
    }

    public DetailBottomRuleViewV2(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailBottomRuleViewV2(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11763c = false;
        this.z = 0;
        LayoutInflater.from(context).inflate(R.layout.view_color_detail_bottom_rule_layout_v2, (ViewGroup) this, true);
        this.x = findViewById(R.id.ll_rules);
        this.y = findViewById(R.id.ll_mode_light_effect);
        this.f11764d = (TextView) findViewById(R.id.item_mode);
        this.f11765f = (TextView) findViewById(R.id.mode_direct);
        this.q = (TextView) findViewById(R.id.mode_breath);
        this.f11764d.setOnClickListener(this);
        this.f11765f.setOnClickListener(this);
        this.q.setOnClickListener(this);
        findViewById(R.id.mode_schedule).setOnClickListener(this);
        findViewById(R.id.mode_away).setOnClickListener(this);
        findViewById(R.id.mode_timer).setOnClickListener(this);
        setSupportLightEffect(false);
    }
}
