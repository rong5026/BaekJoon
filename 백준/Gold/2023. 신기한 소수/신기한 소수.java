import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {
	private static boolean isPrime(int num) {
		for (int i = 2 ; i < num /2  ; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	private static void DFS(int num, int i, int n) {

		if (i == n) {
			System.out.println(num);
			return;
		}
		for (int j = 0 ; j <= 4 ; j++) {
			int elem = 2 * j + 1;
			if (isPrime(num * 10 + elem))
				DFS(num * 10 + elem, i + 1, n);
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();

		DFS(2, 1, n);
		DFS(3, 1, n);
		DFS(5, 1, n);
		DFS(7, 1, n);

	}
}