package com.jcraft.jsch;

/* loaded from: classes2.dex */
class UserAuthKeyboardInteractive extends UserAuth {
    UserAuthKeyboardInteractive() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d2, code lost:
        r17.buf.getInt();
        r17.buf.getByte();
        r17.buf.getByte();
        r5 = r17.buf.getString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ed, code lost:
        if (r17.buf.getByte() != 0) goto L_0x0103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ef, code lost:
        if (r4 == false) goto L_0x00f2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f1, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f2, code lost:
        r18.auth_failures++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f7, code lost:
        if (r14 != false) goto L_0x00fd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f9, code lost:
        r4 = r13;
        r5 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0102, code lost:
        throw new com.jcraft.jsch.JSchAuthCancelException("keyboard-interactive");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x010c, code lost:
        throw new com.jcraft.jsch.JSchPartialAuthException(com.jcraft.jsch.Util.byte2str(r5));
     */
    @Override // com.jcraft.jsch.UserAuth
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean start(com.jcraft.jsch.Session r18) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 513
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.UserAuthKeyboardInteractive.start(com.jcraft.jsch.Session):boolean");
    }
}
