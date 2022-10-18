// This program prints the last digit of the ISBN-10 number according to first 9 digits.

import java.util.Scanner;

public class HW2_150120031_P1 {

    public static void main(String[] args) {

        //Create a scanner.
        Scanner input = new Scanner(System.in);

        //Prompt to the user to enter first 9 digits of an ISBN number.
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        int numberISBN = input.nextInt();

        //Calculate each digit.
        int A = numberISBN % 1000000000 / 100000000;
        int B = numberISBN % 100000000 / 10000000;
        int C = numberISBN % 10000000 / 1000000;
        int D = numberISBN % 1000000 / 100000;
        int E = numberISBN % 100000 / 10000;
        int F = numberISBN % 10000 / 1000;
        int K = numberISBN % 1000 / 100;
        int L = numberISBN % 100 / 10;
        int M = numberISBN % 10;

        //Calculate the last digit.
        int N = ((A * 1 + B * 2 + C * 3 + D * 4 + E * 5 + F * 6 + K * 7 + L * 8 + M * 9) % 11);


        //If statements for A==0,A!=0,N==10,N!=10. ( There are 4 possibilities. )
        if (A == 0 && N == 10) {
            System.out.println("The ISBN-10 number is 0" + numberISBN + "X");
        }
        else if (A == 0) {
            System.out.println("The ISBN-10 number is 0" + numberISBN + N);
        }
        else if (N==10) {
            System.out.println("The ISBN-10 number is " + numberISBN + "X");

        }else{
            System.out.println("The ISBN-10 number is " + numberISBN + N);
        }
    }
}