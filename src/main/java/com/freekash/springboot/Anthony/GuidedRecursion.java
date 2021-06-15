package com.freekash.springboot.Anthony;

import java.util.ArrayList;

public class GuidedRecursion {
    //keeps track of steps
    private ArrayList<String> log = new ArrayList<String>();

    public int fib (int n) {
        log.add("<strong>Process for the " + n + "th term</strong>");
        //edge case for negative numbers
        if (n < 0) {
            log.add("Negative number received, operation ended");
            return -1;
        }
        //switch statement to check for cases of 0, 1, 2, and everything else
        switch (n) {
            case 0:
                log.add("Edge case of 0, return 0");
                return 0;
            case 1:
                log.add("Case of 1, add 0 to the final result");
                return 0;
            case 2:
                log.add("Case of 2, add 1 to the final result");
                return 1;
            default:
                log.add("Value higher than 2 given: adding the " + n + "th term and " + (n-1) + "th term together");
                //recursively calls the function to find the sum of the last two terms
                return fib(n-1) + fib(n-2);
        }
    }

    //prints steps
    public String dumpLog () {
        String s = "";
        for (int i = 0; i < log.size(); i++) {
            s += log.get(i);
            s += "<br />";
        }
        return s;
    }
}
