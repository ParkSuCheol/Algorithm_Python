import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            int tmp = Integer.parseInt(st.nextToken());
            int res = binarySearch(tmp);
            if(res!= -1){
                System.out.println(1);
            }else{
                System.out.println(0);
            }

        }
    }

    public static int binarySearch(int key){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            // 중간 위치 값
            int mid = (left + right)/2;

            // key값이 중간 위치의 값보다 작을 경우
            if(key < arr[mid]){
                right = mid - 1;
            }
            // key 값이 중간 위치의 값보다 클 경우
            else if (key > arr[mid]){
                left = mid + 1;
            }
            // key와 중간이 같을 경우
            else{
                return mid;
            }
        }
        return -1;
    }
}