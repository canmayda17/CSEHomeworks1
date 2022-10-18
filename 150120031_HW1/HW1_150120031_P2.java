// The purpose of this program is to convert a date that is given in days to years, months and days.


//Import the scanner.
import java.util.Scanner;

public class HW1_150120031_P2 {

	public static void main(String[] args) {
		
		//Create a scanner.
		Scanner input = new Scanner(System.in);
		
		//Prompt to the user to enter number of days.
		System.out.print("Number of days: hfhf");
		
		int promptDay= input.nextInt();
		
		//Calculate years, months and days.
		int years= promptDay / 365;
		int months= promptDay % 365 / 31;
		int days= promptDay % 365 % 31;
		
		//Display the years, months and days separately.
		System.out.println("Year: " + years + ", Month: " + months + ", Day: " + days + "." );
		
			
	}

}
