
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String []input = br.readLine().split("-");
		int total = 0;

		for (int i = 0; i < input.length; i++) {
			String []elems = input[i].split("\\+");
			int sum = 0;
			for (String elem : elems) {
				sum += Integer.valueOf(elem);
			}
			if (i != 0) {
				total -= sum;
			}
			else {
				total += sum;
			}
		}
		System.out.println(total);


	}
}
