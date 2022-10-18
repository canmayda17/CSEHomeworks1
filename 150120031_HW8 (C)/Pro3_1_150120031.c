// Sukru Can Mayda - 150120031
// The purpose of this program is to calculate bunny ears by line numbers
#include <stdio.h>
#include <stdlib.h>

int lineNumber = 1;
int totalEars = 0;

int main()
{
	
    int n;
    printf("Please enter the number of lines ");
    // Get the number
    scanf("%d", &n);

    
    printf("bunnyEars0(0) -> 0\n");
    calculateBunnyEars(n);



    return 0;
}

// Calculate bunny ears with the given number
void calculateBunnyEars(int n){
    if (lineNumber % 2 == 0) {
        totalEars +=3;
        printf("bunnyEars%d(%d) -> %d\n", lineNumber,lineNumber,totalEars);
        lineNumber++;
    }
    else {
        totalEars +=2;
        printf("bunnyEars%d(%d) -> %d\n", lineNumber,lineNumber,totalEars);
        lineNumber++;
    }

    if(lineNumber <= n){

        calculateBunnyEars(n);
    }
}

