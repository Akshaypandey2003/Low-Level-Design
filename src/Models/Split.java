package Models;

import java.math.BigDecimal;

public class Split {
    private int userId;
    private BigDecimal amount;

    public Split(int userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public int getUserId() { return userId; }
    public BigDecimal getAmount() { return amount; }
}

