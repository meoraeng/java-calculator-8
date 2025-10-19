package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private ArrayList<Integer> numberList;

    public Numbers() {
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
