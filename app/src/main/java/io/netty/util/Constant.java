package io.netty.util;

import io.netty.util.Constant;

/* loaded from: classes3.dex */
public interface Constant<T extends Constant<T>> extends Comparable<T> {
    int id();

    String name();
}
