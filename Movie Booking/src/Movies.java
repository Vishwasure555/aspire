import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Movies {
public static void getmovies(){
	System.out.print("Movie List\n\n");
	try {
	    Connection connection ;
		 String databasename = "Moviebooking";
		  String url = "jdbc:mysql://localhost:3306/"+databasename;
		  String username ="root";
		 String password ="9898";
		 Class.forName("com.mysql.cj.jdbc.Driver");
	    connection = DriverManager.getConnection(url,username,password);
		String sql="select * from Moviebooking.movies";
//      PreparedStatement ps = connection.prepareStatement(sql);
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		System.out.println("movieid"+"      "+"movie"+"      "+"start"+"      "+"end"+"      "+" seat"+"      "+"price");
		while(rs.next()) {
		System.out.println(rs.getString(1)+"      "+rs.getString(2)+"      "+rs.getString(3)+"      "+rs.getString(4)+"      "+rs.getString(5)+"      "+rs.getString(6));
		}
//		System.out.print("sql");
	}catch(Exception e) {
		System.out.println(e);
	}
}

	}