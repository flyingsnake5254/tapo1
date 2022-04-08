package b.d.r.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: H264Reader.java */
/* loaded from: classes3.dex */
public class d {
    private a a;

    /* compiled from: H264Reader.java */
    /* loaded from: classes3.dex */
    public interface a {
        void c(byte[] bArr, long j);
    }

    public d(a aVar) {
        this.a = aVar;
    }

    public void a(byte[] bArr, long j) {
        if (bArr != null && bArr.length >= 5) {
            int length = bArr.length;
            int i = 5;
            while (i < length - 4) {
                if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 1) {
                    byte[] bArr2 = new byte[i];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    a aVar = this.a;
                    if (aVar != null) {
                        aVar.c(bArr2, j);
                    }
                    length -= i;
                    System.arraycopy(bArr, i, bArr, 0, length);
                    i = 5;
                }
                i++;
            }
            if (length > 5) {
                byte[] bArr3 = new byte[length];
                System.arraycopy(bArr, 0, bArr3, 0, length);
                a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.c(bArr3, j);
                }
            }
        }
    }

    public List<byte[]> b(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        if (bArr != null && bArr.length >= 5) {
            int length = bArr.length;
            int i = 5;
            while (i < length - 4) {
                if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 1) {
                    byte[] bArr2 = new byte[i];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    arrayList.add(bArr2);
                    length -= i;
                    System.arraycopy(bArr, i, bArr, 0, length);
                    i = 5;
                }
                i++;
            }
            if (length > 5) {
                byte[] bArr3 = new byte[length];
                System.arraycopy(bArr, 0, bArr3, 0, length);
                arrayList.add(bArr3);
            }
        }
        return arrayList;
    }
}
