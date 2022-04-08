package b.d.w.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import b.d.w.f.b;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: TPSharePreferences.java */
@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes3.dex */
public class a {
    private SharedPreferences a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f832b;

    public a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.a = sharedPreferences;
        this.f832b = sharedPreferences.edit();
    }

    public boolean a(String str) {
        return this.a.contains(str);
    }

    public Map<String, ?> b() {
        return this.a.getAll();
    }

    public boolean c(String str, boolean z) {
        return this.a.getBoolean(str, z);
    }

    public int d(String str, int i) {
        return this.a.getInt(str, i);
    }

    public long e(String str, long j) {
        return this.a.getLong(str, j);
    }

    public String f(String str, String str2) {
        return this.a.getString(str, str2);
    }

    @SuppressLint({"NewApi"})
    public Set<String> g(String str) {
        if (b.g()) {
            try {
                HashSet hashSet = (HashSet) this.a.getStringSet(str, null);
                if (hashSet != null) {
                    return new HashSet(hashSet);
                }
            } catch (ClassCastException e2) {
                b.d.w.c.a.d(e2.toString());
            }
        } else {
            String string = this.a.getString(str, null);
            if (string != null) {
                HashSet hashSet2 = new HashSet();
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        hashSet2.add(jSONArray.getString(i));
                    }
                    return hashSet2;
                } catch (JSONException e3) {
                    b.d.w.c.a.d(e3.toString());
                }
            }
        }
        return null;
    }

    public void h(String str, boolean z) {
        this.f832b.putBoolean(str, z);
        this.f832b.commit();
    }

    public void i(String str, int i) {
        this.f832b.putInt(str, i);
        this.f832b.commit();
    }

    public void j(String str, long j) {
        this.f832b.putLong(str, j);
        this.f832b.commit();
    }

    public void k(String str, String str2) {
        this.f832b.putString(str, str2);
        this.f832b.commit();
    }

    public void l(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f832b.putString(entry.getKey(), entry.getValue());
        }
        this.f832b.commit();
    }

    @SuppressLint({"NewApi"})
    public void m(String str, Set<String> set) {
        if (set != null && set.size() != 0) {
            if (b.g()) {
                this.f832b.putStringSet(str, set);
                this.f832b.commit();
                return;
            }
            this.f832b.putString(str, new JSONArray((Collection) set).toString());
            this.f832b.commit();
        }
    }

    public void n(List<String> list) {
        for (String str : list) {
            this.f832b.remove(str);
        }
        this.f832b.commit();
    }
}
