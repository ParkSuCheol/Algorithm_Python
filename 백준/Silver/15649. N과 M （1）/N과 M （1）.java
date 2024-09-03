import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] output = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = i+1;
        }
        boolean[] v = new boolean[N];
        permutation(arr, output, v, 0, 0, M);
    }

    public static void permutation(int[] arr, int[] output, boolean[] v, int k, int start, int end){
        if (start == end){
            for (int i = 0; i < end; i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++){
            if (!v[i]){
                v[i] = true;
                output[start] = arr[i];
                permutation(arr, output, v, k, start + 1, end);
                v[i] = false;
            }
        }
    }

}