package org.bouncycastle.crypto.prng.j;

import java.util.Hashtable;
import org.bouncycastle.crypto.g;
import org.bouncycastle.crypto.j;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes4.dex */
class d {
    static final Hashtable a;

    static {
        Hashtable hashtable = new Hashtable();
        a = hashtable;
        hashtable.put("SHA-1", org.bouncycastle.util.d.b(128));
        hashtable.put("SHA-224", org.bouncycastle.util.d.b(192));
        hashtable.put("SHA-256", org.bouncycastle.util.d.b(256));
        hashtable.put("SHA-384", org.bouncycastle.util.d.b(256));
        hashtable.put("SHA-512", org.bouncycastle.util.d.b(256));
        hashtable.put("SHA-512/224", org.bouncycastle.util.d.b(192));
        hashtable.put("SHA-512/256", org.bouncycastle.util.d.b(256));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(g gVar) {
        return ((Integer) a.get(gVar.b())).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(j jVar) {
        String b2 = jVar.b();
        return ((Integer) a.get(b2.substring(0, b2.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR)))).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] c(g gVar, byte[] bArr, int i) {
        int i2 = (i + 7) / 8;
        byte[] bArr2 = new byte[i2];
        int e2 = i2 / gVar.e();
        int e3 = gVar.e();
        byte[] bArr3 = new byte[e3];
        int i3 = 1;
        int i4 = 0;
        for (int i5 = 0; i5 <= e2; i5++) {
            gVar.c((byte) i3);
            gVar.c((byte) (i >> 24));
            gVar.c((byte) (i >> 16));
            gVar.c((byte) (i >> 8));
            gVar.c((byte) i);
            gVar.update(bArr, 0, bArr.length);
            gVar.doFinal(bArr3, 0);
            int i6 = i5 * e3;
            int i7 = i2 - i6;
            if (i7 > e3) {
                i7 = e3;
            }
            System.arraycopy(bArr3, 0, bArr2, i6, i7);
            i3++;
        }
        int i8 = i % 8;
        if (i8 != 0) {
            int i9 = 8 - i8;
            int i10 = 0;
            while (i4 != i2) {
                int i11 = bArr2[i4] & 255;
                bArr2[i4] = (byte) ((i10 << (8 - i9)) | (i11 >>> i9));
                i4++;
                i10 = i11;
            }
        }
        return bArr2;
    }
}
