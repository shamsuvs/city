package com.smashplus.cityxplor.lab;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIterator {
    public static void main(String args[]){
        //sv4234993
        HashMap<String,String> myCarMap = new HashMap<String,String>();
        myCarMap.put("elite","ferrari");
        myCarMap.put("premium","honda city");

        for (Map.Entry<String, String> mapEntry : myCarMap.entrySet()) {
            System.out.println(mapEntry.getKey()+":"+mapEntry.getValue());
        }
        //using lambda in Java 8 onwards

        myCarMap.forEach( (k,v) -> System.out.println("Key: " + k + ": Value: " + v));

        //iterate using iterator
        Iterator<Map.Entry<String,String>> mapIterator = myCarMap.entrySet().iterator();
        while(mapIterator.hasNext()) {
            Map.Entry<String,String> mapEntry = mapIterator.next();
            System.out.println(mapEntry.getKey()+":"+mapEntry.getValue());
        }
//stream
        myCarMap.entrySet().stream().forEach((entry) -> {
            Object currentKey = entry.getKey();
            Object currentValue = entry.getValue();
            System.out.println(currentKey + ":" + currentValue);
        });
    }
}
