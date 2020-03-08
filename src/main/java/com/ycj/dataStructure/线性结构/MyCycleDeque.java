package com.ycj.dataStructure.线性结构;

/**
 * MyCycleDeque
 */
public class MyCycleDeque<E> {

    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int front;

    @SuppressWarnings("unchecked")
    public MyCycleDeque() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == MyList.EMPTY_SIZE;
    }

    // 尾部入队
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    // 头部出队
    public E deQueueFront() {
        E removed = front();
        elements[front] = null;
        front = index(1);
        size--;
        return removed;
    }

    // 头部入队
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front=index(-1);
        elements[front] = element;
        size++;
    }

    // 尾部出队
    public E deQueueRear() {
        int rear=index(size-1);
        E removed=elements[rear];
        elements[rear]=null;
        size--;
        return removed;
    }

    public E front() {
        return elements[front];
    }

    public E rear() {
        return elements[index(size - 1)];
    }

    // 把相对于front的第几个位置映射为真正数组中的位置 front->0
    private int index(int index) {
        index=(front + index + elements.length);
        while (index >= elements.length){
            index-=elements.length;
        }
        return index;
    }

    public void clear(){
        size=0;
        for (int i = 0; i < size; i++) {
            elements[index(i)]=null;
        }
        front=0;
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
}