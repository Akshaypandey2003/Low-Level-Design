import Models.Expense;
import Models.Split;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class ExpenseManager {

    // A owes B
    private Map<Integer, Map<Integer, BigDecimal>> balances = new HashMap<>();

    public void addExpense(Expense expense) {

        int paidBy = expense.getPaidBy();

        for (Split split : expense.getSplits()) {

            int userId = split.getUserId();
            BigDecimal amount = split.getAmount();

            if (userId == paidBy) continue;

            // user owes paidBy
            balances
                    .computeIfAbsent(userId, k -> new HashMap<>())
                    .merge(paidBy, amount, BigDecimal::add);

            // paidBy is owed by user
            balances
                    .computeIfAbsent(paidBy, k -> new HashMap<>())
                    .merge(userId, amount.negate(), BigDecimal::add);
        }
    }

    public void showBalances() {
        for (var entry : balances.entrySet()) {
            int user = entry.getKey();
            for (var inner : entry.getValue().entrySet()) {
                if (inner.getValue().compareTo(BigDecimal.ZERO) > 0) {
                    System.out.println(
                            "User " + user + " owes User "
                                    + inner.getKey() + ": "
                                    + inner.getValue()
                    );
                }
            }
        }
    }
}

