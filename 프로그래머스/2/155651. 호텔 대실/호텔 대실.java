import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < book_time.length; i++){
            String start = book_time[i][0];
            String end = book_time[i][1];
            int startTime = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]);
            int endTime = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]);
            list.add(new int[]{startTime, endTime+10});
        }
        Collections.sort(list, (o1, o2)->{
           return o1[0] - o2[0]; 
        });
        //System.out.println(Arrays.toString(res));
        
        for(int[] t : list){
            if(!pq.isEmpty() && pq.peek() <= t[0]){
                pq.poll();
            }
            pq.add(t[1]);
        }
        
        return pq.size();
    }
}