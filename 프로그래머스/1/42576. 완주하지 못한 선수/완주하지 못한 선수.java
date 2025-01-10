import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> list = new HashMap<>();
        
        for (String elem: participant) {
            int valueCnt = list.getOrDefault(elem, 0);
            list.put(elem, valueCnt + 1);
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