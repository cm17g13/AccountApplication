package testingManagment;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import managmentSystem.*;

public class ManagmentTests {

	Service service = new Service();
	int accountNumber1 = service.generateAccountNumber();
	int accountNumber2 = service.generateAccountNumber();
	int accountNumber3 = service.generateAccountNumber();
	Account a1 = new Account("Jason", "Hart", accountNumber1);
	Account a2 = new Account("Nidhesh", "Pillai", accountNumber2);
	Account a3 = new Account("Tib", "Coder", accountNumber3);

	@Test
	public void addAccount() {
		service.addAccount(a2);
		service.addAccount(a3);
		assertEquals(true, service.addAccount(a1));
		assertEquals(false, service.addAccount(a1));
	}
	
	@Test
	public void getAccount() {
		service.addAccount(a1);
		service.addAccount(a2);
		service.addAccount(a3);
		assertEquals(a1, service.getAccount(a1.getAccountNumber()));
		assertEquals(null, service.getAccount(service.generateAccountNumber()));
	}
	
	@Test
	public void toJson() {
		Account test1 = new Account("Tim1", "Tim2", 1);
		Account test2 = new Account("Tim3", "Tim4", 2);
		service.addAccount(test1);
		service.addAccount(test2);
		String output = "{\"1\":{\"firstName\":\"Tim1\",\"lastName\":\"Tim2\",\"accountNumber\":1},\"2\":{\"firstName\":\"Tim3\",\"lastName\":\"Tim4\",\"accountNumber\":2}}";
		assertEquals(output, service.convertToJson());
	}
	
	@Test
	public void search() {
		service.addAccount(a1);
		service.addAccount(a2);
		service.addAccount(a3);
		service.addAccount(new Account("Tib", "Man", service.generateAccountNumber()));
		service.addAccount(new Account("Jason", "Tib", service.generateAccountNumber()));
		assertEquals(2, service.search("Tib"));
		assertEquals(2, service.search("Jason"));
		assertEquals(0, service.search("Nidesh"));
	}
	
	@Test
	public void search8() {
		service.addAccount(a1);
		service.addAccount(a2);
		service.addAccount(a3);
		service.addAccount(new Account("Tib", "Man", service.generateAccountNumber()));
		service.addAccount(new Account("Jason", "Tib", service.generateAccountNumber()));
		assertEquals(2, service.search8("Tib"));
		assertEquals(2, service.search8("Jason"));
		assertEquals(0, service.search8("Nidesh"));
	}
	
	
	
}
