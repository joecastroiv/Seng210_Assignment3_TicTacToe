import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


public class TicTacToe {

	static ArrayList<Integer> userSpot = new ArrayList<Integer>();    
    static ArrayList<Integer> comSpots = new ArrayList<Integer>();
    static int playerWinCount = 0;
	static int computerWinCount = 0;
     
    public static void main (String [] args) {
    Scanner scan = new Scanner (System.in);
   
        System.out.println("Welcome to 3x3 Tic Tac Toe"); //added for commit #1
        
        System.out.println("What is your player name: ?"); //added for commit #3
        String playerName = scan.next();
        
        
        char[][] board = {{' ', '|', ' ', '|', ' '}, 
                    	{'-', '-', '-', '-', '-'},
                    	{' ', '|', ' ', '|', ' '},
                    	{'-', '-', '-', '-', '-'},
                    	{' ', '|', ' ', '|', ' '}};
         
        printBoard(board);
        
        System.out.println("Lets begin " + playerName + " ,you will play first. Enter a slot number to place X in: "); //added for commit #2
     
        //Player input
        while(true) {
            System.out.println("Enter numbers between 1 through 9 to move!");
            int userPosition = scan.nextInt();
            while(userSpot.contains(userPosition) || comSpots.contains(userSpot) || comSpots.contains(userPosition)){
                System.out.println("Spot is filled, enter new area to move:");
                userPosition = scan.nextInt();
                
                //No overlap
                while(userSpot.contains(userPosition) || comSpots.contains(userPosition)){
                    System.out.println("Spot is filled, enter new area to move:");
                    userPosition= scan.nextInt();
                }
            }
         
            placePiece(board, userPosition, "player");
             
            String result = checkVictory();
            if(result.length() > 0) {
                System.out.println(result);
                break;            
            }
            //Computer input
            Random rand = new Random();
            int comPosition = rand.nextInt(9) + 1;
            while(userSpot.contains(comPosition) || comSpots.contains(comPosition)){
                comPosition = rand.nextInt(9) + 1;
            }
             
            placePiece(board, comPosition, "com");
         
            printBoard(board);
            
            //Victory results
            result = checkVictory();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
        }
        
        
 
          }
    public static void placePiece(char[][] board, int spot, String user){
         
        char piece = ' ';
        
        //Player=X
        if(user.equals("player")){
            piece = 'X';
            userSpot.add(spot);
        } 
        //Computer=O
        else if(user.equals("com")){
            piece = 'O';
            comSpots.add(spot);
        }
        
        //Board input
        switch(spot){
            case 1:
                board[0][0] = piece;
                break;
                
            case 2:
                board[0][2] = piece;
                break;
                
            case 3:
                board[0][4] = piece;
                break;
                
            case 4:
                board[2][0] = piece;
                break;
                
            case 5:
                board[2][2] = piece;
                break;
                
            case 6:
                board[2][4] = piece;
                break;
                
            case 7:
                board[4][0] = piece;
                break;
                
            case 8:
                board[4][2] = piece;
                break;
                
            case 9:
                board[4][4] = piece;
                break;    
                
            default:
                break;
        }
    }
    
    //Victory options
    public static String checkVictory(){        
        List horizontal1 = Arrays.asList(1, 2, 3);
        List horizontal2 = Arrays.asList(4, 5, 6);
        List horizontal3 = Arrays.asList(7, 8, 9);
        List column1 = Arrays.asList(1, 4, 7);
        List column2 = Arrays.asList(2, 5, 8);
        List column3 = Arrays.asList(3, 6, 9);
        List diagonal1 = Arrays.asList(1, 5, 9);
        List diagonal2 = Arrays.asList(7, 5, 3);
        
        //Victory categories
        List<List> winning = new ArrayList<List>();
        winning.add(horizontal1);
        winning.add(horizontal2);
        winning.add(horizontal3);
        winning.add(column1);
        winning.add(column2);
        winning.add(column3);
        winning.add(diagonal1);
        winning.add(diagonal2);
         
        for(List l : winning){
            if(userSpot.containsAll(l)){
            	playerWinCount++; //commit #4 keep track of player wins, printout and increment
            	System.out.println("The player has won " + playerWinCount + " time(s)");
                return "V-I-C-T-O-R-Y!, yay you....";  //commit for remote repos test
            } 
            else if(comSpots.containsAll(l)){
            	computerWinCount++; //commit #5 keep track of computer wins, printout and increment
            	System.out.println("The computer has won " + computerWinCount + " time(s)");
                return "Computer wins, you failed!";
            } 
            else if(userSpot.size() + comSpots.size() == 9){
                return "Draw!";
            }
       
        }
        return "";       
    }
    
    public static void printBoard (char [][] board){ 
        for(char[] row : board) {
            for(char c : row) {
                System.out.print(c);              
            }
            System.out.println();
        }
    }
    
}

