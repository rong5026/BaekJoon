import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
       
        
        HashSet<String> set = new HashSet<>(Arrays.asList(report));
        HashMap<String, Integer> reportedMap = new HashMap<>();
        HashSet<String> bannedSet = new HashSet<>();    
        HashMap<String, Set<String>> reports = new HashMap<>();
        
        for (String str : set) {
            String[] pair = str.split(" ");
            String reporter = pair[0];
            String reported = pair[1];
            reportedMap.put(reported, reportedMap.getOrDefault(reported,0) + 1);
            
            if (reportedMap.get(reported) >= k)
                bannedSet.add(reported);
            reports.computeIfAbsent(reporter, x -> new HashSet<>()).add(reported);
        }
        
        int [] answer = new int[id_list.length];
        
        for (int i = 0 ; i < id_list.length ; i++) {
            for (String person : reports.getOrDefault(id_list[i], new HashSet<>()))
                if (bannedSet.contains(person))
                    answer[i]++;
        }
        

        return answer;
        
        
    }
}