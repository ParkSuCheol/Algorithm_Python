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
        for(int i = 0; i < N; i++){
            arr[i] = i+1;
        }
        boolean[] v = new boolean[N];
        combination(arr,v,0,M);
    }
    public static void combination(int[] arr, boolean[] v, int start, int end){
        if (end == 0){
            for(int i = 0; i < arr.length; i++){
                if(v[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
        for (int i = start; i < arr.length; i++){
            v[i] = true;
            combination(arr, v, i+1, end-1);
            v[i] = false;
        }
    }
}