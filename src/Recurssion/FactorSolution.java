package Recurssion;


import java.util.List;
import java.util.ArrayList;


public class FactorSolution {
   
    List<List<Integer>> lists = new ArrayList<>();
    
    public static void main(String args[]){       
        FactorSolution f = new FactorSolution();
        f.getFactors(12);
        System.out.println();
       
       
        for(int i=0;i<f.lists.size();i++){
          f.printList(f.lists.get(i));
            System.out.println();
        }
    }

    public List<List<Integer>> getFactors(int n) {
        List<Integer> tempList = new ArrayList<Integer>();
        getFactors(n, tempList, 2);
        return lists;
    }

    public void getFactors(int n, List<Integer> tempList, int startFactor) {
        if (n <= 1) {
            if (tempList.size() > 0)
                lists.add(new ArrayList<Integer>(tempList));
        }
        else {
            for (int i = startFactor; i <=n; i++) {
                if (n % i == 0) {
                    tempList.add(i);
                    getFactors(n / i, tempList, i);
                    tempList.remove(tempList.size() - 1);
             
                }
            }
        }

    }
    
    public void printList(List<Integer>list){
       for(int i=0;i<list.size();i++){
           System.out.print(list.get(i)+" ");
       }
    }

}
