package calculator;


public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        TokenParser tokenParser = new TokenParser();
        Separators separators = new Separators();

        Controller controller = new Controller(input, output, tokenParser, separators);
        controller.run();
    }
}
