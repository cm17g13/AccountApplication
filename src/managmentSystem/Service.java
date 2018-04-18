package managmentSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Service {

	 static Map<Integer,Account> accounts = new HashMap<Integer,Account>();  
	
	public static void main(String[] args) {
		
	}
	
	public int generateAccountNumber() {
		
		Random rand = new Random();
		int number;
		Account exists;
		
		do {
			number = rand.nextInt(10000) + 1;
			exists = accounts.get(number);
		} while (exists != null);
		
		return number;
		
	}
	
	public boolean addAccount(Account account) {
		
		Account exists = accounts.get(account.getAccountNumber());	
		if(exists != null) {
			return false;
		} else {
			accounts.put(account.getAccountNumber(), account);
			return true;
		}
	}
	
	public Account getAccount(int accountNumber) {
		Account exists = accounts.get(accountNumber);
		if(exists != null) {
			return exists;
		} else {
			return null;
		}
	}
	
	public int addPadding(int number) {
		String newNum = String.valueOf(number);
		for(int i = newNum.length(); i < 5; i++) {
			newNum = "0" + newNum; 
		}
		return Integer.valueOf(newNum);
	}

}
