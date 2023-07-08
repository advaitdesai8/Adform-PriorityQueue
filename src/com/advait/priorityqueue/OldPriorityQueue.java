package com.advait.priorityqueue;

import java.util.*;

public class OldPriorityQueue<T> {
    private static TreeMap<Integer, LinkedList<String>> map = new TreeMap<>();

    public String take() {
        if (map.size() > 0) {
            LinkedList<String> linkedList = map.lastEntry().getValue();
            if (linkedList.size() == 1)
                map.pollLastEntry();
            return linkedList.pollFirst();
        } else {
            return null;
        }
    }

    public void offer(String value, int priority) {
        LinkedList<String> linkedList = new LinkedList<>();
        if (map.containsKey(priority)) {
            linkedList = map.get(priority);
        }
        linkedList.add(value);
        map.put(priority, linkedList);

    }

    public static void main(String args[]) {
        OldPriorityQueue<String> pq = new OldPriorityQueue<>();
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
