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

    public int calculate() {
        var result = SeperatorDetector.detect(inputString);
        if (!result.getCustom().isEmpty()) {
            seperators.addSeperator(result.getCustom());
        }
        inputString = result.getBody();

        var sepList = seperators.getSeperators();

        while(true) {
            int firstSeperatorIdx = SeperatorDetector.findFirstSeperatorIdx(inputString, sepList);
            if(firstSeperatorIdx == -1){
                break;
            }

            splitStringToNumber(inputString, firstSeperatorIdx);
        }

        if (!inputString.isEmpty()) {
            numberList.add(Integer.parseInt(inputString));
        }
        return calculateNumber(numberList);
    }

    private void splitStringToNumber(String str, int seperatorIdx) {
        int number = Integer.parseInt(str.substring(0,seperatorIdx));
        String remainString = str.substring(seperatorIdx+1);
        numberList.add(number);  // 앞쪽값은 numberList.add
        this.inputString = remainString; // 뒤쪽값을 새 문자열로 갱신
    }
    private int calculateNumber(ArrayList<Integer> numberList){
        int sum = 0;
        for (Integer integer : numberList) {
            sum += integer;
        }
        return sum;
    }

}
