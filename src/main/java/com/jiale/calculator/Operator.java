package com.jiale.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Operator {
    private Integer scale;
    private RoundingMode roundingMode;
    public abstract BigDecimal operate(BigDecimal a,BigDecimal b);

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public RoundingMode getRoundingMode() {
        return roundingMode;
    }

    public void setRoundingMode(RoundingMode roundingMode) {
        this.roundingMode = roundingMode;
    }
}
