import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Dealer extends User
{
	
	private int dealerTotal;
	
	
	public Dealer(String dealerName, double balance)
	{
		super(dealerName,balance);
	}
	
	public int getDealerTotal()
	{
		return dealerTotal;
	}

	
	public void getBeginGame()
	{
	String[]intro;
	intro = new String [5];
	intro[0]= "Best of luck";
	intro[1]= "Whats the craic?";
	intro[2]= "Feeling Lucky?";
	intro[3]= "Let's Play";
	intro[4]= "It's time to go";

		int num = (int)(Math.random()*5);
		System.out.println(intro[num]);
	}
	
	public void getLowBet()
	{
	String[]lowbet;
	lowbet = new String [5];
	lowbet[0]= "Chicken";
	lowbet[1]= "Must be expecting a bad hand";
	lowbet[2]= "You must be low on cash";
	lowbet[3]= "I'm not impressed";
	lowbet[4]= "Your not breaking the bank there anyways!";

		int num = (int)(Math.random()*5);
		System.out.println(lowbet[num]);
	
	
	}
	
	public void getHighBet()
	{
		String[]high;
		high = new String [5];
		high[0]= "Risky Business";
		high[1]= "Bet big, Win big";
		high[2]= "You Must Feeling Lucky?";
		high[3]= "Big Spender";
		high[4]= "You can win if your not in!";

		int num = (int)(Math.random()*5);
		System.out.println(high[num]);

	
	
	}
	
	public void getUserWin()
	{
		String[]winner;
			winner = new String [5];
			winner[0]= "Winner Winner Chicken Dinner";
			winner[1]= "Well Done!";
			winner[2]= "Congratulations";
			winner[3]= "Drinks on you tonight!";
			winner[4]= "We have a winner";

		int num = (int)(Math.random()*5);
		System.out.println(winner[num]);

	}
	
	
	public void getUserLoss()
	{
	String[]lose;
	lose = new String [5];
	lose[0]= "Unlucky";
	lose[1]= "Show me the money!";
	lose[2]= "Bad Luck";
	lose[3]= "Better Luck Next Time";
	lose[4]= "You were so close";

		int num = (int)(Math.random()*5);
		System.out.println(lose[num]);
	}

		
	public void getDraw()
	{
	String[]draw= new String [5];
	draw[0]= "Draw Game";
	draw[1]= "Not often it happens but we drew in that one";
	draw[2]= "Wow the same score each";
	draw[3]= "Stalemate!";
	draw[4]= "Same scores, onto next one";

		int num = (int)(Math.random()*5);
		System.out.println(draw[num]);
	}
	
	public void moneyGone()
	{
	String[]noMoney= new String [5];
	noMoney[0]= "Your out of money";
	noMoney[1]= "Back to the bank for you";
	noMoney[2]= "No money , no blackjack";
	noMoney[3]= "Come back with more money";
	noMoney[4]= "Your going to have to rob a bank after that game!";

		int num = (int)(Math.random()*5);
		System.out.println(noMoney[num]);
	}
	
	
	
	
	public void getGameOver()
	{
	String[]end;
	end = new String [5];
	end[0]= "Bye Now";
	end[1]= "That all you got?";
	end[2]= "Good game, well played";
	end[3]= "Until Next Time";
	end[4]= "All good things must come to an end";

		int num = (int)(Math.random()*5);
		System.out.println(end[num]);

	
	
	}

	public int getFirstTotal()
	{
		return rankInt;
	}
	

	public void dealerDrawCard()
	{
		this.randomSuitGenerator();
		this.randomRankGenerator();
		
		System.out.println("I have drawn the " + rank + " of " + suit);
	}
	
	
	public void hitOrStick(User sampleUser)
	{
		if( (this.getFirstTotal() > 21) && (sampleUser.justCheckingBust() < 21) )
		{
			System.out.println("\nI have gone bust and you haven't, you win"); //speaking as the dealer
		}
		else if( (this.getFirstTotal() < 21) && (this.getFirstTotal() > sampleUser.justCheckingBust()))
		{
			System.out.println("\nI  have won, I bet you"); //speaking as the dealer
		}
		
		else if( (this.getFirstTotal() < 21) && (this.getFirstTotal() < sampleUser.justCheckingBust()) && (sampleUser.justCheckingBust() < 21))
		{
			System.out.println("\nYou have won, you bet me"); //speaking as the dealer
		}

		

	}

	public void DealerCard()
	{
		sc = new Scanner(System.in);
		
		ArrayList<String> testList = new ArrayList<String>();
		Iterator<String> it = testList.iterator();
		
		this.card();
		
		String choice = "yes";
		
		int checker = 0;
		testList.add(this.card());
		
		System.out.println(this.getCardOutput());
		
		dealerTotal = this.getRankInt();
		
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
				
				dealerTotal = dealerTotal + this.getRankInt();
				
			}
			
			
			if( (checker == 0) && (dealerTotal < 21))
			{
			
				System.out.println("Dealer's total is: " + dealerTotal);
				Dealer.oneSec();
				
			}
			
			
		} while((dealerTotal < 21));

			System.out.println("Total is greater that 21");
			

	}	
		
	
	
}
	
	
	
	