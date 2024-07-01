import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int tmp = 0;
        int res = 0;
        end:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            count = 0;
            for (int j = 0; j < 5; j++) {
                res++;
                tmp = Integer.parseInt(st.nextToken());
                int[] which = findBingo(tmp);
                if (which == null) {
                    break end;
                }
                map[which[0]][which[1]] = 0;

                frstCheck();
                secCheck();
                thrdCheck();
                fourCheck();

                if (count >= 3) {
                    System.out.println(res);
                    break end;
                }
                count = 0;
            }
        }
    }

    public static void print(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "     ");
            }
            System.out.println();
        }
    }

    public static int[] findBingo(int N) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == N) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void frstCheck() {
        for (int i = 0; i < 5; i++) {
            int zero = 0;
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 0) {
                    zero++;
                }
            }
            if (zero == 5) {
                count++;
            }
        }
    }

    public static void secCheck() {
        for (int i = 0; i < 5; i++) {
            int zero = 0;
            for (int j = 0; j < 5; j++) {
                if (map[j][i] == 0) {
                    zero++;
                }
            }
            if (zero == 5) {
                count++;
            }
        }
    }

    public static void thrdCheck() {
        int zero = 0;
        for (int i = 0; i < 5; i++) {
            if (map[i][i] == 0) {
                zero++;
            }
        }
        if (zero == 5) {
            count++;
        }
    }

    public static void fourCheck() {
        int zero = 0;
        for (int i = 0; i < 5; i++) {
            if (map[i][4 - i] == 0) {
                zero++;
            }
        }
        if (zero == 5) {
            count++;
        }
    }
}