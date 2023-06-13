package com.develogical;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class QueryProcessor {

    private final Map<String, String> roots = new HashMap<>();
    private final Map<String, String> squares = new HashMap<>();

    public QueryProcessor() {
        roots.put("4", "2");
        roots.put("9", "3");
        roots.put("16", "4");
        roots.put("25", "5");
        roots.put("36", "6");


    }


    public String process(String query) {

        System.out.println("Received query:" + query);

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
                    + "English poet, playwright, and actor, widely regarded as the greatest "
                    + "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("your name")) {
            return "Mellow Yellow The Second";
        }

        if (query.contains("What is ") && query.contains(" plus ")) {
            String[] arr = query.substring(0, query.length() - 1).split(" ");
            System.out.println(arr[2]);
            Integer foo = parseInt(arr[2]) + parseInt(arr[4]);
            return foo.toString();
        }

        if (query.contains("What is ") && query.contains(" minus ")) {
            String[] arr = query.substring(0, query.length() - 1).split(" ");
            System.out.println(arr[2]);
            Integer foo = parseInt(arr[2]) - parseInt(arr[4]);
            return foo.toString();
        }

        if (query.contains("What is ") && query.contains(" multiplied by ")) {
            String[] arr = query.substring(0, query.length() - 1).split(" ");
            Integer foo = parseInt(arr[2]) * parseInt(arr[5]);
            return foo.toString();
        }

        if(query.toLowerCase().contains("which of the following numbers is the largest:")){
            String[] numbers = query.substring(0, query.length()-1).split(":")[1].split(", ");
            String max = "0";
            for(String number: numbers){
                if(parseInt(max) < parseInt(number.trim())){
                    max = number.trim();
                }
            }
            System.out.println(numbers.length);
            return max;
        }

        if(query.toLowerCase().contains("which of the following numbers is both a square and a cube")){
            String[] numbers = query.substring(0, query.length()-1).split(":")[1].split(", ");
            for(String number: numbers){
                int check = parseInt(number.trim());
                if(isSquareAndCube(check))
                    return number.trim();
            }
            return "0";
        }

        //Which of the following numbers are primes: 74, 59, 70, 61, 94?
        if(query.toLowerCase().contains("which of the following numbers are primes")){
            String[] numbers = query.substring(0, query.length()-1).split(":")[1].split(", ");
            for(String number: numbers){
                int check = parseInt(number.trim());
                if(isPrime(check))
                    return number.trim();
            }
            return "0";
        }

        return "";
    }

    boolean isPrime(int check){
        return check > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(check))
                .noneMatch(n -> (check % n == 0));
    }

    boolean isSquareAndCube(int check){
        return isSquare(check) && isCube(check);
    }

    boolean isSquare(int check){
        int x = (int) Math.sqrt(check);
        if(Math.pow(x,2) == check){
            return true;
        }
        return false;
    }

    boolean isCube(int check){
        int n = (int) Math.round(Math.pow(check, 1.0/3.0));
        return Math.pow(n,3) == check;
    }


}
