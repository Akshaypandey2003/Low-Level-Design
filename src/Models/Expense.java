package Models;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Expense {
    private int expenseId;
    private int groupId;
    private BigDecimal amount;
    private int paidBy;
    private List<Split> splits;

    public Expense(int expenseId, int groupId,
                   BigDecimal amount,
                   int paidBy,
                   List<Split> splits) {
        this.expenseId = expenseId;
        this.groupId = groupId;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public int getPaidBy() { return paidBy; }
    public List<Split> getSplits() { return splits; }
}
