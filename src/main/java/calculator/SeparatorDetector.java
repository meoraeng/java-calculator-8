package calculator;

import java.util.ArrayList;

public class SeparatorDetector {

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

    public static Result detect(String inputString){
        int start = inputString.indexOf("//");
        int end = inputString.indexOf("\\n", start+2);
        boolean ok = start == 0 && end != -1;

        if(ok) {
            String custom = inputString.substring(start+2, end);
            String body = inputString.substring(end + 2);

            if(custom.length() > 1) { // 구분자 글자수가 1글자보다 많은 경우(추후 validation으로 분리)
                throw new IllegalArgumentException(
                        "구분자는 한 글자만 입력할 수 있습니다. (입력된 구분자 : " + custom + ")"
                );
            }

            return new Result(custom, body);
        }
        return new Result("", inputString);
    }


    public static int findFirstSeparatorIdx(String current, ArrayList<String> seperators) {
        int minIdx = Integer.MAX_VALUE;
        boolean found = false;

        for(String seperator : seperators)  {
            int idx = current.indexOf(seperator);
            if (idx != -1) { // 2depth 추후 분리
                found = true;
                minIdx = Math.min(minIdx, idx);
            }
        }

        return found ? minIdx : -1;
    }
}