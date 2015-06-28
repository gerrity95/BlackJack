import java.util.Scanner;
import java.sql.*;

public class RegisterConnect {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String user = "";
	private String pword = "";
	
	private String fname;
	private String lname;
	private String password;
	public double balance;
	public int userID = 0;
	
	Scanner sc = new Scanner(System.in);
	
	public RegisterConnect()
	{
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack", user, pword); //change these to strings
			st = con.createStatement();
			
		}catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}
	
	public String getFname()
	{
		return fname;
	}
	
	public String getLname()
	{
		return lname;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public double getBalance()
	{
		
		try{
			
			String getBal = "SELECT balance FROM users WHERE ID = ' "+userID+" ' "; //This gets the password to check if it matches the ID
			rs = st.executeQuery(getBal);
			while(rs.next()){
			balance = rs.getDouble("balance");
			}
			}catch (Exception ex) {
				System.out.println("Error: " + ex);
				}
		
		
		return balance;
	}
	
	public void insertForm() //Allows user to input the data
	{
		
		System.out.println("Please enter First name:");
		fname = sc.next();
		
		System.out.println("\nPlease enter Surname:");
		lname = sc.next();
		
		System.out.println("\nPlease enter Password:");
		password = sc.next();
		
		String checkPword = password;
		
		try{
		
		String sql = "insert into users "
				+ " (fname, lname, password)"
				+ " values (? , ?, ?)";
		
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
		statement.setString(1, fname);
		statement.setString(2, lname);
		statement.setString(3, password);
		//statement.setDouble(4, balance);
		
		statement.execute();
		
		//st.executeUpdate(sql);
		
		
		}catch (Exception ex) {
			System.out.println("Error: " + ex);
			}

		
		
		try{
		System.out.println(checkPword);
		int userID = 0;
		String getID = "select ID FROM users WHERE password = ' "+checkPword+" '";
		rs = st.executeQuery(getID);
		while(rs.next()){
			userID = rs.getInt("ID");
		}
		
		
		System.out.println("Insert Complete");
		System.out.print("Your unique ID is: ");
		System.out.println(userID);
		
		}catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
		
	} 
	
	public void userLogin()
	{
		int userID = 0;
		String userPword;
		String tryAgain = "yes";
		
		while(tryAgain.equalsIgnoreCase("yes"))
		{
		System.out.println("Please enter your ID: ");
		userID = sc.nextInt();
		
		System.out.println("Please enter your password: ");
		userPword = sc.next();
		
		try{
			
			String checkPword = "SELECT password FROM users WHERE ID = ' "+userID+" ' "; //This gets the password to check if it matches the ID
			rs = st.executeQuery(checkPword);
			while(rs.next()){
			password = rs.getString("password");
			}
			
				if(userPword.equals(this.getPassword()))
				{
					String loginQuery = "SELECT * FROM users WHERE ID = ' "+userID+" ' "; //This is just to get the details of the user
					rs = st.executeQuery(loginQuery);
					while(rs.next()){
					fname = rs.getString("fname");
					lname = rs.getString("lname");
					balance = rs.getDouble("balance");
				
					System.out.println("First name: " + this.getFname() + "\nSurname: " + this.getLname() + "\nBalance: " + this.getBalance());
					}
					
					tryAgain = "no";
				}
				else //Change so that it asks them to either try again or sends them to website to request their ID
				{
					System.out.println("Invalid ID or password");
					System.out.println("Would you like to try again? (Yes/No)");
					tryAgain = sc.next();
					
					while( (tryAgain.equalsIgnoreCase("yes")) && (tryAgain.equalsIgnoreCase("no")))
					{
						System.out.println("Invalid Input, please try again:");
						tryAgain = sc.next();
					}
					
					if(tryAgain.equalsIgnoreCase("no"))
					{
						//Redirect them to website where they can contact the admin
					}
					
				}
			
			
			
		}catch (Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		
		
		} //end of while loop for whole thing
		
	}
	
	
}