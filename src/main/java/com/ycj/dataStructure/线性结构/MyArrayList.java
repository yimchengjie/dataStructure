package com.ycj.dataStructure.线性结构;

/**
 * MyArrayList
 */
public class MyArrayList<E> extends MyAbstractList<E>{

    private E[] elements;

    private static final int DEFAULT_CAPATICU = 16;    // 默认容量

    @SuppressWarnings("unchecked")
    public MyArrayList(int capaticy) {
        if (capaticy <= DEFAULT_CAPATICU) {
            this.elements = (E[]) new Object[DEFAULT_CAPATICU];
        } else {
            this.elements = (E[]) new Object[capaticy];
        }
    }

    public MyArrayList() {
        this(DEFAULT_CAPATICU);
    }

    
    /**
     * 判断是否需要扩容
     * @param capacity 添加元素需要的需要的容量
     * O(1)  **这里O(n)出现的次数属于个例, 可以平摊到每一次操作
     */
    @SuppressWarnings("unchecked")
    protected void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity < capacity) {
            System.out.println("---------扩容操作---------");
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            E[] newElements = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = (E[]) newElements;
        }
        return;
    }

    
    /**
     * 添加操作
     * @param index 添加元素的位置
     * O(n)
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 移除操作
     * @param index 移除元素的位置
     * O(n)
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        E removed = (E) elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[size - 1] = null;
        size--;
        return removed;
    }

    /**
     * 清空操作
     * O(n)
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = EMPTY_SIZE;
    }

    /**
     * 获得index位置的元素
     * @param index
     * O(1)
     */
    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }

    // O(n)
    @Override
    public int indexOf(E e) {
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    // O(1)
    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        final E old = (E) elements[index];
        elements[index] = element;
        return old;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append("size=").append(size).append(",MyArrayList [");
        for (int i = 0; i < size; i++) {
            str.append(elements[i]);
            if (i != size - 1) {
                str.append(",");
            }
        }
        str.append("]");
        return str.toString();
    }

}
