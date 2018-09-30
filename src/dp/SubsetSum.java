package dp;

public class SubsetSum {

    public static void main(String args[]) {
        
        SubsetSum ss = new SubsetSum();

        int arr1[] = {2, 3, 4};
        System.out.print(ss.subsetSum(arr1, 8));
    }

    private  boolean subsetSum(int[] arr1, int sum) {
   
        boolean table[][] = new boolean[arr1.length+1][sum+1];
        
        for(int i=0;i<=arr1.length;i++){
            table[i][0]=true;
        }
        
        for(int i=1;i<=arr1.length;i++){
            for(int j=1;j<=sum;j++){
                
                if(arr1[i-1]>j){
                    table[i][j]=table[i-1][j];
                }
                else{
                    table[i][j]= table[i-1][j-arr1[i-1]]||table[i-1][j];
                }
                
            }
        }
        
        return table[arr1.length][sum];
        
    }

}
