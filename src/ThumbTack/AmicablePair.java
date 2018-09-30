package ThumbTack;

import java.util.*;

class AmicablePair {

    public class Index {

        int currentIndex;
        int minDiff;

        @Override
        public String toString() {
            return "Index [currentIndex=" + currentIndex + ", minDiff=" + minDiff + "]";
        }

    }

    Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();

    public static void main(String args[]) {
        AmicablePair p = new AmicablePair();
        /*
         * Map<Integer, Integer> m = p.getAmicablePairs();
         * 
         * for (Integer key : m.keySet()) { System.out.print(key + "," +
         * m.get(key)); System.out.println(); }
         */
        // System.out.println(p.getLongestStepsNumber());
    }


    public Map<Integer, Integer> getAmicablePairs() {
        Map<Integer, Integer> amicablePairs = new HashMap<Integer, Integer>();
        for (int i = 1; i < 100000; i++) {
            int sum1 = sumOfDividers(i);
            int sum2 = sumOfDividers(sum1);
            if (sum2 == i && sum1 != sum2) {
                if (!amicablePairs.containsKey(sum2)) {
                    amicablePairs.put(sum1, sum2);
                }
            }

        }

        return amicablePairs;

    }

    public int sumOfDividers(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum;

    }

    public int getLongestStepsNumber() {

        int max = Integer.MIN_VALUE;
        int number = 0;
        int numberOfSteps = 0;

        for (int i = 1; i < 10000; i++) {
            if (!counterMap.containsKey(i)) {
                numberOfSteps = getNumberOfSteps(i, 0);
            }
            else {
                numberOfSteps = counterMap.get(i);
            }
            if (numberOfSteps > max) {
                max = numberOfSteps;
                number = i;
            }

        }
        return number;

    }

    public int getNumberOfSteps(int num, int count) {

        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            }
            else {
                num = (num * 3) + 1;
            }
            count++;
        }
        counterMap.put(num, count);
        return count;
    }

}
