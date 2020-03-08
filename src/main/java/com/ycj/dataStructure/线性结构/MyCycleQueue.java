package com.ycj.dataStructure.线性结构;

/**
 * MyCycleQueue
 */
public class MyCycleQueue<E> {

    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int front;

    @SuppressWarnings("unchecked")
    public MyCycleQueue() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear(){
        front=0;
        size=0;
        for (int i = 0; i < elements.length; i++) {
            elements[i]=null;
        }
    }

    public void enQueue(final E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    protected void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity < capacity) {
            System.out.println("---------扩容操作---------");
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            E[] newElements = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[index(i)];
            }
            elements = (E[]) newElements;
            front = 0;
        }
        return;
    }

    public E deQueue() {
        E removed = front();
        elements[front] = null;
        front = index(1);
        size--;
        return removed;
    }

    public E front() {
        return elements[front];
    }

    private int index(int index) {
        return (front + index) % elements.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=" + size).append(", front=" + front).append(", capacity=" + elements.length)
                .append(", CycleQueue[");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }

}