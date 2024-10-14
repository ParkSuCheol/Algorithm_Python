import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(report));
        HashMap<String, Integer> reportCount = new HashMap<>();
        HashMap<String, HashSet<String>> reportData = new HashMap<>();
        
        for(String data : set){
            String reporter = data.split(" ")[0];
            String reported = data.split(" ")[1];
            
            reportData.putIfAbsent(reporter, new HashSet<String>(){{
                add(reported);
            }});
            reportData.get(reporter).add(reported);
            
            reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
        }
        int[] answer = new int[id_list.length];
        
        for(String data : reportCount.keySet()){
            int reportedCount = reportCount.get(data);
            if(reportedCount >= k){
                for(int i = 0; i < id_list.length; i++){
                    if(reportData.containsKey(id_list[i]) && reportData.get(id_list[i]).contains(data)){
                        answer[i]++;
                    }
                }
            }
        }
        
        return answer;
    }
}