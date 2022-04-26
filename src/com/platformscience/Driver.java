package com.platformscience;

import java.util.Arrays;
import java.util.List;

/**
 * @author Eduardo Sanabia
 */
public class Driver {

    private List<Character> vowelsList = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
    private double vowels = 0;
    private double consonants = 0;
    private char[] driverNameArr;

    public Driver(String name)
    {
        this.driverNameArr = name.toCharArray();
        this.setVowels(name);
        this.setConsonants(name);
    }

    private void setVowels(String driverName) {
        for (char c : driverNameArr) {
            if (vowelsList.contains(c)) {
                vowels++;
            }
        }
    }

    public double getVowels() {
        return vowels * 1.5;
    }

    private void setConsonants(String driverName) {
        String driverNameClean = driverName.replaceAll("\\s+","");
        driverNameClean.trim();
        consonants = driverNameClean.length() - vowels;
    }

    public double getConsonants() {
        return consonants;
    }
}

