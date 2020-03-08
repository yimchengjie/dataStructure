package com.ycj.dataStructure.线性结构;

/**
 * MyLinkedList
 */
public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;

    public MyLinkedList() {
    }

    @Override
    public void clear() {
        size = EMPTY_SIZE;
        firstNode = null;
        lastNode = null;
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
        if (index==size) {
            Node<E> insert=new Node<>(element, lastNode, null);
            if (lastNode==null) {  // 整个链表的第一个元素
                firstNode = insert;
                lastNode = insert;
            }else{
                insert.pre.next=insert;
            }
            lastNode = insert;
        }else{
            Node<E> node = indexNode(index);
            Node<E> insert=new Node<>(element,node.pre,node);
            node.pre=insert;
            // index=0
            if (insert.pre==null) {
                firstNode=insert;
            }else{
                insert.pre.next=insert;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> removedNode = indexNode(index);
        E removed = removedNode.element;
        if (removedNode.pre==null) {  // index=0
            firstNode=removedNode.next;
        }else{
            removedNode.pre.next=removedNode.next;
        }
        if (removedNode.next==null) {  // index=size-1
            lastNode=removedNode.pre;
        }else{
            removedNode.next.pre=removedNode.pre;
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
        if (index < (size >> 1)) {
            Node<E> node = firstNode;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }else{
            Node<E> node = lastNode;
            for (int i = size-1; i > index; i--) {
                node = node.pre;
            }
            return node;
        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> pre;
        public Node(E element, Node<E> pre, Node<E> next) {
            this.element = element;
            this.pre = pre;
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