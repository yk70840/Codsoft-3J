import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount bankAccount) {
        account = bankAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.println("Your balance: $" + account.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposited $" + depositAmount + " successfully.");
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                if (account.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawn $" + withdrawAmount + " successfully.");
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
            case 4:
                System.out.println("Thank you for using the ATM!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            atm.processOption(option);
        }
    }
}
