package com.tplink.libtpanalytics.database.d;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/* compiled from: Event.java */
@Entity(tableName = "EVENT")
/* loaded from: classes3.dex */
public class b {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "EVENT_ID")
    private String a;
    @NonNull
    @ColumnInfo(name = "EVENT_NAME")

    /* renamed from: b  reason: collision with root package name */
    private String f11975b;
    @ColumnInfo(name = "USER_ID")

    /* renamed from: c  reason: collision with root package name */
    private String f11976c;
    @NonNull
    @ColumnInfo(name = "TIME")

    /* renamed from: d  reason: collision with root package name */
    private long f11977d;
    @ColumnInfo(name = "ENCRYPTED_PARAM")

    /* renamed from: e  reason: collision with root package name */
    private String f11978e;
    @ColumnInfo(name = "PLAINTEXT_PARAM")

    /* renamed from: f  reason: collision with root package name */
    private String f11979f;
    @NonNull
    @ColumnInfo(name = "LEN")
    private int g;
    @ColumnInfo(name = "ENCRYPT_VER")
    private int h;
    @ColumnInfo(name = "APP_VER")
    private String i;
    @ColumnInfo(name = "REGION")
    private String j;
    @ColumnInfo(name = "OS_VER")
    private String k;
    @ColumnInfo(name = "LANGUAGE")
    private String l;
    @NonNull
    @ColumnInfo(name = "ENCRYPT_VERSION_ID")
    private String m;

    public String a() {
        return this.i;
    }

    public int b() {
        return this.h;
    }

    @NonNull
    public String c() {
        return this.m;
    }

    public String d() {
        return this.f11978e;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.f11975b;
    }

    public String g() {
        return this.l;
    }

    public int h() {
        return this.g;
    }

    public String i() {
        return this.k;
    }

    public String j() {
        return this.f11979f;
    }

    public String k() {
        return this.j;
    }

    public long l() {
        return this.f11977d;
    }

    public String m() {
        return this.f11976c;
    }

    public void n(String str) {
        this.i = str;
    }

    public void o(int i) {
        this.h = i;
    }

    public void p(@NonNull String str) {
        this.m = str;
    }

    public void q(String str) {
        this.f11978e = str;
    }

    public void r(String str) {
        this.a = str;
    }

    public void s(String str) {
        this.f11975b = str;
    }

    public void t(String str) {
        this.l = str;
    }

    public String toString() {
        return "Event{eventId='" + this.a + "', eventName='" + this.f11975b + "', userId='" + this.f11976c + "', time=" + this.f11977d + ", encryptedParam='" + this.f11978e + "', plaintextParam='" + this.f11979f + "', len=" + this.g + ", encryptVer=" + this.h + ", appVer='" + this.i + "', region='" + this.j + "', osVer='" + this.k + "', language='" + this.l + "', encryptVersionId='" + this.m + "'}";
    }

    public void u(int i) {
        this.g = i;
    }

    public void v(String str) {
        this.k = str;
    }

    public void w(String str) {
        this.f11979f = str;
    }

    public void x(String str) {
        this.j = str;
    }

    public void y(long j) {
        this.f11977d = j;
    }

    public void z(String str) {
        this.f11976c = str;
    }
}
