package com.jcraft.jsch;

import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import java.io.PrintStream;

/* loaded from: classes2.dex */
public abstract class KeyExchange {
    static final int PROPOSAL_COMP_ALGS_CTOS = 6;
    static final int PROPOSAL_COMP_ALGS_STOC = 7;
    static final int PROPOSAL_ENC_ALGS_CTOS = 2;
    static final int PROPOSAL_ENC_ALGS_STOC = 3;
    static final int PROPOSAL_KEX_ALGS = 0;
    static final int PROPOSAL_LANG_CTOS = 8;
    static final int PROPOSAL_LANG_STOC = 9;
    static final int PROPOSAL_MAC_ALGS_CTOS = 4;
    static final int PROPOSAL_MAC_ALGS_STOC = 5;
    static final int PROPOSAL_MAX = 10;
    static final int PROPOSAL_SERVER_HOST_KEY_ALGS = 1;
    public static final int STATE_END = 0;
    static String enc_c2s = "blowfish-cbc";
    static String enc_s2c = "blowfish-cbc";
    static String kex = "diffie-hellman-group1-sha1";
    static String lang_c2s = "";
    static String lang_s2c = "";
    static String mac_c2s = "hmac-md5";
    static String mac_s2c = "hmac-md5";
    static String server_host_key = "ssh-rsa,ssh-dss";
    protected Session session = null;
    protected HASH sha = null;
    protected byte[] K = null;
    protected byte[] H = null;
    protected byte[] K_S = null;
    protected final int RSA = 0;
    protected final int DSS = 1;
    protected final int ECDSA = 2;
    private int type = 0;
    private String key_alg_name = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public static String[] guess(byte[] bArr, byte[] bArr2) {
        String[] strArr = new String[10];
        Buffer buffer = new Buffer(bArr);
        buffer.setOffSet(17);
        Buffer buffer2 = new Buffer(bArr2);
        buffer2.setOffSet(17);
        if (JSch.getLogger().isEnabled(1)) {
            for (int i = 0; i < 10; i++) {
                Logger logger = JSch.getLogger();
                logger.log(1, "kex: server: " + Util.byte2str(buffer.getString()));
            }
            for (int i2 = 0; i2 < 10; i2++) {
                Logger logger2 = JSch.getLogger();
                logger2.log(1, "kex: client: " + Util.byte2str(buffer2.getString()));
            }
            buffer.setOffSet(17);
            buffer2.setOffSet(17);
        }
        for (int i3 = 0; i3 < 10; i3++) {
            byte[] string = buffer.getString();
            byte[] string2 = buffer2.getString();
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 >= string2.length) {
                    break;
                }
                while (i4 < string2.length && string2[i4] != 44) {
                    i4++;
                }
                if (i5 == i4) {
                    return null;
                }
                String byte2str = Util.byte2str(string2, i5, i4 - i5);
                int i6 = 0;
                int i7 = 0;
                while (i6 < string.length) {
                    while (i6 < string.length && string[i6] != 44) {
                        i6++;
                    }
                    if (i7 == i6) {
                        return null;
                    }
                    if (byte2str.equals(Util.byte2str(string, i7, i6 - i7))) {
                        strArr[i3] = byte2str;
                        break;
                    }
                    i7 = i6 + 1;
                    i6 = i7;
                }
                i5 = i4 + 1;
                i4 = i5;
            }
            if (i4 == 0) {
                strArr[i3] = "";
            } else if (strArr[i3] == null) {
                return null;
            }
        }
        if (JSch.getLogger().isEnabled(1)) {
            Logger logger3 = JSch.getLogger();
            logger3.log(1, "kex: server->client " + strArr[3] + SSLClient.WHITE_SPACE + strArr[5] + SSLClient.WHITE_SPACE + strArr[7]);
            Logger logger4 = JSch.getLogger();
            logger4.log(1, "kex: client->server " + strArr[2] + SSLClient.WHITE_SPACE + strArr[4] + SSLClient.WHITE_SPACE + strArr[6]);
        }
        return strArr;
    }

    public String getFingerPrint() {
        HASH hash;
        try {
            hash = (HASH) Class.forName(this.session.getConfig("md5")).newInstance();
        } catch (Exception e2) {
            PrintStream printStream = System.err;
            printStream.println("getFingerPrint: " + e2);
            hash = null;
        }
        return Util.getFingerPrint(hash, getHostKey());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getH() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HASH getHash() {
        return this.sha;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getHostKey() {
        return this.K_S;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getK() {
        return this.K;
    }

    public String getKeyAlgorithName() {
        return this.key_alg_name;
    }

    public String getKeyType() {
        int i = this.type;
        return i == 1 ? "DSA" : i == 0 ? "RSA" : "ECDSA";
    }

    public abstract int getState();

    public abstract void init(Session session, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws Exception;

    public abstract boolean next(Buffer buffer) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] normalize(byte[] bArr) {
        if (bArr.length <= 1 || bArr[0] != 0 || (bArr[1] & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE) != 0) {
            return bArr;
        }
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        return normalize(bArr2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean verify(java.lang.String r10, byte[] r11, int r12, byte[] r13) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.KeyExchange.verify(java.lang.String, byte[], int, byte[]):boolean");
    }
}
