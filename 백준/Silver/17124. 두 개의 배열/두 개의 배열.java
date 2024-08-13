import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arrA;
    static int[] arrB;
    static int[] arrC;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            arrA = new int[N];
            arrB = new int[M];
            arrC = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrB);

            for(int i = 0; i < N; i++){
                int number = arrA[i];
                int start = 0;
                int end = M-1;
                boolean flag = false;
                while (start + 1 < end){
                    int mid = (start + end) / 2;

                    if(number == arrB[mid]){
                        arrC[i] = number;
                        flag = true;
                        break;
                    }else if (number > arrB[mid]){
                        start = mid;
                    }else if (number < arrB[mid]){
                        end = mid;
                    }
                }

                if(!flag){
                    if(Math.abs(number - arrB[start]) == Math.abs(number - arrB[end])){
                        arrC[i] = arrB[start];
                    }else if(Math.abs(number - arrB[start]) < Math.abs(number - arrB[end])){
                        arrC[i] = arrB[start];
                    }else if (Math.abs(number - arrB[start]) > Math.abs(number - arrB[end])){
                        arrC[i] = arrB[end];
                    }
                }
            }

            long res = 0;
            for(int i = 0; i < N; i++){
                res += arrC[i];
            }

            System.out.println(res);

        }
    }
}