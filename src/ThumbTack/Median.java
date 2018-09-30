package ThumbTack;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Median {
    
    Queue<Integer> maxHeap;
    Queue<Integer>minHeap;
    public Median() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
        else{
            return maxHeap.peek();
        }
    }
}
