/* The purpose of this program is to calculate the bill for each flat according to inputs
(flat number, consumption of each flat, total bill) */


import java.util.Scanner;

public class HW4_Q1_150120031 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take the flat number.
        int n = input.nextInt();
        double[] flats = new double[n];

        for (int i = 0; i < flats.length; i++) {
        	// Take the consumption of each flat.
            flats[i] = input.nextDouble();
        }
        // Take the total bill.
        double totalBill = input.nextDouble();
        // Print the result.
        printBills( calculateTheInvoice(flats, totalBill) );

    }

    public static double[] calculateTheInvoice (double[] flats, double totalBill) {

        double[] bills = new double[flats.length];
        double sum = 0;
        for (int i = 0; i < flats.length; i++) {
            sum += flats[i];
        }

        for (int i = 0; i < flats.length; i++) {
        	// Calculation
            bills[i] = (int)(((totalBill * 0.3) / flats.length + totalBill * 0.7 * flats[i] / sum) * 100) / 100.0 ;
    }
        return bills ;
    }


    public static void printBills (double[] bills) {

        for (int i = 0; i < bills.length; i++)
            System.out.println("Flat #" + (i + 1) + ": " + bills[i]);
    }
}