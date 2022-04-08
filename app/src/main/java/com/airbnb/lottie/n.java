package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.v.f;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker.java */
/* loaded from: classes.dex */
public class n {
    private boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<b> f1041b = new ArraySet();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, f> f1042c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<Pair<String, Float>> f1043d = new a();

    /* compiled from: PerformanceTracker.java */
    /* loaded from: classes.dex */
    class a implements Comparator<Pair<String, Float>> {
        a() {
        }

        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.second.floatValue();
            float floatValue2 = pair2.second.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    /* compiled from: PerformanceTracker.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(float f2);
    }

    public void a(String str, float f2) {
        if (this.a) {
            f fVar = this.f1042c.get(str);
            if (fVar == null) {
                fVar = new f();
                this.f1042c.put(str, fVar);
            }
            fVar.a(f2);
            if (str.equals("__container")) {
                for (b bVar : this.f1041b) {
                    bVar.a(f2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        this.a = z;
    }
}
