import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.management.MemoryType;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> negative = new PriorityQueue<>();
		int sum = 0;
		int zeroCnt = 0;

		for (int i = 0 ; i < n ; i++) {
			int elem = Integer.parseInt(br.readLine());

			if (elem > 0) {
				positive.add(elem);
			}
			else if (elem == 0) {
				zeroCnt++;
			}
			else {
				negative.add(elem);
			}
		}

		while (negative.size() >= 2) {
			int a = negative.poll();
			int b = negative.poll();
			sum += a * b;
		}

		while (positive.size() >= 2) {
			int a = positive.poll();
			int b = positive.poll();

			if (a + b < a * b) {
				sum += a * b;
			}
			else {
				sum += a + b;
			}
		}

		if (!negative.isEmpty()) {
			if (zeroCnt == 0) {
				sum += negative.poll();
			}
		}

		if (!positive.isEmpty()) {
			sum += positive.poll();
		}
		System.out.println(sum);



	}
}