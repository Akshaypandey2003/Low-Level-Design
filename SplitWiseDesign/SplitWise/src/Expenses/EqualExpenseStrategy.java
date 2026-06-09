package Expenses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class EqualExpenseStrategy implements ExpenseStrategy {

    @Override
    public Map<String, BigDecimal> calculateSplits(
            BigDecimal amount,
            List<String> users,
            Map<String, BigDecimal> extraData) {

        Map<String, BigDecimal> splits = new HashMap<>();

        BigDecimal splitAmount = amount.divide(
                new BigDecimal(users.size()),
                2,
                RoundingMode.HALF_UP
        );

        for (String user : users) {
            splits.put(user, splitAmount);
        }

        return splits;
    }
}