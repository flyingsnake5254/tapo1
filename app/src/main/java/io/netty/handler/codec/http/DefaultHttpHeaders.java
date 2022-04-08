package io.netty.handler.codec.http;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DateFormatter;
import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.DefaultHeadersImpl;
import io.netty.handler.codec.HeadersUtils;
import io.netty.handler.codec.ValueConverter;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultHttpHeaders extends HttpHeaders {
    private static final int HIGHEST_INVALID_VALUE_CHAR_MASK = -16;
    private final DefaultHeaders<CharSequence, CharSequence, ?> headers;
    private static final ByteProcessor HEADER_NAME_VALIDATOR = new ByteProcessor() { // from class: io.netty.handler.codec.http.DefaultHttpHeaders.1
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b2) throws Exception {
            DefaultHttpHeaders.validateHeaderNameElement(b2);
            return true;
        }
    };
    static final DefaultHeaders.NameValidator<CharSequence> HttpNameValidator = new DefaultHeaders.NameValidator<CharSequence>() { // from class: io.netty.handler.codec.http.DefaultHttpHeaders.2
        public void validateName(CharSequence charSequence) {
            if (charSequence == null || charSequence.length() == 0) {
                throw new IllegalArgumentException("empty headers are not allowed [" + ((Object) charSequence) + "]");
            } else if (charSequence instanceof AsciiString) {
                try {
                    ((AsciiString) charSequence).forEachByte(DefaultHttpHeaders.HEADER_NAME_VALIDATOR);
                } catch (Exception e2) {
                    PlatformDependent.throwException(e2);
                }
            } else {
                for (int i = 0; i < charSequence.length(); i++) {
                    DefaultHttpHeaders.validateHeaderNameElement(charSequence.charAt(i));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class HeaderValueConverter extends CharSequenceValueConverter {
        static final HeaderValueConverter INSTANCE = new HeaderValueConverter();

        private HeaderValueConverter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.handler.codec.CharSequenceValueConverter, io.netty.handler.codec.ValueConverter
        public CharSequence convertObject(Object obj) {
            if (obj instanceof CharSequence) {
                return (CharSequence) obj;
            }
            if (obj instanceof Date) {
                return DateFormatter.format((Date) obj);
            }
            if (obj instanceof Calendar) {
                return DateFormatter.format(((Calendar) obj).getTime());
            }
            return obj.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class HeaderValueConverterAndValidator extends HeaderValueConverter {
        static final HeaderValueConverterAndValidator INSTANCE = new HeaderValueConverterAndValidator();

        private HeaderValueConverterAndValidator() {
            super();
        }

        private static int validateValueChar(CharSequence charSequence, int i, char c2) {
            if ((c2 & 65520) == 0) {
                if (c2 == 0) {
                    throw new IllegalArgumentException("a header value contains a prohibited character '\u0000': " + ((Object) charSequence));
                } else if (c2 == 11) {
                    throw new IllegalArgumentException("a header value contains a prohibited character '\\v': " + ((Object) charSequence));
                } else if (c2 == '\f') {
                    throw new IllegalArgumentException("a header value contains a prohibited character '\\f': " + ((Object) charSequence));
                }
            }
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        if (c2 == '\t' || c2 == ' ') {
                            return 0;
                        }
                        throw new IllegalArgumentException("only ' ' and '\\t' are allowed after '\\n': " + ((Object) charSequence));
                    }
                } else if (c2 == '\n') {
                    return 2;
                } else {
                    throw new IllegalArgumentException("only '\\n' is allowed after '\\r': " + ((Object) charSequence));
                }
            } else if (c2 == '\n') {
                return 2;
            } else {
                if (c2 == '\r') {
                    return 1;
                }
            }
            return i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.handler.codec.http.DefaultHttpHeaders.HeaderValueConverter, io.netty.handler.codec.CharSequenceValueConverter, io.netty.handler.codec.ValueConverter
        public CharSequence convertObject(Object obj) {
            CharSequence convertObject = super.convertObject(obj);
            int i = 0;
            for (int i2 = 0; i2 < convertObject.length(); i2++) {
                i = validateValueChar(convertObject, i, convertObject.charAt(i2));
            }
            if (i == 0) {
                return convertObject;
            }
            throw new IllegalArgumentException("a header value must not end with '\\r' or '\\n':" + ((Object) convertObject));
        }
    }

    public DefaultHttpHeaders() {
        this(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DefaultHeaders.NameValidator<CharSequence> nameValidator(boolean z) {
        return z ? HttpNameValidator : DefaultHeaders.NameValidator.NOT_NULL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateHeaderNameElement(byte b2) {
        if (!(b2 == 0 || b2 == 32 || b2 == 44 || b2 == 61 || b2 == 58 || b2 == 59)) {
            switch (b2) {
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    if (b2 < 0) {
                        throw new IllegalArgumentException("a header name cannot contain non-ASCII character: " + ((int) b2));
                    }
                    return;
            }
        }
        throw new IllegalArgumentException("a header name cannot contain the following prohibited characters: =,;: \\t\\r\\n\\v\\f: " + ((int) b2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ValueConverter<CharSequence> valueConverter(boolean z) {
        return z ? HeaderValueConverterAndValidator.INSTANCE : HeaderValueConverter.INSTANCE;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(HttpHeaders httpHeaders) {
        if (!(httpHeaders instanceof DefaultHttpHeaders)) {
            return super.add(httpHeaders);
        }
        this.headers.add(((DefaultHttpHeaders) httpHeaders).headers);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders addInt(CharSequence charSequence, int i) {
        this.headers.addInt(charSequence, i);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders addShort(CharSequence charSequence, short s) {
        this.headers.addShort(charSequence, s);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders clear() {
        this.headers.clear();
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(String str) {
        return contains((CharSequence) str);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders copy() {
        return new DefaultHttpHeaders(this.headers.copy());
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<Map.Entry<String, String>> entries() {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.headers.size());
        Iterator<Map.Entry<String, String>> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DefaultHttpHeaders) && this.headers.equals(((DefaultHttpHeaders) obj).headers, AsciiString.CASE_SENSITIVE_HASHER);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public String get(String str) {
        return get((CharSequence) str);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<String> getAll(String str) {
        return getAll((CharSequence) str);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Integer getInt(CharSequence charSequence) {
        return this.headers.getInt(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Short getShort(CharSequence charSequence) {
        return this.headers.getShort(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Long getTimeMillis(CharSequence charSequence) {
        return this.headers.getTimeMillis(charSequence);
    }

    public int hashCode() {
        return this.headers.hashCode(AsciiString.CASE_SENSITIVE_HASHER);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean isEmpty() {
        return this.headers.isEmpty();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders, java.lang.Iterable
    @Deprecated
    public Iterator<Map.Entry<String, String>> iterator() {
        return HeadersUtils.iteratorAsString(this.headers);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence() {
        return this.headers.iterator();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Set<String> names() {
        return HeadersUtils.namesAsString(this.headers);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders remove(String str) {
        this.headers.remove(str);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(HttpHeaders httpHeaders) {
        if (!(httpHeaders instanceof DefaultHttpHeaders)) {
            return super.set(httpHeaders);
        }
        this.headers.set(((DefaultHttpHeaders) httpHeaders).headers);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders setInt(CharSequence charSequence, int i) {
        this.headers.setInt(charSequence, i);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders setShort(CharSequence charSequence, short s) {
        this.headers.setShort(charSequence, s);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public int size() {
        return this.headers.size();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<CharSequence> valueCharSequenceIterator(CharSequence charSequence) {
        return this.headers.valueIterator(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<String> valueStringIterator(CharSequence charSequence) {
        final Iterator<CharSequence> valueCharSequenceIterator = valueCharSequenceIterator(charSequence);
        return new Iterator<String>() { // from class: io.netty.handler.codec.http.DefaultHttpHeaders.3
            @Override // java.util.Iterator
            public boolean hasNext() {
                return valueCharSequenceIterator.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                valueCharSequenceIterator.remove();
            }

            @Override // java.util.Iterator
            public String next() {
                return ((CharSequence) valueCharSequenceIterator.next()).toString();
            }
        };
    }

    public DefaultHttpHeaders(boolean z) {
        this(z, nameValidator(z));
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(CharSequence charSequence) {
        return this.headers.contains(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public String get(CharSequence charSequence) {
        return HeadersUtils.getAsString(this.headers, charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<String> getAll(CharSequence charSequence) {
        return HeadersUtils.getAllAsString(this.headers, charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public int getInt(CharSequence charSequence, int i) {
        return this.headers.getInt(charSequence, i);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public short getShort(CharSequence charSequence, short s) {
        return this.headers.getShort(charSequence, s);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public long getTimeMillis(CharSequence charSequence, long j) {
        return this.headers.getTimeMillis(charSequence, j);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders remove(CharSequence charSequence) {
        this.headers.remove(charSequence);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultHttpHeaders(boolean z, DefaultHeaders.NameValidator<CharSequence> nameValidator) {
        this(new DefaultHeadersImpl(AsciiString.CASE_INSENSITIVE_HASHER, valueConverter(z), nameValidator));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateHeaderNameElement(char c2) {
        if (!(c2 == 0 || c2 == ' ' || c2 == ',' || c2 == '=' || c2 == ':' || c2 == ';')) {
            switch (c2) {
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                    break;
                default:
                    if (c2 > 127) {
                        throw new IllegalArgumentException("a header name cannot contain non-ASCII character: " + c2);
                    }
                    return;
            }
        }
        throw new IllegalArgumentException("a header name cannot contain the following prohibited characters: =,;: \\t\\r\\n\\v\\f: " + c2);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(String str, String str2, boolean z) {
        return contains((CharSequence) str, (CharSequence) str2, z);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(String str, Object obj) {
        this.headers.addObject((DefaultHeaders<CharSequence, CharSequence, ?>) str, obj);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return this.headers.contains(charSequence, charSequence2, z ? AsciiString.CASE_INSENSITIVE_HASHER : AsciiString.CASE_SENSITIVE_HASHER);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(String str, Object obj) {
        this.headers.setObject((DefaultHeaders<CharSequence, CharSequence, ?>) str, obj);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(CharSequence charSequence, Object obj) {
        this.headers.addObject((DefaultHeaders<CharSequence, CharSequence, ?>) charSequence, obj);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(CharSequence charSequence, Object obj) {
        this.headers.setObject((DefaultHeaders<CharSequence, CharSequence, ?>) charSequence, obj);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultHttpHeaders(DefaultHeaders<CharSequence, CharSequence, ?> defaultHeaders) {
        this.headers = defaultHeaders;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(String str, Iterable<?> iterable) {
        this.headers.addObject((DefaultHeaders<CharSequence, CharSequence, ?>) str, iterable);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(String str, Iterable<?> iterable) {
        this.headers.setObject((DefaultHeaders<CharSequence, CharSequence, ?>) str, iterable);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(CharSequence charSequence, Iterable<?> iterable) {
        this.headers.addObject((DefaultHeaders<CharSequence, CharSequence, ?>) charSequence, iterable);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(CharSequence charSequence, Iterable<?> iterable) {
        this.headers.setObject((DefaultHeaders<CharSequence, CharSequence, ?>) charSequence, iterable);
        return this;
    }
}
