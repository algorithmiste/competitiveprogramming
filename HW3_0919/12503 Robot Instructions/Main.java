import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int testCases = in.nextInt();
		in.nextLine();

		for (int i = 0; i < testCases; i++) {
			int p = 0;
			int numInstructions = in.nextInt();
			in.nextLine();
			int[] historical = new int[numInstructions];

			for (int j = 0; j < numInstructions; j++) {

				String instruction = in.nextLine();

				if (instruction.contains("LEFT")) {
					p--;
					historical[j] = -1;
				}
				else if (instruction.contains("RIGHT")) {
					p++;
					historical[j] = 1;
				}
				else if (instruction.contains("SAME AS")) {
					String[] instr = instruction.split(" ");
					int sameAs = Integer.parseInt(instr[2]);
					
					p += historical[sameAs-1];
					historical[j] = historical[sameAs-1];	
				}
			}
			System.out.println(p);
		}
		return;

	}
}