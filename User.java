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
	public User(String n)
	{
	
	name = n;
	
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
	
	public void randomSuitGenerator()
	{
		String[] randomSuit = { "Hearts", "Diamonds", "Clubs", "Spades" };
		
		Random randomForSuit = new Random();
		
		int select = randomForSuit.nextInt(randomSuit.length);
		suit = (randomSuit[select]);
	}

	//##################################
	
		public void randomRankGenerator()
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
		
		
	}
	
	//#################################
	
	public void drawCard()
	{
		this.randomSuitGenerator();
		this.randomRankGenerator();
		
		System.out.println("You have drawn the " + rank + " of " + suit);
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
		Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	}
	
	public static void manySec(long s) {
	try {
		Thread.currentThread().sleep(s * 1000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	}
	
}