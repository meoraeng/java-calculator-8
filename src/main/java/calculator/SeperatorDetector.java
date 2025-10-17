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

    public int findFirstSeperatorIdx(ArrayList<String> seperators, String str) {
        int minIdx = Integer.MAX_VALUE;
        boolean found = false;

        for(String seperator : seperators)  {
            int idx = str.indexOf(seperator);
            if(idx != -1) { // 2depth라 리팩토링 대상
                found = true;
                minIdx = Math.min(minIdx, idx);
            }
        }

        return found ? minIdx : -1;
    }
}