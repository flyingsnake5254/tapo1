package org.bouncycastle.crypto.tls;

import androidx.core.view.MotionEventCompat;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.i;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x509.m;
import org.bouncycastle.asn1.x509.t;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.p.e;
import org.bouncycastle.crypto.p.f;
import org.bouncycastle.crypto.p.h;
import org.bouncycastle.crypto.t.b;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.util.a;
import org.bouncycastle.util.d;

/* loaded from: classes4.dex */
public class m1 {
    public static final byte[] a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public static final short[] f17259b = new short[0];

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f17260c = new int[0];

    /* renamed from: d  reason: collision with root package name */
    public static final long[] f17261d = new long[0];

    /* renamed from: e  reason: collision with root package name */
    public static final Integer f17262e = d.b(13);

    /* renamed from: f  reason: collision with root package name */
    static final byte[] f17263f = {67, 76, 78, 84};
    static final byte[] g = {83, 82, 86, 82};
    static final byte[][] h = u();

    /* JADX WARN: Removed duplicated region for block: B:30:0x004b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A(int r3) throws java.io.IOException {
        /*
            r0 = 1
            r1 = 0
            if (r3 == r0) goto L_0x0061
            r0 = 2
            if (r3 == r0) goto L_0x0061
            r2 = 4
            if (r3 == r2) goto L_0x0060
            r2 = 5
            if (r3 == r2) goto L_0x0060
            switch(r3) {
                case 10: goto L_0x005e;
                case 13: goto L_0x005e;
                case 16: goto L_0x005e;
                case 19: goto L_0x005e;
                case 22: goto L_0x005e;
                case 24: goto L_0x0060;
                case 27: goto L_0x005e;
                case 132: goto L_0x005b;
                case 133: goto L_0x005b;
                case 134: goto L_0x005b;
                case 135: goto L_0x005b;
                case 136: goto L_0x005b;
                case 137: goto L_0x005b;
                case 138: goto L_0x0060;
                case 139: goto L_0x005e;
                case 140: goto L_0x0058;
                case 141: goto L_0x0055;
                case 142: goto L_0x0060;
                case 143: goto L_0x005e;
                case 144: goto L_0x0058;
                case 145: goto L_0x0055;
                case 146: goto L_0x0060;
                case 147: goto L_0x005e;
                case 148: goto L_0x0058;
                case 149: goto L_0x0055;
                case 150: goto L_0x0052;
                case 151: goto L_0x0052;
                case 152: goto L_0x0052;
                case 153: goto L_0x0052;
                case 154: goto L_0x0052;
                case 155: goto L_0x0052;
                case 156: goto L_0x004f;
                case 157: goto L_0x004c;
                case 158: goto L_0x004f;
                case 159: goto L_0x004c;
                case 160: goto L_0x004f;
                case 161: goto L_0x004c;
                case 162: goto L_0x004f;
                case 163: goto L_0x004c;
                case 164: goto L_0x004f;
                case 165: goto L_0x004c;
                case 166: goto L_0x004f;
                case 167: goto L_0x004c;
                case 168: goto L_0x004f;
                case 169: goto L_0x004c;
                case 170: goto L_0x004f;
                case 171: goto L_0x004c;
                case 172: goto L_0x004f;
                case 173: goto L_0x004c;
                case 174: goto L_0x0058;
                case 175: goto L_0x0055;
                case 176: goto L_0x004b;
                case 177: goto L_0x004b;
                case 178: goto L_0x0058;
                case 179: goto L_0x0055;
                case 180: goto L_0x004b;
                case 181: goto L_0x004b;
                case 182: goto L_0x0058;
                case 183: goto L_0x0055;
                case 184: goto L_0x004b;
                case 185: goto L_0x004b;
                case 186: goto L_0x0048;
                case 187: goto L_0x0048;
                case 188: goto L_0x0048;
                case 189: goto L_0x0048;
                case 190: goto L_0x0048;
                case 191: goto L_0x0048;
                case 192: goto L_0x005b;
                case 193: goto L_0x005b;
                case 194: goto L_0x005b;
                case 195: goto L_0x005b;
                case 196: goto L_0x005b;
                case 197: goto L_0x005b;
                default: goto L_0x0010;
            }
        L_0x0010:
            switch(r3) {
                case 44: goto L_0x0061;
                case 45: goto L_0x0061;
                case 46: goto L_0x0061;
                case 47: goto L_0x0058;
                case 48: goto L_0x0058;
                case 49: goto L_0x0058;
                case 50: goto L_0x0058;
                case 51: goto L_0x0058;
                case 52: goto L_0x0058;
                case 53: goto L_0x0055;
                case 54: goto L_0x0055;
                case 55: goto L_0x0055;
                case 56: goto L_0x0055;
                case 57: goto L_0x0055;
                case 58: goto L_0x0055;
                case 59: goto L_0x004b;
                case 60: goto L_0x0058;
                case 61: goto L_0x0055;
                case 62: goto L_0x0058;
                case 63: goto L_0x0058;
                case 64: goto L_0x0058;
                case 65: goto L_0x0048;
                case 66: goto L_0x0048;
                case 67: goto L_0x0048;
                case 68: goto L_0x0048;
                case 69: goto L_0x0048;
                case 70: goto L_0x0048;
                default: goto L_0x0013;
            }
        L_0x0013:
            switch(r3) {
                case 103: goto L_0x0058;
                case 104: goto L_0x0055;
                case 105: goto L_0x0055;
                case 106: goto L_0x0055;
                case 107: goto L_0x0055;
                case 108: goto L_0x0058;
                case 109: goto L_0x0055;
                default: goto L_0x0016;
            }
        L_0x0016:
            switch(r3) {
                case 49153: goto L_0x0061;
                case 49154: goto L_0x0060;
                case 49155: goto L_0x005e;
                case 49156: goto L_0x0058;
                case 49157: goto L_0x0055;
                case 49158: goto L_0x0061;
                case 49159: goto L_0x0060;
                case 49160: goto L_0x005e;
                case 49161: goto L_0x0058;
                case 49162: goto L_0x0055;
                case 49163: goto L_0x0061;
                case 49164: goto L_0x0060;
                case 49165: goto L_0x005e;
                case 49166: goto L_0x0058;
                case 49167: goto L_0x0055;
                case 49168: goto L_0x0061;
                case 49169: goto L_0x0060;
                case 49170: goto L_0x005e;
                case 49171: goto L_0x0058;
                case 49172: goto L_0x0055;
                case 49173: goto L_0x0061;
                case 49174: goto L_0x0060;
                case 49175: goto L_0x005e;
                case 49176: goto L_0x0058;
                case 49177: goto L_0x0055;
                case 49178: goto L_0x005e;
                case 49179: goto L_0x005e;
                case 49180: goto L_0x005e;
                case 49181: goto L_0x0058;
                case 49182: goto L_0x0058;
                case 49183: goto L_0x0058;
                case 49184: goto L_0x0055;
                case 49185: goto L_0x0055;
                case 49186: goto L_0x0055;
                case 49187: goto L_0x0058;
                case 49188: goto L_0x0055;
                case 49189: goto L_0x0058;
                case 49190: goto L_0x0055;
                case 49191: goto L_0x0058;
                case 49192: goto L_0x0055;
                case 49193: goto L_0x0058;
                case 49194: goto L_0x0055;
                case 49195: goto L_0x004f;
                case 49196: goto L_0x004c;
                case 49197: goto L_0x004f;
                case 49198: goto L_0x004c;
                case 49199: goto L_0x004f;
                case 49200: goto L_0x004c;
                case 49201: goto L_0x004f;
                case 49202: goto L_0x004c;
                case 49203: goto L_0x0060;
                case 49204: goto L_0x005e;
                case 49205: goto L_0x0058;
                case 49206: goto L_0x0055;
                case 49207: goto L_0x0058;
                case 49208: goto L_0x0055;
                case 49209: goto L_0x0061;
                case 49210: goto L_0x004b;
                case 49211: goto L_0x004b;
                default: goto L_0x0019;
            }
        L_0x0019:
            switch(r3) {
                case 49266: goto L_0x0048;
                case 49267: goto L_0x005b;
                case 49268: goto L_0x0048;
                case 49269: goto L_0x005b;
                case 49270: goto L_0x0048;
                case 49271: goto L_0x005b;
                case 49272: goto L_0x0048;
                case 49273: goto L_0x005b;
                case 49274: goto L_0x0045;
                case 49275: goto L_0x0042;
                case 49276: goto L_0x0045;
                case 49277: goto L_0x0042;
                case 49278: goto L_0x0045;
                case 49279: goto L_0x0042;
                case 49280: goto L_0x0045;
                case 49281: goto L_0x0042;
                case 49282: goto L_0x0045;
                case 49283: goto L_0x0042;
                case 49284: goto L_0x0045;
                case 49285: goto L_0x0042;
                case 49286: goto L_0x0045;
                case 49287: goto L_0x0042;
                case 49288: goto L_0x0045;
                case 49289: goto L_0x0042;
                case 49290: goto L_0x0045;
                case 49291: goto L_0x0042;
                case 49292: goto L_0x0045;
                case 49293: goto L_0x0042;
                case 49294: goto L_0x0045;
                case 49295: goto L_0x0042;
                case 49296: goto L_0x0045;
                case 49297: goto L_0x0042;
                case 49298: goto L_0x0045;
                case 49299: goto L_0x0042;
                case 49300: goto L_0x0048;
                case 49301: goto L_0x005b;
                case 49302: goto L_0x0048;
                case 49303: goto L_0x005b;
                case 49304: goto L_0x0048;
                case 49305: goto L_0x005b;
                case 49306: goto L_0x0048;
                case 49307: goto L_0x005b;
                case 49308: goto L_0x003f;
                case 49309: goto L_0x003c;
                case 49310: goto L_0x003f;
                case 49311: goto L_0x003c;
                case 49312: goto L_0x0039;
                case 49313: goto L_0x0036;
                case 49314: goto L_0x0039;
                case 49315: goto L_0x0036;
                case 49316: goto L_0x003f;
                case 49317: goto L_0x003c;
                case 49318: goto L_0x003f;
                case 49319: goto L_0x003c;
                case 49320: goto L_0x0039;
                case 49321: goto L_0x0036;
                case 49322: goto L_0x0039;
                case 49323: goto L_0x0036;
                case 49324: goto L_0x003f;
                case 49325: goto L_0x003c;
                case 49326: goto L_0x0039;
                case 49327: goto L_0x0036;
                default: goto L_0x001c;
            }
        L_0x001c:
            switch(r3) {
                case 52392: goto L_0x0033;
                case 52393: goto L_0x0033;
                case 52394: goto L_0x0033;
                case 52395: goto L_0x0033;
                case 52396: goto L_0x0033;
                case 52397: goto L_0x0033;
                case 52398: goto L_0x0033;
                default: goto L_0x001f;
            }
        L_0x001f:
            switch(r3) {
                case 65280: goto L_0x0030;
                case 65281: goto L_0x002d;
                case 65282: goto L_0x0030;
                case 65283: goto L_0x002d;
                case 65284: goto L_0x0030;
                case 65285: goto L_0x002d;
                default: goto L_0x0022;
            }
        L_0x0022:
            switch(r3) {
                case 65296: goto L_0x0030;
                case 65297: goto L_0x002d;
                case 65298: goto L_0x0030;
                case 65299: goto L_0x002d;
                case 65300: goto L_0x0030;
                case 65301: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            org.bouncycastle.crypto.tls.TlsFatalAlert r3 = new org.bouncycastle.crypto.tls.TlsFatalAlert
            r0 = 80
            r3.<init>(r0)
            throw r3
        L_0x002d:
            r3 = 104(0x68, float:1.46E-43)
            return r3
        L_0x0030:
            r3 = 103(0x67, float:1.44E-43)
            return r3
        L_0x0033:
            r3 = 21
            return r3
        L_0x0036:
            r3 = 18
            return r3
        L_0x0039:
            r3 = 16
            return r3
        L_0x003c:
            r3 = 17
            return r3
        L_0x003f:
            r3 = 15
            return r3
        L_0x0042:
            r3 = 20
            return r3
        L_0x0045:
            r3 = 19
            return r3
        L_0x0048:
            r3 = 12
            return r3
        L_0x004b:
            return r1
        L_0x004c:
            r3 = 11
            return r3
        L_0x004f:
            r3 = 10
            return r3
        L_0x0052:
            r3 = 14
            return r3
        L_0x0055:
            r3 = 9
            return r3
        L_0x0058:
            r3 = 8
            return r3
        L_0x005b:
            r3 = 13
            return r3
        L_0x005e:
            r3 = 7
            return r3
        L_0x0060:
            return r0
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.tls.m1.A(int):int");
    }

    public static void A0(int[] iArr, OutputStream outputStream) throws IOException {
        int length = iArr.length * 2;
        i(length);
        w0(length, outputStream);
        y0(iArr, outputStream);
    }

    public static byte[] B(Hashtable hashtable, Integer num) {
        if (hashtable == null) {
            return null;
        }
        return (byte[]) hashtable.get(num);
    }

    public static void B0(int[] iArr, byte[] bArr, int i) throws IOException {
        int length = iArr.length * 2;
        i(length);
        x0(length, bArr, i);
        z0(iArr, bArr, i + 2);
    }

    public static short C(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("legacy PRF not a valid algorithm");
        } else if (i == 1) {
            return (short) 4;
        } else {
            if (i == 2) {
                return (short) 5;
            }
            throw new IllegalArgumentException("unknown PRFAlgorithm");
        }
    }

    public static void C0(int i, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (i >>> 16));
        outputStream.write((byte) (i >>> 8));
        outputStream.write((byte) i);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int D(int r2) throws java.io.IOException {
        /*
            r0 = 1
            if (r2 == r0) goto L_0x005b
            r1 = 2
            if (r2 == r1) goto L_0x005b
            r1 = 4
            if (r2 == r1) goto L_0x005b
            r1 = 5
            if (r2 == r1) goto L_0x005b
            switch(r2) {
                case 10: goto L_0x005b;
                case 13: goto L_0x0059;
                case 16: goto L_0x0056;
                case 19: goto L_0x0054;
                case 22: goto L_0x0053;
                case 24: goto L_0x0050;
                case 27: goto L_0x0050;
                case 132: goto L_0x005b;
                case 133: goto L_0x0059;
                case 134: goto L_0x0056;
                case 135: goto L_0x0054;
                case 136: goto L_0x0053;
                case 137: goto L_0x0050;
                case 138: goto L_0x004d;
                case 139: goto L_0x004d;
                case 140: goto L_0x004d;
                case 141: goto L_0x004d;
                case 142: goto L_0x004a;
                case 143: goto L_0x004a;
                case 144: goto L_0x004a;
                case 145: goto L_0x004a;
                case 146: goto L_0x0047;
                case 147: goto L_0x0047;
                case 148: goto L_0x0047;
                case 149: goto L_0x0047;
                case 150: goto L_0x005b;
                case 151: goto L_0x0059;
                case 152: goto L_0x0056;
                case 153: goto L_0x0054;
                case 154: goto L_0x0053;
                case 155: goto L_0x0050;
                case 156: goto L_0x005b;
                case 157: goto L_0x005b;
                case 158: goto L_0x0053;
                case 159: goto L_0x0053;
                case 160: goto L_0x0056;
                case 161: goto L_0x0056;
                case 162: goto L_0x0054;
                case 163: goto L_0x0054;
                case 164: goto L_0x0059;
                case 165: goto L_0x0059;
                case 166: goto L_0x0050;
                case 167: goto L_0x0050;
                case 168: goto L_0x004d;
                case 169: goto L_0x004d;
                case 170: goto L_0x004a;
                case 171: goto L_0x004a;
                case 172: goto L_0x0047;
                case 173: goto L_0x0047;
                case 174: goto L_0x004d;
                case 175: goto L_0x004d;
                case 176: goto L_0x004d;
                case 177: goto L_0x004d;
                case 178: goto L_0x004a;
                case 179: goto L_0x004a;
                case 180: goto L_0x004a;
                case 181: goto L_0x004a;
                case 182: goto L_0x0047;
                case 183: goto L_0x0047;
                case 184: goto L_0x0047;
                case 185: goto L_0x0047;
                case 186: goto L_0x005b;
                case 187: goto L_0x0059;
                case 188: goto L_0x0056;
                case 189: goto L_0x0054;
                case 190: goto L_0x0053;
                case 191: goto L_0x0050;
                case 192: goto L_0x005b;
                case 193: goto L_0x0059;
                case 194: goto L_0x0056;
                case 195: goto L_0x0054;
                case 196: goto L_0x0053;
                case 197: goto L_0x0050;
                default: goto L_0x000f;
            }
        L_0x000f:
            switch(r2) {
                case 44: goto L_0x004d;
                case 45: goto L_0x004a;
                case 46: goto L_0x0047;
                case 47: goto L_0x005b;
                case 48: goto L_0x0059;
                case 49: goto L_0x0056;
                case 50: goto L_0x0054;
                case 51: goto L_0x0053;
                case 52: goto L_0x0050;
                case 53: goto L_0x005b;
                case 54: goto L_0x0059;
                case 55: goto L_0x0056;
                case 56: goto L_0x0054;
                case 57: goto L_0x0053;
                case 58: goto L_0x0050;
                case 59: goto L_0x005b;
                case 60: goto L_0x005b;
                case 61: goto L_0x005b;
                case 62: goto L_0x0059;
                case 63: goto L_0x0056;
                case 64: goto L_0x0054;
                case 65: goto L_0x005b;
                case 66: goto L_0x0059;
                case 67: goto L_0x0056;
                case 68: goto L_0x0054;
                case 69: goto L_0x0053;
                case 70: goto L_0x0050;
                default: goto L_0x0012;
            }
        L_0x0012:
            switch(r2) {
                case 103: goto L_0x0053;
                case 104: goto L_0x0059;
                case 105: goto L_0x0056;
                case 106: goto L_0x0054;
                case 107: goto L_0x0053;
                case 108: goto L_0x0050;
                case 109: goto L_0x0050;
                default: goto L_0x0015;
            }
        L_0x0015:
            switch(r2) {
                case 49153: goto L_0x0044;
                case 49154: goto L_0x0044;
                case 49155: goto L_0x0044;
                case 49156: goto L_0x0044;
                case 49157: goto L_0x0044;
                case 49158: goto L_0x0041;
                case 49159: goto L_0x0041;
                case 49160: goto L_0x0041;
                case 49161: goto L_0x0041;
                case 49162: goto L_0x0041;
                case 49163: goto L_0x003e;
                case 49164: goto L_0x003e;
                case 49165: goto L_0x003e;
                case 49166: goto L_0x003e;
                case 49167: goto L_0x003e;
                case 49168: goto L_0x003b;
                case 49169: goto L_0x003b;
                case 49170: goto L_0x003b;
                case 49171: goto L_0x003b;
                case 49172: goto L_0x003b;
                case 49173: goto L_0x0038;
                case 49174: goto L_0x0038;
                case 49175: goto L_0x0038;
                case 49176: goto L_0x0038;
                case 49177: goto L_0x0038;
                case 49178: goto L_0x0035;
                case 49179: goto L_0x0032;
                case 49180: goto L_0x002f;
                case 49181: goto L_0x0035;
                case 49182: goto L_0x0032;
                case 49183: goto L_0x002f;
                case 49184: goto L_0x0035;
                case 49185: goto L_0x0032;
                case 49186: goto L_0x002f;
                case 49187: goto L_0x0041;
                case 49188: goto L_0x0041;
                case 49189: goto L_0x0044;
                case 49190: goto L_0x0044;
                case 49191: goto L_0x003b;
                case 49192: goto L_0x003b;
                case 49193: goto L_0x003e;
                case 49194: goto L_0x003e;
                case 49195: goto L_0x0041;
                case 49196: goto L_0x0041;
                case 49197: goto L_0x0044;
                case 49198: goto L_0x0044;
                case 49199: goto L_0x003b;
                case 49200: goto L_0x003b;
                case 49201: goto L_0x003e;
                case 49202: goto L_0x003e;
                case 49203: goto L_0x002c;
                case 49204: goto L_0x002c;
                case 49205: goto L_0x002c;
                case 49206: goto L_0x002c;
                case 49207: goto L_0x002c;
                case 49208: goto L_0x002c;
                case 49209: goto L_0x002c;
                case 49210: goto L_0x002c;
                case 49211: goto L_0x002c;
                default: goto L_0x0018;
            }
        L_0x0018:
            switch(r2) {
                case 49266: goto L_0x0041;
                case 49267: goto L_0x0041;
                case 49268: goto L_0x0044;
                case 49269: goto L_0x0044;
                case 49270: goto L_0x003b;
                case 49271: goto L_0x003b;
                case 49272: goto L_0x003e;
                case 49273: goto L_0x003e;
                case 49274: goto L_0x005b;
                case 49275: goto L_0x005b;
                case 49276: goto L_0x0053;
                case 49277: goto L_0x0053;
                case 49278: goto L_0x0056;
                case 49279: goto L_0x0056;
                case 49280: goto L_0x0054;
                case 49281: goto L_0x0054;
                case 49282: goto L_0x0059;
                case 49283: goto L_0x0059;
                case 49284: goto L_0x0050;
                case 49285: goto L_0x0050;
                case 49286: goto L_0x0041;
                case 49287: goto L_0x0041;
                case 49288: goto L_0x0044;
                case 49289: goto L_0x0044;
                case 49290: goto L_0x003b;
                case 49291: goto L_0x003b;
                case 49292: goto L_0x003e;
                case 49293: goto L_0x003e;
                case 49294: goto L_0x004d;
                case 49295: goto L_0x004d;
                case 49296: goto L_0x004a;
                case 49297: goto L_0x004a;
                case 49298: goto L_0x0047;
                case 49299: goto L_0x0047;
                case 49300: goto L_0x004d;
                case 49301: goto L_0x004d;
                case 49302: goto L_0x004a;
                case 49303: goto L_0x004a;
                case 49304: goto L_0x0047;
                case 49305: goto L_0x0047;
                case 49306: goto L_0x002c;
                case 49307: goto L_0x002c;
                case 49308: goto L_0x005b;
                case 49309: goto L_0x005b;
                case 49310: goto L_0x0053;
                case 49311: goto L_0x0053;
                case 49312: goto L_0x005b;
                case 49313: goto L_0x005b;
                case 49314: goto L_0x0053;
                case 49315: goto L_0x0053;
                case 49316: goto L_0x004d;
                case 49317: goto L_0x004d;
                case 49318: goto L_0x004a;
                case 49319: goto L_0x004a;
                case 49320: goto L_0x004d;
                case 49321: goto L_0x004d;
                case 49322: goto L_0x004a;
                case 49323: goto L_0x004a;
                case 49324: goto L_0x0041;
                case 49325: goto L_0x0041;
                case 49326: goto L_0x0041;
                case 49327: goto L_0x0041;
                default: goto L_0x001b;
            }
        L_0x001b:
            switch(r2) {
                case 52392: goto L_0x003b;
                case 52393: goto L_0x0041;
                case 52394: goto L_0x0053;
                case 52395: goto L_0x004d;
                case 52396: goto L_0x002c;
                case 52397: goto L_0x004a;
                case 52398: goto L_0x0047;
                default: goto L_0x001e;
            }
        L_0x001e:
            switch(r2) {
                case 65280: goto L_0x0053;
                case 65281: goto L_0x0053;
                case 65282: goto L_0x003b;
                case 65283: goto L_0x003b;
                case 65284: goto L_0x0041;
                case 65285: goto L_0x0041;
                default: goto L_0x0021;
            }
        L_0x0021:
            switch(r2) {
                case 65296: goto L_0x004d;
                case 65297: goto L_0x004d;
                case 65298: goto L_0x004a;
                case 65299: goto L_0x004a;
                case 65300: goto L_0x002c;
                case 65301: goto L_0x002c;
                default: goto L_0x0024;
            }
        L_0x0024:
            org.bouncycastle.crypto.tls.TlsFatalAlert r2 = new org.bouncycastle.crypto.tls.TlsFatalAlert
            r0 = 80
            r2.<init>(r0)
            throw r2
        L_0x002c:
            r2 = 24
            return r2
        L_0x002f:
            r2 = 22
            return r2
        L_0x0032:
            r2 = 23
            return r2
        L_0x0035:
            r2 = 21
            return r2
        L_0x0038:
            r2 = 20
            return r2
        L_0x003b:
            r2 = 19
            return r2
        L_0x003e:
            r2 = 18
            return r2
        L_0x0041:
            r2 = 17
            return r2
        L_0x0044:
            r2 = 16
            return r2
        L_0x0047:
            r2 = 15
            return r2
        L_0x004a:
            r2 = 14
            return r2
        L_0x004d:
            r2 = 13
            return r2
        L_0x0050:
            r2 = 11
            return r2
        L_0x0053:
            return r1
        L_0x0054:
            r2 = 3
            return r2
        L_0x0056:
            r2 = 9
            return r2
        L_0x0059:
            r2 = 7
            return r2
        L_0x005b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.tls.m1.D(int):int");
    }

    public static void D0(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 16);
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) i;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int E(int r4) throws java.io.IOException {
        /*
            r0 = 1
            if (r4 == r0) goto L_0x0032
            r1 = 2
            if (r4 == r1) goto L_0x0031
            r2 = 4
            if (r4 == r2) goto L_0x0032
            r3 = 5
            if (r4 == r3) goto L_0x0031
            switch(r4) {
                case 10: goto L_0x0031;
                case 13: goto L_0x0031;
                case 16: goto L_0x0031;
                case 19: goto L_0x0031;
                case 22: goto L_0x0031;
                case 24: goto L_0x0032;
                case 27: goto L_0x0031;
                case 132: goto L_0x0031;
                case 133: goto L_0x0031;
                case 134: goto L_0x0031;
                case 135: goto L_0x0031;
                case 136: goto L_0x0031;
                case 137: goto L_0x0031;
                case 138: goto L_0x0031;
                case 139: goto L_0x0031;
                case 140: goto L_0x0031;
                case 141: goto L_0x0031;
                case 142: goto L_0x0031;
                case 143: goto L_0x0031;
                case 144: goto L_0x0031;
                case 145: goto L_0x0031;
                case 146: goto L_0x0031;
                case 147: goto L_0x0031;
                case 148: goto L_0x0031;
                case 149: goto L_0x0031;
                case 150: goto L_0x0031;
                case 151: goto L_0x0031;
                case 152: goto L_0x0031;
                case 153: goto L_0x0031;
                case 154: goto L_0x0031;
                case 155: goto L_0x0031;
                case 156: goto L_0x002f;
                case 157: goto L_0x002f;
                case 158: goto L_0x002f;
                case 159: goto L_0x002f;
                case 160: goto L_0x002f;
                case 161: goto L_0x002f;
                case 162: goto L_0x002f;
                case 163: goto L_0x002f;
                case 164: goto L_0x002f;
                case 165: goto L_0x002f;
                case 166: goto L_0x002f;
                case 167: goto L_0x002f;
                case 168: goto L_0x002f;
                case 169: goto L_0x002f;
                case 170: goto L_0x002f;
                case 171: goto L_0x002f;
                case 172: goto L_0x002f;
                case 173: goto L_0x002f;
                case 174: goto L_0x002d;
                case 175: goto L_0x002c;
                case 176: goto L_0x002d;
                case 177: goto L_0x002c;
                case 178: goto L_0x002d;
                case 179: goto L_0x002c;
                case 180: goto L_0x002d;
                case 181: goto L_0x002c;
                case 182: goto L_0x002d;
                case 183: goto L_0x002c;
                case 184: goto L_0x002d;
                case 185: goto L_0x002c;
                case 186: goto L_0x002d;
                case 187: goto L_0x002d;
                case 188: goto L_0x002d;
                case 189: goto L_0x002d;
                case 190: goto L_0x002d;
                case 191: goto L_0x002d;
                case 192: goto L_0x002d;
                case 193: goto L_0x002d;
                case 194: goto L_0x002d;
                case 195: goto L_0x002d;
                case 196: goto L_0x002d;
                case 197: goto L_0x002d;
                default: goto L_0x000f;
            }
        L_0x000f:
            switch(r4) {
                case 44: goto L_0x0031;
                case 45: goto L_0x0031;
                case 46: goto L_0x0031;
                case 47: goto L_0x0031;
                case 48: goto L_0x0031;
                case 49: goto L_0x0031;
                case 50: goto L_0x0031;
                case 51: goto L_0x0031;
                case 52: goto L_0x0031;
                case 53: goto L_0x0031;
                case 54: goto L_0x0031;
                case 55: goto L_0x0031;
                case 56: goto L_0x0031;
                case 57: goto L_0x0031;
                case 58: goto L_0x0031;
                case 59: goto L_0x002d;
                case 60: goto L_0x002d;
                case 61: goto L_0x002d;
                case 62: goto L_0x002d;
                case 63: goto L_0x002d;
                case 64: goto L_0x002d;
                case 65: goto L_0x0031;
                case 66: goto L_0x0031;
                case 67: goto L_0x0031;
                case 68: goto L_0x0031;
                case 69: goto L_0x0031;
                case 70: goto L_0x0031;
                default: goto L_0x0012;
            }
        L_0x0012:
            switch(r4) {
                case 103: goto L_0x002d;
                case 104: goto L_0x002d;
                case 105: goto L_0x002d;
                case 106: goto L_0x002d;
                case 107: goto L_0x002d;
                case 108: goto L_0x002d;
                case 109: goto L_0x002d;
                default: goto L_0x0015;
            }
        L_0x0015:
            switch(r4) {
                case 49153: goto L_0x0031;
                case 49154: goto L_0x0031;
                case 49155: goto L_0x0031;
                case 49156: goto L_0x0031;
                case 49157: goto L_0x0031;
                case 49158: goto L_0x0031;
                case 49159: goto L_0x0031;
                case 49160: goto L_0x0031;
                case 49161: goto L_0x0031;
                case 49162: goto L_0x0031;
                case 49163: goto L_0x0031;
                case 49164: goto L_0x0031;
                case 49165: goto L_0x0031;
                case 49166: goto L_0x0031;
                case 49167: goto L_0x0031;
                case 49168: goto L_0x0031;
                case 49169: goto L_0x0031;
                case 49170: goto L_0x0031;
                case 49171: goto L_0x0031;
                case 49172: goto L_0x0031;
                case 49173: goto L_0x0031;
                case 49174: goto L_0x0031;
                case 49175: goto L_0x0031;
                case 49176: goto L_0x0031;
                case 49177: goto L_0x0031;
                case 49178: goto L_0x0031;
                case 49179: goto L_0x0031;
                case 49180: goto L_0x0031;
                case 49181: goto L_0x0031;
                case 49182: goto L_0x0031;
                case 49183: goto L_0x0031;
                case 49184: goto L_0x0031;
                case 49185: goto L_0x0031;
                case 49186: goto L_0x0031;
                case 49187: goto L_0x002d;
                case 49188: goto L_0x002c;
                case 49189: goto L_0x002d;
                case 49190: goto L_0x002c;
                case 49191: goto L_0x002d;
                case 49192: goto L_0x002c;
                case 49193: goto L_0x002d;
                case 49194: goto L_0x002c;
                case 49195: goto L_0x002f;
                case 49196: goto L_0x002f;
                case 49197: goto L_0x002f;
                case 49198: goto L_0x002f;
                case 49199: goto L_0x002f;
                case 49200: goto L_0x002f;
                case 49201: goto L_0x002f;
                case 49202: goto L_0x002f;
                case 49203: goto L_0x0031;
                case 49204: goto L_0x0031;
                case 49205: goto L_0x0031;
                case 49206: goto L_0x0031;
                case 49207: goto L_0x002d;
                case 49208: goto L_0x002c;
                case 49209: goto L_0x0031;
                case 49210: goto L_0x002d;
                case 49211: goto L_0x002c;
                default: goto L_0x0018;
            }
        L_0x0018:
            switch(r4) {
                case 49266: goto L_0x002d;
                case 49267: goto L_0x002c;
                case 49268: goto L_0x002d;
                case 49269: goto L_0x002c;
                case 49270: goto L_0x002d;
                case 49271: goto L_0x002c;
                case 49272: goto L_0x002d;
                case 49273: goto L_0x002c;
                case 49274: goto L_0x002f;
                case 49275: goto L_0x002f;
                case 49276: goto L_0x002f;
                case 49277: goto L_0x002f;
                case 49278: goto L_0x002f;
                case 49279: goto L_0x002f;
                case 49280: goto L_0x002f;
                case 49281: goto L_0x002f;
                case 49282: goto L_0x002f;
                case 49283: goto L_0x002f;
                case 49284: goto L_0x002f;
                case 49285: goto L_0x002f;
                case 49286: goto L_0x002f;
                case 49287: goto L_0x002f;
                case 49288: goto L_0x002f;
                case 49289: goto L_0x002f;
                case 49290: goto L_0x002f;
                case 49291: goto L_0x002f;
                case 49292: goto L_0x002f;
                case 49293: goto L_0x002f;
                case 49294: goto L_0x002f;
                case 49295: goto L_0x002f;
                case 49296: goto L_0x002f;
                case 49297: goto L_0x002f;
                case 49298: goto L_0x002f;
                case 49299: goto L_0x002f;
                case 49300: goto L_0x002d;
                case 49301: goto L_0x002c;
                case 49302: goto L_0x002d;
                case 49303: goto L_0x002c;
                case 49304: goto L_0x002d;
                case 49305: goto L_0x002c;
                case 49306: goto L_0x002d;
                case 49307: goto L_0x002c;
                case 49308: goto L_0x002f;
                case 49309: goto L_0x002f;
                case 49310: goto L_0x002f;
                case 49311: goto L_0x002f;
                case 49312: goto L_0x002f;
                case 49313: goto L_0x002f;
                case 49314: goto L_0x002f;
                case 49315: goto L_0x002f;
                case 49316: goto L_0x002f;
                case 49317: goto L_0x002f;
                case 49318: goto L_0x002f;
                case 49319: goto L_0x002f;
                case 49320: goto L_0x002f;
                case 49321: goto L_0x002f;
                case 49322: goto L_0x002f;
                case 49323: goto L_0x002f;
                case 49324: goto L_0x002f;
                case 49325: goto L_0x002f;
                case 49326: goto L_0x002f;
                case 49327: goto L_0x002f;
                default: goto L_0x001b;
            }
        L_0x001b:
            switch(r4) {
                case 52392: goto L_0x002f;
                case 52393: goto L_0x002f;
                case 52394: goto L_0x002f;
                case 52395: goto L_0x002f;
                case 52396: goto L_0x002f;
                case 52397: goto L_0x002f;
                case 52398: goto L_0x002f;
                default: goto L_0x001e;
            }
        L_0x001e:
            switch(r4) {
                case 65280: goto L_0x002f;
                case 65281: goto L_0x002f;
                case 65282: goto L_0x002f;
                case 65283: goto L_0x002f;
                case 65284: goto L_0x002f;
                case 65285: goto L_0x002f;
                default: goto L_0x0021;
            }
        L_0x0021:
            switch(r4) {
                case 65296: goto L_0x002f;
                case 65297: goto L_0x002f;
                case 65298: goto L_0x002f;
                case 65299: goto L_0x002f;
                case 65300: goto L_0x002f;
                case 65301: goto L_0x002f;
                default: goto L_0x0024;
            }
        L_0x0024:
            org.bouncycastle.crypto.tls.TlsFatalAlert r4 = new org.bouncycastle.crypto.tls.TlsFatalAlert
            r0 = 80
            r4.<init>(r0)
            throw r4
        L_0x002c:
            return r2
        L_0x002d:
            r4 = 3
            return r4
        L_0x002f:
            r4 = 0
            return r4
        L_0x0031:
            return r1
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.tls.m1.E(int):int");
    }

    public static void E0(long j, byte[] bArr, int i) {
        bArr[i] = (byte) (j >>> 56);
        bArr[i + 1] = (byte) (j >>> 48);
        bArr[i + 2] = (byte) (j >>> 40);
        bArr[i + 3] = (byte) (j >>> 32);
        bArr[i + 4] = (byte) (j >>> 24);
        bArr[i + 5] = (byte) (j >>> 16);
        bArr[i + 6] = (byte) (j >>> 8);
        bArr[i + 7] = (byte) j;
    }

    public static x F(int i) {
        switch (i) {
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
                break;
            default:
                switch (i) {
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                        break;
                    default:
                        switch (i) {
                            case 156:
                            case 157:
                            case 158:
                            case 159:
                            case 160:
                            case 161:
                            case 162:
                            case 163:
                            case 164:
                            case 165:
                            case 166:
                            case 167:
                            case 168:
                            case 169:
                            case 170:
                            case 171:
                            case 172:
                            case 173:
                                break;
                            default:
                                switch (i) {
                                    case 186:
                                    case 187:
                                    case 188:
                                    case 189:
                                    case 190:
                                    case 191:
                                    case 192:
                                    case 193:
                                    case 194:
                                    case 195:
                                    case 196:
                                    case 197:
                                        break;
                                    default:
                                        switch (i) {
                                            case 49187:
                                            case 49188:
                                            case 49189:
                                            case 49190:
                                            case 49191:
                                            case 49192:
                                            case 49193:
                                            case 49194:
                                            case 49195:
                                            case 49196:
                                            case 49197:
                                            case 49198:
                                            case 49199:
                                            case 49200:
                                            case 49201:
                                            case 49202:
                                                break;
                                            default:
                                                switch (i) {
                                                    case 49266:
                                                    case 49267:
                                                    case 49268:
                                                    case 49269:
                                                    case 49270:
                                                    case 49271:
                                                    case 49272:
                                                    case 49273:
                                                    case 49274:
                                                    case 49275:
                                                    case 49276:
                                                    case 49277:
                                                    case 49278:
                                                    case 49279:
                                                    case 49280:
                                                    case 49281:
                                                    case 49282:
                                                    case 49283:
                                                    case 49284:
                                                    case 49285:
                                                    case 49286:
                                                    case 49287:
                                                    case 49288:
                                                    case 49289:
                                                    case 49290:
                                                    case 49291:
                                                    case 49292:
                                                    case 49293:
                                                    case 49294:
                                                    case 49295:
                                                    case 49296:
                                                    case 49297:
                                                    case 49298:
                                                    case 49299:
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case 49308:
                                                            case 49309:
                                                            case 49310:
                                                            case 49311:
                                                            case 49312:
                                                            case 49313:
                                                            case 49314:
                                                            case 49315:
                                                            case 49316:
                                                            case 49317:
                                                            case 49318:
                                                            case 49319:
                                                            case 49320:
                                                            case 49321:
                                                            case 49322:
                                                            case 49323:
                                                            case 49324:
                                                            case 49325:
                                                            case 49326:
                                                            case 49327:
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 52392:
                                                                    case 52393:
                                                                    case 52394:
                                                                    case 52395:
                                                                    case 52396:
                                                                    case 52397:
                                                                    case 52398:
                                                                        break;
                                                                    default:
                                                                        switch (i) {
                                                                            case MotionEventCompat.ACTION_POINTER_INDEX_MASK /* 65280 */:
                                                                            case 65281:
                                                                            case 65282:
                                                                            case 65283:
                                                                            case 65284:
                                                                            case 65285:
                                                                                break;
                                                                            default:
                                                                                switch (i) {
                                                                                    case 65296:
                                                                                    case 65297:
                                                                                    case 65298:
                                                                                    case 65299:
                                                                                    case 65300:
                                                                                    case 65301:
                                                                                        break;
                                                                                    default:
                                                                                        return x.a;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
        return x.f17285d;
    }

