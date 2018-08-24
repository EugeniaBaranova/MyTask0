package com.company.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Task {

    public static void main (String[] args) {

        ArrayList<Integer> myArrayList = new ArrayList<>();
        myArrayList.add(2);
        myArrayList.add(5);
        myArrayList.indexOf(2);
        System.out.println(myArrayList.contains(4));
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.isEmpty());
        System.out.println(myArrayList.size());

        ArrayList<Integer> myArrayList2 = new ArrayList<Integer>();
        myArrayList2.add(1);
        myArrayList2.add(3);
        myArrayList2.addAll(myArrayList);
        System.out.println(myArrayList2);


        LinkedList<String> myLinkedList = new LinkedList<String>();
        myLinkedList.add("Hi");
        myLinkedList.add("Buy");
        System.out.println(myLinkedList);
        myLinkedList.addFirst("Hola");
        myLinkedList.addLast("Adios");
        System.out.println(myLinkedList);
        Iterator<String> stringIterator= myLinkedList.iterator();
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());




    }


}
