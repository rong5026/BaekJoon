import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> list = new HashMap<>();
        
        for (String elem: participant) {
            int count = 0;
            if (list.get(elem) != null) {
	            count = list.get(elem);
            }
            list.put(elem, count + 1);
        }
        
        for (String elem: completion) {
            int valueCnt = list.get(elem);
            if (valueCnt == 1) {
                list.remove(elem);
            }
            else {
                list.put(elem, valueCnt - 1);
            }
        }
        
         for (String key : list.keySet()) {
           if (list.get(key) == 1) {
                return key;
            }
        }
        return "";

    }
}