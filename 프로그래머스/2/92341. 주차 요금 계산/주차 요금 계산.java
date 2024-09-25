import java.util.*;
import java.math.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] totalTime = new int[10001];
        int[] carTime = new int[10001];
        
        for(int i = 0; i < 10001; i++){
            carTime[i] = -1;
        }
        
        int basicTime = fees[0];
        int basicFee = fees[1];
        int caseTime = fees[2];
        int caseFee = fees[3];
        
        for(int i = 0; i < records.length; i++){
            String[] tmp = records[i].split(" ");
            String[] timeTmp = tmp[0].split(":");
            
            int time = Integer.parseInt(timeTmp[0]) * 60 + Integer.parseInt(timeTmp[1]);
            int carNumber = Integer.parseInt(tmp[1]);
            String command = tmp[2];
            
            if(command.equals("IN")){
                carTime[carNumber] = time;
            }else if (command.equals("OUT")){
                totalTime[carNumber] += time - carTime[carNumber];
                carTime[carNumber] = -1;
            }
        }
        for(int j = 0; j < 10001; j++){
            if(carTime[j] != -1){
                totalTime[j] += (23 * 60) + 59 - carTime[j];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
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
        //System.out.println(Arrays.toString(carTime));
        //System.out.println(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}