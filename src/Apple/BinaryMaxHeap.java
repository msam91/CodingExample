package Apple;

import java.util.ArrayList;
import java.util.List;


public class BinaryMaxHeap<T> {

    List<Node>allNodes = new ArrayList<Node>();
    
    class Node{
        int weight;
        T data;
    }
    
    public void add(int weight, T data){
        Node n = new Node();
        n.weight=weight;
        n.data= data;
        allNodes.add(n);
        
        int heapSize = allNodes.size();
        int currentIndex = heapSize-1;
        int parentIndex = (currentIndex-1)/2;
        
        
        while (parentIndex>=0){
            Node parentNode = allNodes.get(parentIndex);
            Node currentNode = allNodes.get(currentIndex);           
            if(parentNode.weight<currentNode.weight){
                swap(parentNode,currentNode);
                currentIndex =parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            }
            else{
                break;
            }
        }
        
    }
    
    public void MaxHeapify(int parentIndex){
        int leftChildIndex = 2*parentIndex+1;
        int rightChildIndex = 2*parentIndex+2;
        
        int higherWeightIndex=0;
        
        if(leftChildIndex<allNodes.size() && allNodes.get(leftChildIndex).weight>allNodes.get(parentIndex).weight){
            higherWeightIndex = leftChildIndex;
        }
        if (rightChildIndex<allNodes.size() && allNodes.get(rightChildIndex).weight>allNodes.get(higherWeightIndex).weight){
            higherWeightIndex = rightChildIndex;
        }
        if(higherWeightIndex==0){
            higherWeightIndex =parentIndex;
        }
        
        if(higherWeightIndex != parentIndex){
            swap(allNodes.get(higherWeightIndex), allNodes.get(parentIndex));
            MaxHeapify(higherWeightIndex);
        }
        
    }
    
    
    private void swap(Node node1,Node node2){
        int weight = node1.weight;
        T data = node1.data;
        
        node1.data = node2.data;
        node1.weight = node2.weight;
        
        node2.data = data;
        node2.weight = weight;
    }
    
    public void  removeMax(){
        Node firstNode = allNodes.get(0);
        Node lastNode = allNodes.get(allNodes.size()-1);
        swap(firstNode, lastNode);
        allNodes.remove(allNodes.size()-1);
        MaxHeapify(0);
        
    }
    
    public Node max(){
        return allNodes.get(0);
    }
    
    public boolean empty(){
        return allNodes.size() == 0;
    }
    
    public void printHeap(){
        for(Node n : allNodes){
            System.out.println(n.weight + " " + n.data);
        }
    }
  
    
   public static void main(String args[]){
       BinaryMaxHeap<String> heap = new BinaryMaxHeap<String>();
       heap.add(3, "manas");
       heap.add(4, "akshay");
       heap.add(8, "onkar");
       heap.add(10, "akriti");
       heap.add(5, "deepu");
       heap.add(6, "sfit");
       heap.printHeap();
       heap.removeMax();
       heap.printHeap();    
       
   }
   
   
    
}
