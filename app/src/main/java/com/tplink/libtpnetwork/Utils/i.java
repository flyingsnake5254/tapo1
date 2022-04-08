package com.tplink.libtpnetwork.Utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.d;
import com.google.gson.l;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: GsonUtils.java */
/* loaded from: classes3.dex */
public class i {
    private static Gson a = new d().c().b();

    public static <T> T a(com.google.gson.i iVar, Type type) {
        return (T) a.h(iVar, type);
    }

    public static <T> T b(String str, Type type) {
        return (T) a.m(str, type);
    }

    @Nullable
    public static <T> T c(com.google.gson.i iVar, Type type) {
        try {
            return (T) a.h(iVar, type);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static <T> T d(String str, Type type) {
        try {
            return (T) a.m(str, type);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> e(String str, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            Iterator<com.google.gson.i> it = new l().a(str).b().iterator();
            while (it.hasNext()) {
                arrayList.add(a.g(it.next(), cls));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public static String f(Object obj) {
        return a.u(obj);
    }

    public static String g(Object obj, Type type) {
        return a.v(obj, type);
    }

    public static String h(Object obj) {
        try {
            return a.u(obj);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static com.google.gson.i i(Object obj) {
        return a.A(obj);
    }

    public static String j(Object obj) {
        return new d().c().f().b().u(obj);
    }
}
