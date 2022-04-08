package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

/* loaded from: classes3.dex */
public class LongAttributeLimits extends AbstractNumberAttributeLimits<Long> {
    private LongRange absolute;
    private LongRangeLimit range;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private LongRange absolute;
        private LongRangeLimit range;

        public Builder absolute(LongRange longRange) {
            this.absolute = longRange;
            return this;
        }

        public LongAttributeLimits build() {
            LongAttributeLimits longAttributeLimits = new LongAttributeLimits();
            longAttributeLimits.setAbsolute(this.absolute);
            longAttributeLimits.setRange(this.range);
            return longAttributeLimits;
        }

        public Builder range(LongRangeLimit longRangeLimit) {
            this.range = longRangeLimit;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeLimits
    public void setAbsolute(AbstractRange<Long> abstractRange) {
        this.absolute = (LongRange) abstractRange;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeLimits
    public void setRange(AbstractRangeLimit<Long> abstractRangeLimit) {
        this.range = (LongRangeLimit) abstractRangeLimit;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeLimits
    public AbstractRange<Long> getAbsolute() {
        return this.absolute;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeLimits
    public AbstractRangeLimit<Long> getRange() {
        return this.range;
    }

    public void setAbsolute(LongRange longRange) {
        this.absolute = longRange;
    }

    public void setRange(LongRangeLimit longRangeLimit) {
        this.range = longRangeLimit;
    }
}
