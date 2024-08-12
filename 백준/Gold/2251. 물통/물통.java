import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int[] arr = new int[3];
    static boolean[][] v;
    static Set<Integer> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        v = new boolean[201][201];
        res = new TreeSet<Integer>();

        dfs(0, 0, arr[2]);

        for(int num : res){
            System.out.print(num + " ");
        }

    }

    public static void dfs(int a, int b, int c){
        if(v[a][b])
            return;
        if(a == 0){
            res.add(c);
        }
        v[a][b] = true;

        // 0번 -> 1번
        if(a + b > arr[1]){
            dfs((a+b)-arr[1], arr[1], c);
        }else{
            dfs(0, a+b, c);
        }
        // 1번 -> 0번
        if(a + b > arr[0]){
            dfs(arr[0], a+b-arr[0], c);
        }else{
            dfs(a+b, 0, c);
        }
        // 2번 -> 0번
        if(a+c > arr[0]){
            dfs(arr[0], b, a+c-arr[0]);
        }else{
            dfs(a+c, b, 0);
        }
        // 2번 -> 1번
        if(b+c > arr[1]){
            dfs(a, arr[1], b+c-arr[1]);
        }else{
            dfs(a, b+c, 0);
        }
        // 0번 -> 2번
        dfs(a, 0, b+c);
        // 1번 -> 2번
        dfs(0, b, a+c);
    }
}