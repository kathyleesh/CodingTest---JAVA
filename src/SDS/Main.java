package SDS;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseNumber; i++) {
            String[] testNumber = br.readLine().split(" ");
            int row = Integer.parseInt(testNumber[0]);
            int column = Integer.parseInt(testNumber[1]);
            int bomb = Integer.parseInt(testNumber[2]);
            int[][] firePlace = new int[row][column];
            for (int j = 0; j < row; j++) {
                String[] place = br.readLine().split("");
                for (int k = 0; k < column; k++) {
                    if (Objects.equals(place[k], "#")) {
                        firePlace[j][k] = 0;
                    } else if (Objects.equals(place[k], ".")) {
                        firePlace[j][k] = 1;
                    }
                }
            }
            for (int j = 0; j < bomb; j++) {
                String[] fireBomb = br.readLine().split(" ");
                int fireRow = Integer.parseInt(fireBomb[0]) - 1;
                int fireColumn = Integer.parseInt(fireBomb[1]) - 1;
                firePlace[fireRow][fireColumn] = 2;
            }
            System.out.println(Arrays.toString(firePlace[0]));
            System.out.println(Arrays.toString(firePlace[1]));
            System.out.println(Arrays.toString(firePlace[2]));
            System.out.println(Arrays.toString(firePlace[3]));
            System.out.println(Arrays.toString(firePlace[4]));

            int[][] visited = new int[row][column];
            check(0, 0, firePlace, visited);
        }
    }

    public static void check(int x, int y, int firePlace[][], int[][] visited) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        Queue<Integer> queue = new LinkedList<>();
        int nx, ny;

        queue.offer(x);
        queue.offer(y);

        while (!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (firePlace[nx][ny] > 0 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    queue.offer(nx);
                    queue.offer(ny);
                }
            }
        }
    }
}





