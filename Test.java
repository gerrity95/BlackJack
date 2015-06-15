//This is just the code I'm working on at the moment to ensure that duplicate cards don't appear.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Test {

	public static Scanner sc;
	
	public static void main(String[] args) {

		sc = new Scanner(System.in);
		
		ArrayList<Integer> testList = new ArrayList<Integer>();
		Iterator<Integer> it = testList.iterator();
		Random randomRank = new Random();
		
		String choice = "yes";
		
		//boolean nextCard;
		
		int  RandomForRank = randomRank.nextInt(10) + 1;
		int checker = 0;
		testList.add(RandomForRank);
		System.out.println(testList.get(0));
		
		
		do {
			RandomForRank = randomRank.nextInt(10) + 1;
			int i = 0;
			
			do
			{
				
				if (RandomForRank != testList.get(i))
				{
					checker = 0;
				}
				else
				{
					checker = 1;
				}
				
	
				
				
				i++;
			} while( (i<testList.size()) && (checker != 1) );
			
			if(checker == 0)
			{
				testList.add(RandomForRank);
			}
			
			for(i=0;i<testList.size();i++)
			{	
				System.out.println(testList.get(i));	
			}
			
			System.out.println("Do you want another card?");
			choice = sc.next();
			
		} while(choice.equalsIgnoreCase("yes"));
		
		
		
	}

}
