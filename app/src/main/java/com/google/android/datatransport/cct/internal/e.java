package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ClientInfo;

/* compiled from: AutoValue_ClientInfo.java */
/* loaded from: classes.dex */
final class e extends ClientInfo {
    private final ClientInfo.ClientType a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1828b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_ClientInfo.java */
    /* loaded from: classes.dex */
    public static final class b extends ClientInfo.a {
        private ClientInfo.ClientType a;

        /* renamed from: b  reason: collision with root package name */
        private a f1829b;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo a() {
            return new e(this.a, this.f1829b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a b(@Nullable a aVar) {
            this.f1829b = aVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a c(@Nullable ClientInfo.ClientType clientType) {
            this.a = clientType;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public a b() {
        return this.f1828b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public ClientInfo.ClientType c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.a;
        if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
            a aVar = this.f1828b;
            if (aVar == null) {
                if (clientInfo.b() == null) {
                    return true;
                }
            } else if (aVar.equals(clientInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.a;
        int i = 0;
        int hashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        a aVar = this.f1828b;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.a + ", androidClientInfo=" + this.f1828b + "}";
    }

    private e(@Nullable ClientInfo.ClientType clientType, @Nullable a aVar) {
        this.a = clientType;
        this.f1828b = aVar;
    }
}
