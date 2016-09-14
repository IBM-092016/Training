package ttt;

public class Table {

	private String TicTacToeTable[] = { 
			 " ", "⚫", "⚪", 
			 " ", " ", " ", 
			 " ", " ", " " };
	
	public void drawTable() {
		System.out.println("    A   B   C");
		System.out.println("  \u2554\u2550\u2550\u2550\u2566\u2550\u2550\u2550\u2566\u2550\u2550\u2550\u2557");
		for (int i = 0; i < TicTacToeTable.length; i=i+3) {
			System.out.print((i/3+1) + " \u2551");
			System.out.print(" "+TicTacToeTable[i] + " \u2551 " + TicTacToeTable[i+1] + " \u2551 " + TicTacToeTable[i+2] + " \u2551");
			System.out.println("");
			if(i/3<2) {
				System.out.println("  \u2560\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2563");
			}else{
				System.out.println("  \u255A\u2550\u2550\u2550\u2569\u2550\u2550\u2550\u2569\u2550\u2550\u2550\u255D");
			}
		}

	}

}
