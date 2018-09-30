package Apple;

import java.util.Arrays;

class MyList<T> {

    private int size = 0;
    private Object elements[];
    private static final int DEFAULT_SIZE = 2;

    public MyList() {
        elements = new Object[DEFAULT_SIZE];
    }
    
    public void add(T t){
        
        if(size==DEFAULT_SIZE){
            increaseCap();
        }
        elements[size++]=t;
    }

    private void increaseCap(){
        int newSize = size*2;
        elements = Arrays.copyOf(elements, newSize);
    }
    
    @SuppressWarnings("unused")
    public T get(int index){
        if(index>=size || index<0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size );
        }
        return (T) elements[index];
    }
    
}

public class UseList{
    
    public static void main(String args[]){
        MyList<Integer>myList = new MyList<Integer>();
        myList.add(5);
        myList.add(5);
        myList.add(6);
        myList.get(4);
    }
}
