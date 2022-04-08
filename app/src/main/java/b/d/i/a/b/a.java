package b.d.i.a.b;

import androidx.annotation.NonNull;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.common.PreviewAudio;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.request.GetDownloadRequest;
import com.tplink.libtpcommonstream.stream.control.request.GetPlaybackRequest;
import com.tplink.libtpcommonstream.stream.control.request.GetPreviewRequest;
import com.tplink.libtpcommonstream.stream.control.request.GetTalkRequest;
import com.tplink.libtpcommonstream.stream.control.request.param.GetDownloadParams;
import com.tplink.libtpcommonstream.stream.control.request.param.GetPreviewParams;
import com.tplink.libtpcommonstream.stream.control.request.param.GetTalkParams;
import com.tplink.libtpcommonstream.stream.control.request.param.GetVodParams;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: RequestParamsUtils.java */
/* loaded from: classes3.dex */
public class a {
    public static String a(int i, int i2, String str, int i3) {
        GetDownloadParams getDownloadParams = new GetDownloadParams();
        getDownloadParams.setChannels(Collections.singletonList(0));
        getDownloadParams.setClientId(i);
        getDownloadParams.setMediaType(Integer.valueOf(i2));
        getDownloadParams.setStartTime(str);
        GetDownloadRequest getDownloadRequest = new GetDownloadRequest();
        getDownloadRequest.setDownload(getDownloadParams);
        StreamControlRequest streamControlRequest = new StreamControlRequest(getDownloadRequest);
        streamControlRequest.setSeq(i3);
        return b.d(streamControlRequest);
    }

    public static String b(int i, String str, @NonNull int[] iArr, long j, long j2, int i2) {
        GetVodParams getVodParams = new GetVodParams();
        getVodParams.setChannels(Collections.singletonList(0));
        getVodParams.setClientId(i);
        getVodParams.setScale(str);
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            arrayList.add(Integer.valueOf(i3));
        }
        getVodParams.setEventType(arrayList);
        if (j <= 0) {
            return null;
        }
        getVodParams.setStartTime(String.valueOf(j));
        if (j2 > 0) {
            getVodParams.setEndTime(String.valueOf(j2));
        }
        GetPlaybackRequest getPlaybackRequest = new GetPlaybackRequest();
        getPlaybackRequest.setPlayback(getVodParams);
        StreamControlRequest streamControlRequest = new StreamControlRequest(getPlaybackRequest);
        streamControlRequest.setSeq(i2);
        return b.d(streamControlRequest);
    }

    public static String c(String str, BitStreamType bitStreamType, String str2, int i) {
        GetPreviewParams getPreviewParams = new GetPreviewParams();
        getPreviewParams.setChannels(Collections.singletonList(0));
        if (bitStreamType == null) {
            bitStreamType = b.d.d.e.a.b(str);
        }
        if (str2 == null) {
            str2 = PreviewAudio.AUDIO_DEFAULT;
        }
        getPreviewParams.setResolutions(Collections.singletonList(bitStreamType.getValue()));
        getPreviewParams.setAudio(Collections.singletonList(str2));
        GetPreviewRequest getPreviewRequest = new GetPreviewRequest();
        getPreviewRequest.setPreview(getPreviewParams);
        StreamControlRequest streamControlRequest = new StreamControlRequest(getPreviewRequest);
        streamControlRequest.setSeq(i);
        return b.d(streamControlRequest);
    }

    public static String d(String str, String str2, int i) {
        GetTalkParams getTalkParams = new GetTalkParams();
        getTalkParams.setMode(str2);
        GetTalkRequest getTalkRequest = new GetTalkRequest();
        getTalkRequest.setTalk(getTalkParams);
        StreamControlRequest streamControlRequest = new StreamControlRequest(getTalkRequest);
        streamControlRequest.setSeq(i);
        return b.d(streamControlRequest);
    }
}
