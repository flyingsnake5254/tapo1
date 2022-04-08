package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.content.ContextCompat;
import com.tplink.iot.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DrawableEditText extends FrameLayout implements View.OnClickListener, TextWatcher {
    private View.OnFocusChangeListener H3;
    private AdapterView.OnItemClickListener I3;
    private List<TextWatcher> J3;
    private boolean K3;
    private boolean L3;
    private boolean M3;
    private boolean N3;
    private Drawable O3;
    private Drawable P3;
    private Drawable Q3;

    /* renamed from: c  reason: collision with root package name */
    private View f11506c;

    /* renamed from: d  reason: collision with root package name */
    private AppCompatAutoCompleteTextView f11507d;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f11508f;
    private ImageView p0;
    private int p1;
    private CharSequence p2;
    private boolean p3;
    private ImageView q;
    private View x;
    private TextView y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (DrawableEditText.this.I3 != null) {
                DrawableEditText.this.I3.onItemClick(adapterView, DrawableEditText.this.f11506c, i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            DrawableEditText.this.i(z);
            if (DrawableEditText.this.H3 != null) {
                DrawableEditText.this.H3.onFocusChange(DrawableEditText.this.f11506c, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DrawableEditText.this.q.setVisibility(0);
        }
    }

    public DrawableEditText(Context context) {
        this(context, null);
    }

    private void g() {
        if (this.M3 && this.q.getVisibility() != 0) {
            this.q.post(new c());
        }
    }

    private void h() {
        this.K3 = true;
        int selectionStart = this.f11507d.getSelectionStart();
        if (!this.p3) {
            this.f11507d.setInputType(129);
            this.f11507d.setTypeface(Typeface.DEFAULT);
            this.f11508f.setImageResource(R.mipmap.text_visibility_off);
        } else {
            this.f11507d.setInputType(1);
            this.f11507d.setTypeface(Typeface.DEFAULT);
            this.f11508f.setImageResource(R.mipmap.text_visibility_on);
        }
        Selection.setSelection(this.f11507d.getText(), selectionStart);
        this.K3 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z) {
        if (z) {
            setLineColor(R.color.common_iot_main_blue);
            setHintDrawable(this.P3);
            if (this.f11507d.getText().length() > 0) {
                g();
                return;
            }
            return;
        }
        setLineColor(R.color.common_divider_gray_color);
        setHintDrawable(this.O3);
        if (this.M3) {
            this.q.setVisibility(4);
        }
    }

    private void j(Context context, AttributeSet attributeSet) {
        this.f11506c = LayoutInflater.from(context).inflate(R.layout.layout_common_edit_text, (ViewGroup) this, true);
        this.f11507d = (AppCompatAutoCompleteTextView) findViewById(R.id.edit_text);
        this.p0 = (ImageView) findViewById(R.id.edit_text_drawable);
        this.f11508f = (ImageView) findViewById(R.id.edit_text_password_toggle);
        this.q = (ImageView) findViewById(R.id.edit_text_clear);
        this.x = findViewById(R.id.edit_text_line);
        this.y = (TextView) findViewById(R.id.edit_text_error);
        this.z = (TextView) findViewById(R.id.edit_text_help);
        this.f11508f.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.f11507d.setOnItemClickListener(new a());
        this.f11507d.setOnFocusChangeListener(new b());
        f(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tplink.iot.b.DrawableEditText);
        this.f11507d.setTextAppearance(getContext(), obtainStyledAttributes.getResourceId(24, R.style.common_text_main_dark_regular_16dp));
        float dimension = obtainStyledAttributes.getDimension(28, -1.0f);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(25);
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(20);
        String string = obtainStyledAttributes.getString(23);
        String string2 = obtainStyledAttributes.getString(16);
        if (dimension != -1.0f) {
            this.f11507d.setTextSize(dimension);
        }
        if (colorStateList != null) {
            this.f11507d.setTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.f11507d.setHintTextColor(colorStateList2);
        }
        if (string != null) {
            this.f11507d.setText(string);
            this.f11507d.setSelection(string.length());
        }
        if (string2 != null) {
            this.f11507d.setHint(string2);
        }
        this.O3 = obtainStyledAttributes.getDrawable(17);
        Drawable drawable = obtainStyledAttributes.getDrawable(19);
        this.P3 = drawable;
        if (drawable == null) {
            this.P3 = this.O3;
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(18);
        this.Q3 = drawable2;
        if (drawable2 == null) {
            Drawable drawable3 = this.P3;
            if (drawable3 != null) {
                this.Q3 = drawable3;
            } else {
                this.Q3 = this.O3;
            }
        }
        Drawable drawable4 = this.O3;
        if (drawable4 != null) {
            this.p0.setImageDrawable(drawable4);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(26, b.d.w.f.a.a(getContext(), 14.0f));
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(27, b.d.w.f.a.a(getContext(), 14.0f));
            AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = this.f11507d;
            appCompatAutoCompleteTextView.setPadding(dimensionPixelSize, appCompatAutoCompleteTextView.getPaddingTop(), dimensionPixelSize2, this.f11507d.getPaddingBottom());
        } else {
            this.p0.setImageDrawable(null);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(26, 0);
            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(27, 0);
            AppCompatAutoCompleteTextView appCompatAutoCompleteTextView2 = this.f11507d;
            appCompatAutoCompleteTextView2.setPadding(dimensionPixelSize3, appCompatAutoCompleteTextView2.getPaddingTop(), dimensionPixelSize4, this.f11507d.getPaddingBottom());
        }
        Drawable drawable5 = obtainStyledAttributes.getDrawable(4);
        if (drawable5 != null) {
            this.q.setImageDrawable(drawable5);
        }
        boolean z = obtainStyledAttributes.getBoolean(5, true);
        this.M3 = z;
        if (z) {
            this.q.setVisibility(4);
        } else {
            this.q.setVisibility(8);
        }
        Drawable drawable6 = obtainStyledAttributes.getDrawable(21);
        if (drawable6 != null) {
            this.f11508f.setImageDrawable(drawable6);
        }
        int i = obtainStyledAttributes.getInt(1, 1);
        this.f11507d.setInputType(i);
        this.f11507d.setTypeface(Typeface.DEFAULT);
        if (i == 129) {
            this.f11508f.setVisibility(0);
        } else if (i == 18) {
            this.f11508f.setVisibility(0);
        } else if (i == 145) {
            this.f11508f.setVisibility(0);
        } else if (i == 225) {
            this.f11508f.setVisibility(0);
        } else {
            this.f11508f.setVisibility(8);
        }
        this.y.setTextAppearance(getContext(), obtainStyledAttributes.getResourceId(8, R.style.common_text_red_regular_12dp));
        float dimension2 = obtainStyledAttributes.getDimension(10, -1.0f);
        ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(9);
        Drawable drawable7 = obtainStyledAttributes.getDrawable(6);
        this.L3 = obtainStyledAttributes.getBoolean(7, true);
        if (dimension2 != -1.0f) {
            this.y.setTextSize(dimension2);
        }
        if (colorStateList3 != null) {
            this.y.setTextColor(colorStateList3);
        }
        if (drawable7 != null) {
            this.y.setCompoundDrawables(null, null, drawable7, null);
        }
        if (this.L3) {
            this.y.setVisibility(4);
        } else {
            this.y.setVisibility(8);
        }
        this.z.setTextAppearance(getContext(), obtainStyledAttributes.getResourceId(13, R.style.common_text_annotation_regular_12dp));
        float dimension3 = obtainStyledAttributes.getDimension(15, -1.0f);
        ColorStateList colorStateList4 = obtainStyledAttributes.getColorStateList(14);
        Drawable drawable8 = obtainStyledAttributes.getDrawable(11);
        this.N3 = obtainStyledAttributes.getBoolean(12, true);
        if (dimension3 != -1.0f) {
            this.z.setTextSize(dimension3);
        }
        if (colorStateList4 != null) {
            this.z.setTextColor(colorStateList4);
        }
        if (drawable8 != null) {
            this.z.setCompoundDrawables(null, null, drawable8, null);
        }
        if (this.N3) {
            this.z.setVisibility(4);
        } else {
            this.z.setVisibility(8);
        }
        int i2 = obtainStyledAttributes.getInt(2, 0);
        this.p1 = i2;
        this.f11507d.setImeOptions(i2);
        CharSequence text = obtainStyledAttributes.getText(3);
        this.p2 = text;
        if (!TextUtils.isEmpty(text)) {
            this.f11507d.setImeActionLabel(this.p2, this.p1);
        }
        int i3 = obtainStyledAttributes.getInt(0, -1);
        if (i3 != -1) {
            this.f11507d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
        }
        if (this.f11508f.getVisibility() == 0) {
            this.p3 = obtainStyledAttributes.getBoolean(22, false);
            h();
        }
        obtainStyledAttributes.recycle();
    }

    private void setHintDrawable(Drawable drawable) {
        this.p0.setImageDrawable(drawable);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.toString().length() > 0) {
            g();
        } else if (this.M3) {
            this.q.setVisibility(4);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void f(TextWatcher textWatcher) {
        if (!this.J3.contains(textWatcher)) {
            this.J3.add(textWatcher);
            this.f11507d.addTextChangedListener(textWatcher);
        }
    }

    public EditText getEditText() {
        return this.f11507d;
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        return this.H3;
    }

    public Editable getText() {
        return this.f11507d.getText();
    }

    public boolean k() {
        return this.K3;
    }

    public void l(TextWatcher textWatcher) {
        this.J3.remove(textWatcher);
        this.f11507d.removeTextChangedListener(textWatcher);
    }

    public void m() {
        this.f11507d.setFocusable(true);
        this.f11507d.setFocusableInTouchMode(true);
        this.f11507d.requestFocus();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.edit_text_clear) {
            this.f11507d.setText("");
        } else if (id == R.id.edit_text_password_toggle) {
            this.p3 = !this.p3;
            h();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        this.f11507d.setAdapter(t);
    }

    public void setEmailList(List<String> list) {
        if (list != null && list.size() > 0) {
            this.f11507d.setAdapter(new com.tplink.libtpcontrols.y0.a(getContext(), list));
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f11507d.setEnabled(z);
        this.q.setEnabled(z);
        this.f11508f.setEnabled(z);
    }

    public void setErrorText(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            if (this.L3) {
                this.y.setVisibility(4);
            } else {
                this.y.setVisibility(8);
            }
            i(this.f11507d.isFocused());
        } else {
            this.y.setVisibility(0);
            setLineColor(R.color.common_iot_red);
            setHintDrawable(this.Q3);
        }
        this.y.setText(charSequence);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f11507d.setFilters(inputFilterArr);
    }

    public void setHelpText(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            this.z.setVisibility(0);
        } else if (this.N3) {
            this.z.setVisibility(4);
        } else {
            this.z.setVisibility(8);
        }
        this.z.setText(charSequence);
    }

    public void setHint(int i) {
        this.f11507d.setHint(i);
    }

    public void setLineColor(@ColorRes int i) {
        this.x.setBackground(ContextCompat.getDrawable(getContext(), i));
    }

    public void setMaxLength(int i) {
        this.f11507d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
    }

    public void setNormalList(List<String> list) {
        if (list != null && list.size() > 0) {
            this.f11507d.setAdapter(new ArrayAdapter(getContext(), (int) R.layout.auto_complete_normal_adapter, list));
        }
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        this.f11507d.setOnEditorActionListener(onEditorActionListener);
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.H3 = onFocusChangeListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.I3 = onItemClickListener;
    }

    public void setSelectAllOnFocus(boolean z) {
        this.f11507d.setSelectAllOnFocus(z);
    }

    public void setSelection(int i) {
        this.f11507d.setSelection(i);
    }

    public void setText(CharSequence charSequence) {
        this.f11507d.setText(charSequence);
    }

    public void setThreshold(int i) {
        this.f11507d.setThreshold(i);
    }

    public DrawableEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setHint(CharSequence charSequence) {
        this.f11507d.setHint(charSequence);
    }

    public void setText(int i) {
        this.f11507d.setText(i);
    }

    public DrawableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11506c = null;
        this.f11507d = null;
        this.f11508f = null;
        this.q = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.p0 = null;
        this.p1 = -1;
        this.p2 = null;
        this.p3 = false;
        this.H3 = null;
        this.I3 = null;
        this.J3 = new ArrayList();
        this.L3 = false;
        this.M3 = false;
        this.N3 = false;
        this.O3 = null;
        this.P3 = null;
        this.Q3 = null;
        j(context, attributeSet);
    }

    public void setHelpText(int i) {
        setHelpText(getContext().getResources().getText(i));
    }

    public void setErrorText(int i) {
        setErrorText(getContext().getResources().getText(i));
    }
}
