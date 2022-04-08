package com.tplink.libtpanalytics.bean;

import com.google.gson.q.c;
import java.util.List;

/* loaded from: classes3.dex */
public class SourceParams {
    @c("cm")
    private String commitMethod;
    @c("evo")
    private List<EncryptionVersionOption> encryptVersionOption;
    @c("evoi")
    private String encryptVersionOptionId;
    @c("ec")
    private String encryptedContent;
    @c("ev")
    private int encryptedVersion;
    @c("lv")
    private int libraryVersion;

    public String getCommitMethod() {
        return this.commitMethod;
    }

    public List<EncryptionVersionOption> getEncryptVersionOption() {
        return this.encryptVersionOption;
    }

    public String getEncryptVersionOptionId() {
        return this.encryptVersionOptionId;
    }

    public String getEncryptedContent() {
        return this.encryptedContent;
    }

    public int getEncryptedVersion() {
        return this.encryptedVersion;
    }

    public int getLibraryVersion() {
        return this.libraryVersion;
    }

    public void setCommitMethod(String str) {
        this.commitMethod = str;
    }

    public void setEncryptVersionOption(List<EncryptionVersionOption> list) {
        this.encryptVersionOption = list;
    }

    public void setEncryptVersionOptionId(String str) {
        this.encryptVersionOptionId = str;
    }

    public void setEncryptedContent(String str) {
        this.encryptedContent = str;
    }

    public void setEncryptedVersion(int i) {
        this.encryptedVersion = i;
    }

    public void setLibraryVersion(int i) {
        this.libraryVersion = i;
    }
}
