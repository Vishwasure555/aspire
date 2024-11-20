import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
	public class Login {
		 static String name;
		  static String Pass;
		  static Connection connection=null;
			static  String databasename = "";
			 static String url = "jdbc:mysql://localhost:3306/"+databasename;
			  static String username ="root";
			 static String password ="9898";
		public static void getDetail()  {
			
			Scanner scanner= new Scanner(System.in);
			System.out.println("USERNAME:");
			name=scanner.next();
			System.out.println(" PASSWORD:");
			Pass=scanner.next();				
			   try {
				   Class.forName("com.mysql.cj.jdbc.Driver");
				   connection = DriverManager.getConnection(url,username,password);
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery("select Username, Password from Moviebooking.owner");
			int flag=0;
			Map<String,String> map = new LinkedHashMap<>();
			while(rs.next()) {
				map.put(rs.getString(1), rs.getString(2));	
			}
		for(Entry<String,String> e : map.entrySet()) {
				if((name.equals(e.getKey()))&&(Pass.equals(e.getValue()))) {
					flag=1;
					System.out.println("Loggedin Successfully");
					System.out.println("WELCOME ADMIN " +name);
					Home home=new Home();
					home.accessHome();
				}
		}
		if(flag==0) {
			System.out.println("Invalid Username or Password");
				getDetail();
		}
			
		}
			   catch(Exception e) {
			System.out.println(e);
		}
		scanner.close();
		

  	   
			}

	}