    public static void F0(int i, OutputStream outputStream) throws IOException {
        outputStream.write(i);
    }

    public static d0 G(p0 p0Var, k1 k1Var) throws IOException {
        if (!P(p0Var)) {
            return null;
        }
        d0 a2 = k1Var.a();
        if (a2 != null) {
            return a2;
        }
        throw new TlsFatalAlert((short) 80);
    }

    public static void G0(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
    }

    public static boolean H(Hashtable hashtable, Integer num, short s) throws IOException {
        byte[] B = B(hashtable, num);
        if (B == null) {
            return false;
        }
        if (B.length == 0) {
            return true;
        }
        throw new TlsFatalAlert(s);
    }

    public static void H0(short s, OutputStream outputStream) throws IOException {
        outputStream.write(s);
    }

    static void I(g gVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        b bVar = new b(gVar);
        bVar.d(new a0(bArr));
        int e2 = gVar.e();
        int length = ((bArr3.length + e2) - 1) / e2;
        int a2 = bVar.a();
        byte[] bArr4 = new byte[a2];
        byte[] bArr5 = new byte[bVar.a()];
        byte[] bArr6 = bArr2;
        int i = 0;
        while (i < length) {
            bVar.update(bArr6, 0, bArr6.length);
            bVar.doFinal(bArr4, 0);
            bVar.update(bArr4, 0, a2);
            bVar.update(bArr2, 0, bArr2.length);
            bVar.doFinal(bArr5, 0);
            int i2 = e2 * i;
            System.arraycopy(bArr5, 0, bArr3, i2, Math.min(e2, bArr3.length - i2));
            i++;
            bArr6 = bArr4;
        }
    }

