package com.jiale.calculator.impl;

import com.jiale.calculator.AbstractCommand;
import com.jiale.calculator.Operator;
import com.jiale.calculator.OperatorBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

/**
 * 拥有undo/redo功能的计算器
 */
public class CalculatorCommand implements AbstractCommand {

    //撤回栈，用于记录每一步操作
    private Stack<BigDecimal> undoStack = new Stack<>();

    //重做栈，记录撤回的操作
    private Stack<BigDecimal> redoStack = new Stack<>();

    private Integer scale;

    private RoundingMode roundingMode;

    public CalculatorCommand(Integer scale, RoundingMode roundingMode) {
        this.scale = scale;
        this.roundingMode = roundingMode;
    }

    /**
     * 执行计算操作
     * @param op
     * @param value
     * @return
     */
    @Override
    public BigDecimal execute(String op, BigDecimal value) {
        //根据操作符获取操作处理器,可以根据需要拓展参数，生成多样的Operator
        Operator operator = OperatorBuilder.builder()
                .op(op) //操作符
                .scale(scale) //小数点精度
                .roundingMode(roundingMode) //进位规则
                .build();
        BigDecimal a = undoStack.empty() ? BigDecimal.valueOf(0) : undoStack.peek();
        BigDecimal result = operator.operate(a, value);
        //压栈到撤回栈
        undoStack.push(result);
        return result;
    }

    /**
     * 撤回操作
     * @return
     */
    @Override
    public BigDecimal undo() {
        System.out.println("undo operate");
        if(undoStack.empty()){
            throw new RuntimeException("undo stack is empty,unable to undo");
        }
        //撤回栈弹出一个栈元素
        BigDecimal pop = undoStack.pop();
        //重做栈压栈
        redoStack.push(pop);
        return pop;

    }


    /**
     * 重做操作
     * @return
     */
    @Override
    public BigDecimal redo() {
        System.out.println("redo operate");
        if(redoStack.empty()){
            throw new RuntimeException("redo stack is empty,unable to redo");
        }
        //重做栈弹出一个栈元素
        BigDecimal pop = redoStack.pop();
        //撤回栈压栈
        undoStack.push(pop);
        return pop;
    }

    /**
     * 返回当前操作结果值
     * @RETURN
     */
    @Override
    public BigDecimal display() {
        BigDecimal value = undoStack.empty() ? BigDecimal.valueOf(0) : undoStack.peek();
        System.out.printf("result: %s\n",value);
        return value;
    }

}
