package kotlin.jvm;

import com.tplink.libtpnetwork.cameranetwork.bean.listing.ColumnFilter;
import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.c;

/* compiled from: JvmClassMapping.kt */
/* loaded from: classes4.dex */
public final class a {
    public static final <T> Class<T> a(c<T> java) {
        j.e(java, "$this$java");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.c) java).a();
        Objects.requireNonNull(cls, "null cannot be cast to non-null type java.lang.Class<T>");
        return cls;
    }

    public static final <T> Class<T> b(c<T> javaObjectType) {
        j.e(javaObjectType, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.c) javaObjectType).a();
        if (!cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return name.equals(ColumnFilter.TYPE_DOUBLE) ? Double.class : cls;
            case 104431:
                return name.equals("int") ? Integer.class : cls;
            case 3039496:
                return name.equals("byte") ? Byte.class : cls;
            case 3052374:
                return name.equals("char") ? Character.class : cls;
            case 3327612:
                return name.equals(ColumnFilter.TYPE_LONG) ? Long.class : cls;
            case 3625364:
                return name.equals("void") ? Void.class : cls;
            case 64711720:
                return name.equals(ColumnFilter.TYPE_BOOLEAN) ? Boolean.class : cls;
            case 97526364:
                return name.equals(ColumnFilter.TYPE_FLOAT) ? Float.class : cls;
            case 109413500:
                return name.equals("short") ? Short.class : cls;
            default:
                return cls;
        }
    }

    public static final <T> c<T> c(Class<T> kotlin2) {
        j.e(kotlin2, "$this$kotlin");
        return m.b(kotlin2);
    }
}
