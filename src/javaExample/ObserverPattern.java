package javaExample;

public class ObserverPattern {

    public static void main(String args[]){
        
        Subject myTopic = new Topic();
        Observer s1 = new Subscriber("sub1");
        Observer s2 = new Subscriber("sub2");
        
        myTopic.register(s1);
        myTopic.register(s2);
        
        myTopic.postMessage("hello");
        myTopic.postMessage("hi");
    }
}
