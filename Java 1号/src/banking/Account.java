package banking;

public class Account {

	private double balance;//���
	
	public Account(double init_balance) {
		this.balance = init_balance;
	}
	
	//�õ����
	public double getBalance(){
		return balance;
	}
	
	//��Ǯ
	public void deposit(double money){
		balance +=money;
	}
	
	public void withdraw(double money){
		balance -=money;
	}
	
	public static void main(String[] args) {
		System.out.println("�������Ϊ500.00���ʻ� ");
		Account a = new Account(500.00);
		
		System.out.println("��ȡ150.00 ");
		a.withdraw(150.00);
		System.out.println("���22.50 ");
		a.deposit(22.50);
		System.out.println("��ȡ47.62     ");
		a.withdraw(47.62);
		System.out.println("�˻����"+a.getBalance());
	}
}
