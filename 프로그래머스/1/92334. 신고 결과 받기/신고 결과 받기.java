import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> reporterCount = new HashMap<>();
        HashMap<String, HashSet<String>> reporterInfo = new HashMap<>();
        HashSet<String> reporterSet = new HashSet<>(Arrays.asList(report));

        for (String reportInfo : reporterSet){
            String reporter = reportInfo.split(" ")[0];
            String reported = reportInfo.split(" ")[1];
            reporterInfo.putIfAbsent(reporter, new HashSet<String>(){{
               add(reported);
            }});
            reporterInfo.get(reporter).add(reported);
            reporterCount.put(reported, reporterCount.getOrDefault(reported, 0) + 1);
        }

        for(String reported : reporterCount.keySet()){
            int reportedCount = reporterCount.get(reported);
            if (reportedCount >= k){
                for(int i = 0; i < id_list.length; i++){
                    if(reporterInfo.containsKey(id_list[i]) && reporterInfo.get(id_list[i]).contains(reported)){
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
}