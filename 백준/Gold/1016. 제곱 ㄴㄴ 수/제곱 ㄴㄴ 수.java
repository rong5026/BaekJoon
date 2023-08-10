import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        long n = input.nextLong();
        long m = input.nextLong();


        long cnt =  m - n + 1;
        boolean arr[] = new boolean[(int)cnt];


        for(long i = 2 ; i * i <= m ; i++) {
            long pow = i *i;
            long tmp = n / pow;

            if(n % pow != 0)
                tmp++;
            for(long j = tmp ; j *pow <= m ; j++) {
                int index = (int)(j * pow - n);
                if(!arr[index]) {
                    arr[index] = true;
                    cnt--;
                }

            }
        }
        System.out.println(cnt);


    }
}
