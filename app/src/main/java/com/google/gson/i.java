package com.google.gson;

import com.google.gson.stream.b;
import java.io.IOException;
import java.io.StringWriter;

/* compiled from: JsonElement.java */
/* loaded from: classes2.dex */
public abstract class i {
    public int a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public f b() {
        if (f()) {
            return (f) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public k c() {
        if (h()) {
            return (k) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public m d() {
        if (i()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean f() {
        return this instanceof f;
    }

    public boolean g() {
        return this instanceof j;
    }

    public boolean h() {
        return this instanceof k;
    }

    public boolean i() {
        return this instanceof m;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            b bVar = new b(stringWriter);
            bVar.D(true);
            com.google.gson.internal.i.b(this, bVar);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
