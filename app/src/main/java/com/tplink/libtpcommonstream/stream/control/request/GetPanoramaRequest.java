package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class GetPanoramaRequest extends Request {
    @c("panorama")
    private GetPanoramaParams panorama;

    public GetPanoramaRequest() {
        super("get");
    }

    public GetPanoramaParams getPanorama() {
        return this.panorama;
    }

    public void setPanorama(GetPanoramaParams getPanoramaParams) {
        this.panorama = getPanoramaParams;
    }
}
