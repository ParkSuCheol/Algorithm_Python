import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[] A, tmp;
    static int count = 0;
    static int result = -1;
    static int K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        tmp = new int[N];
        mergeSort(A, 0, N - 1);
        System.out.println(result);
    }
    public static void mergeSort(int[] arr, int p, int r){
        if (count > K) return;
        if (p < r) {
            int q = (p+r)/2;
            mergeSort(A,p,q);
            mergeSort(A,q + 1,r);
            merge(A, p, q, r);
        }
    }
    public static void merge(int[] A, int p, int q, int r){
        int i = p;
        int j = q + 1;
        int t = 0;

        while(i <= q && j <= r ){
            if(A[i] <= A[j]){
                tmp[t] = A[i];
                i++;
            }else{
                tmp[t] = A[j];
                j++;
            }
            t++;
        }
        while(i <= q)
            tmp[t++] = A[i++];
        while(j <= r)
            tmp[t++] = A[j++];

        i = p;
        t = 0;
        while (i <= r) {
            count++;
            if (count == K) {
                result = tmp[t];
                break;
            }
            A[i++] = tmp[t++];
        }
    }
}