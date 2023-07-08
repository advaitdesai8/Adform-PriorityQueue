package com.advait.priorityqueue;

import java.util.*;

public class PriorityQueue<T> {

    private static final LinkedList[] arr = new LinkedList[10];

    /**
     This approach uses LinkedList to pop the first result faster
      */

    public String take() {
        LinkedList<String> linkedList = new LinkedList<>();
        int index = -1;

        for (int i = 9; i>= 0; i--) {
            if (arr[i] != null && arr[i].size() != 0) {
                linkedList = arr[i];
                index = i;
                break;
            }
        }
        String result =  linkedList.pollFirst();
        if (index != -1) {
            arr[index] = linkedList;
            return result;
        } else
            return null;
    }

    public void offer(String value, int priority) {
        LinkedList<String> linkedList = arr[priority] == null ? new LinkedList<>() : arr[priority];
        linkedList.add(value);
        arr[priority] = linkedList;
    }

    public static void main(String args[]) {
        PriorityQueue<String> pq = new PriorityQueue<>();

       // pq.offer("Advait", 9);
        pq.offer("Adform", 0);
        pq.offer("World", 1);
        pq.offer("Welcome", 0);
        pq.offer("to", 1);
        pq.offer("Here", 2);
        pq.offer("!", 1);

        System.out.println(pq.take()); //Prints "Here"
        System.out.println(pq.take()); //Prints "World"
        System.out.println(pq.take()); //Prints "to"
        System.out.println(pq.take()); //Prints "!"
        System.out.println(pq.take()); //Prints "Adform"
        System.out.println(pq.take()); //Prints "Welcome"
    }

}
