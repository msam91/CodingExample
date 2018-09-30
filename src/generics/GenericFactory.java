package generics;

import LinkList.Node;

public class GenericFactory<T> {

    Class theClass = null;
    
    public GenericFactory(Class theClass){
        this.theClass = theClass;
    }
    
    public T getInstance() throws InstantiationException, IllegalAccessException{
        return (T) this.theClass.newInstance();
    }
}

class Example<T>{
    
    public void createInstanc() throws InstantiationException, IllegalAccessException{
    GenericFactory<Node> factory = new GenericFactory<Node>(Node.class);
    Node n = factory.getInstance();
    }
}
