class Solution {
    static boolean[] v;
	static int cnt;
	public static int solution(String begin, String target, String[] words) {
        v = new boolean[words.length+1];
        cnt = Integer.MAX_VALUE;
        dfs(begin,target,words,0,0);
        if(cnt == Integer.MAX_VALUE)
        	cnt = 0;
        return cnt;
    }
	public static void dfs(String begin, String target, String[] words, 
			int index, int count) {
		
		if(begin.equals(target)) {
			cnt = Math.min(count, cnt);
			return;
		}
		v[index] = true;
		count++;
		for (int i = 0; i < words.length; i++) {
			int word = 0;
			for (int j = 0; j < begin.length(); j++) {
				if(begin.charAt(j) == words[i].charAt(j))
					word++;
			}
			if(word == begin.length()-1 && !v[i + 1]) {
				dfs(words[i],target,words,i+1,count);
			}
		}
		v[index] = false;
        return;
	}
}