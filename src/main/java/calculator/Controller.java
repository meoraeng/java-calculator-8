package calculator;

import java.util.ArrayList;

public class Controller {
    private Input input = new Input();
    private String inputString;
    private Seperators seperators;
    private ArrayList<Integer> numberList = new ArrayList<>();

    public Controller(){
        this.inputString = input.readInput();
        this.seperators = new Seperators();
    }

    private void splitStringToNumber(String str, int seperatorIdx) {
        int number = Integer.parseInt(str.substring(0,seperatorIdx));
        String remainString = str.substring(seperatorIdx+1);
        numberList.add(number);  // 앞쪽값은 numberList.add
        this.inputString = remainString; // 뒤쪽값을 새 문자열로 갱신
    }

}
