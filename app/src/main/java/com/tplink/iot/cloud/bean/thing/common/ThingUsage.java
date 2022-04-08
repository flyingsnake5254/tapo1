package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;

/* loaded from: classes2.dex */
public class ThingUsage {
    @c("energy_usage")
    private ThingEnergyUsage energyUsage;
    @c("power_usage")
    private ThingUsageDetail powerUsage;
    @c("saved_power")
    private ThingUsageDetail savedUsage;
    @c("temperature_records")
    private ThingTemperatureRecords temperatureRecords;
    @c("time_usage")
    private ThingUsageDetail timeUsage;

    public ThingEnergyUsage getEnergyUsage() {
        return this.energyUsage;
    }

    public ThingUsageDetail getPowerUsage() {
        return this.powerUsage;
    }

    public ThingUsageDetail getSavedUsage() {
        return this.savedUsage;
    }

    public ThingTemperatureRecords getTemperatureRecords() {
        return this.temperatureRecords;
    }

    public ThingUsageDetail getTimeUsage() {
        return this.timeUsage;
    }

    public void setEnergyUsage(ThingEnergyUsage thingEnergyUsage) {
        this.energyUsage = thingEnergyUsage;
    }

    public void setPowerUsage(ThingUsageDetail thingUsageDetail) {
        this.powerUsage = thingUsageDetail;
    }

    public void setSavedUsage(ThingUsageDetail thingUsageDetail) {
        this.savedUsage = thingUsageDetail;
    }

    public void setTemperatureRecords(ThingTemperatureRecords thingTemperatureRecords) {
        this.temperatureRecords = thingTemperatureRecords;
    }

    public void setTimeUsage(ThingUsageDetail thingUsageDetail) {
        this.timeUsage = thingUsageDetail;
    }
}
