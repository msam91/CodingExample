package ThumbTack;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianUsingCountSort {

   int count [];
   int sum;
   int n;
    public MedianUsingCountSort() {
        count = new int[1000]; 
        sum = 0;
         n = 0;
    
    }
    
    public void addNum(int num) {
        if (num >= 1000 || num < 0) {
            return;
        }
        count[num]++;
        sum += num;
        n++;
       
    }
    public double getMean() {
        return (double)sum / n;
    }


}
