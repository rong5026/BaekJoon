
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1 ; i <= n ; i++) {
			queue.add(i);
		}

		int i = 1;

		while (queue.size() != 1) {

			if (i % 2 == 1) {
				queue.poll();
			}
			else {
				int elem = queue.poll();
				queue.add(elem);
			}
			i++;
		}
		System.out.println(queue.peek());
	}
}



