import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static class Belt{
        boolean robot;
        int weight;
        public Belt(int weight){
            this.weight = weight;
            robot = false;
        }

        public void putRobot(){
            robot = true;
            weight--;
        }
    }
    static LinkedList<Belt> conveyor;
    static int n,k;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        conveyor = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n*2; i++){
            conveyor.add(i, new Belt(Integer.parseInt(st.nextToken())));
        }

        while (k > 0){
            moveConveyor();
            moveRobot();
        }
        System.out.println(res);
    }

    private static void moveConveyor() {
        res++;
        conveyor.add(0, conveyor.removeLast());
        if(conveyor.get(n-1).robot){
            conveyor.get(n-1).robot = false;
        }
    }

    private static void moveRobot() {
        for(int i = n - 1; i > 0; i--){
            if(!conveyor.get(i).robot)
                continue;
            if(conveyor.get(i+1).robot || conveyor.get(i+1).weight <= 0)
                continue;
            conveyor.get(i).robot = false;
            conveyor.get(i+1).putRobot();
            if(conveyor.get(i+1).weight <= 0) k--;

            if(i + 1 == n - 1)
                conveyor.get(i+1).robot = false;
        }
        //올리는 위치에 내구도 1 이상이면 로봇 올림
        if(conveyor.get(0).weight > 0){
            conveyor.get(0).putRobot();
            if(conveyor.get(0).weight <= 0) k--;
        }
    }
}