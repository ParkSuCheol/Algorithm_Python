import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static HashSet<String> set;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        arr = new int[6];
        set = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                dfs(0, i, j);
            }
        }

        System.out.println(set.size());

    }

    public static void dfs(int depth, int x, int y){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        if(depth == 6){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]);
            }
            set.add(sb.toString());
            return;
        }

        for (int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5){
                arr[depth] = map[nx][ny];
                dfs(depth + 1, nx, ny);
            }
        }

    }
}