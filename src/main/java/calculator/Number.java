package calculator;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private ArrayList<Integer> numberList;

    Number() {
        this.numberList = new ArrayList<>();
    }

    public void add(int value) {
        numberList.add(value);
    }

    public int sum() {
        return numberList.stream().mapToInt(Integer::intValue).sum();
    }

    public List<Integer> asList() { //getter 없이 복사본 반환
        return List.copyOf(this.numberList);
    }
}
