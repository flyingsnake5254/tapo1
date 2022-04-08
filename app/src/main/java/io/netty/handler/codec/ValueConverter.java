package io.netty.handler.codec;

/* loaded from: classes3.dex */
public interface ValueConverter<T> {
    T convertBoolean(boolean z);

    T convertByte(byte b2);

    T convertChar(char c2);

    T convertDouble(double d2);

    T convertFloat(float f2);

    T convertInt(int i);

    T convertLong(long j);

    T convertObject(Object obj);

    T convertShort(short s);

    T convertTimeMillis(long j);

    boolean convertToBoolean(T t);

    byte convertToByte(T t);

    char convertToChar(T t);

    double convertToDouble(T t);

    float convertToFloat(T t);

    int convertToInt(T t);

    long convertToLong(T t);

    short convertToShort(T t);

    long convertToTimeMillis(T t);
}
