public class SavingsAccount extends BankAccount {
    private final double minimumBalance;

    public SavingsAccount(String acctNum, String holder, double openingDeposit, double minimumBalance) {
        super(acctNum, holder, Math.max(openingDeposit, minimumBalance));
        this.minimumBalance = minimumBalance;
    }

    @Override
    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Savings(" + getAccountNumber() + "): Withdrawal denied. Invalid amount.";
        }
        if (getBalance() - amount < minimumBalance) {
            return "Savings(" + getAccountNumber() + "): Withdrawal of $" + amount + " blocked. Must maintain minimum balance $" + minimumBalance;
        }
        setBalance(getBalance() - amount);
        return "Savings(" + getAccountNumber() + "): Withdrawal of $" + amount + " successful | Balance: $" + getBalance();
    }

    @Override
    public String toString() {
        return "Savings [" + getAccountNumber() + "] | Holder: " + getAccountHolder() +
                " | Balance: $" + getBalance() + " | Min Balance: $" + minimumBalance;
    }
}
