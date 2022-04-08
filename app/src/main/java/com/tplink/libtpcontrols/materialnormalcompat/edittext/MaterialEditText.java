package com.tplink.libtpcontrols.materialnormalcompat.edittext;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ViewCompat;
import com.tplink.libtpcontrols.q0;
import com.tplink.libtpcontrols.u0;
import com.tplink.libtpcontrols.x0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes3.dex */
public class MaterialEditText extends AppCompatEditText {
    StaticLayout C4;
    ObjectAnimator D4;
    ObjectAnimator E4;
    ObjectAnimator F4;
    View.OnFocusChangeListener G4;
    private int H3;
    View.OnFocusChangeListener H4;
    private int I3;
    private List<com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b> I4;
    private int J3;
    private com.tplink.libtpcontrols.materialnormalcompat.edittext.c.a J4;
    private int K3;
    private Context K4;
    private int L3;
    private CharSequence L4;
    private int M3;
    private CharSequence M4;
    private int N3;
    private int O3;
    private Bitmap O4;
    private int P3;
    private int P4;
    private boolean Q3;
    private int Q4;
    private boolean R3;
    private CharSequence R4;
    private boolean S3;
    private int T3;
    private int U3;
    private int V3;
    private float W3;
    private float X3;
    private StaticLayout X4;
    private String Y3;
    private boolean Y4;
    private Bitmap[] Z4;
    private String a4;
    private Bitmap[] a5;
    private float b4;

    /* renamed from: c  reason: collision with root package name */
    private int f12330c;
    private boolean c4;

    /* renamed from: d  reason: collision with root package name */
    private int f12331d;
    private float d4;
    private Typeface e4;

