package com.wrixton.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//There is a game called football where there is a score
//return ways that score could be made

//This is similar to the combinations of dollar value
public class FootballScores {

    private static Integer[] scores = {2, 3, 6, 7, 8};
    private static Set<Integer> scoreSet = new HashSet<Integer>(Arrays.asList(scores));
    private static int MIN = 2;

    public static int getWays(int finalScore) {
        if (finalScore < MIN) {
            return 0;
        } else if (scoreSet.contains(finalScore)) {
            return 1;
        } else {
            return getWays(finalScore - scores[0]) + getWays(finalScore - scores[1]) + getWays(finalScore - scores[2])
                    + getWays(finalScore - scores[3]) + getWays(finalScore - scores[4]);
        }
    }

}
