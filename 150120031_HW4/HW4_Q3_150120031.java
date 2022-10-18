// The purpose of this program is to draw diamond with the letters according to input letter.


import java.util.Scanner;

public class HW4_Q3_150120031 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a letter: ");
        String letter1 = input.nextLine();

        char letter = letter1.charAt(0);

        // User should enter letter. If he/she does not the system will warn them.
        if (letter1.length() != 1) {
            System.out.println("Invalid Input !");
            System.exit(1);
        }
        else if (!((letter > 64 && letter < 91) || (letter > 96 && letter < 123))) {
            System.out.println("Invalid Input !");
            System.exit(1);
        }
        if (letter > 96) {
            letter = (char)(letter - 32);
            printDiamond(constructDiamond(letter));
            System.out.println();
        }
        else
            printDiamond(constructDiamond(letter));
        System.out.println();

    }

    // Calculation part.
    public static char[][] constructDiamond(char letter) {

        char[][] constructDiamond = new char[(letter - 64) * 2 - 1][(letter - 64) * 2 - 1];

        for (int i = 0; i <constructDiamond.length; i++) {

            for (int j = 0; j < constructDiamond.length; j++) {

                if (j == constructDiamond.length / 2 + i || j == constructDiamond.length / 2 - i)
                    constructDiamond[i][j] = (char)(65 + i);
                else if (j == constructDiamond.length / 2 - constructDiamond.length - 1 - i && i > constructDiamond.length / 2 || j == constructDiamond.length / 2 + constructDiamond.length - 1 - i)
                    constructDiamond[i][j] = (char)(65 + constructDiamond.length - i - 1);
                else
                    constructDiamond[i][j] = (char)(46);

            }
        }
        return constructDiamond;

    }

    // Print part.
        public static void printDiamond (char[][] diamond){

        for (int i = 0; i < diamond.length; i++)

            for (int j = 0; j < diamond.length; j++) {

                System.out.print(diamond[i][j]);
            }
        System.out.println(" ");

        }
    }