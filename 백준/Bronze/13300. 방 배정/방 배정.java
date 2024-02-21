import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] female = new int[7];
		int[] male = new int[7];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			if (sex == 0)
				female[grade]++;
			else
				male[grade]++;
		}
		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			sum += male[i] / k;
			sum += female[i] / k;
			
			int maleSum = male[i] % k;
			int femaleSum = female[i] % k;
			
			if(maleSum != 0)
				sum++;
			if (femaleSum != 0)
				sum++;
		}
		
		bw.write(sum+"");
		bw.flush();
		bw.close();
		br.close();
	}

}