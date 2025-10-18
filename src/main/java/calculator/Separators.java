package calculator;

import java.util.ArrayList;

public class Separators {
    private ArrayList<String> seperators = new ArrayList<>(3);
    public Separators() {
        seperators.add(",");
        seperators.add(";");
    }
    public void addSeperator(String customSeperator) {
        seperators.add(customSeperator);
    }
    public ArrayList<String> getSeparators() {
        return seperators;
    }
}
