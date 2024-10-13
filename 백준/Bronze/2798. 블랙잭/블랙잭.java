import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int maxNum = 0;
    static int M;
    public static void main(String[] args) throws IOException {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        boolean[] v = new boolean[N];
        int[] output = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        combination(arr, output, v,0, 0, N);
        System.out.println(maxNum);
    }
    public static void combination(int[] arr, int[] output, boolean[] v,  int start, int end, int depth){
        if(end == 3){
            //System.out.println(Arrays.toString(output));
            int sum = 0;
            for(int i = 0; i < 3; i++){
                sum += output[i];
            }
            if(sum >= maxNum && M >= sum){
                maxNum = sum;
            }
            return ;
        }

        for(int i = start; i < depth; i++){
            if(!v[i]){
                v[i] = true;
                output[end] = arr[i];
                //System.out.println(Arrays.toString(output));
                combination(arr, output, v, i + 1, end + 1, depth);
                v[i] = false;
            }
        }

    }
}