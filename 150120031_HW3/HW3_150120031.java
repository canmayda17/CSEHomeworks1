
// This program prints line, triangle, rectangle, parabola and circle according to input that user enters.

// Şükrü Can Mayda - 150120031

import java.util.Scanner;
public class HW3_150120031 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        

        while (true) {
        	System.out.println("Which shape would you like to draw?\n1. Line\n2. Triangle\n3. Rectangle\n4. Parabola\n5. Circle\n6.Exit");
            int number = input.nextInt();
            
            // Calculations of line.
        	if (number == 1) {

            System.out.print("Line formula is y = ax + b\nPlease enter the coefficients a and b:");

            int a = input.nextInt();
            int b = input.nextInt();

            for (int y = 10; y >= -11; y--) {
                for (int x = -10; x <= 11; x++) {
                    if (y == 0) {
                        if ((a * x + b) == 0)
                            System.out.print("*");
                        else if (x == 0)
                            System.out.print("|");
                        else if (x == 11)
                            System.out.print("x");
                        else
                            System.out.print("-");
                    } else if ((a * x + b) == y)
                        System.out.print("*");
                    else if (x == 0) {
                        if (y == 10)
                            System.out.print("y");
                        else
                            System.out.print("|");
                    } else
                        System.out.print(" ");
                }
                System.out.println("");
            }
        }

        // Calculations of triangle.
        if (number == 2) {

            System.out.print("For triangle, we need the coordinates of the points for three vertices.\n" +
                    "Please enter the coordinates of 3 vertices a,b,c,d,e,f:");

            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            int d = input.nextInt();
            int e = input.nextInt();
            int f = input.nextInt();

            double slope1 = (double) (d - b) / (double) (c - a);
            double slope2 = (double) (f - d) / (double) (e - c);
            double slope3 = (double) (f - b) / (double) (e - a);

            for (int y = 10; y >= -11; y--) {
                for (int x = -10; x <= 11; x++) {

                    if ((slope1) * (x - c) == (y - d) && (x <= Math.max(a, c) && x >= Math.min(a, c)) && (y >= Math.min(b, d) && y <= Math.max(b, d)))
                        System.out.print("*");
                    else if (slope2 * (x - c) == (y - d) && (x <= Math.max(c, e) && x >= Math.min(c, e)) && (y >= Math.min(d, f) && y <= Math.max(d, f)))
                        System.out.print("*");
                    else if (slope3 * (x - a) == (y - b) && (x <= Math.max(a, e) && x >= Math.min(a, e)) && (y >= Math.min(b, f) && y <= Math.max(b, f)))
                        System.out.print("*");
                    else if (y == 0) {

                        if (x == 0)
                            System.out.print("|");
                        else if (x == 11)
                            System.out.print("x");
                        else
                            System.out.print("-");
                    } else if (x == 0) {

                        if (y == 10)
                            System.out.print("y");
                        else
                            System.out.print("|");
                    } else
                        System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }


        // Calculations of rectangle
        if (number == 3) {

            System.out.print("For rectangle, we need the coordinates of the points for three vertices.\n" +
                    "Please enter the coordinates of 3 vertices a, b, c, d, e, f:");

            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            int d = input.nextInt();
            int e = input.nextInt();
            int f = input.nextInt();
            
            // Controlling the slope.
            double slopea= (double)(d - b)/(double)(c - a);
            double slopeb= (double)(f - b)/(double)(e - a);

            if(slopea*slopeb == -1||a == e){
            	
                int g= c;
                c= a;
                a= g;

                int h= d;
                d= b;
                b= h;
            }

            // Fourth point.
            int g = a + e - c;
            int h = b + f - d;


            // Four slopes.
            double slope1 = (double) (d - b) / (double) (c - a);
            double slope2 = (double) (f - d) / (double) (e - c);
            double slope3 = (double) (h - f) / (double) (g - e);
            double slope4 = (double) (h - b) / (double) (g - a);

            if (slope1 * slope2 == -1 || (a == c) || (c == e) || (e == g) || (g == a)) {


                for (int y = 10; y >= -11; y--) {
                    for (int x = -10; x <= 11; x++) {

                        if (((slope1) * (x - c) == (y - d) || (a == c)) && (x <= Math.max(a, c) && x >= Math.min(a, c)) && (y >= Math.min(b, d) && y <= Math.max(b, d)))
                            System.out.print("*");
                        else if ((slope2 * (x - c) == (y - d) || (c == e)) && (x <= Math.max(c, e) && x >= Math.min(c, e)) && (y >= Math.min(d, f) && y <= Math.max(d, f)))
                            System.out.print("*");
                        else if ((slope3 * (x - e) == (y - f) || (e == g)) && (x <= Math.max(e, g) && x >= Math.min(e, g)) && (y >= Math.min(f, h) && y <= Math.max(f, h)))
                            System.out.print("*");
                        else if ((slope4 * (x - g) == (y - h) || (a == g)) && (x <= Math.max(a, g) && x >= Math.min(a, g)) && (y >= Math.min(b, h) && y <= Math.max(b, h)))
                            System.out.print("*");
                        else if (y == 0) {
                            if (x == 0)
                                System.out.print("|");
                            else if (x == 11)
                                System.out.print("x");
                            else
                                System.out.print("-");
                        } else if (x == 0) {
                            if (y == 10)
                                System.out.print("y");
                            else
                                System.out.print("|");
                        } else
                            System.out.print(" ");
                    }
                    System.out.println();
                }
                System.out.println();
            } else
                System.out.println("Unfortunately, rectangles can not drawn with these inputs..");
        }


            // Calculations of parabola.
            if (number == 4) {

                System.out.print("Parabola formula is y = ax^2 + bx + c\nPlease enter the coefficients a, b and c:");

                int a= input.nextInt();
                int b= input.nextInt();
                int c= input.nextInt();

                for (int y= 10; y >= -10; y--) {
                    for (int x = -10; x <= 11; x++) {
                        if (y == 0) {
                            if (a * Math.pow(x,2) + b * x + c == 0)
                                System.out.print("*");
                            else if (x == 0)
                                System.out.print("|");
                            else if (x == 11)
                                System.out.print("x");
                            else
                                System.out.print("-");
                        }
                        else if ((a * Math.pow(x,2) + b * x + c) == y)
                            System.out.print("*");
                        else if (x == 0) {
                            if (y == 10)
                            System.out.print("y");
                            else
                            System.out.print("|");
                        }
                        else
                            System.out.print(" ");
                    }
                    System.out.println("");
                }
                System.out.println("\n\n");
                }

            // Calculations of circle.
            if (number == 5) {

                System.out.print("Circle formula is (x-a)^2 + (y-b)^2 = r^2\n" +
                        "Please enter the coordinates of the center (a,b) and the radius:");

                int a= input.nextInt();
                int b= input.nextInt();
                int r= input.nextInt();

                for (int y= 10; y >= -11; y--) {
                    for (int x = -10; x <= 11; x++) {
                        if (y == 0) {
                            if (Math.pow(x - a, 2) + Math.pow(y - b, 2) - Math.pow(r, 2) == 0)
                            System.out.print("*");
                            else if (x == 0)
                                System.out.print("|");
                            else if (x == 11)
                                System.out.print("x");
                            else
                                System.out.print("-");
                        }
                        else if (Math.pow(x - a, 2) + Math.pow(y - b, 2) == Math.pow(r, 2))
                            System.out.print("*");
                        else if (x == 0) {
                            if (y == 10)
                                System.out.print("y");
                            else
                                System.out.print("|");
                        }
                        else
                            System.out.print(" ");
                    }
                    System.out.println("");
                }
                System.out.println("\n\n");
            }

            // Exit.
            if (number == 6) {
                System.out.print(" ");
                break;
            }
        }
    }
}

