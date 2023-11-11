public class BankAccount {

    private int uniqueID;
    private double balance;

    public BankAccount(int uniqueID, double amount){
        this.uniqueID = uniqueID;
        this.balance = amount;
    }
    public void addToBalance(double amount){
        this.balance += amount;
    }
    public boolean canBeRemovedFromBalance(double amount) {
        /***
         Check if the balance can be removed from an account.
         ***/
        if (balance < amount) {
            System.out.println("insufficient balance ");
            return false;
        } else {
            System.out.println("sufficient balance");
            return true;
        }
    }
    public void removeFromBalance(double amount) {
        /***
          Decrease the account balance if the conditions are valid.
         ***/
        if (canBeRemovedFromBalance(amount)) {
            balance -= amount;
            System.out.println("successfully removed from balance");
        } else {
            System.out.println("cant Remove Insufficient balance");
        }
    }
    public double getBalance() {
        return this.balance;
    }
    public int getID() {
        return this.uniqueID;
    }
}