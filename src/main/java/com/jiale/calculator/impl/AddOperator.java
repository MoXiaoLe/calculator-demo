package com.jiale.calculator.impl;

import com.jiale.calculator.Operator;

import java.math.BigDecimal;

/**
 * 加法操作器
 */
public class AddOperator extends Operator {
    @Override
    public BigDecimal operate(BigDecimal a, BigDecimal b) {
        System.out.printf("add operate: %s + %s\n", a, b);
        BigDecimal add = a.add(b);
        if(super.getScale() != null && super.getRoundingMode() != null){
            add = add.setScale(super.getScale(),super.getRoundingMode());
        }else if(super.getScale() != null){
            add = add.setScale(super.getScale());
        }
        return add;
    }
}
