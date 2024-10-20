import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 시작 숫자
        int M = Integer.parseInt(st.nextToken()); // 끝 숫자

        v = new boolean[M + 1]; // 방문 여부 배열

        // 에라토스테네스의 체 알고리즘 적용
        find(M);

        // N부터 M까지 소수 출력
        for (int i = N; i <= M; i++) {
            if (!v[i]) { // 소수인 경우
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void find(int m) {
        v[0] = true; // 0은 소수가 아님
        v[1] = true; // 1도 소수가 아님
        for (int i = 2; i * i <= m; i++) { // i의 제곱이 m 이하일 때까지 반복
            if (!v[i]) { // i가 소수라면
                for (int j = i * i; j <= m; j += i) { // i의 배수들을 모두 소수 아님으로 처리
                    v[j] = true; // j는 소수가 아님
                }
            }
        }
    }
}