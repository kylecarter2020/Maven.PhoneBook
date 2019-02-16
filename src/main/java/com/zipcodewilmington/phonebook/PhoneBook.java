package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private SortedMap<String, ArrayList<String>> map;
    private ArrayList<String> number;

    public PhoneBook(){
        map = new TreeMap<>();
    }

    public void add(String name, String... number) {
        this.number = new ArrayList<>(Arrays.asList(number));

        if(hasEntry(name))
        {
            this.number.addAll(getArrayListFor(name));
        }

        map.put(name, this.number);

    }

    public void removeRecord(String name) {
        map.remove(name);
    }

    public boolean hasEntry(String name) {

        return map.containsKey(name);
    }

    public String listNamesAndNumbers() {
        String result = "";

        for (String key : map.keySet()) {
            result += key + " " + map.get(key).toString() + "\n";
        }

        result = result.replace("[", "");
        result = result.replace("]", "");

        return result;
    }

    public ArrayList<String> getArrayListFor(String name) {
        return map.get(name);
    }

    public String lookup(String name) {
        return null;
    }

    public String[] lookupNumberFor(String name2) {
        return null;
    }

    public String reverseLookup(String s) {
        return null;
    }

    public String[] remove(String name, String s) {
        return null;
    }

    public String listNames() {
        return null;
    }

}
