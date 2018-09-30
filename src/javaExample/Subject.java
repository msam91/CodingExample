package javaExample;

public interface Subject {
    
    public void notifyObserver(String msg);

    void unregister(Observer o);

    void register(Observer o);

    public void postMessage(String string);
}
