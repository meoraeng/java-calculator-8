package calculator.model;

import java.util.ArrayList;
import java.util.Collections;


public class Separators {
    private ArrayList<String> seperators = new ArrayList<>(3);
    public Separators() {
        seperators.add(",");
        seperators.add(";");
    }
    public void addSeperator(String customSeperator) {
        if (customSeperator == null || customSeperator.isEmpty()) {
            return;
        }
        seperators.add(customSeperator);
    }
    public String cutNextToken(InputCursor cursor) {
        return cursor.cutBefore(Collections.unmodifiableList(seperators));
    }
}
