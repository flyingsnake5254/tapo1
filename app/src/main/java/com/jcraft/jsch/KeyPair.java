package com.jcraft.jsch;

import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes2.dex */
public abstract class KeyPair {
    public static final int DSA = 1;
    public static final int ECDSA = 3;
    public static final int ERROR = 0;
    public static final int RSA = 2;
    public static final int UNKNOWN = 4;
    static final int VENDOR_FSECURE = 1;
    static final int VENDOR_OPENSSH = 0;
    static final int VENDOR_PKCS8 = 3;
    static final int VENDOR_PUTTY = 2;
    private Cipher cipher;
    private HASH hash;
    JSch jsch;
    private byte[] passphrase;
    private Random random;
    private static final byte[] cr = Util.str2byte("\n");
    static byte[][] header = {Util.str2byte("Proc-Type: 4,ENCRYPTED"), Util.str2byte("DEK-Info: DES-EDE3-CBC,")};
    private static byte[] space = Util.str2byte(SSLClient.WHITE_SPACE);
    private static final String[] header1 = {"PuTTY-User-Key-File-2: ", "Encryption: ", "Comment: ", "Public-Lines: "};
    private static final String[] header2 = {"Private-Lines: "};
    private static final String[] header3 = {"Private-MAC: "};
    int vendor = 0;
    protected String publicKeyComment = "no comment";
    protected boolean encrypted = false;
    protected byte[] data = null;
    private byte[] iv = null;
    private byte[] publickeyblob = null;

    /* loaded from: classes2.dex */
    class ASN1 {
        byte[] buf;
        int length;
        int start;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ASN1(KeyPair keyPair, byte[] bArr) throws ASN1Exception {
            this(bArr, 0, bArr.length);
        }

        private int getLength(int[] iArr) {
            int i = iArr[0];
            int i2 = i + 1;
            int i3 = this.buf[i] & 255;
            if ((i3 & 128) != 0) {
                int i4 = i3 & 127;
                int i5 = 0;
                while (true) {
                    i4--;
                    if (i4 <= 0) {
                        break;
                    }
                    i2++;
                    i5 = (this.buf[i2] & 255) + (i5 << 8);
                }
                i3 = i5;
            }
            iArr[0] = i2;
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public byte[] getContent() {
            int[] iArr = {this.start + 1};
            int length = getLength(iArr);
            byte[] bArr = new byte[length];
            System.arraycopy(this.buf, iArr[0], bArr, 0, length);
            return bArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ASN1[] getContents() throws ASN1Exception {
            byte[] bArr = this.buf;
            int i = this.start;
            byte b2 = bArr[i];
            int[] iArr = new int[1];
            iArr[0] = i + 1;
            int length = getLength(iArr);
            if (b2 == 5) {
                return new ASN1[0];
            }
            int i2 = iArr[0];
            Vector vector = new Vector();
            while (length > 0) {
                int i3 = i2 + 1;
                iArr[0] = i3;
                int length2 = getLength(iArr);
                int i4 = iArr[0];
                int i5 = i4 - i3;
                vector.addElement(new ASN1(this.buf, i3 - 1, i5 + 1 + length2));
                i2 = i4 + length2;
                length = ((length - 1) - i5) - length2;
            }
            ASN1[] asn1Arr = new ASN1[vector.size()];
            for (int i6 = 0; i6 < vector.size(); i6++) {
                asn1Arr[i6] = (ASN1) vector.elementAt(i6);
            }
            return asn1Arr;
        }

        int getType() {
            return this.buf[this.start] & 255;
        }

        boolean isINTEGER() {
            return getType() == 2;
        }

        boolean isOBJECT() {
            return getType() == 6;
        }

        boolean isOCTETSTRING() {
            return getType() == 4;
        }

        boolean isSEQUENCE() {
            return getType() == 48;
        }

        ASN1(byte[] bArr, int i, int i2) throws ASN1Exception {
            this.buf = bArr;
            this.start = i;
            this.length = i2;
            if (i + i2 > bArr.length) {
                throw new ASN1Exception();
            }
        }
    }

    /* loaded from: classes2.dex */
    class ASN1Exception extends Exception {
        ASN1Exception() {
        }
    }

    public KeyPair(JSch jSch) {
        this.jsch = null;
        this.jsch = jSch;
    }

    private static byte a2b(byte b2) {
        return (byte) ((48 > b2 || b2 > 57) ? (b2 - 97) + 10 : b2 - 48);
    }

    private static byte b2a(byte b2) {
        return (byte) ((b2 < 0 || b2 > 9) ? (b2 - 10) + 65 : b2 + 48);
    }

    private byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            byte[] genKey = genKey(bArr2, bArr3);
            this.cipher.init(1, genKey, bArr3);
            Util.bzero(genKey);
            byte[] bArr4 = new byte[bArr.length];
            this.cipher.update(bArr, 0, bArr.length, bArr4, 0);
            return bArr4;
        } catch (Exception unused) {
            return null;
        }
    }

