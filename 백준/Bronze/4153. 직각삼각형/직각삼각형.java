import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if(x == 0 && y == 0 && z == 0){
                break;
            }
            int[] tmp = new int[]{x,y,z};
            Arrays.sort(tmp);
            if (tmp[2] * tmp[2] == tmp[1] * tmp[1] + tmp[0] * tmp[0]){
                System.out.println("right");
            }else
                System.out.println("wrong");
        }
    }
}