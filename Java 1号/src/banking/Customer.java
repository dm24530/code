package banking;

public class Customer {
	
	private String firstName;
	private String lastName;
	private Account account;
	
	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setAccount(Account account){
		this.account = account;
	}
	
    public Account getAccount(){
		return account;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a = new Account(500.00);
		System.out.println("�����ͻ��Ǳ���");
		System.out.println("��500.00�����������˻�");
		System.out.println("��ȡ150.00 ");
		a.withdraw(150.00);
		System.out.println("���22.50 ");
		a.deposit(22.50);
		System.out.println("ȡ��47.62�ͻ�[�Ǳ���]     ");
		a.withdraw(47.62);
		System.out.println("��"+a.getBalance()+"�����");
	}

}
