// This program prints the best path for someone who wants to get from one point to another point

// Şükrü Can Mayda - 150120031

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#define SIZE 10

// struct for MetroStation
typedef struct MetroStation{
    char name[20];
    double x;
    double y;

}MetroStation;

// struct for MetroLine
typedef struct MetroLine{
    char color[20];
    MetroStation MetroStations[SIZE];

}MetroLine;

// struct fot MetroSystem
typedef struct MetroSystem{
    char name[20];
    MetroLine MetroLines[SIZE];

}MetroSystem;

// This is from sample main to initialize metroSystem
MetroSystem istanbul = {"istanbul", '\0'};

// Checks if the name s1 is equal to s2
int equals(MetroStation s1, MetroStation s2){
    if (strcmp(s1.name,s2.name) == 0) {
        return 1;
    }
    else
        return 0;
}

// Adds station to metro line
void addStation(MetroLine *mL, MetroStation ms){
	int i = 0;
    for (i = 0; i<SIZE; i++) {
            if (!strcmp(mL->MetroStations[i].name, "\0")){
                    mL->MetroStations[i]= ms;
                break;
            }
    }
}

// Checks if mL has station named as mS
int hasStation(MetroLine mL, MetroStation mS){
	int i = 0;
    for (i = 0; i<SIZE; i++) {
        if (strcmp(mL.MetroStations[i].name,mS.name)) {
            return 1;
        }
    }
    return 0;
}

// Gets first stop
MetroStation getFirstStop(MetroLine mL){
    return mL.MetroStations[0];
}

// Gets previous station
MetroStation getPreviousStop(MetroLine mL, MetroStation mS){
	int i = 0;
    int temp = 0;
    for (i = 0; i<SIZE; i++) {
        if (strcmp(mL.MetroStations[i].name, mS.name) == 0) {
            temp = i - 1;
            break;
        }
    }
    return mL.MetroStations[temp];
}

// Gets next station
MetroStation getNextStop(MetroLine mL, MetroStation mS) {
	int i = 0;
    int temp = 0;
    for (i= 0; i<SIZE; i++) {
        if (strcmp(mL.MetroStations[i].name, mS.name) == 0) {
            temp = i + 1;
            break;
        }
    }
    return mL.MetroStations[temp];
}

// Adds line mL to metroSystem
void addLine(MetroSystem *metroSystem, MetroLine mL) {
	int i = 0;
    for (i= 0; i<SIZE; i++) {
    	if (strcmp(metroSystem->MetroLines[i].color,"\0") == 0) {
		metroSystem->MetroLines[i] = mL;
		break;
		}
    }
}

// Prints line number and stations
void printLine(MetroLine mL) {
	int i = 0;
    printf("Metroline %s: ", mL.color);
    for (i = 0; i < SIZE; i++) {
        if(mL.MetroStations[i].name[0] != '\0') {
            if (i == 0) {
            printf("%s", mL.MetroStations[i].name);
        }
        else {
            printf(", %s", mL.MetroStations[i].name);
        }
    }

    }
    printf(".\n");

}

// Prints path
void printPath(MetroStation MetroStations[]){
	int i = 0;
    for (i = 0; i < SIZE; i++){
        if(strcmp(MetroStations[i].name, "") != 0)
        printf("%d. %s\n",(i+1),MetroStations[i].name);
    }
}

// Gets total distance travelled
double getDistanceTravelled(MetroStation *myPath){
	int i = 0;
    double totalDistance = 0;
    if (sizeof(myPath) <= 2) {
        return 0.0;
    }
    if(strcmp(myPath[1].name, "\0") == 0) {
			return 0;
		}
    for (i = 0; i < sizeof(myPath); i++){
        totalDistance += sqrt(pow(myPath[i].x , 2) + pow(myPath[i].y , 2));
    }
    return totalDistance;

}



// Finds nearest station to mS with x and y
MetroStation findNearestStation (MetroSystem mS, double x, double y)
{ //finds and returns the closest metro station base on given x and y values.
   double distance;
   double temp;
   double tempX = 0;
   double tempY = 0;

   int i,j;

   MetroStation nextStation;
   MetroStation nearestStation;
   distance = sqrt(pow(getFirstStop(mS.MetroLines[0]).x - x, 2) + pow(getFirstStop(mS.MetroLines[0]).y - y, 2));
   nearestStation = getFirstStop(mS.MetroLines[0]);

   for (i = 0; i < SIZE; i++)
   {
       for (j = 0; j < SIZE; j++)
       {
           nextStation = mS.MetroLines[i].MetroStations[j];
           tempX = nextStation.x;
           tempX -= x;
           tempY = nextStation.y;
           tempY -= y;

           temp = sqrt(tempX*tempX + tempY*tempY);
           if (strcmp(nextStation.name, "\0"))
           {
               if (temp < distance){
                //if current distance smaller than previous one, update previous one to new distance.
                   distance = temp;
                   nearestStation = nextStation;
               }
           }
           else{
        break;
           }
       }
   }
   return nearestStation;
}

// This is a function that I wrote because it makes easier for further problems
// and checks if the ms1 array has ms 2 station
int contains(MetroStation *ms1, MetroStation ms2)
{
   int i;
   for (i = 0; i < strlen(ms1[i].name) != 0; i++)
   {
       if (!strcmp(ms1[i].name, ms2.name))
       {
           return 1;
       }
   }
   return 0;
}

// This is another function that I wrote. It compares distances partialPath
// and bestPath. After that it returns which is smallest.
int compareDistance(MetroStation partialPath[], MetroStation bestPath[])
{
    int result = 0;
    if(strcmp(bestPath[0].name, "") == 0) {
        result = 1;
        return result;
    }
    else {
        if(getDistanceTravelled(partialPath) < getDistanceTravelled(bestPath)) {
            result = 1;
            return result;
        }
    }
    return result;
}

