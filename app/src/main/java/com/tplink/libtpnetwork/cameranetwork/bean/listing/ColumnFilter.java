package com.tplink.libtpnetwork.cameranetwork.bean.listing;

import com.google.gson.JsonParseException;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.k;
import com.tplink.libtpnetwork.cameranetwork.util.c;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes3.dex */
public class ColumnFilter<T> implements Filter {
    public static final String TYPE_BOOLEAN = "boolean";
    public static final String TYPE_DATE = "date";
    public static final String TYPE_DATETIME = "datetime";
    public static final String TYPE_DOUBLE = "double";
    public static final String TYPE_FLOAT = "float";
    public static final String TYPE_INTEGER = "integer";
    public static final String TYPE_LIST = "list";
    public static final String TYPE_LONG = "long";
    public static final String TYPE_OBJECT = "object";
    public static final String TYPE_STRING = "string";
    private String key;
    private Operation operation;
    private String type;
    private T value;

    /* loaded from: classes3.dex */
    public static final class ColumnFilterDeserializer implements h<ColumnFilter> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.h
        public ColumnFilter deserialize(i iVar, Type type, g gVar) throws JsonParseException {
            k c2 = iVar.c();
            String b2 = c.b(c2, "key");
            String e2 = c2.o("type") ? c2.n("type").e() : ColumnFilter.TYPE_STRING;
            String str = null;
            i n = c2.o("value") ? c2.n("value") : null;
            ColumnFilter columnFilter = new ColumnFilter();
            if (!n.f()) {
                if (c2.o("value")) {
                    str = c2.n("value").e();
                }
                e2.hashCode();
                char c3 = 65535;
                switch (e2.hashCode()) {
                    case -1325958191:
                        if (e2.equals(ColumnFilter.TYPE_DOUBLE)) {
                            c3 = 0;
                            break;
                        }
                        break;
                    case -1023368385:
                        if (e2.equals(ColumnFilter.TYPE_OBJECT)) {
                            c3 = 1;
                            break;
                        }
                        break;
                    case -891985903:
                        if (e2.equals(ColumnFilter.TYPE_STRING)) {
                            c3 = 2;
                            break;
                        }
                        break;
                    case 3076014:
                        if (e2.equals(ColumnFilter.TYPE_DATE)) {
                            c3 = 3;
                            break;
                        }
                        break;
                    case 3327612:
                        if (e2.equals(ColumnFilter.TYPE_LONG)) {
                            c3 = 4;
                            break;
                        }
                        break;
                    case 64711720:
                        if (e2.equals(ColumnFilter.TYPE_BOOLEAN)) {
                            c3 = 5;
                            break;
                        }
                        break;
                    case 97526364:
                        if (e2.equals(ColumnFilter.TYPE_FLOAT)) {
                            c3 = 6;
                            break;
                        }
                        break;
                    case 1793702779:
                        if (e2.equals(ColumnFilter.TYPE_DATETIME)) {
                            c3 = 7;
                            break;
                        }
                        break;
                    case 1958052158:
                        if (e2.equals(ColumnFilter.TYPE_INTEGER)) {
                            c3 = '\b';
                            break;
                        }
                        break;
                }
                switch (c3) {
                    case 0:
                        columnFilter.setValue(Double.valueOf(Double.parseDouble(str)));
                        break;
                    case 1:
                        columnFilter.setValue(str, e2);
                        break;
                    case 2:
                        columnFilter.setValue(str);
                        break;
                    case 3:
                    case 7:
                        try {
                            columnFilter.setValue(c.d(str));
                            break;
                        } catch (ParseException unused) {
                            break;
                        }
                    case 4:
                        columnFilter.setValue(Long.valueOf(Long.parseLong(str)));
                        break;
                    case 5:
                        columnFilter.setValue(Boolean.valueOf(Boolean.parseBoolean(str)));
                        break;
                    case 6:
                        columnFilter.setValue(Float.valueOf(Float.parseFloat(str)));
                        break;
                    case '\b':
                        columnFilter.setValue(Integer.valueOf(Integer.parseInt(str)));
                        break;
                }
            } else {
                columnFilter.setValue(c.a(n.b()), e2);
            }
            String e3 = c2.n("operation").e();
            columnFilter.setKey(b2);
            columnFilter.setOperation(Operation.valueOf(e3));
            return columnFilter;
        }
    }

    public ColumnFilter() {
    }

    public String getKey() {
        return this.key;
    }

    public Operation getOperation() {
        return this.operation;
    }

    public String getType() {
        return this.type;
    }

    public T getValue() {
        return this.value;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValue(T t) {
        setValue(t, getType(t));
    }

    public ColumnFilter(String str, T t, Operation operation) {
        this.key = str;
        this.value = t;
        this.operation = operation;
        this.type = getType(t);
    }

    public static String getType(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof String ? TYPE_STRING : obj instanceof Integer ? TYPE_INTEGER : obj instanceof Long ? TYPE_LONG : obj instanceof Float ? TYPE_FLOAT : obj instanceof Double ? TYPE_DOUBLE : obj instanceof Date ? TYPE_DATETIME : obj instanceof Boolean ? TYPE_BOOLEAN : TYPE_STRING;
    }

    public void setValue(T t, String str) {
        this.value = t;
        this.type = str;
    }

    public ColumnFilter(String str, T t, String str2, Operation operation) {
        this.key = str;
        this.value = t;
        this.operation = operation;
        this.type = str2;
    }
}
