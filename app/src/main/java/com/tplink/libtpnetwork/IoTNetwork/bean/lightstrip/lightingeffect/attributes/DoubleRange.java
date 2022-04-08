package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

/* loaded from: classes3.dex */
public class DoubleRange extends AbstractRange<Double> {
    private Double from;
    private Double to;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private Double from;
        private Double to;

        private Builder() {
        }

        public DoubleRange build() {
            return new DoubleRange(this);
        }

        public Builder from(Double d2) {
            this.from = d2;
            return this;
        }

        public Builder to(Double d2) {
            this.to = d2;
            return this;
        }
    }

    public DoubleRange() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractRange
    public Double getFrom() {
        return this.from;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractRange
    public Double getTo() {
        return this.to;
    }

    public void setFrom(Double d2) {
        this.from = d2;
    }

    public void setTo(Double d2) {
        this.to = d2;
    }

    private DoubleRange(Builder builder) {
        setFrom(builder.from);
        setTo(builder.to);
    }
}
