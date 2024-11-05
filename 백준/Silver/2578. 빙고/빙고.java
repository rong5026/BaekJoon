
import java.io.*;
import java.util.Scanner;

public class Main {
	private static int map[][];

	private static void insertValue(int elem) {
		for (int i = 0 ; i < 5 ; i++) {
			for (int j = 0 ; j < 5 ; j++) {
				if (map[i][j] == elem) {
					map[i][j] = -1; // 입력된 값 0으로 마킹 처리
					return;
				}
			}
		}
	}
	private static boolean checkBingGo() {
		int bingGoCount = 0;

		int leftToRight = 0;
		int rightToLeft = 0;
		int rowCount = 0;
		int colCount = 0;

		for (int i = 0 ; i < 5 ; i++) {
			rowCount = 0;
			colCount = 0;
			for (int j = 0 ; j < 5 ; j++) {
				rowCount += map[i][j];
				colCount += map[j][i];

				if (i == j) {
					leftToRight += map[i][j];
				}
				if (j == 4 - i) {
					rightToLeft += map[i][j];
				}
			}
			if (rowCount == -5)
				bingGoCount++;
			if (colCount == -5)
				bingGoCount++;
			if (leftToRight == -5)
				bingGoCount++;
			if (rightToLeft == -5)
				bingGoCount++;
		}

		if (bingGoCount >= 3)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		map = new int[5][5];

		// 입력
		for (int i = 0 ; i < 5 ; i++) {
			for (int j = 0 ; j < 5 ; j++) {
				map[i][j] = input.nextInt();
			}
		}

		for (int i = 0 ; i < 5 ; i++) {
			for (int j = 0 ; j < 5; j++) {
				int elem = input.nextInt();
				insertValue(elem);
				if(checkBingGo()) {
					System.out.println(5 * i + j + 1);
					return;
				}
			}
		}

	}
}



