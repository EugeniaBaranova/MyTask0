package com.company.Collections;

import java.util.*;

//Написать метод для конвертации массива строк/чисел в список

public class Task {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        Object[] newArray = {2, 4, "fgfh",5,5,6,7,7,"fdcgd"};
        System.out.println(Task.convertArrayToList(newArray));

        List<Integer> myArrayList = new ArrayList<>();
        myArrayList.add(2);
        myArrayList.add(5);
        try {
            System.out.println("Enter next number");
            myArrayList.add(scanner.nextInt());
        } catch(InputMismatchException | NullPointerException e) {
            System.out.println("Incorrect format");
        }
        myArrayList.indexOf(2);
        System.out.println(myArrayList.contains(4));
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.isEmpty());
        System.out.println(myArrayList.size());

        List<Integer> myArrayList2 = new ArrayList<>();
        myArrayList2.add(1);
        myArrayList2.add(3);
        myArrayList2.addAll(myArrayList);
        System.out.println(myArrayList2);
        System.out.println();






        LinkedList<String> myLinkedList = new LinkedList<>();
        myLinkedList.add("Hi");
        myLinkedList.add("Buy");
        System.out.println(myLinkedList);
        myLinkedList.addFirst("Hola");
        myLinkedList.addLast("Adios");
        System.out.println(myLinkedList);
        Iterator<String> stringIterator= myLinkedList.iterator();
        while (stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }
        System.out.println();





        HashSet<Integer> myHashSet = new HashSet<>();
        myHashSet.add(2);
        myHashSet.add(1);
        System.out.println(myHashSet);
        try {
            int sizeBefore = myHashSet.size();
            System.out.println("Enter new number");
            int nextInt = scanner.nextInt();
            myHashSet.add(nextInt);
            int sizeAfter = myHashSet.size();
            while(sizeAfter == sizeBefore) {
                System.out.println("This number is already in HashSet" + myHashSet + ". Try again.");
                nextInt = scanner.nextInt();
                myHashSet.add(nextInt);
                sizeAfter = myHashSet.size();
            }
        } catch(InputMismatchException e) {
            System.out.println("Incorrect format");
        }
        System.out.println(myHashSet);
        Iterator iterator1 = myHashSet.iterator();
        while(iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        for (Integer i: myHashSet) {
            System.out.println(i);
        }
        System.out.println();




        HashMap<String, Integer> myHashMap = new HashMap<>();
        myHashMap.put("I", 5);
        System.out.println(myHashMap);
        System.out.println(myHashMap.get("I"));







    }

    public static ArrayList convertArrayToList(Object[] array) {
        ArrayList list = new ArrayList();
        for (Object o: array) {
            list.add(o);
        }
        return list;
    }


}
