package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class CloudTerraceId {
    private final String id;

    public CloudTerraceId(String id) {
        j.e(id, "id");
        this.id = id;
    }

    public static /* synthetic */ CloudTerraceId copy$default(CloudTerraceId cloudTerraceId, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cloudTerraceId.id;
        }
        return cloudTerraceId.copy(str);
    }

    public final String component1() {
        return this.id;
    }

    public final CloudTerraceId copy(String id) {
        j.e(id, "id");
        return new CloudTerraceId(id);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CloudTerraceId) && j.a(this.id, ((CloudTerraceId) obj).id);
        }
        return true;
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CloudTerraceId(id=" + this.id + ")";
    }
}
