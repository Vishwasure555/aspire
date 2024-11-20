/* Title:Bus Reservation System
Created by:Vishva.S
Created On:20-10-2022
Modified By:
Reviewed By:
Reviewed On:
*/
    	import java.sql.SQLException;
import java .util.*;
    	public class MovieBooking {
    	    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
    	    	
    	    System.out.println("Enter Your Choice \n");
    	   System.out.println("1.Registration 2.Login \n");
    	   
    	   Scanner scanner=new Scanner(System.in);
    	   int page=scanner.nextInt();
    	      
    	   if(page==1) {
    	   
    	  SignUp.getDetail(); 
    	   }
    	   
    	   else{
    		
    	   Login.getDetail();
    	   }
    	   
    	   scanner.close();
    	    }
    	}