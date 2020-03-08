package com.ycj.dataStructure.线性结构;


/**
 * MyStack
 */
public class MyStack<E> {

    private MyList<E> list = new MyArrayList<>();

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public E top() {
        return list.get(list.size() - 1);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void clear(){
        list.clear();
    }

    @Override
    public String toString(){
        return list.toString();
    }

}