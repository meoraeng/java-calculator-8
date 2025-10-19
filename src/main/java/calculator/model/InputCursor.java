package calculator.model;

import java.util.List;

public class InputCursor {
    private String restString;

    private static class SeperatorState { // 상태 관리용 임시 객체
        int firstSepIdx = Integer.MAX_VALUE;
        String firstSeperator = null;
    }

    public InputCursor(String restString) {
        this.restString = restString;
    }

    public boolean isEmpty() {
        return restString == null || restString.isEmpty();
    }

    public String cutBefore(List<String> separators) {
        SeperatorState state = new SeperatorState();

        for (String seperator : separators) {
            int index = restString.indexOf(seperator);
            updateSeperatorState(index, seperator, state); // 함수로 분리하여 depth 유지
        }
        if (state.firstSeperator == null) {
            String token = restString;
            restString = "";
            return token;
        }
        String token = restString.substring(0, state.firstSepIdx);
        restString = restString.substring(state.firstSepIdx + 1);

        return token;
    }

    public boolean hasNext() {
        return !isEmpty();
    }

    private void updateSeperatorState(int index, String seperator, SeperatorState state) {
        if (index != -1 && index < state.firstSepIdx) {
            state.firstSepIdx = index;
            state.firstSeperator = seperator;
        }
    }
}
