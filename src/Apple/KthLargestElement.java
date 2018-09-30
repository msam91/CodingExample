package Apple;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

    public static void main(String args[]){
        int a [] = {3,30,2,4,15,10};
        getKthLargest(a,2);   
        getUsingPrio(a,5);  
    }

    private static void getKthLargest(int a[], int k) {
        BinaryMaxHeap<String>mh = new BinaryMaxHeap<String>();
        int data = 0;
        for(int i=0;i<a.length;i++){
            mh.add(a[i], "manas");
        }
        
        for(int i=0;i<k;i++){
            data=mh.max().weight;
            mh.removeMax();
        }
        System.out.println(data);
    }
    
    private static void getUsingPrio(int a[], int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int data = 0;
        for(int i=0;i<a.length;i++){
            pq.add(a[i]);
        }
  
        for(int i=0;i<k;i++){
            data = pq.poll();
        }
        System.out.print(data);
    }
}
