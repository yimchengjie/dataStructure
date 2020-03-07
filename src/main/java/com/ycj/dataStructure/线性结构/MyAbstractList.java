package com.ycj.dataStructure.线性结构;

/**
 * AbstractList
 */
public abstract class MyAbstractList<E> implements MyList<E> {

    protected int size = EMPTY_SIZE;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == EMPTY_SIZE;
    }

    @Override
    public boolean contains(E o) {
        return indexOf(o) != ELEMENT_NOT_FOUND;
    }

    @Override
    public boolean add(E element) {
        add(size, element);
        return true;
    }

    protected void throwIndexOutOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index越界:" + "index=" + index + "; size=" + size() + ";");
    }

    // O(1)
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throwIndexOutOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throwIndexOutOfBounds(index);
        }
    }

}