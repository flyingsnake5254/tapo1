package skin.support.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import f.a.e;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import skin.support.widget.SkinCompatAutoCompleteTextView;
import skin.support.widget.SkinCompatButton;
import skin.support.widget.SkinCompatCheckBox;
import skin.support.widget.SkinCompatCheckedTextView;
import skin.support.widget.SkinCompatEditText;
import skin.support.widget.SkinCompatFrameLayout;
import skin.support.widget.SkinCompatImageButton;
import skin.support.widget.SkinCompatImageView;
import skin.support.widget.SkinCompatLinearLayout;
import skin.support.widget.SkinCompatMultiAutoCompleteTextView;
import skin.support.widget.SkinCompatProgressBar;
import skin.support.widget.SkinCompatRadioButton;
import skin.support.widget.SkinCompatRadioGroup;
import skin.support.widget.SkinCompatRatingBar;
import skin.support.widget.SkinCompatRelativeLayout;
import skin.support.widget.SkinCompatScrollView;
import skin.support.widget.SkinCompatSeekBar;
import skin.support.widget.SkinCompatSpinner;
import skin.support.widget.SkinCompatTextView;
import skin.support.widget.SkinCompatToolbar;
import skin.support.widget.SkinCompatView;

/* compiled from: SkinCompatViewInflater.java */
/* loaded from: classes4.dex */
public class a {
    private static final Class<?>[] a = {Context.class, AttributeSet.class};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f17685b = {16843375};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f17686c = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, Constructor<? extends View>> f17687d = new ArrayMap();

    /* renamed from: e  reason: collision with root package name */
    private final Object[] f17688e = new Object[2];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SkinCompatViewInflater.java */
    /* renamed from: skin.support.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class View$OnClickListenerC0351a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        private final View f17689c;

        /* renamed from: d  reason: collision with root package name */
        private final String f17690d;

        /* renamed from: f  reason: collision with root package name */
        private Method f17691f;
        private Context q;

        public View$OnClickListenerC0351a(@NonNull View view, @NonNull String str) {
            this.f17689c = view;
            this.f17690d = str;
        }

        @NonNull
        private void a(@Nullable Context context, @NonNull String str) {
            int id;
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f17690d, View.class)) != null) {
                        this.f17691f = method;
                        this.q = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            if (this.f17689c.getId() == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f17689c.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f17690d + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f17689c.getClass() + str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NonNull View view) {
            if (this.f17691f == null) {
                a(this.f17689c.getContext(), this.f17690d);
            }
            try {
                this.f17691f.invoke(this.q, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 15 || ViewCompat.hasOnClickListeners(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f17685b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new View$OnClickListenerC0351a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View b(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        Map<String, Constructor<? extends View>> map = f17687d;
        Constructor<? extends View> constructor = map.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).asSubclass(View.class).getConstructor(a);
                map.put(str, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f17688e);
    }

    private View d(Context context, String str, AttributeSet attributeSet) {
        if (str.contains(".")) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1495589242:
                if (str.equals("ProgressBar")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = 3;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 4;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = 6;
                    break;
                }
                break;
            case -443652810:
                if (str.equals("RelativeLayout")) {
                    c2 = 7;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 2666181:
                if (str.equals("View")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1127291599:
                if (str.equals("LinearLayout")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1310765783:
                if (str.equals("FrameLayout")) {
                    c2 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = 14;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 15;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = 16;
                    break;
                }
                break;
            case 1969230692:
                if (str.equals("RadioGroup")) {
                    c2 = 17;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = 18;
                    break;
                }
                break;
            case 2059813682:
                if (str.equals("ScrollView")) {
                    c2 = 19;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new SkinCompatRatingBar(context, attributeSet);
            case 1:
                return new SkinCompatProgressBar(context, attributeSet);
            case 2:
                return new SkinCompatCheckedTextView(context, attributeSet);
            case 3:
                return new SkinCompatMultiAutoCompleteTextView(context, attributeSet);
            case 4:
                return new SkinCompatTextView(context, attributeSet);
            case 5:
                return new SkinCompatImageButton(context, attributeSet);
            case 6:
                return new SkinCompatSeekBar(context, attributeSet);
            case 7:
                return new SkinCompatRelativeLayout(context, attributeSet);
            case '\b':
                return new SkinCompatSpinner(context, attributeSet);
            case '\t':
                return new SkinCompatView(context, attributeSet);
            case '\n':
                return new SkinCompatRadioButton(context, attributeSet);
            case 11:
                return new SkinCompatImageView(context, attributeSet);
            case '\f':
                return new SkinCompatLinearLayout(context, attributeSet);
            case '\r':
                return new SkinCompatFrameLayout(context, attributeSet);
            case 14:
                return new SkinCompatAutoCompleteTextView(context, attributeSet);
            case 15:
                return new SkinCompatCheckBox(context, attributeSet);
            case 16:
                return new SkinCompatEditText(context, attributeSet);
            case 17:
                return new SkinCompatRadioGroup(context, attributeSet);
            case 18:
                return new SkinCompatButton(context, attributeSet);
            case 19:
                return new SkinCompatScrollView(context, attributeSet);
            default:
                return null;
        }
    }

    private View e(Context context, String str, AttributeSet attributeSet) {
        e.a();
        throw null;
    }

    private View f(Context context, String str, AttributeSet attributeSet) {
        e.a();
        throw null;
    }

    private View h(Context context, String str, AttributeSet attributeSet) {
        if (((str.hashCode() == -254446176 && str.equals("androidx.appcompat.widget.Toolbar")) ? (char) 0 : (char) 65535) != 0) {
            return null;
        }
        return new SkinCompatToolbar(context, attributeSet);
    }

    private static Context i(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(R.styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.View_theme, 0)) != 0) {
            Log.i("SkinCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? (!(context instanceof ContextThemeWrapper) || ((ContextThemeWrapper) context).getThemeResId() != resourceId) ? new ContextThemeWrapper(context, resourceId) : context : context;
    }

    public final View c(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        if (z && view != null) {
            context = view.getContext();
        }
        if (z2 || z3) {
            context = i(context, attributeSet, z2, z3);
        }
        if (z4) {
            context = TintContextWrapper.wrap(context);
        }
        View e2 = e(context, str, attributeSet);
        if (e2 == null) {
            e2 = d(context, str, attributeSet);
        }
        if (e2 == null) {
            e2 = h(context, str, attributeSet);
        }
        if (e2 == null) {
            e2 = f(context, str, attributeSet);
        }
        if (e2 == null) {
            e2 = g(context, str, attributeSet);
        }
        if (e2 != null) {
            a(e2, attributeSet);
        }
        return e2;
    }

    public View g(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f17688e;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return b(context, str, null);
            }
            int i = 0;
            while (true) {
                String[] strArr = f17686c;
                if (i >= strArr.length) {
                    return null;
                }
                View b2 = b(context, str, strArr[i]);
                if (b2 != null) {
                    return b2;
                }
                i++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f17688e;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }
}
