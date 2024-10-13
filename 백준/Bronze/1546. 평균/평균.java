import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double[] arr = new double[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(arr);
        double M = arr[N - 1];
        for(int i = 0; i < N; i++) {
            arr[i] = arr[i] / M * 100;
        }
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        System.out.println(sum / N);
    }
}