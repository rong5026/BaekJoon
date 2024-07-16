import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	private static boolean isPrime(int num) {
		if (num == 1)
			return false;
		for (int i = 2 ; i <= Math.sqrt(num) ; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	private static boolean checkPerim(int num) {
		char array[] = String.valueOf(num).toCharArray();

		for (int i = 0 ; i < array.length / 2 ; i++) {
			if (array[i] != array[array.length -1 -i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();

		while(true) {
			if (checkPerim(n) && isPrime(n))
				break;
			else
				n++;
		}
		System.out.println(n);

	}
}