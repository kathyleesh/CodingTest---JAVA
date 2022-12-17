package SDS;

import java.io.*;
import java.util.*;

public class 바람의신 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseNumber; i++) {
            List<Integer> maxPeople = new ArrayList<>();
            String[] conditions = br.readLine().split(" ");
            int row = Integer.parseInt(conditions[0]);
            int column = Integer.parseInt(conditions[1]);
            int count = Integer.parseInt(conditions[2]);

            int[][] peopleMatrixArr = new int[row][column];
            for(int j = 0; j < row; j++) {
                String[] matrixNum = br.readLine().split(" ");
                for(int k = 0; k < column; k++){
                    peopleMatrixArr[j][k] = Integer.parseInt(matrixNum[k]);
                }
            }

            String[] result = new String[count];
            moveWay(0, result, maxPeople, peopleMatrixArr);
            int maxCase = Collections.max(maxPeople);
            int caseNum = i + 1;
            System.out.println("#" + caseNum + " " + maxCase);
        }
    }

    public static void moveWay(int cnt, String[] result, List<Integer> maxPeople, int[][] peopleMatrixArr) {
        if (cnt == result.length) {
            List<String> winds = new ArrayList<>();
            List<String> windone = Arrays.asList(result);
            for(String windOne : windone) {
                winds.add(windOne);
            }

            int[][] cloneArr = new int[peopleMatrixArr.length][peopleMatrixArr[0].length];
            for (int i = 0; i < peopleMatrixArr.length; i++) {
                for (int j = 0; j < peopleMatrixArr[0].length; j++) {
                    cloneArr[i][j] = peopleMatrixArr[i][j];
                }
            }

            for (String wind : winds) {
                if (Objects.equals(wind, "N")) {
                    int row = cloneArr.length;
                    int column = cloneArr[0].length;
                    for (int i = 0; i < column; i++) {
                        for (int j = 0; j < row - 1; j++) {
                            if (cloneArr[j][i] != 0) {
                                int before = cloneArr[j][i];
                                int after = cloneArr[j + 1][i];
                                cloneArr[j + 1][i] = before + after;
                                cloneArr[j][i] = 0;
                                break;
                            }
                        }
                    }
                } else if (Objects.equals(wind, "S")) {
                    int row = cloneArr.length;
                    int column = cloneArr[0].length;
                    for (int i = 0; i < column; i++) {
                        for (int j = row - 1; j > 0; j--) {
                            if (cloneArr[j][i] !=  0) {
                                int before = cloneArr[j][i];
                                int after = cloneArr[j - 1][i];
                                cloneArr[j - 1][i] = before + after;
                                cloneArr[j][i] = 0;
                                break;
                            }
                        }
                    }
                } else if (Objects.equals(wind, "W")) {
                    int row = cloneArr.length;
                    int column = cloneArr[0].length;
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column - 1; j++) {
                            if (cloneArr[i][j] != 0) {
                                int before = cloneArr[i][j];
                                int after = cloneArr[i][j + 1];
                                cloneArr[i][j + 1] = before + after;
                                cloneArr[i][j] = 0;
                                break;
                            }
                        }
                    }
                } else {
                    int row = cloneArr.length;
                    int column = cloneArr[0].length;
                    for (int i = 0; i < row; i++) {
                        for (int j = column - 1; j > 0; j--) {
                            if (cloneArr[i][j] !=  0) {
                                int before = cloneArr[i][j];
                                int after = cloneArr[i][j - 1];
                                cloneArr[i][j - 1] = before + after;
                                cloneArr[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < cloneArr.length; i++) {
                for (int j = 0; j < cloneArr[0].length; j++) {
                    if (max < cloneArr[i][j]) {
                        max = cloneArr[i][j];
                    }
                }
            }
            maxPeople.add(max);
            return;
        }
        String[] target = new String[]{"N", "S", "W", "E"};

        for (int i = 0; i < 4; i++) {
            result[cnt] = target[i];
            moveWay(cnt + 1, result, maxPeople, peopleMatrixArr);
        }
    }
}
