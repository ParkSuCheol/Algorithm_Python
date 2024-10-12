import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                if(ch == 'W'){
                    map[i][j] = 1;
                }else
                    map[i][j] = 0;
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if (i + 7 < N && j + 7 < M){
                    answer = Math.min(checkBoard(i,j), answer);
                }
            }
        }

        System.out.println(answer);

    }
    public static int checkBoard(int x, int y){
        int cnt = 0;
        int tmp = map[x][y];
        int endX = x + 8;
        int endY = y + 8;
        for(int i = x; i < endX; i++){
            for(int j = y; j < endY; j++){
                if(map[i][j] != tmp){
                    cnt++;
                }
                if(tmp == 0)
                    tmp = 1;
                else
                    tmp = 0;
            }
            if(tmp == 0)
                tmp = 1;
            else
                tmp = 0;
        }
        return Math.min(cnt, 64-cnt);
    }


}