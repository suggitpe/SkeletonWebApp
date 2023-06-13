package com.develogical;

import java.util.HashMap;
import java.util.Map;

public class QueryProcessor {

    private Map<String, String> roots;

    public QueryProcessor() {
        roots = new HashMap();
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

        return "";
    }


}
