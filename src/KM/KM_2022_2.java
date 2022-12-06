package KM;

import java.util.*;
import java.util.stream.Collectors;

public class KM_2022_2 {

    public static void main(String[] args) {
        KM_2022_2 ex = new KM_2022_2();
        String id_list[] = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
        int k = 3;
        ex.solution(id_list, k);
    }

    public int solution(String[] id_list, int k) {
        int answer = 0;
        Map<String, Integer> cupon = new HashMap<>();
        for (String people : id_list) {
            String[] splitPeople = people.split(" ");
            ArrayList<String> personName = new ArrayList<>(Arrays.asList(splitPeople));
            List<String> peopleID = personName.stream().distinct().collect(Collectors.toList());
            for (String person : peopleID) {
                if (!Objects.equals(person, " ")) {
                    if (!cupon.containsKey(person)) {
                        cupon.put(person, 1);
                    } else {
                        if (cupon.get(person) < k) {
                            cupon.put(person, cupon.get(person) + 1);
                        }
                    }
                }
            }
        }
        System.out.println(cupon);
        for (Map.Entry<String, Integer> cuponId : cupon.entrySet()){
            answer = answer + cuponId.getValue();
        }
        System.out.println(answer);
        return answer;
    }
}
