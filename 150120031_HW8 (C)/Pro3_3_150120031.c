// Sukru Can Mayda - 150120031
// The purpose of this program is to print triangle with the given number.

#include <stdio.h>
#include <stdlib.h>

int number;
int row = 32;
int column = 63;
int row1 = 1;
int row2 = 1;
int row3 = 1;
int row4 = 1;
int row5 = 1;
int row6 = 1;
int row7 = 1;
int row8 = 1;
int row9 = 1;
int row10 = 1;
int row11 = 1;
int row12 = 1;
int row13 = 1;
int row14 = 1;
int row15 = 1;
int row16 = 1;

int main()
{
	//Get the number
    printf("Enter a number: ");
    scanf("%d", &number);
    makeTriangle();


}

//The function of how to make triangle with the given number
void makeTriangle() {

//If the number = 0
    if (number == 0) {
        if (row == 0) {
                return 0;
            }
        if ((column <= 32 + (row1/2)) && (column >= 32 - (row1/2))) {
            printf("1");
            column--;
            makeTriangle();
        }

        else if (column != 0){
            printf("_");
            column--;
            makeTriangle();
        }
        if (column == 0) {
            row--;
            printf("\n");
            column = 63;
            row1 += 2;
            makeTriangle();
    }
    else if (row != 0) {
        makeTriangle();
        }
    }
    //If the number = 1
    else if (number == 1) {
        if (row == 0) {
                return 0;
            }
        if ((column <= 32 + (row1/2)) && (column >= 32 - (row1/2)) && (row > 16)) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((column <= 48 + (row2/2)) && (column >= 48 - (row2/2)) && (row <= 16)) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((column <= 16 + (row2/2)) && (column >= 16 - (row2/2)) && (row <= 16)) {
            printf("1");
            column--;
            makeTriangle();
        }


        else if (column != 0){
            printf("_");
            column--;
            makeTriangle();
        }
        if (column == 0) {
            row--;
            printf("\n");
            column = 63;
            row1 += 2;
            if (row < 16) {
                row2 += 2;
            }
            makeTriangle();
    }
    else if (row != 0) {
        makeTriangle();
        }
    }
    //If the number = 2
    else if (number == 2) {
        if (row == 0) {
                return 0;
            }
        if ((column <= 32 + (row1/2)) && (column >= 32 - (row1/2)) && (row > 24)) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 40 + (row2/2)) && (column >= 40 - (row2/2))) || ((column <= 24 + (row2/2)) && (column >= 24 - (row2/2)))) && ((row <= 24) && (row > 16))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 48 + (row3/2)) && (column >= 48 - (row3/2))) || ((column <= 16 + (row3/2)) && (column >= 16 - (row3/2)))) && ((row <= 16) && (row > 8))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 56 + (row4/2)) && (column >= 56 - (row4/2))) || ((column <= 40 + (row4/2)) && (column >= 40 - (row4/2)))) && ((row <= 8) && (row > 0))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 24 + (row4/2)) && (column >= 24 - (row4/2))) || ((column <= 8 + (row4/2)) && (column >= 8 - (row4/2)))) && ((row <= 8) && (row > 0))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if (column != 0){
            printf("_");
            column--;
            makeTriangle();
        }
        if (column == 0) {
            row--;
            printf("\n");
            column = 63;
            row1 += 2;
            if ((row < 24) && (row >= 16)) {
                row2 += 2;
            }
            else if ((row < 16) && (row >= 8)){
                row3 += 2;
            }
            else if ((row < 8) && (row >= 0)) {
                row4 += 2;
            }
            makeTriangle();
    }
    else if (row != 0) {
        makeTriangle();
        }
    }
    //If the number = 3
    else if (number == 3) {
            if (row == 0) {
                return 0;
            }
        if ((column <= 32 + (row1/2)) && (column >= 32 - (row1/2)) && (row > 28)) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 36 + (row2/2)) && (column >= 36 - (row2/2))) || ((column <= 28 + (row2/2)) && (column >= 28 - (row2/2)))) && ((row <= 28) && (row > 24))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 40 + (row3/2)) && (column >= 40 - (row3/2))) || ((column <= 24 + (row3/2)) && (column >= 24 - (row3/2)))) && ((row <= 24) && (row > 20))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 44 + (row4/2)) && (column >= 44 - (row4/2))) || ((column <= 36 + (row4/2)) && (column >= 36 - (row4/2))) || ((column <= 28 + (row4/2)) && (column >= 28 - (row4/2))) || ((column <= 20 + (row4/2)) && (column >= 20 - (row4/2)))) && ((row <= 20) && (row > 16))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 48 + (row5/2)) && (column >= 48 - (row5/2))) || ((column <= 16 + (row5/2)) && (column >= 16 - (row5/2)))) && ((row <= 16) && (row > 12))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 52 + (row6/2)) && (column >= 52 - (row6/2))) || ((column <= 44 + (row6/2)) && (column >= 44 - (row6/2))) || ((column <= 20 + (row6/2)) && (column >= 20 - (row6/2))) || ((column <= 12 + (row6/2)) && (column >= 12 - (row6/2)))) && ((row <= 12) && (row > 8))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 56 + (row7/2)) && (column >= 56 - (row7/2))) || ((column <= 40 + (row7/2)) && (column >= 40 - (row7/2))) || ((column <= 24 + (row7/2)) && (column >= 24 - (row7/2))) || ((column <= 8 + (row7/2)) && (column >= 8 - (row7/2)))) && ((row <= 8) && (row > 4))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 60 + (row8/2)) && (column >= 60 - (row8/2))) || ((column <= 52 + (row8/2)) && (column >= 52 - (row8/2))) || ((column <= 44 + (row8/2)) && (column >= 44 - (row8/2))) || ((column <= 36 + (row8/2)) && (column >= 36 - (row8/2)))) && ((row <= 4) && (row > 0))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 28 + (row8/2)) && (column >= 28 - (row8/2))) || ((column <= 20 + (row8/2)) && (column >= 20 - (row8/2))) || ((column <= 12 + (row8/2)) && (column >= 12 - (row8/2))) || ((column <= 4 + (row8/2)) && (column >= 4 - (row8/2)))) && ((row <= 4) && (row > 0))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if (column != 0){
            printf("_");
            column--;
            makeTriangle();
        }
        if (column == 0) {
            row--;
            printf("\n");
            column = 63;
            row1 += 2;
            if ((row < 28) && (row >= 24)) {
                row2 += 2;
            }
            else if ((row < 24) && (row >= 20)){
                row3 += 2;
            }
            else if ((row < 20) && (row >= 16)) {
                row4 += 2;
            }
            else if ((row < 16) && (row >= 12)) {
                row5 += 2;
            }
            else if ((row < 12) && (row >= 8)) {
                row6 += 2;
            }
            else if ((row < 8) && (row >= 4)) {
                row7 += 2;
            }
            else if ((row < 4) && (row >= 0)) {
                row8 += 2;
            }
            makeTriangle();
    }
    else if (row != 0) {
        makeTriangle();
        }
        }
        //If the number = 4
        else if (number == 4) {
            if (row == 0) {
                return 0;
            }
        if ((column <= 32 + (row1/2)) && (column >= 32 - (row1/2)) && (row > 30)) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 34 + (row2/2)) && (column >= 34 - (row2/2))) || ((column <= 30 + (row2/2)) && (column >= 30 - (row2/2)))) && ((row <= 30) && (row > 28))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 36 + (row3/2)) && (column >= 36 - (row3/2))) || ((column <= 28 + (row3/2)) && (column >= 28 - (row3/2)))) && ((row <= 28) && (row > 26))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 38 + (row4/2)) && (column >= 38 - (row4/2))) || ((column <= 34 + (row4/2)) && (column >= 34 - (row4/2))) || ((column <= 30 + (row4/2)) && (column >= 30 - (row4/2))) || ((column <= 26 + (row4/2)) && (column >= 26 - (row4/2)))) && ((row <= 26) && (row > 24))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 40 + (row5/2)) && (column >= 40 - (row5/2))) || ((column <= 24 + (row5/2)) && (column >= 24 - (row5/2)))) && ((row <= 24) && (row > 22))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 42 + (row6/2)) && (column >= 42 - (row6/2))) || ((column <= 38 + (row6/2)) && (column >= 38 - (row6/2))) || ((column <= 26 + (row6/2)) && (column >= 26 - (row6/2))) || ((column <= 22 + (row6/2)) && (column >= 22 - (row6/2)))) && ((row <= 22) && (row > 20))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 44 + (row7/2)) && (column >= 44 - (row7/2))) || ((column <= 36 + (row7/2)) && (column >= 36 - (row7/2))) || ((column <= 28 + (row7/2)) && (column >= 28 - (row7/2))) || ((column <= 20 + (row7/2)) && (column >= 20 - (row7/2)))) && ((row <= 20) && (row > 18))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 46 + (row8/2)) && (column >= 46 - (row8/2))) || ((column <= 42 + (row8/2)) && (column >= 42 - (row8/2))) || ((column <= 38 + (row8/2)) && (column >= 38 - (row8/2))) || ((column <= 34 + (row8/2)) && (column >= 34 - (row8/2)))) && ((row <= 18) && (row > 16))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 30 + (row8/2)) && (column >= 30 - (row8/2))) || ((column <= 26 + (row8/2)) && (column >= 26 - (row8/2))) || ((column <= 22 + (row8/2)) && (column >= 22 - (row8/2))) || ((column <= 18 + (row8/2)) && (column >= 18 - (row8/2)))) && ((row <= 18) && (row > 16))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 48 + (row9/2)) && (column >= 48 - (row9/2))) || ((column <= 16 + (row9/2)) && (column >= 16 - (row9/2)))) && ((row <= 16) && (row > 14))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 50 + (row10/2)) && (column >= 50 - (row10/2))) || ((column <= 46 + (row10/2)) && (column >= 46 - (row10/2))) || ((column <= 18 + (row10/2)) && (column >= 18 - (row10/2))) || ((column <= 14 + (row10/2)) && (column >= 14 - (row10/2)))) && ((row <= 14) && (row > 12))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 52 + (row11/2)) && (column >= 52 - (row11/2))) || ((column <= 44 + (row11/2)) && (column >= 44 - (row11/2))) || ((column <= 20 + (row11/2)) && (column >= 20 - (row11/2))) || ((column <= 12 + (row11/2)) && (column >= 12 - (row11/2)))) && ((row <= 12) && (row > 10))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 54 + (row12/2)) && (column >= 54 - (row12/2))) || ((column <= 50 + (row12/2)) && (column >= 50 - (row12/2))) || ((column <= 46 + (row12/2)) && (column >= 46 - (row12/2))) || ((column <= 42 + (row12/2)) && (column >= 42 - (row12/2)))) && ((row <= 10) && (row > 8))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 22 + (row12/2)) && (column >= 22 - (row12/2))) || ((column <= 18 + (row12/2)) && (column >= 18 - (row12/2))) || ((column <= 14 + (row12/2)) && (column >= 14 - (row12/2))) || ((column <= 10 + (row12/2)) && (column >= 10 - (row12/2)))) && ((row <= 10) && (row > 8))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 56 + (row13/2)) && (column >= 56 - (row13/2))) || ((column <= 40 + (row13/2)) && (column >= 40 - (row13/2))) || ((column <= 24 + (row13/2)) && (column >= 24 - (row13/2))) || ((column <= 8 + (row13/2)) && (column >= 8 - (row13/2)))) && ((row <= 8) && (row > 6))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 58 + (row14/2)) && (column >= 58 - (row14/2))) || ((column <= 54 + (row14/2)) && (column >= 54 - (row14/2))) || ((column <= 42 + (row14/2)) && (column >= 42 - (row14/2))) || ((column <= 38 + (row14/2)) && (column >= 38 - (row14/2)))) && ((row <= 6) && (row > 4))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 26 + (row14/2)) && (column >= 26 - (row14/2))) || ((column <= 22 + (row14/2)) && (column >= 22 - (row14/2))) || ((column <= 10 + (row14/2)) && (column >= 10 - (row14/2))) || ((column <= 6 + (row14/2)) && (column >= 6 - (row14/2)))) && ((row <= 6) && (row > 4))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 60 + (row15/2)) && (column >= 60 - (row15/2))) || ((column <= 52 + (row15/2)) && (column >= 52 - (row15/2))) || ((column <= 44 + (row15/2)) && (column >= 44 - (row15/2))) || ((column <= 36 + (row15/2)) && (column >= 36 - (row15/2)))) && ((row <= 4) && (row > 2))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 28 + (row15/2)) && (column >= 28 - (row15/2))) || ((column <= 20 + (row15/2)) && (column >= 20 - (row15/2))) || ((column <= 12 + (row15/2)) && (column >= 12 - (row15/2))) || ((column <= 4 + (row15/2)) && (column >= 4 - (row15/2)))) && ((row <= 4) && (row > 2))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 62 + (row16/2)) && (column >= 62 - (row16/2))) || ((column <= 58 + (row16/2)) && (column >= 58 - (row16/2))) || ((column <= 54 + (row16/2)) && (column >= 54 - (row16/2))) || ((column <= 50 + (row16/2)) && (column >= 50 - (row16/2)))) && ((row <= 2) && (row > 0))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 46 + (row16/2)) && (column >= 46 - (row16/2))) || ((column <= 42 + (row16/2)) && (column >= 42 - (row16/2))) || ((column <= 38 + (row16/2)) && (column >= 38 - (row16/2))) || ((column <= 34 + (row16/2)) && (column >= 34 - (row16/2)))) && ((row <= 2) && (row > 0))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 30 + (row16/2)) && (column >= 30 - (row16/2))) || ((column <= 26 + (row16/2)) && (column >= 26 - (row16/2))) || ((column <= 22 + (row16/2)) && (column >= 22 - (row16/2))) || ((column <= 18 + (row16/2)) && (column >= 18 - (row16/2)))) && ((row <= 2) && (row > 0))) {
            printf("1");
            column--;
            makeTriangle();
        }
        else if ((((column <= 14 + (row16/2)) && (column >= 14 - (row16/2))) || ((column <= 10 + (row16/2)) && (column >= 10 - (row16/2))) || ((column <= 6 + (row16/2)) && (column >= 6 - (row16/2))) || ((column <= 2 + (row16/2)) && (column >= 2 - (row16/2)))) && ((row <= 2) && (row > 0))) {
            printf("1");
            column--;
            makeTriangle();
        }

        else if (column != 0){
            printf("_");
            column--;
            makeTriangle();
        }
        if (column == 0) {
            row--;
            printf("\n");
            column = 63;
            row1 += 2;
            if ((row < 30) && (row >= 28)) {
                row2 += 2;
            }
            else if ((row < 28) && (row >= 26)){
                row3 += 2;
            }
            else if ((row < 26) && (row >= 24)) {
                row4 += 2;
            }
            else if ((row < 24) && (row >= 22)) {
                row5 += 2;
            }
            else if ((row < 22) && (row >= 20)) {
                row6 += 2;
            }
            else if ((row < 20) && (row >= 18)) {
                row7 += 2;
            }
            else if ((row < 18) && (row >= 16)) {
                row8 += 2;
            }
            else if ((row < 16) && (row >= 14)){
                row9 += 2;
            }
            else if ((row < 14) && (row >= 12)) {
                row10 += 2;
            }
            else if ((row < 12) && (row >= 10)) {
                row11 += 2;
            }
            else if ((row < 10) && (row >= 8)) {
                row12 += 2;
            }
            else if ((row < 8) && (row >= 6)) {
                row13 += 2;
            }
            else if ((row < 6) && (row >= 4)) {
                row14 += 2;
            }
            else if ((row < 4) && (row >= 2)) {
                row15 += 2;
            }
            else if ((row < 2) && (row >= 0)) {
                row16 += 2;
            }
            makeTriangle();
    }
    else if (row != 0) {
        makeTriangle();
        }
        }

    }

