package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

/* loaded from: classes3.dex */
public class IntegerAttributeLimits extends AbstractNumberAttributeLimits<Integer> {
    private IntegerRange absolute;
    private IntegerRangeLimit range;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private IntegerRange absolute;
        private IntegerRangeLimit range;

        public Builder absolute(IntegerRange integerRange) {
            this.absolute = integerRange;
            return this;
        }

        public IntegerAttributeLimits build() {
            IntegerAttributeLimits integerAttributeLimits = new IntegerAttributeLimits();
            integerAttributeLimits.setAbsolute(this.absolute);
            integerAttributeLimits.setRange(this.range);
            return integerAttributeLimits;
        }

        public Builder range(IntegerRangeLimit integerRangeLimit) {
            this.range = integerRangeLimit;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeLimits
    public void setAbsolute(AbstractRange<Integer> abstractRange) {
        this.absolute = (IntegerRange) abstractRange;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeLimits
    public void setRange(AbstractRangeLimit<Integer> abstractRangeLimit) {
        this.range = (IntegerRangeLimit) abstractRangeLimit;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeLimits
    public AbstractRange<Integer> getAbsolute() {
        return this.absolute;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeLimits
    public AbstractRangeLimit<Integer> getRange() {
        return this.range;
    }

    public void setAbsolute(IntegerRange integerRange) {
        this.absolute = integerRange;
    }

    public void setRange(IntegerRangeLimit integerRangeLimit) {
        this.range = integerRangeLimit;
    }
}
