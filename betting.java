import java.util.Scanner;


class Betting extends User
{
	public double balance = 200;	
	public double betAmount;	
	public String betLoss;
	public String betOne;
	public String betOutcome;
	public double winBet;
	public double looseBet;
	
	public Betting(String n)
	{
	super(n);
	
	}
	
	Scanner sc = new Scanner(System.in);
	/*public void getBalance(int b)
	{
	balance = b;
	System.out.println("Your bank for this game is " + balance);
	}*/
	
	public double getBalance()
	{
		return balance;
	}
	
	public void makeABet()
	{
	System.out.println("What do you want to bet?");
	betAmount = sc.nextDouble();
	}
	
	public double getAmount()
	{
	return betAmount;
	}
	
	public String getLoss()
	{
	return betLoss;
	}
	
	public String getOne()
	{
	return betOne;
	}
	
	public String getBetOutcome()
	{
		return betOutcome;
	}
	
	public double getBetWin()
	{
		winBet = this.getAmount() * 1;
		balance = this.getBalance() + winBet;
		return balance;
	}
	
	public double getBetLoss()
	{
		looseBet = this.getAmount();
		balance = this.getBalance() - looseBet;
		return balance;
	}
	
	public double getBetDraw()
	{
		return balance;
	}
	
	public void checkBet()
	{
		while (this.getAmount() > this.getBalance())
		{
			System.out.println("I'm sorry but your bet must be lower than your balance.");
			this.makeABet();
			
		}
		
	}

}