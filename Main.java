package org.kpi.fpm.lab_2;

public class Main{
    public static void main(String[] args) {
        LabTest.test();
        //System.out.println(Add("//[*][**]\n1.1**2.5*3.2**4*1002**1"));
    }
    public static double Add(String numbers) {
        double d = 0;
        int n = 0;
        String neg = "";
        if (numbers.isEmpty()) {
            return d;
        }
        else if (numbers.startsWith("//")) {
            String delimiter = "";
            if (numbers.contains("[") && numbers.contains("]") && numbers.contains("][")) {
                String[] str = numbers.split("\n");
                String s = "";
                for(int i = 0; i< str.length; i++){
                    if(i > 0) {
                        s += str[i]+" ";
                    }
                }
                String an_s = "";
                for(int i = 0; i < s.length(); i++){
                    if(Character.isDigit(s.charAt(i)) || s.charAt(i) == '.' || s.charAt(i) == '-'){
                        an_s += s.charAt(i);
                    } else{
                        an_s +=',';
                    }
                }
                an_s = an_s.replaceAll("(,)\\1+", ",");
                String[] num = an_s.split(",");
                for(String st : num){
                    if (Double.parseDouble(st) < 0) {
                        n++;
                        neg += Double.parseDouble(st) + " ";
                    }
                    if (Double.parseDouble(st) < 1001) {
                        d += Double.parseDouble(st);
                    }
                }
            }
            else if (numbers.contains("[") && numbers.contains("]")) {
                numbers = numbers.replace("//[", "");
                for (int i = 0; i < numbers.length(); i++) {
                    if (numbers.charAt(i) != ']') {
                        delimiter += numbers.charAt(i);
                    } else {
                        numbers = numbers.replace(delimiter + "]\n", "");
                        break;
                    }
                }
                numbers = numbers.replace("\n", ",");
                numbers = numbers.replace(delimiter, ",");
                for (String s : numbers.split(",|\n")) {
                    if (Double.parseDouble(s) < 0) {
                        n++;
                        neg += Double.parseDouble(s) + " ";
                    }
                    if (Double.parseDouble(s) < 1001) {
                        d += Double.parseDouble(s);
                    }
                }
            }
            else if (!(numbers.contains("[") && numbers.contains("]"))) {
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.replace("//" + delimiter + "\n", "");
                numbers = numbers.replace(delimiter, ",");
                for (String s : numbers.split(",|\n")) {
                    if (Double.parseDouble(s) < 0) {
                        n++;
                        neg += Double.parseDouble(s) + " ";
                    }
                    if (Double.parseDouble(s) < 1001) {
                        d += Double.parseDouble(s);
                    }
                }
            }

            if (n > 0) {
                throw new RuntimeException("negatives not allowed: " + neg.trim());
            } else {
                return d;
            }
        }
        else {
            for (String s : numbers.split(",|\n")) {
                if (Double.parseDouble(s) < 0) {
                    n++;
                    neg += Double.parseDouble(s) + " ";
                }
                if (Double.parseDouble(s) < 1001) {
                    d += Double.parseDouble(s);
                }
            }
            if (n > 0) {
                throw new RuntimeException("negatives not allowed: " + neg.trim());
            } else {
                return d;
            }
        }
    }
}