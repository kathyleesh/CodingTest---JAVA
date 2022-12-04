package KM;

import java.util.ArrayList;
import java.util.List;

public class KM_2022_1 {
    public static void main(String[] args) {

        KM_2022_1 ex = new KM_2022_1();
        int flowers[][] = {{2, 5}, {3, 7}, {10, 11}};

        ex.solution(flowers);
    }

    static List<Integer> flowerDate = new ArrayList<>();

    public int solution(int[][] flowers) {
        int answer = 0;

        for (int i = 0; i < flowers.length; i++){
            checkFlower(flowers[i]);
        }

        answer = flowerDate.size();
        return answer;
    }

    public void checkFlower(int[] flower) {
        for (int i = flower[0]; i < flower[1]; i++) {
            if (!flowerDate.contains(i)) {
                flowerDate.add(i);
            }
        }
    }
}
