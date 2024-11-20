import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ViewersDetail {
static void getviewerDetail() {
	System.out.println("Press 1 for full List\nPress 2 for Specific Movie");
	Scanner scanner=new Scanner(System.in);
	int choose=scanner.nextInt();
	try {
    Connection connection ;
	 String databasename = "Moviebooking";
	  String url = "jdbc:mysql://localhost:3306/"+databasename;
	  String username ="root";
	 String password ="9898";
	 Class.forName("com.mysql.cj.jdbc.Driver");
    connection = DriverManager.getConnection(url,username,password);
	if(choose==1) {
		

		String sql="select * from moviebooking.viewer";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		System.out.println("MovieID"+"           "+"Name"+"           "+"Mobile"+"           "+"Seat No");
		while(rs.next()) {
			System.out.println(rs.getString(1)+"           "+rs.getString(2)+"           "+rs.getString(3)+"           "+rs.getString(4));
		}
		}
	else {
		System.out.println("MovieID: ");
		Scanner scanner1=new Scanner(System.in);
		int Movieid=scanner1.nextInt();
		
		String query=("SELECT movies.movieid,movies.movie,movies.start,movies.end,movies.price, viewer.name,viewer.mobile,viewer.seat FROM movies,viewer where movies.movieid=viewer.movieid and movies.movieid="+Movieid);

		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		System.out.println("MovieID"+"           "+"Movie"+"           "+"Start"+"           "+"End"+"           "+"Price"+"           "+"price"+"           "+"Name"+"           "+"Mobile"+"           "+"Seat No");
		while(rs.next()) {
			System.out.println(rs.getString(1)+"           "+rs.getString(2)+"           "+rs.getString(3)+"           "+rs.getString(4)+"           "+
		rs.getString(5)+"           "+rs.getString(6)+"           "+rs.getString(7)+"           "+rs.getString(8));
		}
		scanner1.close();
	}
}catch(Exception e) {
	System.out.println(e);
}
}
public static void main(String[] args) {
	getviewerDetail();
}
}