package com.google.android.datatransport.h.z;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* compiled from: PriorityMapping.java */
/* loaded from: classes.dex */
public final class a {
    private static SparseArray<Priority> a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<Priority, Integer> f1944b;

    static {
        HashMap<Priority, Integer> hashMap = new HashMap<>();
        f1944b = hashMap;
        hashMap.put(Priority.DEFAULT, 0);
        f1944b.put(Priority.VERY_LOW, 1);
        f1944b.put(Priority.HIGHEST, 2);
        for (Priority priority : f1944b.keySet()) {
            a.append(f1944b.get(priority).intValue(), priority);
        }
    }

    public static int a(@NonNull Priority priority) {
        Integer num = f1944b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    @NonNull
    public static Priority b(int i) {
        Priority priority = a.get(i);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i);
    }
}
