package com.tplink.iot.view.ipcamera.widget.timeaxis;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisHorizontalScrollView;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisScaleView;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class TimeAxisLayout extends FrameLayout implements TimeAxisHorizontalScrollView.b, TimeAxisScaleView.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9409c = TimeAxisLayout.class.getSimpleName();
    private int I3;
    private int J3;
    private int K3;

    /* renamed from: d  reason: collision with root package name */
    private TimeAxisHorizontalScrollView f9410d;

    /* renamed from: f  reason: collision with root package name */
    private TimeAxisScaleView f9411f;
    private b p0;
    private ImageView q;
    private ImageView x;
    private TextView y;
    private Handler z;
    private boolean p1 = false;
    private boolean p2 = false;
    private boolean p3 = false;
    private boolean H3 = false;
    private boolean L3 = false;
    private boolean M3 = false;
    private int N3 = 0;
    private int O3 = 0;

    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f9412c;

        /* renamed from: d  reason: collision with root package name */
        float f9413d;

        /* renamed from: f  reason: collision with root package name */
        int[] f9414f;
        int[] p0;
        int[] p1;
        int[] p2;
        int[] q;
        int[] x;
        int[] y;
        int[] z;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f9412c);
            parcel.writeFloat(this.f9413d);
            parcel.writeIntArray(this.f9414f);
            parcel.writeIntArray(this.q);
            parcel.writeIntArray(this.x);
            parcel.writeIntArray(this.y);
            parcel.writeIntArray(this.z);
            parcel.writeIntArray(this.p0);
            parcel.writeIntArray(this.p1);
            parcel.writeIntArray(this.p2);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f9412c = parcel.readInt();
            this.f9413d = parcel.readFloat();
            this.f9414f = parcel.createIntArray();
            this.q = parcel.createIntArray();
            this.x = parcel.createIntArray();
            this.y = parcel.createIntArray();
            this.z = parcel.createIntArray();
            this.p0 = parcel.createIntArray();
            this.p1 = parcel.createIntArray();
            this.p2 = parcel.createIntArray();
        }
    }

    /* loaded from: classes2.dex */
    public enum Status {
        INIT,
        LOADING,
        TIPS,
        DATA
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Status.values().length];
            a = iArr;
            try {
                iArr[Status.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Status.DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void L();

        void T();

        void x(int i, boolean z);

        void y0(int i, boolean z, boolean z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Handler {
        private c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0 && message.arg1 == TimeAxisLayout.this.f9410d.getScrollX()) {
                removeCallbacksAndMessages(null);
                int i = message.arg2;
                TimeAxisLayout.this.K3 = i;
                boolean z = TimeAxisLayout.this.M3 && i > (TimeAxisLayout.this.N3 * 3600) + (TimeAxisLayout.this.O3 * 60);
                if (TimeAxisLayout.this.p0 != null) {
                    TimeAxisLayout.this.p0.x(i, z);
                }
                TimeAxisLayout.this.p2 = false;
            }
        }

        /* synthetic */ c(TimeAxisLayout timeAxisLayout, a aVar) {
            this();
        }
    }

    public TimeAxisLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        q(context);
    }

    private void p() {
        TimeAxisScaleView timeAxisScaleView = this.f9411f;
        if (timeAxisScaleView != null) {
            timeAxisScaleView.setRecordTimes(null);
            this.f9411f.setMotionDetectTimes(null);
            this.f9411f.setMotionDetectTimesV2(null);
            this.f9411f.setBabyCryDetectTimes(null);
            this.f9411f.setPersonDetectTimes(null);
            this.f9411f.setAreaIntrusionDetectTimes(null);
            this.f9411f.setLineCrossingDetectTimes(null);
            this.f9411f.setCameraTamperDetectTimes(null);
        }
    }

    private void q(Context context) {
        AnimationDrawable animationDrawable;
        this.z = new c(this, null);
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_time_axis, (ViewGroup) this, true);
        this.f9410d = (TimeAxisHorizontalScrollView) inflate.findViewById(R.id.time_axis_scrollview);
        this.f9411f = (TimeAxisScaleView) inflate.findViewById(R.id.time_axis_scaleview);
        this.q = (ImageView) inflate.findViewById(R.id.time_axis_cursor_line_iv);
        this.x = (ImageView) inflate.findViewById(R.id.time_axis_loading_iv);
        this.y = (TextView) inflate.findViewById(R.id.time_axis_tv);
        this.f9410d.setScrollViewListener(this);
        this.f9411f.setScaleViewListener(this);
        ImageView imageView = this.x;
        if (!(imageView == null || (animationDrawable = (AnimationDrawable) imageView.getDrawable()) == null || animationDrawable.isRunning())) {
            animationDrawable.start();
        }
        t(Status.INIT);
    }

    private boolean r(int i) {
        return this.M3 && i > (this.N3 * 3600) + (this.O3 * 60);
    }

    private void setCurrentTimeInternal(int i) {
        this.K3 = i;
        this.J3 = i;
        this.I3 = i;
        int max = Math.max(0, i);
        this.I3 = max;
        int min = Math.min(this.M3 ? 90000 : 86400, max);
        this.I3 = min;
        if (!this.p2 && !this.p1) {
            int f2 = this.f9411f.f(min);
            if (f2 == this.f9410d.getScrollX()) {
                b bVar = this.p0;
                if (bVar != null) {
                    bVar.y0(this.K3, false, r(this.I3));
                    return;
                }
                return;
            }
            this.H3 = true;
            this.f9410d.scrollTo(f2, 0);
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisScaleView.a
    public void a() {
        int max = Math.max(0, this.I3);
        this.I3 = max;
        int min = Math.min(this.M3 ? 90000 : 86400, max);
        this.I3 = min;
        int f2 = this.f9411f.f(min);
        this.p3 = true;
        this.f9410d.scrollTo(f2, 0);
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisHorizontalScrollView.b
    public void b() {
        if (this.p1) {
            this.p1 = false;
            this.p0.L();
        }
        setCurrentTimeInternal(this.K3);
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisHorizontalScrollView.b
    public void c() {
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisHorizontalScrollView.b
    public void d(TimeAxisHorizontalScrollView timeAxisHorizontalScrollView, int i, int i2, int i3, int i4) {
        TimeAxisScaleView timeAxisScaleView = this.f9411f;
        if (timeAxisScaleView != null && !this.p1) {
            this.p2 = true;
            if (i < 0 || timeAxisScaleView.getValidLength() == 0) {
                this.I3 = 0;
            } else {
                this.I3 = this.f9411f.d(i);
            }
            if (this.H3) {
                this.H3 = false;
                this.p2 = false;
                int i5 = this.J3;
                this.K3 = i5;
                b bVar = this.p0;
                if (bVar != null) {
                    bVar.y0(i5, false, r(this.I3));
                }
            } else if (this.p3) {
                this.p3 = false;
                this.p2 = false;
            } else {
                int i6 = this.I3;
                this.K3 = i6;
                b bVar2 = this.p0;
                if (bVar2 != null) {
                    bVar2.y0(i6, true, r(i6));
                }
                long j = this.L3 ? 1500L : 200L;
                Handler handler = this.z;
                handler.sendMessageDelayed(handler.obtainMessage(0, i, this.I3), j);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.L3 = true;
        } else if (action == 1 || action == 3) {
            this.L3 = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisHorizontalScrollView.b
    public void e() {
        if (!this.p1) {
            this.p1 = true;
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisHorizontalScrollView.b
    public void f(float f2) {
        this.f9411f.setZoomScale(f2);
        setCurrentTimeInternal(this.K3);
        this.p0.T();
    }

    @Override // com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisHorizontalScrollView.b
    public void g() {
    }

    public int getCurrentTime() {
        return this.K3;
    }

    public boolean getShowTimeAxis() {
        return this.f9411f.i();
    }

    public float getZoomRation() {
        return this.f9411f.getZoomRatio();
    }

    public void o() {
        TimeAxisScaleView timeAxisScaleView = this.f9411f;
        if (timeAxisScaleView != null) {
            timeAxisScaleView.a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        TimeAxisScaleView timeAxisScaleView = this.f9411f;
        if (!(timeAxisScaleView == null || mode == 0)) {
            timeAxisScaleView.setBlankWidth(size / 2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        setCurrentTimeInternal(savedState.f9412c);
        this.f9411f.setZoomRatio(savedState.f9413d);
        int[] iArr = savedState.f9414f;
        ArrayList<int[]> arrayList = new ArrayList<>((iArr.length / 2) + 1);
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = i * 2;
            arrayList.add(new int[]{iArr[i2], iArr[i2 + 1]});
        }
        this.f9411f.setRecordTimes(arrayList);
        int[] iArr2 = savedState.q;
        ArrayList<int[]> arrayList2 = new ArrayList<>((iArr2.length / 2) + 1);
        for (int i3 = 0; i3 < iArr2.length / 2; i3++) {
            int i4 = i3 * 2;
            arrayList2.add(new int[]{iArr2[i4], iArr2[i4 + 1]});
        }
        this.f9411f.setMotionDetectTimes(arrayList2);
        int[] iArr3 = savedState.x;
        ArrayList<int[]> arrayList3 = new ArrayList<>((iArr3.length / 2) + 1);
        for (int i5 = 0; i5 < iArr3.length / 2; i5++) {
            int i6 = i5 * 2;
            arrayList3.add(new int[]{iArr3[i6], iArr3[i6 + 1]});
        }
        this.f9411f.setMotionDetectTimesV2(arrayList3);
        int[] iArr4 = savedState.y;
        ArrayList<int[]> arrayList4 = new ArrayList<>((iArr4.length / 2) + 1);
        for (int i7 = 0; i7 < iArr4.length / 2; i7++) {
            int i8 = i7 * 2;
            arrayList4.add(new int[]{iArr4[i8], iArr4[i8 + 1]});
        }
        this.f9411f.setBabyCryDetectTimes(arrayList4);
        int[] iArr5 = savedState.z;
        ArrayList<int[]> arrayList5 = new ArrayList<>((iArr5.length / 2) + 1);
        for (int i9 = 0; i9 < iArr5.length / 2; i9++) {
            int i10 = i9 * 2;
            arrayList5.add(new int[]{iArr5[i10], iArr5[i10 + 1]});
        }
        this.f9411f.setPersonDetectTimes(arrayList5);
        int[] iArr6 = savedState.p0;
        ArrayList<int[]> arrayList6 = new ArrayList<>((iArr6.length / 2) + 1);
        for (int i11 = 0; i11 < iArr6.length / 2; i11++) {
            int i12 = i11 * 2;
            arrayList6.add(new int[]{iArr6[i12], iArr6[i12 + 1]});
        }
        this.f9411f.setAreaIntrusionDetectTimes(arrayList6);
        int[] iArr7 = savedState.p1;
        ArrayList<int[]> arrayList7 = new ArrayList<>((iArr7.length / 2) + 1);
        for (int i13 = 0; i13 < iArr7.length / 2; i13++) {
            int i14 = i13 * 2;
            arrayList7.add(new int[]{iArr7[i14], iArr7[i14 + 1]});
        }
        this.f9411f.setLineCrossingDetectTimes(arrayList7);
        int[] iArr8 = savedState.p2;
        ArrayList<int[]> arrayList8 = new ArrayList<>((iArr8.length / 2) + 1);
        for (int i15 = 0; i15 < iArr8.length / 2; i15++) {
            int i16 = i15 * 2;
            arrayList8.add(new int[]{iArr8[i16], iArr8[i16 + 1]});
        }
        this.f9411f.setCameraTamperDetectTimes(arrayList8);
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f9412c = this.K3;
        savedState.f9413d = this.f9411f.getZoomRatio();
        ArrayList<int[]> recordTimes = this.f9411f.getRecordTimes();
        int[] iArr = new int[recordTimes.size() * 2];
        for (int i = 0; i < recordTimes.size(); i++) {
            int i2 = i * 2;
            iArr[i2] = recordTimes.get(i)[0];
            iArr[i2 + 1] = recordTimes.get(i)[1];
        }
        savedState.f9414f = iArr;
        ArrayList<int[]> motionDetectTimes = this.f9411f.getMotionDetectTimes();
        int[] iArr2 = new int[motionDetectTimes.size() * 2];
        for (int i3 = 0; i3 < motionDetectTimes.size(); i3++) {
            int i4 = i3 * 2;
            iArr2[i4] = motionDetectTimes.get(i3)[0];
            iArr2[i4 + 1] = motionDetectTimes.get(i3)[1];
        }
        savedState.q = iArr2;
        ArrayList<int[]> motionDetectTimesV2 = this.f9411f.getMotionDetectTimesV2();
        int[] iArr3 = new int[motionDetectTimesV2.size() * 2];
        for (int i5 = 0; i5 < motionDetectTimesV2.size(); i5++) {
            int i6 = i5 * 2;
            iArr3[i6] = motionDetectTimesV2.get(i5)[0];
            iArr3[i6 + 1] = motionDetectTimesV2.get(i5)[1];
        }
        savedState.x = iArr3;
        ArrayList<int[]> babyCryDetectTimes = this.f9411f.getBabyCryDetectTimes();
        int[] iArr4 = new int[babyCryDetectTimes.size() * 2];
        for (int i7 = 0; i7 < babyCryDetectTimes.size(); i7++) {
            int i8 = i7 * 2;
            iArr4[i8] = babyCryDetectTimes.get(i7)[0];
            iArr4[i8 + 1] = babyCryDetectTimes.get(i7)[1];
        }
        savedState.y = iArr4;
        ArrayList<int[]> personDetectTimes = this.f9411f.getPersonDetectTimes();
        int[] iArr5 = new int[personDetectTimes.size() * 2];
        for (int i9 = 0; i9 < personDetectTimes.size(); i9++) {
            int i10 = i9 * 2;
            iArr5[i10] = personDetectTimes.get(i9)[0];
            iArr5[i10 + 1] = personDetectTimes.get(i9)[1];
        }
        savedState.z = iArr5;
        ArrayList<int[]> areaIntrusionDetectTimes = this.f9411f.getAreaIntrusionDetectTimes();
        int[] iArr6 = new int[areaIntrusionDetectTimes.size() * 2];
        for (int i11 = 0; i11 < areaIntrusionDetectTimes.size(); i11++) {
            int i12 = i11 * 2;
            iArr6[i12] = areaIntrusionDetectTimes.get(i11)[0];
            iArr6[i12 + 1] = areaIntrusionDetectTimes.get(i11)[1];
        }
        savedState.p0 = iArr6;
        ArrayList<int[]> lineCrossingDetectTimes = this.f9411f.getLineCrossingDetectTimes();
        int[] iArr7 = new int[lineCrossingDetectTimes.size() * 2];
        for (int i13 = 0; i13 < lineCrossingDetectTimes.size(); i13++) {
            int i14 = i13 * 2;
            iArr7[i14] = lineCrossingDetectTimes.get(i13)[0];
            iArr7[i14 + 1] = lineCrossingDetectTimes.get(i13)[1];
        }
        savedState.p1 = iArr7;
        ArrayList<int[]> cameraTamperDetectTimes = this.f9411f.getCameraTamperDetectTimes();
        int[] iArr8 = new int[cameraTamperDetectTimes.size() * 2];
        for (int i15 = 0; i15 < cameraTamperDetectTimes.size(); i15++) {
            int i16 = i15 * 2;
            iArr8[i16] = cameraTamperDetectTimes.get(i15)[0];
            iArr8[i16 + 1] = cameraTamperDetectTimes.get(i15)[1];
        }
        savedState.p2 = iArr8;
        return savedState;
    }

    public void s(boolean z, int i, int i2) {
        this.M3 = z;
        this.N3 = i;
        this.O3 = i2;
        this.f9411f.l(z, i, i2);
    }

    public void setAreaIntrusionDetectTimes(ArrayList<int[]> arrayList) {
        TimeAxisScaleView timeAxisScaleView = this.f9411f;
        if (timeAxisScaleView != null) {
            timeAxisScaleView.setAreaIntrusionDetectTimes(arrayList);
        }
    }

    public void setBabyCryDetectTimes(ArrayList<int[]> arrayList) {
        TimeAxisScaleView timeAxisScaleView = this.f9411f;
        if (timeAxisScaleView != null) {
            timeAxisScaleView.setBabyCryDetectTimes(arrayList);
        }
    }

    public void setCameraTamperDetectTimes(ArrayList<int[]> arrayList) {
        TimeAxisScaleView timeAxisScaleView = this.f9411f;
        if (timeAxisScaleView != null) {
            timeAxisScaleView.setCameraTamperDetectTimes(arrayList);
        }
    }

    public void setCurrentTime(int i) {
        setCurrentTimeInternal(i);
    }

    public void setIOnTimeChangedListener(b bVar) {
        this.p0 = bVar;
    }

    public void setInterceptTouch(boolean z) {
        this.f9410d.setInterceptTouch(z);
    }

    public void setLineCrossingDetectTimes(ArrayList<int[]> arrayList) {
        TimeAxisScaleView timeAxisScaleView = this.f9411f;
        if (timeAxisScaleView != null) {
            timeAxisScaleView.setLineCrossingDetectTimes(arrayList);
        }
    }

    public void setMotionDetectTimes(ArrayList<int[]> arrayList) {
        TimeAxisScaleView timeAxisScaleView = this.f9411f;
        if (timeAxisScaleView != null) {
            timeAxisScaleView.setMotionDetectTimes(arrayList);
        }
    }

    public void setMotionDetectTimesV2(ArrayList<int[]> arrayList) {
        TimeAxisScaleView timeAxisScaleView = this.f9411f;
        if (timeAxisScaleView != null) {
            timeAxisScaleView.setMotionDetectTimesV2(arrayList);
        }
    }

    public void setPersonDetectTimes(ArrayList<int[]> arrayList) {
        TimeAxisScaleView timeAxisScaleView = this.f9411f;
        if (timeAxisScaleView != null) {
            timeAxisScaleView.setPersonDetectTimes(arrayList);
        }
    }

    public void setRecordTimes(ArrayList<int[]> arrayList) {
        TimeAxisScaleView timeAxisScaleView = this.f9411f;
        if (timeAxisScaleView != null) {
            timeAxisScaleView.setRecordTimes(arrayList);
        }
    }

    public void setZoomRatio(float f2) {
        this.f9411f.setZoomRatio(f2);
    }

    public void t(Status status) {
        int i = a.a[status.ordinal()];
        if (i == 1) {
            this.q.setVisibility(0);
            this.y.setVisibility(8);
            this.x.setVisibility(8);
            p();
            setCurrentTime(43200);
        } else if (i == 2) {
            this.y.setVisibility(8);
            this.x.setVisibility(8);
            this.q.setVisibility(0);
        }
    }

    public TimeAxisLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q(context);
    }

    public TimeAxisLayout(Context context) {
        super(context);
        q(context);
    }
}
