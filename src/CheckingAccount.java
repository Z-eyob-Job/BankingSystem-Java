public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String acctNum, String holder, double openingDeposit, double overdraftLimit) {
        super(acctNum, holder, openingDeposit);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Checking(" + getAccountNumber() + "): Withdrawal denied. Invalid amount.";
        }
        if (amount > getBalance() + overdraftLimit) {
            return "Checking(" + getAccountNumber() + "): Withdrawal of $" + amount + " failed. Exceeds overdraft limit.";
        }
        setBalance(getBalance() - amount);
        return "Checking(" + getAccountNumber() + "): Withdrawal of $" + amount + " processed | Balance: $" + getBalance();
    }

    @Override
    public String toString() {
        return "Checking [" + getAccountNumber() + "] | Holder: " + getAccountHolder() +
                " | Balance: $" + getBalance() + " | Overdraft Limit: $" + overdraftLimit;
    }
}
