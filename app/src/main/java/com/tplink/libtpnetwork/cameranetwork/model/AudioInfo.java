package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class AudioInfo {
    public static final Companion Companion = new Companion(null);
    @c("microphone")
    private MicroPhoneInfo microPhoneInfo;
    @c("speaker")
    private SpeakerInfo speakerInfo;

    /* compiled from: ModelAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements UnwrapFromResponse<AudioInfo> {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tplink.libtpnetwork.cameranetwork.model.UnwrapFromResponse
        public AudioInfo fromResponse(Response<Wrappers> response) {
            j.e(response, "response");
            if (!j.a(response.getMethod(), Method.GET_AUDIO_CONFIG.getValue())) {
                return null;
            }
            Wrappers result = response.getResult();
            Module module = Module.AUDIO_CONFIG;
            return new AudioInfo((MicroPhoneInfo) Model.typeCast(result, module, Section.MICROPHONE), (SpeakerInfo) Model.typeCast(result, module, Section.SPEAKER));
        }
    }

    public AudioInfo(MicroPhoneInfo microPhoneInfo, SpeakerInfo speakerInfo) {
        this.microPhoneInfo = microPhoneInfo;
        this.speakerInfo = speakerInfo;
    }

    public static /* synthetic */ AudioInfo copy$default(AudioInfo audioInfo, MicroPhoneInfo microPhoneInfo, SpeakerInfo speakerInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            microPhoneInfo = audioInfo.microPhoneInfo;
        }
        if ((i & 2) != 0) {
            speakerInfo = audioInfo.speakerInfo;
        }
        return audioInfo.copy(microPhoneInfo, speakerInfo);
    }

    public final MicroPhoneInfo component1() {
        return this.microPhoneInfo;
    }

    public final SpeakerInfo component2() {
        return this.speakerInfo;
    }

    public final AudioInfo copy(MicroPhoneInfo microPhoneInfo, SpeakerInfo speakerInfo) {
        return new AudioInfo(microPhoneInfo, speakerInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioInfo)) {
            return false;
        }
        AudioInfo audioInfo = (AudioInfo) obj;
        return j.a(this.microPhoneInfo, audioInfo.microPhoneInfo) && j.a(this.speakerInfo, audioInfo.speakerInfo);
    }

    public final MicroPhoneInfo getMicroPhoneInfo() {
        return this.microPhoneInfo;
    }

    public final SpeakerInfo getSpeakerInfo() {
        return this.speakerInfo;
    }

    public int hashCode() {
        MicroPhoneInfo microPhoneInfo = this.microPhoneInfo;
        int i = 0;
        int hashCode = (microPhoneInfo != null ? microPhoneInfo.hashCode() : 0) * 31;
        SpeakerInfo speakerInfo = this.speakerInfo;
        if (speakerInfo != null) {
            i = speakerInfo.hashCode();
        }
        return hashCode + i;
    }

    public final void setMicroPhoneInfo(MicroPhoneInfo microPhoneInfo) {
        this.microPhoneInfo = microPhoneInfo;
    }

    public final void setSpeakerInfo(SpeakerInfo speakerInfo) {
        this.speakerInfo = speakerInfo;
    }

    public String toString() {
        return "AudioInfo(microPhoneInfo=" + this.microPhoneInfo + ", speakerInfo=" + this.speakerInfo + ")";
    }
}
