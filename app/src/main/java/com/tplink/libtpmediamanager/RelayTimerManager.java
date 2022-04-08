package com.tplink.libtpmediamanager;

import androidx.annotation.Nullable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import b.d.p.d;
import com.tplink.libtplivemedia.a.t;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public enum RelayTimerManager {
    INSTANCE;
    
    public static final int MULTI_DEVICE_TIMEOUT_SECONDS = 120;
    public static final int SINGLE_DEVICE_TIMEOUT_SECONDS = 300;
    private c clientDelayRelayDisposable;
    @Nullable
    private ObservableBoolean isCallingObservable;
    @Nullable
    private ObservableBoolean isRecordingObservable;
    private Observable.OnPropertyChangedCallback playStatusChangedCallback;
    private int relayTimeoutSeconds;
    private final String TAG = RelayTimerManager.class.getSimpleName();
    private boolean playInPreviewPage = false;
    Observable.OnPropertyChangedCallback callAndRecordCallBack = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Observable.OnPropertyChangedCallback {
        a() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            boolean z = ((ObservableBoolean) observable).get();
            String str = RelayTimerManager.this.TAG;
            d.a(str, "Detect some devices play status changed.Playing properly:" + z);
            RelayTimerManager.this.refreshRelayTimer();
        }
    }

    /* loaded from: classes3.dex */
    class b extends Observable.OnPropertyChangedCallback {
        b() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            d.c(RelayTimerManager.this.TAG, "录像或通话状态变化,更新Relay timer");
            RelayTimerManager.this.switchRelayTimer(!((ObservableBoolean) observable).get());
        }
    }

    RelayTimerManager() {
    }

    private Set<Map.Entry<String, t>> getClientSet() {
        return f.j().m();
    }

    private b.d.b0.a.t getPlaybackClient() {
        return e.k().m();
    }

    private boolean isCalling() {
        ObservableBoolean observableBoolean = this.isCallingObservable;
        return observableBoolean != null && b.d.d.m.c.a(Boolean.valueOf(observableBoolean.get()));
    }

    private boolean isRecording() {
        ObservableBoolean observableBoolean = this.isRecordingObservable;
        return observableBoolean != null && b.d.d.m.c.a(Boolean.valueOf(observableBoolean.get()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$switchRelayTimer$0 */
    public /* synthetic */ void a(Long l) throws Exception {
        d.c(this.TAG, "Trigger relay timeout");
        if (this.playInPreviewPage) {
            d.a(this.TAG, "Stop all relay stream");
            stopAllRelayStream(this.relayTimeoutSeconds);
        } else if (findRelayLiveStream() > 0) {
            d.a(this.TAG, "Stop all stream");
            stopAllStreamDueToRelay(this.relayTimeoutSeconds);
        }
    }

    public void bindCallingVariable(@Nullable ObservableBoolean observableBoolean) {
        String str = this.TAG;
        d.a(str, "bindCallingVariable() called with: isCalling = [" + observableBoolean + "]");
        ObservableBoolean observableBoolean2 = this.isCallingObservable;
        if (observableBoolean2 != null) {
            observableBoolean2.removeOnPropertyChangedCallback(this.callAndRecordCallBack);
        }
        if (observableBoolean != null) {
            observableBoolean.addOnPropertyChangedCallback(this.callAndRecordCallBack);
        }
        this.isCallingObservable = observableBoolean;
    }

    public void bindRecordingVariable(@Nullable ObservableBoolean observableBoolean) {
        String str = this.TAG;
        d.a(str, "bindRecordingVariable() called with: isRecording = [" + observableBoolean + "]");
        ObservableBoolean observableBoolean2 = this.isRecordingObservable;
        if (observableBoolean2 != null) {
            observableBoolean2.removeOnPropertyChangedCallback(this.callAndRecordCallBack);
        }
        if (observableBoolean != null) {
            observableBoolean.addOnPropertyChangedCallback(this.callAndRecordCallBack);
        }
        this.isRecordingObservable = observableBoolean;
    }

    public void disableRelayTimer() {
        switchRelayTimer(false);
    }

    public void enableRelayTimer() {
        refreshRelayTimer();
    }

    int findPlayingLiveStream() {
        int i = 0;
        for (Map.Entry<String, t> entry : getClientSet()) {
            i += entry.getValue().J().get() ? 1 : 0;
        }
        b.d.b0.a.t playbackClient = getPlaybackClient();
        return playbackClient != null ? i + (playbackClient.F().get() ? 1 : 0) : i;
    }

    int findRelayLiveStream() {
        Iterator<Map.Entry<String, t>> it = getClientSet().iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, t> next = it.next();
            if (next.getValue().J().get()) {
                if (next.getValue().D() != 0) {
                    i3 = 0;
                }
                i2 += i3;
            }
        }
        b.d.b0.a.t playbackClient = getPlaybackClient();
        if (playbackClient == null || !playbackClient.F().get()) {
            return i2;
        }
        if (playbackClient.B() == 0) {
            i = 1;
        }
        return i2 + i;
    }

    @Nullable
    public ObservableBoolean getCallingObservable() {
        return this.isCallingObservable;
    }

    @Nullable
    public ObservableBoolean getRecordingObservable() {
        return this.isRecordingObservable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void refreshRelayTimer() {
        d.a(this.TAG, "Refresh relay timer");
        int findRelayLiveStream = findRelayLiveStream();
        String str = this.TAG;
        d.a(str, "Relay stream count: " + findRelayLiveStream);
        boolean z = findRelayLiveStream > 0;
        String str2 = this.TAG;
        d.a(str2, "Open relay timer:" + z);
        switchRelayTimer(z);
    }

    public void setPlayInPreviewPage(boolean z) {
        this.playInPreviewPage = z;
    }

    void stopAllRelayStream(int i) {
        d.a(this.TAG, "stopAllRelayStream");
        for (Map.Entry<String, t> entry : getClientSet()) {
            t value = entry.getValue();
            if (value.D() == 0) {
                value.X();
                value.C(i);
            }
        }
        b.d.b0.a.t playbackClient = getPlaybackClient();
        if (playbackClient != null && playbackClient.B() == 0) {
            playbackClient.A(i);
        }
    }

    void stopAllStreamDueToRelay(int i) {
        d.a(this.TAG, "stopAllStreamDueToRelay");
        for (Map.Entry<String, t> entry : getClientSet()) {
            entry.getValue().C(i);
        }
        b.d.b0.a.t playbackClient = getPlaybackClient();
        if (playbackClient != null) {
            playbackClient.A(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void subscribePlayStatus(String str) {
        if (this.playStatusChangedCallback == null) {
            this.playStatusChangedCallback = new a();
        }
        t l = f.j().l(str);
        if (l != null) {
            l.J().addOnPropertyChangedCallback(this.playStatusChangedCallback);
        }
        b.d.b0.a.t m = e.k().m();
        if (m != null) {
            m.F().addOnPropertyChangedCallback(this.playStatusChangedCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchRelayTimer(boolean z) {
        if (!z) {
            c cVar = this.clientDelayRelayDisposable;
            if (cVar != null && !cVar.isDisposed()) {
                String str = this.TAG;
                d.c(str, "Disable relay timer for " + this.relayTimeoutSeconds + " seconds");
                this.clientDelayRelayDisposable.dispose();
            }
        } else if (isCalling() || isRecording()) {
            d.c(this.TAG, "Cannot activate relay timer due to user is recording or calling");
        } else {
            int i = (this.playInPreviewPage || findPlayingLiveStream() > 1) ? 120 : 300;
            c cVar2 = this.clientDelayRelayDisposable;
            if (cVar2 != null && !cVar2.isDisposed()) {
                if (i != this.relayTimeoutSeconds) {
                    this.clientDelayRelayDisposable.dispose();
                    String str2 = this.TAG;
                    d.c(str2, "Disable relay timer for " + this.relayTimeoutSeconds + " seconds");
                } else {
                    d.a(this.TAG, "Retain existed relay timer");
                    return;
                }
            }
            this.relayTimeoutSeconds = i;
            String str3 = this.TAG;
            d.c(str3, "Activate relay timer for " + this.relayTimeoutSeconds + " seconds");
            this.clientDelayRelayDisposable = q.W0((long) this.relayTimeoutSeconds, TimeUnit.SECONDS).G0(new g() { // from class: com.tplink.libtpmediamanager.a
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    RelayTimerManager.this.a((Long) obj);
                }
            });
        }
    }
}
