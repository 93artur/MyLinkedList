package com.mylinkedlist;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E extends Object & Comparable<E>> {
    private E[] elements;
    private int size = 0;

    public MyArrayList() {
        elements = (E[]) new Object[10];
    }

    public MyArrayList(Collection<? extends E> collection) {
        elements = (E[]) collection.toArray();
    }

    public boolean add(E element) {
        checkFreePlace(1);
        elements[size] = element;
        size++;
        return true;
    }

    public boolean add(int index, E element) {
        checkFreePlace(1);
        E[] tempArray = Arrays.copyOfRange(elements, index, size);
        int tempIndex = index + 1;
        for (int i = 0; i < tempArray.length; i++) {
            elements[tempIndex] = tempArray[i];
            tempIndex++;
        }
        elements[index] = element;
        size++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (collection.size() == 0) {
            return false;
        } else {
            checkFreePlace(collection.size());
            int tempIndex = size;
            for (Object o : collection) {
                E element = (E) o;
                elements[tempIndex] = element;
                tempIndex++;
            }
            size = tempIndex;
            return true;
        }
    }

    private void checkFreePlace(int necessaryCells) {
        int currentFreeCells = elements.length - size;
        boolean isEnough = false;
        while (!isEnough) {
            isEnough = true;
            if (currentFreeCells < necessaryCells) {
                elements = Arrays.copyOf(elements, (elements.length * 3) / 2 + 1);
                isEnough = false;
            }
        }
    }

    public void sort() {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < size - 1; i++) {
                E tempElement = elements[i];
                E tempElement2 = elements[i + 1];
                if (tempElement.compareTo(tempElement2) > 0) {
                    elements[i] = tempElement2;
                    elements[i + 1] = tempElement;
                    isSorted = false;
                }
            }
        }
    }

    public E get(int index) {
        if (index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Size of MyArrayList is " + size);
        } else {
            return elements[index];
        }
    }

    public E remove(int index) {
        if (index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Size of MyArrayList is " + size);
        } else {
            E element = elements[index];
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            return element;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++){
            stringBuilder.append(elements[i] + "; ");
        }
        return stringBuilder.toString();
    }
}
