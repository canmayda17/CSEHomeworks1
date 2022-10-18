// This program prints the tax according to the years and incomes. ( In Turkey )

import java.util.Scanner;

public class HW2_150120031_P3 {

    public static void main(String[] args) {

        // Create a scanner and prompt to the user to enter the year and income.
        Scanner input = new Scanner(System.in);
        double year = input.nextDouble();
        double income = input.nextDouble();
        double taxAmount = 0;
        double incomeAfterTax;
        double realTaxRate;

        // The taxes according to 2020.
        if (year == 2020) {

            if (income > 0 && income < 22000) {
                taxAmount = income * 0.15;

            }else if (income >= 22000 && income < 49000) {
                taxAmount = 3300 + (income-22000)*0.2;

            }else if (income >= 49000 && income < 180000) {
                taxAmount = 8700 + (income-49000)*0.27;

            }else if (income >= 180000 && income < 600000) {
                taxAmount = 44070 + (income-180000)*0.35;

            }else if (income >= 600000) {
                taxAmount = 191070 + (income-600000)*0.4;

            }else{
                System.out.println("Income must be > 0");
                System.exit(1);
            }

        }

        //The taxes according to 2019.
        else if (year == 2019) {

            if (income > 0 && income < 18000) {
                taxAmount = income * 0.15;

            }else if (income >= 18000 && income < 40000) {
                taxAmount = 2700 + (income-18000)*0.2;

            }else if (income >= 40000 && income < 148000) {
                taxAmount = 7100 + (income-40000)*0.27;

            }else if (income >= 148000 && income < 500000) {
                taxAmount = 36260 + (income-148000)*0.35;

            }else if (income >= 500000) {
                taxAmount = 159460 + (income-500000)*0.4;

            }else{
                System.out.println("Income must be > 0");
                System.exit(1);
            }

        }

        // The taxes according to 2018
        else if (year == 2018) {

            if (income > 0 && income < 14800) {
                taxAmount = income * 0.15;

            }else if (income >= 14800 && income < 34000) {
                taxAmount = 2220 + (income-14800)*0.2;

            }else if (income >= 34000 && income < 120000) {
                taxAmount = 6060 + (income-34000)*0.27;

            }else if (income >= 120000) {
                taxAmount = 29280 + (income-120000)*0.35;

            }else{
                System.out.println("Income must be > 0");
                System.exit(1);
            }

        }

        // The taxes according to 2017.
        else if (year == 2017) {

            if (income > 0 && income < 13000) {
                taxAmount = income * 0.15;

            }else if (income >= 13000 && income < 30000) {
                taxAmount = 1950 + (income-13000)*0.2;

            }else if (income >= 30000 && income < 110000) {
                taxAmount = 5350 + (income-30000)*0.27;

            }else if (income >= 110000) {
                taxAmount = 26950 + (income-110000)*0.35;

            }else{
                System.out.println("Income must be > 0");
                System.exit(1);
            }

        // If the user prompt a year that is not 2017,2018,2019 or 2020.
        }else{

            System.out.println("Undefined year value");
            System.exit(1);
        }

        // Calculate tax amount, income after tax and real tax rate.
        taxAmount= (int) (taxAmount * 100) / 100.0;
        incomeAfterTax= (int) ((income - taxAmount) * 100) / 100.0;
        realTaxRate= (int) ((taxAmount / income * 100) * 100) / 100.0;

        // Display the results.
        System.out.println("Income: " + income);
        System.out.println("Tax amount: " + taxAmount );
        System.out.println("Income after tax: " + incomeAfterTax );
        System.out.println("Real tax rate: " + realTaxRate + "%");
    }
}