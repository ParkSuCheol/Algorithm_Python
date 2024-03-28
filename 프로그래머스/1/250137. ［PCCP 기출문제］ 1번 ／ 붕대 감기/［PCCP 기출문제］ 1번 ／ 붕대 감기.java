class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int time = bandage[0];
        int heal = bandage[1];
        int healMax = bandage[2];
        int lastTime = attacks[attacks.length-1][0];
        int cnt = 0;
        int index = 0;

        for(int i = 1; i <= lastTime; i++){
            int attackTime = attacks[index][0];
            int damage = attacks[index][1];
            if(attackTime == i){
                health -= damage;
                cnt = 0;
                index++;
                if(health <= 0)
                    return -1;
            }else{
                health += heal;
                cnt++;
                if(time == cnt){
                    health += healMax;
                    cnt = 0;
                }
                if(health >= answer)
                    health = answer;
            }
        }
        return health;
    }
}