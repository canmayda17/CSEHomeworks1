// The purpose of this program is to determine whether the number is valid or not according to Luhn algorithm.


import java.util.Scanner;

public class HW4_Q2_150120031 {

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
        // Take the number.
        String number = input.nextLine();

        for (int i = 0; i < number.length(); i++) {

            if (number.charAt(i) != ' ' && ((int)(number.charAt(i)) < 48 || (int)(number.charAt(i)) > 57)) {
                System.out.println("Invalid Input !");
                System.exit(1);
            }
        }

        // Determine the number is valid or not.
        if (validateNumber(number)) {
            System.out.println("Number is Valid");
        }
        else
            System.out.println("Number is Invalid");

    }

    public static boolean validateNumber (String number) {

        String cardNumber = "";

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != ' ')
                cardNumber += number.charAt(i);
        }

        String DNumber = "";
        String LNumber = "";

        if (cardNumber.length() % 2 == 0) {

            for (int i = 0; i < cardNumber.length(); i++) {

                if (i % 2 == 0) {
                    DNumber += cardNumber.charAt(i);

                    if (cardNumber.charAt(i) * 2 - 96 > 9)
                        LNumber += cardNumber.charAt(i) * 2 - 96 - 9;
                    else
                        LNumber += cardNumber.charAt(i) * 2 - 96;
                }
                else {
                    DNumber += "_";
                    LNumber += cardNumber.charAt(i);

                }
            }
        }

        if (cardNumber.length() % 2 == 1) {

            for (int i = 0; i < cardNumber.length(); i++)

                if (i % 2 == 0) {
                    DNumber += "_";
                    LNumber += cardNumber.charAt(i);
                }
                else {
                    DNumber += cardNumber.charAt(i);

                    if (cardNumber.charAt(i) * 2 - 96 > 9)
                        LNumber += cardNumber.charAt(i) * 2 - 96 - 9;
                    else
                        LNumber += cardNumber.charAt(i) * 2 - 96;
                }
        }

        // Print DNumber and LNumber.
        System.out.println("DNumber:" + DNumber);
        System.out.println("LNumber:" + LNumber);

        int sum = 0;

        for (int i = 0; i < LNumber.length(); i++) {
            sum += LNumber.charAt(i) - 48;
        }


        // Last check.
        if (sum % 10 == 0)
            return true;
        else
            return false;
    }
}