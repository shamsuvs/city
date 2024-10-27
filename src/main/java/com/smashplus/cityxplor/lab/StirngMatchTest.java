package com.smashplus.cityxplor.lab;

public class StirngMatchTest {
    public static void main(String args[]){

        System.out.println(validatePattern("abcxyzckl","abc?yz?kl")); // Should be 1/3
    }


    static boolean validatePattern(String inputStr, String pattern) {
        boolean match=false;
        if(inputStr.length()==pattern.length()){
            match=true;
        }
        if(inputStr.equals(pattern))
        match=true;
        String[] patternArray = new String[10];
        if(pattern.contains("?")){
            patternArray=pattern.split("\\?");
        }else if(pattern.contains("*")){
            patternArray=pattern.split("\\*");
        }

        int index=0;
        System.out.println(inputStr);
        String sp="";
        for(String subPattern:patternArray) {
            System.out.println(subPattern);
            System.out.println(inputStr.indexOf(subPattern)+","+ subPattern.length());
            String sstring ="";
            if(inputStr.indexOf(subPattern)>-1){
                sstring  = inputStr.substring(inputStr.indexOf(subPattern), inputStr.indexOf(subPattern)+subPattern.length());//abc?bc?yz  [abc] [bc] [yz]  abcabcxyz
            }

            System.out.println(sstring);
            if (!sstring.equals(subPattern)) {
                match = false;
                break;
            } else {
                match = true;
            }
        }
        return match;
    }

}
/*
Hi..
        hellow


        patten: ? can mact any single char
        pattern: * it can macth anychars

        input string: abcayzyz
        patter type1 : abc?yz --> abc ? yz
        patter type2: ab?yz
        patter type3: ab*x*yz
        patter type4: ab*x?yz

        boolean validatePattern(String inputStr, String pattern) {
        Pattern p= pattern.compile(pattern);
        Matchern mat=pattern.matcher(i
        return true;
        }

        return match;
        }
*/
