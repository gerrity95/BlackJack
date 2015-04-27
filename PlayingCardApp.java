import java.util.Scanner;

public class PlayingCardApp
{

	public static void main(String [] args)
	{
			Scanner sc = new Scanner(System.in);
	
	
			
			System.out.println("Welcome to Blackjack");
			System.out.println("Please, enter your name: ");
			String userName = sc.next();
			
			User player = new User(userName); //this is for the users first card
			Dealer thisDealer = new Dealer("Stephen"); //this is for the dealers first card
			Betting playerBet = new Betting(userName);
			
			
			System.out.println("Welcome " + player.getName() + " to our game!");
			System.out.println("My name is " + thisDealer.getName() + " and I am your dealer for tonight.");
			thisDealer.getBeginGame(); //Dealer random Intro generator
			player.manySec(3);
			
			double balance = playerBet.getBalance();
			double bet = 0;
			double winBet = 0;
			double looseBet = 0;
			String playAgain = "yes";
			System.out.println("Your starting off today with: " + balance + " in the bank!");
			do
			{
			
			
			
			
			//Output how much the user has in the bank
			
			playerBet.makeABet();
			
			
			bet = playerBet.getAmount();
			
			playerBet.checkBet();
			
			//winBet = (bet * 2);
			//looseBet = bet;
			
			if (bet <= 40)
			{
				thisDealer.getLowBet();
			}
			else if (bet > 40)
			{
				thisDealer.getHighBet();
			}
			
			
			
			
				int afterFirstCard = 0;
			
				//player.randomSuitGenerator(); //Gets the suit for each card
				//player.randomRankGenerator(); // Gets the rank for each card
				
				
				player.drawCard(); //this outputs what the card is
				
				afterFirstCard = player.getUserTotal();
				
				
				String choice = "Hit"; //just needed for the loop to be entered
				
				int playerTotal = afterFirstCard; //this is the total for the users cards
				//System.out.println("after next card is " + playerTotal);
				int dealerCheck = 0; //this is just to enter the nested loop so that the dealers first card will be given

				
				do 
				{
					player.drawCard();
				
				
					playerTotal = player.getUserTotal() + playerTotal; //this adds the total of all the cards and puts them in to a variable (playerTotal)
					
					if (playerTotal <= 21)
					{
					System.out.println("Your total is "  + playerTotal);
					}
					
					while(dealerCheck == 0) //loop for the dealers first card
					{
						player.manySec(2);
						thisDealer.dealerDrawCard();
						dealerCheck = 1;
					}
					
					if (playerTotal  < 21) //this is where the user decides to hit or sticks, exits the loop if > 21 or users sticks
					{
						player.oneSec();
						System.out.println("Would you like to hit or stick?\n1. Hit\n2. Stick");
						choice = sc.next();
						
							while ( (!choice.equalsIgnoreCase("hit")) && (!choice.equalsIgnoreCase("stick")))
							{
								System.out.println("I'm sorry but you must enter either Hit or Stick, please try again:");
								choice = sc.next();
							}
					}
				
				} while( (choice.equalsIgnoreCase("Hit")) && (playerTotal < 21));

				

				player.checkBust = playerTotal; //assigns a variable in the class to the total for the user so it can be used

				player.bustOrStick();
				
				int dealerTotal = thisDealer.getFirstTotal();
				
					while ( (playerTotal <= 21) && (dealerTotal < playerTotal))
					{
					
						thisDealer.dealerDrawCard();
						dealerTotal = thisDealer.getFirstTotal() + dealerTotal;
						player.oneSec();

					}
										
					if (dealerTotal > 21)
					{
						System.out.println("I have gone bust");
						thisDealer.getUserWin();
						playerBet.getBetWin();
						//Random dealer phrase when the user wins
						//Add on the amount for the bet to the total
					}
					else if( (dealerTotal < 21) && (dealerTotal > playerTotal))
					{
						System.out.println(player.getName() + ": " + playerTotal);
						System.out.println(thisDealer.getName() + ": " + dealerTotal);
						System.out.println("I win");
						thisDealer.getUserLoss();
						playerBet.getBetLoss();
						
						//Random dealer phrase for when the dealer wins
						//Take away amount of bet from the user amount
					}
					else if ( (dealerTotal > 21) && (dealerTotal < playerTotal))
					{
						System.out.println(player.getName() + ": " + playerTotal);
						System.out.println(thisDealer.getName() + ": " + dealerTotal);
						System.out.println("You win");
						thisDealer.getUserWin();
						playerBet.getBetWin();
						//Random dealer phrase for when the user wins
						//Add on the amount of the bet to the total
					}
					else if( dealerTotal == playerTotal)
					{
						System.out.println(player.getName() + ": " + playerTotal);
						System.out.println(thisDealer.getName() + ": " + dealerTotal);
						
						System.out.println("We draw");
						thisDealer.getDraw();
						playerBet.getBetDraw();
						//Dealer phrase for when they draw
						//Give the amount of the bet back to the user
					}
					
					
					else
					{
									
						System.out.println("I win");
						playerBet.getBetLoss();
					}
			

					
					System.out.println("Your current balance is: " + playerBet.getBalance());
					User.oneSec();
			
					if (balance > 0)
					{
					System.out.println("Would you like to play another hand?");
					playAgain = sc.next();
					
					while ( (!playAgain.equalsIgnoreCase("yes")) && (!playAgain.equalsIgnoreCase("no")))
					{
						System.out.println("I'm sorry but you must enter yes or no, please try again:");
						playAgain = sc.next();
					}
					}
					

			
			} while( (playAgain.equalsIgnoreCase("yes")) && (balance > 0));
			
			if (balance <= 0)
			{
				thisDealer.moneyGone();
			}
			else
			{
				thisDealer.getGameOver();
			}
	}
}