    private byte[] encrypt(byte[] bArr, byte[][] bArr2, byte[] bArr3) {
        if (bArr3 == null) {
            return bArr;
        }
        if (this.cipher == null) {
            this.cipher = genCipher();
        }
        int iVSize = this.cipher.getIVSize();
        byte[] bArr4 = new byte[iVSize];
        bArr2[0] = bArr4;
        if (this.random == null) {
            this.random = genRandom();
        }
        this.random.fill(bArr4, 0, iVSize);
        byte[] genKey = genKey(bArr3, bArr4);
        int iVSize2 = this.cipher.getIVSize();
        int length = ((bArr.length / iVSize2) + 1) * iVSize2;
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
        int length2 = iVSize2 - (bArr.length % iVSize2);
        for (int i = length - 1; length - length2 <= i; i--) {
            bArr5[i] = (byte) length2;
        }
        try {
            this.cipher.init(0, genKey, bArr4);
            this.cipher.update(bArr5, 0, length, bArr5, 0);
        } catch (Exception unused) {
        }
        Util.bzero(genKey);
        return bArr5;
    }

    private Cipher genCipher() {
        try {
            this.cipher = (Cipher) Class.forName(JSch.getConfig("3des-cbc")).newInstance();
        } catch (Exception unused) {
        }
        return this.cipher;
    }

    private HASH genHash() {
        try {
            HASH hash = (HASH) Class.forName(JSch.getConfig("md5")).newInstance();
            this.hash = hash;
            hash.init();
        } catch (Exception unused) {
        }
        return this.hash;
    }

    public static KeyPair genKeyPair(JSch jSch, int i) throws JSchException {
        return genKeyPair(jSch, i, 1024);
    }

    private Random genRandom() {
        if (this.random == null) {
            try {
                this.random = (Random) Class.forName(JSch.getConfig("random")).newInstance();
            } catch (Exception e2) {
                PrintStream printStream = System.err;
                printStream.println("connect: random " + e2);
            }
        }
        return this.random;
    }

    public static KeyPair load(JSch jSch, String str) throws JSchException {
        String str2 = str + ".pub";
        if (!new File(str2).exists()) {
            str2 = null;
        }
        return load(jSch, str, str2);
    }

