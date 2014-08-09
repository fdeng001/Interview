package Interview_Bank;

public class Bank {
	public static void main(String[] args){
		OneCount A = new OneCount();
		double m = 1000;
		A.setBalance(m);
		dealThread dt_A = new dealThread("A",10,A);
		dealThread dt_B = new dealThread("B",-10,A);
		dt_A.start();
		dt_B.start();
	}
}
class OneCount{
	private double balance = 0;
	public synchronized double savemoney(double money){
		this.balance = getbalance();
		if(money<0 && Math.abs(money)<balance){
			return money+balance;
		}
		else if(money>=0){
			return money+balance;
		}
		else{
			return -1;
		}
	}
	public double getbalance(){
		return balance;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
}
class dealThread extends Thread{
	private double money;
	private String user;
	private OneCount oc;
	public dealThread(String user,double money, OneCount oc){
		this.money = money;
		this.user = user;
		this.oc = oc;
	}
	public void run(){
		while(true){
			try{
				double blance = oc.savemoney(money);
				System.out.println("用户："+user+"操作后账户余额"+blance);
				Thread.currentThread().sleep(1000000);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
