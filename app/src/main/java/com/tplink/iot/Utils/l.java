package com.tplink.iot.Utils;

import com.tplink.iot.R;

/* compiled from: DirectionUtils.java */
/* loaded from: classes2.dex */
public class l {
    public static int[] a(int i) {
        int[] iArr = new int[2];
        if (i == 0) {
            iArr[0] = R.anim.slide_in_right;
            iArr[1] = R.anim.slide_out_left;
        } else if (i == 1) {
            iArr[0] = R.anim.pop_up_in;
            iArr[1] = R.anim.pop_up_out;
        } else if (i == 2) {
            iArr[0] = 17432576;
            iArr[1] = 17432577;
        } else if (i == 4) {
            iArr[0] = R.anim.fragment_in_left;
            iArr[1] = R.anim.fragment_out_right;
        } else if (i == 3) {
            iArr[0] = R.anim.fragment_in_right;
            iArr[1] = R.anim.fragment_out_left;
        }
        return iArr;
    }
}
