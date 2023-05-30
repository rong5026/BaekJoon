import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n;
        int num1;
        int num2;
        Scanner input;

        input = new Scanner(System.in);

        n = input.nextInt();

        while (n > 0) {
            num1 = input.nextInt();
            num2 = input.nextInt();
            System.out.println(num1 + num2);
            n--;
        }
    }
}