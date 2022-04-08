package com.tplink.libtpnetwork.cameranetwork.model;

import com.tplink.libtpmediastatistics.SSLClient;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class Camera {
    private final String id;
    private final String ip;
    private final String name;
    private final int port;
    private final String url;

    public Camera(String id, String name, String ip, int i) {
        j.e(id, "id");
        j.e(name, "name");
        j.e(ip, "ip");
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.port = i;
        this.url = SSLClient.HTTPS_PREFIX + ip + ':' + i;
    }

    public static /* synthetic */ Camera copy$default(Camera camera, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = camera.id;
        }
        if ((i2 & 2) != 0) {
            str2 = camera.name;
        }
        if ((i2 & 4) != 0) {
            str3 = camera.ip;
        }
        if ((i2 & 8) != 0) {
            i = camera.port;
        }
        return camera.copy(str, str2, str3, i);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.ip;
    }

    public final int component4() {
        return this.port;
    }

    public final Camera copy(String id, String name, String ip, int i) {
        j.e(id, "id");
        j.e(name, "name");
        j.e(ip, "ip");
        return new Camera(id, name, ip, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Camera)) {
            return false;
        }
        Camera camera = (Camera) obj;
        return j.a(this.id, camera.id) && j.a(this.name, camera.name) && j.a(this.ip, camera.ip) && this.port == camera.port;
    }

    public final String getId() {
        return this.id;
    }

    public final String getIp() {
        return this.ip;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPort() {
        return this.port;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ip;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.port;
    }

    public String toString() {
        return "Camera(id=" + this.id + ", name=" + this.name + ", ip=" + this.ip + ", port=" + this.port + ")";
    }
}
