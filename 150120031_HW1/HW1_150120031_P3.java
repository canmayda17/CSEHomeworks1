// The purpose of this program is to calculate the compound monthly interest with variables;
/* a) initial principal in TL/USD, etc. (p),
   b) annual interest rate percentage (r),
   c) number of time periods in months (t),
   d) monthly interest rate percentage (r/12),
   e) total compound interest amount in TL/USD, etc. (i),
   f) final balance amount in TL/USD, etc. (f) */

//Import the scanner.
import java.util.Scanner;

public class HW1_150120031_P3 {

	public static void main(String[] args) {
		
		//Create a scanner.
		Scanner input = new Scanner(System.in);
		
		//Promt to the user to enter initial principal amount.
		System.out.print("Enter initial principal amount: ");
		  double p= input.nextDouble();
		
		//Prompt to the user to enter annual interest rate.
		System.out.print("Enter annual interest rate: ");  
          double r= input.nextDouble();
          
        //Prompt to the user to enter number of time periods in months.  
        System.out.print("Enter number of time periods in months: ");
          double t= input.nextDouble();
          
          //Calculate the final balance amount (f) and total compound interest amount (i).
          double f= p * Math.pow((1 + r/1200) , t );
          double i= f-p ;
        
        //Display the results.  
        System.out.println("");
        System.out.println("Initial principal amount: " + p );
        System.out.println("Monthly interest rate: " + (int)(r/12 * 100) / 100.0 );
        System.out.println("Total compound interest amount: " + (int)(i * 100) / 100.0 );
        System.out.println("Final balance amount: " + (int)(f * 100) / 100.0 );
        
	}

}
