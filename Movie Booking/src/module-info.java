/* Title:Bus Reservation System
Created by:Hariharan.R
Created On:
Modified By:
Reviewed By:
Reviewed On:
*/
    	import java.sql.SQLException;
import java .util.*;
    	public class Main {
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