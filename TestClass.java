
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class TestClass {

	private String choice;
	private int checker;
	public int rankInt;
	public String rank;
	private int total;
	private String face;
	public String suit;
	private String card;
	private String cardOutput;
	
	public static Scanner sc;
	
	public TestClass()
	{
		
	}
	
	public String getChoice()
	{
		return choice;
	}
	
	public int getChecker()
	{
		return checker;
	}
	
	public int getRankInt()
	{
		return rankInt;
	}
	
	public String getRank()
	{
		return rank;
	}
	
	public int getTotal()
	{
		return total;
	}
	
	public String getSuit()
	{
		return suit;
	}
	

	
	public String randomSuitGenerator()
	{
		String[] randomSuit = { "Hearts", "Diamonds", "Clubs", "Spades" };
		
		Random randomForSuit = new Random();
		
		int select = randomForSuit.nextInt(randomSuit.length);
		suit = (randomSuit[select]);
		
		return suit;
	}
	
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
	
	
	public void RandomCard()
	{
		sc = new Scanner(System.in);
		
		ArrayList<String> testList = new ArrayList<String>();
		Iterator<String> it = testList.iterator();
		
		this.card();
		
		choice = "yes";
		
		checker = 0;
		testList.add(this.card());
		
		System.out.println(this.getCardOutput());
		
		total = this.getRankInt();
		
		do {

			this.card();
			
			
			int i = 0;
			
			do
			{
				
				if (this.card().equalsIgnoreCase(testList.get(i)))
				{
					checker = 1;
				}
				else
				{
					checker = 0;
				}
				
	
				
				
				i++;
			} while( (i<testList.size()) && (checker != 1) );
			
			if(checker == 0)
			{
				testList.add(this.card());
				System.out.println(this.getCardOutput());
				
				total = total + this.getRankInt();
				
			}
			
			
			if( (checker == 0) && (total < 21))
			{
			
				System.out.println("Your total is: " + total);
				
				System.out.println("Do you want another card?");
				choice = sc.next();
			}
			else 
			{
				choice = "no";
			}
			
		} while( (choice.equalsIgnoreCase("yes")) || (checker == 1));

			System.out.println("Total is greater that 21");
			

			
			
	}
	
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
	
	public void check()
	{
		ArrayList<String> testList = new ArrayList<String>();
		Iterator<String> it = testList.iterator();
		
			this.card();
			System.out.println(this.getCardOutput());
			System.out.println(this.getRankInt());
			
			testList.add(this.card());
			System.out.println(this.getCardOutput());
			System.out.println(this.getRankInt());
	}
}
