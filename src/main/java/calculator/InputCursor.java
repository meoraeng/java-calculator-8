package calculator;

public class InputCursor {
    private String restString;
    private String token;

    public InputCursor(String restString) {
        this.restString = restString;
    }

    public boolean isEmpty() {
        return restString == null || restString.isEmpty();
    }

    public String cutBefore(String separator) {
        // seperator가 1글자인지 체크하는 validation 추가
        int idx = restString.indexOf(separator);

        if(idx < 0) { // 구분자가 없는 경우 early return
            token = restString;
            restString = "";
            return token;
        }

        token = restString.substring(0, idx);
        restString = restString.substring(idx + 1);

        return token;
    }

    public boolean hasNext() {
        return !isEmpty();
    }
    public String rest() {
        return restString;
    }
}
