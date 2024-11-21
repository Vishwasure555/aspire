import java.util.Scanner;

public class Home {
	void accessHome() {
Scanner scanner=new Scanner(System.in);
System.out.println("\nWelcome \n");
System.out.println("press 1 to Add  New Movie\n press 2 to view Movie List \n Press 3 for Viewers Detail \n Press 4 for Logout");
int Access=scanner.nextInt();
switch(Access) {
case 1:{
	System.out.println("Add  New Movie\n");

		  MovieDetail.addMovieDetail();
		  break;
}
case 2:{
	Movies.getmovies();
	break;
}

case 3:{
 System.out.println("Viewers Details:");
	
	ViewersDetail.getviewerDetail();
	
}
case 4:{
	System.out.print("Logged out");
}


scanner.close();
	}
	}
}
//ok