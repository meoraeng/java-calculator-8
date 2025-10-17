package calculator;

import java.util.ArrayList;

public class Seperator {
    private ArrayList<String> seperators = new ArrayList<>(3);
    public Seperator() {
        seperators.add(",");
        seperators.add(";");
    }
    public void addSeperator(String customSeperator) {
        seperators.add(customSeperator);
    }
}
