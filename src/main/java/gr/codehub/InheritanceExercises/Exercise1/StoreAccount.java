package gr.codehub.InheritanceExercises.Exercise1;

import java.util.Scanner;


public class StoreAccount extends Account {
    private String storeName;
    private AccountCategory accountCategory;

    public StoreAccount() {
    }

    public StoreAccount(String storeName, AccountCategory accountCategory) {
        this.storeName = storeName;
        this.accountCategory = accountCategory;
    }

    public StoreAccount(String owner, double balance, int numberOfTransactions, String storeName, AccountCategory accountCategory) {
        super(owner, balance, numberOfTransactions);
        this.storeName = storeName;
        this.accountCategory = accountCategory;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public AccountCategory getAccountCategory() {
        return accountCategory;
    }

    public void setAccountCategory(AccountCategory accountCategory) {
        this.accountCategory = accountCategory;
    }

    public void changeCategory(StoreAccount storeAccount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type one of the available categories: ( ");
        for (AccountCategory accountCategory : AccountCategory.values()) {
            System.out.print(accountCategory + " ");
        }
        System.out.print(")\n");
        String input = scanner.nextLine();
        String category = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();

        try {
            storeAccount.setAccountCategory(AccountCategory.valueOf(category));
        } catch(Exception e){
            System.out.println("Invalid Category");
        } finally {
            System.out.println("Category is: " + storeAccount.getAccountCategory());
        }
    }

    @Override
    public String toString() {
        return super.toString() + "StoreAccount{" +
                "storeName='" + storeName + '\'' +
                ", accountCategory=" + accountCategory +
                '}';
    }

    public void testerStoreAccount() {
        StoreAccount storeAccount = new StoreAccount("Anestis", 500.60, 6, "ESHOP", AccountCategory.Premium);
        System.out.println("Constructor using inheritance: " + storeAccount.toString());
        System.out.println("Call Set methods to change our values to " +
                "Owner: Dimitris/ Balance: 320/ Number of Transactions: 4/ Store Name: Almaliotis-shop/ Account Category: Mid");

        storeAccount.setStoreName("Almaliotis-shop");
        storeAccount.setAccountCategory(AccountCategory.Mid);
        storeAccount.setOwner("Dimitris");
        storeAccount.setBalance(320);
        storeAccount.setNumberOfTransactions(4);

        System.out.println("Owner using getMethod: " + storeAccount.getOwner() +
                "\nBalance using getMethod: " + storeAccount.getBalance() +
                "\nNumber of Transactions using getMethod: " + storeAccount.getNumberOfTransactions() +
                "\nStore Name using getMethod: " + storeAccount.getStoreName() +
                "\nAccount Category using getMethod: " + storeAccount.getAccountCategory());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the amount you want to deposit: ");
        if (storeAccount.deposit(Double.parseDouble(scanner.nextLine()))) {
            System.out.println("After Deposit Balance is "
                    + storeAccount.getBalance() + "€ and number of transactions is " + storeAccount.getNumberOfTransactions() + ".");
        } else {
            System.out.println("Error: Invalid Amount to deposit");
        }

        System.out.println("Give the amount you want to withdraw: ");
        if (storeAccount.withdraw(Double.parseDouble(scanner.nextLine()))) {
            System.out.println("After Withdraw Balance is "
                    + storeAccount.getBalance() + "€ and number of transactions is " + storeAccount.getNumberOfTransactions() + ".");
        } else {
            System.out.println("Error: Invalid Amount to withdraw");
        }
        storeAccount.changeCategory(storeAccount);

        System.out.println("Constructor after changes: " + storeAccount.toString());
    }


}