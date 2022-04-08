package androidx.navigation;

import androidx.navigation.NavArgument;
import kotlin.jvm.internal.j;

/* compiled from: NavDestinationBuilder.kt */
@NavDestinationDsl
/* loaded from: classes.dex */
public final class NavArgumentBuilder {
    private NavType<?> _type;
    private final NavArgument.Builder builder = new NavArgument.Builder();
    private Object defaultValue;
    private boolean nullable;

    public final NavArgument build() {
        NavArgument build = this.builder.build();
        j.b(build, "builder.build()");
        return build;
    }

    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    public final boolean getNullable() {
        return this.nullable;
    }

    public final NavType<?> getType() {
        NavType<?> navType = this._type;
        if (navType != null) {
            return navType;
        }
        throw new IllegalStateException("NavType has not been set on this builder.");
    }

    public final void setDefaultValue(Object obj) {
        this.defaultValue = obj;
        this.builder.setDefaultValue(obj);
    }

    public final void setNullable(boolean z) {
        this.nullable = z;
        this.builder.setIsNullable(z);
    }

    public final void setType(NavType<?> value) {
        j.f(value, "value");
        this._type = value;
        this.builder.setType(value);
    }
}
