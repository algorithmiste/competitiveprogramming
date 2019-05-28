import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			int numVessels = in.nextInt();
			int numBlocks = in.nextInt(); 
			int[] vessels = new int[numVessels];

			int min = 0;
			int max = 0;

			for (int i = 0; i < numVessels; i++) {
				vessels[i] = in.nextInt();
				if (vessels[i] > min) {min = vessels[i];}
				max += vessels[i];
			}

			// ArrayList<Integer> blocks;
			int l = min, u = max;
			while (l < u) {
				int mid = (l + u)/2;

				int curContainer = 1, curSum = 0;
				for (int i = 0; i < numVessels; ++i) {
					curSum += vessels[i];
					if (curSum > mid) {
						curContainer++;
						if (curContainer > numBlocks) {break;}
						curSum = vessels[i];
					}
				}
				// int vIndex = 0;
				// int mid = (min + max) / 2;
				// blocks = new ArrayList<>(numVessels);
				// for (int b = 0; b < numVessels; b++) { 
				// 	int sumAtIndexB = 0;
				// 	blocks.add(b, 0);
				// 	int bValue = blocks.get(b);
				// 	while (bValue <= mid) { 
				// 		if (((bValue + vessels.get(vIndex)) <= mid) && (vIndex < numVessels -1 )) {
				// 			sumAtIndexB += vessels.get(vIndex);
				// 			blocks.set(b,sumAtIndexB);
				// 			vIndex++; 
				// 		}
				// 		else {break;}
				// 	}
				// 	if (vIndex == numVessels - 1) {break;}
				// }
				// int blockIndex = 0;
				// int bCount = blocks.size();
				if (curContainer > numBlocks) { 
					l = mid +1; 
				}
				else {
					u = mid;
				}
			}
			System.out.println(u); 
		}
		// return;
	}
}