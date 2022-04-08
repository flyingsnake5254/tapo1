package org.apache.commons.lang.enums;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang.d;
import org.apache.commons.lang.e;

/* loaded from: classes4.dex */
public abstract class Enum implements Comparable, Serializable {
    private static final Map EMPTY_MAP = Collections.unmodifiableMap(new HashMap(0));
    private static Map cEnumClasses = new WeakHashMap();
    static /* synthetic */ Class class$org$apache$commons$lang$enums$Enum = null;
    static /* synthetic */ Class class$org$apache$commons$lang$enums$ValuedEnum = null;
    private static final long serialVersionUID = -487045951170455942L;
    private final transient int iHashCode;
    private final String iName;
    protected transient String iToString = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        final Map a;

        /* renamed from: b  reason: collision with root package name */
        final Map f16641b;

        /* renamed from: c  reason: collision with root package name */
        final List f16642c;

        /* renamed from: d  reason: collision with root package name */
        final List f16643d;

        protected a() {
            HashMap hashMap = new HashMap();
            this.a = hashMap;
            this.f16641b = Collections.unmodifiableMap(hashMap);
            ArrayList arrayList = new ArrayList(25);
            this.f16642c = arrayList;
            this.f16643d = Collections.unmodifiableList(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Enum(String str) {
        init(str);
        this.iName = str;
        this.iHashCode = getEnumClass().hashCode() + 7 + (str.hashCode() * 3);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private static a createEntry(Class cls) {
        a aVar = new a();
        Class superclass = cls.getSuperclass();
        while (true) {
            if (superclass == null) {
                break;
            }
            Class cls2 = class$org$apache$commons$lang$enums$Enum;
            if (cls2 == null) {
                cls2 = class$("org.apache.commons.lang.enums.Enum");
                class$org$apache$commons$lang$enums$Enum = cls2;
            }
            if (superclass == cls2) {
                break;
            }
            Class cls3 = class$org$apache$commons$lang$enums$ValuedEnum;
            if (cls3 == null) {
                cls3 = class$("org.apache.commons.lang.enums.ValuedEnum");
                class$org$apache$commons$lang$enums$ValuedEnum = cls3;
            }
            if (superclass == cls3) {
                break;
            }
            a aVar2 = (a) cEnumClasses.get(superclass);
            if (aVar2 != null) {
                aVar.f16642c.addAll(aVar2.f16642c);
                aVar.a.putAll(aVar2.a);
                break;
            }
            superclass = superclass.getSuperclass();
        }
        return aVar;
    }

    private static a getEntry(Class cls) {
        if (cls != null) {
            Class cls2 = class$org$apache$commons$lang$enums$Enum;
            if (cls2 == null) {
                cls2 = class$("org.apache.commons.lang.enums.Enum");
                class$org$apache$commons$lang$enums$Enum = cls2;
            }
            if (cls2.isAssignableFrom(cls)) {
                a aVar = (a) cEnumClasses.get(cls);
                if (aVar != null) {
                    return aVar;
                }
                try {
                    Class.forName(cls.getName(), true, cls.getClassLoader());
                    return (a) cEnumClasses.get(cls);
                } catch (Exception unused) {
                    return aVar;
                }
            } else {
                throw new IllegalArgumentException("The Class must be a subclass of Enum");
            }
        } else {
            throw new IllegalArgumentException("The Enum Class must not be null");
        }
    }

    protected static Enum getEnum(Class cls, String str) {
        a entry = getEntry(cls);
        if (entry == null) {
            return null;
        }
        return (Enum) entry.a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List getEnumList(Class cls) {
        a entry = getEntry(cls);
        if (entry == null) {
            return Collections.EMPTY_LIST;
        }
        return entry.f16643d;
    }

    protected static Map getEnumMap(Class cls) {
        a entry = getEntry(cls);
        if (entry == null) {
            return EMPTY_MAP;
        }
        return entry.f16641b;
    }

    private String getNameInOtherClassLoader(Object obj) {
        try {
            return (String) obj.getClass().getMethod("getName", null).invoke(obj, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            throw new IllegalStateException("This should not happen");
        }
    }

    private void init(String str) {
        a aVar;
        if (!e.a(str)) {
            Class<?> enumClass = getEnumClass();
            if (enumClass != null) {
                Class<?> cls = getClass();
                boolean z = false;
                while (true) {
                    if (cls == null) {
                        break;
                    }
                    Class<?> cls2 = class$org$apache$commons$lang$enums$Enum;
                    if (cls2 == null) {
                        cls2 = class$("org.apache.commons.lang.enums.Enum");
                        class$org$apache$commons$lang$enums$Enum = cls2;
                    }
                    if (cls == cls2) {
                        break;
                    }
                    Class<?> cls3 = class$org$apache$commons$lang$enums$ValuedEnum;
                    if (cls3 == null) {
                        cls3 = class$("org.apache.commons.lang.enums.ValuedEnum");
                        class$org$apache$commons$lang$enums$ValuedEnum = cls3;
                    }
                    if (cls == cls3) {
                        break;
                    } else if (cls == enumClass) {
                        z = true;
                        break;
                    } else {
                        cls = cls.getSuperclass();
                    }
                }
                if (z) {
                    Class cls4 = class$org$apache$commons$lang$enums$Enum;
                    if (cls4 == null) {
                        cls4 = class$("org.apache.commons.lang.enums.Enum");
                        class$org$apache$commons$lang$enums$Enum = cls4;
                    }
                    synchronized (cls4) {
                        aVar = (a) cEnumClasses.get(enumClass);
                        if (aVar == null) {
                            aVar = createEntry(enumClass);
                            WeakHashMap weakHashMap = new WeakHashMap();
                            weakHashMap.putAll(cEnumClasses);
                            weakHashMap.put(enumClass, aVar);
                            cEnumClasses = weakHashMap;
                        }
                    }
                    if (!aVar.a.containsKey(str)) {
                        aVar.a.put(str, this);
                        aVar.f16642c.add(this);
                        return;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("The Enum name must be unique, '");
                    stringBuffer.append(str);
                    stringBuffer.append("' has already been added");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
                throw new IllegalArgumentException("getEnumClass() must return a superclass of this class");
            }
            throw new IllegalArgumentException("getEnumClass() must not be null");
        }
        throw new IllegalArgumentException("The Enum name must not be empty or null");
    }

    protected static Iterator iterator(Class cls) {
        return getEnumList(cls).iterator();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == this) {
            return 0;
        }
        if (obj.getClass() == getClass()) {
            return this.iName.compareTo(((Enum) obj).iName);
        }
        if (obj.getClass().getName().equals(getClass().getName())) {
            return this.iName.compareTo(getNameInOtherClassLoader(obj));
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Different enum class '");
        stringBuffer.append(d.c(obj.getClass()));
        stringBuffer.append("'");
        throw new ClassCastException(stringBuffer.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == getClass()) {
            return this.iName.equals(((Enum) obj).iName);
        }
        if (!obj.getClass().getName().equals(getClass().getName())) {
            return false;
        }
        return this.iName.equals(getNameInOtherClassLoader(obj));
    }

    public Class getEnumClass() {
        return getClass();
    }

    public final String getName() {
        return this.iName;
    }

    public final int hashCode() {
        return this.iHashCode;
    }

    protected Object readResolve() {
        a aVar = (a) cEnumClasses.get(getEnumClass());
        if (aVar == null) {
            return null;
        }
        return aVar.a.get(getName());
    }

    public String toString() {
        if (this.iToString == null) {
            String c2 = d.c(getEnumClass());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(c2);
            stringBuffer.append("[");
            stringBuffer.append(getName());
            stringBuffer.append("]");
            this.iToString = stringBuffer.toString();
        }
        return this.iToString;
    }
}
