package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.l;
import com.airbnb.lottie.v.d;

/* loaded from: classes.dex */
public class MergePaths implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final MergePathsMode f961b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f962c;

    /* loaded from: classes.dex */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i == 4) {
                return INTERSECT;
            }
            if (i != 5) {
                return MERGE;
            }
            return EXCLUDE_INTERSECTIONS;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.a = str;
        this.f961b = mergePathsMode;
        this.f962c = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public c a(f fVar, a aVar) {
        if (fVar.k()) {
            return new l(this);
        }
        d.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public MergePathsMode b() {
        return this.f961b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.f962c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f961b + '}';
    }
}
