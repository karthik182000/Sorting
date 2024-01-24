package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SpecialCharacterSort {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("abc");
        stringList.add("xyz");
        stringList.add("!@#");
        stringList.add("123");


        Collections.sort(stringList, new SpecialCharacterComparator());
        for (String str : stringList) {
            System.out.println(str);
        }
    }
}

class SpecialCharacterComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
}

