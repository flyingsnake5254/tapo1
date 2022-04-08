package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.sequences.f;

/* compiled from: Menu.kt */
/* loaded from: classes.dex */
public final class MenuKt {
    public static final boolean contains(Menu contains, MenuItem item) {
        j.f(contains, "$this$contains");
        j.f(item, "item");
        int size = contains.size();
        for (int i = 0; i < size; i++) {
            if (j.a(contains.getItem(i), item)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(Menu forEach, l<? super MenuItem, p> action) {
        j.f(forEach, "$this$forEach");
        j.f(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = forEach.getItem(i);
            j.b(item, "getItem(index)");
            action.invoke(item);
        }
    }

    public static final void forEachIndexed(Menu forEachIndexed, kotlin.jvm.b.p<? super Integer, ? super MenuItem, p> action) {
        j.f(forEachIndexed, "$this$forEachIndexed");
        j.f(action, "action");
        int size = forEachIndexed.size();
        for (int i = 0; i < size; i++) {
            Integer valueOf = Integer.valueOf(i);
            MenuItem item = forEachIndexed.getItem(i);
            j.b(item, "getItem(index)");
            action.invoke(valueOf, item);
        }
    }

    public static final MenuItem get(Menu get, int i) {
        j.f(get, "$this$get");
        MenuItem item = get.getItem(i);
        j.b(item, "getItem(index)");
        return item;
    }

    public static final f<MenuItem> getChildren(final Menu children) {
        j.f(children, "$this$children");
        return new f<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // kotlin.sequences.f
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(children);
            }
        };
    }

    public static final int getSize(Menu size) {
        j.f(size, "$this$size");
        return size.size();
    }

    public static final boolean isEmpty(Menu isEmpty) {
        j.f(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final boolean isNotEmpty(Menu isNotEmpty) {
        j.f(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    public static final Iterator<MenuItem> iterator(Menu iterator) {
        j.f(iterator, "$this$iterator");
        return new MenuKt$iterator$1(iterator);
    }

    public static final void minusAssign(Menu minusAssign, MenuItem item) {
        j.f(minusAssign, "$this$minusAssign");
        j.f(item, "item");
        minusAssign.removeItem(item.getItemId());
    }
}
