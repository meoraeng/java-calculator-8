package calculator;

import java.util.ArrayList;

public class SeparatorDetector { // statelsess, 순수 기능 함수이므로 static으로 구현

    public static class Result {
        private final String custom;
        private final String body;
        public Result(String custom, String body) {
            this.custom = custom;
            this.body = body;
        }
        public String getCustom() {
            return custom;
        }
        public String getBody() {
            return body;
        }
    }

    public static Result detectCustomSeperator(String inputString){
        int start = inputString.indexOf("//");
        int end = inputString.indexOf("\\n", start+2);
        boolean ok = start == 0 && end != -1;

        if(ok) {
            String custom = inputString.substring(start+2, end);
            String body = inputString.substring(end + 2);

            Validator.checkSeparatorLength(custom);

            return new Result(custom, body);
        }
        return new Result("", inputString); // 커스텀이 없는 경우
    }
}