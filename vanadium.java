
/* 
first attempt
https://codility.com/programmers/task/winter_lights/
in java, with an awfully slow running time. 
the c version runs a lot faster. 
*/ 

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(String S) {
        List<List<Integer>> rel = new ArrayList<List<Integer>>(2);
        for(int i = 0; i < 2; ++i)
            rel.add(new ArrayList<Integer>(Collections.nCopies(1024, 0)));
        int index = 1 << Character.getNumericValue(S.charAt(0));
        rel.get(0).set(index, 1);
        int sum = 1;
        for(int k = 1; k < S.length(); ++k) {
            index = 1 << Character.getNumericValue(S.charAt(k));
            for(int i = 0; i < 1024; ++i)
                rel.get(k & 1).set(i, rel.get((k + 1) & 1).get(i ^ index));
            rel.get(k & 1).set(index, (rel.get(k & 1).get(index) + 1) % 1000000007);
            for(int i = 0; i < 10; ++i) {
            	sum += rel.get(k & 1).get(1 << i);
                sum %= 1000000007;
            }
            sum += rel.get(k & 1).get(0) % 1000000007;
        }
        return sum;
    }
}