    public static void I0(short s, byte[] bArr, int i) {
        bArr[i] = (byte) s;
    }

    public static boolean J(int i) throws IOException {
        return 1 == v(i);
    }

    public static void J0(short[] sArr, OutputStream outputStream) throws IOException {
        for (short s : sArr) {
            H0(s, outputStream);
        }
    }

    public static boolean K(p0 p0Var) {
        return p0Var.b().i();
    }

    public static void K0(short[] sArr, byte[] bArr, int i) throws IOException {
        for (short s : sArr) {
            I0(s, bArr, i);
            i++;
        }
    }

    public static boolean L(x xVar) {
        return x.f17285d.h(xVar.c());
    }

    public static void L0(short[] sArr, OutputStream outputStream) throws IOException {
        k(sArr.length);
        F0(sArr.length, outputStream);
        J0(sArr, outputStream);
    }

    public static boolean M(x xVar) {
        return x.f17284c.h(xVar.c());
    }

    public static void M0(short[] sArr, byte[] bArr, int i) throws IOException {
        k(sArr.length);
        G0(sArr.length, bArr, i);
        K0(sArr, bArr, i + 1);
    }

    public static boolean N(p0 p0Var) {
        return M(p0Var.b());
    }

    public static void N0(x xVar, OutputStream outputStream) throws IOException {
        outputStream.write(xVar.d());
        outputStream.write(xVar.e());
    }

