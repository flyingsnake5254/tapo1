package com.google.gson;

import com.google.gson.internal.i;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.google.gson.stream.a;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* compiled from: JsonParser.java */
/* loaded from: classes2.dex */
public final class l {
    public static i b(a aVar) throws JsonIOException, JsonSyntaxException {
        boolean t = aVar.t();
        t = true;
        try {
            try {
                return i.a(aVar);
            } catch (OutOfMemoryError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e2);
            } catch (StackOverflowError e3) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e3);
            }
        } finally {
            aVar.L(t);
        }
    }

    public static i c(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            a aVar = new a(reader);
            i b2 = b(aVar);
            if (!b2.g() && aVar.G() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return b2;
        } catch (MalformedJsonException e2) {
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException(e4);
        }
    }

    public static i d(String str) throws JsonSyntaxException {
        return c(new StringReader(str));
    }

    @Deprecated
    public i a(String str) throws JsonSyntaxException {
        return d(str);
    }
}
