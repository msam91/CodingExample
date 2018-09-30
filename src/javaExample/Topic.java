package javaExample;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Subject {

    List<Observer>obs;
    
    public Topic(){
        obs = new ArrayList<>();
    }
    @Override
    public void register(Observer o) {
        // TODO Auto-generated method stub
        if(!obs.contains(o)){
            obs.add(o);
        }
        
    }

    @Override
    public void unregister(Observer o) {
        // TODO Auto-generated method stub
        obs.remove(o);
    }

    @Override
    public void notifyObserver(String msg) {
        // TODO Auto-generated method stub
        for(Observer o : obs){
            o.update(msg);
        }
        
    }
    
    public void postMessage(String message){
        notifyObserver(message);
    }

}
