package com.jiale.calculator;

import com.jiale.calculator.impl.AddOperator;
import com.jiale.calculator.impl.DeductOperator;
import com.jiale.calculator.impl.DivideOperator;
import com.jiale.calculator.impl.MultiOperator;

import java.math.RoundingMode;
import java.util.Optional;

/**
 * 操作器构造类
 */
public class OperatorBuilder {

    private Integer scale;
    private RoundingMode roundingMode;
    private String op;

    public Operator build(){
        Operator operator = newOperator(op);
        operator.setScale(scale);
        operator.setRoundingMode(roundingMode);
        return operator;
    }

    public static OperatorBuilder builder(){
        return new OperatorBuilder();
    }

    public  OperatorBuilder scale(Integer scale){
        this.scale = scale;
        return this;
    }

    public OperatorBuilder roundingMode(RoundingMode roundingMode){
        this.roundingMode = roundingMode;
        return this;
    }

    public OperatorBuilder op(String op){
        this.op = op;
        return this;
    }

     private Operator newOperator(String op){
        switch (Optional.ofNullable(op).orElse("")){
            case "+":
                return new AddOperator();
            case "-":
                return new DeductOperator();
            case "*":
                return new MultiOperator();
            case "/":
                return new DivideOperator();
        }
        throw new RuntimeException("not operator for " + op);
    }
}
