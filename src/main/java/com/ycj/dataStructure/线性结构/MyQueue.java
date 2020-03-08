package com.ycj.dataStructure.线性结构;

/**
 * MyQueue
 */
public class MyQueue<E> {

    private MyList<E> list = new MyLinkedList<>(); 

    public void clear(){
        list.clear();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == MyList.EMPTY_SIZE;
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public E deQueue(){
        return list.remove(0);
    }

    public E front(){
        return list.get(0);
    }

    @Override
    public String toString(){
        return list.toString();
    }
}