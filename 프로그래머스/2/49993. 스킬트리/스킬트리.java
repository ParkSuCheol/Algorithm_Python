class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
		for(String skillTree : skill_trees){
            int learning = 0;
            boolean chk = true;
            for(char c:skillTree.toCharArray()){
                int idx = skill.indexOf(c);
                if(idx == -1)
                    continue;
                else if (idx == learning){
                    learning++;
                }else{
                    chk = false;
                    break;
                }
            }
            if(chk)
                answer++;
        }
		return answer;
    }
}