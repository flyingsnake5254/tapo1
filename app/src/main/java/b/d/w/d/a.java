package b.d.w.d;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* compiled from: TPSerializeUtils.java */
/* loaded from: classes3.dex */
public class a {
    private static volatile String a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile com.tplink.libtputility.security.a f828b;

    /* renamed from: c  reason: collision with root package name */
    private static Gson f829c = new Gson();

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, ReadWriteLock> f830d = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TPSerializeUtils.java */
    /* loaded from: classes3.dex */
    public static class b implements ParameterizedType {

        /* renamed from: c  reason: collision with root package name */
        private final Type[] f831c;

        b(Type[] typeArr) {
            this.f831c = typeArr;
        }

        @Override // java.lang.reflect.ParameterizedType
        @NonNull
        public Type[] getActualTypeArguments() {
            return this.f831c;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        @NonNull
        public Type getRawType() {
            return List.class;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TPSerializeUtils.java */
    /* loaded from: classes3.dex */
    public static class c implements FileFilter {
        private c() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (!file.isDirectory()) {
                return false;
            }
            String[] split = file.getName().split("_");
            return split.length > 0 && b.d.w.h.b.c(split[0]);
        }
    }

    private a() {
    }

    public static Object a(String str, String str2, String str3) {
        return i(d(str, str2), str3);
    }

    public static <T> T b(String str, String str2, String str3, Class<T> cls) {
        Object a2 = a(str, str2, str3);
        if (!(a2 instanceof String)) {
            return null;
        }
        try {
            return (T) f829c.l((String) a2, cls);
        } catch (JsonSyntaxException e2) {
            b.d.w.c.a.d(e2.toString());
            return null;
        }
    }

    public static <T> List<T> c(String str, String str2, String str3, Class<T> cls) {
        Object a2 = a(str, str2, str3);
        if (a2 instanceof String) {
            try {
                return (List) f829c.m((String) a2, new b(new Class[]{cls}));
            } catch (JsonSyntaxException e2) {
                b.d.w.c.a.d(e2.toString());
            }
        }
        return new ArrayList();
    }

    private static String d(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        String str3 = File.separator;
        sb.append(str3);
        sb.append(b.d.w.h.a.g(str));
        sb.append(str3);
        sb.append(str2);
        return sb.toString();
    }

    @RequiresPermission("android.permission.ACCESS_WIFI_STATE")
    @Deprecated
    public static void e(Context context) {
        String str;
        if (a == null) {
            synchronized (a.class) {
                String absolutePath = context.getCacheDir().getAbsolutePath();
                a = absolutePath + File.separator + "model_cache";
                File file = new File(a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.tplink.libtputility.security.b c2 = com.tplink.libtputility.security.b.c();
                if (c2.f("deco_model_file_key")) {
                    JSONObject f2 = f();
                    String str2 = null;
                    if (f2 != null) {
                        str2 = c2.a(f2.optString("DECO_TPSERIALIZEUTILS_AES_KEY", ""), "deco_model_file_key");
                        str = c2.a(f2.optString("DECO_TPSERIALIZEUTILS_AES_VECTOR", ""), "deco_model_file_key");
                    } else {
                        str = null;
                    }
                    if (b.d.w.h.b.d(str2) || b.d.w.h.b.d(str)) {
                        b.d.w.b.b.c(file);
                        f828b = new com.tplink.libtputility.security.a();
                        j(c2.b(f828b.h(), "deco_model_file_key"), c2.b(f828b.g(), "deco_model_file_key"));
                    } else {
                        f828b = new com.tplink.libtputility.security.a(str2, str);
                    }
                } else {
                    c2.e(context, "deco_model_file_key");
                    h(context, absolutePath);
                    f828b = new com.tplink.libtputility.security.a();
                    j(c2.b(f828b.h(), "deco_model_file_key"), c2.b(f828b.g(), "deco_model_file_key"));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0080 A[Catch: IOException -> 0x007c, TRY_LEAVE, TryCatch #9 {IOException -> 0x007c, blocks: (B:28:0x0078, B:32:0x0080), top: B:49:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileReader] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileReader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.FileReader, java.io.Reader] */
    /* JADX WARN: Unknown variable types count: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONObject f() {
        /*
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = b.d.w.d.a.a
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r3 = "deco_model"
            r1.append(r3)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: all -> 0x0065, JSONException -> 0x006a, IOException -> 0x006c
            r2.<init>(r0)     // Catch: all -> 0x0065, JSONException -> 0x006a, IOException -> 0x006c
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: all -> 0x005b, JSONException -> 0x0060, IOException -> 0x0062
            r0.<init>(r2)     // Catch: all -> 0x005b, JSONException -> 0x0060, IOException -> 0x0062
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: JSONException -> 0x0057, IOException -> 0x0059, all -> 0x008c
            r3.<init>()     // Catch: JSONException -> 0x0057, IOException -> 0x0059, all -> 0x008c
        L_0x0033:
            java.lang.String r4 = r0.readLine()     // Catch: JSONException -> 0x0057, IOException -> 0x0059, all -> 0x008c
            if (r4 == 0) goto L_0x003d
            r3.append(r4)     // Catch: JSONException -> 0x0057, IOException -> 0x0059, all -> 0x008c
            goto L_0x0033
        L_0x003d:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: JSONException -> 0x0057, IOException -> 0x0059, all -> 0x008c
            java.lang.String r3 = r3.toString()     // Catch: JSONException -> 0x0057, IOException -> 0x0059, all -> 0x008c
            r4.<init>(r3)     // Catch: JSONException -> 0x0057, IOException -> 0x0059, all -> 0x008c
            r0.close()     // Catch: IOException -> 0x004d
            r2.close()     // Catch: IOException -> 0x004d
            goto L_0x0055
        L_0x004d:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            b.d.w.c.a.d(r0)
        L_0x0055:
            r1 = r4
            goto L_0x008b
        L_0x0057:
            r3 = move-exception
            goto L_0x006f
        L_0x0059:
            r3 = move-exception
            goto L_0x006f
        L_0x005b:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x008d
        L_0x0060:
            r3 = move-exception
            goto L_0x0063
        L_0x0062:
            r3 = move-exception
        L_0x0063:
            r0 = r1
            goto L_0x006f
        L_0x0065:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x008d
        L_0x006a:
            r3 = move-exception
            goto L_0x006d
        L_0x006c:
            r3 = move-exception
        L_0x006d:
            r0 = r1
            r2 = r0
        L_0x006f:
            java.lang.String r3 = r3.toString()     // Catch: all -> 0x008c
            b.d.w.c.a.d(r3)     // Catch: all -> 0x008c
            if (r0 == 0) goto L_0x007e
            r0.close()     // Catch: IOException -> 0x007c
            goto L_0x007e
        L_0x007c:
            r0 = move-exception
            goto L_0x0084
        L_0x007e:
            if (r2 == 0) goto L_0x008b
            r2.close()     // Catch: IOException -> 0x007c
            goto L_0x008b
        L_0x0084:
            java.lang.String r0 = r0.toString()
            b.d.w.c.a.d(r0)
        L_0x008b:
            return r1
        L_0x008c:
            r1 = move-exception
        L_0x008d:
            if (r0 == 0) goto L_0x0095
            r0.close()     // Catch: IOException -> 0x0093
            goto L_0x0095
        L_0x0093:
            r0 = move-exception
            goto L_0x009b
        L_0x0095:
            if (r2 == 0) goto L_0x00a2
            r2.close()     // Catch: IOException -> 0x0093
            goto L_0x00a2
        L_0x009b:
            java.lang.String r0 = r0.toString()
            b.d.w.c.a.d(r0)
        L_0x00a2:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.w.d.a.f():org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00eb -> B:78:0x00f2). Please submit an issue!!! */
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_WIFI_STATE")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(android.content.Context r5, java.io.File r6, java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.w.d.a.g(android.content.Context, java.io.File, java.lang.String, java.lang.String):void");
    }

    @RequiresPermission("android.permission.ACCESS_WIFI_STATE")
    private static void h(Context context, String str) {
        File[] listFiles = new File(str).listFiles(new c());
        if (listFiles != null) {
            for (File file : listFiles) {
                StringBuilder sb = new StringBuilder();
                sb.append("com");
                String str2 = File.separator;
                sb.append(str2);
                sb.append("tplink");
                sb.append(str2);
                sb.append("model");
                sb.append(str2);
                sb.append("MessageV2Model");
                String sb2 = sb.toString();
                File file2 = new File(file.getAbsolutePath() + str2 + sb2);
                if (file2.isDirectory()) {
                    File[] listFiles2 = file2.listFiles();
                    if (listFiles2 != null) {
                        for (File file3 : listFiles2) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(a);
                            String str3 = File.separator;
                            sb3.append(str3);
                            sb3.append(b.d.w.h.a.g(file.getName()));
                            sb3.append(str3);
                            sb3.append(sb2);
                            g(context, file3, sb3.toString(), file3.getName());
                        }
                    }
                }
                b.d.w.b.b.c(file);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object i(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.w.d.a.i(java.lang.String, java.lang.String):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a A[Catch: IOException -> 0x007e, TRY_ENTER, TryCatch #8 {IOException -> 0x007e, blocks: (B:9:0x004f, B:24:0x007a, B:28:0x0082), top: B:42:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0082 A[Catch: IOException -> 0x007e, TRY_LEAVE, TryCatch #8 {IOException -> 0x007e, blocks: (B:9:0x004f, B:24:0x007a, B:28:0x0082), top: B:42:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.FileWriter, java.io.Writer] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.FileWriter] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.FileWriter] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(java.lang.String r5, java.lang.String r6) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = b.d.w.d.a.a
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r2 = "deco_model"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0026
            r0.mkdirs()
        L_0x0026:
            java.io.File r1 = new java.io.File
            r1.<init>(r0, r2)
            r0 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: all -> 0x0066, JSONException -> 0x006b, IOException -> 0x006d
            r2.<init>()     // Catch: all -> 0x0066, JSONException -> 0x006b, IOException -> 0x006d
            java.lang.String r3 = "DECO_TPSERIALIZEUTILS_AES_KEY"
            r2.put(r3, r5)     // Catch: all -> 0x0066, JSONException -> 0x006b, IOException -> 0x006d
            java.lang.String r5 = "DECO_TPSERIALIZEUTILS_AES_VECTOR"
            r2.put(r5, r6)     // Catch: all -> 0x0066, JSONException -> 0x006b, IOException -> 0x006d
            java.io.FileWriter r5 = new java.io.FileWriter     // Catch: all -> 0x0066, JSONException -> 0x006b, IOException -> 0x006d
            r5.<init>(r1)     // Catch: all -> 0x0066, JSONException -> 0x006b, IOException -> 0x006d
            java.io.BufferedWriter r6 = new java.io.BufferedWriter     // Catch: all -> 0x005a, JSONException -> 0x005f, IOException -> 0x0061
            r6.<init>(r5)     // Catch: all -> 0x005a, JSONException -> 0x005f, IOException -> 0x0061
            java.lang.String r0 = r2.toString()     // Catch: JSONException -> 0x0056, IOException -> 0x0058, all -> 0x008e
            r6.write(r0)     // Catch: JSONException -> 0x0056, IOException -> 0x0058, all -> 0x008e
            r6.flush()     // Catch: JSONException -> 0x0056, IOException -> 0x0058, all -> 0x008e
            r6.close()     // Catch: IOException -> 0x007e
            r5.close()     // Catch: IOException -> 0x007e
            goto L_0x008d
        L_0x0056:
            r0 = move-exception
            goto L_0x0071
        L_0x0058:
            r0 = move-exception
            goto L_0x0071
        L_0x005a:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x008f
        L_0x005f:
            r6 = move-exception
            goto L_0x0062
        L_0x0061:
            r6 = move-exception
        L_0x0062:
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x0071
        L_0x0066:
            r5 = move-exception
            r6 = r0
            r0 = r5
            r5 = r6
            goto L_0x008f
        L_0x006b:
            r5 = move-exception
            goto L_0x006e
        L_0x006d:
            r5 = move-exception
        L_0x006e:
            r6 = r0
            r0 = r5
            r5 = r6
        L_0x0071:
            java.lang.String r0 = r0.toString()     // Catch: all -> 0x008e
            b.d.w.c.a.d(r0)     // Catch: all -> 0x008e
            if (r6 == 0) goto L_0x0080
            r6.close()     // Catch: IOException -> 0x007e
            goto L_0x0080
        L_0x007e:
            r5 = move-exception
            goto L_0x0086
        L_0x0080:
            if (r5 == 0) goto L_0x008d
            r5.close()     // Catch: IOException -> 0x007e
            goto L_0x008d
        L_0x0086:
            java.lang.String r5 = r5.toString()
            b.d.w.c.a.d(r5)
        L_0x008d:
            return
        L_0x008e:
            r0 = move-exception
        L_0x008f:
            if (r6 == 0) goto L_0x0097
            r6.close()     // Catch: IOException -> 0x0095
            goto L_0x0097
        L_0x0095:
            r5 = move-exception
            goto L_0x009d
        L_0x0097:
            if (r5 == 0) goto L_0x00a4
            r5.close()     // Catch: IOException -> 0x0095
            goto L_0x00a4
        L_0x009d:
            java.lang.String r5 = r5.toString()
            b.d.w.c.a.d(r5)
        L_0x00a4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.w.d.a.j(java.lang.String, java.lang.String):void");
    }

    public static void k(String str, Object obj, String str2, String str3) {
        m(obj, d(str, str2), str3);
    }

    public static void l(String str, Object obj, String str2, String str3) {
        k(str, f829c.u(obj), str2, str3);
    }

    private static void m(Object obj, String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable th;
        IOException e2;
        Exception e3;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        if (obj != null && !b.d.w.h.b.d(str) && !b.d.w.h.b.d(str2)) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str3 = str + File.separator + str2;
            Map<String, ReadWriteLock> map = f830d;
            ReadWriteLock readWriteLock = map.get(str);
            if (readWriteLock == null) {
                synchronized (map) {
                    readWriteLock = new ReentrantReadWriteLock();
                    map.put(str, readWriteLock);
                }
            }
            readWriteLock.writeLock().lock();
            ObjectOutputStream objectOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(new File(str3));
                try {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    } catch (Exception e4) {
                        e3 = e4;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e5) {
                e3 = e5;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                objectOutputStream.close();
                fileOutputStream.write(f828b.d(byteArrayOutputStream.toByteArray()));
                fileOutputStream.flush();
                fileOutputStream.close();
                try {
                    objectOutputStream.close();
                } catch (IOException e6) {
                    b.d.w.c.a.d(e6.toString());
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e7) {
                    e2 = e7;
                    b.d.w.c.a.d(e2.toString());
                    readWriteLock.writeLock().unlock();
                }
            } catch (Exception e8) {
                e3 = e8;
                objectOutputStream2 = objectOutputStream;
                b.d.w.c.a.d(e3.toString());
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e9) {
                        b.d.w.c.a.d(e9.toString());
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e10) {
                        e2 = e10;
                        b.d.w.c.a.d(e2.toString());
                        readWriteLock.writeLock().unlock();
                    }
                }
                readWriteLock.writeLock().unlock();
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e11) {
                        b.d.w.c.a.d(e11.toString());
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e12) {
                        b.d.w.c.a.d(e12.toString());
                    }
                }
                readWriteLock.writeLock().unlock();
                throw th;
            }
            readWriteLock.writeLock().unlock();
        }
    }
}
