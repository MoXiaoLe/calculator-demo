package com.jiale.calculator.impl;

import com.jiale.calculator.Operator;

import java.math.BigDecimal;

/**
 * 减法操作器
 */
public class DeductOperator extends Operator {
    @Override
    public BigDecimal operate(BigDecimal a, BigDecimal b) {
        System.out.printf("subtract operate: %s - %s\n", a, b);
        BigDecimal subtract = a.subtract(b);
        if(super.getScale() != null && super.getRoundingMode() != null){
            subtract = subtract.setScale(super.getScale(),super.getRoundingMode());
        }else if(super.getScale() != null){
            subtract = subtract.setScale(super.getScale());
        }
        return subtract;
    }
}
