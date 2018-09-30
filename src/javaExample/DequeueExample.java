package javaExample;

import java.util.LinkedList;

public class DequeueExample {

    public static void main(String args[]){
        LinkedList<String> list = new LinkedList<String>();
        list.offer("manas");
        list.offer("vivek");
        list.offer("manali");
        list.offer("samant");
        list.offer("abc");
        System.out.println(list.remove());
        System.out.println(list.remove());

    }
}
