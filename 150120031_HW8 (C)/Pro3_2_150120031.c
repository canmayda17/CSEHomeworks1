// Sukru Can Mayda - 150120031
// The purpose of this program is to calculate the super digit of the given number. The calculation is total digit of the number.

#include <stdio.h>
#include <stdlib.h>

int number1;
int number2;
int number3;
int a=10;
int total=0;
int aClone=1;
int totalClone=0;

int main()
{
	//Get the numbers
    printf("Please enter a number (n=) : ");
    scanf("%d", &number1);
    printf("Please enter repetition factor (k=) : ");
    scanf("%d", &number2);

    a=aClone;
    total=totalClone;
    calculateLastNumber(number1);
    calculateSuperDigit(number3);
    //Print the super digit of given number
    printf("Super digit of number is %d\n", total);

}

//Calculate super digit
void calculateSuperDigit(int n) {

    total += (n%a)/(a/10);
    n=n-(n%a);
    if (n >= 10) {
        a=a*10;
        calculateSuperDigit(n);

    }
    else if(total>=10){
        n=total;
        total=0;
        a=10;
        calculateSuperDigit(n);
    }

}

//Calculate last number
void calculateLastNumber(int n) {

    if (n > 0&&n<=number1) {
        n=(n-(n%a))/10;
        a=a*10;

        calculateLastNumber(n);

    }
    else if(number2>0){
        total+=number1;
        number1=number1*a;
        number2--;
        calculateLastNumber(n);
    }

}

