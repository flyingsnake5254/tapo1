package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

import android.text.TextUtils;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.apache.commons.lang.f;

/* loaded from: classes3.dex */
public class ColorHSBAttributeValue {
    private static final int HEX_CHAR_COUNT = 16;
    private static final int MULTIPLIER;
    public static final char[] TOKEN_CHARS;

    /* renamed from: b  reason: collision with root package name */
    private IntegerAttributeValue f12837b;
    private IntegerAttributeValue h;
    private String id = generateId();
    private IntegerAttributeValue s;

    /* loaded from: classes3.dex */
    public static final class ColorHSBAttributeValueBuilder {

        /* renamed from: b  reason: collision with root package name */
        private IntegerAttributeValue f12838b;
        private IntegerAttributeValue h;
        private String id;
        private IntegerAttributeValue s;

        public static ColorHSBAttributeValueBuilder aColorHSBAttributeValue() {
            return new ColorHSBAttributeValueBuilder();
        }

        public ColorHSBAttributeValueBuilder b(IntegerAttributeValue integerAttributeValue) {
            this.f12838b = integerAttributeValue;
            return this;
        }

        public ColorHSBAttributeValue build() {
            ColorHSBAttributeValue colorHSBAttributeValue = new ColorHSBAttributeValue();
            if (TextUtils.isEmpty(this.id)) {
                colorHSBAttributeValue.setId(ColorHSBAttributeValue.generateId());
            } else {
                colorHSBAttributeValue.setId(this.id);
            }
            colorHSBAttributeValue.setH(this.h);
            colorHSBAttributeValue.setS(this.s);
            colorHSBAttributeValue.setB(this.f12838b);
            return colorHSBAttributeValue;
        }

        public ColorHSBAttributeValueBuilder h(IntegerAttributeValue integerAttributeValue) {
            this.h = integerAttributeValue;
            return this;
        }

        public ColorHSBAttributeValueBuilder id(String str) {
            this.id = str;
            return this;
        }

        public ColorHSBAttributeValueBuilder s(IntegerAttributeValue integerAttributeValue) {
            this.s = integerAttributeValue;
            return this;
        }

        private ColorHSBAttributeValueBuilder() {
        }
    }

    static {
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        TOKEN_CHARS = charArray;
        MULTIPLIER = charArray.length / 16;
    }

    public static ColorHSBAttributeValueBuilder builder() {
        return new ColorHSBAttributeValueBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateId() {
        String upperCase = UUID.randomUUID().toString().toUpperCase();
        StringBuilder sb = new StringBuilder(upperCase.length());
        for (int i = 0; i < upperCase.length(); i++) {
            char charAt = upperCase.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(TOKEN_CHARS[(randomInt(MULTIPLIER) * 16) + (charAt - '0')]);
            } else if (isAlphabeticCompat(charAt)) {
                sb.append(TOKEN_CHARS[(randomInt(MULTIPLIER) * 16) + 10 + (charAt - 'A')]);
            }
        }
        return sb.toString();
    }

    public static boolean isAlphabeticCompat(int i) {
        if (f.h(1.7f)) {
            return Character.isAlphabetic(i);
        }
        return Character.isLetter(i) || Character.getType(i) == 10;
    }

    public static int randomInt(int i) {
        return new Random().nextInt(i);
    }

    public IntegerAttributeValue getB() {
        return this.f12837b;
    }

    public IntegerAttributeValue getH() {
        return this.h;
    }

    public String getId() {
        return this.id;
    }

    public IntegerAttributeValue getS() {
        return this.s;
    }

    public boolean isRegisteredIn(List<ColorHSBAttributeValue> list) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(this.id)) {
            for (ColorHSBAttributeValue colorHSBAttributeValue : list) {
                if (!(colorHSBAttributeValue == null || TextUtils.isEmpty(colorHSBAttributeValue.getId()) || !colorHSBAttributeValue.getId().equals(this.id))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid() {
        IntegerAttributeValue integerAttributeValue;
        return !TextUtils.isEmpty(this.id) && (integerAttributeValue = this.h) != null && this.s != null && this.f12837b != null && integerAttributeValue.isValid() && this.s.isValid() && this.f12837b.isValid();
    }

    public void setB(IntegerAttributeValue integerAttributeValue) {
        this.f12837b = integerAttributeValue;
    }

    public void setH(IntegerAttributeValue integerAttributeValue) {
        this.h = integerAttributeValue;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setS(IntegerAttributeValue integerAttributeValue) {
        this.s = integerAttributeValue;
    }
}
