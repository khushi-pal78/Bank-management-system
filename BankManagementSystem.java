
import java.util.Scanner;

class BankAccount {

    String accountHolder;
    long accountNumber;
    double balance;

    // Account creation
    void createAccount(String name, long number, double amount) {
        accountHolder = name;
        accountNumber = number;
        balance = amount;

        System.out.println("\nAccount created successfully!");
    }

    // Deposit money
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw money
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        }
    }

    // Check balance
    void checkBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }

    // Display account details
    void displayDetails() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs. " + balance);
    }
}

public class BankManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        int choice;
        boolean accountCreated = false;

        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        if (accountCreated) {
                            System.out.println("Account already exists!");
                            break;
                        }

                        sc.nextLine();
                        System.out.print("Enter account holder name: ");
                        String name = sc.nextLine();

                        if (name.trim().isEmpty()) {
                            System.out.println("Name cannot be empty!");
                            break;
                        }

                        System.out.print("Enter account number: ");
                        long number = sc.nextLong();

                        if (number <= 0) {
                            System.out.println("Invalid account number!");
                            break;
                        }

                        System.out.print("Enter initial deposit: ");
                        double amount = sc.nextDouble();

                        if (amount < 0) {
                            System.out.println("Amount cannot be negative!");
                            break;
                        }

                        account.createAccount(name, number, amount);
                        accountCreated = true;
                        break;

                    case 2:
                        if (!accountCreated) {
                            System.out.println("Please create an account first!");
                            break;
                        }

                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 3:
                        if (!accountCreated) {
                            System.out.println("Please create an account first!");
                            break;
                        }

                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;

                    case 4:
                        if (!accountCreated) {
                            System.out.println("Please create an account first!");
                            break;
                        }

                        account.checkBalance();
                        break;

                    case 5:
                        if (!accountCreated) {
                            System.out.println("Please create an account first!");
                            break;
                        }

                        account.displayDetails();
                        break;

                    case 6:
                        System.out.println("Thank you for using our bank!");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input! Please enter the correct data type.");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 6);

        sc.close();
    }
}
