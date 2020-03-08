package com.ycj.dataStructure.线性结构;

/**
 * MyDeque
 * Doube ended queue
 */
public class MyDeque<E> {

    private MyList<E> list = new MyLinkedList<>(); 

    public int size(){
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == MyList.EMPTY_SIZE;
    }

    public void enQueueRear(E element) {
        list.add(element);
    }

    public E deQueueFront(){
        return list.remove(0);
    }

    public void enQueueFront(E element) {
        list.add(0,element);
    }

    public E deQueueRear(){
        return list.remove(list.size()-1);
    }

    public E front(){
        return list.get(0);
    }

    public E rear(){
        return list.get(list.size()-1);
    }

    public void clear(){
        list.clear();
    }

    @Override
    public String toString(){
        return list.toString();
    }
}