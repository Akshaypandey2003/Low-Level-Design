import Helper.SplitwiseService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Enum.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SplitwiseService service = new SplitwiseService();

        // Create Users
        service.addUser("U1", "Akshay");
        service.addUser("U2", "Rahul");
        service.addUser("U3", "Aman");

        // Equal Split
        List<String> users1 = Arrays.asList("U1", "U2", "U3");
        service.addExpense(
                ExpenseType.EQUAL,
                new BigDecimal("300"),
                "U1",
                users1,
                null
        );

        System.out.println("After Equal Expense:");
        service.showBalances();

        // Exact Split
        Map<String, BigDecimal> exactMap = new HashMap<>();
        exactMap.put("U1", new BigDecimal("100"));
        exactMap.put("U2", new BigDecimal("200"));

        service.addExpense(
                ExpenseType.EXACT,
                new BigDecimal("300"),
                "U3",
                Arrays.asList("U1", "U2"),
                exactMap
        );

        System.out.println("\nAfter Exact Expense:");
        service.showBalances();

        // Percent Split
        Map<String, BigDecimal> percentMap = new HashMap<>();
        percentMap.put("U1", new BigDecimal("50"));
        percentMap.put("U2", new BigDecimal("30"));
        percentMap.put("U3", new BigDecimal("20"));

        service.addExpense(
                ExpenseType.PERCENT,
                new BigDecimal("1000"),
                "U2",
                Arrays.asList("U1", "U2", "U3"),
                percentMap
        );

        System.out.println("\nAfter Percent Expense:");
        service.showBalances();
    }
}