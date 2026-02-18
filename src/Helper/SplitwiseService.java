package Helper;

import Expenses.*;
import Models.User;

import Enum.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseService {

    private Map<String, User> users = new HashMap<>();

    // BalanceSheet: who owes whom
    // balances[A][B] = amount A owes B
    private Map<String, Map<String, BigDecimal>> balances = new HashMap<>();

    public void addUser(String id, String name) {
        users.put(id, new User(id, name));
        balances.put(id, new HashMap<>());
    }

    public void addExpense(
            ExpenseType type,
            BigDecimal amount,
            String paidBy,
            List<String> involvedUsers,
            Map<String, BigDecimal> extraData) {

        ExpenseStrategy strategy = ExpenseStrategyFactory.getStrategy(type);

        Map<String, BigDecimal> splits =
                strategy.calculateSplits(amount, involvedUsers, extraData);

        for (String user : splits.keySet()) {

            if (user.equals(paidBy)) continue;

            BigDecimal userShare = splits.get(user);

            balances.get(user).put(
                    paidBy,
                    balances.get(user).getOrDefault(paidBy, BigDecimal.ZERO)
                            .add(userShare)
            );
        }
    }

    public void showBalances() {

        boolean noBalances = true;

        for (String user : balances.keySet()) {

            for (Map.Entry<String, BigDecimal> entry :
                    balances.get(user).entrySet()) {

                if (entry.getValue().compareTo(BigDecimal.ZERO) > 0) {

                    noBalances = false;

                    System.out.println(
                            users.get(user).getName()
                                    + " owes "
                                    + users.get(entry.getKey()).getName()
                                    + " : "
                                    + entry.getValue()
                    );
                }
            }
        }

        if (noBalances) {
            System.out.println("No balances");
        }
    }
}
