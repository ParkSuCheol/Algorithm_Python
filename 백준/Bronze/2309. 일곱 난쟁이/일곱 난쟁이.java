import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        end:for(int i = 0; i < 9; i++){
            for(int j = i+1; j < 9; j++){
                if(sum - arr[i] - arr[j] == 100){
                    for(int k = 0; k < 9; k++){
                        if(i == k || j == k){
                            continue;
                        }
                        sb.append(arr[k]).append('\n');
                    }
                    break end;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}