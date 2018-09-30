package LinkedIn;

class SolutionPerfectSquare {
    
    public static void main(String args[]){
        SolutionPerfectSquare s = new SolutionPerfectSquare();
        long startTime =System.currentTimeMillis();
        System.out.println(s.isPerfectSquare(2147483647));
        long endTime =System.currentTimeMillis();
        System.out.println(endTime-startTime);
        long startTime1 =System.currentTimeMillis();
        System.out.println(s.isPerfectSqr(2147483647));
        long endTime1 =System.currentTimeMillis();
        System.out.println(endTime1-startTime1);
    }
    public boolean isPerfectSquare(int num) {       
        
        long x = num;
      
        while (x*x > num){
        x = (x + num/x) / 2;
        }
        
        if(x*x==num){
            return true;
        }
        return false;
    }
    
    public boolean isPerfectSqr(int num) {       
     
        int i = 1;
        
        while(!(i*i>=num)){    
            i++;
        }
        if(i*i==num){
            return true;
        }
        
        return false;

    }
}
