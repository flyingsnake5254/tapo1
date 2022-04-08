package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

/* loaded from: classes3.dex */
public class IntegerRange extends AbstractRange<Integer> {
    private Integer from;
    private Integer to;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private Integer from;
        private Integer to;

        public IntegerRange build() {
            return new IntegerRange(this);
        }

        public Builder from(Integer num) {
            this.from = num;
            return this;
        }

        public Builder to(Integer num) {
            this.to = num;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public IntegerRange() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractRange
    public Integer getFrom() {
        return this.from;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractRange
    public Integer getTo() {
        return this.to;
    }

    public void setFrom(Integer num) {
        this.from = num;
    }

    public void setTo(Integer num) {
        this.to = num;
    }

    private IntegerRange(Builder builder) {
        setFrom(builder.from);
        setTo(builder.to);
    }
}
