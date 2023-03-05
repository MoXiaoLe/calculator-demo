package com.jiale.calculator;

import java.math.BigDecimal;

public interface AbstractCommand {

    BigDecimal execute(String op, BigDecimal value);

    BigDecimal undo();

    BigDecimal redo();

    BigDecimal display();

}
