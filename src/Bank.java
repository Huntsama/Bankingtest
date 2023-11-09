import java.util.ArrayList;
import java.util.List;

public class Bank {
	private int uniqueIDAccounts = 0;

	private int uniqueIDClient = 0;
	private List<Client> clients;
	private Client currentClient = null;

	public Bank() {
		/***
		 Constructor
		 ***/
		this.clients = new ArrayList<>();
	}

	public void addNewClient(Client client, int pin) {
		/***
		 Add clients to the bank. What do you do when a client has already been added to the bank?
		 ***/
		if(clients.contains(client)){
			System.out.println("Client is already exist..");
		}
		else{
			client.addBankID(uniqueIDClient++);
			client.setPin(pin);
			clients.add(client);
		}
	}

	public void logOut() {
		/***
		 Log the current user out of the bank
		 ***/
		currentClient = null;
	}

	public void logIn(int id, int pin) {
		/***
		 Log the current user in to the bank. What happens is someone is already logged in?
		 How do you validate if the user is indeed who they claim to be?
		 If the user is unable to provide the correct information, the following sentence should be displayed:
		 "This user is not know to the bank, please check if you gave the correct ID and PIN!"
		 ***/

		for(Client client : clients){
			if(client.getBankID() == id && client.getPin() == pin) {
				currentClient = client;
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
			BankAccount account = new BankAccount(++uniqueIDAccounts, amount);
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
		if (clients.contains(currentClient)) {
			if(currentClient.getAccounts().contains(transferFrom)) {
				if(amount <= transferFrom.getBalance()) {
					transferFrom.removeFromBalance(amount);
					transferTo.addToBalance(amount);
				}
			}
		}
	}

	public void displayAccounts() {
		/***
		 Give a display to the user what accounts are associated with them.
		 Give info abouth the index (for easy access), the ID and the amount.
		 ***/
		if(currentClient != null){
			List<BankAccount> accounts = currentClient.getAccounts();

			for(BankAccount bankAccount : accounts)
			{
				System.out.println("index: " + accounts.indexOf(bankAccount) + ", ID " + bankAccount.getID() + ", amount: " + bankAccount.getBalance());
			}

			if(accounts.isEmpty()){
				System.out.println("No accounts");
			}
		}


	}


	public int maxIDClient(){
		/***
		 Getter
		 ***/
		return uniqueIDClient;

	}

	public Client getCurrentClient(){
		/***
		 Getter
		 ***/
		return currentClient;
	}

	public List<Client> getClients() {
		/***
		 Getter
		 ***/
		return clients;
	}

}