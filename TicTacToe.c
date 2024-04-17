#include<stdio.h>
#include<stdlib.h>

// Creating an array of Character to store mark (X,O) at given position
 char a[] = {'0','1','2','3','4','5','6','7','8','9'};

// function to reset the values in array
 void reset();

//Declaring Board function for creating the grid of game
 void board();

 //Declaring winner function for checking the winner
 int winner();

 //Declaring a function to check if the player can give input at that position.
 int checkPos();

int main(){
  //player value depends on the (player % 2) i:e 1 or 2
  //mark depends on the value of player either 1 or 2
   
int player = 1, pos, b,n; 
 char mark;  // X or O
  int count[4] = {0};

    //Do-while loop for taking input and checking the winner

    start :

    reset();
    
    do {

        board();
         player = (player % 2) ? 1:2;
         mark = (player % 2) ? 'X' : 'O' ;

         printf("\nPlayer %d, Enter your position : ",player);
         scanf("%d",&pos);

         while (pos < 1 || pos > 9 || checkPos(pos)){
         printf("\t\tInvalid Position\n");
         printf("\tPlayer %d, Enter your position : ",player);
         scanf("%d",&pos);
         }
         if(a[1] == '1' && pos == 1)
         a[1] = mark; 
         else if (a[2] == '2' && pos == 2)
         a[2] = mark;
         else if (a[3] == '3' && pos == 3)
         a[3] = mark;
         else if (a[4] == '4' && pos == 4)
         a[4] = mark;
         else if (a[5] == '5' && pos == 5)
         a[5] = mark;
         else if (a[6] == '6' && pos == 6)
         a[6] = mark;
         else if (a[7] == '7' && pos == 7)
         a[7] = mark;
         else if (a[8] == '8' && pos == 8)
         a[8] = mark;
        else if (a[9] == '9' && pos == 9)
         a[9] = mark;
   
b = winner();
 player--;

 system("cls");
 }
    
 while(b == -1); // Winner fnc() returns -1 to continue taking input
 player ++;
 board();
 if ( b == 1){
 count[player]++;
 printf("\n\t\t\t  Player %d Wins!!",player);
 printf("\t\t\t\tPlayer 1 score : %d\n",count[1]);
 printf("\t\t\t\t\t\t\t\t\tPlayer 2 score : %d",count[2]);


printf("\n\nEnter 1 to play again || enter 0 to exit : ");
scanf("%d",&n);

if(n == 1) goto start;
 } 
 else {
  printf("\t\tIt's a Draw");
  printf("Enter 1 to play again || enter 0 to exit : ");
   scanf("%d",&n);

    if(n == 1) 
goto start;
}
}



void board()
{
//Drawing the board

printf("\n\t\t\t    TIC TAC TOE\n\n");
printf("\t\tPlayer 1   (X)         Player 2   (O)\n\n");
printf("\t\t\t     |       |    \n");
printf("\t\t\t  %c  |   %c   |  %c \n",a[1],a[2],a[3]);
printf("\t\t\t_____|_______|_____\n");
printf("\t\t\t     |       |    \n");
printf("\t\t\t  %c  |   %c   |  %c \n",a[4],a[5],a[6]);
printf("\t\t\t_____|_______|_____\n");
printf("\t\t\t     |       |    \n");
printf("\t\t\t  %c  |   %c   |  %c \n",a[7],a[8],a[9]);
printf("\t\t\t     |       |     \n");
}

int winner(){
//Horizontal Win check
if (a[1] == a[2] && a[2] == a[3])
return 1;
else if (a[4] == a[5] && a[5] == a[6])
 return 1;
 else if(a[7] == a[8] && a[8] == a[9])
 return 1;

  //Vertical win check
 else if (a[1] == a[4] && a[4] == a[7])
 return 1;
 else if (a[2] == a[5] && a[5] == a[8])
 return 1;
 else if (a[3] == a[6] && a[6] == a[9])
 return 1;

//Diagonal win check 

else if (a[1] == a[5] && a[5] == a[9])
return 1;
else if (a[3] == a[5] && a[5] == a[7])
return 1;

 //Draw check
 else if (a[1] != '1' && a[2] != '2' && a[3] != '3' && a[4] != '4' && a[5] != '5' && a[6] != '6' && a[7] != '7' && a[8] !='8' && a[9] != '9')
 return 0;

 else return -1; //To continue taking the input
}
void reset(){
    a[1] = '1';
    a[2] = '2';
    a[3] = '3';
    a[4] = '4';
    a[5] = '5';
    a[6] = '6';
    a[7] = '7';
    a[8] = '8';
    a[9] = '9';
}

int checkPos(int pos){
    if(a[pos] == 'X' || a[pos] == 'O'){
      return 1;
    }
    else return 0;
}
