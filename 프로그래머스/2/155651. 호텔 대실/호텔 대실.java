import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] res = new int[3000];
        for(int i = 0; i < book_time.length; i++){
            String start = book_time[i][0];
            String end = book_time[i][1];
            int startTime = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]);
            int endTime = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]);
            for(int j = startTime; j < endTime+10; j++){
                res[j]++;
            }
        }
        
        //System.out.println(Arrays.toString(res));
        int max = 0;
        for(int i = 0; i < res.length; i++){
            if (max < res[i])
                max = res[i];
        }
        return max;
    }
}