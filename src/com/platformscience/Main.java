package com.platformscience;

import java.util.*;

public class Main {

    static List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');

    public static void main(String[] args) {
        List<String> addresses = new ArrayList<>();
        List<String> drivers = new ArrayList<>();
        Map<String, List<Double>> ssTotals = new HashMap<String, List<Double>>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Number of street addresses: ");
        int fileSize = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter " + fileSize + " addresses: ");
        getInput(addresses, fileSize, sc);
        System.out.println("Enter " + fileSize + " drivers: ");
        getInput(drivers, fileSize, sc);

        //          a  e  c
        // jose    [5  5  6]
        // sanabia [3  3  6]
        // muñoz   [7  7  9]
        //


        double ssFinalValue = 0;
        for(String driver: drivers) {
            double ssValue = 0;
            String addressId = null;

            for(String address: addresses) {
                if(address.length() % 2 == 0) {
                    double vowelsCount = getVowelsCount(driver);
                    if (address.length() == driver.length()) {
                        vowelsCount = vowelsCount * 1.5;
                    }
                    if (vowelsCount > ssValue) {
                        ssValue = vowelsCount;
                        addressId = address;
                    }
                }
                else {
                    double consonantCount = getConsonantCount(driver);
                    if (address.length() == driver.length()) {
                        consonantCount = consonantCount * 1.5;
                    }
                    if (consonantCount > ssValue) {
                        ssValue = consonantCount;
                        addressId = address;
                    }
                }
            }
            addresses.remove(addressId);
            ssFinalValue += ssValue;
        }
        System.out.println("Final " + ssFinalValue);
    }

    static void getInput(List<String> inputValue, int fileSize, Scanner sc) {
        for (int i = 0; i < fileSize; i++) {
            String address = sc.nextLine();
            inputValue.add(address);
        }
    }

    static double getVowelsCount(String driverName) {
        double vowelsCount = 0;
        char[] driverNameArr = driverName.toCharArray();
        for(int i=0; i<driverNameArr.length; i++){
            if(vowels.contains(driverNameArr[i])) {
                vowelsCount++;
            }
        }

        vowelsCount = vowelsCount * 1.5;
        System.out.println(vowelsCount);
        return vowelsCount;
    }

    static double getConsonantCount(String driverName ) {
        double consonantsCount = 0;
        char[] driverNameArr = driverName.toCharArray();
        for(int i=0; i<driverNameArr.length; i++){
            if(!vowels.contains(driverNameArr[i]) && driverNameArr[i] != ' ') {
                consonantsCount++;
            }
        }
        System.out.println(consonantsCount);
        return consonantsCount;
    }
}
