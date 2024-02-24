import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        person[] people = new person[N];
        StringTokenizer st;
        int height;
        int kg;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            kg = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            people[i] = new person(height, kg, 0);
        }
        for(int i = 0; i < N; i++){
            int chkNum = 0;
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(people[i].height < people[j].height && people[i].kg < people[j].kg)
                    chkNum++;
            }
            people[i].num = chkNum+1;
        }

        for(int i = 0; i < N; i++){
            System.out.print(people[i].num+ " ");
        }


        int sum = 0;
    }
    public static class person{
        int height;
        int kg;
        int num;
        public person(){}
        public person(int height, int kg, int num){
            this.height = height;
            this.kg = kg;
            this.num = num;
        }
    }
}