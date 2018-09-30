package DesignPatterns;

import DesignPatterns.ObserverDP.Observable;
import DesignPatterns.ObserverDP.ObserverTwo;
import DesignPatterns.ObserverDP.ObseverOne;

public class ObserverExample {

    public static void main(String args[]){
        ObserverDP dp = new ObserverDP();
        Observable ob = dp.new Observable();
        ObseverOne o1 = dp.new ObseverOne();
        ObserverTwo o2 =dp.new ObserverTwo();
        
        ob.registerObservers(o1);
        ob.registerObservers(o2);
        
        ob.changeData(5);
        ob.changeData(6);
        
        ob.deRegisterObservers(o2);
        
        ob.changeData(7);
        
    }
}
