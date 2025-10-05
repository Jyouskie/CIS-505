package Module_4.BowlingShopApp;

import java.util.LinkedList;

public class GenericQueue<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T item) {
        list.addFirst(item);
    }

    public T dequeue() {
        return list.removeFirst();
    }

    public int size() {
        return list.size();
    }
}    

