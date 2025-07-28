package main_atm;
import java.util.HashMap;
import java.util.Map;

public class AtmOperationImp implements AtmOperation {
    private double balance = 0;
    private Map<String, Double> miniStatement = new HashMap<>();

    public void viewBalance() {
        System.out.println("💰 Available Balance: ₹" + balance);
    }

    @Override
    public void withdrawAmount(double amount) {
        if (amount <= balance) {
            balance -= amount;
            miniStatement.put("Withdraw - ₹" + amount, balance);
            System.out.println("✅ ₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("⚠️ Insufficient balance.");
        }
    }

    @Override
    public void depositAmount(double amount) {
        balance += amount;
        miniStatement.put("Deposit - ₹" + amount, balance);
        System.out.println("✅ ₹" + amount + " deposited successfully.");
    }

    @Override
    public void viewMiniStatement() {
        System.out.println("\n📋 Mini Statement:");
        if (miniStatement.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Map.Entry<String, Double> entry : miniStatement.entrySet()) {
                System.out.println(entry.getKey() + " | Balance: ₹" + entry.getValue());
            }
        }
    }
}
