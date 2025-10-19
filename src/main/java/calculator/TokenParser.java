package calculator;

import java.util.List;

public class TokenParser {
    public int parseInteger(String token) {
        int parsedInt;
        try {
            parsedInt = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "범위를 초과했거나 유효하지 않은 값이 포함되어 있습니다 :" + token
            );
        }
        if (parsedInt < 0) {
            throw new IllegalArgumentException(
                    "음수 값은 허용되지 않습니다 : " + token
            );
        }
        return parsedInt;
    }

    public int nextInteger(InputCursor cursor, List<String> seperators ) {
        String token = cursor.cutBefore(seperators);
        return parseInteger(token);
    }


}
