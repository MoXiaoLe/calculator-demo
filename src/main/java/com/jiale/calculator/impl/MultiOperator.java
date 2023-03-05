package com.jiale.calculator.impl;

import com.jiale.calculator.Operator;

import java.math.BigDecimal;

/**
 * 乘法操作器
 */
public class MultiOperator extends Operator {
    @Override
    public BigDecimal operate(BigDecimal a, BigDecimal b) {
        System.out.printf("multiply operate: %s * %s\n", a, b);
        BigDecimal multiply = a.multiply(b);
        if(super.getScale() != null && super.getRoundingMode() != null){
            multiply = multiply.setScale(super.getScale(),super.getRoundingMode());
        }else if(super.getScale() != null){
            multiply = multiply.setScale(super.getScale());
        }
        return multiply;
    }
}
