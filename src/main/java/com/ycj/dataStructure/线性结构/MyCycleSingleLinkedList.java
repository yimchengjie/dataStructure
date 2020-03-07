package com.ycj.dataStructure.线性结构;

/**
 * MyLinkedList
 */
public class MyCycleSingleLinkedList<E> extends MyAbstractList<E> {

    private Node<E> firstNode;

    public MyCycleSingleLinkedList() {
        // firstNode是虚拟头结点
        firstNode = null;
    }

    @Override
    public void clear() {
        size = EMPTY_SIZE;
        firstNode = null;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = indexNode(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public E get(int index) {
        return indexNode(index).element;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            Node<E> newFirst= new Node<>(element, firstNode);
            Node<E> lastNode = (size == 0) ? newFirst : indexNode(size - 1);
            lastNode.next=newFirst;
            firstNode = newFirst;
        }else{
            Node<E> preNode = indexNode(index - 1);
            preNode.next = new Node<>(element, preNode.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> removedNode = indexNode(index);
        E removed = removedNode.element;
        if (index==0) {
            if (size==1) {
                firstNode=null;
            }else{
                Node<E> lastNode=indexNode(size-1);
                firstNode=firstNode.next;
                lastNode.next=firstNode;
            }
        }else{
            Node<E> pre =  indexNode(index - 1);
            pre.next = pre.next.next;
        }
        size--;
        return removed;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = firstNode;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private Node<E> indexNode(int index) {
        rangeCheck(index);
        Node<E> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        Node<E> node = firstNode;
        str.append("size=").append(size).append(",MyLinkedList [");
        for (int i = 0; i < size; i++) {
            str.append(node.element);
            if (i != size - 1) {
                str.append(",");
            }
            node = node.next;
        }
        str.append("]");
        return str.toString();
    }
}