// Gets neighbor stations for given metroStation
void getNeighboringStations (MetroSystem metroSystem, MetroStation metroStation, MetroStation *neighboringStations){
    int temp = 0, i = 0, j = 0;
    for (i = 0; strcmp(metroSystem.MetroLines[i].color, "\0"); i++){
        for (j = 0; strcmp(metroSystem.MetroLines[i].MetroStations[j].name, "\0"); j++){
            if (!strcmp(metroStation.name, metroSystem.MetroLines[i].MetroStations[j].name)){
                    if (j > 0){
                        if(!contains(neighboringStations, metroSystem.MetroLines[i].MetroStations[j-1])) {
                            neighboringStations[temp++] = metroSystem.MetroLines[i].MetroStations[j-1];
                        }
                    if(!contains(neighboringStations, metroSystem.MetroLines[i].MetroStations[j+1])) {
                        neighboringStations[temp++] = metroSystem.MetroLines[i].MetroStations[j+1];
                    }

                    }
                    else{
                    neighboringStations[temp++] = metroSystem.MetroLines[i].MetroStations[j+1];
                    }
            }
        }
    }
}

// Finds the best path for every possibility and recursively
void recursiveFindPath (MetroStation start, MetroStation finish, MetroStation *partialPath, MetroStation *bestPath){
	int i, j, k;
    for (i = 0; i < SIZE; i++){
        if (equals(partialPath[i], start))
           return;
        }
    if(equals(start,finish)){

        for (i = 0; i < SIZE; i++){
           if (strlen(partialPath[i].name) < 5)
           {

               partialPath[i] = finish;
               break;
           }
       }
        if(compareDistance(partialPath, bestPath)) {
            for(i = 0; i < SIZE; i++){
            bestPath[i] = partialPath[i];
        }
        return;
        }

    }

    MetroStation neighbors[SIZE]= {'\0'};
    getNeighboringStations(istanbul,start,neighbors);

    for (i = 0; i < SIZE; i++){
        MetroStation duplicatePath[SIZE]= {'\0'};
        for(k = 0; k < SIZE; k++) {
            duplicatePath[k] = partialPath[k];
        }
        for(j = 0; j < SIZE; j++){
        if(strcmp(duplicatePath[j].name,"\0") == 0){
            duplicatePath[j] = start;
            break;
        }

        }
        recursiveFindPath(neighbors[i], finish, duplicatePath, bestPath);
    }


}

// This function only constructs partialPath and calls recursiveFindPath
void findPath (MetroStation start, MetroStation finish, MetroStation *path){
    MetroStation partialPath[SIZE] = {'\0'};


   recursiveFindPath(start, finish, partialPath, path);
}


// This is the simple main
int main()
{
    int i;
	double myX=1, myY=2;
	double goalX=60, goalY=45;

	// define 3 metro lines, 9 metro stations, and an empty myPath
	MetroLine red={'\0'}, blue={'\0'}, green={'\0'};
	MetroStation s1, s2, s3, s4, s5, s6, s7, s8, s9;
	MetroStation myPath[SIZE]={'\0'};

	strcpy(red.color, "red");
	strcpy(blue.color, "blue");
	strcpy(green.color, "green");


	strcpy(s1.name, "Haydarpasa"); 		s1.x=0; 	s1.y=0;
	strcpy(s2.name, "Sogutlucesme"); 	s2.x=10; 	s2.y=5;
	strcpy(s3.name, "Goztepe"); 		s3.x=20; 	s3.y=10;
	strcpy(s4.name, "Kozyatagi"); 		s4.x=30; 	s4.y=35;
	strcpy(s5.name, "Bostanci"); 		s5.x=45; 	s5.y=20;
	strcpy(s6.name, "Kartal"); 			s6.x=55; 	s6.y=20;
	strcpy(s7.name, "Samandira"); 		s7.x=60; 	s7.y=40;
	strcpy(s8.name, "Icmeler"); 		s8.x=70; 	s8.y=15;

	//Add several metro stations to the given metro lines.
	addStation(&red, s1); addStation(&red, s2); addStation(&red, s3); addStation(&red, s4); addStation(&red, s5); addStation(&red, s8);

	addStation(&blue, s2); addStation(&blue, s3); addStation(&blue, s4); addStation(&blue, s6); addStation(&blue, s7);

	addStation(&green, s2); addStation(&green, s3); addStation(&green, s5); addStation(&green, s6); addStation(&green, s8);

	// Add red, blue, green metro lines to the Istanbul metro system.
	addLine(&istanbul, red);
	addLine(&istanbul, blue);
	addLine(&istanbul, green);

	// print the content of the red, blue, green metro lines
	printLine(red);
	printLine(blue);
	printLine(green);


	// find the nearest stations to the current and target locations
	MetroStation nearMe = findNearestStation(istanbul, myX, myY);
	MetroStation nearGoal = findNearestStation(istanbul, goalX, goalY);

	printf("\n");

	printf("The best path from %s to %s is:\n", nearMe.name, nearGoal.name);

	// if the nearest current and target stations are the same, then print a message and exit.
	if(equals(nearMe, nearGoal)){
		printf("It is better to walk!\n");
		return 0;
	}

	// Calculate and print the myPath with the minimum distance travelled from start to target stations.
	findPath(nearMe, nearGoal, myPath);

	if(strlen(myPath[0].name) == 0)
		printf("There is no path on the metro!\n");
	else{
		printPath(myPath);
	}

	return 0;
}




