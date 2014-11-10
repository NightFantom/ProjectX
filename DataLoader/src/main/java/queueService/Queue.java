package queueService;

import java.util.LinkedList;

/**
 * Created by Виктор on 07.11.2014.
 */
public class Queue<T>{
    private LinkedList<T> list = new LinkedList<T>();
    private boolean blockAdd = false;

    public boolean isBlockAdd() {
        return blockAdd;
    }

    public void setBlockAdd(boolean blockAdd) {
        this.blockAdd = blockAdd;
    }

    public synchronized void add(T v){
        if(!blockAdd) {
            list.addLast(v);
        }
    }

    public T poll(){
        return list.poll();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    public boolean contains(Object object){
        return list.contains(object);
    }

}
