package calculator;

import java.util.ArrayList;

public class Controller {
    private final Output output = new Output();
    private String inputString;
    private Separators seperators;
    private ArrayList<Integer> numberList = new ArrayList<>();

    public Controller(){
        Input input = new Input();
        this.inputString = input.readInput();
        this.seperators = new Separators();
    }

    public void run() {
        int sum = calculate();
        output.print(sum);
    }

    public int calculate() {
        var result = SeparatorDetector.detectCustomSeperator(inputString);
        if (!result.getCustom().isEmpty()) {
            seperators.addSeperator(result.getCustom());
        }
        inputString = result.getBody();
        var sepList = seperators.getSeparators();

        while(true) {
            int firstSeperatorIdx = SeparatorDetector.findFirstSeparatorIdx(inputString, sepList);
            if(firstSeperatorIdx == -1){ // 구분자가 모두 없는 경우 탈출(추후 validation 분리)
                break;
            }

            splitStringToNumber(inputString, firstSeperatorIdx);
        }

        if (!inputString.isEmpty()) { // 추후 validation 분리
            numberList.add(Integer.parseInt(inputString));
        }
        return calculateNumber(numberList);
    }

    private void splitStringToNumber(String str, int seperatorIdx) {
        String numberToken = str.substring(0, seperatorIdx);

        try {
            int number = Integer.parseInt(numberToken);

            if (number < 0) { // validaton 분리
                throw new IllegalArgumentException(
                        "음수값은 허용되지 않습니다.: " + numberToken
                );
            }
            String remainString = str.substring(seperatorIdx + 1);
            numberList.add(number);  // 앞쪽값은 numberList.add
            this.inputString = remainString; // 뒤쪽값을 새 문자열로 갱신
         } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "정수 범위를 초과했거나 유효하지 않은 값이 포함되어 있습니다.: " + numberToken
            );
        }
    }
    private int calculateNumber(ArrayList<Integer> numberList){
        int sum = 0;
        for (Integer integer : numberList) {
            sum += integer;
        }
        return sum;
    }

}
