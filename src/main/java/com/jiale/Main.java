package com.jiale;

import com.jiale.calculator.impl.CalculatorCommand;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        System.out.println("滴滴滴开始测试计算器类滴滴滴");

        CalculatorCommand calculatorCommand = new CalculatorCommand(2, RoundingMode.HALF_UP);
        //加100
        calculatorCommand.execute("+", BigDecimal.valueOf(100));
        //100
        calculatorCommand.display();

        //减50
        calculatorCommand.execute("-", BigDecimal.valueOf(50));
        //50
        calculatorCommand.display();

        //乘100
        calculatorCommand.execute("*", BigDecimal.valueOf(100));
        //5000
        calculatorCommand.display();

        //撤回乘100
        calculatorCommand.undo();
        //50
        calculatorCommand.display();

        //乘10
        calculatorCommand.execute("*", BigDecimal.valueOf(10));
        //500
        calculatorCommand.display();

        //撤回乘10
        calculatorCommand.undo();
        //50
        calculatorCommand.display();

        //重做乘10
        calculatorCommand.redo();
        //500
        calculatorCommand.display();

        //除以10
        calculatorCommand.execute("/",BigDecimal.valueOf(1.123));
        //50
        calculatorCommand.display();

        System.out.println("滴滴滴结束测试计算器类滴滴滴");

        /**
         * 测试结果如下：
         * 滴滴滴开始测试计算器类滴滴滴
         * add operate: 0 + 100
         * result: 100.00
         * subtract operate: 100.00 - 50
         * result: 50.00
         * multiply operate: 50.00 * 100
         * result: 5000.00
         * undo operate
         * result: 50.00
         * multiply operate: 50.00 * 10
         * result: 500.00
         * undo operate
         * result: 50.00
         * redo operate
         * result: 500.00
         * divide operate: 500.00 / 1.123
         * result: 445.24
         * 滴滴滴结束测试计算器类滴滴滴
         */

    }
}