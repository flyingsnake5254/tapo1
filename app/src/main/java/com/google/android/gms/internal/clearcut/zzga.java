package com.google.android.gms.internal.clearcut;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class zzga {
    public static <T extends zzfz> String zza(T t) {
        if (t == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            zza(null, t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            return valueOf.length() != 0 ? "Error printing proto: ".concat(valueOf) : new String("Error printing proto: ");
        } catch (InvocationTargetException e3) {
            String valueOf2 = String.valueOf(e3.getMessage());
            return valueOf2.length() != 0 ? "Error printing proto: ".concat(valueOf2) : new String("Error printing proto: ");
        }
    }

    private static void zza(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        Field[] fields;
        if (obj == null) {
            return;
        }
        if (obj instanceof zzfz) {
            int length = stringBuffer.length();
            if (str != null) {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(zzl(str));
                stringBuffer2.append(" <\n");
                stringBuffer.append("  ");
            }
            Class<?> cls = obj.getClass();
            for (Field field : cls.getFields()) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & 8) != 8 && !name.startsWith("_") && !name.endsWith("_")) {
                    Class<?> type = field.getType();
                    Object obj2 = field.get(obj);
                    if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                        zza(name, obj2, stringBuffer, stringBuffer2);
                    } else {
                        int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                        for (int i = 0; i < length2; i++) {
                            zza(name, Array.get(obj2, i), stringBuffer, stringBuffer2);
                        }
                    }
                }
            }
            for (Method method : cls.getMethods()) {
                String name2 = method.getName();
                if (name2.startsWith("set")) {
                    String substring = name2.substring(3);
                    try {
                        String valueOf = String.valueOf(substring);
                        if (((Boolean) cls.getMethod(valueOf.length() != 0 ? "has".concat(valueOf) : new String("has"), new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                            String valueOf2 = String.valueOf(substring);
                            zza(substring, cls.getMethod(valueOf2.length() != 0 ? "get".concat(valueOf2) : new String("get"), new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                }
            }
            if (str != null) {
                stringBuffer.setLength(length);
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(">\n");
                return;
            }
            return;
        }
        String zzl = zzl(str);
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(zzl);
        stringBuffer2.append(": ");
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!str2.startsWith("http") && str2.length() > 200) {
                str2 = String.valueOf(str2.substring(0, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION)).concat("[...]");
            }
            int length3 = str2.length();
            StringBuilder sb = new StringBuilder(length3);
            for (int i2 = 0; i2 < length3; i2++) {
                char charAt = str2.charAt(i2);
                if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            stringBuffer2.append(SSLClient.DOUBLE_QUOTATION);
            stringBuffer2.append(sb2);
            stringBuffer2.append(SSLClient.DOUBLE_QUOTATION);
        } else if (obj instanceof byte[]) {
            stringBuffer2.append(StringUtil.DOUBLE_QUOTE);
            for (byte b2 : (byte[]) obj) {
                int i3 = b2 & 255;
                if (i3 == 92 || i3 == 34) {
                    stringBuffer2.append('\\');
                } else if (i3 < 32 || i3 >= 127) {
                    stringBuffer2.append(String.format("\\%03o", Integer.valueOf(i3)));
                }
                stringBuffer2.append((char) i3);
            }
            stringBuffer2.append(StringUtil.DOUBLE_QUOTE);
        } else {
            stringBuffer2.append(obj);
        }
        stringBuffer2.append("\n");
    }

    private static String zzl(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (i != 0) {
                if (Character.isUpperCase(charAt)) {
                    stringBuffer.append('_');
                }
                stringBuffer.append(charAt);
            }
            charAt = Character.toLowerCase(charAt);
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }
}