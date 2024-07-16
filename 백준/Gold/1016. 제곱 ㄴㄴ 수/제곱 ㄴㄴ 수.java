import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		long min = input.nextLong();
		long max = input.nextLong();
		boolean check[] = new boolean[(int)(max - min + 1)];
		long cnt = max - min + 1;

		for (long i = 2; i * i <= max ; i++) {
			long pow = i * i;
			long startValue = min / pow;

			if (min % pow != 0)
				startValue++;

			for (long j = startValue; j * pow <= max; j++) {
				int index = (int)(j * pow - min); // max의 범위가 min ≤ max ≤ min + 1,000,000 이므로
				if (!check[index]) {
					check[index] = true;
					cnt--;
				}
			}
		}
		System.out.println(cnt);



	}
}