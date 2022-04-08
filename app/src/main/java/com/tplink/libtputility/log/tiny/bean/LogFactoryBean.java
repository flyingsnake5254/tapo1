package com.tplink.libtputility.log.tiny.bean;

import com.google.gson.Gson;
import com.google.gson.q.c;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class LogFactoryBean {
    @c("block_list")
    private List<a> blockList;
    @c("compaction_algorithm")
    private String compactionAlgorithm;
    @c("encrypt_type")
    private String encryptType;

    /* loaded from: classes3.dex */
    public static class a {
        @c("encrypt_key")
        private String a;
        @c("length")

        /* renamed from: b  reason: collision with root package name */
        private long f15116b;

        public void a(String str) {
            this.a = str;
        }

        public void b(long j) {
            this.f15116b = j;
        }
    }

    public LogFactoryBean() {
        this.blockList = new ArrayList();
    }

    public List<a> getBlockList() {
        return this.blockList;
    }

    public String getCompactionAlgorithm() {
        return this.compactionAlgorithm;
    }

    public String getEncryptType() {
        return this.encryptType;
    }

    public void setBlockList(List<a> list) {
        this.blockList = list;
    }

    public void setCompactionAlgorithm(String str) {
        this.compactionAlgorithm = str;
    }

    public void setEncryptType(String str) {
        this.encryptType = str;
    }

    public byte[] toJsonByte() {
        try {
            return new Gson().u(this).getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public LogFactoryBean(List<a> list) {
        this.blockList = new ArrayList();
        this.encryptType = "aes-ecb";
        this.compactionAlgorithm = "zlib";
        for (a aVar : list) {
            if (aVar.h() != null && aVar.g() > 0) {
                a aVar2 = new a();
                aVar2.a(aVar.e());
                aVar2.b(aVar.g());
                this.blockList.add(aVar2);
            }
        }
    }
}
