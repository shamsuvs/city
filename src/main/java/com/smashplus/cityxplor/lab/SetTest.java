package com.smashplus.cityxplor.lab;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String args[]){
        Set<String> mySet = new TreeSet<>();
        mySet.add("ind");
        mySet.add("aus");
        mySet.add("us");
        mySet.forEach(s -> {System.out.println(s);});
        Iterator<String> it = mySet.iterator();
        while(it.hasNext()) {
            String value = it.next();
            System.out.println(value);
        }
    }
}
