package com.tplink.libtpnetwork.Utils;

import java.util.Random;

/* compiled from: RandomUtil.java */
/* loaded from: classes3.dex */
public class m {
    public static String a(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            if (random.nextInt(2) == 0) {
                sb.append(Character.toString(Character.toChars(random.nextInt(26) + (random.nextInt(2) == 0 ? 65 : 97))[0]));
            } else {
                sb.append(String.valueOf(random.nextInt(10)));
            }
        }
        return sb.toString();
    }
}
