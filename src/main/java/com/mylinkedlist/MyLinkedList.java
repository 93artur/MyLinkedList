package com.mylinkedlist;

import java.util.Collection;

public class MyLinkedList<E extends Comparable> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
    }

    public MyLinkedList(Collection<? extends E> collection){
        addAll(collection);
    }

    private class Node<E> {
        Node<E> prev;
        Node<E> next;
        E item;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private void linkLastNode(E element) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public void add(E item) {
        linkLastNode(item);
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (collection.size() == 0) {
            return false;
        } else {
            for (Object o : collection) {
                E element = (E) o;
                linkLastNode(element);
            }
            return true;
        }
    }

    public E get(int index) {
        return (E) node(index).item;
    }

    public E remove(int index) {
        if (index > size - 1){
            throw new IndexOutOfBoundsException("Size: " + size + "; Index: " + index);
        }
        Node forRemove = node(index);
        if(forRemove == first){
            Node next = forRemove.next;
            next.prev = null;
            first = next;
            size--;
        } else if (forRemove == last){
            Node pre = forRemove.prev;
            pre.next = null;
            last = pre;
            size--;
        } else {
            Node pre = forRemove.prev;
            Node next = forRemove.next;
            pre.next = next;
            next.prev = pre;
            size--;
        }
        return (E) forRemove.item;
    }

    private Node<E> node(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Size: " + size + "; Index: " + index);
        } else {
            Node node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
    }

    public void sort(){
        boolean isSorted = false;
        Node nodeFirst = first;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i <= size - 2; i++){
                Node nodeNext = nodeFirst.next;
                E item1 = (E)nodeFirst.item;
                E item2 = (E)nodeNext.item;
                if(item1.compareTo(item2) > 0){
                    nodeFirst.item = item2;
                    nodeNext.item = item1;
                    isSorted = false;
                }
                nodeFirst = nodeNext;
            }
            nodeFirst = first;
        }
    }

    public int size() {
        return this.size;
    }

   @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = first;
        stringBuilder.append(first.item + " ");
        for (int i = 0; i < size - 1; i++){
            node = node.next;
            stringBuilder.append(node.item + " ");
        }
        return stringBuilder.toString();
    }
}
