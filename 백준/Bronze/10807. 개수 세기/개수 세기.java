import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int chk = 0;
		for(int i = 0; i < N; i++) {
			if(V == arr[i])
				chk++;
		}
		
		bw.write(chk + "");
		bw.flush();
		bw.close();
		br.close();
	}
}