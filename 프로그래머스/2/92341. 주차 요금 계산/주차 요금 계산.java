import java.util.*;
import java.math.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] totalTime = new int[10001];
        int[] carTime = new int[10001];
        
        for(int i = 0; i < carTime.length; i++){
            carTime[i] = -1;
        }
        
        int basicTime = fees[0];
        int basicFee = fees[1];
        int caseTime = fees[2];
        int caseFee = fees[3];
        
        for(String record : records){
            String ttime = record.split(" ")[0];
            int carNumber = Integer.parseInt(record.split(" ")[1]);
            String command = record.split(" ")[2];
            
            int hour = Integer.parseInt(ttime.split(":")[0]);
            int min = Integer.parseInt(ttime.split(":")[1]);
            int time = hour * 60 + min;
            
            if(command.equals("IN")){
                carTime[carNumber] = time;
            }else if (command.equals("OUT")){
                totalTime[carNumber] += time - carTime[carNumber];
                carTime[carNumber] = -1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        
        for(int i = 0; i < 10001; i++){
            if(carTime[i] != -1){
                totalTime[i] += (23 * 60) + 59 - carTime[i];
            }
        }
        
        for(int i = 0; i < 10001; i++){
            if(totalTime[i] != 0){
                int fee = totalTime[i];
                if(fee <= basicTime){
                    list.add(basicFee);
                }else{
                    list.add(basicFee + (int)Math.ceil((double)(fee - basicTime)/caseTime) * caseFee);
                }
            }
        }
        
        
        System.out.println(list);
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}