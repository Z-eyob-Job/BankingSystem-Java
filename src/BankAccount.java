public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder) {
        this(accountNumber, accountHolder, 0.0);
    }

    public BankAccount(String accountNumber, String accountHolder, double openingDeposit) {
        if (openingDeposit < 0) {
            throw new IllegalArgumentException("BankAccount creation failed: Opening deposit cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = openingDeposit;
    }

    public String deposit(double amount) {
        if (amount <= 0) {
            return "BankAccount(" + accountNumber + "): Deposit of $" + amount + " denied. Invalid amount.";
        }
        balance += amount;
        return "BankAccount(" + accountNumber + "): Deposited $" + amount + " | Balance now $" + balance;
    }

    public String deposit(double amount, String note) {
        return deposit(amount) + " | Note: " + note;
    }

    public String withdraw(double amount) {
        if (amount <= 0) {
            return "BankAccount(" + accountNumber + "): Withdrawal of $" + amount + " denied. Invalid amount.";
        }
        if (amount > balance) {
            return "BankAccount(" + accountNumber + "): Withdrawal of $" + amount + " failed. Insufficient funds.";
        }
        balance -= amount;
        return "BankAccount(" + accountNumber + "): Withdrew $" + amount + " | Balance now $" + balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount [" + accountNumber + "] | Holder: " + accountHolder + " | Balance: $" + balance;
    }
}
