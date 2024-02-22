import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int prev = 0, crossCnt = 1;

        while(true){
            if(X <= prev + crossCnt){
                if(crossCnt % 2 == 1){
                    System.out.println((prev-(X-crossCnt-1))+"/"+(X-prev));
                    break;
                }else{
                    System.out.println((X-prev) + "/" + (prev-(X-crossCnt-1)));
                    break;
                }
            }
            else{
                prev += crossCnt;
                crossCnt++;
            }
        }
    }
}