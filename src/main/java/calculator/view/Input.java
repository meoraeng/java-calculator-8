package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String INPUT_START_GUIDE = "덧셈할 문자열을 입력해 주세요.";

    public String readInput() {
        System.out.println(INPUT_START_GUIDE);
        return Console.readLine();
    }
}
