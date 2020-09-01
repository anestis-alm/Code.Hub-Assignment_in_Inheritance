package gr.codehub.InheritanceExercises.Exercise1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String owner;
    private double balance;
    private int numberOfTransactions;


    public boolean withdraw(double amount) {
        if ((amount <= 0) || (amount > this.balance)) return false;
        this.balance -= amount;
        this.numberOfTransactions++;
        return true;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        this.balance += amount;
        this.numberOfTransactions++;
        return true;
    }


    public void testerAccount() {
        Account account = new Account("Dimitris", 23.67, 4);
        System.out.println("Constructor with given values: " + account.toString());

        System.out.println("Call Set methods to change our values to " +
                "Owner: Anestis/ Balance: 13.567 / NumberOfTransactions: 6");

        account.setOwner("Anestis");
        account.setBalance(13.567);
        account.setNumberOfTransactions(6);

        System.out.println("Owner using getMethod: " + account.getOwner() +
                "\nBalance using getMethod: " + account.getBalance() +
                "\nNumber of Transactions using getMethod: " + account.getNumberOfTransactions());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the amount you want to deposit: ");
        if (account.deposit(Double.parseDouble(scanner.nextLine()))) {
            System.out.println("After Deposit Balance is "
                    + account.getBalance() + "€ and number of transactions is " + account.getNumberOfTransactions() + ".");
        } else {
            System.out.println("Error: Invalid Amount to deposit");
        }

        System.out.println("Give the amount you want to withdraw: ");
        if (account.withdraw(Double.parseDouble(scanner.nextLine()))) {
            System.out.println("After Withdraw Balance is "
                    + account.getBalance() + "€ and number of transactions is " + account.getNumberOfTransactions() + ".");
        } else {
            System.out.println("Error: Invalid Amount to withdraw");
        }

        System.out.println("Constructor after changes: " + account.toString());
    }
}