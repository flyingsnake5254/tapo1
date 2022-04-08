package com.jcraft.jsch;

import androidx.core.view.MotionEventCompat;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.IOException;
import java.net.Socket;
import java.util.Hashtable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ChannelX11 extends Channel {
    private static final int LOCAL_MAXIMUM_PACKET_SIZE = 16384;
    private static final int LOCAL_WINDOW_SIZE_MAX = 131072;
    private static final int TIMEOUT = 10000;
    static byte[] cookie = null;
    private static byte[] cookie_hex = null;
    private static String host = "127.0.0.1";
    private static int port = 6000;
    private static Hashtable faked_cookie_pool = new Hashtable();
    private static Hashtable faked_cookie_hex_pool = new Hashtable();
    private static byte[] table = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    private boolean init = true;
    private Socket socket = null;
    private byte[] cache = new byte[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelX11() {
        setLocalWindowSizeMax(131072);
        setLocalWindowSize(131072);
        setLocalPacketSize(16384);
        this.type = Util.str2byte("x11");
        this.connected = true;
    }

    private byte[] addCache(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.cache;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr, i, bArr3, bArr2.length, i2);
        byte[] bArr4 = this.cache;
        if (bArr4.length > 0) {
            System.arraycopy(bArr4, 0, bArr3, 0, bArr4.length);
        }
        this.cache = bArr3;
        return bArr3;
    }

    private static boolean equals(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] getFakedCookie(Session session) {
        byte[] bArr;
        int i;
        synchronized (faked_cookie_hex_pool) {
            bArr = (byte[]) faked_cookie_hex_pool.get(session);
            if (bArr == null) {
                Random random = Session.random;
                byte[] bArr2 = new byte[16];
                synchronized (random) {
                    random.fill(bArr2, 0, 16);
                }
                faked_cookie_pool.put(session, bArr2);
                bArr = new byte[32];
                for (i = 0; i < 16; i++) {
                    int i2 = i * 2;
                    byte[] bArr3 = table;
                    bArr[i2] = bArr3[(bArr2[i] >>> 4) & 15];
                    bArr[i2 + 1] = bArr3[bArr2[i] & BinaryMemcacheOpcodes.PREPEND];
                }
                faked_cookie_hex_pool.put(session, bArr);
            }
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeFakedCookie(Session session) {
        synchronized (faked_cookie_hex_pool) {
            faked_cookie_hex_pool.remove(session);
            faked_cookie_pool.remove(session);
        }
    }

    static int revtable(byte b2) {
        int i = 0;
        while (true) {
            byte[] bArr = table;
            if (i >= bArr.length) {
                return 0;
            }
            if (bArr[i] == b2) {
                return i;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCookie(String str) {
        cookie_hex = Util.str2byte(str);
        cookie = new byte[16];
        for (int i = 0; i < 16; i++) {
            int i2 = i * 2;
            cookie[i] = (byte) (((revtable(cookie_hex[i2]) << 4) & 240) | (revtable(cookie_hex[i2 + 1]) & 15));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setHost(String str) {
        host = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setPort(int i) {
        port = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
        eof();
     */
    @Override // com.jcraft.jsch.Channel, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r6 = this;
            r0 = 1
            java.lang.String r1 = com.jcraft.jsch.ChannelX11.host     // Catch: Exception -> 0x0082
            int r2 = com.jcraft.jsch.ChannelX11.port     // Catch: Exception -> 0x0082
            r3 = 10000(0x2710, float:1.4013E-41)
            java.net.Socket r1 = com.jcraft.jsch.Util.createSocket(r1, r2, r3)     // Catch: Exception -> 0x0082
            r6.socket = r1     // Catch: Exception -> 0x0082
            r1.setTcpNoDelay(r0)     // Catch: Exception -> 0x0082
            com.jcraft.jsch.IO r1 = new com.jcraft.jsch.IO     // Catch: Exception -> 0x0082
            r1.<init>()     // Catch: Exception -> 0x0082
            r6.f5104io = r1     // Catch: Exception -> 0x0082
            java.net.Socket r2 = r6.socket     // Catch: Exception -> 0x0082
            java.io.InputStream r2 = r2.getInputStream()     // Catch: Exception -> 0x0082
            r1.setInputStream(r2)     // Catch: Exception -> 0x0082
            com.jcraft.jsch.IO r1 = r6.f5104io     // Catch: Exception -> 0x0082
            java.net.Socket r2 = r6.socket     // Catch: Exception -> 0x0082
            java.io.OutputStream r2 = r2.getOutputStream()     // Catch: Exception -> 0x0082
            r1.setOutputStream(r2)     // Catch: Exception -> 0x0082
            r6.sendOpenConfirmation()     // Catch: Exception -> 0x0082
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r6.thread = r0
            com.jcraft.jsch.Buffer r0 = new com.jcraft.jsch.Buffer
            int r1 = r6.rmpsize
            r0.<init>(r1)
            com.jcraft.jsch.Packet r1 = new com.jcraft.jsch.Packet
            r1.<init>(r0)
        L_0x0040:
            java.lang.Thread r2 = r6.thread     // Catch: Exception -> 0x007e
            if (r2 == 0) goto L_0x007e
            com.jcraft.jsch.IO r2 = r6.f5104io     // Catch: Exception -> 0x007e
            if (r2 == 0) goto L_0x007e
            java.io.InputStream r2 = r2.in     // Catch: Exception -> 0x007e
            if (r2 == 0) goto L_0x007e
            byte[] r3 = r0.buffer     // Catch: Exception -> 0x007e
            int r4 = r3.length     // Catch: Exception -> 0x007e
            r5 = 14
            int r4 = r4 - r5
            int r4 = r4 + (-128)
            int r2 = r2.read(r3, r5, r4)     // Catch: Exception -> 0x007e
            if (r2 > 0) goto L_0x005e
            r6.eof()     // Catch: Exception -> 0x007e
            goto L_0x007e
        L_0x005e:
            boolean r3 = r6.close     // Catch: Exception -> 0x007e
            if (r3 == 0) goto L_0x0063
            goto L_0x007e
        L_0x0063:
            r1.reset()     // Catch: Exception -> 0x007e
            r3 = 94
            r0.putByte(r3)     // Catch: Exception -> 0x007e
            int r3 = r6.recipient     // Catch: Exception -> 0x007e
            r0.putInt(r3)     // Catch: Exception -> 0x007e
            r0.putInt(r2)     // Catch: Exception -> 0x007e
            r0.skip(r2)     // Catch: Exception -> 0x007e
            com.jcraft.jsch.Session r3 = r6.getSession()     // Catch: Exception -> 0x007e
            r3.write(r1, r6, r2)     // Catch: Exception -> 0x007e
            goto L_0x0040
        L_0x007e:
            r6.disconnect()
            return
        L_0x0082:
            r6.sendOpenFailure(r0)
            r6.close = r0
            r6.disconnect()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.ChannelX11.run():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.jcraft.jsch.Channel
    public void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2;
        if (this.init) {
            try {
                Session session = getSession();
                byte[] addCache = addCache(bArr, i, i2);
                int length = addCache.length;
                if (length >= 9) {
                    int i3 = ((addCache[6] & 255) * 256) + (addCache[7] & 255);
                    int i4 = ((addCache[8] & 255) * 256) + (addCache[9] & 255);
                    if ((addCache[0] & 255) != 66 && (addCache[0] & 255) == 108) {
                        i3 = ((i3 << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((i3 >>> 8) & 255);
                        i4 = ((i4 << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((i4 >>> 8) & 255);
                    }
                    int i5 = (-i3) & 3;
                    if (length >= i3 + 12 + i5 + i4) {
                        byte[] bArr3 = new byte[i4];
                        int i6 = 12 + i3 + i5;
                        System.arraycopy(addCache, i6, bArr3, 0, i4);
                        synchronized (faked_cookie_pool) {
                            bArr2 = (byte[]) faked_cookie_pool.get(session);
                        }
                        if (equals(bArr3, bArr2)) {
                            byte[] bArr4 = cookie;
                            if (bArr4 != null) {
                                System.arraycopy(bArr4, 0, addCache, i6, i4);
                            }
                        } else {
                            this.thread = null;
                            eof();
                            this.f5104io.close();
                            disconnect();
                        }
                        this.init = false;
                        this.f5104io.put(addCache, 0, length);
                        this.cache = null;
                    }
                }
            } catch (JSchException e2) {
                throw new IOException(e2.toString());
            }
        } else {
            this.f5104io.put(bArr, i, i2);
        }
    }
}
