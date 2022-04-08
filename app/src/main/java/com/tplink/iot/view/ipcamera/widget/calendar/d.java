package com.tplink.iot.view.ipcamera.widget.calendar;

/* compiled from: OneDayInfo.java */
/* loaded from: classes2.dex */
public class d {
    int a;

    /* renamed from: b  reason: collision with root package name */
    int f9348b;

    /* renamed from: c  reason: collision with root package name */
    int f9349c;

    public d(int i, int i2, int i3) {
        this.a = i;
        this.f9348b = i2;
        this.f9349c = i3;
    }

    /* renamed from: a */
    public d clone() {
        return new d(this.a, this.f9348b, this.f9349c);
    }

    public int b(d dVar) {
        if (this.a < dVar.e()) {
            return -1;
        }
        if (this.a > dVar.e()) {
            return 1;
        }
        if (this.f9348b < dVar.d()) {
            return -1;
        }
        if (this.f9348b > dVar.d()) {
            return 1;
        }
        if (this.f9349c < dVar.c()) {
            return -1;
        }
        return this.f9349c > dVar.c() ? 1 : 0;
    }

    public int c() {
        return this.f9349c;
    }

    public int d() {
        return this.f9348b;
    }

    public int e() {
        return this.a;
    }

    public void f() {
        int i = this.f9348b;
        if (i == 1) {
            this.a--;
            this.f9348b = 12;
        } else {
            this.f9348b = i - 1;
        }
        this.f9349c = 1;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.a);
        stringBuffer.append("-");
        if (this.f9348b < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(this.f9348b);
        stringBuffer.append("-");
        if (this.f9349c < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(this.f9349c);
        return stringBuffer.toString();
    }
}
