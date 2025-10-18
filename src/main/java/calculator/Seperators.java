package calculator;

import java.util.ArrayList;

public class Seperators {
    private ArrayList<String> seperators = new ArrayList<>(3);
    public Seperators() {
        seperators.add(",");
        seperators.add(";");
    }
    public void addSeperator(String customSeperator) {
        seperators.add(customSeperator);
    }
    public ArrayList<String> getSeperators() {
        return seperators;
    }
}
