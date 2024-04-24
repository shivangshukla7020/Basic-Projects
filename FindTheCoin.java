import java.util.Random;
import java.util.Scanner;

public class FindTheCoin {

    static String[] board = new String[64];
    static int[] coin = new int[20];
    static int moves;
    static int coinsRemain; 

    public static void main(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("\n\n=====================================================================================================================================================================================");
            System.out.println("======================================================================================================================================================================================");

            System.out.println("\n------------------------------------------------------------------------------->   START THE GAME ?  <------------------------------------------------------------------------------\n");

            System.out.println("=======================================================================================================================================================================================");
            System.out.println("=======================================================================================================================================================================================");
            System.out.print("\n(y/n)");
            char input = sc.next().charAt(0);

            System.out.print("\033[H\033[2J");
            System.out.flush();


            if(input == 'n') break;
            else {
                coinsRemain = 20;
                resetBoard();
                createCoin();
                moves = 0;
                int players = player();
                int[] score = new int[players];

                int counter = 0;

                while(moves < 64){

                    System.out.println("Coins Left = " + coinsRemain);
                  
                    displayBoard();
                    System.out.println();
                    for(int i = 0; i < players; i++){
                        System.out.print("Player " + (i+1) + " Score " + score[i] + "      ");

                    }
                    System.out.println("\n");
                    System.out.println("        Player No " + (counter+1) + " Enter the position : ");
                    int pos = sc.nextInt();
                    int k = checkBoard(pos);
                    while(k == -1) {
                        System.out.println(" Wrong Position Please Enter again : ");
                        pos = sc.nextInt();
                        k = checkBoard(pos);
                    }
                    openCell(pos,k);
                    if(k == 0){
                        score[counter]++;
                    }
                    if(checkWin(score)){
                        break;
                    }
                    if(counter == players-1){
                        counter = 0;
                    }
                    else counter++;

                    System.out.print("\033[H\033[2J");
                    System.out.flush();



                }
                if(checkWin(score)){
                    System.out.println("Player " + (counter+1) + " WINS !!");
                }
                System.out.println("------>  GAME OVER  <-------- ");
            }

            sc.close();
        }

    }



    static void displayBoard(){
        System.out.println("-------------------------------------------------------------------------");
        //System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        for(int i = 0; i < 64; i+=8){
            System.out.println("|        |        |        |        |        |        |        |        |");
            System.out.println("|   " + board[i] + "   |   " + board[i+1] + "   |   " + board[i + 2] + "   |   " + board[i+3] + "   |   " + board[i+4] + "   |   " + board[i+5] + "   |   " + board[i + 6]  + "   |   " + board[i + 7] + "   |");
            System.out.println("|        |        |        |        |        |        |        |        |");
            //System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            System.out.println("-------------------------------------------------------------------------");
        }

    }

    static void resetBoard(){
        for(int i = 0; i < 64 ;i++ ){
            if(i<=8){
                board[i]= i+1+ " ";
            }
            else {
                board[i] = i + 1 + "";
            }
        }
    }

    static void openCell(int idx, int res){
        if(res == 0){
            board[idx-1] = "$$";
        }
        else{
            board[idx-1] = "!!";
        }
    }

    static void createCoin(){
        Random r = new Random();
        int i = 0;
        while(i < 20){
            int n = r.nextInt(1,65);
            boolean f = true;
            for(int k = 0; k <= i; k++){
                if(n == coin[k]){
                    f = false;
                    break;
                }
            }
            if(f){
                coin[i] = n;
                i++;
            }

        }
        //System.out.println(Arrays.toString(coin));  To check the position of coins
    }

    static int checkBoard(int num){
        if(num > 64 || board[num-1].equals("$$") || board[num-1].equals("!!")) return -1;
        else{
            for (int i = 0; i < 8; i++) {
                
                if (num == coin[i]){
                    coinsRemain--;
                    return 0;
                } 
            }
        }
    return 1;
    }

    static int player(){
        System.out.println("Enter the number of players  (MAX 4)");
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        while(p > 4){
          System.out.println("Only 4 players are allowed Please Re-Enter : ");
          p = sc.nextInt();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return p;
        
    }

    static boolean checkWin(int[] players){
        for(int i = 0; i < players.length; i++){
            if(players[i] == 3) return true;
        }

        return false;
    }


}
