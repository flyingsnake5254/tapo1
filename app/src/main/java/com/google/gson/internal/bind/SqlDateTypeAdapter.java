package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.p;
import com.google.gson.r.a;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.b;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes2.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final p a = new p() { // from class: com.google.gson.internal.bind.SqlDateTypeAdapter.1
        @Override // com.google.gson.p
        public <T> TypeAdapter<T> a(Gson gson, a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f4879b = new SimpleDateFormat("MMM d, yyyy");

    /* renamed from: a */
    public synchronized Date read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.G() == JsonToken.NULL) {
            aVar.C();
            return null;
        }
        try {
            return new Date(this.f4879b.parse(aVar.E()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    /* renamed from: b */
    public synchronized void write(b bVar, Date date) throws IOException {
        bVar.J(date == null ? null : this.f4879b.format((java.util.Date) date));
    }
}
