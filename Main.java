package org.kpi.fpm.lab_2;

public class Main{
    public static void main(String[] args) {
        LabTest.test();
    }
    public static int Add(String numbers) {
        int d = 0;
        int n = 0;
        String neg = "";
        if (numbers.isEmpty()) {
            return d;
        }
        else if (numbers.startsWith("//")) {
            String delimiter = "";
            if (numbers.contains("[") && numbers.contains("]") && numbers.contains("][")) {
                numbers = numbers.replace("//[", "").replace("][", ",");
                for (int i = 0; i < numbers.length(); i++) {
                    if (numbers.charAt(i) != ']') {
                        delimiter += numbers.charAt(i);
                    } else {
                        numbers = numbers.replace(delimiter + "]\n", "");
                        break;
                    }
                }
                String[] delimiters = delimiter.split(",");
                numbers = numbers.replace("\n", ",");
                for(int i = 0; i < delimiters.length; i++){
                    numbers = numbers.replace(delimiters[i], ",");
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
            }
            else if (!(numbers.contains("[") && numbers.contains("]"))) {
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.replace("//" + delimiter + "\n", "");
                numbers = numbers.replace(delimiter, ",");
            }
            for (String s : numbers.split(",|\n")) {
                if (Integer.parseInt(s) < 0) {
                    n++;
                    neg += Integer.parseInt(s) + " ";
                }
                if (Integer.parseInt(s) < 1001) {
                    d += Integer.parseInt(s);
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
                if (Integer.parseInt(s) < 0) {
                    n++;
                    neg += Integer.parseInt(s) + " ";
                }
                if (Integer.parseInt(s) < 1001) {
                    d += Integer.parseInt(s);
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