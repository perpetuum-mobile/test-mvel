package com.egar.test;

import java.util.HashSet;

/**
 * User: nchebykina
 * Date: 02.08.12
 * Time: 13:35
 */
public class Constants {
    public static final String[] types = {"AA", "BB", "CC", "DD", "EE", "FF"};
    public static final String[] statuses = {"U", "V", "W", "X", "Y", "Z"};
    public static final String[] instrumentTypeIds = {"B", "E", "F", "O"};
    public static final String[] typePairs =  {"\"AA\", \"BB\"", "\"AA\", \"CC\"",
                                                "\"AA\", \"DD\"", "\"AA\", \"EE\"",
                                                "\"AA\", \"FF\"", "\"BB\", \"CC\"",
                                                "\"BB\", \"DD\"", "\"BB\", \"EE\"",
                                                "\"BB\", \"FF\"", "\"CC\", \"DD\"",
                                                "\"CC\", \"EE\"", "\"CC\", \"FF\"",
                                                "\"DD\", \"EE\"", "\"DD\", \"FF\"",
                                                "\"EE\", \"FF\"",};
    public static final String[] instrumentTypeIdPairs = {"\"B\",\"E\"", "\"E\",\"F\"", "\"F\",\"O\"", "\"B\",\"F\"", "\"B\",\"O\"", "\"E\",\"O\""};
    public static HashSet<Integer> getRandoms(int min, int max, int nNums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nNums; i++) {
            int res;
            do {
                res = min + (int)(Math.random()*((max - min)+1));
            } while(set.contains(res));
            set.add(res);
        }
        return set;
    }

}
