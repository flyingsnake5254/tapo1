package com.google.android.gms.internal.measurement;

import com.github.mikephil.charting.utils.Utils;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
public final class zzlk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzli zzliVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zzliVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zzb(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zzb(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzmf.zza(zzjd.zzk((String) obj)));
                sb.append(StringUtil.DOUBLE_QUOTE);
            } else if (obj instanceof zzjd) {
                sb.append(": \"");
                sb.append(zzmf.zza((zzjd) obj));
                sb.append(StringUtil.DOUBLE_QUOTE);
            } else if (obj instanceof zzkd) {
                sb.append(" {");
                zzc((zzkd) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i4 = i + 2;
                zzb(sb, i4, "key", entry2.getKey());
                zzb(sb, i4, "value", entry2.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static void zzc(zzli zzliVar, StringBuilder sb, int i) {
        Method[] declaredMethods;
        boolean equals;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzliVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String substring = str.startsWith("get") ? str.substring(3) : str;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String valueOf = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(substring.substring(1, substring.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzd(concat), zzkd.zzbA(method2, zzliVar, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String valueOf3 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(substring.substring(1, substring.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzd(concat2), zzkd.zzbA(method3, zzliVar, new Object[0]));
                }
            }
            if (((Method) hashMap2.get(substring.length() != 0 ? "set".concat(substring) : new String("set"))) != null) {
                if (substring.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(substring.substring(0, substring.length() - 5));
                    if (!hashMap.containsKey(valueOf5.length() != 0 ? "get".concat(valueOf5) : new String("get"))) {
                    }
                }
                String valueOf6 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(substring.substring(1));
                String concat3 = valueOf7.length() != 0 ? valueOf6.concat(valueOf7) : new String(valueOf6);
                Method method4 = (Method) hashMap.get(substring.length() != 0 ? "get".concat(substring) : new String("get"));
                Method method5 = (Method) hashMap.get(substring.length() != 0 ? "has".concat(substring) : new String("has"));
                if (method4 != null) {
                    Object zzbA = zzkd.zzbA(method4, zzliVar, new Object[0]);
                    if (method5 == null) {
                        if (zzbA instanceof Boolean) {
                            if (((Boolean) zzbA).booleanValue()) {
                                zzb(sb, i, zzd(concat3), zzbA);
                            }
                        } else if (zzbA instanceof Integer) {
                            if (((Integer) zzbA).intValue() != 0) {
                                zzb(sb, i, zzd(concat3), zzbA);
                            }
                        } else if (zzbA instanceof Float) {
                            if (((Float) zzbA).floatValue() != 0.0f) {
                                zzb(sb, i, zzd(concat3), zzbA);
                            }
                        } else if (!(zzbA instanceof Double)) {
                            if (zzbA instanceof String) {
                                equals = zzbA.equals("");
                            } else if (zzbA instanceof zzjd) {
                                equals = zzbA.equals(zzjd.zzb);
                            } else if (!(zzbA instanceof zzli)) {
                                if ((zzbA instanceof Enum) && ((Enum) zzbA).ordinal() == 0) {
                                }
                                zzb(sb, i, zzd(concat3), zzbA);
                            } else if (zzbA != ((zzli) zzbA).zzbL()) {
                                zzb(sb, i, zzd(concat3), zzbA);
                            }
                            if (!equals) {
                                zzb(sb, i, zzd(concat3), zzbA);
                            }
                        } else if (((Double) zzbA).doubleValue() != Utils.DOUBLE_EPSILON) {
                            zzb(sb, i, zzd(concat3), zzbA);
                        }
                    } else if (((Boolean) zzkd.zzbA(method5, zzliVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, zzd(concat3), zzbA);
                    }
                }
            }
        }
        if (!(zzliVar instanceof zzka)) {
            zzmi zzmiVar = ((zzkd) zzliVar).zzc;
            if (zzmiVar != null) {
                zzmiVar.zzg(sb, i);
                return;
            }
            return;
        }
        zzka zzkaVar = (zzka) zzliVar;
        throw null;
    }

    private static final String zzd(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
