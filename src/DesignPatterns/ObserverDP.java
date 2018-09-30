package DesignPatterns;

import java.util.ArrayList;
import java.util.List;


public class ObserverDP {

    public interface Subject {

        public void registerObservers(Observer o);

        public void deRegisterObservers(Observer o);

        public void notifyObservers();

    }

    public interface Observer {
        public void update(int data);
    }

    public class Observable implements Subject {

        public List<Observer> observerList;
        int data = 2;

        public Observable() {
            observerList = new ArrayList<ObserverDP.Observer>();
        }

        @Override
        public void registerObservers(Observer o) {
            // TODO Auto-generated method stub
            observerList.add(o);
        }

        @Override
        public void deRegisterObservers(Observer o) {
            // TODO Auto-generated method stub
            observerList.remove(observerList.indexOf(o));
        }

        @Override
        public void notifyObservers() {
            // TODO Auto-generated method stub
            for (Observer o : observerList) {
                o.update(data);
            }

        }

        public void changeData(int data) {
            this.data = data;
            notifyObservers();
        }

    }

    public class ObseverOne implements Observer {

        @Override
        public void update(int data) {
            System.out.println("observer1-->"+data);

        }

    }

    public class ObserverTwo implements Observer {

        @Override
        public void update(int data) {
            System.out.println("observer2-->"+data);

        }

    }

}
