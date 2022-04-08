package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;

/* compiled from: SQLiteDatabase.kt */
/* loaded from: classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase transaction, boolean z, l<? super SQLiteDatabase, ? extends T> body) {
        j.f(transaction, "$this$transaction");
        j.f(body, "body");
        if (z) {
            transaction.beginTransaction();
        } else {
            transaction.beginTransactionNonExclusive();
        }
        try {
            T t = (T) body.invoke(transaction);
            transaction.setTransactionSuccessful();
            return t;
        } finally {
            i.b(1);
            transaction.endTransaction();
            i.a(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase transaction, boolean z, l body, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        j.f(transaction, "$this$transaction");
        j.f(body, "body");
        if (z) {
            transaction.beginTransaction();
        } else {
            transaction.beginTransactionNonExclusive();
        }
        try {
            Object invoke = body.invoke(transaction);
            transaction.setTransactionSuccessful();
            return invoke;
        } finally {
            i.b(1);
            transaction.endTransaction();
            i.a(1);
        }
    }
}
