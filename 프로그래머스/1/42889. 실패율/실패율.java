import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> map = new HashMap<>(){};
        int[] res = new int[N];
        for(int i = 1; i <= N; i++){
            int cnt = 0;
            int fail = 0;
            for(int j = 0; j < stages.length; j++){
                if(stages[j] >= i){
                    cnt++;
                    if (stages[j] == i){
                        fail++;
                    }
                }
            }
            if(cnt == 0){
                map.put(i, 0.0);
            }else{
                map.put(i, ((double)fail/(double)cnt));
            }
        }


        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        
        for (Integer key : keySet) {
            System.out.print("Key : " + key);
            System.out.println(", Val : " + map.get(key));
        }
        
        for(int i = 0; i < keySet.size(); i++){
            res[i] = keySet.get(i);
        }
        return res;
	}
	
	
}