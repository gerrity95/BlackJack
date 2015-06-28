import java.util.Random;
import java.util.Scanner;

class User
{

	public String name;
	public String suit;
	public String rank;
	private String face; //These are for the randomly generated cards
	
	public int rankInt; //Convert the rank to a string as well so this is the numerical value for when getting the total
	private int firstTotal;
	public int checkBust;
	
	private String [] cardValues;
	
	private String card;
	private String cardOutput;
	
	public double balance;
	public double betAmount;	
	public String betLoss;
	public String betOne;
	public String betOutcome;
	public double winBet;
	public double looseBet;
	
	public User(String n, double b)
	{
	
	name = n;
	balance = b;
	
	}
	
	Scanner sc = new Scanner(System.in);
	
	public String getName()
	{
	
		return name;
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	public String getRank()
	{
		return rank;
	}
	
	public int getRankInt()
	{
		return rankInt;
	}
	
	public String getCard()
	{
		return card;
	}
	
	public String [] getCardValues()
	{
		return cardValues;
	}
	
	public void setSuit(String newSuit)
	{
		suit = newSuit;
	}
	
	public void setRank(String newRank )
	{
		rank = newRank;
	}
	
	public void setRankInt(int newRankInt)
	{
		rankInt = newRankInt;
	}
	
	//##################################
	
	public String randomSuitGenerator()
	{
		String[] randomSuit = { "Hearts", "Diamonds", "Clubs", "Spades" };
		
		Random randomForSuit = new Random();
		
		int select = randomForSuit.nextInt(randomSuit.length);
		suit = (randomSuit[select]);
		
		return suit;
	}
	
	//###########################################
	
	public String randomRankGenerator()
{
	Random randomRank = new Random();

	int  RandomForRank = randomRank.nextInt(10) + 2;
		
	rankInt = RandomForRank;
		
	rank = Integer.toString(RandomForRank);
	
	if(rank.equals("10"))
	{
		String[] randomFace = {"Jack", "Queen", "King" };
		
		Random randomFaceCard = new Random();
		
		int output = randomFaceCard.nextInt(randomFace.length);
		face = (randomFace[output]);
		
		rank = face;
	}
	else if(rank.equals("11"))
	{
		rank = "Ace";
	}
	
	return rank;
}
	
	//#################################
	
	public String drawCard()
	{
		this.randomSuitGenerator();
		this.randomRankGenerator();
		
		return "You have drawn the " + rank + " of " + suit;
	}
	
	//##################################
	
	public String finalCard()
	{
		return "The card you have drawn is the " + rank + " of " + suit;
	}
	
	//##################################
	
	public int totalAmount()
	{
		
		firstTotal = firstTotal + rankInt;
	
		return firstTotal;
	}
	
	//##################################
	
		public int getUserTotal()
	{
		return rankInt;
	}
	
	//#################################
	
	public int justCheckingBust() //Add this to fix the bug
	{
		return checkBust;
	}
	
	//##################################
	
	public String stickChoice()
	{
		return "You chose to stick";
	}
	
	//##################################
	
	public void bustOrStick()
	{
			if(justCheckingBust() > 21)
			{
				System.out.println("\nYou have gone bust");
			}
			else if(justCheckingBust() < 21)
			{
				System.out.println("You chose to stick");
			}
			else
			{
				System.out.println("\nYou got 21");
			}
	}
	
	//##################################
	
	public static void oneSec() {
	try {
		Thread.currentThread();
		Thread.sleep(1000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	}
	
	public static void manySec(long s) {
	try {
		Thread.currentThread();
		Thread.sleep(s * 1000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	}
	
	
	//######################################
	
	public String card()
	{
		String mySuit = this.randomSuitGenerator();
		String myRank = this.randomRankGenerator();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(mySuit);
		sb.append(myRank);
		
		card = sb.toString();
				
		cardOutput =  "The " + myRank + " of " + mySuit;
		
		return card;
	}
	
	public String getCardOutput()
	{
		return cardOutput;
	}
	
	//============================= This is where the betting classes start
	
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
	
	public double getBlackjack()
	{
		winBet = this.getAmount() * 1.5;
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