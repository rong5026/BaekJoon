import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String result;

        Scanner input = new Scanner(System.in);
        result = input.nextLine().trim();

        if (result.isEmpty()) {
            System.out.println("0");
        }
        else {
            System.out.println(result.split(" ").length);
        }

        input.close();
    }
}