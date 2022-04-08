package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.common.ClientType;
import com.tplink.libtpcommonstream.stream.control.request.param.GetDownloadParams;

/* loaded from: classes3.dex */
public class GetDownloadRequest extends Request {
    @c(ClientType.DOWNLOAD)
    private GetDownloadParams download;

    public GetDownloadRequest() {
        super("get");
    }

    public GetDownloadParams getDownload() {
        return this.download;
    }

    public void setDownload(GetDownloadParams getDownloadParams) {
        this.download = getDownloadParams;
    }
}
