// Problem 11942 Lumberjack Sequencing 

import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		int numLines = in.nextInt();
		in.nextLine();
			
		System.out.println("Lumberjacks:");

		for (int i = 0; i < numLines; i++) {
			String bString = in.nextLine();
			String[] beards = bString.split(" ");
			boolean inOrder = true;

			for (int j = 1; j < beards.length - 1; j++) {
				if (Integer.parseInt(beards[j]) < Integer.parseInt(beards[j+1])) { 
					if (j != 0) {
						if (Integer.parseInt(beards[j-1]) > Integer.parseInt(beards[j])) {
							System.out.println("Unordered");
							inOrder = false;
							break;
						}
						else {continue;}
					}
					else {continue;}
				}

				else if (Integer.parseInt(beards[j]) > Integer.parseInt(beards[j+1])){
					if (j != 0) {
						if (Integer.parseInt(beards[j-1]) < Integer.parseInt(beards[j])) {
							System.out.println("Unordered");
							inOrder = false;
							break;
						}
						else {continue;}
					}
					else {continue;}
				}
			}
			if (inOrder == true) 
				System.out.println("Ordered");
		
		}

	}

}