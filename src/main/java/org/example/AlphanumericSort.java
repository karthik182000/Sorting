package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlphanumericSort {
    public static void main(String[] args) {
        List<String> alphanumericList = new ArrayList<>();
        alphanumericList.add("kar10");
        alphanumericList.add("10kar");
        alphanumericList.add("ark10");
        alphanumericList.add("nan17");

        Collections.sort(alphanumericList, new AlphanumericComparator());

        // Printing the sorted list
        for (String str : alphanumericList) {
            System.out.println(str);
        }
    }
}

class AlphanumericComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        // Splitting the input strings into alphabetic and numeric parts
        String[] parts1 = splitAlphaNumeric(str1);
        String[] parts2 = splitAlphaNumeric(str2);

        // Comparing the alphabetic parts using natural ordering
        int alphaComparison = parts1[0].compareTo(parts2[0]);
        if (alphaComparison != 0) {
            return alphaComparison;
        }

        // Comparing the numeric parts using numerical comparison
        Integer num1 = Integer.parseInt(parts1[1]);
        Integer num2 = Integer.parseInt(parts2[1]);
        return num1.compareTo(num2);
    }

    private String[] splitAlphaNumeric(String str) {
        // Splitting the input string into alphabetic and numeric parts
        String alpha = str.replaceAll("[^A-Za-z]", "");
        String numeric = str.replaceAll("[^0-9]", "");
        return new String[]{alpha, numeric};
    }
}
