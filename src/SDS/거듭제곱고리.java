package SDS;

import java.io.*;
import java.lang.Math;
import java.util.*;

public class 거듭제곱고리 {
    static List<Integer> countCheck = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseNumber; i++) {
            int countNumber = Integer.parseInt(br.readLine());
            String[] testNumber = br.readLine().split(" ");

            int n = countNumber;
            String[] arr = testNumber;
            int[] output = new int[n];
            boolean[] visited = new boolean[n];

            perm(arr, output, visited, 0, n, n);

            int index = i + 1;
            System.out.print("#" + index + " ");
            System.out.println(Collections.max(countCheck));
            countCheck.clear();

        }
    }

    static void perm(String[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            int[] testNumber = output;
            int countCase = countRoot(testNumber);
            countCheck.add(countCase);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = Integer.parseInt(arr[i]);
                perm(arr, output, visited, depth + 1, n, r);
                if (i != 0) {
                    visited[i] = false;
                }
            }
        }
    }

    public static int countRoot(int[] testNumber) {
        int count = 0;
        int countCheckSequential = checkSequential(count, testNumber);
        int countCheckFirstLast = checkFirstLast(countCheckSequential, testNumber);
        return countCheckFirstLast;
    }

    public static int checkSequential(int count, int[] testNumber) {
        for (int j = 1; j < testNumber.length; j++) {
            int before = testNumber[j - 1];
            int after = testNumber[j];
            int result = before + after;
            double calculate = Math.sqrt(result);

            if (calculate % 1 == 0) {
                count += 1;
            }
        }
        return count;
    }

    public static int checkFirstLast(int countCheckSequential, int[] testNumber) {
        int before = testNumber[testNumber.length - 1];
        int after = testNumber[0];
        int result = before + after;
        double calculate = Math.sqrt(result);
        if (calculate % 1 == 0) {
            countCheckSequential += 1;
        }
        return countCheckSequential;
    }

}
