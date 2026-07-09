import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
       
        HashMap <String, Integer> map = new HashMap<>();
        
        for (String[] elem : clothes) { 
            String type = elem[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int sum = 1;
        for (String key : map.keySet()) {
            sum *= (map.get(key) + 1);
        }
        return sum - 1;
        
    }
}