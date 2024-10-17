import java.util.*;
class Solution {
    static char[][] map;
    static boolean[][] v;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N, M;
    public static int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        
        map = new char[N][M];
        v = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            String tmp = maps[i];
            for(int j = 0; j < M; j++){
                map[i][j] = tmp.charAt(j);
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if (map[i][j] == 'S'){
                    int frst = bfs(i,j,'L');
                    if(frst == -1)
                        return -1;
                    else
                        answer += frst;
                }
            }
        }
        v = new boolean[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 'L'){
                    int sec = bfs(i,j,'E');
                    if(sec == -1)
                        return -1;
                    else
                        answer += sec;
                }
            }
        }
        return answer;
    }
    
    public static int bfs(int x, int y, char target){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        v[x][y] = true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int nx = tmp[0];
            int ny = tmp[1];
            int cnt = tmp[2];
            for(int i = 0; i < 4; i++){
                int fx = nx+dx[i];
                int fy = ny+dy[i];
                if(fx < 0 || fx >= N || fy < 0 || fy >= M)
                    continue;
                if(map[fx][fy] == target){
                    v[fx][fy] = true;
                    return cnt+1;
                }
                if(v[fx][fy] || map[fx][fy] == 'X')
                    continue;
                
                q.add(new int[]{fx,fy,cnt+1});
                v[fx][fy] = true;
            }
        }
        
        return -1;
    }
}