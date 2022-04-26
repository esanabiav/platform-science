package com.platformscience;

import java.util.*;

/**
 * @author Eduardo Sanabia
 */
public class Main {

    static List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');

    public static void main(String[] args) {
        List<String> addresses = new ArrayList<>();
        List<String> drivers = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Number of street names and drivers: ");
        int fileSize = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter " + fileSize + " addresses: ");
        getInput(addresses, fileSize, sc);

        System.out.println("Enter " + fileSize + " drivers: ");
        getInput(drivers, fileSize, sc);

        double ssFinalValue = getMaxSsByDriver(addresses, drivers);
        System.out.println("Final SS: " + ssFinalValue);
    }

    static double getMaxSsByDriver(List<String> addresses, List<String> drivers) {
        double ssFinalValue = 0;
        for(String driver: drivers) {
            Driver currentDriver = new Driver(driver);
            double ssValue = 0;
            String addressId = null;
            for(String address: addresses) {
                if(address.length() % 2 == 0) {
                    double vowelsCount = currentDriver.getVowels();
                    if (address.length() == driver.length()) {
                        vowelsCount = vowelsCount * 1.5;
                    }
                    if (vowelsCount > ssValue) {
                        ssValue = vowelsCount;
                        addressId = address;
                    }
                }
                else {
                    double consonantCount = currentDriver.getConsonants();
                    if (address.length() == driver.length()) {
                        consonantCount = consonantCount * 1.5;
                    }
                    if (consonantCount > ssValue) {
                        ssValue = consonantCount;
                        addressId = address;
                    }
                }
            }
            System.out.println(driver + " - " + addressId);
            addresses.remove(addressId);
            ssFinalValue += ssValue;
        }
        return ssFinalValue;
    }

    static void getInput(List<String> inputValue, int fileSize, Scanner sc) {
        for (int i = 0; i < fileSize; i++) {
            String address = sc.nextLine();
            inputValue.add(address);
        }
    }
}

