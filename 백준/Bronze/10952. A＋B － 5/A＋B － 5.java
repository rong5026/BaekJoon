import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        int num1;
        int num2;
        
        Scanner input;
        input = new Scanner(System.in);
        
        while (true) {
            num1 = input.nextInt();
            num2 = input.nextInt();
            
            if(num1 == 0 && num2 == 0)
                break;
            System.out.println(num1 + num2);
        }
    }
}