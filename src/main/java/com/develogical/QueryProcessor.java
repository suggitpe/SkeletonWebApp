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
            return "Mellow Yellow";
        }

        if (query.contains("What is ") && query.contains(" plus ")) {
            String[] arr = query.split(" ");
            System.out.println(arr[2]);
            Integer foo = parseInt(arr[2]) + parseInt(arr[4]);
            System.out.println("foo = " + foo);
            return foo.toString();
        }

        if (query.contains("Which of the following numbers is the largest")) {
            System.out.println("" + query.split(":"));
            String numbers = query.split(":")[1];

        }


        return "";
    }


}
