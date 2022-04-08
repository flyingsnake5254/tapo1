package com.bumptech.glide.load.data.o;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.z.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener.java */
/* loaded from: classes.dex */
class e {
    private static final a a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final a f1370b;

    /* renamed from: c  reason: collision with root package name */
    private final d f1371c;

    /* renamed from: d  reason: collision with root package name */
    private final b f1372d;

    /* renamed from: e  reason: collision with root package name */
    private final ContentResolver f1373e;

    /* renamed from: f  reason: collision with root package name */
    private final List<ImageHeaderParser> f1374f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(List<ImageHeaderParser> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, a, dVar, bVar, contentResolver);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0048: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x0048 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(@androidx.annotation.NonNull android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            com.bumptech.glide.load.data.o.d r2 = r6.f1371c     // Catch: all -> 0x0022, SecurityException -> 0x0024
            android.database.Cursor r2 = r2.a(r7)     // Catch: all -> 0x0022, SecurityException -> 0x0024
            if (r2 == 0) goto L_0x001c
            boolean r3 = r2.moveToFirst()     // Catch: SecurityException -> 0x001a, all -> 0x0047
            if (r3 == 0) goto L_0x001c
            r3 = 0
            java.lang.String r7 = r2.getString(r3)     // Catch: SecurityException -> 0x001a, all -> 0x0047
            r2.close()
            return r7
        L_0x001a:
            r3 = move-exception
            goto L_0x0026
        L_0x001c:
            if (r2 == 0) goto L_0x0021
            r2.close()
        L_0x0021:
            return r1
        L_0x0022:
            r7 = move-exception
            goto L_0x0049
        L_0x0024:
            r3 = move-exception
            r2 = r1
        L_0x0026:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: all -> 0x0047
            if (r4 == 0) goto L_0x0041
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: all -> 0x0047
            r4.<init>()     // Catch: all -> 0x0047
            java.lang.String r5 = "Failed to query for thumbnail for Uri: "
            r4.append(r5)     // Catch: all -> 0x0047
            r4.append(r7)     // Catch: all -> 0x0047
            java.lang.String r7 = r4.toString()     // Catch: all -> 0x0047
            android.util.Log.d(r0, r7, r3)     // Catch: all -> 0x0047
        L_0x0041:
            if (r2 == 0) goto L_0x0046
            r2.close()
        L_0x0046:
            return r1
        L_0x0047:
            r7 = move-exception
            r1 = r2
        L_0x0049:
            if (r1 == 0) goto L_0x004e
            r1.close()
        L_0x004e:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.o.e.b(android.net.Uri):java.lang.String");
    }

    private boolean c(File file) {
        return this.f1370b.a(file) && 0 < this.f1370b.c(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f1373e.openInputStream(uri);
                return com.bumptech.glide.load.b.b(this.f1374f, inputStream, this.f1372d);
            } finally {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
            }
        } catch (IOException | NullPointerException e2) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e2);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused2) {
                return -1;
            }
        }
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String b2 = b(uri);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        File b3 = this.f1370b.b(b2);
        if (!c(b3)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b3);
        try {
            return this.f1373e.openInputStream(fromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e2));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        this.f1370b = aVar;
        this.f1371c = dVar;
        this.f1372d = bVar;
        this.f1373e = contentResolver;
        this.f1374f = list;
    }
}
