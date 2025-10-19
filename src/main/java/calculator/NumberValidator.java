package calculator;

public class NumberValidator {
    public static void nonNegativeValidation(int parsedInt, String token){
        if (parsedInt < 0) {
            throw new IllegalArgumentException(
                    "음수 값은 허용되지 않습니다 : " + token
            );
        }
    }
}
