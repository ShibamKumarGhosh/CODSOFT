import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n===== ATM MACHINE =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
             switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (account.deposit(amount)) {
            System.out.println("₹" + amount + " deposited successfully!");
            checkBalance();
        } else {
            System.out.println("Invalid amount! Deposit failed.");
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("₹" + amount + " withdrawn successfully!");
            checkBalance();
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}

// Main class to run the ATM program
public class Atminterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(10000); 
        ATM atmMachine = new ATM(userAccount);

        atmMachine.start();
    }
}
