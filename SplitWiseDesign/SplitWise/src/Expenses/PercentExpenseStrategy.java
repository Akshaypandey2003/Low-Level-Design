package Expenses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class PercentExpenseStrategy implements ExpenseStrategy {

    @Override
    public Map<String, BigDecimal> calculateSplits(
            BigDecimal amount,
            List<String> users,
            Map<String, BigDecimal> percentMap) {

        Map<String, BigDecimal> splits = new HashMap<>();

        BigDecimal totalPercent = BigDecimal.ZERO;
        for (BigDecimal percent : percentMap.values()) {
            totalPercent = totalPercent.add(percent);
        }

        if (totalPercent.compareTo(new BigDecimal("100")) != 0) {
            throw new IllegalArgumentException("Total percentage must be 100.");
        }

        for (String user : users) {
            BigDecimal percent = percentMap.get(user);
            BigDecimal userShare = amount
                    .multiply(percent)
                    .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);

            splits.put(user, userShare);
        }

        return splits;
    }
}