    public static boolean O(x xVar) {
        return x.f17285d.h(xVar.c());
    }

    public static void O0(x xVar, byte[] bArr, int i) {
        bArr[i] = (byte) xVar.d();
        bArr[i + 1] = (byte) xVar.e();
    }

    public static boolean P(p0 p0Var) {
        return O(p0Var.b());
    }

    public static boolean Q(int i, x xVar) {
        return F(i).h(xVar.c());
    }

    public static boolean R(int i) {
        return (65535 & i) == i;
    }

    public static boolean S(int i) {
        return (16777215 & i) == i;
    }

    public static boolean T(int i) {
        return (i & 255) == i;
    }

    public static boolean U(short s) {
        return (s & 255) == s;
    }

    public static Vector V(boolean z, InputStream inputStream) throws IOException {
        int d0 = d0(inputStream);
        if (d0 < 2 || (d0 & 1) != 0) {
            throw new TlsFatalAlert((short) 50);
        }
        int i = d0 / 2;
        Vector vector = new Vector(i);
        for (int i2 = 0; i2 < i; i2++) {
            d0 d2 = d0.d(inputStream);
            if (z || d2.c() != 0) {
                vector.addElement(d2);
            } else {
                throw new TlsFatalAlert((short) 47);
            }
        }
        return vector;
    }

