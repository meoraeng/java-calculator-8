package calculator;

public class Controller {
    private final Input input;
    private final Output output;
    private final TokenParser tokenParser;
    private final Separators seperators;

    public Controller(Input input, Output output, TokenParser tokenParser, Separators seperators) {
        this.input = input;
        this.output = output;
        this.tokenParser = tokenParser;
        this.seperators = seperators;
    }

    public void run() {
        String raw = input.readInput();
        int sum = calculate(raw);
        output.print(sum);
    }

    public int calculate(String raw) {
        var result = SeparatorDetector.detectCustomSeperator(raw);
        if (!result.getCustom().isEmpty()) {
            seperators.addSeperator(result.getCustom());
        }

        var sepList = seperators.getSeparators();
        var cursor = new InputCursor(result.getBody());
        var numbers = new Numbers();

        while(cursor.hasNext()) {
            String token = cursor.cutBefore(sepList);
            int n = tokenParser.parseInteger(token);
            numbers.add(n);
        }
        return numbers.sum();
    }

}
