import java.util.ArrayList;
import java.util.List;

public class Bank {
	private int uniqueIDAccounts = 0;

	private int uniqueIDClient = 0;
	private List<Client> clients;
	private Client currentClient = null;

	public Bank() {
		this.clients = new ArrayList<>();
	}
	public void addNewClient(Client client, int pin) {
		/***
		 Add clients to the bank. What do you do when a client has already been added to the bank?
		 ***/
		if(clients.contains(client)){
			System.out.println("client has already been added to the bank");
		}
		else{
			client.setPin(pin);
			clients.add(client);
			client.addBankID(uniqueIDClient + 1 );
		}
	}
	public void logOut() {
		this.currentClient = null;
	}
	public void logIn(int id, int pin) {
		/***
		 Log the current user in to the bank. What happens is someone is already logged in?
		 How do you validate if the user is indeed who they claim to be?
		 If the user is unable to provide the correct information, the following sentence should be displayed:
		 "This user is not know to the bank, please check if you gave the correct ID and PIN!"
		 ***/
		for(int i = 0; i < clients.size(); i=i+1){
			Client client = clients.get(i);
			if(client.getBankID() == id & client.getPin() == pin) {
				this.currentClient = client;
				return;
			}
		}
		System.out.println("This user is not know to the bank, please check if you gave the correct ID and PIN!");
	}
	public void addAccount(Client client, double amount) {
		/***
		 Add an account, if all input valid in this method?
		 ***/
		if (amount >= 0) {
			BankAccount account = new BankAccount(uniqueIDAccounts + 1, amount);
			client.addAccount(account);
		}
	}
	public void removeAccount(BankAccount toRemove, BankAccount transferAccount) {
		/***
		 Remove an account, the user can transfer the money in the 'toRemove' account to the 'transferAccount'.
		 ***/
		if (currentClient.getAccounts().contains(toRemove)) {
			if(transferAccount != null){
				transfer(toRemove, transferAccount, toRemove.getBalance());
			}
			currentClient.getAccounts().remove(toRemove);
		}
	}
	public void transfer(BankAccount transferFrom, BankAccount transferTo, double amount) {
		/***
		 Transfer from 'transferFrom' to 'TransferTo' with a given ammount?
		 Can anyone transfer, what with people that are not part of the bank?
		 ***/
		for(int i = 0; i < clients.size(); i=i+1){
			Client client = clients.get(i);
			if (client.getAccounts().contains(transferFrom)) {
				if (amount <= transferFrom.getBalance()) {
					transferFrom.removeFromBalance(amount);
					transferTo.addToBalance(amount);
				}
			} else {
				System.out.println("Sorry you are not the client of this bank, please become the client of this bank if you want to transfer. ");
			}
		}
	}
	public void displayAccounts() {
		/***
		 Give a display to the user what accounts are associated with them.
		 Give info abouth the index (for easy access), the ID and the amount.
		 ***/
		if (currentClient != null) {
			List<BankAccount> accounts = currentClient.getAccounts();
			if (!accounts.isEmpty()) {
				System.out.println("your accounts");
				for (int i = 0; i < accounts.size(); i=i+1) {
					BankAccount bankAccount = accounts.get(i);
					System.out.println("index" + (i + 1));
					System.out.println("ID" + bankAccount.getID());
					System.out.println("Balance" + bankAccount.getBalance());
				}
			} else {
				System.out.println("no accounts");
			}
		}
	}
	public int maxIDClient(){
		return this.uniqueIDClient;

	}
	public Client getCurrentClient(){
		return this.currentClient;
	}
	public List<Client> getClients() {
		return this.clients;
	}

}