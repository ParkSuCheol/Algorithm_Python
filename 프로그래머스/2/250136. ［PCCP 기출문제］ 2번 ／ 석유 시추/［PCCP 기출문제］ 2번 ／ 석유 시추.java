import java.util.*;

class Solution {
    static int X; static int Y;
    static int[] oil;
    public int solution(int[][] land) {
        int answer = 0;
        Y = land.length;
        X = land[0].length;
        oil = new int[X];
        boolean[][] v = new boolean[Y][X];
        
        for(int i = 0; i < Y; i++){
            for(int j = 0; j < X; j++){
                if(land[i][j] == 1 && !v[i][j])
                    bfs(land, v, i, j);        
            }
        }
        
        for(int max : oil){
            answer = Math.max(answer,max);
        }
        
        return answer;
    }
    
    public static void bfs(int[][] land, boolean[][] v, int y, int x){
        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};
        
        Queue<int[]> que = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        que.add(new int[]{y,x});
        int count = 1;
        v[y][x] = true;
        
        while(!que.isEmpty()){
            int[] tmp = que.poll();
            int fy; int fx;
            set.add(tmp[1]);
            for(int i = 0; i < 4; i++){
                fy = tmp[0] + dy[i];
                fx = tmp[1] + dx[i];
                
                if(fy < 0 || fy >= Y || fx < 0 || fx >= X)
                    continue;
                if(land[fy][fx] == 1 && v[fy][fx] == false){
                    que.add(new int[]{fy,fx});
                    count++;
                    v[fy][fx] = true;
                }
                
            }
        }
        for(int indx : set){
            oil[indx] += count; 
        }
        
    }

}