import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<int[]>> genreList = new HashMap<>();
        
        // 장르별 총 재생수
        for (int i = 0 ; i < genres.length ; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            genreList.putIfAbsent(genres[i], new ArrayList<>());
            genreList.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        
        //재생수별 장르 정렬
        List<String> genreOrder = new ArrayList<>(genreMap.keySet());
        genreOrder.sort((a,b) -> genreMap.get(b) - genreMap.get(a));
        
        List<Integer> results = new ArrayList<>();
        
       //각 장르별 순회
       for (String genre : genreOrder) {
            //각 장르안 곡 정렬 + 상위 2개
            List<int[]> songs = genreList.get(genre);
            songs.sort((a, b) -> {
                if (b[1] != a[1])
                    return b[1] - a[1];
                return a[0] - b[0];
            });
           
           int limit = Math.min(2, songs.size());
           for (int i = 0 ; i < limit ; i++){
               results.add(songs.get(i)[0]);
           }
       }
        int [] answer = new int[results.size()];
        
        for (int i = 0 ; i < answer.length; i++) {
            answer[i] = results.get(i);
        }
        return answer;
        

    }
}