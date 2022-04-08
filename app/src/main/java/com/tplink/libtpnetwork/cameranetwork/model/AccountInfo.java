package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class AccountInfo {
    @c("secname")
    private final String group;
    @c("passwd")
    private String newPassword;
    @c("old_passwd")
    private String oldPassword;
    @c("ciphertext")
    private final String passwordEncrypted;
    private String username;

    public AccountInfo(String group, String username, String newPassword, String oldPassword, String passwordEncrypted) {
        j.e(group, "group");
        j.e(username, "username");
        j.e(newPassword, "newPassword");
        j.e(oldPassword, "oldPassword");
        j.e(passwordEncrypted, "passwordEncrypted");
        this.group = group;
        this.username = username;
        this.newPassword = newPassword;
        this.oldPassword = oldPassword;
        this.passwordEncrypted = passwordEncrypted;
    }

    public static /* synthetic */ AccountInfo copy$default(AccountInfo accountInfo, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accountInfo.group;
        }
        if ((i & 2) != 0) {
            str2 = accountInfo.username;
        }
        if ((i & 4) != 0) {
            str3 = accountInfo.newPassword;
        }
        if ((i & 8) != 0) {
            str4 = accountInfo.oldPassword;
        }
        if ((i & 16) != 0) {
            str5 = accountInfo.passwordEncrypted;
        }
        return accountInfo.copy(str, str2, str3, str4, str5);
    }

    public final String component1() {
        return this.group;
    }

    public final String component2() {
        return this.username;
    }

    public final String component3() {
        return this.newPassword;
    }

    public final String component4() {
        return this.oldPassword;
    }

    public final String component5() {
        return this.passwordEncrypted;
    }

    public final AccountInfo copy(String group, String username, String newPassword, String oldPassword, String passwordEncrypted) {
        j.e(group, "group");
        j.e(username, "username");
        j.e(newPassword, "newPassword");
        j.e(oldPassword, "oldPassword");
        j.e(passwordEncrypted, "passwordEncrypted");
        return new AccountInfo(group, username, newPassword, oldPassword, passwordEncrypted);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountInfo)) {
            return false;
        }
        AccountInfo accountInfo = (AccountInfo) obj;
        return j.a(this.group, accountInfo.group) && j.a(this.username, accountInfo.username) && j.a(this.newPassword, accountInfo.newPassword) && j.a(this.oldPassword, accountInfo.oldPassword) && j.a(this.passwordEncrypted, accountInfo.passwordEncrypted);
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getNewPassword() {
        return this.newPassword;
    }

    public final String getOldPassword() {
        return this.oldPassword;
    }

    public final String getPasswordEncrypted() {
        return this.passwordEncrypted;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.group;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.username;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.newPassword;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.oldPassword;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.passwordEncrypted;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public final void setNewPassword(String str) {
        j.e(str, "<set-?>");
        this.newPassword = str;
    }

    public final void setOldPassword(String str) {
        j.e(str, "<set-?>");
        this.oldPassword = str;
    }

    public final void setUsername(String str) {
        j.e(str, "<set-?>");
        this.username = str;
    }

    public String toString() {
        return "AccountInfo(group=" + this.group + ", username=" + this.username + ", newPassword=" + this.newPassword + ", oldPassword=" + this.oldPassword + ", passwordEncrypted=" + this.passwordEncrypted + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccountInfo(Account oldAccount, String newPassword) {
        this("root", oldAccount.getUsername(), com.tplink.libtpnetwork.cameranetwork.util.j.a(newPassword), oldAccount.getPassword(), com.tplink.libtpnetwork.cameranetwork.util.j.d(com.tplink.libtpnetwork.cameranetwork.util.j.a(newPassword)));
        j.e(oldAccount, "oldAccount");
        j.e(newPassword, "newPassword");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccountInfo(String username, String newPassword) {
        this("third_account", username, com.tplink.libtpnetwork.cameranetwork.util.j.a(newPassword), "", com.tplink.libtpnetwork.cameranetwork.util.j.d(newPassword));
        j.e(username, "username");
        j.e(newPassword, "newPassword");
    }
}