    public static q W(byte[] bArr) throws IOException {
        i iVar = new i(bArr);
        q t = iVar.t();
        if (t == null) {
            throw new TlsFatalAlert((short) 50);
        } else if (iVar.t() == null) {
            return t;
        } else {
            throw new TlsFatalAlert((short) 50);
        }
    }

    public static byte[] X(int i, InputStream inputStream) throws IOException {
        if (i < 1) {
            return a;
        }
        byte[] bArr = new byte[i];
        int c2 = org.bouncycastle.util.io.b.c(inputStream, bArr);
        if (c2 == 0) {
            return null;
        }
        if (c2 == i) {
            return bArr;
        }
        throw new EOFException();
    }

    public static q Y(byte[] bArr) throws IOException {
        q W = W(bArr);
        if (a.c(W.e("DER"), bArr)) {
            return W;
        }
        throw new TlsFatalAlert((short) 50);
    }

    public static byte[] Z(int i, InputStream inputStream) throws IOException {
        if (i < 1) {
            return a;
        }
        byte[] bArr = new byte[i];
        if (i == org.bouncycastle.util.io.b.c(inputStream, bArr)) {
            return bArr;
        }
        throw new EOFException();
    }

    public static byte[] a(p0 p0Var, byte[] bArr, String str, byte[] bArr2, int i) {
        if (!p0Var.b().i()) {
            byte[] e2 = org.bouncycastle.util.i.e(str);
            byte[] m = m(e2, bArr2);
            int g2 = p0Var.e().g();
            if (g2 == 0) {
                return b(bArr, e2, m, i);
            }
            byte[] bArr3 = new byte[i];
            I(o(g2), bArr, m, bArr3);
            return bArr3;
        }
        throw new IllegalStateException("No PRF available for SSLv3 session");
    }

