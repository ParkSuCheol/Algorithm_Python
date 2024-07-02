import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = {500, 100, 50, 10, 5, 1};
        N = 1000 - N;
        int num = 0;

        for (int i = 0; i < 6; i++) {
            if (N / arr[i] > 0) {
                num += N / arr[i];
                N = N % arr[i];
            }
        }
        System.out.println(num);
    }
}