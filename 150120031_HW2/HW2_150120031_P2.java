// This program prints Zeller's congruence which is calculating the day of the week according to some values.

import java.util.Scanner;

public class HW2_150120031_P2 {

    public static void main(String[] args) {

        //Create a scanner
        Scanner input= new Scanner(System.in);

        //Prompt to the user to enter year,month and the day of the month.
        System.out.print("Enter year (e.g. 2012): ");
        int year= input.nextInt();

        System.out.print("Enter month (e.g. 1-12): ");
        int month= input.nextInt();

        System.out.print("Enter the day of the month (e.g. 1-31): ");
        int day= input.nextInt();

        /* Because of January and February are counted as 13 and 14 in the formula,
        we need to convert the user input 1 to 13 and 2 to 14. */
        if (month == 1) {
            month = 13;
            --year;
        }else if (month == 2){
            month = 14;
            --year;
        }

        // Identify the century and the year of the century.
        int century= year/100;
        int yearOfTheCentury= year % 100;

        // Calculate day of the week with the formula.
        int dayOfTheWeek = (day + 26*(month + 1)/10 + yearOfTheCentury + yearOfTheCentury/4 + century/4 + 5 * century) % 7;

        //Display the day of the week according to the formula.
        if (dayOfTheWeek==0) {
            System.out.println("Day of the week is Saturday");
        }else if (dayOfTheWeek==1){
            System.out.println("Day of the week is Sunday");
        }else if (dayOfTheWeek==2){
            System.out.println("Day of the week is Monday");
        }else if (dayOfTheWeek==3){
            System.out.println("Day of the week is Tuesday");
        }else if (dayOfTheWeek==4){
            System.out.println("Day of the week is Wednesday");
        }else if (dayOfTheWeek==5){
            System.out.println("Day of the week is Thursday");
        }else if (dayOfTheWeek==6){
            System.out.println("Day of the week is Friday");
        }
    }
}