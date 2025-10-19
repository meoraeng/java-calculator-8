package calculator.controller;

import calculator.model.InputCursor;
import calculator.model.Numbers;
import calculator.model.SeparatorDetector;
import calculator.model.Separators;
import calculator.model.TokenParser;
import calculator.view.Input;
import calculator.view.Output;

public class Controller {
    private final Input input;
    private final Output output;
    private final TokenParser tokenParser;
    private final Separators separators;

    public Controller(Input input, Output output, TokenParser tokenParser, Separators separators) {
        this.input = input;
        this.output = output;
        this.tokenParser = tokenParser;
        this.separators = separators;
    }

    public void run() {
        String raw = input.readInput();
        int sum = calculate(raw);
        output.print(sum);
    }

    public int calculate(String raw) {
        var result = SeparatorDetector.detectCustomSeperator(raw);
        if (!result.getCustom().isEmpty()) {
            separators.addSeperator(result.getCustom());
        }

        var sepList = separators.getSeparators();
        var cursor = new InputCursor(result.getBody());
        var numbers = new Numbers();

        while(cursor.hasNext()) {
            int number = tokenParser.nextInteger(cursor, sepList);
            numbers.add(number);
        }
        return numbers.sum();
    }

}
