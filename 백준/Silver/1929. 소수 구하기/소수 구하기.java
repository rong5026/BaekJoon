
import java.io.*;
import java.util.Scanner;

public class Main {

	private static boolean isPrime(int n) {
		if (n < 2)
			return false;

		for (int i = 2 ; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();

		boolean[] array = new boolean[m + 1];
		for (int i = 2 ; i <= Math.sqrt(m) ; i++) {
			if (array[i])
				continue;
			for (int j = i + i ; j <= m ; j = j + i ) {
				array[j] = true;
			}
		}

		for (int i = n; i <= m ; i++) {
			if (!array[i] && i > 1) {
				System.out.println(i);
			}
		}



	}
}
