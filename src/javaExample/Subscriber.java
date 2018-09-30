package javaExample;

public class Subscriber implements Observer {

    private String name;
    
    public Subscriber(String name){
        this.name=name;
    }
    
    @Override
    public void update(String msg){
        System.out.println(this.name+" received "+msg);
    }

}
