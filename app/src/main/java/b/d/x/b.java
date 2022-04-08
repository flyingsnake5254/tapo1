package b.d.x;

import androidx.annotation.NonNull;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;
import com.tplink.libtpappcommonmedia.bean.stream.StreamMediaData;

/* compiled from: VideoDecoder.java */
/* loaded from: classes3.dex */
public interface b {
    void a(StreamMediaData streamMediaData);

    void b(a aVar);

    void c(@NonNull YUVBuffer yUVBuffer);

    void destroy();
}
