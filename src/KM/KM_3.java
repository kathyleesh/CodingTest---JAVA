package KM;

import java.util.Arrays;

class KM_3 {
    public static void main(String[] args) {

        int n = 3;

        solution(n);
    }

    public static int[] solution(int n) {
        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            answer[i] = i;
        }

        return answer;
    }
}