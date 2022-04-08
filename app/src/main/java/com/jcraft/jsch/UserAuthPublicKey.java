package com.jcraft.jsch;

import com.jcraft.jsch.IdentityRepository;
import java.util.Vector;

/* loaded from: classes2.dex */
class UserAuthPublicKey extends UserAuth {
    UserAuthPublicKey() {
    }

    @Override // com.jcraft.jsch.UserAuth
    public boolean start(Session session) throws Exception {
        byte[] bArr;
        byte[] bArr2;
        super.start(session);
        Vector identities = session.getIdentityRepository().getIdentities();
        synchronized (identities) {
            if (identities.size() <= 0) {
                return false;
            }
            byte[] str2byte = Util.str2byte(this.username);
            for (int i = 0; i < identities.size(); i++) {
                if (session.auth_failures >= session.max_auth_tries) {
                    return false;
                }
                Identity identity = (Identity) identities.elementAt(i);
                byte[] publicKeyBlob = identity.getPublicKeyBlob();
                if (publicKeyBlob != null) {
                    this.packet.reset();
                    this.buf.putByte((byte) 50);
                    this.buf.putString(str2byte);
                    this.buf.putString(Util.str2byte("ssh-connection"));
                    this.buf.putString(Util.str2byte("publickey"));
                    this.buf.putByte((byte) 0);
                    this.buf.putString(Util.str2byte(identity.getAlgName()));
                    this.buf.putString(publicKeyBlob);
                    session.write(this.packet);
                    while (true) {
                        Buffer read = session.read(this.buf);
                        this.buf = read;
                        int command = read.getCommand() & 255;
                        if (command == 60 || command == 51 || command != 53) {
                            break;
                        }
                        this.buf.getInt();
                        this.buf.getByte();
                        this.buf.getByte();
                        byte[] string = this.buf.getString();
                        this.buf.getString();
                        String byte2str = Util.byte2str(string);
                        UserInfo userInfo = this.userinfo;
                        if (userInfo != null) {
                            userInfo.showMessage(byte2str);
                        }
                    }
                }
                int i2 = 5;
                while (true) {
                    if (identity.isEncrypted()) {
                        if (this.userinfo != null) {
                            if (identity.isEncrypted()) {
                                if (!this.userinfo.promptPassphrase("Passphrase for " + identity.getName())) {
                                    throw new JSchAuthCancelException("publickey");
                                }
                            }
                            String passphrase = this.userinfo.getPassphrase();
                            if (passphrase != null) {
                                bArr = Util.str2byte(passphrase);
                                if ((!identity.isEncrypted() && bArr == null) || !identity.setPassphrase(bArr)) {
                                    Util.bzero(bArr);
                                    i2--;
                                    if (i2 == 0) {
                                        bArr2 = null;
                                        break;
                                    }
                                } else {
                                    if (bArr != null && (session.getIdentityRepository() instanceof IdentityRepository.Wrapper)) {
                                        ((IdentityRepository.Wrapper) session.getIdentityRepository()).check();
                                    }
                                    bArr2 = bArr;
                                }
                            }
                        } else {
                            throw new JSchException("USERAUTH fail");
                        }
                    }
                    bArr = null;
                    if (!identity.isEncrypted()) {
                    }
                    if (bArr != null) {
                        ((IdentityRepository.Wrapper) session.getIdentityRepository()).check();
                    }
                    bArr2 = bArr;
                }
                Util.bzero(bArr2);
                if (!identity.isEncrypted()) {
                    if (publicKeyBlob == null) {
                        publicKeyBlob = identity.getPublicKeyBlob();
                    }
                    if (publicKeyBlob != null) {
                        this.packet.reset();
                        this.buf.putByte((byte) 50);
                        this.buf.putString(str2byte);
                        this.buf.putString(Util.str2byte("ssh-connection"));
                        this.buf.putString(Util.str2byte("publickey"));
                        this.buf.putByte((byte) 1);
                        this.buf.putString(Util.str2byte(identity.getAlgName()));
                        this.buf.putString(publicKeyBlob);
                        byte[] sessionId = session.getSessionId();
                        int length = sessionId.length;
                        int i3 = length + 4;
                        byte[] bArr3 = new byte[(this.buf.index + i3) - 5];
                        bArr3[0] = (byte) (length >>> 24);
                        bArr3[1] = (byte) (length >>> 16);
                        bArr3[2] = (byte) (length >>> 8);
                        bArr3[3] = (byte) length;
                        System.arraycopy(sessionId, 0, bArr3, 4, length);
                        Buffer buffer = this.buf;
                        System.arraycopy(buffer.buffer, 5, bArr3, i3, buffer.index - 5);
                        byte[] signature = identity.getSignature(bArr3);
                        if (signature == null) {
                            break;
                        }
                        this.buf.putString(signature);
                        session.write(this.packet);
                        while (true) {
                            Buffer read2 = session.read(this.buf);
                            this.buf = read2;
                            int command2 = read2.getCommand() & 255;
                            if (command2 == 52) {
                                return true;
                            }
                            if (command2 == 53) {
                                this.buf.getInt();
                                this.buf.getByte();
                                this.buf.getByte();
                                byte[] string2 = this.buf.getString();
                                this.buf.getString();
                                String byte2str2 = Util.byte2str(string2);
                                UserInfo userInfo2 = this.userinfo;
                                if (userInfo2 != null) {
                                    userInfo2.showMessage(byte2str2);
                                }
                            } else if (command2 == 51) {
                                this.buf.getInt();
                                this.buf.getByte();
                                this.buf.getByte();
                                byte[] string3 = this.buf.getString();
                                if (this.buf.getByte() == 0) {
                                    session.auth_failures++;
                                } else {
                                    throw new JSchPartialAuthException(Util.byte2str(string3));
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }
}
