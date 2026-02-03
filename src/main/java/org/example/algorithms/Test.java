package org.example.algorithms;

import java.util.*;

public class Test {

    public static void main(String[] args) {
//        CustomLinkedList<Integer> list = new CustomLinkedList<>();
//        list.add(23);
//        list.add(21);
//
//        System.out.println(list);
//
//        list.add(45);
//        list.add(46);
//        System.out.println(list);
//
//        list.remove(23);
//        System.out.println(list);
//        list.remove(56);
//        System.out.println(list);
//
//        System.out.println(list.size);
//
        List<Integer> l1 = Arrays.asList(23,45,12,45,65);
//
//        list.addAll(2, l1 );
//        System.out.println(list);
//
//        list.addAll(l1);
//        System.out.println(list);

        CustomLinkedList<Integer> list2  = new CustomLinkedList<>(l1);

        System.out.println(list2);

        System.out.println(list2.getFirst());
        System.out.println(list2.getLast());

        list2.add(2,154);
        System.out.println(list2);

    }
}
