
public class ProgramTest {
	static char [][] board = new char[5][5];
	
	public static void printBoard() {
	System.out.println("Im Starting to print board test");
	for (int i=0; i < 5; i++) {
	    for(int j=0; j < 5; j++) {
	    	System.out.print(board[i][j]);
	    }
	}
	}
	
	public static void main (String [] args) {
	
	
	System.out.println("Lets Begin Test");
	 
	 printBoard();
	 
	 TicTacToe.placePiece(board, 3, "player");
	 if(board[0][4] != 'X') {
		 System.out.println("   Failed input player spot");
	 }

	 printBoard();
	 
	 TicTacToe.placePiece(board, 1, "com");
	 if(board[0][0] != 'O') {
		 System.out.println("   Failed input com spot");
	 }
	 
	 printBoard();
	
	 TicTacToe.placePiece(board, 9, "player");
	 if(board[4][4] != 'X') {
		 System.out.println("   Failed input player spot");
	 }
	 
	 printBoard();
	 
	 TicTacToe.placePiece(board, 7, "com");
	 if(board[4][0] != 'O') {
		 System.out.println("   Failed input com spot");
	 }
	 
	 printBoard();
	 
	 System.out.println("End Of Test");
	  
	
	}
	
	

	
}

