package gr.codehub.InheritanceExercises.Exercise1;

public class ManageExercise1 {
    public static void main(String[] args) {
        Account account = new Account();
        account.testerAccount();
        System.out.println("\n--------------------------------------------------------\n");
        StoreAccount storeAccount = new StoreAccount();
        storeAccount.testerStoreAccount();
    }
}
