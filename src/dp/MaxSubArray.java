package dp;

public class MaxSubArray {

    public static void main(String args[]) {

        MaxSubArray m = new MaxSubArray();
        int a[] = { 1, 2, -3,-5,4, 5, 6, -1, 3 };
        m.maxSubArray(a);

    }

    private void maxSubArray(int[] a) {
       int maxSoFar =a[0];
       int maxEndingHere=0;
       int start=0;
       int end=0; 
       for(int i=0;i<a.length;i++){
           maxEndingHere = maxEndingHere+a[i];
           if(maxSoFar<maxEndingHere){
               maxSoFar=maxEndingHere;
               end =i;
           }
           if(maxEndingHere<0){
               maxEndingHere=0;
               start=i+1;
           }
       }
       System.out.println(start);
       System.out.print(end);
        
    }

}
