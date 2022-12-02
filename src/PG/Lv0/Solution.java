package PG.Lv0;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution ex = new Solution();
        int dots[][] = {{1, 1}, {5, 1}, {1, 10}, {3, 10}};

        ex.solution(dots);
    }

    public int solution(int[][] dots) {
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                List<Integer> con = new ArrayList<>(List.of(0, 1, 2, 3));
                con.remove(con.indexOf(i));
                con.remove(con.indexOf(j));
                if ((dots[j][0] - dots[i][0]) != 0) {
                    int slope1 = (dots[j][1] - dots[i][1]) / (dots[j][0] - dots[i][0]);
                    if ((dots[con.get(1)][0] - dots[con.get(0)][0]) != 0) {
                        int slope2 = (dots[con.get(1)][1] - dots[con.get(0)][1]) / (dots[con.get(1)][0] - dots[con.get(0)][0]);
                        if (slope1 != 0 && Math.abs(slope1) == Math.abs(slope2)) {
                            answer++;
                        }
                    }
                    else if((dots[j][1] - dots[i][1]) == 0){
                        if((dots[con.get(1)][1] - dots[con.get(0)][1]) == 0 | (dots[con.get(1)][0] - dots[con.get(0)][0]) == 0){
                            answer++;
                        }
                    }
                }
                else if((dots[j][1] - dots[i][1]) == 0 && (dots[j][0] - dots[i][0]) == 0){
                    if((dots[con.get(1)][1] - dots[con.get(0)][1]) == 0 && (dots[con.get(1)][0] - dots[con.get(0)][0]) == 0){
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer / 2);
        return answer / 2;
    }
}
