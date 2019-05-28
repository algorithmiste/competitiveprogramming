import java.util.*;

public class Main{
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int numLadies = in.nextInt();
		in.nextLine();

		int[] lineArr = new int[numLadies];
		for (int k = 0; k < numLadies; k++) {
			lineArr[k] = in.nextInt();
		}
		int numQueries = in.nextInt();
		in.nextLine();

		// Loop through the queries
		for (int i = 0; i < numQueries; i++) { 

			int heightToMatch = in.nextInt(); 
			int left = 0;
			int right = numLadies - 1;
			boolean casser = false;

			while (left < right) {
				int mid = (left + right) / 2;
				if (heightToMatch < lineArr[mid]) {
					if ((mid - 1 >= 0) && (heightToMatch >  lineArr[mid - 1])) {
						System.out.println(lineArr[mid-1] + " " + lineArr[mid]);
						casser = true; break;
					}
					right = mid - 1;
				} 
				else if (heightToMatch > lineArr[mid]) {
					if ((mid + 1 <= numLadies - 1) && (heightToMatch < lineArr[mid + 1])) { 
						System.out.println(lineArr[mid] + " " + lineArr[mid+1]);
						casser = true; break;
					}
					left = mid + 1;	
				}
				else {
					// Case that heightToMatch == lineArr[mid]
					// We found match, so 1st we try to find tallestShorter
					for (int l = mid; l >= 0; l--) {
						if (lineArr[l] < heightToMatch) {
							System.out.print(lineArr[l] + " ");casser = true; break;  //casser = true;
						}
						else if (l == 0) {
							System.out.print("X "); casser = true; break; 
						}
					}
					// Then we try to find shortestTaller
					for (int u = mid; u <= numLadies - 1; u++) {
						if (lineArr[u] > heightToMatch) {
							System.out.print(lineArr[u]); 
							System.out.println(); break; // casser = true;
						}
						else if (u == numLadies - 1) {
							System.out.print("X"); 
							System.out.println(); break;
						}
					}
				}
				if (casser == true) {break;}
			}
			if (casser == false) {
				if (heightToMatch > lineArr[left]) {
					System.out.println(lineArr[left] + " X");
				}
				else if (heightToMatch < lineArr[left]) {
					System.out.println("X " + lineArr[left]);
				}
				else if (heightToMatch == lineArr[left]) {
					System.out.println("X X"); 
				}
			}
		}
		return;
	}

}