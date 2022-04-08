package io.reactivex.internal.util;

import io.reactivex.g0.c;
import java.util.List;

/* loaded from: classes4.dex */
public enum ListAddBiConsumer implements c<List, Object, List> {
    INSTANCE;

    public static <T> c<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    public List apply(List list, Object obj) throws Exception {
        list.add(obj);
        return list;
    }
}
