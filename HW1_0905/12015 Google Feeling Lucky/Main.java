// Problem 12015 Google is Feeling Lucky

import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		in.nextLine();

		for (int i = 0; i < numCases; i++) {
			System.out.println("Case #" + (i+1) + ":");
			ArrayList<String> url = new ArrayList<>();

			String first = in.nextLine();
			String[] firstURL = first.split(" ");
			int highestRel = Integer.parseInt(firstURL[1]);
			url.add(firstURL[0]);

			for (int j = 1; j < 10; j++) {
				String line = in.nextLine();
				String[] urlRelevance = line.split(" ");

				if (Integer.parseInt(urlRelevance[1]) == highestRel)
					url.add(urlRelevance[0]);
				else if (Integer.parseInt(urlRelevance[1]) > highestRel) {
					url.clear();
					url.add(urlRelevance[0]);
					highestRel = Integer.parseInt(urlRelevance[1]);
				} 
			}
			for (int k = 0; k < url.size(); k++) {
				System.out.println(url.get(k));
			}
		}
	}
}