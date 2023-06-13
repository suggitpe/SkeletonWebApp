package com.develogical;

import java.util.HashMap;
import java.util.Map;

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
//            System.out.println("foo = " + foo);
            return foo.toString();
        }

        // What is 6 multiplied by 35?
        if (query.contains("What is ") && query.contains(" multiplied by ")) {
            String[] arr = query.substring(0, query.length() - 1).split(" ");
//            System.out.println(arr[2]);
            Integer foo = parseInt(arr[2]) + parseInt(arr[5]);
//            System.out.println("foo = " + foo);
            return foo.toString();
        }

        if(query.toLowerCase().contains("which of the following numbers is the largest:")){
//            System.out.println("#######");
            String[] numbers = query.substring(0, query.length()-1).split(":")[1].split(", ");
//            System.out.println("----> " + numbers);
            String max = "0";
            for(String number: numbers){
                if(parseInt(max) < parseInt(number.trim())){
                    max = number.trim();
                }
            }
            System.out.println(numbers.length);
            return max;
        }

        if(query.toLowerCase().contains("which of the following numbers is both a square and a cube:")){
            System.out.println()
        }



        return "";
    }


}
