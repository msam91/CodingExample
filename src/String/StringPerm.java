package String;

public class StringPerm {

    public static void main(String args[]){
        
    String abc = "abc";
    char a [] =abc.toCharArray();
    stringPerm(a,0,a.length);
    
    }
    
    public static void stringPerm(char a[],int k,int length){
        if(k== length-1){
            for(int i=0;i<length;i++){
                System.out.print(a[i]);
            }
            System.out.println();
        }else{
            for(int i=k;i<length;i++){
                swap(a,k,i);
                stringPerm(a,k+1,length);
                swap(a,k,i);
            }
        }
    }
    
    public static void swap(char a[],int level,int i){
        char temp = a[level];
        a[level]=a[i];
        a[i]=temp;
    }

}