    /* renamed from: f  reason: collision with root package name */
    private int f12332f;
    private Typeface f4;
    private CharSequence g4;
    private boolean h4;
    private int i4;
    private boolean j4;
    private int j5;
    private boolean k4;
    private String k5;
    private boolean l4;
    private int l5;
    private boolean m4;
    private boolean m5;
    private Bitmap[] n4;
    private e n5;
    private Bitmap[] o4;
    private int p0;
    private int p1;
    private boolean p2;
    private boolean p3;
    private Bitmap[] p4;
    private int q;
    private boolean q4;
    private boolean r4;
    private boolean s4;
    private int t4;
    private int u4;
    private boolean v4;
    private boolean w4;
    private int x;
    private ColorStateList x4;
    private int y;
    private ColorStateList y4;
    private int z;
    private int Z3 = -1;
    private ArgbEvaluator z4 = new ArgbEvaluator();
    Paint A4 = new Paint(1);
    TextPaint B4 = new TextPaint(1);
    private Animator.AnimatorListener N4 = null;
    private int S4 = 0;
    private int T4 = 0;
    private int U4 = 0;
    private int V4 = 0;
    private int W4 = 0;
    private boolean b5 = false;
    private int c5 = 0;
    private int d5 = 0;
    private int e5 = 0;
    private int f5 = 0;
    private boolean g5 = false;
    private boolean h5 = false;
    private boolean i5 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() != 0 && !MaterialEditText.this.hasFocus()) {
                Selection.setSelection(MaterialEditText.this.getText(), editable.length());
            }
            MaterialEditText.this.y();
            if (MaterialEditText.this.j4) {
                MaterialEditText.this.i0();
            } else {
                MaterialEditText.this.setError(null);
                MaterialEditText.this.B();
            }
            MaterialEditText.this.postInvalidate();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!MaterialEditText.this.p2) {
                return;
            }
            if (MaterialEditText.this.b4 == 0.0f) {
                if (TextUtils.isEmpty(MaterialEditText.this.L4)) {
                    MaterialEditText materialEditText = MaterialEditText.this;
                    materialEditText.L4 = materialEditText.M4;
                }
                MaterialEditText materialEditText2 = MaterialEditText.this;
                materialEditText2.setHint(materialEditText2.L4);
                return;
            }
            float unused = MaterialEditText.this.b4;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (MaterialEditText.this.p2 && editable.length() != 0 && !MaterialEditText.this.c4) {
                MaterialEditText.this.c4 = true;
                MaterialEditText.this.b4 = 1.0f;
                MaterialEditText materialEditText = MaterialEditText.this;
                materialEditText.L4 = materialEditText.getHint();
                MaterialEditText.this.setHint("");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (MaterialEditText.this.p2 && MaterialEditText.this.p3) {
                if (z) {
                    MaterialEditText.this.getLabelFocusAnimator().start();
                } else {
                    MaterialEditText.this.getLabelFocusAnimator().reverse();
                }
            }
            if (MaterialEditText.this.p2) {
                if (!z) {
                    if (MaterialEditText.this.c4 && TextUtils.isEmpty(MaterialEditText.this.getText())) {
                        MaterialEditText.this.c4 = false;
                        MaterialEditText.this.getLabelAnimator().reverse();
                    }
                    Log.i("material_debug", "focus = 0 fs: " + MaterialEditText.this.c4);
                    Log.i("material_debug", "focus = 0 hint:" + ((Object) MaterialEditText.this.L4));
                } else {
                    if (!MaterialEditText.this.c4) {
                        MaterialEditText.this.c4 = true;
                        MaterialEditText.this.getLabelAnimator().start();
                        MaterialEditText materialEditText = MaterialEditText.this;
                        materialEditText.L4 = materialEditText.getHint();
                        MaterialEditText.this.setHint("");
                    }
                    Log.i("material_debug", "focus != 0 fs: " + MaterialEditText.this.c4);
                    Log.i("material_debug", "focus != 0 hint:" + ((Object) MaterialEditText.this.L4));
                }
            }
            if (MaterialEditText.this.q4 && !z) {
                MaterialEditText.this.i0();
            }
            View.OnFocusChangeListener onFocusChangeListener = MaterialEditText.this.H4;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(view, z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(boolean z);
    }

    public MaterialEditText(Context context) {
        super(context);
        O(context, null);
    }

    private boolean A(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
    }

    @TargetApi(16)
    private void C() {
        int width = (f0() ? this.p4[0].getWidth() : 0) + (d0() ? this.Z4[0].getWidth() : 0);
        int i = this.c5 + this.d5;
        if (this.Y4) {
            i += this.e5 + this.f5;
        }
        if (e0()) {
            super.setPaddingRelative(this.K3 + this.f12332f + 0, this.I3 + this.f12330c, this.L3 + this.q + width + this.S4 + i, this.J3 + this.f12331d);
        } else {
            super.setPadding(this.K3 + this.f12332f + 0, this.I3 + this.f12330c, this.L3 + this.q + width + this.S4 + i, this.J3 + this.f12331d);
        }
    }

    private StaticLayout D(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        TextPaint textPaint = this.B4;
        return new StaticLayout(charSequence, textPaint, (int) textPaint.measureText(charSequence.toString()), alignment, 1.0f, 0.0f, true);
    }

    private Bitmap E(@DrawableRes int i) {
        if (i == -1) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), i, options);
        int max = Math.max(options.outWidth, options.outHeight);
        int i3 = this.t4;
        if (max > i3) {
            i2 = max / i3;
        }
        options.inSampleSize = i2;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(getResources(), i, options);
    }

    private Bitmap[] F(@DrawableRes int i) {
        if (i == -1) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), i, options);
        int max = Math.max(options.outWidth, options.outHeight);
        int i3 = this.t4;
        if (max > i3) {
            i2 = max / i3;
        }
        options.inSampleSize = i2;
        options.inJustDecodeBounds = false;
        return G(BitmapFactory.decodeResource(getResources(), i, options));
    }

    private Bitmap[] G(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap[] bitmapArr = new Bitmap[4];
        bitmapArr[0] = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmapArr[0]);
        int i = this.H3;
        canvas.drawColor((a.a(i) ? ViewCompat.MEASURED_STATE_MASK : -1979711488) | (i & 16777215), PorterDuff.Mode.SRC_IN);
        bitmapArr[1] = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(bitmapArr[1]).drawColor(this.M3, PorterDuff.Mode.SRC_IN);
        bitmapArr[2] = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas2 = new Canvas(bitmapArr[2]);
        int i2 = this.H3;
        canvas2.drawColor((a.a(i2) ? 1275068416 : 1107296256) | (16777215 & i2), PorterDuff.Mode.SRC_IN);
        bitmapArr[3] = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(bitmapArr[3]).drawColor(this.N3, PorterDuff.Mode.SRC_IN);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapArr;
    }

    private Bitmap[] H(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        int i = this.t4;
        return G(Bitmap.createScaledBitmap(createBitmap, i, i, false));
    }

    private Bitmap[] I(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap[] bitmapArr = {bitmap.copy(Bitmap.Config.ARGB_8888, true), bitmap.copy(Bitmap.Config.ARGB_8888, true), bitmap.copy(Bitmap.Config.ARGB_8888, true), bitmap.copy(Bitmap.Config.ARGB_8888, true)};
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapArr;
    }

    private Bitmap[] J(@DrawableRes int i) {
        if (i == -1) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), i, options);
        int max = Math.max(options.outWidth, options.outHeight);
        int i3 = this.t4;
        if (max > i3) {
            i2 = max / i3;
        }
        options.inSampleSize = i2;
        options.inJustDecodeBounds = false;
        return I(BitmapFactory.decodeResource(getResources(), i, options));
    }

    private ObjectAnimator K(float f2) {
        ObjectAnimator objectAnimator = this.F4;
        if (objectAnimator == null) {
            this.F4 = ObjectAnimator.ofFloat(this, "currentBottomLines", f2);
        } else {
            objectAnimator.cancel();
            this.F4.setFloatValues(f2);
        }
        return this.F4;
    }

    private Typeface L(@NonNull String str) {
        return Typeface.createFromAsset(getContext().getAssets(), str);
    }

    private int M(int i) {
        return b.a(getContext(), i);
    }

    private boolean N() {
        return this.O3 > 0 || this.P3 > 0;
    }

    private void O(Context context, AttributeSet attributeSet) {
        int i;
        this.K4 = context;
        if (!isInEditMode()) {
            this.t4 = getResources().getDimensionPixelSize(q0.icon_max_size);
            this.p1 = getResources().getDimensionPixelSize(q0.inner_components_spacing);
            this.T3 = getResources().getDimensionPixelSize(q0.bottom_ellipsis_height);
            this.P4 = getResources().getDimensionPixelSize(q0.error_icon_width);
            this.Q4 = getResources().getDimensionPixelSize(q0.error_icon_height);
            this.T4 = getResources().getDimensionPixelSize(q0.postfix_max_length);
            this.U4 = getResources().getDimensionPixelSize(q0.postfix_min_length);
            this.c5 = M(3);
            this.d5 = M(3);
            this.e5 = M(3);
            this.f5 = M(3);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.MaterialEditText);
            this.x4 = obtainStyledAttributes.getColorStateList(x0.MaterialEditText_met_textColor);
            this.y4 = obtainStyledAttributes.getColorStateList(x0.MaterialEditText_met_textColorHint);
            this.H3 = obtainStyledAttributes.getColor(x0.MaterialEditText_met_baseColor, ViewCompat.MEASURED_STATE_MASK);
            TypedValue typedValue = new TypedValue();
            try {
                try {
                } catch (Exception unused) {
                    i = this.H3;
                }
            } catch (Exception unused2) {
                int identifier = getResources().getIdentifier("colorPrimary", "attr", getContext().getPackageName());
                if (identifier != 0) {
                    context.getTheme().resolveAttribute(identifier, typedValue, true);
                    i = typedValue.data;
                } else {
                    throw new RuntimeException("colorPrimary not found");
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                context.getTheme().resolveAttribute(16843827, typedValue, true);
                i = typedValue.data;
                this.M3 = obtainStyledAttributes.getColor(x0.MaterialEditText_met_primaryColor, i);
                setFloatingLabelInternal(obtainStyledAttributes.getInt(x0.MaterialEditText_met_floatingLabel, 0));
                this.N3 = obtainStyledAttributes.getColor(x0.MaterialEditText_met_errorColor, Color.parseColor("#e7492E"));
                this.O3 = obtainStyledAttributes.getInt(x0.MaterialEditText_met_minCharacters, 0);
                this.P3 = obtainStyledAttributes.getInt(x0.MaterialEditText_met_maxCharacters, 0);
                this.Q3 = obtainStyledAttributes.getBoolean(x0.MaterialEditText_met_singleLineEllipsis, false);
                this.Y3 = obtainStyledAttributes.getString(x0.MaterialEditText_met_helperText);
                this.Z3 = obtainStyledAttributes.getColor(x0.MaterialEditText_met_helperTextColor, -1);
                this.V3 = obtainStyledAttributes.getInt(x0.MaterialEditText_met_minBottomTextLines, 0);
                String string = obtainStyledAttributes.getString(x0.MaterialEditText_met_accentTypeface);
                if (string != null && !isInEditMode()) {
                    Typeface L = L(string);
                    this.e4 = L;
                    this.B4.setTypeface(L);
                }
                String string2 = obtainStyledAttributes.getString(x0.MaterialEditText_met_typeface);
                if (string2 != null && !isInEditMode()) {
                    Typeface L2 = L(string2);
                    this.f4 = L2;
                    setTypeface(L2);
                }
                String string3 = obtainStyledAttributes.getString(x0.MaterialEditText_met_floatingLabelText);
                this.g4 = string3;
                if (string3 == null) {
                    this.g4 = getHint();
                }
                this.p0 = obtainStyledAttributes.getDimensionPixelSize(x0.MaterialEditText_met_floatingLabelPadding, this.p1);
                this.x = obtainStyledAttributes.getDimensionPixelSize(x0.MaterialEditText_met_floatingLabelTextSize, getResources().getDimensionPixelSize(q0.floating_label_text_size));
                this.y = obtainStyledAttributes.getColor(x0.MaterialEditText_met_floatingLabelTextColor, -1);
                this.l4 = obtainStyledAttributes.getBoolean(x0.MaterialEditText_met_floatingLabelAnimating, true);
                this.z = obtainStyledAttributes.getDimensionPixelSize(x0.MaterialEditText_met_bottomTextSize, getResources().getDimensionPixelSize(q0.bottom_text_size));
                this.h4 = obtainStyledAttributes.getBoolean(x0.MaterialEditText_met_hideUnderline, false);
                this.i4 = obtainStyledAttributes.getColor(x0.MaterialEditText_met_underlineColor, -1);
                this.j4 = obtainStyledAttributes.getBoolean(x0.MaterialEditText_met_autoValidate, false);
                this.n4 = F(obtainStyledAttributes.getResourceId(x0.MaterialEditText_met_iconLeft, -1));
                this.o4 = F(obtainStyledAttributes.getResourceId(x0.MaterialEditText_met_iconRight, -1));
                this.r4 = obtainStyledAttributes.getBoolean(x0.MaterialEditText_met_clearButton, true);
                this.u4 = obtainStyledAttributes.getDimensionPixelSize(x0.MaterialEditText_met_iconPadding, M(16));
                this.R3 = obtainStyledAttributes.getBoolean(x0.MaterialEditText_met_floatingLabelAlwaysShown, false);
                this.S3 = obtainStyledAttributes.getBoolean(x0.MaterialEditText_met_helperTextAlwaysShown, false);
                this.q4 = obtainStyledAttributes.getBoolean(x0.MaterialEditText_met_validateOnFocusLost, false);
                this.m4 = obtainStyledAttributes.getBoolean(x0.MaterialEditText_met_checkCharactersCountAtBeginning, true);
                this.R4 = obtainStyledAttributes.getString(x0.MaterialEditText_met_postfix_text);
                this.V4 = obtainStyledAttributes.getColor(x0.MaterialEditText_met_postfix_textColor, -1);
                this.l5 = obtainStyledAttributes.getInt(x0.MaterialEditText_met_disable_underline_style, 0);
                this.m5 = obtainStyledAttributes.getBoolean(x0.MaterialEditText_met_enable_error_icon, true);
                this.W4 = (int) getTextSize();
                if (this.V4 < 0) {
                    this.V4 = this.H3;
                }
                this.O4 = E(obtainStyledAttributes.getResourceId(x0.MaterialEditText_met_iconError, u0.alert_triangle_met));
                if (!this.m5) {
                    this.O4 = null;
                }
                int i2 = obtainStyledAttributes.getInt(x0.MaterialEditText_met_icon_color_mode, 0);
                this.j5 = i2;
                if (i2 == 0) {
                    this.p4 = J(obtainStyledAttributes.getResourceId(x0.MaterialEditText_met_iconClear, u0.clear_cross_met));
                    int resourceId = obtainStyledAttributes.getResourceId(x0.MaterialEditText_met_iconEyeOn, -1);
                    int resourceId2 = obtainStyledAttributes.getResourceId(x0.MaterialEditText_met_iconEyeOff, -1);
                    if (resourceId <= 0 || resourceId2 <= 0) {
                        this.Z4 = J(u0.eyeball_invisible_met);
                        this.a5 = J(u0.eyeball_visible_met);
                    } else {
                        this.Z4 = J(resourceId2);
                        this.a5 = J(resourceId);
                    }
                } else {
                    this.p4 = F(obtainStyledAttributes.getResourceId(x0.MaterialEditText_met_iconClear, u0.ic_clear));
                    int resourceId3 = obtainStyledAttributes.getResourceId(x0.MaterialEditText_met_iconEyeOn, -1);
                    int resourceId4 = obtainStyledAttributes.getResourceId(x0.MaterialEditText_met_iconEyeOff, -1);
                    if (resourceId3 <= 0 || resourceId4 <= 0) {
                        this.Z4 = F(u0.ic_visibility_off);
                        this.a5 = F(u0.ic_visibility);
                    } else {
                        this.Z4 = F(resourceId4);
                        this.a5 = F(resourceId3);
                    }
                }
                this.Y4 = obtainStyledAttributes.getBoolean(x0.MaterialEditText_met_password, false);
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(x0.MaterialEditText_met_clear_left, 0);
                if (dimensionPixelSize > 0) {
                    this.c5 = dimensionPixelSize;
                }
                int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(x0.MaterialEditText_met_clear_right, 0);
                if (dimensionPixelSize2 > 0) {
                    this.d5 = dimensionPixelSize2;
                }
                int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(x0.MaterialEditText_met_eyeball_left, 0);
                if (dimensionPixelSize3 > 0) {
                    this.e5 = dimensionPixelSize3;
                }
                int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(x0.MaterialEditText_met_eyeball_right, 0);
                if (dimensionPixelSize4 > 0) {
                    this.f5 = dimensionPixelSize4;
                }
                obtainStyledAttributes.recycle();
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, new int[]{16842965, 16842966, 16842967, 16842968, 16842969});
                int dimensionPixelSize5 = obtainStyledAttributes2.getDimensionPixelSize(0, 0);
                this.K3 = obtainStyledAttributes2.getDimensionPixelSize(1, dimensionPixelSize5);
                this.I3 = obtainStyledAttributes2.getDimensionPixelSize(2, dimensionPixelSize5);
                this.L3 = obtainStyledAttributes2.getDimensionPixelSize(3, dimensionPixelSize5);
                this.J3 = obtainStyledAttributes2.getDimensionPixelSize(4, dimensionPixelSize5);
                obtainStyledAttributes2.recycle();
                if (Build.VERSION.SDK_INT >= 16) {
                    setBackground(null);
                } else {
                    setBackgroundDrawable(null);
                }
                if (this.Q3) {
                    TransformationMethod transformationMethod = getTransformationMethod();
                    setSingleLine();
                    setTransformationMethod(transformationMethod);
                }
                R();
                T();
                W();
                V();
                U();
                X();
                Q();
                Y();
                y();
                S();
                P();
                return;
            }
            throw new RuntimeException("SDK_INT less than LOLLIPOP");
        }
    }

    private void P() {
        p();
        if (this.P3 > 0 || this.O3 > 0) {
            this.i5 = true;
        }
    }

    private void Q() {
        addTextChangedListener(new c());
        d dVar = new d();
        this.G4 = dVar;
        super.setOnFocusChangeListener(dVar);
    }

    private void R() {
        if (e0()) {
            setGravity(5);
        }
    }

    private void S() {
        this.N4 = new b();
    }

    private void T() {
        int i = 0;
        boolean z = this.O3 > 0 || this.P3 > 0 || this.Q3 || this.a4 != null || this.Y3 != null || this.k5 != null;
        int i2 = this.V3;
        if (i2 > 0) {
            i = i2;
        } else if (z) {
            i = 1;
        }
        this.U3 = i;
        this.W3 = i;
    }

    private void U() {
        this.f12330c = this.p2 ? this.x + this.p0 : this.p0;
        this.B4.setTextSize(this.z);
        Paint.FontMetrics fontMetrics = this.B4.getFontMetrics();
        int i = ((int) ((fontMetrics.descent - fontMetrics.ascent) * this.W3)) + (this.h4 ? this.p1 : this.p1 * 2);
        this.f12331d = i;
        Bitmap bitmap = this.O4;
        if (bitmap != null) {
            this.f12331d = i + (bitmap.getHeight() / 3);
        }
        int i2 = 0;
        this.f12332f = this.n4 == null ? 0 : this.u4;
        if (this.o4 != null) {
            i2 = this.u4;
        }
        this.q = i2;
        C();
    }

    private void V() {
        x();
    }

    private void W() {
        this.S4 = 0;
        if (!TextUtils.isEmpty(this.R4)) {
            int measureText = (int) getPaint().measureText(this.R4.toString());
            this.S4 = measureText;
            int i = this.T4;
            if (measureText > i) {
                this.S4 = i;
            }
            int i2 = this.S4;
            int i3 = this.U4;
            if (i2 < i3) {
                this.S4 = i3;
                return;
            }
            return;
        }
        this.S4 = 0;
    }

    private void X() {
        if (!TextUtils.isEmpty(getText())) {
            g0();
            Selection.setSelection(getText(), getText().length());
            this.b4 = 1.0f;
            this.c4 = true;
            this.L4 = getHint();
            this.M4 = getHint();
            setHint("");
        } else {
            g0();
            this.L4 = getHint();
            this.M4 = getHint();
        }
        h0();
    }

    private void Y() {
        addTextChangedListener(new a());
    }

    private boolean Z(MotionEvent motionEvent) {
        int i;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int scrollX = getScrollX() + (this.n4 == null ? 0 : this.u4);
        int scrollX2 = getScrollX() + (this.o4 == null ? getWidth() : getWidth() - this.u4);
        int s = s();
        int width = this.p4[0].getWidth() + this.c5 + this.d5;
        int u = u();
        if (e0()) {
            i = ((scrollX + u) + this.S4) - getScrollX();
        } else {
            i = ((scrollX2 - s) - this.S4) - getScrollX();
        }
        int t = t() - M(3);
        return x >= ((float) i) && x < ((float) (i + width)) && y >= ((float) t) && y < ((float) ((t + this.p4[0].getHeight()) + M(3)));
    }

    private boolean a0(MotionEvent motionEvent) {
        int i;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int scrollX = getScrollX() + (this.n4 == null ? 0 : this.u4);
        int scrollX2 = getScrollX() + (this.o4 == null ? getWidth() : getWidth() - this.u4);
        int u = u();
        int width = this.Z4[0].getWidth() + this.e5 + this.f5;
        if (e0()) {
            i = (scrollX + this.S4) - getScrollX();
        } else {
            i = ((scrollX2 - u) - this.S4) - getScrollX();
        }
        int v = v() - M(3);
        return x >= ((float) i) && x < ((float) (i + width)) && y >= ((float) v) && y < ((float) ((v + this.p4[0].getHeight()) + M(3)));
    }

    private boolean c0() {
        return this.a4 == null && this.k5 == null && b0();
    }

    @TargetApi(17)
    private boolean e0() {
        return Build.VERSION.SDK_INT >= 17 && getResources().getConfiguration().getLayoutDirection() == 1;
    }

    private void g0() {
        ColorStateList colorStateList = this.y4;
        if (colorStateList == null) {
            setHintTextColor((this.H3 & 16777215) | 1140850688);
        } else {
            setHintTextColor(colorStateList);
        }
    }

    private int getBottomEllipsisWidth() {
        if (this.Q3) {
            return (this.T3 * 5) + M(4);
        }
        return 0;
    }

    private int getBottomTextLeftOffset() {
        return e0() ? getCharactersCounterWidth() : getBottomEllipsisWidth();
    }

    private int getBottomTextRightOffset() {
        return e0() ? getBottomEllipsisWidth() : getCharactersCounterWidth();
    }

    private int getButtonsCount() {
        return f0() ? 1 : 0;
    }

    private String getCharactersCounterText() {
        int i;
        StringBuilder sb;
        StringBuilder sb2;
        int i2;
        StringBuilder sb3;
        if (this.O3 <= 0) {
            if (e0()) {
                sb3 = new StringBuilder();
                sb3.append(this.P3);
                sb3.append(" / ");
                i2 = z(getText());
            } else {
                sb3 = new StringBuilder();
                sb3.append(z(getText()));
                sb3.append(" / ");
                i2 = this.P3;
            }
            sb3.append(i2);
            return sb3.toString();
        } else if (this.P3 <= 0) {
            if (e0()) {
                sb2 = new StringBuilder();
                sb2.append(MqttTopic.SINGLE_LEVEL_WILDCARD);
                sb2.append(this.O3);
                sb2.append(" / ");
                sb2.append(z(getText()));
            } else {
                sb2 = new StringBuilder();
                sb2.append(z(getText()));
                sb2.append(" / ");
                sb2.append(this.O3);
                sb2.append(MqttTopic.SINGLE_LEVEL_WILDCARD);
            }
            return sb2.toString();
        } else {
            if (e0()) {
                sb = new StringBuilder();
                sb.append(this.P3);
                sb.append("-");
                sb.append(this.O3);
                sb.append(" / ");
                i = z(getText());
            } else {
                sb = new StringBuilder();
                sb.append(z(getText()));
                sb.append(" / ");
                sb.append(this.O3);
                sb.append("-");
                i = this.P3;
            }
            sb.append(i);
            return sb.toString();
        }
    }

    private int getCharactersCounterWidth() {
        if (N()) {
            return (int) this.B4.measureText(getCharactersCounterText());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator getLabelAnimator() {
        if (this.D4 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "floatingLabelFraction", 0.0f, 1.0f);
            this.D4 = ofFloat;
            Animator.AnimatorListener animatorListener = this.N4;
            if (animatorListener != null) {
                ofFloat.addListener(animatorListener);
            }
        }
        this.D4.setDuration(this.l4 ? 300L : 0L);
        return this.D4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator getLabelFocusAnimator() {
        if (this.E4 == null) {
            this.E4 = ObjectAnimator.ofFloat(this, "focusFraction", 0.0f, 1.0f);
        }
        return this.E4;
    }

    private void h0() {
        ColorStateList colorStateList = this.x4;
        if (colorStateList == null) {
            int[][] iArr = {new int[]{16842910}, EditText.EMPTY_STATE_SET};
            int i = this.H3;
            ColorStateList colorStateList2 = new ColorStateList(iArr, new int[]{(i & 16777215) | (-553648128), (i & 16777215) | 1140850688});
            this.x4 = colorStateList2;
            setTextColor(colorStateList2);
            return;
        }
        setTextColor(colorStateList);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean p() {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText.p():boolean");
    }

    private boolean q() {
        if (TextUtils.isEmpty(this.R4)) {
            return false;
        }
        this.B4.setTextSize(this.W4);
        this.B4.setColor(this.V4);
        if (TextUtils.isEmpty(this.R4)) {
            return true;
        }
        this.X4 = new StaticLayout(this.R4, this.B4, this.S4, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        return true;
    }

    private float r() {
        this.B4.setTextSize(this.z);
        Paint.FontMetrics fontMetrics = this.B4.getFontMetrics();
        float f2 = fontMetrics.ascent;
        return this.z + f2 + fontMetrics.descent;
    }

    private int s() {
        int width = this.p4[0].getWidth() + this.c5 + this.d5;
        return this.Y4 ? width + this.Z4[0].getWidth() + this.e5 + this.f5 : width;
    }

    private void setFloatingLabelInternal(int i) {
        if (i == 1) {
            this.p2 = true;
            this.p3 = false;
        } else if (i != 2) {
            this.p2 = false;
            this.p3 = false;
        } else {
            this.p2 = true;
            this.p3 = true;
        }
        this.L4 = getHint();
    }

    private int t() {
        int scrollY = getScrollY() + getPaddingTop();
        int w = w();
        return scrollY + ((getLineCount() - 1) * w) + ((w - this.p4[0].getHeight()) / 2);
    }

    private int u() {
        if (!this.Y4) {
            return 0;
        }
        return this.f5 + this.Z4[0].getWidth() + this.e5;
    }

    private int v() {
        int scrollY = getScrollY() + getPaddingTop();
        int w = w();
        return scrollY + ((getLineCount() - 1) * w) + ((w - this.Z4[0].getHeight()) / 2);
    }

    private int w() {
        return ((getHeight() - getPaddingTop()) - getPaddingBottom()) / (getLineCount() > 0 ? getLineCount() : 1);
    }

    private void x() {
        if (this.Y4) {
            Typeface typeface = getTypeface();
            if (!this.b5) {
                setInputType(129);
                setTypeface(typeface);
            } else {
                setInputType(1);
            }
            Selection.setSelection(getText(), getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        int i;
        boolean z = true;
        if ((this.s4 || this.m4) && N()) {
            Editable text = getText();
            int z2 = text == null ? 0 : z(text);
            if (z2 < this.O3 || ((i = this.P3) > 0 && z2 > i)) {
                z = false;
            }
            this.k4 = z;
            return;
        }
        this.k4 = true;
    }

    private int z(CharSequence charSequence) {
        if (this.J4 == null) {
            return charSequence.length();
        }
        throw null;
    }

    public void B() {
        this.k5 = null;
        postInvalidate();
    }

    public boolean b0() {
        return this.k4;
    }

    public boolean d0() {
        return this.Y4;
    }

    public boolean f0() {
        return this.r4;
    }

    @Nullable
    public Typeface getAccentTypeface() {
        return this.e4;
    }

    public int getBottomTextSize() {
        return this.z;
    }

    public float getCurrentBottomLines() {
        return this.W3;
    }

    public int getDisableUnderlineStyle() {
        return this.l5;
    }

    @Override // android.widget.TextView
    public CharSequence getError() {
        return this.a4;
    }

    public int getErrorColor() {
        return this.N3;
    }

    public float getFloatingLabelFraction() {
        return this.b4;
    }

    public int getFloatingLabelPadding() {
        return this.p0;
    }

    public CharSequence getFloatingLabelText() {
        return this.g4;
    }

    public int getFloatingLabelTextColor() {
        return this.y;
    }

    public int getFloatingLabelTextSize() {
        return this.x;
    }

    public float getFocusFraction() {
        return this.d4;
    }

    public String getHelperText() {
        return this.Y3;
    }

    public int getHelperTextColor() {
        return this.Z3;
    }

    public int getInnerPaddingBottom() {
        return this.J3;
    }

    public int getInnerPaddingLeft() {
        return this.K3;
    }

    public int getInnerPaddingRight() {
        return this.L3;
    }

    public int getInnerPaddingTop() {
        return this.I3;
    }

    public int getMaxCharacters() {
        return this.P3;
    }

    public int getMinBottomTextLines() {
        return this.V3;
    }

    public int getMinCharacters() {
        return this.O3;
    }

    public CharSequence getPostfixText() {
        return this.R4;
    }

    public int getUnderlineColor() {
        return this.i4;
    }

    @Nullable
    public List<com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b> getValidators() {
        return this.I4;
    }

    public boolean i0() {
        List<com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b> list = this.I4;
        if (list == null || list.isEmpty()) {
            return true;
        }
        Editable text = getText();
        boolean z = text.length() == 0;
        Iterator<com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b> it = this.I4.iterator();
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b next = it.next();
            if (!z2 || !next.b(text, z)) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (!z2) {
                setError(next.a());
                break;
            }
        }
        if (z2) {
            setError(null);
        }
        postInvalidate();
        return z2;
    }

    public MaterialEditText o(com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b bVar) {
        if (this.I4 == null) {
            this.I4 = new ArrayList();
        }
        this.I4.add(bVar);
        return this;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.s4) {
            this.s4 = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    @RequiresApi(api = 17)
    protected void onDraw(@NonNull Canvas canvas) {
        int i;
        int i2;
        int textSize;
        int i3;
        int i4;
        int i5;
        int i6;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        char c2 = 0;
        int scrollX = getScrollX() + (this.n4 == null ? 0 : this.u4) + getPaddingStart();
        int scrollX2 = (getScrollX() + (this.o4 == null ? getWidth() : getWidth() - this.u4)) - this.S4;
        int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
        int scrollY2 = getScrollY() + getPaddingTop();
        this.A4.setAlpha(255);
        Bitmap[] bitmapArr = this.n4;
        int i7 = 1;
        if (bitmapArr != null) {
            canvas.drawBitmap(bitmapArr[!c0() ? (char) 3 : !isEnabled() ? (char) 2 : hasFocus() ? (char) 1 : (char) 0], (scrollX - this.u4) - bitmap3.getWidth(), (this.p1 + scrollY) - bitmap3.getHeight(), this.A4);
        }
        Bitmap[] bitmapArr2 = this.o4;
        if (bitmapArr2 != null) {
            canvas.drawBitmap(bitmapArr2[!c0() ? (char) 3 : !isEnabled() ? (char) 2 : hasFocus() ? (char) 1 : (char) 0], (this.u4 + scrollX2) - bitmap2.getWidth(), (this.p1 + scrollY) - bitmap2.getHeight(), this.A4);
        }
        int s = s();
        int u = u();
        if (hasFocus() && this.r4 && !TextUtils.isEmpty(getText()) && isEnabled()) {
            this.A4.setAlpha(255);
            canvas.drawBitmap(this.p4[!c0() ? (char) 3 : !isEnabled() ? (char) 2 : hasFocus() ? (char) 1 : (char) 0], e0() ? this.S4 + u + scrollX : (-s) + scrollX2, t(), this.A4);
        }
        if (this.Y4 && !TextUtils.isEmpty(getText()) && isEnabled()) {
            int i8 = e0() ? this.S4 + scrollX : (-u) + scrollX2;
            if (this.b5) {
                Bitmap[] bitmapArr3 = this.a5;
                if (!c0()) {
                    c2 = 3;
                } else if (!isEnabled()) {
                    c2 = 2;
                } else if (hasFocus()) {
                    c2 = 1;
                }
                bitmap = bitmapArr3[c2];
            } else {
                Bitmap[] bitmapArr4 = this.Z4;
                if (!c0()) {
                    c2 = 3;
                } else if (!isEnabled()) {
                    c2 = 2;
                } else if (hasFocus()) {
                    c2 = 1;
                }
                bitmap = bitmapArr4[c2];
            }
            canvas.drawBitmap(bitmap, i8, v(), this.A4);
        }
        if (!this.h4) {
            int i9 = scrollY + this.p1;
            if (e0()) {
                int i10 = this.S4;
                i5 = scrollX + i10;
                i6 = i10 + scrollX2;
            } else {
                i5 = scrollX;
                i6 = scrollX2;
            }
            if (!c0()) {
                this.A4.setColor(this.N3);
                scrollY = i9;
                i = -1;
                canvas.drawRect(i5, i9, i6, M(2) + i9, this.A4);
            } else {
                scrollY = i9;
                i = -1;
                if (!isEnabled()) {
                    Paint paint = this.A4;
                    int i11 = this.i4;
                    if (i11 == -1) {
                        i11 = (this.H3 & 16777215) | 1140850688;
                    }
                    paint.setColor(i11);
                    if (this.l5 == 1) {
                        float M = M(1);
                        float f2 = 0.0f;
                        while (f2 < getWidth()) {
                            float f3 = i5 + f2;
                            canvas.drawRect(f3, scrollY, f3 + M, M(1) + scrollY, this.A4);
                            f2 += M * 3.0f;
                            i5 = i5;
                            M = M;
                        }
                    } else {
                        canvas.drawRect(i5, scrollY + (M(1) / 2), i6, ((M(1) * 3) / 2) + scrollY, this.A4);
                    }
                } else if (hasFocus()) {
                    this.A4.setColor(this.M3);
                    canvas.drawRect(i5, scrollY, i6, M(2) + scrollY, this.A4);
                } else {
                    Paint paint2 = this.A4;
                    int i12 = this.i4;
                    if (i12 == -1) {
                        i12 = this.H3;
                    }
                    paint2.setColor(i12);
                    canvas.drawRect(i5, scrollY + (M(1) / 2), i6, ((M(1) * 3) / 2) + scrollY, this.A4);
                }
            }
        } else {
            i = -1;
        }
        if (this.X4 != null && !TextUtils.isEmpty(this.R4)) {
            int lineCount = scrollY2 + ((getLineCount() - 1) * w());
            this.B4.setColor(this.V4);
            this.B4.setTextSize(this.W4);
            canvas.save();
            if (e0()) {
                canvas.translate(scrollX, lineCount);
            } else {
                canvas.translate(scrollX2, lineCount);
            }
            this.X4.draw(canvas);
            canvas.restore();
        }
        float r = r();
        if (((hasFocus() && N()) || !b0()) && this.a4 == null) {
            this.B4.setTextSize(this.z);
            this.B4.setColor(b0() ? this.H3 : this.N3);
            String charactersCounterText = getCharactersCounterText();
            StaticLayout D = D(charactersCounterText);
            if (D != null) {
                canvas.save();
                if (e0()) {
                    canvas.translate(this.S4 + scrollX, (this.p1 + scrollY) - r);
                } else {
                    canvas.translate(scrollX2 - this.B4.measureText(charactersCounterText), (this.p1 + scrollY) - r);
                }
                D.draw(canvas);
                canvas.restore();
            }
        }
        if (this.C4 != null && (this.a4 != null || ((this.S3 || hasFocus()) && !TextUtils.isEmpty(this.Y3)))) {
            TextPaint textPaint = this.B4;
            if (this.a4 != null) {
                i4 = this.N3;
            } else {
                i4 = this.Z3;
                if (i4 == i) {
                    i4 = (this.H3 & 16777215) | 1140850688;
                }
            }
            textPaint.setColor(i4);
            this.B4.setTextSize(this.z);
            canvas.save();
            if (e0()) {
                canvas.translate((scrollX2 - this.C4.getWidth()) + this.S4, (this.p1 + scrollY) - r);
            } else {
                canvas.translate(getBottomTextLeftOffset() + scrollX, (this.p1 + scrollY) - r);
            }
            this.C4.draw(canvas);
            canvas.restore();
            if (this.O4 != null && !TextUtils.isEmpty(this.a4)) {
                Bitmap bitmap4 = this.O4;
                int width = ((scrollX2 - bitmap4.getWidth()) + this.S4) - M(1);
                int M2 = M(1) + scrollX;
                int height = this.p1 + scrollY + ((this.C4.getHeight() - this.O4.getHeight()) / 2);
                this.A4.setFlags(1);
                if (e0()) {
                    canvas.drawBitmap(bitmap4, M2, height, this.A4);
                } else {
                    canvas.drawBitmap(bitmap4, width, height, this.A4);
                }
            }
        }
        if (this.p2 && !TextUtils.isEmpty(this.g4)) {
            this.B4.setTextSize(this.x);
            TextPaint textPaint2 = this.B4;
            ArgbEvaluator argbEvaluator = this.z4;
            float f4 = this.d4 * (isEnabled() ? 1.0f : 0.0f);
            int i13 = this.y;
            if (i13 == i) {
                i13 = (this.H3 & 16777215) | 1140850688;
            }
            textPaint2.setColor(((Integer) argbEvaluator.evaluate(f4, Integer.valueOf(i13), Integer.valueOf(this.M3))).intValue());
            if (!(this.a4 == null && b0() && this.k5 == null)) {
                TextPaint textPaint3 = this.B4;
                ArgbEvaluator argbEvaluator2 = this.z4;
                float f5 = this.d4 * (isEnabled() ? 1.0f : 0.0f);
                int i14 = this.N3;
                if (i14 == i) {
                    i14 = (this.H3 & 16777215) | 1140850688;
                }
                Integer valueOf = Integer.valueOf(i14);
                int i15 = this.N3;
                if (i15 == i) {
                    i15 = this.M3;
                }
                textPaint3.setColor(((Integer) argbEvaluator2.evaluate(f5, valueOf, Integer.valueOf(i15))).intValue());
            }
            float measureText = this.B4.measureText(this.g4.toString());
            if ((getGravity() & 5) == 5 || e0()) {
                i2 = (int) (scrollX2 - measureText);
            } else {
                i2 = (getGravity() & 3) == 3 ? scrollX : ((int) (getInnerPaddingLeft() + ((((getWidth() - getInnerPaddingLeft()) - getInnerPaddingRight()) - measureText) / 2.0f))) + scrollX;
            }
            if (e0()) {
                i2 += this.S4;
            }
            float f6 = 1.0f;
            int textSize2 = (int) (((this.R3 ? 1.0f : this.b4) * ((this.I3 + this.x) - textSize)) + this.I3 + this.x + this.p0 + ((int) getTextSize()) + getScrollY());
            this.B4.setAlpha((int) ((this.R3 ? 1.0f : this.b4) * 255.0f * (this.y != i ? 1.0f : Color.alpha(i3) / 255.0f)));
            if (!this.R3) {
                f6 = this.b4;
            }
            this.B4.setTextSize(((this.x - getTextSize()) * f6) + getTextSize());
            canvas.drawText(this.g4.toString(), i2, textSize2, this.B4);
        }
        if (hasFocus() && this.Q3 && getScrollX() != 0) {
            this.A4.setColor(c0() ? this.M3 : this.N3);
            float f7 = scrollY + this.p1;
            if (e0()) {
                scrollX = scrollX2;
            }
            if (e0()) {
                i7 = -1;
            }
            int i16 = this.T3;
            canvas.drawCircle(((i7 * i16) / 2) + scrollX, (i16 / 2) + f7, i16 / 2, this.A4);
            int i17 = this.T3;
            canvas.drawCircle((((i7 * i17) * 5) / 2) + scrollX, (i17 / 2) + f7, i17 / 2, this.A4);
            int i18 = this.T3;
            canvas.drawCircle(scrollX + (((i7 * i18) * 9) / 2), f7 + (i18 / 2), i18 / 2, this.A4);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            p();
            q();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.Q3 || getScrollX() <= 0 || motionEvent.getAction() != 0 || motionEvent.getX() >= M(20) || motionEvent.getY() <= (getHeight() - this.f12331d) - this.J3 || motionEvent.getY() >= getHeight() - this.J3) {
            if (hasFocus() && this.r4 && isEnabled()) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        if (this.w4) {
                            if (!TextUtils.isEmpty(getText())) {
                                setText((CharSequence) null);
                            }
                            this.w4 = false;
                        }
                        if (this.v4) {
                            this.v4 = false;
                            return true;
                        }
                        this.v4 = false;
                    } else if (action == 2) {
                        if (this.w4 && !Z(motionEvent)) {
                            this.w4 = false;
                        }
                        if (this.v4) {
                            return true;
                        }
                    } else if (action == 3) {
                        this.v4 = false;
                        this.w4 = false;
                    }
                } else if (Z(motionEvent)) {
                    this.v4 = true;
                    this.w4 = true;
                    return true;
                }
            }
            if (this.Y4 && isEnabled()) {
                int action2 = motionEvent.getAction();
                if (action2 != 0) {
                    if (action2 == 1) {
                        if (this.h5) {
                            boolean z = !this.b5;
                            this.b5 = z;
                            e eVar = this.n5;
                            if (eVar != null) {
                                eVar.a(z);
                            }
                            x();
                            this.h5 = false;
                            postInvalidate();
                        }
                        if (this.g5) {
                            this.g5 = false;
                            return true;
                        }
                        this.g5 = false;
                    } else if (action2 != 2) {
                        if (action2 == 3) {
                            this.g5 = false;
                            this.h5 = false;
                        }
                    }
                } else if (a0(motionEvent)) {
                    this.g5 = true;
                    this.h5 = true;
                    return true;
                }
                if (this.h5 && !a0(motionEvent)) {
                    this.h5 = false;
                }
                if (this.g5) {
                    return true;
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        setSelection(0);
        return false;
    }

    public void setAccentTypeface(Typeface typeface) {
        this.e4 = typeface;
        this.B4.setTypeface(typeface);
        postInvalidate();
    }

    public void setAutoValidate(boolean z) {
        this.j4 = z;
        if (z) {
            i0();
        }
    }

    public void setBaseColor(int i) {
        if (this.H3 != i) {
            this.H3 = i;
        }
        X();
        postInvalidate();
    }

    public void setBottomTextSize(int i) {
        this.z = i;
        U();
    }

    public void setCurrentBottomLines(float f2) {
        this.W3 = f2;
        U();
    }

    public void setDisableUnderlineStyle(int i) {
        this.l5 = i;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setError(CharSequence charSequence) {
        this.a4 = charSequence == null ? null : charSequence.toString();
        if (p()) {
            U();
            postInvalidate();
        }
    }

    public void setErrorColor(int i) {
        this.N3 = i;
        postInvalidate();
    }

    public void setFloatingLabel(int i) {
        setFloatingLabelInternal(i);
        U();
    }

    public void setFloatingLabelAlwaysShown(boolean z) {
        this.R3 = z;
        invalidate();
    }

    public void setFloatingLabelAnimating(boolean z) {
        this.l4 = z;
    }

    public void setFloatingLabelFraction(float f2) {
        this.b4 = f2;
        invalidate();
    }

    public void setFloatingLabelPadding(int i) {
        this.p0 = i;
        postInvalidate();
    }

    public void setFloatingLabelText(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = getHint();
        }
        this.g4 = charSequence;
        postInvalidate();
    }

    public void setFloatingLabelTextColor(int i) {
        this.y = i;
        postInvalidate();
    }

    public void setFloatingLabelTextSize(int i) {
        this.x = i;
        U();
    }

    public void setFocusFraction(float f2) {
        this.d4 = f2;
        invalidate();
    }

    public void setHelperText(CharSequence charSequence) {
        this.Y3 = charSequence == null ? null : charSequence.toString();
        if (p()) {
            U();
            postInvalidate();
        }
    }

    public void setHelperTextAlwaysShown(boolean z) {
        this.S3 = z;
        invalidate();
    }

    public void setHelperTextColor(int i) {
        this.Z3 = i;
        postInvalidate();
    }

    public void setHideUnderline(boolean z) {
        this.h4 = z;
        U();
        postInvalidate();
    }

    public void setIconLeft(@DrawableRes int i) {
        this.n4 = F(i);
        U();
    }

    public void setIconRight(@DrawableRes int i) {
        this.o4 = F(i);
        U();
    }

    public void setLengthChecker(com.tplink.libtpcontrols.materialnormalcompat.edittext.c.a aVar) {
    }

    public void setMaxCharacters(int i) {
        this.P3 = i;
        y();
        T();
        U();
        postInvalidate();
    }

    public void setMetHintTextColor(int i) {
        this.y4 = ColorStateList.valueOf(i);
        g0();
    }

    public void setMetTextColor(int i) {
        this.x4 = ColorStateList.valueOf(i);
        h0();
    }

    public void setMinBottomTextLines(int i) {
        this.V3 = i;
        T();
        U();
        postInvalidate();
    }

    public void setMinCharacters(int i) {
        this.O3 = i;
        y();
        T();
        U();
        postInvalidate();
    }

    public void setOnEyeballVisibleChangedListener(e eVar) {
        this.n5 = eVar;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        if (this.G4 == null) {
            super.setOnFocusChangeListener(onFocusChangeListener);
        } else {
            this.H4 = onFocusChangeListener;
        }
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(16)
    @Deprecated
    public final void setPadding(int i, int i2, int i3, int i4) {
        if (e0()) {
            super.setPadding(i, i2, i3, i4);
        } else {
            super.setPaddingRelative(i, i2, i3, i4);
        }
    }

    public void setPaddingBottom(int i) {
        this.J3 = i;
        C();
    }

    public void setPaddingLeft(int i) {
        this.K3 = i;
        C();
    }

    public void setPaddingRight(int i) {
        this.L3 = i;
        C();
    }

    public void setPaddingTop(int i) {
        this.I3 = i;
        C();
    }

    public void setPasswordMode(boolean z) {
        this.Y4 = z;
        C();
        p();
        postInvalidate();
    }

    public void setPostfixText(CharSequence charSequence) {
        this.R4 = charSequence;
        W();
        C();
        p();
        q();
        postInvalidate();
    }

    public void setPrimaryColor(int i) {
        this.M3 = i;
        postInvalidate();
    }

    public void setShowClearButton(boolean z) {
        this.r4 = z;
        C();
        p();
    }

    public void setSingleLineEllipsis(boolean z) {
        this.Q3 = z;
        T();
        U();
        postInvalidate();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    public void setTextNormal(CharSequence charSequence) {
        setText(charSequence);
        if (!TextUtils.isEmpty(charSequence)) {
            Selection.setSelection(getText(), charSequence.length());
        }
    }

    public void setUnderlineColor(int i) {
        this.i4 = i;
        postInvalidate();
    }

    public void setValidateOnFocusLost(boolean z) {
        this.q4 = z;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return super.getText();
    }

    public void setIconLeft(Drawable drawable) {
        this.n4 = H(drawable);
        U();
    }

    public void setIconRight(Drawable drawable) {
        this.o4 = H(drawable);
        U();
    }

    public void setMetHintTextColor(ColorStateList colorStateList) {
        this.y4 = colorStateList;
        g0();
    }

    public void setMetTextColor(ColorStateList colorStateList) {
        this.x4 = colorStateList;
        h0();
    }

    public void setIconLeft(Bitmap bitmap) {
        this.n4 = G(bitmap);
        U();
    }

    public void setIconRight(Bitmap bitmap) {
        this.o4 = G(bitmap);
        U();
    }

    public MaterialEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O(context, attributeSet);
    }

    @TargetApi(21)
    public MaterialEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O(context, attributeSet);
    }
}
