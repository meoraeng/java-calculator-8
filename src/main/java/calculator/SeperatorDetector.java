package calculator;

import java.util.ArrayList;

public class SeperatorDetector {
    private String inputString;
    private ArrayList<String> seperators;

    public SeperatorDetector(String str) {
        this.inputString = str;
    }

    private void stringUpdate(String str){
        this.inputString = str;
    }

    public String findCustomSeperator(){
        int start = inputString.indexOf("//");
        int end = inputString.indexOf("\n, start+2");
        boolean ok = start == 0 && end != -1;

        if(!ok) {
            return "";
        }
        stringUpdate(inputString.substring(end+2));
        return inputString.substring(start+2, end);
    }
}