package com.ycj.dataStructure.线性结构;

/**
 * MyLinkedList
 */
public class MySingleLinkedList<E> extends MyAbstractList<E> {

    private Node<E> firstNode;

    public MySingleLinkedList() {
        // firstNode是虚拟头结点
        firstNode = new Node<E>(null, null);
    }

    @Override
    public void clear() {
        size = EMPTY_SIZE;
        firstNode.next = null;
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
        Node<E> preNode = index == 0 ? firstNode : indexNode(index - 1);
        preNode.next = new Node<>(element, preNode.next);
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> removedNode = indexNode(index);
        E removed = removedNode.element;
        Node<E> pre = index == 0 ? firstNode : indexNode(index - 1);
        pre.next = pre.next.next;
        size--;
        return removed;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = firstNode.next;
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
        Node<E> node = firstNode.next;
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
        Node<E> node = firstNode.next;
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