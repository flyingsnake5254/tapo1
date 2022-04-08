package com.jcraft.jsch;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import java.io.PrintStream;

/* loaded from: classes2.dex */
public class DHG14 extends KeyExchange {
    private static final int SSH_MSG_KEXDH_INIT = 30;
    private static final int SSH_MSG_KEXDH_REPLY = 31;
    static final byte[] g = {2};
    static final byte[] p = {0, -1, -1, -1, -1, -1, -1, -1, -1, -55, BinaryMemcacheOpcodes.PREPEND, -38, -94, BinaryMemcacheOpcodes.SASL_AUTH, 104, -62, 52, -60, -58, 98, -117, DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE, -36, BinaryMemcacheOpcodes.TOUCH, -47, 41, 2, 78, 8, -118, 103, -52, 116, 2, 11, -66, -90, HttpConstants.SEMICOLON, BinaryMemcacheOpcodes.REPLACEQ, -101, 34, 81, 74, 8, 121, -114, 52, 4, -35, -17, -107, BinaryMemcacheOpcodes.APPENDQ, -77, -51, HttpConstants.COLON, 67, 27, 48, 43, 10, 109, -14, 95, BinaryMemcacheOpcodes.DELETEQ, 55, 79, -31, 53, 109, 109, 81, -62, 69, -28, -123, -75, 118, 98, 94, 126, -58, -12, 76, 66, -23, -90, 55, -19, 107, 11, -1, 92, -74, -12, 6, -73, -19, -18, 56, 107, -5, 90, -119, -97, -91, -82, -97, BinaryMemcacheOpcodes.GATKQ, BinaryMemcacheOpcodes.SETQ, 124, 75, 31, -26, 73, 40, 102, 81, -20, -28, 91, HttpConstants.EQUALS, -62, 0, 124, -72, -95, 99, -65, 5, -104, -38, 72, 54, BinaryMemcacheOpcodes.TOUCH, 85, -45, -102, 105, BinaryMemcacheOpcodes.DECREMENTQ, 63, -88, -3, BinaryMemcacheOpcodes.GATKQ, -49, 95, -125, 101, 93, BinaryMemcacheOpcodes.GATK, -36, -93, -83, -106, BinaryMemcacheOpcodes.TOUCH, 98, -13, 86, 32, -123, 82, -69, -98, -43, 41, 7, 112, -106, -106, 109, 103, 12, 53, 78, 74, -68, -104, 4, -15, 116, 108, 8, -54, BinaryMemcacheOpcodes.FLUSHQ, BinaryMemcacheOpcodes.SASL_AUTH, 124, 50, -112, 94, 70, 46, 54, -50, HttpConstants.SEMICOLON, -29, -98, 119, HttpConstants.COMMA, BinaryMemcacheOpcodes.FLUSHQ, 14, -122, 3, -101, 39, -125, -94, -20, 7, -94, -113, -75, -59, 93, -16, 111, 76, 82, -55, -34, 43, -53, -10, -107, 88, BinaryMemcacheOpcodes.QUITQ, BinaryMemcacheOpcodes.FLUSHQ, 57, -107, 73, 124, -22, -107, 106, -27, BinaryMemcacheOpcodes.INCREMENTQ, -46, 38, BinaryMemcacheOpcodes.FLUSHQ, -104, -6, 5, BinaryMemcacheOpcodes.STAT, BinaryMemcacheOpcodes.INCREMENTQ, 114, -114, 90, -118, -84, -86, 104, -1, -1, -1, -1, -1, -1, -1, -1};
    byte[] I_C;
    byte[] I_S;
    byte[] V_C;
    byte[] V_S;
    private Buffer buf;
    DH dh;

    /* renamed from: e  reason: collision with root package name */
    byte[] f5108e;
    private Packet packet;
    private int state;

    @Override // com.jcraft.jsch.KeyExchange
    public int getState() {
        return this.state;
    }

    @Override // com.jcraft.jsch.KeyExchange
    public void init(Session session, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws Exception {
        this.session = session;
        this.V_S = bArr;
        this.V_C = bArr2;
        this.I_S = bArr3;
        this.I_C = bArr4;
        try {
            HASH hash = (HASH) Class.forName(session.getConfig("sha-1")).newInstance();
            this.sha = hash;
            hash.init();
        } catch (Exception e2) {
            System.err.println(e2);
        }
        this.buf = new Buffer();
        this.packet = new Packet(this.buf);
        try {
            DH dh = (DH) Class.forName(session.getConfig("dh")).newInstance();
            this.dh = dh;
            dh.init();
            this.dh.setP(p);
            this.dh.setG(g);
            this.f5108e = this.dh.getE();
            this.packet.reset();
            this.buf.putByte(BinaryMemcacheOpcodes.GATQ);
            this.buf.putMPInt(this.f5108e);
            if (bArr != null) {
                session.write(this.packet);
                if (JSch.getLogger().isEnabled(1)) {
                    JSch.getLogger().log(1, "SSH_MSG_KEXDH_INIT sent");
                    JSch.getLogger().log(1, "expecting SSH_MSG_KEXDH_REPLY");
                }
                this.state = 31;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    @Override // com.jcraft.jsch.KeyExchange
    public boolean next(Buffer buffer) throws Exception {
        if (this.state != 31) {
            return false;
        }
        buffer.getInt();
        buffer.getByte();
        int i = buffer.getByte();
        if (i != 31) {
            PrintStream printStream = System.err;
            printStream.println("type: must be 31 " + i);
            return false;
        }
        this.K_S = buffer.getString();
        byte[] mPInt = buffer.getMPInt();
        byte[] string = buffer.getString();
        this.dh.setF(mPInt);
        this.dh.checkRange();
        this.K = normalize(this.dh.getK());
        this.buf.reset();
        this.buf.putString(this.V_C);
        this.buf.putString(this.V_S);
        this.buf.putString(this.I_C);
        this.buf.putString(this.I_S);
        this.buf.putString(this.K_S);
        this.buf.putMPInt(this.f5108e);
        this.buf.putMPInt(mPInt);
        this.buf.putMPInt(this.K);
        int length = this.buf.getLength();
        byte[] bArr = new byte[length];
        this.buf.getByte(bArr);
        this.sha.update(bArr, 0, length);
        this.H = this.sha.digest();
        byte[] bArr2 = this.K_S;
        int i2 = ((bArr2[1] << BinaryMemcacheOpcodes.STAT) & 16711680) | ((bArr2[0] << BinaryMemcacheOpcodes.FLUSHQ) & ViewCompat.MEASURED_STATE_MASK) | ((bArr2[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr2[3] & 255);
        boolean verify = verify(Util.byte2str(bArr2, 4, i2), this.K_S, 4 + i2, string);
        this.state = 0;
        return verify;
    }
}
