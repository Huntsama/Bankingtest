public class BankAccount {

    private int uniqueID;
    private double balance;

    public BankAccount(int uniqueID, double amount){
        /***
         Constructor
         ***/
        this.uniqueID = uniqueID;
        this.balance = amount;
    }

    public void addToBalance(double amount){
        /***
         Add to an account
         ***/
        this.balance += amount;

    }

    public boolean canBeRemovedFromBalance(double amount){
        /***
         Check if the balance can be removed from an account
         ***/
        if(balance < amount){
            System.out.println("the account does not have enough balance, please deposit first.");
            return false;
        }else{
            System.out.println("the account has enough balance, the amount can be removed from it.");
            return true;
        }
    }

    public void removeFromBalance(double amount){
        /***
         Remove from an account if the conditions are valid
         ***/
        if(canBeRemovedFromBalance(amount)){
            this.balance -= amount;
        }

    }

    public double getBalance() {
        /***
         Getter
         ***/
        return balance;
    }

    public int getID() {
        /***
         Getter
         ***/
        return uniqueID;
    }
}