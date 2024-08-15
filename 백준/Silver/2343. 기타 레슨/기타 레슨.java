import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int left, right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }
        System.out.println(binarySearch(left, right));
    }

    public static long binarySearch(long left, long right) {
        while (left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            long count = 1;
            for(int i = 0; i < N; i++){
                sum += arr[i];
                if (sum > mid){
                    sum = arr[i];
                    count++;
                }
            }
            if (count <= M){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

}