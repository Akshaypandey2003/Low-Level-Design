package Expenses;

import java.math.BigDecimal;
import java.util.*;

public class ExactExpenseStrategy implements ExpenseStrategy {

    @Override
    public Map<String, BigDecimal> calculateSplits(
            BigDecimal amount,
            List<String> users,
            Map<String, BigDecimal> exactAmounts) {

        BigDecimal total = BigDecimal.ZERO;

        for (BigDecimal value : exactAmounts.values()) {
            total = total.add(value);
        }

        if (total.compareTo(amount) != 0) {
            throw new IllegalArgumentException("Exact amounts do not match total expense.");
        }

        return exactAmounts;
    }
}