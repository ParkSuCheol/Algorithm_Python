import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int A,B, tmp, minNum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            System.out.println(LCM(A,B));
        }
    }

    public static void GCD(int A, int B){
        if(B == 0) {
            minNum = A;
            return;
        }
        if(A > B){
            tmp = B;
            B = A % B;
            A = tmp;
            GCD(A,B);
        }else{
            tmp = A;
            A = B;
            B = tmp;
            tmp = B;
            B = A % B;
            A = tmp;
            GCD(A,B);
        }
    }
    public static int LCM(int A, int B){
        GCD(A,B);
        return A*B / minNum;
    }
}