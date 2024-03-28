class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};
        String color = board[h][w];
        for(int i = 0; i < 4; i++){
            int fx = h + dx[i];
            int fy = w + dy[i];
            if(fx < 0 || fx >= board.length || fy < 0 || fy >= board.length)
                continue;
            if (board[fx][fy].equals(color))
                answer++;
        }
        return answer;
    }
}