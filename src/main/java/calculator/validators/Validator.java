package calculator.validators;

public class Validator {
    public static void nonNegativeIntValidation(int parsedInt, String token){
        if (parsedInt < 0) {
            throw new IllegalArgumentException(
                    "음수 값은 허용되지 않습니다 : " + token
            );
        }
    }
    public static void checkSeparatorLength(String custom) {
        if (custom.length() > 1) {
            throw new IllegalArgumentException(
                    "구분자는 한 글자만 입력할 수 있습니다. (입력된 구분자 : " + custom + ")"
            );
        }
    }

    public static void isTokenEmpty(String token){
        if (token.isEmpty()) {
            throw new IllegalArgumentException(
                    "구분자를 연속해서 사용하거나 가장 앞에 사용할 수 없습니다."
            );
        }
    }
}
