package org.example;

import java.util.*;


public class Main {

    public int romanToInt(String s) {
        int num = 0;
        for (int x = s.length() - 1; x >= 0; x--) {
            switch (s.charAt(x)) {
                case 'M' -> num += 1000;
                case 'D' -> {
                    if (num >= 1000) num -= 1000;
                    else num += 500;
                }
                case 'C' -> {
                    if (num >= 500) num -= 500;
                    else num += 100;
                }
                case 'L' -> {
                    if (num >= 100) num -= 100;
                    else num += 50;
                }
                case 'X' -> {
                    if (num >= 50) num -= 10;
                    else num += 10;
                }
                case 'V' -> {
                    if (num >= 10) num -= 5;
                    else num += 5;
                }
                case 'I' -> {
                    if (num >= 5) num -= 1;
                    else num += 1;
                }
            }
        }
        return num;
    }


    public String mergeAlternately(String word1, String word2) {
        StringBuilder word = new StringBuilder();
        int wLength;
        if (word1.length() > word2.length()) wLength = word1.length();
        else wLength = word2.length();
        for (int i = 0; i < wLength; i++) {
            if (word1.length() > i) word.append(word1.charAt(i));
            if (word2.length() > i) word.append(word2.charAt(i));
        }
        return word.toString();
    }

    /*public String gcdOfStrings(String str1, String str2) {
        String content = "";
        if (str1.contains(str2)) {
            content = str1.replaceFirst(str2, "");
        }
        return content;
    }*/

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> kidsWithMost = new ArrayList<>();
        List<Boolean> temp = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            for (int j = 0; j < candies.length; j++) {
                if (i != j) {
                    if ((candies[i] + extraCandies) >= candies[j]) temp.add(true);
                    else temp.add(false);
                }
            }
            if (temp.contains(false)) kidsWithMost.add(false);
            else kidsWithMost.add(true);
            temp.clear();
        }
        return kidsWithMost;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean canPlace = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        if (n == 0) canPlace = true;
        return canPlace;
    }

    public String reverseVowels(String s) {
        StringBuilder vowels = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                vowels.append(c);
            }
        }
        StringBuilder str = new StringBuilder(s);
        int j = vowels.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                str.setCharAt(i, vowels.charAt(j--));
            }
        }
        return str.toString();
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        String revWord = "";

        for (int i = words.length - 1; i >= 0; i--) {
            if (i == 0) revWord += words[0];
            else revWord += words[i] + " ";
        }
        return revWord;
    }

    public int[] moveZeroes(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[x] = nums[i];
                x++;
            }
        }
        for (int j = x; j < nums.length; j++) {
            nums[j] = 0;
        }
        return nums;
    }


    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int operations = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                operations++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return operations;
    }


    public String removeStars(String s) {
        StringBuilder str = new StringBuilder(s);
        StringBuilder end = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '*'){
                end.deleteCharAt(end.length()-1);
            } else end.append(str.charAt(i));
        }
        return end.toString();
    }

    public int largestAltitude(int[] gain) {
        int highest = 0;
        int temp = 0;
        for (int i = 0; i < gain.length; i++) {
            temp += gain[i];
            if(temp >highest) highest = temp;
        } return highest;
    }


    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> temp1 = new HashSet<>();
        HashSet<Integer> temp2 = new HashSet<>();
        List<List<Integer>> differences = new ArrayList<>();
        differences.add(new ArrayList<>());
        differences.add(new ArrayList<>());

        for (int num:nums1) temp1.add(num);
        for (int num:nums2) temp2.add(num);

        for (int num : temp1) {
            if (!temp2.contains(num)) differences.get(0).add(num);
        }

        for (int num : temp2) {
            if (!temp1.contains(num)) differences.get(1).add(num);
        }


        return differences;
    }


    public static void main(String[] args) {
        Main main = new Main();

        //System.out.println(main.romanToInt("MCMXCIV"));

        //System.out.println(main.mergeAlternately("abs","W"));

        //System.out.println(main.gcdOfStrings("ABCABC","AB"));


        //System.out.println(main.reverseVowels("aTestu"));

        //System.out.println(main.reverseWords(" This is a test to test") + "/");

        //System.out.println(Arrays.toString(main.moveZeroes(new int[]{0, 0, 4, 5, 0, 3,4,6,5,0})));

        //System.out.println(main.removeStars("erasee******"));

        //System.out.println(main.letterCombinations("234"));

        //System.out.println(main.largestAltitude(new int[]{-5,1,5,0,-7}));

        //System.out.println(main.findDifference(new int[]{1,2,3,4},new int[]{1,2,3}).stream().toList());

    }
}