import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long res = 0;

        for(int i = 0; i < N; i++){
            if (arr[i] <= B){
                res++;
                continue;
            }else{
                res++;
                arr[i] -= B;
            }
            if(arr[i] % C == 0)
                res += arr[i]/C;
            else {
                res += arr[i]/C;
                res++;
            }
        }
        System.out.println(res);
    }
}