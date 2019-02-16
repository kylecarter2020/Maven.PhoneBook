package com.zipcodewilmington.phonebook;

import javafx.beans.binding.StringBinding;

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
        String result = "";

        result += map.get(name).toString() + "\n";

        result = result.replace("[", "");
        result = result.replace("]", "");

        return result;
    }


    public String reverseLookup(String number) {
        String result = "";
        boolean found = false;

        for (String key : map.keySet()) {
            if(map.get(key).contains(number)) {
                result += key + "\n";
                found = true;
            }
        }
        if(!found)
        {
            result += "No entries found.\n";
        }
        return result;
    }

    public void remove(String name, String number) {
        ArrayList<String> nums = map.get(name);
        nums.remove(number);
        map.put(name, nums);
    }

    public String listNames() {

        String result = "";

        for (String key : map.keySet()) {
            result += key + "\n";
        }

        return result;
    }

}
