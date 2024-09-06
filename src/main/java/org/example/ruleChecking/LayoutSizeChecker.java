package org.example.ruleChecking;

public class LayoutSizeChecker {

    private static final int MIN_LAYOUT_SIZE = 2;
    private static final int MAX_LAYOUT_SIZE = 50;
    public static boolean checkLayoutSize(String[] layout){
        int fieldCounter = 0;
        for (String row : layout){
            fieldCounter+=row.length();
        }

        return fieldCounter >= MIN_LAYOUT_SIZE && fieldCounter <= MAX_LAYOUT_SIZE;
    }
}
