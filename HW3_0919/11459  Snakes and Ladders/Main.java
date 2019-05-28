import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();

		for (int t = 0; t < testCases; t++) {

			int numPlayers = in.nextInt();
			int numJumps = in.nextInt();
			int numRolls = in.nextInt(); 

			int[] players = new int[numPlayers]; 
			Arrays.fill(players,1);
			int[] myJumps = new int[101];
			Arrays.fill(myJumps,-1);

			
			for (int j = 0; j < numJumps; j++) {
				int bottom = in.nextInt();
				int top = in.nextInt(); 
				myJumps[bottom] = top;
			}
			
			int rollNum = 1;
			boolean gameNotOver = true;
			do {

				for (int p = 0; (p < numPlayers); p++) {
				
					if (rollNum <= numRolls) {
						int roll = in.nextInt(); 
						if (gameNotOver) {players[p] += roll;}
						if ((players[p] != 100) && (myJumps[players[p]] != -1)) {players[p] = myJumps[players[p]];}
						if (players[p] > 100) {players[p] = 100;}
						if (players[p] == 100) {gameNotOver = false;}
					}
					rollNum++;
				}

			} while (rollNum <= numRolls);

			for (int r = 0; r < numPlayers; r++) {
				System.out.println("Position of player " + (r+1) + " is " + players[r] + ".");
			}
		}
	}
}