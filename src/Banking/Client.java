import java.util.ArrayList;
import java.util.List;

public class Client {
    private int age;
    private String name;
    private int IDnumber;
    private String address;
    private List<BankAccount> accounts;

    private int bankID;

    private int pin;

    public Client(String name, int age, int IDnumber, String address){
        this.name = name;
        this.age = age;
        this.IDnumber = IDnumber;
        this.address = address;
        accounts = new ArrayList<>();
    }
    public void addAccount(BankAccount bankAccount){
        accounts.add(bankAccount);
    }

    public void removeAccount(BankAccount selectedAccount){
        /***
         Remove an account from the user, think of edge cases. Can you always remove an account?
         ***/
        if (accounts == null) {
            System.out.println("error the client has no accounts in this bank.");
        } else if (accounts.isEmpty()) {
            System.out.println("error the client has no accounts in this bank.");
        }else {
            accounts.remove(selectedAccount);
            System.out.println("Account removed successfully.");
        }
    }
    public int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }
    public List<BankAccount> getAccounts(){
        return this.accounts;
    }
    public void addBankID(int bankID) {
       this.bankID = bankID;
    }
    public int getBankID(){
        return this.bankID;
    }
    public void setPin(int pin){
        this.pin = pin;
    }
    public int getPin(){
        return this.pin;
    }
}