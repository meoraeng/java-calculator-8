package calculator;

public class Output {
    private final String outputGuide = "결과 : ";

    public void print(int sum) {
        String stringSum = Integer.toString(sum);
        System.out.println(outputGuide + stringSum);
    }
}
