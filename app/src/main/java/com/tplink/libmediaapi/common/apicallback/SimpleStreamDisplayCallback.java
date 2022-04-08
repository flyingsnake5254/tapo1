package com.tplink.libmediaapi.common.apicallback;

import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;

/* loaded from: classes3.dex */
public class SimpleStreamDisplayCallback implements StreamDisplayCommonCallback {
    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void changeVideoBitStreamType(String str, BitStreamType bitStreamType, boolean z, int i) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void displayDestroy() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void displayNetworkSpeed(float f2) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void framePerSecond(String str, int i) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void hideLoadingView() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void onRenderProgramAdd(String str, GLSurfaceViewGPU gLSurfaceViewGPU) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void onSnapshotComplete(String str) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void onStreamFinish() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void playFatalException(Exception exc) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordFailed(int i) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordProgress(long j) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordStart() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordStop() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordSuccess(int i, String str) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void relayPreviewTimeLimit(int i) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void retryResolutions(BitStreamType bitStreamType) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void showLoadingView() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void startHoldToTalk() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void stopHoldToTalk() {
    }
}
