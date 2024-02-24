import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int command = 0;
        for(int i = 0; i < K; i++){
            command = Integer.parseInt(br.readLine());
            if(command == 0){
                stack.pop();
            }else{
                stack.push(command);
            }
        }
        int sum = 0;
        for(int i = 0; i < stack.size(); i++)
            sum += stack.get(i);
        System.out.println(sum);
    }
}