package com.mylinkedlist;

import java.util.LinkedList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Leha");
        myLinkedList.add("Gena");
        myLinkedList.add("Artur");
        myLinkedList.sort();
        System.out.println(myLinkedList.get(0));
        myLinkedList.remove(2);
        System.out.println(myLinkedList.toString());

        List<String> list = new LinkedList<>();
        list.add("Dasha");
        list.add("Vita");
        list.add("Lena");
        MyLinkedList<String> myLinkedList2 = new MyLinkedList<>(list);
        System.out.println(myLinkedList2.toString());
        myLinkedList.addAll(list);
        myLinkedList.sort();
        System.out.println(myLinkedList.toString());

        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Dub");
        myArrayList.add("Lipa");
        myArrayList.add(0,"Beresa");
        System.out.println(myArrayList.toString());
        LinkedList<String> col2 = new LinkedList<>();
        col2.add("Romashka");
        col2.add("Vasilek");
        col2.add("Rosa");
        myArrayList.addAll(col2);
        System.out.println(myArrayList.toString());
        myArrayList.sort();
        System.out.println(myArrayList.toString());
        System.out.println(myArrayList.get(4));
        System.out.println(myArrayList.remove(4) + " was deleted");
        System.out.println(myArrayList.toString());
    }
}