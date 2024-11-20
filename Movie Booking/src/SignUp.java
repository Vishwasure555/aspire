import java.util.Scanner;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import java.sql.*;

	public class SignUp {
		
		static boolean validateEmail(String Email) {
			
			String emailValidation="^(.+)@(.+)$";
			Pattern pattern=Pattern.compile(emailValidation);
			Matcher m=pattern.matcher(Email);

			if(m.matches()) {
				return true;
			}
			
			return false;
		}


		

		static String Name;
		static String Mobile_no;
		static String Email;
		static String Confirm_password;
		static String Username;
		static String Password;

		public static void getDetail(){
			
			System.out.println("Welcome to My Ticket Space.com");
		        
		Scanner scanner=new Scanner(System.in);

		System.out.println("Name: ");
		    Name=scanner.nextLine();
		while(!Name.matches("[a-z A-Z]+")) {
			System.out.println("Enter valid Name");
		    Name=scanner.nextLine();
		}

		System.out.println(" Username: ");
		 Username=scanner.next();
		while(Username.length()<4||Username.length()>10) {
			System.out.println("Enter valid UserName");
		    Username=scanner.next();
		}
		System.out.println(" Email: ");
		Email=scanner.next();

		while(! validateEmail(Email)) {
			System.out.println("Enter valid Email Address");
			 Email=scanner.next();
		}
			


		System.out.println(" Mobile Number: ");
		 Mobile_no=scanner.next();
		while(Mobile_no.equals("^[0-9]")) {
			System.out.println("Enter valid Mobile Number");
		    Mobile_no=scanner.next();
		}
		while(Mobile_no.length()!=10) {
			System.out.println("Enter valid Mobile Number");
		    Mobile_no=scanner.next();
		}
		System.out.println(" Password: ");
		 Password=scanner.next();

		

		System.out.println("Confirm password: ");
		 Confirm_password=scanner.next();
		while(!Password.equals(Confirm_password)) {
			System.out.println("Password and Confirm password does not match");
			Confirm_password=scanner.next();
		
}
try {
    Connection connection ;
	 String databasename = "Moviebooking";
	  String url = "jdbc:mysql://localhost:3306/"+databasename;
	  String username ="root";
	 String password ="9898";
	 Class.forName("com.mysql.cj.jdbc.Driver");
    connection = DriverManager.getConnection(url,username,password);
    PreparedStatement statement = connection.prepareStatement("insert into Moviebooking.owner(Name,Email,Mobile_no,Password,Username)values (?,?,?,?,?)");
    statement.setString(1,Name);//1 specifies the first parameter in the query  
     statement.setString(2,Email);
     statement.setString(3,Mobile_no);
     statement.setString(4,Password);
     statement.setString(5,Username);

     statement.executeUpdate();
     System.out.println("Admin Registration Successfull");
    
     Login.getDetail();
}catch(Exception e) {
	System.out.println(e);
}
scanner.close();
      }
}