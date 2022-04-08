package com.tplink.libtpcommonstream.stream.control.request;

import com.google.gson.q.c;
import com.tplink.libtpcommonstream.stream.control.request.param.GetPreviewParams;

/* loaded from: classes3.dex */
public class DoChangeResolutionsRequest extends Request {
    @c("change_resolutions")
    private GetPreviewParams changeResolutions;

    public DoChangeResolutionsRequest() {
        super("do");
    }

    public GetPreviewParams getChangeResolutions() {
        return this.changeResolutions;
    }

    public void setChangeResolutions(GetPreviewParams getPreviewParams) {
        this.changeResolutions = getPreviewParams;
    }
}
