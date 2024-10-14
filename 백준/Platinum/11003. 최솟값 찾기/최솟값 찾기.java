
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

class hNode {
	int index, value;
	public hNode(int index, int value) {
		this.value =value;
		this.index = index;
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Deque<hNode> queue = new LinkedList<>();

		int input[] = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0 ; i < n ; i++) {

			while (!queue.isEmpty() && queue.getLast().value > input[i])
				queue.removeLast();

			queue.add(new hNode(i, input[i]));

			if (queue.getFirst().index <= i - m) {
				queue.removeFirst();
			}
			bw.write(queue.getFirst().value + " ");
		}

		bw.flush();
		bw.close();
	}
}



