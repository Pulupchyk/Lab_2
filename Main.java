package org.kpi.fpm.lab_2;

public class Main{
    public static void main(String[] args) {
        LabTest.test();
    }
    public static int Add(String numbers) {
        int d = 0;
        int n = 0;
        String neg = "";
        if(numbers.isEmpty()){
            return d;
        }
        if(numbers.startsWith("//")){
            String delimiter = Character.toString(numbers.charAt(2));
            numbers = numbers.replace("//"+delimiter+"\n", "");
            numbers = numbers.replace(delimiter, ",");
            for(String s : numbers.split(",|\n")){
                if (Integer.parseInt(s) < 0) {
                    n++;
                    neg += Integer.parseInt(s) + " ";
                }
                else {
                    d += Integer.parseInt(s);
                }
            }
            if (n > 0) {
                throw new RuntimeException("negatives not allowed: " + neg.trim());
            }
            else {
                return d;
            }
        }
        for(String s : numbers.split(",|\n")){
            if (Integer.parseInt(s) < 0) {
                n++;
                neg += Integer.parseInt(s) + " ";
            }
            else {
                d += Integer.parseInt(s);
            }
        }
        if (n > 0) {
            throw new RuntimeException("negatives not allowed: " + neg.trim());
        }
        else {
            return d;
        }
    }
}