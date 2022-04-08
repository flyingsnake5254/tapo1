package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.sequences.f;

/* compiled from: ViewGroup.kt */
/* loaded from: classes.dex */
public final class ViewGroupKt {
    public static final boolean contains(ViewGroup contains, View view) {
        j.f(contains, "$this$contains");
        j.f(view, "view");
        return contains.indexOfChild(view) != -1;
    }

    public static final void forEach(ViewGroup forEach, l<? super View, p> action) {
        j.f(forEach, "$this$forEach");
        j.f(action, "action");
        int childCount = forEach.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = forEach.getChildAt(i);
            j.b(childAt, "getChildAt(index)");
            action.invoke(childAt);
        }
    }

    public static final void forEachIndexed(ViewGroup forEachIndexed, kotlin.jvm.b.p<? super Integer, ? super View, p> action) {
        j.f(forEachIndexed, "$this$forEachIndexed");
        j.f(action, "action");
        int childCount = forEachIndexed.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Integer valueOf = Integer.valueOf(i);
            View childAt = forEachIndexed.getChildAt(i);
            j.b(childAt, "getChildAt(index)");
            action.invoke(valueOf, childAt);
        }
    }

    public static final View get(ViewGroup get, int i) {
        j.f(get, "$this$get");
        View childAt = get.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + get.getChildCount());
    }

    public static final f<View> getChildren(final ViewGroup children) {
        j.f(children, "$this$children");
        return new f<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.f
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(children);
            }
        };
    }

    public static final int getSize(ViewGroup size) {
        j.f(size, "$this$size");
        return size.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup isEmpty) {
        j.f(isEmpty, "$this$isEmpty");
        return isEmpty.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup isNotEmpty) {
        j.f(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.getChildCount() != 0;
    }

    public static final Iterator<View> iterator(ViewGroup iterator) {
        j.f(iterator, "$this$iterator");
        return new ViewGroupKt$iterator$1(iterator);
    }

    public static final void minusAssign(ViewGroup minusAssign, View view) {
        j.f(minusAssign, "$this$minusAssign");
        j.f(view, "view");
        minusAssign.removeView(view);
    }

    public static final void plusAssign(ViewGroup plusAssign, View view) {
        j.f(plusAssign, "$this$plusAssign");
        j.f(view, "view");
        plusAssign.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams setMargins, @Px int i) {
        j.f(setMargins, "$this$setMargins");
        setMargins.setMargins(i, i, i, i);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams updateMargins, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        j.f(updateMargins, "$this$updateMargins");
        updateMargins.setMargins(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams updateMargins, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = updateMargins.leftMargin;
        }
        if ((i5 & 2) != 0) {
            i2 = updateMargins.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = updateMargins.rightMargin;
        }
        if ((i5 & 8) != 0) {
            i4 = updateMargins.bottomMargin;
        }
        j.f(updateMargins, "$this$updateMargins");
        updateMargins.setMargins(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams updateMarginsRelative, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        j.f(updateMarginsRelative, "$this$updateMarginsRelative");
        updateMarginsRelative.setMarginStart(i);
        updateMarginsRelative.topMargin = i2;
        updateMarginsRelative.setMarginEnd(i3);
        updateMarginsRelative.bottomMargin = i4;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams updateMarginsRelative, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = updateMarginsRelative.getMarginStart();
        }
        if ((i5 & 2) != 0) {
            i2 = updateMarginsRelative.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = updateMarginsRelative.getMarginEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = updateMarginsRelative.bottomMargin;
        }
        j.f(updateMarginsRelative, "$this$updateMarginsRelative");
        updateMarginsRelative.setMarginStart(i);
        updateMarginsRelative.topMargin = i2;
        updateMarginsRelative.setMarginEnd(i3);
        updateMarginsRelative.bottomMargin = i4;
    }
}
