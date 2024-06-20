import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		int result[] = new int[n];

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0 ; i < n ; i++) {
			result[i] = -1;
			input[i] = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				stack.push(i);
			}
			else {
				while (!stack.isEmpty() && input[i] > input[stack.peek()]) {
					result[stack.pop()] = input[i];
				}
				stack.push(i);
			}
		}

		for (int i = 0 ; i < n ; i++) {
			sb.append(result[i] + " ");
		}

		System.out.println(sb.toString());
	}
}
