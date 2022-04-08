package com.tplink.iot.Utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: TPCollectionsSortUtils.java */
/* loaded from: classes2.dex */
public class g0 {
    public static <T> void a(List<T> list, Comparator<? super T> comparator) {
        try {
            Collections.sort(list, comparator);
        } catch (ClassCastException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (UnsupportedOperationException e4) {
            e4.printStackTrace();
        }
    }
}
