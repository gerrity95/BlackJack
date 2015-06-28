import java.util.Scanner;


public class Register {

	private static Scanner sc;
	
	public static void main(String[] args) {

		sc = new Scanner(System.in);
		System.out.println("Do you want to login or register?");
		System.out.println("1.Login\n2.Register");
		String choice = sc.next();
		while( (!choice.equalsIgnoreCase("Login")) && (!choice.equalsIgnoreCase("Register")))
				{
					System.out.println("Invalid Input, Please try again:");
					choice = sc.next();
				}
		
		
		RegisterConnect reg = new RegisterConnect();
		
		
		if(choice.equalsIgnoreCase("Register"))
		{
			reg.insertForm();
		}
		else if(choice.equalsIgnoreCase("Login"))
		{
			reg.userLogin();
		}
		
		String name = reg.getFname();

		System.out.println("Welcome " + name);
		
	}

}
