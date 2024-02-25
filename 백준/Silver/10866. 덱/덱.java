
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static Deque<Integer> dq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		dq = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			switch (s[0]) {
			case "push_front": {
				dq.addFirst(Integer.parseInt(s[1]));
				break;
			}
			case "push_back": {
				dq.addLast(Integer.parseInt(s[1]));
				break;
			}
			case "pop_front": {
				if (dq.isEmpty()) {
					sb.append(-1).append('\n');
				} else
					sb.append(dq.pollFirst()).append('\n');
				break;
			}
			case "pop_back": {
				if (dq.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(dq.pollLast()).append('\n');
				break;
			}
			case "size": {
				sb.append(dq.size()).append('\n');
				break;
			}
			case "empty": {
				if (dq.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			}
			case "front": {
				if (dq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(dq.peekFirst()).append('\n');
				}
				break;
			}

			case "back": {
				if (dq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(dq.peekLast()).append('\n');
				}
				break;
			}
			}
		}
		System.out.println(sb);
	}

}