    static KeyPair loadPPK(JSch jSch, byte[] bArr) throws JSchException {
        KeyPair keyPair;
        Buffer buffer = new Buffer(bArr);
        Hashtable hashtable = new Hashtable();
        do {
        } while (parseHeader(buffer, hashtable));
        String str = (String) hashtable.get("PuTTY-User-Key-File-2");
        if (str == null) {
            return null;
        }
        byte[] parseLines = parseLines(buffer, Integer.parseInt((String) hashtable.get("Public-Lines")));
        do {
        } while (parseHeader(buffer, hashtable));
        byte[] parseLines2 = parseLines(buffer, Integer.parseInt((String) hashtable.get("Private-Lines")));
        do {
        } while (parseHeader(buffer, hashtable));
        byte[] fromBase64 = Util.fromBase64(parseLines2, 0, parseLines2.length);
        byte[] fromBase642 = Util.fromBase64(parseLines, 0, parseLines.length);
        if (str.equals("ssh-rsa")) {
            Buffer buffer2 = new Buffer(fromBase642);
            buffer2.skip(fromBase642.length);
            buffer2.getByte(new byte[buffer2.getInt()]);
            byte[] bArr2 = new byte[buffer2.getInt()];
            buffer2.getByte(bArr2);
            byte[] bArr3 = new byte[buffer2.getInt()];
            buffer2.getByte(bArr3);
            keyPair = new KeyPairRSA(jSch, bArr3, bArr2, null);
        } else if (!str.equals("ssh-dss")) {
            return null;
        } else {
            Buffer buffer3 = new Buffer(fromBase642);
            buffer3.skip(fromBase642.length);
            buffer3.getByte(new byte[buffer3.getInt()]);
            byte[] bArr4 = new byte[buffer3.getInt()];
            buffer3.getByte(bArr4);
            byte[] bArr5 = new byte[buffer3.getInt()];
            buffer3.getByte(bArr5);
            byte[] bArr6 = new byte[buffer3.getInt()];
            buffer3.getByte(bArr6);
            byte[] bArr7 = new byte[buffer3.getInt()];
            buffer3.getByte(bArr7);
            keyPair = new KeyPairDSA(jSch, bArr4, bArr5, bArr6, bArr7, null);
        }
        keyPair.encrypted = !hashtable.get("Encryption").equals("none");
        keyPair.vendor = 2;
        keyPair.publicKeyComment = (String) hashtable.get("Comment");
        if (!keyPair.encrypted) {
            keyPair.data = fromBase64;
            keyPair.parse(fromBase64);
        } else if (Session.checkCipher(JSch.getConfig("aes256-cbc"))) {
            try {
                Cipher cipher = (Cipher) Class.forName(JSch.getConfig("aes256-cbc")).newInstance();
                keyPair.cipher = cipher;
                keyPair.iv = new byte[cipher.getIVSize()];
                keyPair.data = fromBase64;
            } catch (Exception unused) {
                throw new JSchException("The cipher 'aes256-cbc' is required, but it is not available.");
            }
        } else {
            throw new JSchException("The cipher 'aes256-cbc' is required, but it is not available.");
        }
        return keyPair;
    }

    private static boolean parseHeader(Buffer buffer, Hashtable hashtable) {
        String str;
        String str2;
        byte[] bArr = buffer.buffer;
        int i = buffer.index;
        int i2 = i;
        while (true) {
            str = null;
            if (i2 >= bArr.length || bArr[i2] == 13) {
                break;
            } else if (bArr[i2] == 58) {
                str2 = new String(bArr, i, i2 - i);
                i = i2 + 1;
                if (i < bArr.length && bArr[i] == 32) {
                    i++;
                }
            } else {
                i2++;
            }
        }
        str2 = null;
        if (str2 == null) {
            return false;
        }
        int i3 = i;
        while (true) {
            if (i3 >= bArr.length) {
                break;
            } else if (bArr[i3] == 13) {
                str = new String(bArr, i, i3 - i);
                i = i3 + 1;
                if (i < bArr.length && bArr[i] == 10) {
                    i++;
                }
            } else {
                i3++;
            }
        }
        if (str != null) {
            hashtable.put(str2, str);
            buffer.index = i;
        }
        return str != null;
    }

