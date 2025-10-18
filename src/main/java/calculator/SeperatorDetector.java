package calculator;

import java.util.ArrayList;

public class SeperatorDetector {

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

            return new Result(custom, body);
        }
        return new Result("", inputString);
    }


    public static int findFirstSeperatorIdx(String current, ArrayList<String> seperators) {
        int minIdx = Integer.MAX_VALUE;
        boolean found = false;

        for(String seperator : seperators)  {
            int idx = current.indexOf(seperator);
            if (idx != -1) {
                found = true;
                minIdx = Math.min(minIdx, idx);
            }
        }

        return found ? minIdx : -1;
    }
}