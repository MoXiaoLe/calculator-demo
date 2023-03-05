package com.jiale.calculator.impl;

import com.jiale.calculator.Operator;

import java.math.BigDecimal;

/**
 * 除法操作器
 */
public class DivideOperator extends Operator {
    @Override
    public BigDecimal operate(BigDecimal a, BigDecimal b) {
        System.out.printf("divide operate: %s / %s\n", a, b);
        if(super.getScale() != null && super.getRoundingMode() != null){
            return a.divide(b,super.getScale(),super.getRoundingMode());
        }else if(super.getRoundingMode() != null){
            return a.divide(b,super.getRoundingMode());
        }
        return a.divide(b);
    }
}
