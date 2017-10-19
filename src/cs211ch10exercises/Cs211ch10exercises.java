/*
 * Textbook chapter 10 exercises recommended by professor
 * Created by David Johnson, October 2, 2017
 * for CS211 course, Bellevue College
 */
package cs211ch10exercises;

import java.util.ArrayList;

public class Cs211ch10exercises {

    public static ArrayList<String> strings = new ArrayList<>();
    public static ArrayList<Integer> numbers = new ArrayList<>();
    
    public static void main(String[] args) {
        strings.add("to");
        strings.add("be");
        strings.add("or");
        strings.add("not");
        strings.add("to");
        strings.add("be");
        strings.add("this");
        strings.add("lots");
        strings.add("Java");
        strings.add("Hamlet");
        
        System.out.println(strings);
        swapPairs(strings);
        System.out.println(strings);
        
        removeShorterStrings(strings);
        System.out.println(strings);
        
        clump(strings);
        System.out.println(strings);
        
        doubleList(strings);
        System.out.println(strings);
        
        removeInRange(strings, "coarse", "index");
        System.out.println(strings);
        
        markLength4(strings);
        System.out.println(strings);
        
        numbers.add(3);
        numbers.add(8);
        numbers.add(92);
        numbers.add(4);
        numbers.add(2);
        numbers.add(17);
        numbers.add(9);
        
        System.out.println(numbers);
        minToFront(numbers);
        System.out.println(numbers);
    }

    //Exercise #2
    public static void swapPairs(ArrayList<String> strings) {
        int length = strings.size();
        int i = 0;
        String temp;
        
        if(length == 0) {
            return;
        }
        while(i < length - 3) {
            temp = strings.get(i + 1);
            strings.set(i + 1, strings.get(i));
            strings.set(i, temp);
            i += 2;
        }

        if(i + 1 <= length - 1) {
            temp = strings.get(i + 1);
            strings.set(i + 1, strings.get(i));
            strings.set(i, temp);
        }
    }
    
    //Exercise #4
    public static void doubleList(ArrayList<String> strings) {
        for(int i = 0; i < strings.size(); i += 2) {
            strings.add(i + 1, strings.get(i));
        }
    }
    
    //Exercise #6
    public static void minToFront(ArrayList<Integer> nums) {
        int min;
        int minIndex;
        
        if(nums.isEmpty()) {
            return;
        }
        
        min = nums.get(0);
        for(int num: nums) {
            if(num < min) {
                min = num;
            }
        }
        
        nums.add(0, min);
        nums.remove(nums.lastIndexOf(min));
    }
    
    //Exercise 10
    public static void removeInRange(ArrayList<String> strings, String begin, String end) {        
        for(int i = strings.size() - 1; i >= 0; i--) {
            if(strings.get(i).compareToIgnoreCase(begin) > 0 && strings.get(i).compareToIgnoreCase(end) < 0) {
                strings.remove(strings.lastIndexOf(strings.get(i)));
            }
        }
    }
    
    //Exercise 12
    public static void markLength4(ArrayList<String> strings) {
        for(int i = strings.size() - 1; i >= 0; i--) {
            String tester = strings.get(i);
            if(!"****".equals(tester)) {
                if(tester.length() == 4) {
                    strings.add(i, "****");
                }
            }
        }
    }
    
    //Exercise 14
    public static void removeShorterStrings(ArrayList<String> strings) {
        int oddSize = strings.size() % 2;
        int i = strings.size() - 1;
        
        while(i >= 0) {
            if(oddSize == 1 && i == strings.size() - 1) {
                i--;
            } else {
                if(strings.get(i).length() < strings.get(i - 1).length()) {
                    strings.remove(i);
                } else {
                    strings.remove(i - 1);
                }
                i -= 2;
            }
        }
    }
    
    //Exercise 16
    public static void clump(ArrayList<String> strings) {
        int oddSize = strings.size() % 2;
        int i = strings.size() - 1;
        
        while(i >= 0) {
            if(oddSize == 1 && i == strings.size() - 1) {
                i--;
            } else {
                strings.add(i + 1, "(" + strings.get(i - 1) + " " + strings.get(i) + ")");
                strings.remove(i);
                strings.remove(i - 1);
                i -= 2;
           }
        }
    }
}
