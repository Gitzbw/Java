public class run {
    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }
}

class Solution {
    public  int romanToInt(String s) {
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            if(getValue(s.charAt(i-1)) < getValue(s.charAt(i)))
            {
                sum -= getValue(s.charAt(i-1));
            }
            else
            {
                sum += getValue(s.charAt(i-1));
            }
        }
        return sum+getValue(s.charAt(s.length()-1));
    }


    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}


