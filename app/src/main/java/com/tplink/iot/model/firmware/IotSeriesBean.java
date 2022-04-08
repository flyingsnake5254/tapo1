package com.tplink.iot.model.firmware;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.iot.view.quicksetup.base.EnumCountry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class IotSeriesBean implements Serializable {
    private EnumCountry countrySpecs;
    private String id;
    private int installTime;
    private String model;
    private String newVersion;
    private String releaseNote;
    private EnumIoTSeriesState currentState = EnumIoTSeriesState.IDLE;
    private final List<t> ioTDeviceStateList = new ArrayList();
    private int progress = 0;
    private int successCount = 0;
    private boolean isInstallFollowDownloaded = true;

    public ArrayList<t> getBatteryDisallowList() {
        ArrayList<t> arrayList = new ArrayList<>();
        for (t tVar : this.ioTDeviceStateList) {
            if (tVar.h()) {
                arrayList.add(tVar);
            }
        }
        return arrayList;
    }

    public EnumCountry getCountrySpecs() {
        return this.countrySpecs;
    }

    public EnumIoTSeriesState getCurrentState() {
        return this.currentState;
    }

    public ArrayList<t> getDownloadFailedList() {
        ArrayList<t> arrayList = new ArrayList<>();
        for (t tVar : this.ioTDeviceStateList) {
            if (tVar.k()) {
                arrayList.add(tVar);
            }
        }
        return arrayList;
    }

    public ArrayList<t> getDownloadSuccessList() {
        ArrayList<t> arrayList = new ArrayList<>();
        for (t tVar : this.ioTDeviceStateList) {
            if (tVar.l()) {
                arrayList.add(tVar);
            }
        }
        return arrayList;
    }

    public String getId() {
        return this.id;
    }

    public int getInstallTime() {
        return this.installTime;
    }

    public List<t> getIoTDeviceStateList() {
        return this.ioTDeviceStateList;
    }

    public String getModel() {
        return this.model;
    }

    public String getNewVersion() {
        return TextUtils.isEmpty(this.newVersion) ? "" : this.newVersion;
    }

    public int getProgress() {
        return this.progress;
    }

    public String getReleaseNote() {
        return this.releaseNote;
    }

    public int getSize() {
        return this.ioTDeviceStateList.size();
    }

    public int getSuccessCount() {
        return this.successCount;
    }

    public ArrayList<t> getTransferFailedList() {
        ArrayList<t> arrayList = new ArrayList<>();
        for (t tVar : this.ioTDeviceStateList) {
            if (tVar.p()) {
                arrayList.add(tVar);
            }
        }
        return arrayList;
    }

    public boolean isInSeries(t tVar) {
        for (t tVar2 : this.ioTDeviceStateList) {
            if (tVar == tVar2) {
                return true;
            }
        }
        return false;
    }

    public boolean isInstallFollowDownloaded() {
        return this.isInstallFollowDownloaded;
    }

    public void putIotDevice(t tVar) {
        this.ioTDeviceStateList.add(tVar);
    }

    public void removeUpdateSuccessDevices() {
        Iterator<t> it = this.ioTDeviceStateList.iterator();
        while (it.hasNext()) {
            if (it.next().b() == 3) {
                it.remove();
            }
        }
    }

    public void replaceAllDevices(List<t> list) {
        for (t tVar : list) {
            Iterator<t> it = this.ioTDeviceStateList.iterator();
            while (true) {
                if (it.hasNext()) {
                    t next = it.next();
                    if (tVar.a().equals(next.a())) {
                        if (next.f() > tVar.f()) {
                            tVar.s(next.f());
                            tVar.q(next.b());
                            tVar.r(next.c());
                        }
                    }
                }
            }
        }
        this.ioTDeviceStateList.clear();
        setIoTDeviceStateList(list);
    }

    public void setCountrySpecs(EnumCountry enumCountry) {
        this.countrySpecs = enumCountry;
    }

    public void setCurrentState(EnumIoTSeriesState enumIoTSeriesState) {
        this.currentState = enumIoTSeriesState;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setInstallFollowDownloaded(boolean z) {
        this.isInstallFollowDownloaded = z;
    }

    public void setInstallTime(int i) {
        this.installTime = i;
    }

    public void setIoTDeviceStateList(List<t> list) {
        if (list != null && list.size() > 0) {
            this.ioTDeviceStateList.addAll(list);
        }
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setNewVersion(String str) {
        this.newVersion = str;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public void setReleaseNote(String str) {
        this.releaseNote = str;
    }

    public void setSuccessCount(int i) {
        this.successCount = i;
    }

    @NonNull
    public String toString() {
        return "IotSeriesBean id: " + this.id + " iotDevicesStateList.size: " + this.ioTDeviceStateList.size();
    }
}
