package practice.practice03.prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String accountNo) {
		setAccountNo(accountNo);
		setBalance(0);
		System.out.println(accountNo + "계좌가 개설되었습니다.");
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		String[] str = accountNo.split("-");
		for(int i = 0; i < str.length; i++) {
			if(isNumber(str[i]) == false) {
				System.out.println("계좌번호를 잘 못 입력하셨습니다.");
				accountNo = null;
			}
		}
		
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public void save(int save) {
		calculate(save, true);
	}
	
	public void deposit(int deposit) {
		calculate(deposit, false);
	}
	
	private void calculate(int money, boolean flag) {
		String name = null;
		if(flag) {
			name = "입금";
		}else {
			name = "출금";
		}
		
		if(money < 0) {
			System.out.println(name + "할 돈은 '0'원 이상이어야 합니다.");
			return;
		}
		
		if(flag) {
			this.balance += money;
		}else {
			if(this.balance > money) {
				this.balance -= money;
			}else {
				System.out.println("잔고가 부족합니다.");
				return;
			}
		}
		
		System.out.println(accountNo + "계좌에 " + money + "만원이 " + name + "되었습니다.");
	}
	
	
	public boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
