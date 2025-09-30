public class Main {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("928A", "Eyob", 7000);
        System.out.println(b1.deposit(60));
        System.out.println(b1.deposit(800, "Mobile deposit"));
        System.out.println(b1.withdraw(67));
        System.out.println(b1);

        CheckingAccount c1 = new CheckingAccount("325A", "Nehi", 5252, 623);
        System.out.println(c1.withdraw(450));
        System.out.println(c1.withdraw(100));
        System.out.println(c1);

        SavingsAccount s1 = new SavingsAccount("251A", "Ruth", 2511, 462);
        System.out.println(s1.withdraw(50));
        System.out.println(s1.deposit(300));
        System.out.println(s1.withdraw(150));
        System.out.println(s1);
    }
}
