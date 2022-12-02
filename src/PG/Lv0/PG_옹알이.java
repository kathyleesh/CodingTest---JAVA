package PG.Lv0;

import java.util.List;
import java.util.ArrayList;

public class PG_옹알이 {

    public static void main(String[] args) {

        String babbling[] = {"aya", "yee", "u", "maa", "wyeoo"};

        solution(babbling);
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        List<String> baby = new ArrayList<>(List.of("aya", "ye", "woo", "ma"));
        for (int i = 0; i < babbling.length;i++) {
            for (String b : baby) {
                if (babbling[i].contains(b)) {
                    babbling[i] = (babbling[i].replace(b, " "));
                }
            }
            if (babbling[i].trim().equals("")) {
                answer++;
            }
        }

        return answer;
    }
}

