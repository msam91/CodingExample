package Apple;

import java.util.Iterator;

public class PeekIterator implements Iterator<Integer> {

    public Iterator<Integer> iterator;
    public boolean isPeekCalled = false;
    public Integer element;

    public PeekIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {

        return isPeekCalled || iterator.hasNext();
    }

    @Override
    public Integer next() {
        if (!isPeekCalled) {
            return iterator.next();
        }
        isPeekCalled = false;
        int result = element;
        element = null;

        return result;

    }

    public Integer peek() {
        if (!isPeekCalled) {
            isPeekCalled = true;
            element = iterator.next();
        }

        return element;
    }

}
