import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] output = new int[n];
        boolean[] visit =  new boolean[n];

        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }

        dfs(arr, output, visit, 0, 0, m);
    }

    public static void dfs(int[] arr, int[] output, boolean[] visit, int k, int start, int end) {
        if (start == end){
            for (int i = 0; i < end; i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < arr.length; i++){
            if(!visit[i]){
                visit[i] = true;
                output[start] = arr[i];
                dfs(arr, output, visit, k, start+1, end);
                visit[i] = false;
            }
        }
    }

}