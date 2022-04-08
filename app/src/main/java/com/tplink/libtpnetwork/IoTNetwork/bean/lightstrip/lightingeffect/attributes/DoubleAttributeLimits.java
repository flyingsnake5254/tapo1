package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

/* loaded from: classes3.dex */
public class DoubleAttributeLimits extends AbstractNumberAttributeLimits<Double> {
    private DoubleRange absolute;
    private DoubleRangeLimit range;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private DoubleRange absolute;
        private DoubleRangeLimit range;

        public Builder absolute(DoubleRange doubleRange) {
            this.absolute = doubleRange;
            return this;
        }

        public DoubleAttributeLimits build() {
            DoubleAttributeLimits doubleAttributeLimits = new DoubleAttributeLimits();
            doubleAttributeLimits.setAbsolute(this.absolute);
            doubleAttributeLimits.setRange(this.range);
            return doubleAttributeLimits;
        }

        public Builder range(DoubleRangeLimit doubleRangeLimit) {
            this.range = doubleRangeLimit;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeLimits
    public void setAbsolute(AbstractRange<Double> abstractRange) {
        this.absolute = (DoubleRange) abstractRange;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeLimits
    public void setRange(AbstractRangeLimit<Double> abstractRangeLimit) {
        this.range = (DoubleRangeLimit) abstractRangeLimit;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeLimits
    public AbstractRange<Double> getAbsolute() {
        return this.absolute;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeLimits
    public AbstractRangeLimit<Double> getRange() {
        return this.range;
    }

    public void setAbsolute(DoubleRange doubleRange) {
        this.absolute = doubleRange;
    }

    public void setRange(DoubleRangeLimit doubleRangeLimit) {
        this.range = doubleRangeLimit;
    }
}
