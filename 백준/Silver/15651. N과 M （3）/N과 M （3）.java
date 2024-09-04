import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] output = new int[N];
        boolean[] v = new boolean[N];

        permutation(arr, output, v, 0,  0, M);
        System.out.println(sb.toString());
    }

    public static void permutation(int[] arr, int[] output, boolean[] v, int depth, int start, int end){
        if (depth == end){
            for(int i = 0; i < end; i++){
                sb.append(output[i] + " ");
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < arr.length; i++){
            output[depth] = i + 1;
            permutation(arr, output, v,depth + 1, start, end);
        }
    }
}