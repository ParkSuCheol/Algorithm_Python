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

        int[] arr1 = new int[2];

        end:for(int i = 0; i < 9; i++){
            for(int j = i+1; j < 9; j++){
                if(sum - arr[i] - arr[j] == 100){
                    arr1[0] = i;
                    arr1[1] = j;
                    break end;
                }
            }
        }
        
        for(int i = 0; i < 9; i++){
            if(i == arr1[0] || i == arr1[1])
                continue;
            sb.append(arr[i]).append('\n');
        }
        

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}