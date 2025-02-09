
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int n;

	private static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2 ; i <= Math.sqrt(num) ; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static void DFS(int elem, int jari) {
		if (jari == n) {
			if (isPrime(elem))
				System.out.println(elem);
			return;
		}

		for (int i = 1 ; i < 10 ; i += 2) {
			if (isPrime(elem)) {
				DFS(elem * 10 + i, jari + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		// 2, 3, 5, 7
		// 1, 3, 5, 7 반복

		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
	}
}
