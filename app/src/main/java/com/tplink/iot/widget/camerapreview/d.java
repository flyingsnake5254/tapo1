package com.tplink.iot.widget.camerapreview;

import android.content.Context;
import android.view.ViewGroup;
import com.hannesdorfmann.mosby3.k.b;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;
import io.reactivex.q;

/* compiled from: DisplayView.kt */
/* loaded from: classes3.dex */
public interface d extends b {
    q<CameraPreviewInfo> K();

    q<Boolean> P();

    Context getContextForView();

    q<Boolean> getFirmwareIntent();

    ViewGroup getParentView();

    void s0(e eVar);

    q<Boolean> x0();
}
