import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;


public class PlayingCardApp
{

	public static Scanner sc;
	
	public static void main(String [] args)
	{
			sc = new Scanner(System.in);
	
			RegisterConnect reg = new RegisterConnect();
			
			
			System.out.println("Welcome to Blackjack");
			System.out.println("Do you want to login or register?");
			System.out.println("1.Login\n2.Register");
			String choice = sc.next();
			while( (!choice.equalsIgnoreCase("Login")) && (!choice.equalsIgnoreCase("Register")))
					{
						System.out.println("Invalid Input, Please try again:");
						choice = sc.next();
					}
			if(choice.equalsIgnoreCase("Register"))
			{
				//reg.insertForm();
				System.out.println("Not working yet");
			}
			else if(choice.equalsIgnoreCase("Login"))
			{
				reg.userLogin();
			}
			
			User player = new User(reg.getFname(), reg.getBalance()); //this is for the users first card
			Dealer thisDealer = new Dealer("Stephen", 0); //this is for the dealers first card
			//Betting playerBet = new Betting(userName);
			
			
			System.out.println("Welcome " + player.getName() + " to our game!");
			System.out.println("My name is " + thisDealer.getName() + " and I am your dealer for tonight.");
			thisDealer.getBeginGame(); //Dealer random Intro generator
			User.manySec(3);
			
			double balance = player.getBalance();
			double bet = 0;
			double winBet = 0;
			double looseBet = 0;
			String playAgain = "yes";
			System.out.println("Your starting off today with: " + balance + " in the bank!");
			
			do
			{
			
			
			
			
			//Output how much the user has in the bank
			
			player.makeABet();
			
			
			bet = player.getAmount();
			
			player.checkBet();
			
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
			
			ArrayList<String> UserCards = new ArrayList<String>();
			Iterator<String> it = UserCards.iterator();
			
				UserCards.add(player.card());
				System.out.println(player.getCardOutput());
				
				
				int userTotal = player.getRankInt();
				
				System.out.println(userTotal);
	
				
				
				choice = "Hit"; //just needed for the loop to be entered
				
				
				int dealerCheck = 0; //this is just to enter the nested loop so that the dealers first card will be given

				
				int checker = 0;
				
				do 
				{
					
					
					int i = 0;
					String nextCard = player.card();
					
					do
					{
						
						if (nextCard.equalsIgnoreCase(UserCards.get(i)))
						{
							checker = 1;
						}
						else
						{
							checker = 0;
						}
						
			
						
						
						i++;
					} while( (i<UserCards.size()) && (checker != 1) );
					
					if( (checker == 0) && (userTotal < 21))
					{
						UserCards.add(nextCard);
						System.out.println(player.getCardOutput());
						
						userTotal = userTotal + player.getRankInt();
						
					}
					
					
					if ( (userTotal <= 21) && (checker == 0))
					{
					System.out.println("Your total is "  + userTotal);
					}
					
					while(dealerCheck == 0) //loop for the dealers first card
					{
						User.manySec(2);
						
						//ArrayList<String> DealerCards = new ArrayList<String>();
						//Iterator<String> it2 = DealerCards.iterator();
						
							UserCards.add(thisDealer.card());
							System.out.println(thisDealer.getCardOutput());
						
						
						dealerCheck = 1;
					}
					
					if (userTotal  < 21) //this is where the user decides to hit or sticks, exits the loop if > 21 or users sticks
					{
						User.oneSec();
						System.out.println("Would you like to hit or stick?\n1. Hit\n2. Stick");
						choice = sc.next();
						
							while ( (!choice.equalsIgnoreCase("hit")) && (!choice.equalsIgnoreCase("stick")))
							{
								System.out.println("I'm sorry but you must enter either Hit or Stick, please try again:");
								choice = sc.next();
							}
					}
					
					
				
				} while( (checker == 1) || (choice.equalsIgnoreCase("Hit")) && (userTotal < 21));
			
				
					int dealerTotal = thisDealer.getRankInt();
					
					
					while ( (userTotal <= 21) && (dealerTotal < userTotal))
					{
							
							
							int i = 0;
							String DealersCard = thisDealer.card();
							
							do
							{
								
								if (DealersCard.equalsIgnoreCase(UserCards.get(i)))
								{
									checker = 1;
								}
								else
								{
									checker = 0;
								}
								
					
								
								
								i++;
							} while( (i<UserCards.size()) && (checker != 1) );
							
							if( (checker == 0) && (userTotal < 21))
							{
								UserCards.add(DealersCard);
								System.out.println(thisDealer.getCardOutput());
								
								dealerTotal = thisDealer.getRankInt() + dealerTotal;		
							}
							

						
						User.oneSec();

				}

				//System.out.println("User total: " + userTotal);
				//System.out.println("Dealer total: " + dealerTotal);

						
			if (dealerTotal > 21)
			{
				System.out.println("I have gone bust");
				thisDealer.getUserWin();
				player.getBetWin();
				//Random dealer phrase when the user wins
				//Add on the amount for the bet to the total
			}
			else if( (dealerTotal < 21) && (dealerTotal > userTotal))
			{
				System.out.println(player.getName() + ": " + userTotal);
				System.out.println(thisDealer.getName() + ": " + dealerTotal);
				System.out.println("I win");
				thisDealer.getUserLoss();
				player.getBetLoss();
				
				//Random dealer phrase for when the dealer wins
				//Take away amount of bet from the user amount
			}
			else if ( (dealerTotal > 21) && (dealerTotal < userTotal))
			{
				System.out.println(player.getName() + ": " + userTotal);
				System.out.println(thisDealer.getName() + ": " + dealerTotal);
				System.out.println("You win");
				thisDealer.getUserWin();
				player.getBetWin();
				//Random dealer phrase for when the user wins
				//Add on the amount of the bet to the total
			}
			else if( dealerTotal == userTotal)
			{
				System.out.println(player.getName() + ": " + userTotal);
				System.out.println(thisDealer.getName() + ": " + dealerTotal);
				
				System.out.println("We draw");
				thisDealer.getDraw();
				player.getBetDraw();
				//Dealer phrase for when they draw
				//Give the amount of the bet back to the user
			}
			else if ( userTotal == 21)
			{
				System.out.println("Blackjack!");
				player.getBlackjack();
				thisDealer.getUserWin();
			}
			
			else
			{
				System.out.println("You have gone bust");
				System.out.println("I win");
				player.getBetLoss();
			}
			
		
			
			System.out.println("Your current balance is: " + player.getBalance());
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

