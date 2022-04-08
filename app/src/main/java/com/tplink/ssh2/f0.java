package com.tplink.ssh2;

import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

/* compiled from: SSH2UserInfo.java */
/* loaded from: classes3.dex */
public class f0 implements UserInfo, UIKeyboardInteractive {
    private String a = "";

    public void a(String str) {
        this.a = str;
    }

    @Override // com.jcraft.jsch.UserInfo
    public String getPassphrase() {
        return null;
    }

    @Override // com.jcraft.jsch.UserInfo
    public String getPassword() {
        return this.a;
    }

    @Override // com.jcraft.jsch.UIKeyboardInteractive
    public String[] promptKeyboardInteractive(String str, String str2, String str3, String[] strArr, boolean[] zArr) {
        return null;
    }

    @Override // com.jcraft.jsch.UserInfo
    public boolean promptPassphrase(String str) {
        return true;
    }

    @Override // com.jcraft.jsch.UserInfo
    public boolean promptPassword(String str) {
        return true;
    }

    @Override // com.jcraft.jsch.UserInfo
    public boolean promptYesNo(String str) {
        return true;
    }

    @Override // com.jcraft.jsch.UserInfo
    public void showMessage(String str) {
    }
}
