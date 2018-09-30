package goldManSachs;

public class VectorDotProduct {

    public static void main(String args[]){
        int vect_A[] = { 3, -5, 4 };
        int vect_B[] = { 2, 6, 5 };
        System.out.println("dot Product:"+ getDotProduct(vect_A,vect_B));
    }

    private static int getDotProduct(int[] vect_A, int[] vect_B) {
        int product = 0;
        
        // Loop for calculate cot product
        for (int i = 0; i < vect_A.length; i++){
     
            product = product + vect_A[i] * vect_B[i];
        }
        return product;
    }
    
    private static int[] getDotProduct(int[] vect_A, int[] vect_B,int[] c_product) {
        c_product[0]= vect_A[1]*vect_B[2]-vect_A[2]*vect_B[1];
        c_product[1]= vect_A[0]*vect_B[2]-vect_A[2]*vect_B[0];
        c_product[2]=vect_A[0]*vect_B[1]-vect_A[1]*vect_B[0];
        
        return c_product;
        
      
    }
}
