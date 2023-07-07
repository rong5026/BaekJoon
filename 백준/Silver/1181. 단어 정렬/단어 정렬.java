import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void changeIndex(ArrayList<String> array) {

        for(int i = 1 ; i < array.size() ; i++) {
            for(int j  = 0 ; j < array.size() - i ; j++){
                if(array.get(j).length() > array.get(j+1).length()) {
                    Collections.swap(array, j , j + 1);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> strArray = new TreeSet<String>();

        String array;

        for(int i = 0 ; i < n ; i++) {
            array = br.readLine();
            strArray.add(array);
        }

        ArrayList<String> result = new ArrayList<String>(strArray);
        changeIndex(result);

        for(int i = 0 ; i < result.size() ; i++) {
            System.out.println(result.get(i));
        }
    }
}