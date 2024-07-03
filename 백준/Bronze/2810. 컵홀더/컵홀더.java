import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder(s);
        
        boolean checkL = false;
        for (int i = 0, j = 0; i < s.length(); i++){
            if(s.charAt(i) == 'L'){
                if(!checkL){
                    checkL = true;
                    sb.insert(i+j, "*");
                    j++;
                    continue;
                }else{
                    checkL = false;
                }
            }else if(s.charAt(i) == 'S'){
                sb.insert(i+j,"*");
                j++;
            }
        }
        sb.append('*');
        sb.append('X');
        //System.out.println("sb.toString() = " + sb.toString());
        int cnt = 0;
        for (int i = 0; i < sb.length()-1; i++){
            char tmp = sb.charAt(i);
            if (tmp == '*')
                continue;
            if (sb.charAt(i-1) == '*'){
                cnt++;
                sb.replace(i-1,i,"O");
                continue;
            }else if (sb.charAt(i+1) == '*'){
                cnt++;
                sb.replace(i+1, i+2, "O");
                continue;
            }
        }
        System.out.println(cnt);
    }
}