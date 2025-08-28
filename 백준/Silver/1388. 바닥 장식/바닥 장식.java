import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 세로 N, 가로 M
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int res = 0;
        res = width() + height();

        System.out.println(res);
    }

    public static int width() {
        int cnt = 0;
        boolean v = false;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == '-' && v){
                    continue;
                }else if (arr[i][j] == '-' && !v){
                    cnt += 1;
                    v = true;
                }else if (arr[i][j] != '-'){
                    v = false;
                }
            }
            v = false;
        }

        return cnt;
    }

    public static int height() {
        int cnt = 0;
        boolean v = false;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(arr[j][i] == '|' && v){
                    continue;
                }else if(arr[j][i] == '|' && !v){
                    cnt += 1;
                    v = true;
                }else if(arr[j][i] != '|'){
                    v = false;
                }
            }
            v = false;
        }
        return cnt;
    }
}
