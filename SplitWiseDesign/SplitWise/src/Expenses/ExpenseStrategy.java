package Expenses;

import java.math.BigDecimal;
import java.util.*;

public interface ExpenseStrategy {
    Map<String, BigDecimal> calculateSplits(
            BigDecimal amount,
            List<String> users,
            Map<String, BigDecimal> extraData
    );
}