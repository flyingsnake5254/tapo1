package com.tplink.cloud.context;

import android.text.TextUtils;
import b.d.w.h.b;
import com.tplink.cloud.define.EnumAccountStatus;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class TCAccountBean implements Serializable {
    private String accountId;
    private EnumAccountStatus accountStatus;
    private String avatarUrl;
    private String cloudUserName;
    private String countryCode;
    private String email;
    private String nickName;
    private String password;
    private String phone;
    private String refreshToken;
    private String regTime;
    private String token;
    private String userName;

    public TCAccountBean() {
        this.accountStatus = EnumAccountStatus.ACCOUNT_STATUS_UNREGISTERED;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public EnumAccountStatus getAccountStatus() {
        return this.accountStatus;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getCloudUserName() {
        return this.cloudUserName;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDisplayUserName() {
        String nickName = getNickName();
        if (TextUtils.isEmpty(nickName)) {
            nickName = getUserName();
        }
        if (TextUtils.isEmpty(nickName)) {
            nickName = b.b(getEmail());
        }
        if (TextUtils.isEmpty(nickName)) {
            nickName = b.b(getCloudUserName());
        }
        return TextUtils.isEmpty(nickName) ? getCloudUserName() : nickName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getRegTime() {
        return this.regTime;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean isAccountInfoFullValid() {
        return !TextUtils.isEmpty(this.cloudUserName) && !TextUtils.isEmpty(this.token) && !TextUtils.isEmpty(this.password);
    }

    public boolean isAccountInfoValid() {
        return !TextUtils.isEmpty(this.cloudUserName) && (!TextUtils.isEmpty(this.token) || !TextUtils.isEmpty(this.password));
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setAccountStatus(EnumAccountStatus enumAccountStatus) {
        this.accountStatus = enumAccountStatus;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setCloudUserName(String str) {
        this.cloudUserName = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public void setRegTime(String str) {
        this.regTime = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public TCAccountBean(String str, String str2) {
        this.accountStatus = EnumAccountStatus.ACCOUNT_STATUS_UNREGISTERED;
        this.cloudUserName = str;
        this.password = str2;
    }

    public TCAccountBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, EnumAccountStatus enumAccountStatus, String str9, String str10, String str11) {
        this.accountStatus = EnumAccountStatus.ACCOUNT_STATUS_UNREGISTERED;
        this.accountId = str;
        this.email = str2;
        this.cloudUserName = str3;
        this.phone = str4;
        this.userName = str5;
        this.password = str6;
        this.nickName = str7;
        this.regTime = str8;
        this.accountStatus = enumAccountStatus;
        this.token = str9;
        this.refreshToken = str10;
        this.avatarUrl = str11;
    }
}
