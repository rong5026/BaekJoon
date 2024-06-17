
import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		int cnt = 1;
		boolean flag = true;

		for (int i = 0 ; i < n ; i++){
			input[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0 ; i < n ; i++) {

			while (input[i] >= cnt) {
				stack.add(cnt);
				sb.append("+\n");
				cnt++;
			}

			int elem = stack.pop();
			if (elem != input[i]) {
				flag = false;
				System.out.println("NO");
				break;
			}
			sb.append("-\n");
		}

		if (flag) {
			System.out.println(sb.toString());
		}

	}
}
