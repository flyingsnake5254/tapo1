package org.apache.commons.io.filefilter;

import com.tplink.libtpmediastatistics.SSLClient;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class MagicNumberFileFilter extends a implements Serializable {
    private static final long serialVersionUID = -547733176983104172L;
    private final long byteOffset;
    private final byte[] magicNumbers;

    public MagicNumberFileFilter(byte[] bArr) {
        this(bArr, 0L);
    }

    @Override // org.apache.commons.io.filefilter.a, org.apache.commons.io.filefilter.b, java.io.FileFilter
    public boolean accept(File file) {
        if (file != null && file.isFile() && file.canRead()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                byte[] bArr = new byte[this.magicNumbers.length];
                randomAccessFile.seek(this.byteOffset);
                int read = randomAccessFile.read(bArr);
                byte[] bArr2 = this.magicNumbers;
                if (read != bArr2.length) {
                    randomAccessFile.close();
                    return false;
                }
                boolean equals = Arrays.equals(bArr2, bArr);
                randomAccessFile.close();
                return equals;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // org.apache.commons.io.filefilter.a
    public String toString() {
        return super.toString() + "(" + new String(this.magicNumbers, Charset.defaultCharset()) + SSLClient.COMMA + this.byteOffset + ")";
    }

    public MagicNumberFileFilter(String str) {
        this(str, 0L);
    }

    public MagicNumberFileFilter(String str, long j) {
        if (str == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        } else if (j >= 0) {
            this.magicNumbers = str.getBytes(Charset.defaultCharset());
            this.byteOffset = j;
        } else {
            throw new IllegalArgumentException("The offset cannot be negative");
        }
    }

    public MagicNumberFileFilter(byte[] bArr, long j) {
        if (bArr == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        } else if (bArr.length == 0) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        } else if (j >= 0) {
            byte[] bArr2 = new byte[bArr.length];
            this.magicNumbers = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.byteOffset = j;
        } else {
            throw new IllegalArgumentException("The offset cannot be negative");
        }
    }
}
