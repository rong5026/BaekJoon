import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

class hNode implements Comparable<hNode> {
	int index;
	int value;

	public hNode(int index, int value) {
		this.index = index;
		this.value = value;
	}
	@Override
	public int compareTo(hNode o) {
		return this.value - o.value;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		hNode inputArray[] = new hNode[n];

		for (int i = 0 ; i < n ; i++) {
			int elem = Integer.parseInt(br.readLine());

			inputArray[i] = new hNode(i, elem);
		}

		Arrays.sort(inputArray);

		int max = 0;

		for (int i = 0 ; i < n ; i++) {
			max = Math.max(max, inputArray[i].index - i);
		}

		System.out.println(max + 1);
	}
}
