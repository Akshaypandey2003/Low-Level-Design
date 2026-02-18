package Expenses;

import Enum.*;
public class ExpenseStrategyFactory {

    public static ExpenseStrategy getStrategy(ExpenseType type) {
        switch (type) {
            case EQUAL:
                return new EqualExpenseStrategy();
            case EXACT:
                return new ExactExpenseStrategy();
            case PERCENT:
                return new PercentExpenseStrategy();
            default:
                throw new IllegalArgumentException("Invalid Expense Type");
        }
    }
}