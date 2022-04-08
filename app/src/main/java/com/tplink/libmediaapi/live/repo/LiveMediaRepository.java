package com.tplink.libmediaapi.live.repo;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableLong;
import androidx.lifecycle.MutableLiveData;
import b.d.p.e.b;
import b.d.z.a.a;
import com.tplink.libmediaapi.common.apicallback.OnConnectionTypeChangeListener;
import com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback;
import com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpcommonstream.stream.control.notification.MotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;
import com.tplink.libtpmediamanager.ConnectionTypeManager;
import com.tplink.libtpmediamanager.f;
import com.tplink.libtpmediamanager.live.LiveMediaBaseRepository;
import com.tplink.libtpstreamclientmanager.m;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class LiveMediaRepository extends LiveMediaBaseRepository {
    private StreamNotificationCallback streamNotificationCallback;
    private final ArrayList<WeakReference<StreamDisplayCommonCallback>> streamDisplayCommonCallbacks = new ArrayList<>();
    private final a commonCallback = new AnonymousClass1();

    /* renamed from: com.tplink.libmediaapi.live.repo.LiveMediaRepository$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements a {
        AnonymousClass1() {
        }

        @Override // b.d.z.a.a
        public void changeVideoBitStreamType(final String str, final BitStreamType bitStreamType, final boolean z, final int i) {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, new b() { // from class: com.tplink.libmediaapi.live.repo.b
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    ((StreamDisplayCommonCallback) obj).changeVideoBitStreamType(str, bitStreamType, z, i);
                }
            });
        }

        @Override // b.d.z.a.a
        public void displayDestroy() {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, g.a);
        }

        @Override // b.d.z.a.a
        public void displayNetworkSpeed(final float f2) {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, new b() { // from class: com.tplink.libmediaapi.live.repo.h
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    ((StreamDisplayCommonCallback) obj).displayNetworkSpeed(f2);
                }
            });
        }

        @Override // b.d.z.a.a
        public void framePerSecond(final String str, final int i) {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, new b() { // from class: com.tplink.libmediaapi.live.repo.d
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    ((StreamDisplayCommonCallback) obj).framePerSecond(str, i);
                }
            });
        }

        @Override // b.d.z.a.a
        public void hideLoadingView() {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, e.a);
        }

        @Override // b.d.z.a.a
        public void onRenderProgramAdd(final String str, final GLSurfaceViewGPU gLSurfaceViewGPU) {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, new b() { // from class: com.tplink.libmediaapi.live.repo.q
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    ((StreamDisplayCommonCallback) obj).onRenderProgramAdd(str, gLSurfaceViewGPU);
                }
            });
        }

        @Override // b.d.z.a.a
        public void onSnapshotComplete(final String str) {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, new b() { // from class: com.tplink.libmediaapi.live.repo.j
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    ((StreamDisplayCommonCallback) obj).onSnapshotComplete(str);
                }
            });
        }

        @Override // b.d.z.a.a
        public void onStreamFinish() {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, l.a);
        }

        @Override // b.d.z.a.a
        public void playFatalException(final Exception exc) {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, new b() { // from class: com.tplink.libmediaapi.live.repo.p
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    ((StreamDisplayCommonCallback) obj).playFatalException(exc);
                }
            });
        }

        @Override // b.d.z.a.a
        public void recordFailed(final int i) {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, new b() { // from class: com.tplink.libmediaapi.live.repo.c
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    ((StreamDisplayCommonCallback) obj).recordFailed(i);
                }
            });
        }

        @Override // b.d.z.a.a
        public void recordProgress(final long j) {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, new b() { // from class: com.tplink.libmediaapi.live.repo.k
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    ((StreamDisplayCommonCallback) obj).recordProgress(j);
                }
            });
        }

        @Override // b.d.z.a.a
        public void recordStart() {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, f.a);
        }

        @Override // b.d.z.a.a
        public void recordStop() {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, s.a);
        }

        @Override // b.d.z.a.a
        public void recordSuccess(final int i, final String str) {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, new b() { // from class: com.tplink.libmediaapi.live.repo.i
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    ((StreamDisplayCommonCallback) obj).recordSuccess(i, str);
                }
            });
        }

        @Override // b.d.z.a.a
        public void relayPreviewTimeLimit(final int i) {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, new b() { // from class: com.tplink.libmediaapi.live.repo.m
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    ((StreamDisplayCommonCallback) obj).relayPreviewTimeLimit(i);
                }
            });
        }

        @Override // b.d.z.a.a
        public void retryResolutions(final BitStreamType bitStreamType) {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, new b() { // from class: com.tplink.libmediaapi.live.repo.n
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    ((StreamDisplayCommonCallback) obj).retryResolutions(BitStreamType.this);
                }
            });
        }

        @Override // b.d.z.a.a
        public void showLoadingView() {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, r.a);
        }

        @Override // b.d.z.a.a
        public void startHoldToTalk() {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, t.a);
        }

        @Override // b.d.z.a.a
        public void stopHoldToTalk() {
            LiveMediaRepository liveMediaRepository = LiveMediaRepository.this;
            liveMediaRepository.iterate(liveMediaRepository.streamDisplayCommonCallbacks, o.a);
        }
    }

    public LiveMediaRepository(TPMediaDeviceContext tPMediaDeviceContext) {
        super(tPMediaDeviceContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iterate(ArrayList<WeakReference<StreamDisplayCommonCallback>> arrayList, b<StreamDisplayCommonCallback> bVar) {
        if (arrayList != null && arrayList.size() > 0) {
            int i = 0;
            while (i < arrayList.size()) {
                WeakReference<StreamDisplayCommonCallback> weakReference = arrayList.get(i);
                if (weakReference.get() != null) {
                    bVar.a(weakReference.get());
                    i++;
                } else {
                    arrayList.remove(i);
                }
            }
        }
    }

    public void addSteamDisplayCommonCallback(StreamDisplayCommonCallback streamDisplayCommonCallback) {
        if (streamDisplayCommonCallback != null) {
            for (int size = this.streamDisplayCommonCallbacks.size() - 1; size >= 0; size--) {
                StreamDisplayCommonCallback streamDisplayCommonCallback2 = this.streamDisplayCommonCallbacks.get(size).get();
                if (streamDisplayCommonCallback2 != null && streamDisplayCommonCallback2.equals(streamDisplayCommonCallback)) {
                    return;
                }
            }
            this.streamDisplayCommonCallbacks.add(new WeakReference<>(streamDisplayCommonCallback));
        }
        if (getClient() != null) {
            getClient().v(this.commonCallback);
        }
    }

    public void allDisplayScreenshotPreview() {
        f.j().g();
    }

    public void changePreviewResolutions(String str, BitStreamType bitStreamType, String str2) {
        f.j().h(str, bitStreamType, null);
    }

    public void clearCommonCallback() {
        this.streamDisplayCommonCallbacks.clear();
    }

    public int getConnectType() {
        if (getClient() == null) {
            return -1;
        }
        return getClient().D();
    }

    public int getConnectionType(String str) {
        return ConnectionTypeManager.INSTANCE.get(str);
    }

    public List<String> getPlayingDevices() {
        return f.j().k();
    }

    public ObservableLong getRecordDuration() {
        if (getClient() == null) {
            return new ObservableLong();
        }
        return getClient().F();
    }

    public boolean isPlayingProperly() {
        return getClient() != null && getClient().J().get();
    }

    public boolean isRecording() {
        return getClient() != null && getClient().K().get();
    }

    public ObservableBoolean isRecordingObservable() {
        if (getClient() == null) {
            return null;
        }
        return getClient().K();
    }

    public void keepDoubleTalk(String str) {
        m.V().c0(str);
    }

    @Override // com.tplink.libtpmediamanager.g.b
    public void loadCacheData() {
    }

    public boolean lockLiveStreamAudio() {
        return f.j().n();
    }

    public void muteAudio(String str, boolean z) {
        f.j().o(str, z);
    }

    public void muteVolume(String str, boolean z) {
        f.j().p(str, z);
    }

    public void pause() {
        if (getClient() != null) {
            getClient().T();
        }
    }

    public void previewCapture(MutableLiveData<b.d.d.m.f<String>> mutableLiveData) {
        if (getClient() != null) {
            getClient().W(mutableLiveData);
        }
    }

    public void previewScreenShot() {
        if (getClient() != null) {
            getClient().X();
        }
    }

    public void releaseStream(String str) {
        m.V().x0(str);
    }

    public void removeSteamDisplayCommonCallback(StreamDisplayCommonCallback streamDisplayCommonCallback) {
        boolean z = true;
        if (streamDisplayCommonCallback != null) {
            int size = this.streamDisplayCommonCallbacks.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                } else if (streamDisplayCommonCallback.equals(this.streamDisplayCommonCallbacks.get(size).get())) {
                    this.streamDisplayCommonCallbacks.set(size, new WeakReference<>(null));
                    break;
                } else {
                    size--;
                }
            }
        }
        int size2 = this.streamDisplayCommonCallbacks.size() - 1;
        while (true) {
            if (size2 < 0) {
                break;
            } else if (this.streamDisplayCommonCallbacks.get(size2).get() != null) {
                z = false;
                break;
            } else {
                size2--;
            }
        }
        if (z && getClient() != null) {
            getClient().Z(this.commonCallback);
        }
    }

    public void resume() {
        if (getClient() != null) {
            getClient().a0();
        }
    }

    public void setConnectionTypeListener(final OnConnectionTypeChangeListener onConnectionTypeChangeListener) {
        if (onConnectionTypeChangeListener != null) {
            ConnectionTypeManager.INSTANCE.setListener(new ConnectionTypeManager.a() { // from class: com.tplink.libmediaapi.live.repo.v
                @Override // com.tplink.libtpmediamanager.ConnectionTypeManager.a
                public final void onChange(String str, int i) {
                    OnConnectionTypeChangeListener.this.onChange(str, i);
                }
            });
        } else {
            ConnectionTypeManager.INSTANCE.setListener(null);
        }
    }

    public void setConnectionTypeListenerEnable(boolean z) {
        ConnectionTypeManager.INSTANCE.setEnabled(z);
    }

    public void setStreamControlNotificationCallback(String str, StreamNotificationCallback streamNotificationCallback) {
        this.streamNotificationCallback = streamNotificationCallback;
        f.j().q(str, new com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback() { // from class: com.tplink.libmediaapi.live.repo.LiveMediaRepository.2
            @Override // com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback
            public void onReceiveDeviceLockedInfo(String str2, DeviceLockedInfo deviceLockedInfo) {
                if (LiveMediaRepository.this.streamNotificationCallback != null) {
                    LiveMediaRepository.this.streamNotificationCallback.onReceiveDeviceLockedInfo(str2, deviceLockedInfo);
                }
            }

            @Override // com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback
            public void onReceiveLensMaskInfo(String str2, boolean z) {
                if (LiveMediaRepository.this.streamNotificationCallback != null) {
                    LiveMediaRepository.this.streamNotificationCallback.onReceiveLensMaskInfo(str2, z);
                }
            }

            @Override // com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback
            public void onReceiveMotorStatus(String str2, MotorStatus motorStatus) {
                if (LiveMediaRepository.this.streamNotificationCallback != null) {
                    LiveMediaRepository.this.streamNotificationCallback.onReceiveMotorStatus(str2, motorStatus);
                }
            }

            @Override // com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback
            public void onReceiveStreamFinish(String str2, String str3) {
                if (LiveMediaRepository.this.streamNotificationCallback != null) {
                    LiveMediaRepository.this.streamNotificationCallback.onReceiveStreamFinish(str2, str3);
                }
            }

            @Override // com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback
            public void onReceiveStreamStatus(String str2, StreamStatus streamStatus) {
                if (LiveMediaRepository.this.streamNotificationCallback != null) {
                    LiveMediaRepository.this.streamNotificationCallback.onReceiveStreamStatus(str2, streamStatus);
                }
            }
        });
    }

    public void snapshot(MutableLiveData<b.d.d.m.f<Pair<Bitmap, String>>> mutableLiveData) {
        if (getClient() != null) {
            getClient().k0(mutableLiveData);
        }
    }

    public void startHoldToTalk() {
        if (getClient() != null) {
            b.d.z.c.a.a(getClient().G(), a.a);
        }
    }

    public void startLiveStreamDisplay(String str, Context context, BitStreamType bitStreamType) {
        f.j().s(str, context, bitStreamType);
    }

    public void startRecord() {
        if (getClient() != null) {
            getClient().m0();
        }
    }

    public void stopDisplay(String str) {
        m.V().x0(str);
        m.V().u0(str);
        f.j().t(str);
    }

    public void stopHoldToTalk() {
        if (getClient() != null) {
            b.d.z.c.a.a(getClient().G(), u.a);
        }
    }

    public void stopKeepDoubleTalk(String str) {
        m.V().I0(str);
    }

    public void stopNetworkStatics() {
        if (getClient() != null) {
            getClient().n0();
        }
    }

    public void stopRecord() {
        if (getClient() != null) {
            getClient().o0();
        }
    }

    public boolean unlockLiveStreamAudio() {
        return f.j().u();
    }

    public void updateAudioVolume(float f2, float f3) {
        if (getClient() != null) {
            getClient().q0(f2);
        }
    }

    public void snapshot() {
        if (getClient() != null) {
            getClient().j0();
        }
    }

    public void addSteamDisplayCommonCallback(int i, StreamDisplayCommonCallback streamDisplayCommonCallback) {
        if (streamDisplayCommonCallback != null) {
            for (int size = this.streamDisplayCommonCallbacks.size() - 1; size >= 0; size--) {
                StreamDisplayCommonCallback streamDisplayCommonCallback2 = this.streamDisplayCommonCallbacks.get(size).get();
                if (streamDisplayCommonCallback2 != null && streamDisplayCommonCallback2.equals(streamDisplayCommonCallback)) {
                    return;
                }
            }
            this.streamDisplayCommonCallbacks.add(i, new WeakReference<>(streamDisplayCommonCallback));
        }
        if (getClient() != null) {
            getClient().u(i, this.commonCallback);
        }
    }
}
