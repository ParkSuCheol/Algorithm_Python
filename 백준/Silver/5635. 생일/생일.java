import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static class Person{
        String name;
        int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString(){
            return name + " " + age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Person[] people = new Person[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String day = st.nextToken();
            if(day.length() < 2){
                day = "0" + day;
            }
            String month = st.nextToken();
            if(month.length() < 2){
                month = "0" + month;
            }
            String year = st.nextToken();

            int age = Integer.parseInt(year + month + day);

            people[i] = new Person(name, age);
        }

        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        bw.write(people[N-1].name);
        bw.write('\n');
        bw.write(people[0].name);
        bw.flush();
        bw.close();
        br.close();
    }
}