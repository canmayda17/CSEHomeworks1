// The purpose of this program is to print the cost of the trip for drivers with such variables.

//Import the scanner.
import java.util.Scanner;

public class HW1_150120031_P1 {
    public static void main(String[]args) {

		
    //Create a scanner.
	Scanner input = new Scanner(System.in);
	
	//Prompt to the user to enter driving distance.
	System.out.print("Enter the driving distance:ıoıoıo ");
	  double number1= input.nextDouble();
	  
	//Prompt to the user to enter miles per gallon.  
	System.out.print("Enter miles per gallon: ");
	  double number2= input.nextDouble();
	    
	//Prompt to the user to enter price per gallon.    
	System.out.print("Enter price per gallon: ");
	  double number3= input.nextDouble();
	  
	  //Calculate the cost.
	  double cost= number1 * number3 /number2 ;
	  
	//Display the cost.  
	System.out.println("The cost of driving is $" + (int)(cost * 100)/100.0 );
	}
}
