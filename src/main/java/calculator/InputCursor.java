package calculator;

import java.util.List;

public class InputCursor {
    private String restString;

    public InputCursor(String restString) {
        this.restString = restString;
    }

    public boolean isEmpty() {
        return restString == null || restString.isEmpty();
    }

    public String cutBefore(List<String> separator) {
        // seperator가 1글자인지 체크하는 validation 추가
        int min = Integer.MAX_VALUE;
        String hit = null;
        for (String s : separator) {
            int i = restString.indexOf(s);
            if (i != -1 && i < min) {
                min = i;
                hit = s;
            }
        }
        if (hit == null) {
            String token = restString;
            restString = "";
            return token;
        }
        String token = restString.substring(0, min);
        restString = restString.substring(min + 1);

        return token;
    }

    public boolean hasNext() {
        return !isEmpty();
    }
    public String rest() {
        return restString;
    }
}
