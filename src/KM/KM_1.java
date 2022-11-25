package KM;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class KM_1 {
    public static void main(String[] args) {

        int v[][] = {{1, 4}, {3, 4}, {3, 10}};

        solution(v);
    }


    public static int[] solution(int[][] v) {
        int[] answer = {};

        ArrayList<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        int yIndex = 0;

        for (int i = v.length - 1; i >= 0; i--) {
            if (!x.contains(v[i][0])) {
                x.add(v[i][0]);
            } else {
                int xIndex = x.indexOf(v[i][0]);
                x.remove(xIndex);
            }
            if (!y.contains(v[i][1])) {
                y.add(v[i][1]);
            } else {
                yIndex = y.indexOf(v[i][1]);
                //System.out.println(y.indexOf(v[i][1]));
            }
        }

        x.add(y.get(searchIndex(yIndex)));

        Integer[] xyArray = x.toArray(new Integer[2]);
        int[] xyIntArray = Arrays.stream(xyArray).mapToInt(i -> i).toArray();

        answer = xyIntArray;

        return answer;
    }

    public static int searchIndex(int yIndex) {
        if (yIndex == 0) {
            return 1;
        }
        return 0;
    }
}