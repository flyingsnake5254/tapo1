package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.jvm.internal.r.a;

/* compiled from: Menu.kt */
/* loaded from: classes.dex */
public final class MenuKt$iterator$1 implements Iterator<MenuItem>, a {
    final /* synthetic */ Menu $this_iterator;
    private int index;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuKt$iterator$1(Menu menu) {
        this.$this_iterator = menu;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_iterator.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        Menu menu = this.$this_iterator;
        int i = this.index - 1;
        this.index = i;
        menu.removeItem(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public MenuItem next() {
        Menu menu = this.$this_iterator;
        int i = this.index;
        this.index = i + 1;
        MenuItem item = menu.getItem(i);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }
}
