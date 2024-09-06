import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] output = new int[N];
        boolean[] v = new boolean[N];

        combination(arr, output, v, 0, 0, M);

        for (String s : set){
            System.out.println(s);
        }
    }

    public static void combination(int[] arr, int[] output, boolean[] v, int depth, int start, int end){
        if(depth == end){
            sb = new StringBuilder();
            for (int i = 0; i < end; i++){
                sb.append(output[i]).append(" ");
            }
            set.add(sb.toString());
            return;
        }
        for(int i = start; i < arr.length; i++){
            output[depth] = arr[i];
            combination(arr, output, v, depth+1, i, end);
        }
    }
}