    public static byte[] a0(InputStream inputStream) throws IOException {
        return Z(d0(inputStream), inputStream);
    }

    static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        int length = (bArr.length + 1) / 2;
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr, 0, bArr4, 0, length);
        System.arraycopy(bArr, bArr.length - length, bArr5, 0, length);
        byte[] bArr6 = new byte[i];
        byte[] bArr7 = new byte[i];
        I(n((short) 1), bArr4, bArr3, bArr6);
        I(n((short) 2), bArr5, bArr3, bArr7);
        for (int i2 = 0; i2 < i; i2++) {
            bArr6[i2] = (byte) (bArr6[i2] ^ bArr7[i2]);
        }
        return bArr6;
    }

    public static byte[] b0(InputStream inputStream) throws IOException {
        return Z(g0(inputStream), inputStream);
    }

    public static void c(Hashtable hashtable, Vector vector) throws IOException {
        hashtable.put(f17262e, p(vector));
    }

    public static byte[] c0(InputStream inputStream) throws IOException {
        return Z(j0(inputStream), inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] d(p0 p0Var, int i) {
        a0 e2 = p0Var.e();
        byte[] e3 = e2.e();
        byte[] m = m(e2.i(), e2.c());
        return K(p0Var) ? e(e3, m, i) : a(p0Var, e3, "key expansion", m, i);
    }

    public static int d0(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if (read2 >= 0) {
            return read2 | (read << 8);
        }
        throw new EOFException();
    }

    static byte[] e(byte[] bArr, byte[] bArr2, int i) {
        g n = n((short) 1);
        g n2 = n((short) 2);
        int e2 = n.e();
        int e3 = n2.e();
        byte[] bArr3 = new byte[e3];
        byte[] bArr4 = new byte[i + e2];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            byte[] bArr5 = h[i3];
            n2.update(bArr5, 0, bArr5.length);
            n2.update(bArr, 0, bArr.length);
            n2.update(bArr2, 0, bArr2.length);
            n2.doFinal(bArr3, 0);
            n.update(bArr, 0, bArr.length);
            n.update(bArr3, 0, e3);
            n.doFinal(bArr4, i2);
            i2 += e2;
            i3++;
        }
        return a.s(bArr4, 0, i);
    }

    public static int e0(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] f(p0 p0Var, byte[] bArr) {
        a0 e2 = p0Var.e();
        byte[] j = e2.o ? e2.j() : m(e2.c(), e2.i());
        if (K(p0Var)) {
            return g(bArr, j);
        }
        return a(p0Var, bArr, e2.o ? "extended master secret" : "master secret", j, 48);
    }

    public static int[] f0(int i, InputStream inputStream) throws IOException {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = d0(inputStream);
        }
        return iArr;
    }

    static byte[] g(byte[] bArr, byte[] bArr2) {
        g n = n((short) 1);
        g n2 = n((short) 2);
        int e2 = n.e();
        int e3 = n2.e();
        byte[] bArr3 = new byte[e3];
        byte[] bArr4 = new byte[e2 * 3];
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            byte[] bArr5 = h[i2];
            n2.update(bArr5, 0, bArr5.length);
            n2.update(bArr, 0, bArr.length);
            n2.update(bArr2, 0, bArr2.length);
            n2.doFinal(bArr3, 0);
            n.update(bArr, 0, bArr.length);
            n.update(bArr3, 0, e3);
            n.doFinal(bArr4, i);
            i += e2;
        }
        return bArr4;
    }

    public static int g0(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        if (read3 >= 0) {
            return read3 | (read << 16) | (read2 << 8);
        }
        throw new EOFException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] h(p0 p0Var, String str, byte[] bArr) {
        if (K(p0Var)) {
            return bArr;
        }
        a0 e2 = p0Var.e();
        return a(p0Var, e2.e(), str, bArr, e2.k());
    }

    public static int h0(byte[] bArr, int i) {
        int i2 = i + 1;
        return (bArr[i2 + 1] & 255) | ((bArr[i] & 255) << 16) | ((bArr[i2] & 255) << 8);
    }

    public static void i(int i) throws IOException {
        if (!R(i)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static long i0(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if (read4 >= 0) {
            return (read4 | (read << 24) | (read2 << 16) | (read3 << 8)) & 4294967295L;
        }
        throw new EOFException();
    }

    public static void j(int i) throws IOException {
        if (!S(i)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static short j0(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read >= 0) {
            return (short) read;
        }
        throw new EOFException();
    }

    public static void k(int i) throws IOException {
        if (!T(i)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static short k0(byte[] bArr, int i) {
        return (short) (bArr[i] & 255);
    }

    public static g l(short s, g gVar) {
        switch (s) {
            case 1:
                return new org.bouncycastle.crypto.p.d((org.bouncycastle.crypto.p.d) gVar);
            case 2:
                return new e((e) gVar);
            case 3:
                return new f((f) gVar);
            case 4:
                return new org.bouncycastle.crypto.p.g((org.bouncycastle.crypto.p.g) gVar);
            case 5:
                return new h((h) gVar);
            case 6:
                return new org.bouncycastle.crypto.p.i((org.bouncycastle.crypto.p.i) gVar);
            default:
                throw new IllegalArgumentException("unknown HashAlgorithm");
        }
    }

    public static short[] l0(int i, InputStream inputStream) throws IOException {
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = j0(inputStream);
        }
        return sArr;
    }

    static byte[] m(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static x m0(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if (read2 >= 0) {
            return x.b(read, read2);
        }
        throw new EOFException();
    }

    public static g n(short s) {
        switch (s) {
            case 1:
                return new org.bouncycastle.crypto.p.d();
            case 2:
                return new e();
            case 3:
                return new f();
            case 4:
                return new org.bouncycastle.crypto.p.g();
            case 5:
                return new h();
            case 6:
                return new org.bouncycastle.crypto.p.i();
            default:
                throw new IllegalArgumentException("unknown HashAlgorithm");
        }
    }

    public static x n0(byte[] bArr, int i) throws IOException {
        return x.b(bArr[i] & 255, bArr[i + 1] & 255);
    }

    public static g o(int i) {
        return i != 0 ? n(C(i)) : new m();
    }

    public static int o0(byte[] bArr, int i) throws IOException {
        return bArr[i + 1] | (bArr[i] << 8);
    }

    public static byte[] p(Vector vector) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        r(vector, false, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void p0(v0 v0Var, Vector vector) {
        if (vector != null) {
            for (int i = 0; i < vector.size(); i++) {
                short b2 = ((d0) vector.elementAt(i)).b();
                if (!s.c(b2)) {
                    v0Var.h(b2);
                }
            }
        }
    }

    public static byte[] q(byte[] bArr) throws IOException {
        k(bArr.length);
        return a.E(bArr, (byte) bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void q0(org.bouncycastle.asn1.x509.h hVar, int i) throws IOException {
        t f2;
        m g2 = hVar.o().g();
        if (g2 != null && (f2 = t.f(g2)) != null && (f2.g()[0] & 255 & i) != i) {
            throw new TlsFatalAlert((short) 46);
        }
    }

    public static void r(Vector vector, boolean z, OutputStream outputStream) throws IOException {
        if (vector == null || vector.size() < 1 || vector.size() >= 32768) {
            throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
        }
        int size = vector.size() * 2;
        i(size);
        w0(size, outputStream);
        for (int i = 0; i < vector.size(); i++) {
            d0 d0Var = (d0) vector.elementAt(i);
            if (z || d0Var.c() != 0) {
                d0Var.a(outputStream);
            } else {
                throw new IllegalArgumentException("SignatureAlgorithm.anonymous MUST NOT appear in the signature_algorithms extension");
            }
        }
    }

    private static Vector r0(Object obj) {
        Vector vector = new Vector(1);
        vector.addElement(obj);
        return vector;
    }

    public static byte[] s(int[] iArr) throws IOException {
        byte[] bArr = new byte[(iArr.length * 2) + 2];
        B0(iArr, bArr, 0);
        return bArr;
    }

    public static void s0(byte[] bArr, int i) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        bArr[i] = (byte) (currentTimeMillis >>> 24);
        bArr[i + 1] = (byte) (currentTimeMillis >>> 16);
        bArr[i + 2] = (byte) (currentTimeMillis >>> 8);
        bArr[i + 3] = (byte) currentTimeMillis;
    }

    public static byte[] t(short[] sArr) throws IOException {
        byte[] bArr = new byte[sArr.length + 1];
        M0(sArr, bArr, 0);
        return bArr;
    }

    public static void t0(byte[] bArr, OutputStream outputStream) throws IOException {
        i(bArr.length);
        w0(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    private static byte[][] u() {
        byte[][] bArr = new byte[10];
        int i = 0;
        while (i < 10) {
            int i2 = i + 1;
            byte[] bArr2 = new byte[i2];
            a.u(bArr2, (byte) (i + 65));
            bArr[i] = bArr2;
            i = i2;
        }
        return bArr;
    }

    public static void u0(byte[] bArr, OutputStream outputStream) throws IOException {
        j(bArr.length);
        C0(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    public static int v(int i) throws IOException {
        int A = A(i);
        if (A == 103 || A == 104) {
            return 2;
        }
        switch (A) {
            case 0:
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 12:
            case 13:
            case 14:
                return 1;
            case 10:
            case 11:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return 2;
            default:
                throw new TlsFatalAlert((short) 80);
        }
    }

    public static void v0(byte[] bArr, OutputStream outputStream) throws IOException {
        k(bArr.length);
        F0(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    public static Vector w() {
        return r0(new d0((short) 2, (short) 2));
    }

    public static void w0(int i, OutputStream outputStream) throws IOException {
        outputStream.write(i >>> 8);
        outputStream.write(i);
    }

    public static Vector x() {
        return r0(new d0((short) 2, (short) 3));
    }

    public static void x0(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
    }

    public static Vector y() {
        return r0(new d0((short) 2, (short) 1));
    }

    public static void y0(int[] iArr, OutputStream outputStream) throws IOException {
        for (int i : iArr) {
            w0(i, outputStream);
        }
    }

    public static Vector z() {
        short[] sArr = {2, 3, 4, 5, 6};
        short[] sArr2 = {1, 2, 3};
        Vector vector = new Vector();
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 5; i2++) {
                vector.addElement(new d0(sArr[i2], sArr2[i]));
            }
        }
        return vector;
    }

    public static void z0(int[] iArr, byte[] bArr, int i) throws IOException {
        for (int i2 : iArr) {
            x0(i2, bArr, i);
            i += 2;
        }
    }
}
