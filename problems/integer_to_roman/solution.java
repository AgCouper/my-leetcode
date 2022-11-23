class Solution {
    // according to the problem discription, 1 <= num <= 3999
    private static String[] lookupTable = new String[] {
        // padding to simplify indices calculation
        "", 

        // 1 to 9
        "I",
        "II",   
        "III", 
        "IV", 
        "V", 
        "VI", 
        "VII", 
        "VIII", 
        "IX",

        "",

        // 10 to 90
        "X", 
        "XX", 
        "XXX", 
        "XL", 
        "L", 
        "LX", 
        "LXX", 
        "LXXX", 
        "XC", 

        "",

        // 100 to 900
        "C", 
        "CC", 
        "CCC", 
        "CD", 
        "D", 
        "DC", 
        "DCC", 
        "DCCC", 
        "CM", 

        "",

        // 1000 to 4000
        "M", 
        "MM", 
        "MMM", 
        "MMMM"
    };

    public String intToRoman(int num) {
        // 1234
        // 4 
        int n1 = num % 10;
        num = num - n1;
        
        // 3
        int n2 = num % 100;
        num = num - n2;

        // 2
        int n3 = num % 1000;

        // 1
        int n4 = num - n3;

        return new StringBuilder(n4 == 0? "" : lookupTable[30 + n4 / 1000])
            .append(n3 == 0? "" : lookupTable[20 + n3 / 100])
            .append(n2 == 0? "" : lookupTable[10 + n2 / 10])
            .append(n1 == 0? "" : lookupTable[n1])
            .toString();
    }
}