    private static byte[] parseLines(Buffer buffer, int i) {
        byte[] bArr = buffer.buffer;
        int i2 = buffer.index;
        byte[] bArr2 = null;
        while (true) {
            i--;
            if (i <= 0) {
                break;
            }
            i2 = i2;
            while (true) {
                if (bArr.length <= i2) {
                    break;
                }
                int i3 = i2 + 1;
                if (bArr[i2] == 13) {
                    if (bArr2 == null) {
                        int i4 = (i3 - i2) - 1;
                        bArr2 = new byte[i4];
                        System.arraycopy(bArr, i2, bArr2, 0, i4);
                    } else {
                        bArr2 = new byte[((bArr2.length + i3) - i2) - 1];
                        System.arraycopy(bArr2, 0, bArr2, 0, bArr2.length);
                        System.arraycopy(bArr, i2, bArr2, bArr2.length, (i3 - i2) - 1);
                        for (int i5 = 0; i5 < bArr2.length; i5++) {
                            bArr2[i5] = 0;
                        }
                    }
                    i2 = i3;
                } else {
                    i2 = i3;
                }
            }
            if (bArr[i2] == 10) {
                i2++;
            }
        }
        if (bArr2 != null) {
            buffer.index = i2;
        }
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void copy(KeyPair keyPair) {
        this.publickeyblob = keyPair.publickeyblob;
        this.vendor = keyPair.vendor;
        this.publicKeyComment = keyPair.publicKeyComment;
        this.cipher = keyPair.cipher;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int countLength(int i) {
        int i2 = 1;
        if (i <= 127) {
            return 1;
        }
        while (i > 0) {
            i >>>= 8;
            i2++;
        }
        return i2;
    }

    public void dispose() {
        Util.bzero(this.passphrase);
    }

    public void finalize() {
        dispose();
    }

    public abstract byte[] forSSHAgent() throws JSchException;

    synchronized byte[] genKey(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        if (this.cipher == null) {
            this.cipher = genCipher();
        }
        if (this.hash == null) {
            this.hash = genHash();
        }
        int blockSize = this.cipher.getBlockSize();
        bArr3 = new byte[blockSize];
        int blockSize2 = this.hash.getBlockSize();
        int i = ((blockSize / blockSize2) * blockSize2) + (blockSize % blockSize2 == 0 ? 0 : blockSize2);
        byte[] bArr4 = new byte[i];
        byte[] bArr5 = null;
        try {
            int i2 = this.vendor;
            if (i2 == 0) {
                int i3 = 0;
                while (i3 + blockSize2 <= i) {
                    if (bArr5 != null) {
                        this.hash.update(bArr5, 0, bArr5.length);
                    }
                    this.hash.update(bArr, 0, bArr.length);
                    HASH hash = this.hash;
                    int i4 = 8;
                    if (bArr2.length <= 8) {
                        i4 = bArr2.length;
                    }
                    hash.update(bArr2, 0, i4);
                    bArr5 = this.hash.digest();
                    System.arraycopy(bArr5, 0, bArr4, i3, bArr5.length);
                    i3 += bArr5.length;
                }
                System.arraycopy(bArr4, 0, bArr3, 0, blockSize);
            } else if (i2 == 1) {
                int i5 = 0;
                while (i5 + blockSize2 <= i) {
                    if (bArr5 != null) {
                        this.hash.update(bArr5, 0, bArr5.length);
                    }
                    this.hash.update(bArr, 0, bArr.length);
                    bArr5 = this.hash.digest();
                    System.arraycopy(bArr5, 0, bArr4, i5, bArr5.length);
                    i5 += bArr5.length;
                }
                System.arraycopy(bArr4, 0, bArr3, 0, blockSize);
            } else if (i2 == 2) {
                HASH hash2 = (HASH) Class.forName(JSch.getConfig("sha-1")).newInstance();
                byte[] bArr6 = new byte[4];
                bArr3 = new byte[40];
                for (int i6 = 0; i6 < 2; i6++) {
                    hash2.init();
                    bArr6[3] = (byte) i6;
                    hash2.update(bArr6, 0, 4);
                    hash2.update(bArr, 0, bArr.length);
                    System.arraycopy(hash2.digest(), 0, bArr3, i6 * 20, 20);
                }
            }
        } catch (Exception e2) {
            System.err.println(e2);
        }
        return bArr3;
    }

    abstract void generate(int i) throws JSchException;

    abstract byte[] getBegin();

    abstract byte[] getEnd();

    public String getFingerPrint() {
        if (this.hash == null) {
            this.hash = genHash();
        }
        byte[] publicKeyBlob = getPublicKeyBlob();
        if (publicKeyBlob == null) {
            return null;
        }
        return Util.getFingerPrint(this.hash, publicKeyBlob);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getKeySize();

    public abstract int getKeyType();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] getKeyTypeName();

    abstract byte[] getPrivateKey();

    public byte[] getPublicKeyBlob() {
        return this.publickeyblob;
    }

    public String getPublicKeyComment() {
        return this.publicKeyComment;
    }

    public abstract byte[] getSignature(byte[] bArr);

    public abstract Signature getVerifier();

    public boolean isEncrypted() {
        return this.encrypted;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean parse(byte[] bArr);

    public void setPassphrase(String str) {
        if (str == null || str.length() == 0) {
            setPassphrase((byte[]) null);
        } else {
            setPassphrase(Util.str2byte(str));
        }
    }

    public void setPublicKeyComment(String str) {
        this.publicKeyComment = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int writeDATA(byte[] bArr, byte b2, int i, byte[] bArr2) {
        bArr[i] = b2;
        int writeLength = writeLength(bArr, i + 1, bArr2.length);
        System.arraycopy(bArr2, 0, bArr, writeLength, bArr2.length);
        return writeLength + bArr2.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int writeINTEGER(byte[] bArr, int i, byte[] bArr2) {
        bArr[i] = 2;
        int writeLength = writeLength(bArr, i + 1, bArr2.length);
        System.arraycopy(bArr2, 0, bArr, writeLength, bArr2.length);
        return writeLength + bArr2.length;
    }

    int writeLength(byte[] bArr, int i, int i2) {
        int i3;
        int countLength = countLength(i2) - 1;
        if (countLength == 0) {
            int i4 = i + 1;
            bArr[i] = (byte) i2;
            return i4;
        }
        bArr[i] = (byte) (countLength | 128);
        int i5 = i + 1 + countLength;
        while (countLength > 0) {
            bArr[(i3 + countLength) - 1] = (byte) (i2 & 255);
            i2 >>>= 8;
            countLength--;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int writeOCTETSTRING(byte[] bArr, int i, byte[] bArr2) {
        bArr[i] = 4;
        int writeLength = writeLength(bArr, i + 1, bArr2.length);
        System.arraycopy(bArr2, 0, bArr, writeLength, bArr2.length);
        return writeLength + bArr2.length;
    }

    public void writePrivateKey(OutputStream outputStream) {
        writePrivateKey(outputStream, (byte[]) null);
    }

    public void writePublicKey(OutputStream outputStream, String str) {
        byte[] publicKeyBlob = getPublicKeyBlob();
        byte[] base64 = Util.toBase64(publicKeyBlob, 0, publicKeyBlob.length);
        try {
            outputStream.write(getKeyTypeName());
            outputStream.write(space);
            outputStream.write(base64, 0, base64.length);
            outputStream.write(space);
            outputStream.write(Util.str2byte(str));
            outputStream.write(cr);
        } catch (Exception unused) {
        }
    }

    public void writeSECSHPublicKey(OutputStream outputStream, String str) {
        byte[] publicKeyBlob = getPublicKeyBlob();
        int i = 0;
        byte[] base64 = Util.toBase64(publicKeyBlob, 0, publicKeyBlob.length);
        try {
            outputStream.write(Util.str2byte("---- BEGIN SSH2 PUBLIC KEY ----"));
            byte[] bArr = cr;
            outputStream.write(bArr);
            outputStream.write(Util.str2byte("Comment: \"" + str + SSLClient.DOUBLE_QUOTATION));
            outputStream.write(bArr);
            while (i < base64.length) {
                int i2 = 70;
                if (base64.length - i < 70) {
                    i2 = base64.length - i;
                }
                outputStream.write(base64, i, i2);
                outputStream.write(cr);
                i += i2;
            }
            outputStream.write(Util.str2byte("---- END SSH2 PUBLIC KEY ----"));
            outputStream.write(cr);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int writeSEQUENCE(byte[] bArr, int i, int i2) {
        bArr[i] = 48;
        return writeLength(bArr, i + 1, i2);
    }

    public static KeyPair genKeyPair(JSch jSch, int i, int i2) throws JSchException {
        KeyPair keyPair;
        if (i == 1) {
            keyPair = new KeyPairDSA(jSch);
        } else if (i == 2) {
            keyPair = new KeyPairRSA(jSch);
        } else {
            keyPair = i == 3 ? new KeyPairECDSA(jSch) : null;
        }
        if (keyPair != null) {
            keyPair.generate(i2);
        }
        return keyPair;
    }

    public void writePrivateKey(OutputStream outputStream, byte[] bArr) {
        if (bArr == null) {
            bArr = this.passphrase;
        }
        byte[] privateKey = getPrivateKey();
        byte[][] bArr2 = new byte[1];
        byte[] encrypt = encrypt(privateKey, bArr2, bArr);
        if (encrypt != privateKey) {
            Util.bzero(privateKey);
        }
        int i = 0;
        byte[] bArr3 = bArr2[0];
        byte[] base64 = Util.toBase64(encrypt, 0, encrypt.length);
        try {
            outputStream.write(getBegin());
            byte[] bArr4 = cr;
            outputStream.write(bArr4);
            if (bArr != null) {
                outputStream.write(header[0]);
                outputStream.write(bArr4);
                outputStream.write(header[1]);
                for (int i2 = 0; i2 < bArr3.length; i2++) {
                    outputStream.write(b2a((byte) ((bArr3[i2] >>> 4) & 15)));
                    outputStream.write(b2a((byte) (bArr3[i2] & BinaryMemcacheOpcodes.PREPEND)));
                }
                byte[] bArr5 = cr;
                outputStream.write(bArr5);
                outputStream.write(bArr5);
            }
            while (true) {
                if (i >= base64.length) {
                    break;
                }
                int i3 = i + 64;
                if (i3 >= base64.length) {
                    outputStream.write(base64, i, base64.length - i);
                    outputStream.write(cr);
                    break;
                }
                outputStream.write(base64, i, 64);
                outputStream.write(cr);
                i = i3;
            }
            outputStream.write(getEnd());
            outputStream.write(cr);
        } catch (Exception unused) {
        }
    }

    public static KeyPair load(JSch jSch, String str, String str2) throws JSchException {
        String str3;
        byte[] bArr;
        try {
            byte[] fromFile = Util.fromFile(str);
            if (str2 == null) {
                str3 = str + ".pub";
            } else {
                str3 = str2;
            }
            try {
                bArr = Util.fromFile(str3);
            } catch (IOException e2) {
                if (str2 == null) {
                    bArr = null;
                } else {
                    throw new JSchException(e2.toString(), e2);
                }
            }
            try {
                return load(jSch, fromFile, bArr);
            } finally {
                Util.bzero(fromFile);
            }
        } catch (IOException e3) {
            throw new JSchException(e3.toString(), e3);
        }
    }

    public void setPassphrase(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        this.passphrase = bArr;
    }

    public boolean decrypt(String str) {
        if (str == null || str.length() == 0) {
            return !this.encrypted;
        }
        return decrypt(Util.str2byte(str));
    }

    public void writePublicKey(String str, String str2) throws FileNotFoundException, IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        writePublicKey(fileOutputStream, str2);
        fileOutputStream.close();
    }

    public boolean decrypt(byte[] bArr) {
        boolean z = this.encrypted;
        if (!z) {
            return true;
        }
        if (bArr == null) {
            return !z;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        byte[] decrypt = decrypt(this.data, bArr2, this.iv);
        Util.bzero(bArr2);
        if (parse(decrypt)) {
            this.encrypted = false;
        }
        return !this.encrypted;
    }

    public void writeSECSHPublicKey(String str, String str2) throws FileNotFoundException, IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        writeSECSHPublicKey(fileOutputStream, str2);
        fileOutputStream.close();
    }

    /*  JADX ERROR: Type inference failed with exception
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [byte, byte[]], vars: [r6v2 ??, r6v3 ??, r6v7 ??, r9v2 ??, r9v12 ??, r9v13 ??, r9v16 ??, r9v26 ??, r9v27 ??, r9v30 ??, r6v46 ??, r6v57 ??, r6v58 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.rerun(InitCodeVariables.java:36)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.tryToFixIncompatiblePrimitives(TypeInferenceVisitor.java:828)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:106)
        */
    public static com.jcraft.jsch.KeyPair load(com.jcraft.jsch.JSch r19, byte[] r20, byte[] r21) throws com.jcraft.jsch.JSchException {
        /*
            Method dump skipped, instructions count: 1841
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.KeyPair.load(com.jcraft.jsch.JSch, byte[], byte[]):com.jcraft.jsch.KeyPair");
    }

    public void writePrivateKey(String str) throws FileNotFoundException, IOException {
        writePrivateKey(str, (byte[]) null);
    }

    public void writePrivateKey(String str, byte[] bArr) throws FileNotFoundException, IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        writePrivateKey(fileOutputStream, bArr);
        fileOutputStream.close();
    }
}
