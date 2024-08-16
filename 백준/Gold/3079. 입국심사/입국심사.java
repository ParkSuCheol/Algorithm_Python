import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N 개의 입국 심사대
        // M 명의 친구들
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[] arr = new long[(int)N];
        long start = 0;
        long end = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }
        end *= M;

        while (start <= end){
            long mid = (start + end) / 2;
            long sum = 0;
            for (long idx : arr){
                long cnt = mid / idx;
                if(sum >= M){
                    break;
                }
                sum += mid / idx;
            }
            if (sum < M){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}