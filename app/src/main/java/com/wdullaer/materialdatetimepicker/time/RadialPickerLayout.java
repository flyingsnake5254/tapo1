package com.wdullaer.materialdatetimepicker.time;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.wdullaer.materialdatetimepicker.time.Timepoint;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class RadialPickerLayout extends FrameLayout implements View.OnTouchListener {
    private RadialTextsView H3;
    private RadialTextsView I3;
    private RadialTextsView J3;
    private RadialSelectorView K3;
    private RadialSelectorView L3;
    private RadialSelectorView M3;
    private View N3;
    private int[] O3;
    private boolean S3;
    private int T3;
    private float U3;
    private float V3;
    private AccessibilityManager W3;

    /* renamed from: c  reason: collision with root package name */
    private final int f15312c;
    private boolean p0;
    private int p1;
    private CircleView p2;
    private AmPmCirclesView p3;
    private a q;
    private c x;
    private Timepoint z;
    private int Q3 = -1;
    private Handler X3 = new Handler();

    /* renamed from: d  reason: collision with root package name */
    private final int f15313d = ViewConfiguration.getTapTimeout();
    private boolean R3 = false;

    /* renamed from: f  reason: collision with root package name */
    private Timepoint f15314f = null;
    private boolean P3 = true;
    private boolean y = false;

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RadialPickerLayout.this.p3.setAmOrPmPressed(RadialPickerLayout.this.Q3);
            RadialPickerLayout.this.p3.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Boolean[] f15316c;

        b(Boolean[] boolArr) {
            this.f15316c = boolArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            RadialPickerLayout.this.R3 = true;
            RadialPickerLayout radialPickerLayout = RadialPickerLayout.this;
            radialPickerLayout.f15314f = radialPickerLayout.l(radialPickerLayout.T3, this.f15316c[0].booleanValue(), false);
            RadialPickerLayout radialPickerLayout2 = RadialPickerLayout.this;
            radialPickerLayout2.f15314f = radialPickerLayout2.p(radialPickerLayout2.f15314f, RadialPickerLayout.this.getCurrentItemShowing());
            RadialPickerLayout radialPickerLayout3 = RadialPickerLayout.this;
            radialPickerLayout3.o(radialPickerLayout3.f15314f, true, RadialPickerLayout.this.getCurrentItemShowing());
            RadialPickerLayout.this.x.a(RadialPickerLayout.this.f15314f);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Timepoint timepoint);

        void b();

        void c(int i);
    }

    public RadialPickerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnTouchListener(this);
        this.f15312c = ViewConfiguration.get(context).getScaledTouchSlop();
        CircleView circleView = new CircleView(context);
        this.p2 = circleView;
        addView(circleView);
        AmPmCirclesView amPmCirclesView = new AmPmCirclesView(context);
        this.p3 = amPmCirclesView;
        addView(amPmCirclesView);
        RadialSelectorView radialSelectorView = new RadialSelectorView(context);
        this.K3 = radialSelectorView;
        addView(radialSelectorView);
        RadialSelectorView radialSelectorView2 = new RadialSelectorView(context);
        this.L3 = radialSelectorView2;
        addView(radialSelectorView2);
        RadialSelectorView radialSelectorView3 = new RadialSelectorView(context);
        this.M3 = radialSelectorView3;
        addView(radialSelectorView3);
        RadialTextsView radialTextsView = new RadialTextsView(context);
        this.H3 = radialTextsView;
        addView(radialTextsView);
        RadialTextsView radialTextsView2 = new RadialTextsView(context);
        this.I3 = radialTextsView2;
        addView(radialTextsView2);
        RadialTextsView radialTextsView3 = new RadialTextsView(context);
        this.J3 = radialTextsView3;
        addView(radialTextsView3);
        n();
        View view = new View(context);
        this.N3 = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.N3.setBackgroundColor(ContextCompat.getColor(context, com.wdullaer.materialdatetimepicker.a.mdtp_transparent_black));
        this.N3.setVisibility(4);
        addView(this.N3);
        this.W3 = (AccessibilityManager) context.getSystemService("accessibility");
    }

    private int getCurrentlyShowingValue() {
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            return this.z.b();
        }
        if (currentItemShowing == 1) {
            return this.z.c();
        }
        if (currentItemShowing != 2) {
            return -1;
        }
        return this.z.d();
    }

    private int k(float f2, float f3, boolean z, Boolean[] boolArr) {
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            return this.K3.a(f2, f3, z, boolArr);
        }
        if (currentItemShowing == 1) {
            return this.L3.a(f2, f3, z, boolArr);
        }
        if (currentItemShowing != 2) {
            return -1;
        }
        return this.M3.a(f2, f3, z, boolArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
        if (r8 == false) goto L_0x0043;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0038, code lost:
        if (r7 == 0) goto L_0x003a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0041, code lost:
        if (r0 == 2) goto L_0x0043;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.wdullaer.materialdatetimepicker.time.Timepoint l(int r7, boolean r8, boolean r9) {
        /*
            r6 = this;
            r0 = -1
            if (r7 != r0) goto L_0x0005
            r7 = 0
            return r7
        L_0x0005:
            int r0 = r6.getCurrentItemShowing()
            r1 = 2
            r2 = 0
            r3 = 1
            if (r9 != 0) goto L_0x0014
            if (r0 == r3) goto L_0x0012
            if (r0 != r1) goto L_0x0014
        L_0x0012:
            r9 = 1
            goto L_0x0015
        L_0x0014:
            r9 = 0
        L_0x0015:
            if (r9 == 0) goto L_0x001c
            int r7 = r6.s(r7)
            goto L_0x0020
        L_0x001c:
            int r7 = r(r7, r2)
        L_0x0020:
            r9 = 6
            if (r0 == 0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r9 = 30
        L_0x0026:
            r4 = 360(0x168, float:5.04E-43)
            if (r0 != 0) goto L_0x003d
            boolean r5 = r6.p0
            if (r5 == 0) goto L_0x0038
            if (r7 != 0) goto L_0x0033
            if (r8 == 0) goto L_0x0033
            goto L_0x003a
        L_0x0033:
            if (r7 != r4) goto L_0x0044
            if (r8 != 0) goto L_0x0044
            goto L_0x0043
        L_0x0038:
            if (r7 != 0) goto L_0x0044
        L_0x003a:
            r7 = 360(0x168, float:5.04E-43)
            goto L_0x0044
        L_0x003d:
            if (r7 != r4) goto L_0x0044
            if (r0 == r3) goto L_0x0043
            if (r0 != r1) goto L_0x0044
        L_0x0043:
            r7 = 0
        L_0x0044:
            int r9 = r7 / r9
            if (r0 != 0) goto L_0x0052
            boolean r5 = r6.p0
            if (r5 == 0) goto L_0x0052
            if (r8 != 0) goto L_0x0052
            if (r7 == 0) goto L_0x0052
            int r9 = r9 + 12
        L_0x0052:
            if (r0 != 0) goto L_0x0066
            com.wdullaer.materialdatetimepicker.time.a r8 = r6.q
            com.wdullaer.materialdatetimepicker.time.TimePickerDialog$Version r8 = r8.getVersion()
            com.wdullaer.materialdatetimepicker.time.TimePickerDialog$Version r5 = com.wdullaer.materialdatetimepicker.time.TimePickerDialog$Version.VERSION_1
            if (r8 == r5) goto L_0x0066
            boolean r8 = r6.p0
            if (r8 == 0) goto L_0x0066
            int r9 = r9 + 12
            int r9 = r9 % 24
        L_0x0066:
            if (r0 == 0) goto L_0x0093
            if (r0 == r3) goto L_0x0081
            if (r0 == r1) goto L_0x006f
            com.wdullaer.materialdatetimepicker.time.Timepoint r7 = r6.z
            goto L_0x00c0
        L_0x006f:
            com.wdullaer.materialdatetimepicker.time.Timepoint r7 = new com.wdullaer.materialdatetimepicker.time.Timepoint
            com.wdullaer.materialdatetimepicker.time.Timepoint r8 = r6.z
            int r8 = r8.b()
            com.wdullaer.materialdatetimepicker.time.Timepoint r0 = r6.z
            int r0 = r0.c()
            r7.<init>(r8, r0, r9)
            goto L_0x00c0
        L_0x0081:
            com.wdullaer.materialdatetimepicker.time.Timepoint r7 = new com.wdullaer.materialdatetimepicker.time.Timepoint
            com.wdullaer.materialdatetimepicker.time.Timepoint r8 = r6.z
            int r8 = r8.b()
            com.wdullaer.materialdatetimepicker.time.Timepoint r0 = r6.z
            int r0 = r0.d()
            r7.<init>(r8, r9, r0)
            goto L_0x00c0
        L_0x0093:
            boolean r8 = r6.p0
            if (r8 != 0) goto L_0x00a1
            int r8 = r6.getIsCurrentlyAmOrPm()
            if (r8 != r3) goto L_0x00a1
            if (r7 == r4) goto L_0x00a1
            int r9 = r9 + 12
        L_0x00a1:
            boolean r8 = r6.p0
            if (r8 != 0) goto L_0x00ae
            int r8 = r6.getIsCurrentlyAmOrPm()
            if (r8 != 0) goto L_0x00ae
            if (r7 != r4) goto L_0x00ae
            goto L_0x00af
        L_0x00ae:
            r2 = r9
        L_0x00af:
            com.wdullaer.materialdatetimepicker.time.Timepoint r7 = new com.wdullaer.materialdatetimepicker.time.Timepoint
            com.wdullaer.materialdatetimepicker.time.Timepoint r8 = r6.z
            int r8 = r8.c()
            com.wdullaer.materialdatetimepicker.time.Timepoint r9 = r6.z
            int r9 = r9.d()
            r7.<init>(r2, r8, r9)
        L_0x00c0:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.l(int, boolean, boolean):com.wdullaer.materialdatetimepicker.time.Timepoint");
    }

    private boolean m(int i) {
        boolean z = i <= 12 && i != 0;
        if (this.q.getVersion() != TimePickerDialog$Version.VERSION_1) {
            z = !z;
        }
        return this.p0 && z;
    }

    private void n() {
        this.O3 = new int[361];
        int i = 0;
        int i2 = 8;
        int i3 = 1;
        for (int i4 = 0; i4 < 361; i4++) {
            this.O3[i4] = i;
            if (i3 == i2) {
                i += 6;
                if (i == 360) {
                    i2 = 7;
                } else {
                    i2 = i % 30 == 0 ? 14 : 4;
                }
                i3 = 1;
            } else {
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Timepoint timepoint, boolean z, int i) {
        if (i == 0) {
            int b2 = timepoint.b();
            boolean m = m(b2);
            int i2 = b2 % 12;
            int i3 = (i2 * 360) / 12;
            boolean z2 = this.p0;
            if (!z2) {
                b2 = i2;
            }
            if (!z2 && b2 == 0) {
                b2 += 12;
            }
            this.K3.b(i3, m, z);
            this.H3.setSelection(b2);
            if (timepoint.c() != this.z.c()) {
                this.L3.b(timepoint.c() * 6, m, z);
                this.I3.setSelection(timepoint.c());
            }
            if (timepoint.d() != this.z.d()) {
                this.M3.b(timepoint.d() * 6, m, z);
                this.J3.setSelection(timepoint.d());
            }
        } else if (i == 1) {
            this.L3.b(timepoint.c() * 6, false, z);
            this.I3.setSelection(timepoint.c());
            if (timepoint.d() != this.z.d()) {
                this.M3.b(timepoint.d() * 6, false, z);
                this.J3.setSelection(timepoint.d());
            }
        } else if (i == 2) {
            this.M3.b(timepoint.d() * 6, false, z);
            this.J3.setSelection(timepoint.d());
        }
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            this.K3.invalidate();
            this.H3.invalidate();
        } else if (currentItemShowing == 1) {
            this.L3.invalidate();
            this.I3.invalidate();
        } else if (currentItemShowing == 2) {
            this.M3.invalidate();
            this.J3.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Timepoint p(Timepoint timepoint, int i) {
        if (i == 0) {
            return this.q.b(timepoint, null);
        }
        if (i != 1) {
            return this.q.b(timepoint, Timepoint.TYPE.MINUTE);
        }
        return this.q.b(timepoint, Timepoint.TYPE.HOUR);
    }

    private void q(int i, Timepoint timepoint) {
        Timepoint p = p(timepoint, i);
        this.z = p;
        o(p, false, i);
    }

    private static int r(int i, int i2) {
        int i3 = (i / 30) * 30;
        int i4 = i3 + 30;
        if (i2 != 1) {
            if (i2 == -1) {
                return i == i3 ? i3 - 30 : i3;
            }
            if (i - i3 < i4 - i) {
                return i3;
            }
        }
        return i4;
    }

    private int s(int i) {
        int[] iArr = this.O3;
        if (iArr == null) {
            return -1;
        }
        return iArr[i];
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        accessibilityEvent.getText().clear();
        Calendar instance = Calendar.getInstance();
        instance.set(10, getHours());
        instance.set(12, getMinutes());
        instance.set(13, getSeconds());
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), instance.getTimeInMillis(), this.p0 ? 129 : 1));
        return true;
    }

    public int getCurrentItemShowing() {
        int i = this.p1;
        if (i == 0 || i == 1 || i == 2) {
            return i;
        }
        Log.e("RadialPickerLayout", "Current item showing was unfortunately set to " + this.p1);
        return -1;
    }

    public int getHours() {
        return this.z.b();
    }

    public int getIsCurrentlyAmOrPm() {
        if (this.z.e()) {
            return 0;
        }
        return this.z.f() ? 1 : -1;
    }

    public int getMinutes() {
        return this.z.c();
    }

    public int getSeconds() {
        return this.z.d();
    }

    public Timepoint getTime() {
        return this.z;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        } else if (i >= 16) {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r11 <= r7) goto L_0x0151;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        int i2;
        Timepoint timepoint;
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        int i3 = Build.VERSION.SDK_INT;
        int i4 = 0;
        int i5 = i == 4096 ? 1 : i == 8192 ? -1 : 0;
        if (i5 == 0) {
            return false;
        }
        int currentlyShowingValue = getCurrentlyShowingValue();
        int currentItemShowing = getCurrentItemShowing();
        int i6 = 6;
        if (currentItemShowing == 0) {
            i6 = 30;
            currentlyShowingValue %= 12;
        } else if (!(currentItemShowing == 1 || currentItemShowing == 2)) {
            i6 = 0;
        }
        int r = r(currentlyShowingValue * i6, i5) / i6;
        if (currentItemShowing != 0) {
            i2 = 55;
        } else if (this.p0) {
            i2 = 23;
        } else {
            i2 = 12;
            i4 = 1;
        }
        if (r > i2) {
            r = i4;
        } else if (r < i4) {
            r = i2;
        }
        if (currentItemShowing == 0) {
            timepoint = new Timepoint(r, this.z.c(), this.z.d());
        } else if (currentItemShowing == 1) {
            timepoint = new Timepoint(this.z.b(), r, this.z.d());
        } else if (currentItemShowing != 2) {
            timepoint = this.z;
            q(currentItemShowing, timepoint);
            this.x.a(timepoint);
            return true;
        } else {
            timepoint = new Timepoint(this.z.b(), this.z.c(), r);
        }
        q(currentItemShowing, timepoint);
        this.x.a(timepoint);
        return true;
    }

    public void setAmOrPm(int i) {
        this.p3.setAmOrPm(i);
        this.p3.invalidate();
        Timepoint timepoint = new Timepoint(this.z);
        if (i == 0) {
            timepoint.h();
        } else if (i == 1) {
            timepoint.i();
        }
        Timepoint p = p(timepoint, 0);
        o(p, false, 0);
        this.z = p;
        this.x.a(p);
    }

    public void setOnValueSelectedListener(c cVar) {
        this.x = cVar;
    }

    public void setTime(Timepoint timepoint) {
        q(0, timepoint);
    }
}
