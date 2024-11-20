import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MovieDetail{
	
public static void addMovieDetail() {
	
	
	Scanner scanner=new Scanner(System.in);
	System.out.println("Movieid: ");
	int Movieid=scanner.nextInt();
	
	System.out.println("Movie: ");
	scanner.nextLine();
	String Movie=scanner.nextLine();
	
	System.out.println("Start: ");
	String Start=scanner.nextLine();
	
	System.out.println("End: ");
	String End=scanner.nextLine();
	
	
	System.out.println("Seat: ");
	String Seat=scanner.next();
	
	
	
	System.out.println("Price: ");
	int Price=scanner.nextInt();
	
	

	Movie movie=new Movie(Movieid,Movie,Start,End ,Seat,Price);
	
	try {
	     Connection connection ;
		 String databasename = "Moviebooking";
		  String url = "jdbc:mysql://localhost:3306/"+databasename;
		  String username ="root";
		 String password ="9898";
		 Class.forName("com.mysql.cj.jdbc.Driver");
	     connection = DriverManager.getConnection(url,username,password);
	     
	     String sql=("insert into Moviebooking.movies(movieid,movie,start,end,seat,price)VALUES(?,?,?,?,?,?)");
	     PreparedStatement st=connection.prepareStatement(sql);
	     
	     st.setInt(1,movie.getMovieid());
	     st.setString(2,movie.getMovie());
	     st.setString(3,movie.getStart());
	     st.setString(4,movie.getEnd());
	     st.setString(5,movie.getSeat());
	     st.setInt(6,movie.getPrice());
	    
	     
	     st.executeUpdate();
	     System.out.println("Movie Details Added Successfully");
	     select();
	}catch(Exception e) {
		System.out.println(e);
	}
	scanner.close();
}

public static void select() {
	System.out.println("1.Add More Movies  2.Exit\n");
	Scanner sc=new Scanner(System.in);
	int Choose=sc.nextInt();
	if(Choose==1) {
		MovieDetail.addMovieDetail();
	}
	else {
		Home home=new Home();
		home.accessHome();
	}
	sc.close();
}

}

class Movie {
	private int Movieid;
	private String Movie;
	private String Start;
	private String End;
	private String Seat;
	private int Price;
	
	
	
	public Movie(int movieid, String movie, String start, String end,
			String seat, int price) 
	{
		super();
		Movieid= movieid;
		Movie = movie;
		Start = start;
		End= end;
		Seat = seat;
		Price = price;

	}

	
	public int getMovieid() {
		return Movieid;
	}
	public void setMovieid(int movieid) {
		Movieid = movieid;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	
	public String getMovie() {
		return Movie;
	}
	public void setMovie(String movie) {
		Movie = movie;
	}
	public String getStart() {
		return Start;
	}
	public void setStart(String start) {
	 Start= start;
	}
	public String getEnd() {
		return End;
	}
	public void setEnd(String end) {
		End = end;
	}
	
	public String getSeat() {
		return Seat;
	}
	public void setSeat(String seat) {
	  Seat = seat;
	}

}