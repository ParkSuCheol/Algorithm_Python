class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
		int a = numbers[0];
		answer += dfs(a,1,numbers,target);
		answer += dfs(-a,1,numbers,target);

		return answer;
	}
	
	public static int dfs(int prev, int index, int[] num, int tar) {
		if(index >= num.length) {
			if(prev == tar) {
				return 1;
			}
			return 0;
		}
		
		int cur1 = prev + num[index];
		int cur2 = prev - num[index];
		
		int ans = 0;
		
		ans += dfs(cur1, index+1, num, tar);
		ans += dfs(cur2, index+1, num, tar);
		
		return ans;
	}
}