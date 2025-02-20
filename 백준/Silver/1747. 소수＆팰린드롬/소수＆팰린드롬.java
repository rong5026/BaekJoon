
import java.io.*;
import java.util.Scanner;

public class Main {

	private static boolean isPrime(int n) {
		if (n < 2)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	private static boolean isPerindrum(int n) {

		char[] array = String.valueOf(n).toCharArray();
		for (int i = 0 ; i < array.length / 2 ; i++) {
			if (array[i] != array[array.length - 1 - i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		boolean[] input = new boolean[10000001];
		input[1] = true;
		for (int i = 2 ; i < Math.sqrt(input.length) ; i++) {
			if (input[i])
				continue;
			for (int j = i + i ; j < input.length; j += i ) {
				input[j] = true;
			}
		}

		while (true) {
			if (isPerindrum(n) && !input[n]) {
				System.out.println(n);
				break;
			}
			n++;
		}

	}
}
