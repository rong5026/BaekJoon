import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.management.MemoryType;
import java.util.*;


public class Main {

	private static boolean check(int mid, int n, int m) {
		int count = 0;
		for (int i = 1 ; i <= n ; i++) {
			count += Math.min(mid / i, n);
		}
		return count < m;
	}
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();

		int start = 1;
		int last = m;
		int result = 0;

		while (start <= last) {
			int mid = (start + last) / 2;


			if (check(mid, n, m))
				start = mid + 1;
			else {
				result = mid;
				last = mid - 1;
			}
		}
		System.out.println(result);


	}
}