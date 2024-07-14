import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static char[][] map;
    public static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        int res = width() + height();
        System.out.println(res);
    }

    public static int width(){
        int cnt = 0;
        boolean chk = false;
        for (int i = 0; i < N; i++){
            chk = false;
            for (int j = 0; j < M; j++){
                if (chk && map[i][j] == '-')
                    continue;
                else{
                    if (map[i][j] == '-'){
                        chk = true;
                        cnt++;
                    }else{
                        chk = false;
                    }
                }
            }
        }
        return cnt;
    }

    public static int height(){
        int cnt = 0;
        boolean chk = false;
        for (int i = 0; i < M; i++){
            chk = false;
            for (int j = 0; j < N; j++){
                if (chk && map[j][i] == '|')
                    continue;
                else{
                    if (map[j][i] == '|'){
                        chk = true;
                        cnt++;
                    }else{
                        chk = false;
                    }
                }
            }
        }
        return cnt;
    }
}