package org.bouncycastle.asn1;

import com.tplink.libtpmediastatistics.SSLClient;
import java.io.IOException;
import org.bouncycastle.util.encoders.d;

/* loaded from: classes4.dex */
public class l0 extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(boolean z, int i, byte[] bArr) {
        super(z, i, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.a, org.bouncycastle.asn1.q
    public void g(p pVar) throws IOException {
        pVar.f(this.f16678c ? 96 : 64, this.f16679d, this.f16680f);
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        if (j()) {
            stringBuffer.append("CONSTRUCTED ");
        }
        stringBuffer.append("APPLICATION ");
        stringBuffer.append(Integer.toString(m()));
        stringBuffer.append("]");
        if (this.f16680f != null) {
            stringBuffer.append(" #");
            str = d.d(this.f16680f);
        } else {
            str = " #null";
        }
        stringBuffer.append(str);
        stringBuffer.append(SSLClient.WHITE_SPACE);
        return stringBuffer.toString();
    }
}
