package KM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class KM_2022_3 {

    public static void main(String[] args) {
        KM_2022_3 ex = new KM_2022_3();

        String s = "2021:04:12:16:08:35";
        String[] times = {"01:06:30:00", "00:01:12:00"};

        ex.solution(s, times);
    }

    static List<List<String>> saveDate = new ArrayList<>();
    static List<List<String>> saveDates = new ArrayList<>();
    public int[] solution(String s, String[] times) {
        int[] answer = {};
        int result[] = new int[2];
        List<String> startD = timeCheck(s);
        List<String> startDate = timeCheck(s);
        saveMoney(times);
        for(List<String> save: saveDate){
            startDate = calculateDate(startDate, save);
        }
        for (int i = 0; i < times.length - 1; i++){
            if(!(saveDates.get(i).get(2) + 1).equals(saveDates.get(i + 1).get(2)) && !Objects.equals(saveDates.get(i).get(2), saveDates.get(i + 1).get(2))){
                result[0] = 0;
            }
            else {
            result[0] = 1;}
        }
        int start = Integer.parseInt(startD.get(2));
        int end = Integer.parseInt(saveDates.get(times.length - 1).get(2));
        result[1] = (end - start + 1);
        answer = result;
        return answer;
    }

    public List<String> timeCheck(String time){
        String[] timeSplit = time.split(":");
        ArrayList<String> date = new ArrayList<>(Arrays.asList(timeSplit));
        return date;
    }

    public void saveMoney(String[] times) {
        for (String time : times){
            List<String> date = timeCheck(time);
            saveDate.add(date);
        }
    }

    public List<String> calculateDate(List<String> startDate, List<String> saveDate){
        List<Integer> start = startDate.stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> save = saveDate.stream().map(Integer::parseInt).collect(Collectors.toList());
        int calculateSec = start.get(5) + save.get(3);
        if(calculateSec <= 60) {start.set(5, calculateSec);}
        else {
            start.set(5, calculateSec - 60);
            if(start.get(4) + 1 <= 60) {start.set(4, start.get(4) + 1);}
            else {if(start.get(3)+1 <= 24){start.set(3, start.get(3) + 1);}
            else {if(start.get(2)+1 <= 30){start.set(2, start.get(2) + 1);}
            else {if(start.get(1)+1 <= 12){start.set(1, start.get(1) + 1);}
            else {start.set(0, start.get(0) + 1);}}
        }}}
        int calculateMin = start.get(4) + save.get(2);
       if(calculateMin <= 60) {start.set(4, calculateMin);}
       else {
           start.set(4, calculateMin - 60);
           if(start.get(3) + 1 <= 24) {start.set(3, start.get(3) + 1);}
           else {if(start.get(2)+1 <= 30){start.set(2, start.get(2) + 1);}
           else {if(start.get(1)+1 <= 12){start.set(1, start.get(1) + 1);}
           else {start.set(0, start.get(0) + 1);}}}
       }
        int calculateHour = start.get(3) + save.get(1);
        if(calculateHour <= 24) {start.set(3, calculateHour);}
        else {
            start.set(3, calculateHour - 24);
            if(start.get(2) + 1 <= 30) {start.set(2, start.get(2) + 1);}
            else {if(start.get(1)+ 1 <= 12){start.set(1, start.get(1) + 1);}
            else {start.set(0, start.get(0) + 1);}}
        }
        int calculateDay = start.get(2) + save.get(0);
        if(calculateDay <= 30) {start.set(2, calculateDay);}
        else {
            start.set(2, calculateDay - 30);
            if(start.get(1)+1 <= 12){start.set(1, start.get(1) + 1);}
            else {start.set(0, start.get(0) + 1);}
        }
        List<String> saveNext = start.stream().map(Object::toString).collect(Collectors.toList());
        saveDates.add(saveNext);
        return saveNext;
    }
}
