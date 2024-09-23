import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int start = Dayliy(today);
        for(int i = 0; i < privacies.length; i++){
            String[] tmp = privacies[i].split(" ");
            int end = Dayliy(tmp[0]);
            
            for(int j = 0; j < terms.length; j++){
                String[] tmp2 = terms[j].split(" ");
                if(tmp2[0].equals(tmp[1])){
                    end += Integer.parseInt(tmp2[1]) * 28;
                    end--;
                }
            }
            
            if(end < start){
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    public static int Dayliy(String s){
        String[] tmp = s.split("\\.");
        
        int year = Integer.parseInt(tmp[0]);
        int month = Integer.parseInt(tmp[1]);
        int day = Integer.parseInt(tmp[2]);
        
        return year*12*28 + month * 28 + day;
    }
}